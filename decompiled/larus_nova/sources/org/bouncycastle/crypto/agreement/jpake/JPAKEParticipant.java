package org.bouncycastle.crypto.agreement.jpake;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class JPAKEParticipant {
    public static final int STATE_INITIALIZED = 0;
    public static final int STATE_KEY_CALCULATED = 50;
    public static final int STATE_ROUND_1_CREATED = 10;
    public static final int STATE_ROUND_1_VALIDATED = 20;
    public static final int STATE_ROUND_2_CREATED = 30;
    public static final int STATE_ROUND_2_VALIDATED = 40;
    public static final int STATE_ROUND_3_CREATED = 60;
    public static final int STATE_ROUND_3_VALIDATED = 70;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BigInteger f525102b;
    private final Digest digest;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final BigInteger f525103g;

    /* JADX INFO: renamed from: gx1, reason: collision with root package name */
    private BigInteger f525104gx1;

    /* JADX INFO: renamed from: gx2, reason: collision with root package name */
    private BigInteger f525105gx2;

    /* JADX INFO: renamed from: gx3, reason: collision with root package name */
    private BigInteger f525106gx3;

    /* JADX INFO: renamed from: gx4, reason: collision with root package name */
    private BigInteger f525107gx4;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final BigInteger f525108p;
    private final String participantId;
    private String partnerParticipantId;
    private char[] password;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final BigInteger f525109q;
    private final SecureRandom random;
    private int state;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    private BigInteger f525110x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    private BigInteger f525111x2;

    public JPAKEParticipant(String r100, char[] r101) {
        this(r100, r101, JPAKEPrimeOrderGroups.NIST_3072);
    }

    public JPAKEParticipant(String r100, char[] r101, JPAKEPrimeOrderGroup r102) {
        this(r100, r101, r102, new SHA256Digest(), CryptoServicesRegistrar.getSecureRandom());
    }

    public JPAKEParticipant(String r100, char[] r101, JPAKEPrimeOrderGroup r102, Digest r103, SecureRandom r104) {
        JPAKEUtil.validateNotNull(r100, "participantId");
        JPAKEUtil.validateNotNull(r101, "password");
        JPAKEUtil.validateNotNull(r102, "p");
        JPAKEUtil.validateNotNull(r103, "digest");
        JPAKEUtil.validateNotNull(r104, "random");
        if (r101.length == 0) goto L7;
        this.participantId = r100;
        this.password = Arrays.copyOf(r101, r101.length);
        this.f525108p = r102.getP();
        this.f525109q = r102.getQ();
        this.f525103g = r102.getG();
        this.digest = r103;
        this.random = r104;
        this.state = 0;
        return;
    L7:
        throw new IllegalArgumentException("Password must not be empty.");
    }

    public BigInteger calculateKeyingMaterial() {
        int r100 = this.state;
        if (r100 >= 50) goto L11;
        if (r100 < 40) goto L9;
        BigInteger r101 = JPAKEUtil.calculateS(this.password);
        Arrays.fill(this.password, 0);
        this.password = null;
        BigInteger r102 = JPAKEUtil.calculateKeyingMaterial(this.f525108p, this.f525109q, this.f525107gx4, this.f525111x2, r101, this.f525102b);
        this.f525110x1 = null;
        this.f525111x2 = null;
        this.f525102b = null;
        this.state = 50;
        return r102;
    L9:
        throw new IllegalStateException("Round2 payload must be validated prior to creating key for " + this.participantId);
    L11:
        throw new IllegalStateException("Key already calculated for " + this.participantId);
    }

    public JPAKERound1Payload createRound1PayloadToSend() {
        if (this.state >= 10) goto L7;
        this.f525110x1 = JPAKEUtil.generateX1(this.f525109q, this.random);
        this.f525111x2 = JPAKEUtil.generateX2(this.f525109q, this.random);
        this.f525104gx1 = JPAKEUtil.calculateGx(this.f525108p, this.f525103g, this.f525110x1);
        this.f525105gx2 = JPAKEUtil.calculateGx(this.f525108p, this.f525103g, this.f525111x2);
        BigInteger[] r110 = JPAKEUtil.calculateZeroKnowledgeProof(this.f525108p, this.f525109q, this.f525103g, this.f525104gx1, this.f525110x1, this.participantId, this.digest, this.random);
        BigInteger[] r111 = JPAKEUtil.calculateZeroKnowledgeProof(this.f525108p, this.f525109q, this.f525103g, this.f525105gx2, this.f525111x2, this.participantId, this.digest, this.random);
        this.state = 10;
        return new JPAKERound1Payload(this.participantId, this.f525104gx1, this.f525105gx2, r110, r111);
    L7:
        throw new IllegalStateException("Round1 payload already created for " + this.participantId);
    }

    public JPAKERound2Payload createRound2PayloadToSend() {
        int r100 = this.state;
        if (r100 >= 30) goto L11;
        if (r100 < 20) goto L9;
        BigInteger r101 = JPAKEUtil.calculateGA(this.f525108p, this.f525104gx1, this.f525106gx3, this.f525107gx4);
        BigInteger r102 = JPAKEUtil.calculateX2s(this.f525109q, this.f525111x2, JPAKEUtil.calculateS(this.password));
        BigInteger r103 = JPAKEUtil.calculateA(this.f525108p, this.f525109q, r101, r102);
        BigInteger[] r104 = JPAKEUtil.calculateZeroKnowledgeProof(this.f525108p, this.f525109q, r101, r103, r102, this.participantId, this.digest, this.random);
        this.state = 30;
        return new JPAKERound2Payload(this.participantId, r103, r104);
    L9:
        throw new IllegalStateException("Round1 payload must be validated prior to creating Round2 payload for " + this.participantId);
    L11:
        throw new IllegalStateException("Round2 payload already created for " + this.participantId);
    }

    public JPAKERound3Payload createRound3PayloadToSend(BigInteger r110) {
        int r100 = this.state;
        if (r100 >= 60) goto L11;
        if (r100 < 50) goto L9;
        BigInteger r111 = JPAKEUtil.calculateMacTag(this.participantId, this.partnerParticipantId, this.f525104gx1, this.f525105gx2, this.f525106gx3, this.f525107gx4, r110, this.digest);
        this.state = 60;
        return new JPAKERound3Payload(this.participantId, r111);
    L9:
        throw new IllegalStateException("Keying material must be calculated prior to creating Round3 payload for " + this.participantId);
    L11:
        throw new IllegalStateException("Round3 payload already created for " + this.participantId);
    }

    public int getState() {
        return this.state;
    }

    public void validateRound1PayloadReceived(JPAKERound1Payload r110) throws CryptoException {
        if (this.state >= 20) goto L7;
        this.partnerParticipantId = r110.getParticipantId();
        this.f525106gx3 = r110.getGx1();
        this.f525107gx4 = r110.getGx2();
        BigInteger[] r100 = r110.getKnowledgeProofForX1();
        BigInteger[] r111 = r110.getKnowledgeProofForX2();
        JPAKEUtil.validateParticipantIdsDiffer(this.participantId, r110.getParticipantId());
        JPAKEUtil.validateGx4(this.f525107gx4);
        JPAKEUtil.validateZeroKnowledgeProof(this.f525108p, this.f525109q, this.f525103g, this.f525106gx3, r100, r110.getParticipantId(), this.digest);
        JPAKEUtil.validateZeroKnowledgeProof(this.f525108p, this.f525109q, this.f525103g, this.f525107gx4, r111, r110.getParticipantId(), this.digest);
        this.state = 20;
        return;
    L7:
        throw new IllegalStateException("Validation already attempted for round1 payload for" + this.participantId);
    }

    public void validateRound2PayloadReceived(JPAKERound2Payload r110) throws CryptoException {
        int r100 = this.state;
        if (r100 >= 40) goto L11;
        if (r100 < 20) goto L9;
        BigInteger r101 = JPAKEUtil.calculateGA(this.f525108p, this.f525106gx3, this.f525104gx1, this.f525105gx2);
        this.f525102b = r110.getA();
        BigInteger[] r102 = r110.getKnowledgeProofForX2s();
        JPAKEUtil.validateParticipantIdsDiffer(this.participantId, r110.getParticipantId());
        JPAKEUtil.validateParticipantIdsEqual(this.partnerParticipantId, r110.getParticipantId());
        JPAKEUtil.validateGa(r101);
        JPAKEUtil.validateZeroKnowledgeProof(this.f525108p, this.f525109q, r101, this.f525102b, r102, r110.getParticipantId(), this.digest);
        this.state = 40;
        return;
    L9:
        throw new IllegalStateException("Round1 payload must be validated prior to validating Round2 payload for " + this.participantId);
    L11:
        throw new IllegalStateException("Validation already attempted for round2 payload for" + this.participantId);
    }

    public void validateRound3PayloadReceived(JPAKERound3Payload r110, BigInteger r111) throws CryptoException {
        int r100 = this.state;
        if (r100 >= 70) goto L11;
        if (r100 < 50) goto L9;
        JPAKEUtil.validateParticipantIdsDiffer(this.participantId, r110.getParticipantId());
        JPAKEUtil.validateParticipantIdsEqual(this.partnerParticipantId, r110.getParticipantId());
        JPAKEUtil.validateMacTag(this.participantId, this.partnerParticipantId, this.f525104gx1, this.f525105gx2, this.f525106gx3, this.f525107gx4, r111, this.digest, r110.getMacTag());
        this.f525104gx1 = null;
        this.f525105gx2 = null;
        this.f525106gx3 = null;
        this.f525107gx4 = null;
        this.state = 70;
        return;
    L9:
        throw new IllegalStateException("Keying material must be calculated validated prior to validating Round3 payload for " + this.participantId);
    L11:
        throw new IllegalStateException("Validation already attempted for round3 payload for" + this.participantId);
    }
}
