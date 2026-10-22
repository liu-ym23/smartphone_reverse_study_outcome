package v9a;

import android.content.Context;
import android.os.Build;
import com.google.gson.Gson;
import com.obric.aiagent.platform.depend.IBuildContext;
import com.obric.aiagent.platform.depend.ICloudConfig;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.feature.FeatureConfig;
import com.obric.aiagent.product.feature.FeatureListConfig;
import com.obric.aiagent.product.feature.ProductInfoConfig;
import com.obric.aiagent.product.feature.ProductSpecialConfig;
import com.obric.aiagent.product.platform.api.rom.RomInfo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class f implements u9a.a {
    public static final a h = null;
    public static final Lazy<f> i = null;
    public Map<String, ProductInfoConfig> b;
    public FeatureListConfig c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;

    public static final class a {
        public final synchronized f a() {
            monitor-enter(this);
            f r0 = f.i.getValue();     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public a() {
        }
    }

    static {
        h = new a();
        i = LazyKt.lazy(new e());
    }

    private final Context getContext() {
        return (Context) this.f.getValue();
    }

    @Override // u9a.a
    public final boolean a() {
        String r0 = IBuildContext.a.a();
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return true;
    L9:
        if (r0.length() <= 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == true) goto L14;
        return false;
    L14:
        if (StringsKt.startsWith$default(r0, "obric", false, 2, null) == false) goto L18;
        return true;
    L18:
        return false;
    L11:
        r2 = false;
        goto L12
    L5:
        r1 = false;
        goto L6
    }

    @Override // u9a.a
    public final boolean b() {
        return ((Boolean) this.d.getValue()).booleanValue();
    }

    @Override // u9a.a
    public final String d() {
        String r0 = (String) this.g.getValue();
        switch(r0.hashCode()) {
            case -2002884280: goto L24;
            case -2002884275: goto L21;
            case -1048984789: goto L18;
            case -807117175: goto L14;
            case -80147032: goto L11;
            case 3440915: goto L8;
            case 1336193813: goto L5;
            default: goto L255;
        };
    L5:
        String r1 = "emulator";
        if (r0.equals("emulator") == true) goto L28;
        r1 = "unknown";
    L28:
        if (Intrinsics.areEqual(r1, "nerida") == true) goto L30;
    L34:
        ILogDepend.a.d("FeatureServiceImpl", "getObricProductName, osProductName=" + ((String) this.g.getValue()) + ", productName=" + r1);
        if (Intrinsics.areEqual(r1, "unknown") == true) goto L37;
        return r1;
    L37:
        Iterator<Map.Entry<String, ProductInfoConfig>> r2 = this.b.entrySet().iterator();
    L39:
        if (r2.hasNext() == false) goto L221;
        Map.Entry<String, ProductInfoConfig> r3 = r2.next();
        ILogDepend.Companion r9 = ILogDepend.a;
        StringBuilder r10 = new StringBuilder("getObricProductName, key: ");
        r10.append(r3.getKey());
        r10.append(", manufacturer: ");
        r10.append(r3.getValue().getManufacturer());
        r10.append(", brand: ");
        r10.append(r3.getValue().getBrand());
        r10.append(", model: ");
        r10.append(r3.getValue().getModel());
        r10.append(", device: ");
        r10.append(r3.getValue().getDevice());
        r10.append(" , ");
        List<String> r11 = r3.getValue().getDevice();
        boolean r12 = false;
        if (r11 != null) goto L43;
    L46:
        boolean r13 = true;
    L47:
        r10.append(r13);
        r10.append(", name:");
        r10.append(r3.getValue().getName());
        r10.append(", ");
        List<String> r14 = r3.getValue().getName();
        if (r14 != null) goto L50;
    L53:
        boolean r15 = true;
    L54:
        r10.append(r15);
        r10.append(", policy: ");
        r10.append(r3.getValue().getPolicy());
        r9.i("FeatureServiceImpl", r10.toString());
        if (Intrinsics.areEqual(r3.getValue().getPolicy(), "and") == true) goto L56;
        if (Intrinsics.areEqual(r3.getValue().getPolicy(), "or") == false) goto L39;
        List<String> r4 = r3.getValue().getManufacturer();
        if (r4 != null) goto L149;
    L152:
        boolean r5 = true;
    L153:
        if (r5 == true) goto L161;
        List<String> r6 = r3.getValue().getManufacturer();
        if (r6 != null) goto L157;
    L159:
        boolean r7 = false;
    L160:
        if (r7 == false) goto L161;
    L220:
        r9.i("FeatureServiceImpl", "getObricProductName or, key: " + r3.getKey() + ", manufacturer: " + r3.getValue().getManufacturer() + ", brand: " + r3.getValue().getBrand() + ", model: " + r3.getValue().getModel() + ", device: " + r3.getValue().getDevice());
        r1 = r3.getKey();
        goto L39
    L157:
        if (r6.contains(Build.MANUFACTURER) != true) goto L159;
        r7 = true;
    L161:
        List<String> r8 = r3.getValue().getBrand();
        if (r8 != null) goto L164;
    L167:
        boolean r16 = true;
    L168:
        if (r16 == true) goto L176;
        List<String> r17 = r3.getValue().getBrand();
        if (r17 != null) goto L172;
    L174:
        boolean r18 = false;
    L175:
        if (r18 == true) goto L220;
    L172:
        if (r17.contains(Build.BRAND) != true) goto L174;
        r18 = true;
    L176:
        List<String> r19 = r3.getValue().getModel();
        if (r19 != null) goto L179;
    L182:
        boolean r20 = true;
    L183:
        if (r20 == true) goto L191;
        List<String> r21 = r3.getValue().getModel();
        if (r21 != null) goto L187;
    L189:
        boolean r22 = false;
    L190:
        if (r22 == true) goto L220;
    L187:
        if (r21.contains(Build.MODEL) != true) goto L189;
        r22 = true;
    L191:
        List<String> r23 = r3.getValue().getName();
        if (r23 != null) goto L194;
    L197:
        boolean r24 = true;
    L198:
        if (r24 == true) goto L206;
        List<String> r25 = r3.getValue().getName();
        if (r25 != null) goto L202;
    L204:
        boolean r26 = false;
    L205:
        if (r26 == true) goto L220;
    L202:
        if (r25.contains(Build.PRODUCT) != true) goto L204;
        r26 = true;
    L206:
        List<String> r28 = r3.getValue().getDevice();
        if (r28 != null) goto L209;
    L212:
        boolean r29 = true;
    L213:
        if (r29 == true) goto L39;
        List<String> r30 = r3.getValue().getDevice();
        if (r30 != null) goto L217;
    L219:
        if (r12 == false) goto L39;
    L217:
        if (r30.contains(Build.DEVICE) != true) goto L219;
        r12 = true;
        goto L219
    L209:
        if (r28.isEmpty() == true) goto L212;
        r29 = false;
        goto L213
    L194:
        if (r23.isEmpty() == true) goto L197;
        r24 = false;
        goto L198
    L179:
        if (r19.isEmpty() == true) goto L182;
        r20 = false;
        goto L183
    L164:
        if (r8.isEmpty() == true) goto L167;
        r16 = false;
        goto L168
    L149:
        if (r4.isEmpty() == true) goto L152;
        r5 = false;
        goto L153
    L56:
        List<String> r110 = r3.getValue().getManufacturer();
        if (r110 != null) goto L59;
    L62:
        boolean r111 = true;
    L63:
        if (r111 == true) goto L71;
        List<String> r112 = r3.getValue().getManufacturer();
        if (r112 != null) goto L67;
    L69:
        boolean r113 = false;
    L70:
        if (r113 == false) goto L39;
    L67:
        if (r112.contains(Build.MANUFACTURER) != true) goto L69;
        r113 = true;
    L71:
        List<String> r114 = r3.getValue().getBrand();
        if (r114 != null) goto L74;
    L77:
        boolean r115 = true;
    L78:
        if (r115 == true) goto L86;
        List<String> r116 = r3.getValue().getBrand();
        if (r116 != null) goto L82;
    L84:
        boolean r117 = false;
    L85:
        if (r117 == false) goto L39;
    L82:
        if (r116.contains(Build.BRAND) != true) goto L84;
        r117 = true;
    L86:
        List<String> r118 = r3.getValue().getModel();
        if (r118 != null) goto L89;
    L92:
        boolean r119 = true;
    L93:
        if (r119 == true) goto L101;
        List<String> r120 = r3.getValue().getModel();
        if (r120 != null) goto L97;
    L99:
        boolean r121 = false;
    L100:
        if (r121 == false) goto L39;
    L97:
        if (r120.contains(Build.MODEL) != true) goto L99;
        r121 = true;
    L101:
        List<String> r122 = r3.getValue().getName();
        if (r122 != null) goto L104;
    L107:
        boolean r123 = true;
    L108:
        if (r123 == true) goto L116;
        List<String> r124 = r3.getValue().getName();
        if (r124 != null) goto L112;
    L114:
        boolean r125 = false;
    L115:
        if (r125 == false) goto L39;
    L112:
        if (r124.contains(Build.PRODUCT) != true) goto L114;
        r125 = true;
    L116:
        List<String> r126 = r3.getValue().getDevice();
        if (r126 != null) goto L119;
    L122:
        boolean r127 = true;
    L123:
        if (r127 == true) goto L131;
        List<String> r128 = r3.getValue().getDevice();
        if (r128 != null) goto L127;
    L129:
        boolean r129 = false;
    L130:
        if (r129 == false) goto L39;
    L127:
        if (r128.contains(Build.DEVICE) != true) goto L129;
        r129 = true;
    L131:
        StringBuilder r31 = new StringBuilder("getObricProductName and, key: ");
        r31.append(r3.getKey());
        r31.append(", manufacturer: ");
        r31.append(r3.getValue().getManufacturer());
        r31.append(", brand: ");
        r31.append(r3.getValue().getBrand());
        r31.append(", model: ");
        r31.append(r3.getValue().getModel());
        r31.append(", device: ");
        List<String> r32 = r3.getValue().getDevice();
        if (r32 != null) goto L134;
    L137:
        boolean r33 = true;
    L138:
        r31.append(r33);
        r31.append(", name: ");
        List<String> r34 = r3.getValue().getName();
        if (r34 != null) goto L141;
    L142:
        r12 = true;
    L143:
        r31.append(r12);
        r9.i("FeatureServiceImpl", r31.toString());
        r1 = r3.getKey();
        goto L39
    L141:
        if (r34.isEmpty() == false) goto L143;
    L134:
        if (r32.isEmpty() == true) goto L137;
        r33 = false;
        goto L138
    L119:
        if (r126.isEmpty() == true) goto L122;
        r127 = false;
        goto L123
    L104:
        if (r122.isEmpty() == true) goto L107;
        r123 = false;
        goto L108
    L89:
        if (r118.isEmpty() == true) goto L92;
        r119 = false;
        goto L93
    L74:
        if (r114.isEmpty() == true) goto L77;
        r115 = false;
        goto L78
    L59:
        if (r110.isEmpty() == true) goto L62;
        r111 = false;
        goto L63
    L50:
        if (r14.isEmpty() == true) goto L53;
        r15 = false;
        goto L54
    L43:
        if (r11.isEmpty() == true) goto L46;
        r13 = false;
        goto L47
    L221:
        ILogDepend.Companion r35 = ILogDepend.a;
        StringBuilder r36 = new StringBuilder("getObricProductName, productName: ");
        String r37 = r1;
        r36.append(r37);
        r36.append(", manufacturer: ");
        r36.append(Build.MANUFACTURER);
        r36.append(", brand: ");
        r36.append(Build.BRAND);
        r36.append(", model: ");
        r36.append(Build.MODEL);
        r36.append(", device: ");
        r36.append(Build.DEVICE);
        r36.append(", name: ");
        r36.append(Build.PRODUCT);
        r35.i("FeatureServiceImpl", r36.toString());
        return r37;
    L30:
        if (Build.VERSION.SDK_INT < 31) goto L34;
        if (Intrinsics.areEqual(Build.SOC_MODEL, "SM8845") == false) goto L34;
        r1 = "nerida-lite";
        goto L34
    L8:
        r1 = "pike";
        if (r0.equals("pike") == true) goto L28;
        r1 = "unknown";
        goto L28
    L11:
        r1 = "genesis";
        if (r0.equals("genesis") == true) goto L28;
        r1 = "unknown";
        goto L28
    L14:
        r1 = "pacific";
        if (r0.equals("pacific") == true) goto L28;
        r1 = "unknown";
        goto L28
    L21:
        r1 = "Genesis-R";
        if (r0.equals("Genesis-R") == true) goto L28;
        r1 = "unknown";
        goto L28
    L24:
        r1 = "Genesis-M";
        if (r0.equals("Genesis-M") == true) goto L28;
        r1 = "unknown";
        goto L28
    L255:
        r1 = "unknown";
        goto L28
    L18:
        if (r0.equals("nerida") == false) goto L259;
        r1 = "nerida";
        goto L28
    L259:
        r1 = "unknown";
        goto L28
    }

    @Override // u9a.a
    public final boolean e() {
        return ((Boolean) this.e.getValue()).booleanValue();
    }

    @Override // u9a.a
    public final boolean f() {
        return c("obric_feature_global_effect_stop_layer_effective");
    }

    public final void i() {
        Object r0 = XmlPullParser.NO_NAMESPACE;
        ILogDepend.a.i("FeatureServiceImpl", "initProductInfo");
        Gson r4 = new Gson();     // Catch: Exception -> L46
        Type r5 = new g().getType();     // Catch: Exception -> L46
        JSONObject r7 = h("default_product_info.json");     // Catch: Exception -> L46
        if (r7 == null) goto L7;
        String r8 = r7.toString();     // Catch: Exception -> L46
        if (r8 == null) goto L7;
    L56:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L10
        Object r10 = Result.m49constructorimpl((Map) r4.fromJson(r8, r5));     // Catch: Throwable -> L10
    L12:
        Map r11 = MapsKt.emptyMap();     // Catch: Exception -> L46
        if (Result.m55isFailureimpl(r10) == false) goto L15;
        r10 = r11;
    L15:
        Map<String, ProductInfoConfig> r12 = (Map) r10;     // Catch: Exception -> L46
        ILogDepend.a.d("FeatureServiceImpl", "init obric product info, defaultProductMap: " + r12 + ", json: " + r8);     // Catch: Exception -> L46
        JSONObject r3 = ICloudConfig.a.a("obric_product_info_config");     // Catch: Throwable -> L24
        if (r3 == null) goto L19;
        String r6 = r3.toString();     // Catch: Throwable -> L24
    L20:
        if (r6 != null) goto L22;
        r6 = XmlPullParser.NO_NAMESPACE;
    L22:
        Object r13 = Result.m49constructorimpl(r6);     // Catch: Throwable -> L24
    L27:
        if (Result.m55isFailureimpl(r13) == true) goto L30;
        r0 = r13;
    L30:
        String r1 = (String) r0;     // Catch: Exception -> L46
        ILogDepend.a.i("FeatureServiceImpl", "init obric product info, cloudJsonStr: " + r1);     // Catch: Exception -> L46
        if (r1.length() <= 0) goto L33;
        boolean r2 = true;
    L34:
        if (r2 == true) goto L50;
        this.b = r12;     // Catch: Exception -> L46
    L44:
        ILogDepend.a.i("FeatureServiceImpl", "init obric product info, productMap: " + this.b);     // Catch: Exception -> L46
    L48:
        j();
        return;
    L50:
        Object r14 = Result.m49constructorimpl((Map) r4.fromJson(r1, r5));     // Catch: Throwable -> L37
    L39:
        Map r15 = MapsKt.emptyMap();     // Catch: Exception -> L46
        if (Result.m55isFailureimpl(r14) == false) goto L42;
        r14 = r15;
    L42:
        this.b = MapsKt.plus(r12, (Map) r14);     // Catch: Exception -> L46
        goto L44
    L37:
        th = move-exception;
        Result.Companion r16 = Result.Companion;     // Catch: Exception -> L46
        r14 = Result.m49constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L46
        goto L39
    L33:
        r2 = false;
        goto L34
    L19:
        r6 = null;
    L24:
        th = move-exception;
        Result.Companion r17 = Result.Companion;     // Catch: Exception -> L46
        r13 = Result.m49constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L46
        goto L27
    L10:
        th = move-exception;
        Result.Companion r18 = Result.Companion;     // Catch: Exception -> L46
        r10 = Result.m49constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L46
    L7:
        r8 = "{}";
    L46:
        e = move-exception;
        ILogDepend.a.e("FeatureServiceImpl", "int obric product info failed, ", e);
        goto L48
    }

    public final void j() {
        ILogDepend.Companion r1 = ILogDepend.a;
        r1.i("FeatureServiceImpl", "initFeatureInfo");
    L11:
        e = move-exception;
        ILogDepend.a.e("FeatureServiceImpl", "int obric feature info failed, ", e);
        return;
    L4:
        if (this.c == null) goto L6;
        return;
    L6:
        JSONObject r2 = h("default_feature_config.json");     // Catch: Exception -> L11
        if (r2 != null) goto L9;
        r2 = new JSONObject();     // Catch: Exception -> L11
    L9:
        this.c = (FeatureListConfig) new Gson().fromJson(r2.toString(), FeatureListConfig.class);     // Catch: Exception -> L11
        r1.d("FeatureServiceImpl", "init obric feature info, featureListConfigBoolean: " + this.c + ", json: " + r2);     // Catch: Exception -> L11
    }

    public f() {
        this.b = MapsKt.emptyMap();
        this.d = LazyKt.lazy(new v9a.a());
        this.e = LazyKt.lazy(new b());
        this.f = LazyKt.lazy(new c());
        this.g = LazyKt.lazy(new d());
    }

    @Override // u9a.a
    public final String g() {
        if (a() == false) goto L5;
        String r0 = IBuildContext.a.a();
        if (r0.length() != 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        r0 = "obric";
    L13:
        return r0 + '_' + Build.BRAND + '_' + Build.MODEL;
    L9:
        r1 = false;
        goto L10
    L5:
        return IBuildContext.a.a();
    }

    @Override // u9a.a
    public final boolean c(String r25) {
        Intrinsics.checkNotNullParameter(r25, "featureKey");
        Object r6 = null;
        FeatureConfig r7 = null;
        r7 = null;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        JSONObject r1 = ICloudConfig.a.a(r25);     // Catch: Throwable -> L11
        if (r1 == null) goto L6;
        String r2 = r1.toString();     // Catch: Throwable -> L11
    L7:
        if (r2 != null) goto L9;
        r2 = XmlPullParser.NO_NAMESPACE;
    L9:
        Object r3 = Result.m49constructorimpl(r2);     // Catch: Throwable -> L11
    L13:
        Throwable r8 = Result.m52exceptionOrNullimpl(r3);     // Catch: Exception -> L105
        if (r8 == null) goto L18;
        ILogDepend.a.e("FeatureServiceImpl", "isFeatureEnable, featureKey: " + r25 + ", ICloudConfig.Companion.getSettingsConfig() failed, " + r8.getMessage(), r8);     // Catch: Exception -> L105
    L18:
        if (Result.m55isFailureimpl(r3) == false) goto L20;
        r3 = null;
    L20:
        String r4 = (String) r3;     // Catch: Exception -> L105
        if (r4 != null) goto L23;
    L28:
        boolean r10 = false;
    L29:
        if (r10 == false) goto L40;
        Object r5 = Result.m49constructorimpl((FeatureConfig) new Gson().fromJson(r4, FeatureConfig.class));     // Catch: Throwable -> L32
    L35:
        if (Result.m55isFailureimpl(r5) == true) goto L38;
        r6 = r5;
    L38:
        r7 = (FeatureConfig) r6;     // Catch: Exception -> L105
    L47:
        ILogDepend.Companion r9 = ILogDepend.a;     // Catch: Exception -> L105
        r9.i("FeatureServiceImpl", "isFeatureEnable, featureKey: " + r25 + ", featureConfig: " + r7);     // Catch: Exception -> L105
        if (r7 != null) goto L53;
        r9.i("FeatureServiceImpl", "isFeatureEnable return false, featureKey: " + r25 + ", featureConfig is null");     // Catch: Exception -> L105
        return false;
    L53:
        if (r7.getEnabled() == true) goto L56;
        r9.i("FeatureServiceImpl", "isFeatureEnable return false, featureKey: " + r25 + ", featureConfig.enabled is false");     // Catch: Exception -> L105
        return false;
    L56:
        String r11 = d();     // Catch: Exception -> L105
        if (r7.getProductWhiteList().contains(r11) == false) goto L61;
        r9.d("FeatureServiceImpl", "isFeatureEnable return true, featureKey: " + r25 + ", is in productWhiteList, productName: " + r11);     // Catch: Exception -> L105
        return true;
    L61:
        if (r7.getProductBlackList().contains(r11) == false) goto L64;
        r9.d("FeatureServiceImpl", "isFeatureEnable return false, featureKey: " + r25 + ", is in productBlackList, productName: " + r11);     // Catch: Exception -> L105
        return false;
    L64:
        iaa.b r12 = iaa.b.a;     // Catch: Exception -> L105
        List<String> r13 = r7.getDependencyOsFeatureList();     // Catch: Exception -> L105
        r12.getClass();     // Catch: Exception -> L105
        if (iaa.b.c(r13) == true) goto L69;
        r9.i("FeatureServiceImpl", "isFeatureEnable return false, featureKey: " + r25 + ", os is not supported, dependencyOsFeatureList: " + r7.getDependencyOsFeatureList() + ", productName: " + r11);     // Catch: Exception -> L105
        return false;
    L69:
        Map<String, ProductSpecialConfig> r14 = r7.getProductSpecialList().get(r11);     // Catch: Exception -> L105
        if (r14 != null) goto L75;
        r9.i("FeatureServiceImpl", "isFeatureEnable return defaultState, featureKey: " + r25 + ", defaultState: " + r7.getDefaultState() + ", productName: " + r11);     // Catch: Exception -> L105
        if (Intrinsics.areEqual(r7.getDefaultState(), "enabled") == false) goto L74;
        return true;
    L74:
        return false;
    L75:
        String r15 = Build.MODEL;     // Catch: Exception -> L105
        ProductSpecialConfig r16 = r14.get(r15);     // Catch: Exception -> L105
        if (r16 != null) goto L79;
        r9.i("FeatureServiceImpl", "isFeatureEnable return false, featureKey: " + r25 + ", modelSpecialConfig is null, model: " + r15 + ", productName: " + r11);     // Catch: Exception -> L105
        return false;
    L79:
        String r17 = r16.getMinRomVersion();     // Catch: Exception -> L105
        String r18 = r16.getMaxRomVersion();     // Catch: Exception -> L105
        RomInfo r19 = RomInfo.a;     // Catch: Exception -> L105
        String r110 = r19.b();     // Catch: Exception -> L105
        long r111 = iaa.d.a(r110);     // Catch: Exception -> L105
        long r112 = iaa.d.a(r17);     // Catch: Exception -> L105
        long r20 = iaa.d.a(r18);     // Catch: Exception -> L105
        if (r16.getRomVersionBlackList().contains(r110) == false) goto L82;
    L103:
        r9.i("FeatureServiceImpl", "isFeatureEnable return false, featureKey: " + r25 + ", osVersion: " + r110 + " is in romVersionBlackList, model: " + r15 + ", productName: " + r11);     // Catch: Exception -> L105
        return false;
    L82:
        if (r112 <= 0) goto L86;
        if (r111 < r112) goto L103;
    L86:
        if (r20 > 0) goto L88;
    L90:
        int r21 = r19.c();     // Catch: Exception -> L105
        long r113 = r16.getMinRomReleaseDate();     // Catch: Exception -> L105
        long r22 = r16.getMaxRomReleaseDate();     // Catch: Exception -> L105
        r9.d("FeatureServiceImpl", "isFeatureEnable, featureKey: " + r25 + ", osReleaseDate: " + r21 + ", minRomReleaseDate: " + r113 + ", maxRomReleaseDate: " + r22);     // Catch: Exception -> L105
        if (r113 <= 0) goto L95;
        if (r21 >= r113) goto L95;
    L101:
        return false;
    L95:
        if (1 <= r22) goto L97;
    L99:
        boolean r23 = false;
    L100:
        if (r23 == true) goto L101;
        return true;
    L97:
        if (r22 >= r21) goto L99;
        r23 = true;
        goto L100
    L88:
        if (r111 <= r20) goto L90;
    L32:
        th = move-exception;
        Result.Companion r114 = Result.Companion;     // Catch: Exception -> L105
        r5 = Result.m49constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L105
        goto L35
    L40:
        if (this.c != null) goto L42;
        j();     // Catch: Exception -> L105
    L42:
        FeatureListConfig r24 = this.c;     // Catch: Exception -> L105
        if (r24 == null) goto L47;
        Map<String, FeatureConfig> r26 = r24.getFeatureConfigs();     // Catch: Exception -> L105
        if (r26 == null) goto L47;
        r7 = r26.get(r25);     // Catch: Exception -> L105
        goto L47
    L23:
        if (r4.length() <= 0) goto L25;
        boolean r115 = true;
    L26:
        if (r115 != true) goto L28;
        r10 = true;
        goto L29
    L25:
        r115 = false;
        goto L26
    L6:
        r2 = null;
    L105:
        e = move-exception;
        ILogDepend.a.e("FeatureServiceImpl", "isFeatureEnable failed, featureKey: ".concat(r25), e);
        return false;
    L11:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Exception -> L105
        r3 = Result.m49constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L105
        goto L13
    }

    public final JSONObject h(String r5) {
        Reader r2 = new InputStreamReader(getContext().getAssets().open(r5), Charsets.UTF_8);     // Catch: Throwable -> L16
        if ((r2 instanceof BufferedReader) == false) goto L7;
        BufferedReader r3 = (BufferedReader) r2;     // Catch: Throwable -> L16
    L19:
        String r6 = TextStreamsKt.readText(r3);     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r3, null);     // Catch: Throwable -> L16
        return new JSONObject(r6);
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L7:
        r3 = new BufferedReader(r2, 8192);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        ILogDepend.a.e("FeatureServiceImpl", "load settings failed", th);
        return null;
    }
}
