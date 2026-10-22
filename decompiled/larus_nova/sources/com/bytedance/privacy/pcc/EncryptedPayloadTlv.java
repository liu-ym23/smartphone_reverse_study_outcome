package com.bytedance.privacy.pcc;

import android.util.Base64;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.annotations.SerializedName;
import com.ss.ttm.player.MediaPlayer;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import kotlin.UByte;

/* JADX INFO: loaded from: classes21.dex */
public class EncryptedPayloadTlv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f266683a = null;

    @SerializedName("content_info_meta")
    public b contentInfoMeta;

    @SerializedName("key_envelope")
    public d keyEnvelopePayload;

    @SerializedName("meta_info")
    public e metaInfo;

    @SerializedName("sign_content_info")
    public g signContentInfo;

    public static final class ByteArrayBase64Adapter implements JsonSerializer<byte[]>, JsonDeserializer<byte[]> {
        private ByteArrayBase64Adapter() {
        }

        public /* synthetic */ ByteArrayBase64Adapter(int r100) {
            this();
        }

        @Override // com.google.gson.JsonDeserializer
        public final byte[] deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) throws JsonParseException {
            return Base64.decode(r100.getAsString(), 0);
        }

        @Override // com.google.gson.JsonSerializer
        public final JsonElement serialize(byte[] r100, Type r101, JsonSerializationContext r102) {
            return new JsonPrimitive(Base64.encodeToString(r100, 2));
        }
    }

    public static class a {

        @SerializedName("access_token")
        public byte[] accessToken;

        @SerializedName("app_id")
        public String appId;

        @SerializedName("biz_type")
        public int bizType;

        @SerializedName("app_svc_id")
        public String serviceId;

        @SerializedName("session_key_id")
        public byte[] sessionKeyId;

        public a() {
        }
    }

    public static class b {

        @SerializedName("content_encryption_algorithm")
        public int contentEncryptionAlgorithm;

        @SerializedName("content_type")
        public int contentType;

        @SerializedName("other_key_attribute")
        public f otherKeyAttribute;

        public b() {
        }
    }

    public static class c {

        @SerializedName("dh_pk")
        public byte[] dhPK;

        @SerializedName("encrypted_session_key")
        public byte[] encryptedSessionKey;

        @SerializedName("index")
        public int index;

        @SerializedName("key_encryption_algorithm")
        public int keyEncryptionAlgorithm;

        @SerializedName("key_identify")
        public byte[] keyIdentify;

        @SerializedName("key_version")
        public int keyVersion;

        @SerializedName("salt")
        public byte[] salt;

        public c() {
        }
    }

    public static class d {

        @SerializedName("envelope_type")
        public int envelopeType;

        @SerializedName("key_envelope_list")
        public List<c> keyEnvelopeList;

        @SerializedName("key_envelope_list_size")
        public int keyEnvelopeListSize;

        @SerializedName("version")
        public int version;

        public d() {
        }
    }

    public static class e {

        @SerializedName("biz_attribute")
        public a bizAttribute;

        @SerializedName("content_type")
        public int contentType;

        @SerializedName("version")
        public int version;

        public e() {
        }
    }

    public static class f {

        @SerializedName("chunk_size")
        public int chunkSize;

        @SerializedName("nonce")
        public byte[] nonce;

        public f() {
        }
    }

    public static class g {

        @SerializedName("content_signature")
        public byte[] contentSignature;

        @SerializedName("signature_algorithm")
        public int signatureAlgorithm;

        public g() {
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f266684a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f266685b;

        public final boolean a() {
            if (this.f266685b >= this.f266684a.length) goto L5;
            return true;
        L5:
            return false;
        }

        public final int b() throws Exception {
            int r100 = this.f266685b;
            int r101 = r100 + 4;
            byte[] r102 = this.f266684a;
            if (r101 > r102.length) goto L11;
            int r103 = ((((r102[r100] & UByte.MAX_VALUE) << 24) | ((r102[r100 + 1] & UByte.MAX_VALUE) << 16)) | ((r102[r100 + 2] & UByte.MAX_VALUE) << 8)) | (r102[r100 + 3] & UByte.MAX_VALUE);
            if (r103 < 0) goto L9;
            this.f266685b = r100 + 4;
            return r103;
        L9:
            throw new Exception("TLV length overflow at offset " + this.f266685b);
        L11:
            throw new Exception("TLV underflow reading length at offset " + this.f266685b);
        }

        public final int c() throws Exception {
            int r100 = this.f266685b;
            int r101 = r100 + 2;
            byte[] r102 = this.f266684a;
            if (r101 > r102.length) goto L7;
            int r103 = ((r102[r100] & UByte.MAX_VALUE) << 8) | (r102[r100 + 1] & UByte.MAX_VALUE);
            this.f266685b = r100 + 2;
            return r103;
        L7:
            throw new Exception("TLV underflow reading tag at offset " + this.f266685b);
        }

        public h(byte[] r100) {
            this.f266684a = r100;
            this.f266685b = 0;
        }

        public final byte[] d(int r100) throws Exception {
            int r101 = this.f266685b;
            int r102 = r101 + r100;
            byte[] r103 = this.f266684a;
            if (r102 > r103.length) goto L7;
            byte[] r104 = new byte[r100];
            System.arraycopy(r103, r101, r104, 0, r100);
            this.f266685b += r100;
            return r104;
        L7:
            throw new Exception("TLV underflow reading value: need " + r100 + " bytes at offset " + this.f266685b + " but only " + (this.f266684a.length - this.f266685b) + " remain");
        }
    }

    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteArrayOutputStream f266686a;

        public final byte[] a() {
            return this.f266686a.toByteArray();
        }

        public i() {
            this.f266686a = new ByteArrayOutputStream();
        }

        public final void d(int r100) {
            this.f266686a.write((r100 >> 24) & 255);
            this.f266686a.write((r100 >> 16) & 255);
            this.f266686a.write((r100 >> 8) & 255);
            this.f266686a.write(r100 & 255);
        }

        public final void e(int r100) {
            this.f266686a.write((r100 >> 8) & 255);
            this.f266686a.write(r100 & 255);
        }

        public final void b(int r100, byte[] r101) {
            e(r100);
            d(r101.length);
            this.f266686a.write(r101, 0, r101.length);
        }

        public final void c(int r100, byte[] r101) {
            e(r100);
            d(r101.length);
            this.f266686a.write(r101, 0, r101.length);
        }

        public final void f(int r100, int r101) {
            e(r100);
            d(2);
            this.f266686a.write((r101 >> 8) & 255);
            this.f266686a.write(r101 & 255);
        }

        public final void g(int r100, int r101) {
            e(r100);
            d(4);
            this.f266686a.write((r101 >> 24) & 255);
            this.f266686a.write((r101 >> 16) & 255);
            this.f266686a.write((r101 >> 8) & 255);
            this.f266686a.write(r101 & 255);
        }
    }

    public EncryptedPayloadTlv() {
    }

    static {
        f266683a = new GsonBuilder().registerTypeHierarchyAdapter(byte[].class, new ByteArrayBase64Adapter(0)).setPrettyPrinting().create();
    }

    public static byte[] a(b r100) throws Exception {
        i r101 = new i();
        r101.f(769, r100.contentType);
        r101.f(770, r100.contentEncryptionAlgorithm);
        f r102 = r100.otherKeyAttribute;
        if (r102 == null) goto L12;
        i r103 = new i();
        byte[] r104 = r102.nonce;
        if (r104 == null) goto L7;
        r103.b(1, r104);
    L7:
        int r105 = r102.chunkSize;
        if (r105 <= 0) goto L10;
        r103.g(2, r105);
    L10:
        r101.c(771, r103.a());
    L12:
        return r101.a();
    }

    public static byte[] b(d r100) throws Exception {
        i r101 = new i();
        r101.f(513, r100.version);
        r101.f(514, r100.envelopeType);
        r101.g(515, r100.keyEnvelopeListSize);
        List<c> r102 = r100.keyEnvelopeList;
        if (r102 == null) goto L24;
        if (r102.isEmpty() == true) goto L24;
        i r103 = new i();
        Iterator<c> r104 = r100.keyEnvelopeList.iterator();
    L8:
        if (r104.hasNext() == false) goto L22;
        c r105 = r104.next();
        int r106 = r105.index;
        i r107 = new i();
        byte[] r108 = r105.keyIdentify;
        if (r108 == null) goto L12;
        r107.b(1, r108);
    L12:
        r107.g(2, r105.keyVersion);
        r107.f(3, r105.keyEncryptionAlgorithm);
        byte[] r109 = r105.dhPK;
        if (r109 == null) goto L15;
        r107.b(4, r109);
    L15:
        byte[] r110 = r105.salt;
        if (r110 == null) goto L18;
        r107.b(5, r110);
    L18:
        byte[] r111 = r105.encryptedSessionKey;
        if (r111 == null) goto L21;
        r107.b(6, r111);
    L21:
        r103.c(r106, r107.a());
        goto L8
    L22:
        r101.c(516, r103.a());
    L24:
        return r101.a();
    }

    public static byte[] c(e r100) throws Exception {
        i r101 = new i();
        r101.f(257, r100.version);
        r101.f(258, r100.contentType);
        a r102 = r100.bizAttribute;
        if (r102 == null) goto L18;
        i r103 = new i();
        String r104 = r102.appId;
        if (r104 == null) goto L7;
        r103.b(1, r104.getBytes(StandardCharsets.UTF_8));
    L7:
        String r105 = r102.serviceId;
        if (r105 == null) goto L10;
        r103.b(2, r105.getBytes(StandardCharsets.UTF_8));
    L10:
        r103.f(3, r102.bizType);
        byte[] r106 = r102.sessionKeyId;
        if (r106 == null) goto L13;
        r103.b(4, r106);
    L13:
        byte[] r107 = r102.accessToken;
        if (r107 == null) goto L16;
        r103.b(5, r107);
    L16:
        r101.c(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME, r103.a());
    L18:
        return r101.a();
    }

    public static int d(byte[] r100) {
        int r101 = (r100[0] & UByte.MAX_VALUE) << 8;
        return (r100[1] & UByte.MAX_VALUE) | r101;
    }

    public static int e(byte[] r100) {
        int r101 = (((r100[0] & UByte.MAX_VALUE) << 24) | ((r100[1] & UByte.MAX_VALUE) << 16)) | ((r100[2] & UByte.MAX_VALUE) << 8);
        return (r100[3] & UByte.MAX_VALUE) | r101;
    }
}
