package com.bytedance.dora.offline.file;

import androidx.collection.SieveCacheKt;
import com.bytedance.keva.KevaImpl;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.UByte;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f204569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f204570b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f204571c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f204572d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f204573e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final byte[] f204574f;

        public a(int r100, int r101, String r102, long r103, int r104, byte[] r105) {
            this.f204569a = r100;
            this.f204570b = r101;
            this.f204571c = r102;
            this.f204572d = r103;
            this.f204573e = r104;
            this.f204574f = r105;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.dora.offline.file.b$b, reason: collision with other inner class name */
    public static final class C2961b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f204575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f204576b;

        public C2961b(int r100, String r101) {
            this.f204575a = r100;
            this.f204576b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f204577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f204578b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f204579c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<C2961b> f204580d;

        public c(int r100, long r101, boolean r102, List<C2961b> r103) {
            this.f204577a = r100;
            this.f204578b = r101;
            this.f204579c = r102;
            this.f204580d = r103;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f204581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f204582b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f204583c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f204584d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f204585e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f204586f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f204587g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f204588h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f204589i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f204590j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f204591k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final boolean f204592l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final long f204593m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f204594n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f204595o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final long f204596p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final int f204597q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final int f204598r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final int f204599s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final String f204600t;

        public final String a() {
            return this.f204581a + "_" + b.g(this.f204582b);
        }

        public d(int r100, String r101, int r102, String r103, int r104, long r105, long r110, long r111, long r112, int r113, int r114, boolean r115, long r210, int r211, int r212, long r213, int r214, int r215, int r216, String r217) {
            this.f204581a = r100;
            this.f204582b = r101;
            this.f204583c = r102;
            this.f204584d = r103;
            this.f204585e = r104;
            this.f204586f = r105;
            this.f204587g = r110;
            this.f204588h = r111;
            this.f204589i = r112;
            this.f204590j = r113;
            this.f204591k = r114;
            this.f204592l = r115;
            this.f204593m = r210;
            this.f204594n = r211;
            this.f204595o = r212;
            this.f204596p = r213;
            this.f204597q = r214;
            this.f204598r = r215;
            this.f204599s = r216;
            this.f204600t = r217;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f204601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f204602b;

        public e(int r100, d r101) {
            this.f204601a = r100;
            this.f204602b = r101;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f204603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f204604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f204605c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f204606d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f204607e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f204608f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f204609g;

        public f(int r100, int r101, String r102, int r103, String r104, int r105, long r106) {
            this.f204603a = r100;
            this.f204604b = r101;
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            this.f204605c = r102;
            this.f204606d = r103;
            this.f204607e = r104;
            this.f204608f = r105;
            this.f204609g = r106;
        }
    }

    public static final class g {
        public g() {
            throw null;
        }
    }

    public static byte[] b(byte[]... r100) {
        int r101 = r100.length;
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r102 >= r101) goto L8;
        byte[] r104 = r100[r102];
        if (r104 == null) goto L7;
        r103 = r103 + r104.length;
    L7:
        r102 = r102 + 1;
        goto L3
    L8:
        byte[] r105 = new byte[r103];
        int r106 = r100.length;
        int r107 = 0;
        int r108 = 0;
    L9:
        if (r107 >= r106) goto L16;
        byte[] r109 = r100[r107];
        if (r109 == null) goto L15;
        if (r109.length <= 0) goto L15;
        System.arraycopy(r109, 0, r105, r108, r109.length);
        r108 = r108 + r109.length;
    L15:
        r107 = r107 + 1;
        goto L9
    L16:
        return r105;
    }

    public static byte[] c(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.length() == 0) goto L13;
        byte[] r101 = r100.getBytes(StandardCharsets.UTF_8);
        if (r101.length <= 48) goto L10;
        return null;
    L10:
        return r101;
    L13:
        return null;
    }

    public static boolean e(String r100) {
        if (r100 != null) goto L5;
    L27:
        return false;
    L5:
        if (r100.length() != 32) goto L27;
        int r101 = 0;
    L9:
        if (r101 >= r100.length()) goto L25;
        char r102 = r100.charAt(r101);
        if (r102 < '0') goto L15;
        if (r102 > '9') goto L15;
    L23:
        r101 = r101 + 1;
    L15:
        if (r102 < 'a') goto L19;
        if (r102 <= 'f') goto L23;
    L19:
        if (r102 < 'A') goto L24;
        if (r102 <= 'F') goto L23;
    L24:
        return false;
    L25:
        return true;
    }

    public static String g(String r100) {
        if (r100 != null) goto L4;
        return "none";
    L4:
        if (r100.length() != 0) goto L7;
        return "none";
    L7:
        return r100.replaceAll("[^a-zA-Z0-9._-]", "_");
    }

    public static String i(JSONObject r100) {
        if (r100.has("context_id") == true) goto L5;
    L11:
        return null;
    L5:
        if (r100.isNull("context_id") == true) goto L11;
        String r101 = r100.optString("context_id", null);
        if (c(r101) == null) goto L10;
        return r101;
    L10:
        f("context_id", "invalid_utf8_string");
        goto L11
    }

    public static String k(JSONObject r100) {
        if (r100.has("vui_id") == true) goto L5;
    L15:
        return null;
    L5:
        if (r100.isNull("vui_id") == true) goto L15;
        String r101 = r100.optString("vui_id", null);
        if (r101 == null) goto L15;
        if (r101.length() == 0) goto L15;
        r(r101, "vui_id");     // Catch: IllegalArgumentException -> L14
        return r101;
    L14:
        f("vui_id", "invalid_uint32");
        goto L15
    }

    public static a n(byte[] r110) {
        if (r110 == null) goto L14;
        if (r110.length < 14) goto L14;
        int r100 = r110[0] & UByte.MAX_VALUE;
        int r101 = r110[1] & UByte.MAX_VALUE;
        String r102 = String.valueOf(s(r110, 2));
        long r103 = s(r110, 6);
        long r104 = s(r110, 10);
        if (r104 > SieveCacheKt.NodeLinkMask) goto L12;
        if (r110.length != (((long) 14) + r104)) goto L12;
        int r105 = (int) r104;
        return new a(r100, r101, r102, r103, r105, Arrays.copyOfRange(r110, 14, 14 + r105));
    L12:
        throw new IllegalArgumentException("Invalid file_data length, actualFrameLength=" + r110.length + ", headerLength=14, declaredDataLength=" + r104);
    L14:
        throw new IllegalArgumentException("file_data is too short");
    }

    public static c o(String r110) throws Exception {
        JSONObject r100 = new JSONObject(r110);
        int r101 = m(r100, "ret_code", -1);
        if (r100.has(com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT) == true) goto L5;
    L10:
        long r102 = 0;
    L11:
        int r103 = 0;
        boolean r104 = h(r100, "has_more", false);
        JSONArray r105 = r100.optJSONArray(KevaImpl.PrivateConstants.FILES_DIR_NAME);
        if (r105 != null) goto L16;
        f(KevaImpl.PrivateConstants.FILES_DIR_NAME, "not_array");
        return new c(r101, r102, r104, Collections.emptyList());
    L16:
        if (r105.length() == 0) goto L18;
        ArrayList r106 = new ArrayList();
    L21:
        if (r103 >= r105.length()) goto L44;
        JSONObject r111 = r105.optJSONObject(r103);
        C2961b r112 = null;
        if (r111 != null) goto L45;
        pk4.j.f("OfflineFileProtocol", "Skip null file list item, index=" + r103 + ", totalCount=" + r102);
    L40:
        if (r112 == null) goto L42;
        r106.add(r112);
    L42:
        r103 = r103 + 1;
        goto L21
    L45:
    L38:
        e = move-exception;
        pk4.j.f("OfflineFileProtocol", "Skip file list item without usable request key, index=" + r103 + ", totalCount=" + r102 + ", error=" + e.getMessage());
        goto L40
    L26:
        if (r111.has("business_type") == false) goto L37;
        if (r111.isNull("business_type") == true) goto L37;
        long r113 = r(r111.optString("business_type"), "business_type");     // Catch: IllegalArgumentException -> L38
        v("business_type", r113);     // Catch: IllegalArgumentException -> L38
        int r114 = (int) r113;     // Catch: IllegalArgumentException -> L38
        if (r111.has("vui_id") == false) goto L35;
        if (r111.isNull("vui_id") == true) goto L35;
        String r115 = r111.optString("vui_id", null);     // Catch: IllegalArgumentException -> L38
        r(r115, "vui_id");     // Catch: IllegalArgumentException -> L38
        m(r111, "context_type", -1);     // Catch: IllegalArgumentException -> L38
        i(r111);     // Catch: IllegalArgumentException -> L38
        m(r111, "file_type", 1);     // Catch: IllegalArgumentException -> L38
        r112 = new C2961b(r114, r115);     // Catch: IllegalArgumentException -> L38
    L35:
        throw new IllegalArgumentException("vui_id is missing");     // Catch: IllegalArgumentException -> L38
    L37:
        throw new IllegalArgumentException("business_type is missing");     // Catch: IllegalArgumentException -> L38
    L44:
        return new c(r101, r102, r104, r106);
    L18:
        return new c(r101, r102, r104, Collections.emptyList());
    L5:
        if (r100.isNull(com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT) == true) goto L10;
        r102 = r(r100.optString(com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT), com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT);     // Catch: IllegalArgumentException -> L9
        t(com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT, r102);     // Catch: IllegalArgumentException -> L9
    L9:
        f(com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT, "invalid_uint16");
        goto L10
    }

    public static e p(String r310) throws Exception {
        JSONObject r100 = new JSONObject(r310);
        int r101 = m(r100, "ret_code", -1);
        if (r101 != 0) goto L5;
        JSONObject r102 = r100.optJSONObject("metadata");
        if (r102 != null) goto L10;
        f("metadata", "missing");
        return new e(r101, null);
    L10:
        int r103 = m(r102, "business_type", 0);
        String r104 = k(r102);
        int r105 = m(r102, "context_type", -1);
        String r110 = i(r102);
        int r111 = m(r102, "file_type", 1);
        long r112 = l(r102, "start_time_ms");
        long r113 = l(r102, "end_time_ms");
        long r114 = j(r102, "duration_ms", 0);
        long r115 = j(r102, "file_size", 0);
        int r106 = m(r102, "file_format", 2);
        int r210 = m(r102, "sync_state", 1);
        boolean r211 = h(r102, "allow_pull", true);
        long r212 = l(r102, "created_at_ms");
        if (r102.has("checksum") == true) goto L13;
    L19:
        String r311 = "";
    L21:
        if (r106 != 2) goto L23;
    L26:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L45;
        long r108 = j(r102, SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT, 16000);
        int r109 = m(r102, "channels", 1);
        int r116 = m(r102, "bits", 16);
        int r117 = m(r102, "com_ratio", 8);
        if (r109 != 2) goto L31;
        int r118 = 1280;
    L32:
        int r213 = r118;
        long r119 = j(r102, "packet_size", r118);
        if (r119 <= SieveCacheKt.NodeLinkMask) goto L35;
        f("packet_size", "exceeds_int_max");
        int r120 = r213;
    L37:
        if (r109 != 2) goto L39;
        int r121 = 160;
    L40:
        int r214 = r120;
        int r215 = r121;
        long r122 = j(r102, "com_packet_size", r121);
        if (r122 <= SieveCacheKt.NodeLinkMask) goto L43;
        f("com_packet_size", "exceeds_int_max");
        int r123 = r215;
    L44:
        int r124 = r116;
        int r312 = r123;
        int r216 = r109;
        int r313 = r214;
        int r217 = r117;
        long r218 = r108;
    L47:
        return new e(r101, new d(r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r210, r211, r212, r124, r217, r218, r216, r313, r312, r311));
    L43:
        r123 = (int) r122;
        goto L44
    L39:
        r121 = 80;
        goto L40
    L35:
        r120 = (int) r119;
        goto L37
    L31:
        r118 = 640;
        goto L32
    L45:
        r124 = 0;
        r217 = 0;
        r218 = 0;
        r216 = 0;
        r313 = 0;
        r312 = 0;
        goto L47
    L23:
        if (r106 == 3) goto L26;
        r107 = false;
        goto L27
    L13:
        if (r102.isNull("checksum") == true) goto L19;
        String r219 = r102.optString("checksum", "");
        if (e(r219) == false) goto L18;
        r311 = r219;
        goto L21
    L18:
        f("checksum", "invalid_md5");
        goto L19
    L5:
        return new e(r101, null);
    }

    public static f q(String r110) throws Exception {
        JSONObject r100 = new JSONObject(r110);
        int r101 = m(r100, "status", 0);
        if (r101 == 0) goto L6;
        if (r101 == 1) goto L6;
        f("status", "out_of_range");
        int r102 = 0;
    L8:
        return new f(r102, m(r100, "business_type", 0), k(r100), m(r100, "context_type", -1), i(r100), m(r100, "file_type", 1), j(r100, "duration", 0));
    L6:
        r102 = r101;
        goto L8
    }

    public static byte[] x(long r100) {
        u("uint32", r100);
        return new byte[]{(byte) ((r100 >> 24) & 255), (byte) ((r100 >> 16) & 255), (byte) ((r100 >> 8) & 255), (byte) (r100 & 255)};
    }

    public static byte[] d(int r100, String r101) {
        long r102 = r100;
        v("business_type", r102);
        return b(new byte[][]{new byte[]{(byte) r102}, x(r(r101, "vui_id"))});
    }

    public static void f(String r100, String r101) {
        pk4.j.f("OfflineFileProtocol", "Use default offline file field, field=" + r100 + ", reason=" + r101);
    }

    public static long l(JSONObject r100, String r101) {
        if (r100.has(r101) == true) goto L5;
    L14:
        return 0;
    L5:
        if (r100.isNull(r101) == true) goto L14;
        String r102 = r100.optString(r101, null);
        long r103 = CastLongProtector.parseLong(r102);     // Catch: IllegalArgumentException -> L13
        if (r103 < 0) goto L12;
        return r103;
    L12:
        throw new IllegalArgumentException(r101 + " uint64 is negative: " + r102);     // Catch: IllegalArgumentException -> L13
    L13:
        f(r101, "invalid_uint64");
        goto L14
    }

    public static long r(String r100, String r101) {
        if (r100 == null) goto L11;
        if (r100.length() == 0) goto L11;
        long r102 = CastLongProtector.parseLong(r100);     // Catch: NumberFormatException -> L7
        u(r101, r102);     // Catch: NumberFormatException -> L7
        return r102;
    L7:
        e = move-exception;
        throw new IllegalArgumentException(r101 + " is not uint32: " + r100, e);
    L11:
        throw new IllegalArgumentException(r101.concat(" is empty"));
    }

    public static long s(byte[] r100, int r101) {
        long r102 = ((((long) (r100[r101] & UByte.MAX_VALUE)) << 24) | (((long) (r100[r101 + 1] & UByte.MAX_VALUE)) << 16)) | (((long) (r100[r101 + 2] & UByte.MAX_VALUE)) << 8);
        return ((long) (r100[r101 + 3] & UByte.MAX_VALUE)) | r102;
    }

    public static void t(String r100, long r101) {
        if (r101 < 0) goto L8;
        if (r101 > 65535) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(r100 + " uint16 out of range: " + r101);
    }

    public static void u(String r100, long r101) {
        if (r101 < 0) goto L8;
        if (r101 > BodyPartID.bodyIdMax) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(r100 + " uint32 out of range: " + r101);
    }

    public static void v(String r100, long r101) {
        if (r101 < 0) goto L8;
        if (r101 > 255) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(r100 + " uint8 out of range: " + r101);
    }

    public static byte[] w(int r100, byte[] r101) {
        if (r101.length > 255) goto L11;
        if (r101.length >= 128) goto L7;
        byte[] r102 = {(byte) r101.length};
    L9:
        return b(new byte[][]{new byte[]{(byte) r100}, r102, r101});
    L7:
        r102 = new byte[]{(byte) ((r101.length / 128) | 128), (byte) (r101.length % 128)};
        goto L9
    L11:
        throw new IllegalArgumentException("TLV value is too large: " + r101.length);
    }

    public static boolean h(JSONObject r100, String r101, boolean r102) {
        if (r100.has(r101) == true) goto L5;
    L12:
        return r102;
    L5:
        if (r100.isNull(r101) == true) goto L12;
        Object r103 = r100.opt(r101);
        if ((r103 instanceof Boolean) == true) goto L10;
        f(r101, "invalid_boolean");
        goto L12
    L10:
        return ((Boolean) r103).booleanValue();
    }

    public static long j(JSONObject r100, String r101, long r102) {
        if (r100.has(r101) == true) goto L5;
    L10:
        return r102;
    L5:
        if (r100.isNull(r101) == true) goto L10;
        return r(r100.optString(r101), r101);
    L9:
        f(r101, "invalid_uint32");
        goto L10
    }

    public static int m(JSONObject r100, String r101, int r102) {
        if (r100.has(r101) == true) goto L5;
    L11:
        return r102;
    L5:
        if (r100.isNull(r101) == true) goto L11;
        long r103 = r(r100.optString(r101), r101);     // Catch: IllegalArgumentException -> L10
        v(r101, r103);     // Catch: IllegalArgumentException -> L10
        return (int) r103;
    L10:
        f(r101, "invalid_uint8");
        goto L11
    }

    public static byte[] a(int r100, String r101, int r102, String r103) {
        byte[] r104 = c(r103);
        if (r104 == null) goto L7;
        long r105 = r102;
        v("context_type", r105);
        return w(58, b(new byte[][]{d(r100, r101), new byte[]{(byte) r105}, r104}));
    L7:
        throw new IllegalArgumentException("context_id is invalid");
    }
}
