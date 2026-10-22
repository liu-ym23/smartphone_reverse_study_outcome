package com.bytedance.crypto.pake;

import android.util.Base64;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.math.BigInteger;
import org.bouncycastle.crypto.agreement.jpake.JPAKERound1Payload;
import org.bouncycastle.crypto.agreement.jpake.JPAKERound2Payload;

/* JADX INFO: loaded from: classes15.dex */
public final class JpakeWireCodec {
    private static final Gson GSON = null;

    public static final class KeyConfirmDto {

        @SerializedName("hmacBase64")
        public final String hmacBase64;

        @SerializedName("saltBase64")
        public final String saltBase64;

        public KeyConfirmDto(String r100, String r101) {
            this.saltBase64 = r100;
            this.hmacBase64 = r101;
        }
    }

    public static final class Round1Dto {

        @SerializedName("gx1Hex")
        public final String gx1Hex;

        @SerializedName("gx2Hex")
        public final String gx2Hex;

        @SerializedName("participantId")
        public final String participantId;

        @SerializedName("zkpX1")
        public final ZkpDto zkpX1;

        @SerializedName("zkpX2")
        public final ZkpDto zkpX2;

        public Round1Dto(String r100, String r101, String r102, ZkpDto r103, ZkpDto r104) {
            this.participantId = r100;
            this.gx1Hex = r101;
            this.gx2Hex = r102;
            this.zkpX1 = r103;
            this.zkpX2 = r104;
        }
    }

    public static final class Round2Dto {

        @SerializedName("aHex")
        public final String aHex;

        @SerializedName("participantId")
        public final String participantId;

        @SerializedName("zkpX2s")
        public final ZkpDto zkpX2s;

        public Round2Dto(String r100, String r101, ZkpDto r102) {
            this.participantId = r100;
            this.aHex = r101;
            this.zkpX2s = r102;
        }
    }

    public static final class ZkpDto {

        @SerializedName("bHex")
        public final String bHex;

        @SerializedName("grHex")
        public final String grHex;

        public ZkpDto(String r100, String r101) {
            this.grHex = r100;
            this.bHex = r101;
        }
    }

    static {
        GSON = new Gson();
    }

    private JpakeWireCodec() {
    }

    public static JpakeSession.KeyConfirmMsg decodeKeyConfirm(String r100) {
        KeyConfirmDto r101 = (KeyConfirmDto) GsonProtectorUtils.fromJson(GSON, r100, KeyConfirmDto.class);
        if (r101 == null) goto L7;
        return new JpakeSession.KeyConfirmMsg(Base64.decode(r101.saltBase64, 2), Base64.decode(r101.hmacBase64, 2));
    L7:
        throw new IllegalArgumentException("KeyConfirm json decode failed");
    }

    public static JpakeSession.Round1Msg decodeRound1(String r100) {
        Round1Dto r101 = (Round1Dto) GsonProtectorUtils.fromJson(GSON, r100, Round1Dto.class);
        if (r101 == null) goto L7;
        BigInteger r102 = new BigInteger(r101.gx1Hex, 16);
        BigInteger r103 = new BigInteger(r101.gx2Hex, 16);
        BigInteger[] r104 = toBigIntArray(r101.zkpX1);
        BigInteger[] r105 = toBigIntArray(r101.zkpX2);
        return new JpakeSession.Round1Msg(new JPAKERound1Payload(r101.participantId, r102, r103, r104, r105));
    L7:
        throw new IllegalArgumentException("Round1 json decode failed");
    }

    public static JpakeSession.Round2Msg decodeRound2(String r100) {
        Round2Dto r101 = (Round2Dto) GsonProtectorUtils.fromJson(GSON, r100, Round2Dto.class);
        if (r101 == null) goto L7;
        BigInteger r102 = new BigInteger(r101.aHex, 16);
        BigInteger[] r103 = toBigIntArray(r101.zkpX2s);
        return new JpakeSession.Round2Msg(new JPAKERound2Payload(r101.participantId, r102, r103));
    L7:
        throw new IllegalArgumentException("Round2 json decode failed");
    }

    public static String encodeKeyConfirm(JpakeSession.KeyConfirmMsg r100) {
        if (r100 == null) goto L6;
        KeyConfirmDto r101 = new KeyConfirmDto(Base64.encodeToString(r100.salt, 2), Base64.encodeToString(r100.hmac, 2));
        return GsonProtectorUtils.toJson(GSON, r101);
    L6:
        throw new IllegalArgumentException("KeyConfirmMsg is null");
    }

    public static String encodeRound1(JpakeSession.Round1Msg r100) {
        if (r100 == null) goto L8;
        JPAKERound1Payload r101 = r100.payload;
        if (r101 == null) goto L8;
        Round1Dto r102 = new Round1Dto(r101.getParticipantId(), r101.getGx1().toString(16), r101.getGx2().toString(16), toZkpDto(r101.getKnowledgeProofForX1()), toZkpDto(r101.getKnowledgeProofForX2()));
        return GsonProtectorUtils.toJson(GSON, r102);
    L8:
        throw new IllegalArgumentException("Round1Msg or payload is null");
    }

    public static String encodeRound2(JpakeSession.Round2Msg r100) {
        if (r100 == null) goto L8;
        JPAKERound2Payload r101 = r100.payload;
        if (r101 == null) goto L8;
        Round2Dto r102 = new Round2Dto(r101.getParticipantId(), r101.getA().toString(16), toZkpDto(r101.getKnowledgeProofForX2s()));
        return GsonProtectorUtils.toJson(GSON, r102);
    L8:
        throw new IllegalArgumentException("Round2Msg or payload is null");
    }

    private static BigInteger[] toBigIntArray(ZkpDto r100) {
        if (r100 == null) goto L6;
        return new BigInteger[]{new BigInteger(r100.grHex, 16), new BigInteger(r100.bHex, 16)};
    L6:
        throw new IllegalArgumentException("ZkpDto is null");
    }

    private static ZkpDto toZkpDto(BigInteger[] r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
    L9:
        StringBuilder r102 = new StringBuilder("invalid zkp array size=");
        if (r100 == null) goto L13;
        r101 = r100.length;
    L13:
        r102.append(r101);
        throw new IllegalStateException(r102.toString());
    L5:
        if (r100.length < 2) goto L9;
        return new ZkpDto(r100[0].toString(16), r100[1].toString(16));
    }
}
