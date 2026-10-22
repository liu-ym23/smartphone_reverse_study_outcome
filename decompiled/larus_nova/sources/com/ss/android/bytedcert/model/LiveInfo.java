package com.ss.android.bytedcert.model;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.bytedcert.flow.base.AbsCertFlow;
import com.ss.android.bytedcert.flow.base.ICertFlow;
import com.ss.android.bytedcert.flow.face.FaceDetectFlow;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.event.EventLogUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import osa.b;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final class LiveInfo {
    public final List<Integer> A;
    public final List<Integer> B;
    public final boolean C;
    public final boolean D;
    public JSONObject E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f407576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f407577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveConf f407578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f407579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f407580e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bitmap f407581f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f407582g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f407583h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f407584i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f407585j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f407586k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f407587l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f407588m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ReflectionConfig f407589n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LivenessInfoConfig f407590o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f407591p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int[] f407592q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int[] f407593r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f407594s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f407595t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f407596u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f407597v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f407598w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f407599x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List<Integer> f407600y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final List<Integer> f407601z;

    public static class LiveConf {
        private int[] controlFlags;
        private float[] controlValues;

        public LiveConf() {
        }

        public int[] getFlags() {
            return this.controlFlags;
        }

        public float[] getValues() {
            return this.controlValues;
        }

        public void parseJsonArray(JSONArray r100) {
            if (r100 == null) goto L20;
        L12:
            e = move-exception;
            e.printStackTrace();
            return;
        L4:
            if (r100.length() == 0) goto L21;
            int r101 = r100.length();     // Catch: Exception -> L12
            this.controlFlags = new int[r101];     // Catch: Exception -> L12
            this.controlValues = new float[r101];     // Catch: Exception -> L12
            int r102 = 0;
        L6:
            if (r102 >= r101) goto L22;
            JSONObject r103 = JSONArrayProtectorUtils.getJSONObject(r100, r102);     // Catch: Exception -> L12
            if (r103 == null) goto L11;
            this.controlFlags[r102] = r103.optInt("enum");     // Catch: Exception -> L12
            this.controlValues[r102] = (float) r103.optDouble("value");     // Catch: Exception -> L12
        L11:
            r102 = r102 + 1;
            goto L6
        L22:
            return;
        L21:
            return;
        }

        public void setControlFlags(int[] r100) {
            this.controlFlags = r100;
        }

        public void setControlValues(float[] r100) {
            this.controlValues = r100;
        }
    }

    public static class LivenessInfoConfig {
        public DetectType detectType;
        public boolean enable;

        public static final enum DetectType extends Enum<DetectType> {
            private static final /* synthetic */ DetectType[] $VALUES = null;
            public static final DetectType NONE = null;
            public static final DetectType WHITE_BALANCE = null;
            private final int mValue;

            static {
                DetectType r100 = new DetectType(UserProfileEvent.POSITION_NONE, 0, -1);
                NONE = r100;
                DetectType r101 = new DetectType("WHITE_BALANCE", 1, 0);
                WHITE_BALANCE = r101;
                $VALUES = new DetectType[]{r100, r101};
            }

            public static DetectType[] values() {
                return (DetectType[]) $VALUES.clone();
            }

            public int getValue() {
                return this.mValue;
            }

            public static DetectType valueOf(String r100) {
                return (DetectType) a.a(DetectType.class, r100);
            }

            private DetectType(String r100, int r101, int r102) {
                super(r100, r101);
                this.mValue = r102;
            }
        }

        public static class WbConfig extends LivenessInfoConfig {
            public boolean autoBlue;
            public int color;
            public int frameNum;
            public double threshold;

            public String getColorStr() {
                int r100 = this.color;
                if (r100 != 1) goto L5;
                return "green";
            L5:
                if (r100 == 2) goto L8;
                return "red";
            L8:
                return "blue";
            }

            public WbConfig() {
            }

            public void parse(JSONObject r100) {
                if (r100 != null) goto L4;
                return;
            L4:
                this.frameNum = r100.optInt(BytedCertConstant.LivenessInfoConfigKey.FRAME_NUM);
                this.threshold = r100.optDouble("t");
                this.color = r100.optInt("c");
            }
        }

        public LivenessInfoConfig() {
        }

        public static LivenessInfoConfig obtain(JSONObject r100) {
            if (r100 == null) goto L14;
            int r101 = r100.optInt(BytedCertConstant.LivenessInfoConfigKey.DETECT_TYPE, -1);
            DetectType r102 = DetectType.NONE;
            if (r101 != 0) goto L7;
            WbConfig r103 = new WbConfig();
            r102 = DetectType.WHITE_BALANCE;
            r103.parse(r100);
            LivenessInfoConfig r104 = r103;
        L8:
            boolean r105 = true;
            if (r100.optInt("e") == 1) goto L12;
            r105 = false;
        L12:
            r104.enable = r105;
            r104.detectType = r102;
            return r104;
        L7:
            r104 = new LivenessInfoConfig();
            goto L8
        L14:
            return new LivenessInfoConfig();
        }
    }

    public static class ReflectionConfig {
        public int colorCount;
        public int[] colors;
        public boolean enable;
        public int preFrameNum;

        public ReflectionConfig() {
        }

        public void parse(JSONObject r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            int r101 = 0;
            boolean r102 = true;
            if (r100.optInt("e") == 1) goto L8;
            r102 = false;
        L8:
            this.enable = r102;
            this.colorCount = r100.optInt("c");
            JSONArray r103 = r100.optJSONArray(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
            if (r103 == null) goto L19;
            int r104 = r103.length();
            int r105 = this.colorCount;
            if (r104 != r105) goto L19;
            this.colors = new int[r105];
        L15:
            if (r101 >= r103.length()) goto L17;
            this.colors[r101] = r103.optInt(r101);
            r101 = r101 + 1;
            goto L15
        L17:
            this.preFrameNum = r100.optInt("p");
            return;
        L19:
            this.enable = false;
        }
    }

    public final String c() {
        StringBuilder r100 = new StringBuilder();
        int[] r101 = this.f407593r;
        if (r101 == null) goto L14;
        if (r101.length <= 0) goto L14;
        int r102 = 0;
    L7:
        int[] r103 = this.f407593r;
        if (r102 >= r103.length) goto L14;
        r100.append(r103[r102]);
        if (r102 == (this.f407593r.length - 1)) goto L12;
        r100.append(",");
    L12:
        r102 = r102 + 1;
    L14:
        return r100.toString();
    }

    public final int d() {
        if (this.A.isEmpty() == false) goto L6;
        return -1;
    L6:
        List<Integer> r100 = this.A;
        return ((Integer) ListProtector.get(r100, r100.size() - 1)).intValue();
    }

    public final String f() {
        StringBuilder r100 = new StringBuilder();
        int[] r101 = this.f407592q;
        if (r101 == null) goto L14;
        if (r101.length <= 0) goto L14;
        int r102 = 0;
    L7:
        int[] r103 = this.f407592q;
        if (r102 >= r103.length) goto L14;
        r100.append(r103[r102]);
        if (r102 == (this.f407592q.length - 1)) goto L12;
        r100.append(",");
    L12:
        r102 = r102 + 1;
    L14:
        return r100.toString();
    }

    public final String h() {
        StringBuilder r100 = new StringBuilder();
        Iterator<Integer> r101 = this.B.iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        r100.append(r101.next().intValue());
        r100.append(",");
        goto L4
    L7:
        if (r100.length() <= 1) goto L10;
        r100.setLength(r100.length() - 1);
    L10:
        return r100.toString();
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(String.valueOf((char) this.f407576a.length()));
        r100.append(this.f407576a);
        r100.append("liveness_timeout=");
        r100.append(this.f407577b);
        r100.append("&motion_types=");
        int r101 = 0;
    L3:
        int[] r102 = this.f407592q;
        if (r101 >= r102.length) goto L9;
        r100.append(r102[r101]);
        if (r101 == (this.f407592q.length - 1)) goto L8;
        r100.append(",");
    L8:
        r101 = r101 + 1;
        goto L3
    L9:
        r100.append("&");
        return r100.toString();
    }

    public LiveInfo(String r100) {
        this.f407576a = "1.0";
        this.f407577b = 10;
        this.f407578c = new LiveConf();
        this.f407589n = new ReflectionConfig();
        this.f407590o = new LivenessInfoConfig();
        this.f407599x = 0;
        this.f407600y = new ArrayList();
        this.f407601z = new ArrayList();
        this.A = new ArrayList();
        this.C = false;
        this.D = false;
        ArrayList r101 = new ArrayList(Arrays.asList(new Integer[]{0, 2, 3}));
        Collections.shuffle(r101);
        this.f407592q = new int[]{((Integer) ListProtector.get(r101, 0)).intValue()};
        ICertFlow r102 = BytedCertManager.getInstance().getFlow(r100);
        String r103 = null;
        if ((r102 instanceof AbsCertFlow) == false) goto L5;
        b r104 = ((AbsCertFlow) r102).getCertInfo();
    L6:
        if (r104 == null) goto L9;
        r103 = r104.f526574h;
    L9:
        this.f407582g = r103;
        if (TextUtils.isEmpty(r103) == false) goto L12;
        this.f407582g = BytedCertConstant.LiveType.LIVE_TYPE_ACTION;
    L12:
        this.B = new ArrayList();
        return;
    L5:
        r104 = null;
        goto L6
    }

    public static List b(int r100) {
        ArrayList r101 = new ArrayList();
        if (r100 == 0) goto L11;
        int r102 = 0;
    L6:
        if (r102 >= 4) goto L11;
        int r103 = ((r100 >> (r102 * 4)) & 15) - 1;
        if (r103 < 0) goto L10;
        r101.add(Integer.valueOf(r103));
    L10:
        r102 = r102 + 1;
    L11:
        return r101;
    }

    public static String e(String r100) {
        return String.valueOf((char) 3) + "4.0" + r100;
    }

    public final void a(String r100, String r101) {
        if (this.E != null) goto L10;
        this.E = new JSONObject();
    L10:
        this.E.put(r100, r101);     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public final void g(int r100, boolean r101) {
        if (r101 == false) goto L19;
        if (r100 != 4) goto L7;
    L8:
        r100 = r100 - 2;
    L10:
        if (this.B.contains(Integer.valueOf(r100)) == true) goto L13;
        this.B.add(Integer.valueOf(r100));
    L13:
        if (this.f407600y.indexOf(Integer.valueOf(r100)) == 0) goto L16;
        CertLog.d("FaceLivenessTask", "something wrong,current motion is not the first motion");
    L16:
        if (this.f407600y.isEmpty() == true) goto L24;
        ListProtector.remove(this.f407600y, 0);
        return;
    L24:
        return;
    L7:
        if (r100 != 5) goto L10;
    L19:
        if (this.f407600y.isEmpty() == true) goto L26;
        int r102 = ((Integer) ListProtector.remove(this.f407600y, 0)).intValue();
        if (this.A.contains(Integer.valueOf(r102)) == true) goto L27;
        this.A.add(Integer.valueOf(r102));
        return;
    L27:
        return;
    }

    public LiveInfo(BDResponse r110, String r111, LiveInfo r112) {
        this.f407576a = "1.0";
        this.f407577b = 10;
        LiveConf r113 = new LiveConf();
        this.f407578c = r113;
        this.f407589n = new ReflectionConfig();
        this.f407590o = new LivenessInfoConfig();
        this.f407599x = 0;
        this.f407600y = new ArrayList();
        this.f407601z = new ArrayList();
        this.A = new ArrayList();
        this.C = false;
        this.D = false;
        if (r112 != null) goto L5;
        this.B = new ArrayList();
    L6:
        ICertFlow r100 = BytedCertManager.getInstance().getFlow(r111);
        if ((r100 instanceof FaceDetectFlow) == false) goto L9;
        FaceDetectFlow r101 = (FaceDetectFlow) r100;
    L10:
        if (r110 == null) goto L107;
    L92:
        e = move-exception;
        e.printStackTrace();
        return;
    L12:
        if (r110.success == false) goto L108;
        JSONObject r114 = r110.jsonData;     // Catch: Exception -> L92
        if (r114 == null) goto L109;
        this.f407576a = r114.optString("version");     // Catch: Exception -> L92
        this.f407577b = r114.optInt("liveness_timeout", 10);     // Catch: Exception -> L92
        r113.parseJsonArray(r114.optJSONArray("liveness_conf"));     // Catch: Exception -> L92
        List r102 = b(r114.optInt("motion_types"));     // Catch: Exception -> L92
        ArrayList r103 = (ArrayList) r102;     // Catch: Exception -> L92
        if (r103.isEmpty() == false) goto L18;
        this.f407592q = new int[0];     // Catch: Exception -> L92
    L30:
        List r104 = b(r114.optInt(EventConstant.Key.FALLBACK_MOTION_TYPES));     // Catch: Exception -> L92
        ArrayList r105 = (ArrayList) r104;     // Catch: Exception -> L92
        if (r105.isEmpty() == true) goto L95;
        int r106 = r105.size();     // Catch: Exception -> L92
        this.f407593r = new int[r106];     // Catch: Exception -> L92
        int r115 = 0;
    L33:
        if (r115 >= r106) goto L95;
        int r116 = ((Integer) ListProtector.get(r104, r115)).intValue();     // Catch: Exception -> L92
        this.f407593r[r115] = r116;     // Catch: Exception -> L92
        if (this.B.isEmpty() == false) goto L37;
    L38:
        List<Integer> r117 = this.f407601z;     // Catch: Exception -> L92
        ArrayList r118 = (ArrayList) r117;     // Catch: Exception -> L92
        r118.add(Integer.valueOf(r116));     // Catch: Exception -> L92
    L39:
        r115 = r115 + 1;
        goto L33
    L37:
        if (this.B.contains(Integer.valueOf(r116)) == true) goto L39;
    L95:
        JSONObject r107 = new JSONObject();     // Catch: JSONException -> L46 Exception -> L92
        r107.put("event_scene", "response");     // Catch: JSONException -> L46 Exception -> L92
        r107.put("motion_types", f());     // Catch: JSONException -> L46 Exception -> L92
        if (r101 != null) goto L44;
        EventLogUtils.onEvent(EventConstant.Event.CERT_MOTION_TYPES, r107);     // Catch: JSONException -> L46 Exception -> L92
    L48:
        int r108 = r114.optInt("beauty_intensity", -1);     // Catch: Exception -> L92
        if (r108 < 0) goto L53;
        if (r101 != null) goto L52;
        BytedCertManager.getInstance().getThemeConfig().setBeautyIntensity(r108);     // Catch: Exception -> L92
        goto L53
    L52:
        r101.getThemeConfig().setBeautyIntensity(r108);     // Catch: Exception -> L92
    L53:
        String r109 = r114.optString(BytedCertConstant.CertKey.LIVE_TYPE);     // Catch: Exception -> L92
        this.f407582g = r109;     // Catch: Exception -> L92
        if (TextUtils.isEmpty(r109) == false) goto L63;
        if (r101 != null) goto L57;
        b r119 = null;
    L58:
        if (r119 != null) goto L60;
        String r120 = null;
    L61:
        this.f407582g = r120;     // Catch: Exception -> L92
        goto L63
    L60:
        r120 = r119.f526574h;     // Catch: Exception -> L92
        goto L61
    L57:
        r119 = r101.getCertInfo();     // Catch: Exception -> L92
    L63:
        if (TextUtils.isEmpty(this.f407582g) == false) goto L65;
        this.f407582g = BytedCertConstant.LiveType.LIVE_TYPE_ACTION;     // Catch: Exception -> L92
    L65:
        this.f407583h = r114.optString("random_number");     // Catch: Exception -> L92
        this.f407584i = r114.optBoolean("log_mode");     // Catch: Exception -> L92
        this.f407585j = r114.optBoolean("log_mode_v3");     // Catch: Exception -> L92
        r114.optInt("security_mode");     // Catch: Exception -> L92
        this.f407586k = r114.optBoolean("enable_voice");     // Catch: Exception -> L92
        this.f407588m = r114.optBoolean("enable_extreme_img");     // Catch: Exception -> L92
        JSONObject r121 = new JSONObject(r114.optString("extra"));     // Catch: JSONException -> L68 Exception -> L92
    L70:
        if (r121.has("r") == false) goto L73;
        this.f407589n.parse(r121.optJSONObject("r"));     // Catch: Exception -> L92
    L73:
        if (r121.has(BdpAppEventConstant.PARAMS_UNIQUEID) == false) goto L76;
        this.f407597v = r121.optString(BdpAppEventConstant.PARAMS_UNIQUEID, "");     // Catch: Exception -> L92
    L76:
        if (r121.has("enable_smash_sign") == false) goto L79;
        this.f407598w = r121.optBoolean("enable_smash_sign");     // Catch: Exception -> L92
    L79:
        if (r121.has(BytedCertConstant.LivenessInfoConfigKey.KEY) == false) goto L81;
        this.f407590o = LivenessInfoConfig.obtain(r121.optJSONObject(BytedCertConstant.LivenessInfoConfigKey.KEY));     // Catch: Exception -> L92
    L81:
        LivenessInfoConfig r122 = this.f407590o;     // Catch: Exception -> L92
        if ((r122 instanceof LivenessInfoConfig.WbConfig) == false) goto L90;
        LivenessInfoConfig.WbConfig r123 = (LivenessInfoConfig.WbConfig) r122;     // Catch: Exception -> L92
        boolean r124 = true;
        if (r114.optInt("enable_auto_blue", 0) != 1) goto L86;
    L89:
        r123.autoBlue = r124;     // Catch: Exception -> L92
        goto L90
    L86:
        if (r114.optBoolean("enable_auto_blue", false) == true) goto L89;
        r124 = false;
    L90:
        this.f407594s = r114.optInt("auto_retry_count");     // Catch: Exception -> L92
        this.f407591p = r114.optBoolean("show_retain");     // Catch: Exception -> L92
        this.f407595t = r114.optBoolean("retry_opt");     // Catch: Exception -> L92
        this.f407596u = r114.optBoolean("force_max_brightness");     // Catch: Exception -> L92
        this.C = r114.optBoolean("enable_face_detect_info", false);     // Catch: Exception -> L92
        this.D = r114.optBoolean("disable_screen_record", false);     // Catch: Exception -> L92
        return;
    L68:
        r121 = new JSONObject();     // Catch: Exception -> L92
        goto L70
    L44:
        r101.onEvent(EventConstant.Event.CERT_MOTION_TYPES, r107);     // Catch: JSONException -> L46 Exception -> L92
    L46:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L92
        goto L48
    L18:
        int r125 = r103.size();     // Catch: Exception -> L92
        this.f407592q = new int[r125];     // Catch: Exception -> L92
        int r126 = 0;
    L19:
        if (r126 >= r125) goto L30;
        int r127 = ((Integer) ListProtector.get(r102, r126)).intValue();     // Catch: Exception -> L92
        this.f407592q[r126] = r127;     // Catch: Exception -> L92
        if (this.B.isEmpty() == false) goto L24;
        List<Integer> r128 = this.f407600y;     // Catch: Exception -> L92
        ArrayList r129 = (ArrayList) r128;     // Catch: Exception -> L92
        r129.add(Integer.valueOf(r127));     // Catch: Exception -> L92
    L29:
        r126 = r126 + 1;     // Catch: Exception -> L92
        goto L19
    L24:
        if ((((ArrayList) this.f407600y).size() + this.B.size()) < r125) goto L27;
        List<Integer> r130 = this.f407601z;     // Catch: Exception -> L92
        ArrayList r131 = (ArrayList) r130;     // Catch: Exception -> L92
        r131.add(Integer.valueOf(r127));     // Catch: Exception -> L92
        goto L29
    L27:
        if (this.B.contains(Integer.valueOf(r127)) == true) goto L29;
        List<Integer> r132 = this.f407600y;     // Catch: Exception -> L92
        ArrayList r133 = (ArrayList) r132;     // Catch: Exception -> L92
        r133.add(Integer.valueOf(r127));     // Catch: Exception -> L92
        goto L29
    L109:
        return;
    L108:
        return;
    L107:
        return;
    L9:
        r101 = null;
        goto L10
    L5:
        this.B = r112.B;
        this.E = r112.E;
        goto L6
    }
}
