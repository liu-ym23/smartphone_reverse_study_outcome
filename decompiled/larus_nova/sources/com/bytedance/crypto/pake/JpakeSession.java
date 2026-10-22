package com.bytedance.crypto.pake;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.agreement.jpake.JPAKEParticipant;
import org.bouncycastle.crypto.agreement.jpake.JPAKERound1Payload;
import org.bouncycastle.crypto.agreement.jpake.JPAKERound2Payload;

/* JADX INFO: loaded from: classes15.dex */
public final class JpakeSession {
    private byte[] confirmKey;
    private byte[] dataKey;
    private boolean keyConfirmed;
    private final int keyLen;
    private final JPAKEParticipant participant;
    private final String participantId;
    private final PakeRole role;
    private boolean round1Received;
    private boolean round1Sent;
    private boolean round2Received;
    private boolean round2Sent;
    private byte[] sharedKey;

    public static final class KeyConfirmMsg {
        public final byte[] hmac;
        public final byte[] salt;

        public KeyConfirmMsg(byte[] r100, byte[] r101) {
            this.salt = r100;
            this.hmac = r101;
        }
    }

    public static final class Round1Msg {
        public final JPAKERound1Payload payload;

        public Round1Msg(JPAKERound1Payload r100) {
            this.payload = r100;
        }
    }

    public static final class Round2Msg {
        public final JPAKERound2Payload payload;

        public Round2Msg(JPAKERound2Payload r100) {
            this.payload = r100;
        }
    }

    private JpakeSession(PakeRole r100, String r101, int r102) {
        if (r101.isEmpty() == true) goto L15;
        this.role = r100;
        if (r100 != PakeRole.ALICE) goto L7;
        String r103 = "alice";
    L8:
        this.participantId = r103;
        if (r102 > 0) goto L12;
        r102 = 32;
    L12:
        this.keyLen = r102;
        this.participant = new JPAKEParticipant(r103, r101.toCharArray());
        return;
    L7:
        r103 = "bob";
        goto L8
    L15:
        throw new IllegalArgumentException("password must not be empty");
    }

    private void ensureSharedKeyAvailable() {
        byte[] r100 = this.sharedKey;
        if (r100 == null) goto L8;
        if (r100.length == 0) goto L8;
        return;
    L8:
        throw new IllegalStateException("shared key not available; call deriveSharedKey() first");
    }

    public static JpakeSession newSession(PakeRole r100, String r101, int r102) {
        return new JpakeSession(r100, r101, r102);
    }

    public synchronized byte[] deriveSharedKey() {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (this.round2Received == false) goto L19;
        byte[] r100 = this.sharedKey;     // Catch: Throwable -> L20
        if (r100 != null) goto L8;
    L24:
        BigInteger r101 = this.participant.calculateKeyingMaterial();     // Catch: Exception -> L15 Throwable -> L20
        MessageDigest r102 = MessageDigest.getInstance("SHA-256");     // Catch: Exception -> L15 Throwable -> L20
        r102.update(r101.toByteArray());     // Catch: Exception -> L15 Throwable -> L20
        byte[] r103 = r102.digest();     // Catch: Exception -> L15 Throwable -> L20
        int r104 = Math.min(this.keyLen, r103.length);     // Catch: Exception -> L15 Throwable -> L20
        byte[] r105 = new byte[r104];     // Catch: Exception -> L15 Throwable -> L20
        this.sharedKey = r105;     // Catch: Exception -> L15 Throwable -> L20
        System.arraycopy(r103, 0, r105, 0, r104);     // Catch: Exception -> L15 Throwable -> L20
        Mac r106 = Mac.getInstance("HmacSHA256");     // Catch: Exception -> L15 Throwable -> L20
        r106.init(new SecretKeySpec(this.sharedKey, "HmacSHA256"));     // Catch: Exception -> L15 Throwable -> L20
        byte[] r107 = r106.doFinal("CONFIRM".getBytes("UTF-8"));     // Catch: Exception -> L15 Throwable -> L20
        Mac r108 = Mac.getInstance("HmacSHA256");     // Catch: Exception -> L15 Throwable -> L20
        r108.init(new SecretKeySpec(this.sharedKey, "HmacSHA256"));     // Catch: Exception -> L15 Throwable -> L20
        byte[] r109 = r108.doFinal("DATA_KEY".getBytes("UTF-8"));     // Catch: Exception -> L15 Throwable -> L20
        this.confirmKey = r107;     // Catch: Exception -> L15 Throwable -> L20
        this.dataKey = r109;     // Catch: Exception -> L15 Throwable -> L20
        byte[] r110 = (byte[]) this.sharedKey.clone();     // Catch: Exception -> L15 Throwable -> L20
        monitor-exit(this);
        return r110;
    L15:
        e = move-exception;
        throw new IllegalStateException("Failed to derive shared key", e);     // Catch: Throwable -> L20
    L8:
        if (r100.length <= 0) goto L24;
        byte[] r111 = (byte[]) r100.clone();     // Catch: Throwable -> L20
        monitor-exit(this);
        return r111;
    L19:
        throw new IllegalStateException("receiveRound2Payload() must be called before deriveSharedKey()");     // Catch: Throwable -> L20
    }

    public synchronized KeyConfirmMsg generateKeyConfirmMsg() {
        monitor-enter(this);
        ensureSharedKeyAvailable();     // Catch: Throwable -> L11
        byte[] r100 = new byte[16];     // Catch: Exception -> L8 Throwable -> L11
        new SecureRandom().nextBytes(r100);     // Catch: Exception -> L8 Throwable -> L11
        Mac r101 = Mac.getInstance("HmacSHA256");     // Catch: Exception -> L8 Throwable -> L11
        r101.init(new SecretKeySpec(this.confirmKey, "HmacSHA256"));     // Catch: Exception -> L8 Throwable -> L11
        KeyConfirmMsg r102 = new KeyConfirmMsg(r100, r101.doFinal(r100));     // Catch: Exception -> L8 Throwable -> L11
        monitor-exit(this);
        return r102;
    L8:
        e = move-exception;
        throw new IllegalStateException("Failed to generate key confirm message", e);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized Round1Msg generateRound1Payload() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.round1Sent == true) goto L9;
        JPAKERound1Payload r100 = this.participant.createRound1PayloadToSend();     // Catch: Throwable -> L10
        this.round1Sent = true;     // Catch: Throwable -> L10
        Round1Msg r101 = new Round1Msg(r100);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r101;
    L9:
        throw new IllegalStateException("Round1 payload already generated");     // Catch: Throwable -> L10
    }

    public synchronized Round2Msg generateRound2Payload() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.round1Received == false) goto L13;
        if (this.round2Sent == true) goto L11;
        JPAKERound2Payload r100 = this.participant.createRound2PayloadToSend();     // Catch: Throwable -> L14
        this.round2Sent = true;     // Catch: Throwable -> L14
        Round2Msg r101 = new Round2Msg(r100);     // Catch: Throwable -> L14
        monitor-exit(this);
        return r101;
    L11:
        throw new IllegalStateException("Round2 payload already generated");     // Catch: Throwable -> L14
    L13:
        throw new IllegalStateException("receiveRound1Payload() must be called before generateRound2Payload()");     // Catch: Throwable -> L14
    }

    public synchronized byte[] getDataKey() {
        monitor-enter(this);
        ensureSharedKeyAvailable();     // Catch: Throwable -> L10
        if (this.keyConfirmed == false) goto L9;
        byte[] r100 = (byte[]) this.dataKey.clone();     // Catch: Throwable -> L10
        monitor-exit(this);
        return r100;
    L9:
        throw new IllegalStateException("data key not confirmed; call verifyKeyConfirmMsg() successfully on this side before getDataKey()");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public PakeRole getRole() {
        return this.role;
    }

    public synchronized boolean isKeyConfirmed() {
        monitor-enter(this);
        boolean r100 = this.keyConfirmed;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void receiveRound1Payload(Round1Msg r100) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.round1Sent == false) goto L16;
        if (this.round1Received == true) goto L14;
        this.participant.validateRound1PayloadReceived(r100.payload);     // Catch: Exception -> L10 Throwable -> L17
        this.round1Received = true;     // Catch: Exception -> L10 Throwable -> L17
        monitor-exit(this);
        return;
    L10:
        e = move-exception;
        throw new IllegalStateException("Failed to validate round1 payload", e);     // Catch: Throwable -> L17
    L14:
        throw new IllegalStateException("Round1 payload already received");     // Catch: Throwable -> L17
    L16:
        throw new IllegalStateException("generateRound1Payload() must be called before receiveRound1Payload()");     // Catch: Throwable -> L17
    }

    public synchronized void receiveRound2Payload(Round2Msg r100) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.round2Sent == false) goto L16;
        if (this.round2Received == true) goto L14;
        this.participant.validateRound2PayloadReceived(r100.payload);     // Catch: Exception -> L10 Throwable -> L17
        this.round2Received = true;     // Catch: Exception -> L10 Throwable -> L17
        monitor-exit(this);
        return;
    L10:
        e = move-exception;
        throw new IllegalStateException("Failed to validate round2 payload", e);     // Catch: Throwable -> L17
    L14:
        throw new IllegalStateException("Round2 payload already received");     // Catch: Throwable -> L17
    L16:
        throw new IllegalStateException("generateRound2Payload() must be called before receiveRound2Payload()");     // Catch: Throwable -> L17
    }

    public synchronized boolean verifyKeyConfirmMsg(KeyConfirmMsg r100) {
        monitor-enter(this);
        ensureSharedKeyAvailable();     // Catch: Throwable -> L10
        Mac r101 = Mac.getInstance("HmacSHA256");     // Catch: Exception -> L7 Throwable -> L10
        r101.init(new SecretKeySpec(this.confirmKey, "HmacSHA256"));     // Catch: Exception -> L7 Throwable -> L10
        boolean r102 = Arrays.equals(r101.doFinal(r100.salt), r100.hmac);     // Catch: Exception -> L7 Throwable -> L10
        this.keyConfirmed = r102;     // Catch: Exception -> L7 Throwable -> L10
        monitor-exit(this);
        return r102;
    L7:
        e = move-exception;
        throw new IllegalStateException("Failed to verify key confirm message", e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }
}
