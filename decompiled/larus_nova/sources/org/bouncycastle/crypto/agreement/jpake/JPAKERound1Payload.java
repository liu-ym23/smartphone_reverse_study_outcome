package org.bouncycastle.crypto.agreement.jpake;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class JPAKERound1Payload {

    /* JADX INFO: renamed from: gx1, reason: collision with root package name */
    private final BigInteger f525115gx1;

    /* JADX INFO: renamed from: gx2, reason: collision with root package name */
    private final BigInteger f525116gx2;
    private final BigInteger[] knowledgeProofForX1;
    private final BigInteger[] knowledgeProofForX2;
    private final String participantId;

    public JPAKERound1Payload(String r100, BigInteger r101, BigInteger r102, BigInteger[] r103, BigInteger[] r104) {
        JPAKEUtil.validateNotNull(r100, "participantId");
        JPAKEUtil.validateNotNull(r101, "gx1");
        JPAKEUtil.validateNotNull(r102, "gx2");
        JPAKEUtil.validateNotNull(r103, "knowledgeProofForX1");
        JPAKEUtil.validateNotNull(r104, "knowledgeProofForX2");
        this.participantId = r100;
        this.f525115gx1 = r101;
        this.f525116gx2 = r102;
        this.knowledgeProofForX1 = Arrays.copyOf(r103, r103.length);
        this.knowledgeProofForX2 = Arrays.copyOf(r104, r104.length);
    }

    public BigInteger getGx1() {
        return this.f525115gx1;
    }

    public BigInteger getGx2() {
        return this.f525116gx2;
    }

    public BigInteger[] getKnowledgeProofForX1() {
        BigInteger[] r100 = this.knowledgeProofForX1;
        return Arrays.copyOf(r100, r100.length);
    }

    public BigInteger[] getKnowledgeProofForX2() {
        BigInteger[] r100 = this.knowledgeProofForX2;
        return Arrays.copyOf(r100, r100.length);
    }

    public String getParticipantId() {
        return this.participantId;
    }
}
