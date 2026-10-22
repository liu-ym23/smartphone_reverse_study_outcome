package com.bytedance.privacy.pcc;

import com.obric.sva.sdk.data.ISmModel;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import kotlin.UByte;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EncryptedPayloadTlv f266696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f266697b;

    public final byte[] b() throws Exception {
        EncryptedPayloadTlv r100 = this.f266696a;
        r100.getClass();
        EncryptedPayloadTlv.i r101 = new EncryptedPayloadTlv.i();
        EncryptedPayloadTlv.e r102 = r100.metaInfo;
        if (r102 == null) goto L5;
        r101.c(256, EncryptedPayloadTlv.c(r102));
    L5:
        EncryptedPayloadTlv.d r103 = r100.keyEnvelopePayload;
        if (r103 == null) goto L8;
        r101.c(512, EncryptedPayloadTlv.b(r103));
    L8:
        EncryptedPayloadTlv.b r104 = r100.contentInfoMeta;
        if (r104 == null) goto L11;
        r101.c(ISmModel.VERSION_0300, EncryptedPayloadTlv.a(r104));
    L11:
        EncryptedPayloadTlv.g r105 = r100.signContentInfo;
        if (r105 == null) goto L17;
        EncryptedPayloadTlv.i r106 = new EncryptedPayloadTlv.i();
        r106.f(1025, r105.signatureAlgorithm);
        byte[] r107 = r105.contentSignature;
        if (r107 == null) goto L16;
        r106.b(1026, r107);
    L16:
        r101.c(1024, r106.a());
    L17:
        byte[] r108 = r101.a();
        int r109 = r108.length;
        ByteArrayOutputStream r110 = new ByteArrayOutputStream((r109 + 6) + this.f266697b.length);
        r110.write(32);
        r110.write(1);
        r110.write((r109 >> 24) & 255);
        r110.write((r109 >> 16) & 255);
        r110.write((r109 >> 8) & 255);
        r110.write(r109 & 255);
        r110.write(r108, 0, r109);
        byte[] r111 = this.f266697b;
        if (r111.length <= 0) goto L21;
        r110.write(r111, 0, r111.length);
    L21:
        return r110.toByteArray();
    }

    public static b a(byte[] r110) throws Exception {
        int r100 = 0;
        if (r110 != null) goto L5;
    L121:
        StringBuilder r101 = new StringBuilder("EncryptedProtocol: data too short (");
        if (r110 == null) goto L125;
        r100 = r110.length;
    L125:
        r101.append(r100);
        r101.append(" bytes)");
        throw new Exception(r101.toString());
    L5:
        if (r110.length < 6) goto L121;
        int r102 = ((r110[0] & UByte.MAX_VALUE) << 8) | (r110[1] & UByte.MAX_VALUE);
        if (r102 != 8193) goto L120;
        int r103 = ((((r110[2] & 255) << 24) | ((r110[3] & 255) << 16)) | ((r110[4] & 255) << 8)) | (r110[5] & 255);
        if (r103 < 0) goto L118;
        int r104 = r103 + 6;
        if (r104 > r110.length) goto L116;
        byte[] r111 = new byte[r103];
        System.arraycopy(r110, 6, r111, 0, r103);
        int r105 = r110.length - r104;
        byte[] r106 = new byte[r105];
        if (r105 <= 0) goto L16;
        System.arraycopy(r110, r104, r106, 0, r105);
    L16:
        EncryptedPayloadTlv r107 = new EncryptedPayloadTlv();
        EncryptedPayloadTlv.h r108 = new EncryptedPayloadTlv.h(r111);
    L18:
        if (r108.a() == false) goto L114;
        int r109 = r108.c();
        byte[] r112 = r108.d(r108.b());
        if (r109 == 256) goto L86;
        if (r109 != 512) goto L24;
        EncryptedPayloadTlv.d r113 = new EncryptedPayloadTlv.d();
        r113.keyEnvelopeList = new ArrayList();
        EncryptedPayloadTlv.h r114 = new EncryptedPayloadTlv.h(r112);
    L60:
        if (r114.a() == false) goto L85;
        int r115 = r114.c();
        byte[] r116 = r114.d(r114.b());
        switch(r115) {
            case 513: goto L83;
            case 514: goto L82;
            case 515: goto L81;
            case 516: goto L64;
            default: goto L60;
        };
    L64:
        List<EncryptedPayloadTlv.c> r117 = r113.keyEnvelopeList;
        EncryptedPayloadTlv.h r118 = new EncryptedPayloadTlv.h(r116);
    L66:
        if (r118.a() == false) goto L60;
        int r119 = r118.c();
        byte[] r120 = r118.d(r118.b());
        EncryptedPayloadTlv.c r121 = new EncryptedPayloadTlv.c();
        EncryptedPayloadTlv.h r122 = new EncryptedPayloadTlv.h(r120);
    L69:
        if (r122.a() == false) goto L80;
        int r123 = r122.c();
        byte[] r124 = r122.d(r122.b());
        switch(r123) {
            case 1: goto L78;
            case 2: goto L77;
            case 3: goto L76;
            case 4: goto L75;
            case 5: goto L74;
            case 6: goto L73;
            default: goto L69;
        };
    L73:
        r121.encryptedSessionKey = r124;
        goto L69
    L74:
        r121.salt = r124;
        goto L69
    L75:
        r121.dhPK = r124;
        goto L69
    L76:
        r121.keyEncryptionAlgorithm = EncryptedPayloadTlv.d(r124);
        goto L69
    L77:
        r121.keyVersion = EncryptedPayloadTlv.e(r124);
        goto L69
    L78:
        r121.keyIdentify = r124;
        goto L69
    L80:
        r121.index = r119;
        r117.add(r121);
        goto L66
    L81:
        r113.keyEnvelopeListSize = EncryptedPayloadTlv.e(r116);
        goto L60
    L82:
        r113.envelopeType = EncryptedPayloadTlv.d(r116);
        goto L60
    L83:
        r113.version = EncryptedPayloadTlv.d(r116);
        goto L60
    L85:
        r107.keyEnvelopePayload = r113;
        goto L18
    L24:
        if (r109 != 768) goto L26;
        EncryptedPayloadTlv.b r125 = new EncryptedPayloadTlv.b();
        EncryptedPayloadTlv.h r126 = new EncryptedPayloadTlv.h(r112);
    L41:
        if (r126.a() == false) goto L57;
        int r127 = r126.c();
        byte[] r128 = r126.d(r126.b());
        switch(r127) {
            case 769: goto L56;
            case 770: goto L55;
            case 771: goto L45;
            default: goto L41;
        };
    L45:
        EncryptedPayloadTlv.f r129 = new EncryptedPayloadTlv.f();
        EncryptedPayloadTlv.h r130 = new EncryptedPayloadTlv.h(r128);
    L47:
        if (r130.a() == false) goto L54;
        int r131 = r130.c();
        byte[] r132 = r130.d(r130.b());
        if (r131 != 1) goto L50;
        r129.nonce = r132;
        goto L47
    L50:
        if (r131 != 2) goto L47;
        r129.chunkSize = EncryptedPayloadTlv.e(r132);
        goto L47
    L54:
        r125.otherKeyAttribute = r129;
        goto L41
    L55:
        r125.contentEncryptionAlgorithm = EncryptedPayloadTlv.d(r128);
        goto L41
    L56:
        r125.contentType = EncryptedPayloadTlv.d(r128);
        goto L41
    L57:
        r107.contentInfoMeta = r125;
        goto L18
    L26:
        if (r109 != 1024) goto L18;
        EncryptedPayloadTlv.g r133 = new EncryptedPayloadTlv.g();
        EncryptedPayloadTlv.h r134 = new EncryptedPayloadTlv.h(r112);
    L30:
        if (r134.a() == false) goto L38;
        int r135 = r134.c();
        byte[] r136 = r134.d(r134.b());
        if (r135 != 1025) goto L34;
        r133.signatureAlgorithm = EncryptedPayloadTlv.d(r136);
        goto L30
    L34:
        if (r135 != 1026) goto L30;
        r133.contentSignature = r136;
        goto L30
    L38:
        r107.signContentInfo = r133;
        goto L18
    L86:
        EncryptedPayloadTlv.e r137 = new EncryptedPayloadTlv.e();
        EncryptedPayloadTlv.h r138 = new EncryptedPayloadTlv.h(r112);
    L88:
        if (r138.a() == false) goto L111;
        int r139 = r138.c();
        byte[] r140 = r138.d(r138.b());
        switch(r139) {
            case 257: goto L110;
            case 258: goto L109;
            case 259: goto L92;
            default: goto L88;
        };
    L92:
        EncryptedPayloadTlv.a r141 = new EncryptedPayloadTlv.a();
        EncryptedPayloadTlv.h r142 = new EncryptedPayloadTlv.h(r140);
    L94:
        if (r142.a() == false) goto L108;
        int r143 = r142.c();
        byte[] r144 = r142.d(r142.b());
        if (r143 != 1) goto L97;
        r141.appId = new String(r144, StandardCharsets.UTF_8);
        goto L94
    L97:
        if (r143 != 2) goto L98;
        r141.serviceId = new String(r144, StandardCharsets.UTF_8);
        goto L94
    L98:
        if (r143 != 3) goto L99;
        r141.bizType = EncryptedPayloadTlv.d(r144);
        goto L94
    L99:
        if (r143 != 4) goto L101;
        r141.sessionKeyId = r144;
        goto L94
    L101:
        if (r143 != 5) goto L94;
        r141.accessToken = r144;
        goto L94
    L108:
        r137.bizAttribute = r141;
        goto L88
    L109:
        r137.contentType = EncryptedPayloadTlv.d(r140);
        goto L88
    L110:
        r137.version = EncryptedPayloadTlv.d(r140);
        goto L88
    L111:
        r107.metaInfo = r137;
        goto L18
    L114:
        return new b(r107, r106);
    L116:
        throw new Exception("EncryptedProtocol: TLV length " + r103 + " exceeds remaining buffer " + (r110.length - 6));
    L118:
        throw new Exception("EncryptedProtocol: TLV length overflow");
    L120:
        throw new Exception("EncryptedProtocol: invalid magic 0x" + Integer.toHexString(r102) + " (expected 0x2001)");
    }

    public b(EncryptedPayloadTlv r100, byte[] r101) {
        this.f266696a = r100;
        this.f266697b = r101;
    }
}
