package org.bouncycastle.crypto.agreement.jpake;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.math.BigInteger;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class JPAKERound2Payload {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BigInteger f525117a;
    private final BigInteger[] knowledgeProofForX2s;
    private final String participantId;

    public JPAKERound2Payload(String r100, BigInteger r101, BigInteger[] r102) {
        JPAKEUtil.validateNotNull(r100, "participantId");
        JPAKEUtil.validateNotNull(r101, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        JPAKEUtil.validateNotNull(r102, "knowledgeProofForX2s");
        this.participantId = r100;
        this.f525117a = r101;
        this.knowledgeProofForX2s = Arrays.copyOf(r102, r102.length);
    }

    public BigInteger getA() {
        return this.f525117a;
    }

    public BigInteger[] getKnowledgeProofForX2s() {
        BigInteger[] r100 = this.knowledgeProofForX2s;
        return Arrays.copyOf(r100, r100.length);
    }

    public String getParticipantId() {
        return this.participantId;
    }
}
