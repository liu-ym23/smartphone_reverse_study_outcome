package org.bouncycastle.crypto.agreement.jpake;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public class JPAKERound3Payload {
    private final BigInteger macTag;
    private final String participantId;

    public JPAKERound3Payload(String r100, BigInteger r101) {
        this.participantId = r100;
        this.macTag = r101;
    }

    public BigInteger getMacTag() {
        return this.macTag;
    }

    public String getParticipantId() {
        return this.participantId;
    }
}
