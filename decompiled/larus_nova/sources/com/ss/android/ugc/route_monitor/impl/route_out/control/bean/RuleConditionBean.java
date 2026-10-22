package com.ss.android.ugc.route_monitor.impl.route_out.control.bean;

import android.net.Uri;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.heytap.mcssdk.constant.b;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.route_monitor.impl.route_out.control.j;
import com.ss.android.ugc.route_monitor.impl.route_out.control.n;
import com.ss.android.ugc.route_monitor.impl.route_out.control.o;
import com.ss.android.ugc.route_monitor.utils.Logger;
import com.ss.android.ugc.route_monitor.utils.p;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u0000 /2\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b-\u0010.J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0001H\u0002J\"\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0002J\"\u0010\u000e\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J$\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0001H\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\u0016\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bJ\u000f\u0010!\u001a\u00020\u001eH\u0000¢\u0006\u0004\b\u001f\u0010 R$\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\f\u0010'\u001a\u0004\b(\u0010)R(\u0010\n\u001a\u0004\u0018\u00010\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u00018\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\n\u0010*\u001a\u0004\b+\u0010,¨\u00061"}, d2 = {"Lcom/ss/android/ugc/route_monitor/impl/route_out/control/bean/RuleConditionBean;", "", "Lcom/ss/android/ugc/route_monitor/impl/route_out/control/bean/ControlRule;", b.f276366p, "", "stringValue", "", "matchStringValue", "valueAny", "matchListValue", "value", "", WikiFolderPushPlugin.OPT, "getOperationResultByIn", "getOperationResultByNotIn", "", "longValue", "matchLongValue", "booleanValue", "matchBooleanValue", "", "mapValue", "matchMapValue", "matchValue", "commonEqualMatch", "isCommonEqualMatchOperation", "isEqualOperation", "Lcom/ss/android/ugc/route_monitor/impl/route_out/control/o;", "routeOutInfo", "match", "Lorg/json/JSONObject;", "toJsonObject$route_monitor_release", "()Lorg/json/JSONObject;", "toJsonObject", "<set-?>", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "I", "getOperation", "()I", "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "route-monitor_release"}, k = 1, mv = {1, 4, 0})
public final class RuleConditionBean {
    public static final String ANDROID_INTENT_ACTION_KEY = "androidIntentAction";
    public static final String APP_ID_KEY = "appId";
    public static final String BIZ_DATA_KEY = "bizData";
    public static final String CERT_ID_KEY = "certId";
    public static final a Companion = null;
    public static final String FROM_SCENE_KEY = "fromScene";
    public static final String LAST_CERT_ID_KEY = "lastCertId";
    public static final String OPEN_URL_KEY = "openUrl";
    private static final int OPERATION_EQUAL = 5;
    private static final int OPERATION_GREAT_EQUAL_THAN = 2;
    private static final int OPERATION_GREAT_THAN = 1;
    private static final int OPERATION_IN = 7;
    private static final int OPERATION_IN_STRING_CONTAINS = 12;
    private static final int OPERATION_IN_STRING_END_WITH = 14;
    private static final int OPERATION_IN_STRING_START_WITH = 13;
    private static final int OPERATION_LESS_EQUAL_THAN = 4;
    private static final int OPERATION_LESS_THAN = 3;
    private static final int OPERATION_NOT_EQUAL = 6;
    private static final int OPERATION_NOT_IN = 8;
    private static final int OPERATION_NOT_IN_STRING_CONTAINS = 15;
    private static final int OPERATION_NOT_IN_STRING_END_WITH = 17;
    private static final int OPERATION_NOT_IN_STRING_START_WITH = 16;
    private static final int OPERATION_NO_CHECK = 0;
    private static final int OPERATION_STRING_CONTAINS = 9;
    private static final int OPERATION_STRING_END_WITH = 11;
    private static final int OPERATION_STRING_START_WITH = 10;
    public static final String OS_KEY = "os";
    public static final String PRODUCT_DIVERSION = "productDiversion";
    public static final String SCHEME_KEY = "scheme";
    public static final String TARGET_APP_KEY = "targetAppAndroid";
    public static final String VERSION_CODE_KEY = "versionCode";
    private String key;
    private int operation;
    private Object value;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private final boolean isCommonEqualMatchOperation() {
        int r100 = this.operation;
        if (isEqualOperation() == false) goto L5;
    L10:
        return true;
    L5:
        if (r100 == 7) goto L10;
        if (r100 == 8) goto L10;
        return false;
    }

    private final boolean isEqualOperation() {
        int r100 = this.operation;
        if (r100 != 5) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 6) goto L8;
        return false;
    }

    public final JSONObject toJsonObject$route_monitor_release() {
        JSONObject r100 = new JSONObject();
        r100.put("key", this.key);     // Catch: Throwable -> L17
        r100.put(WikiFolderPushPlugin.OPT, this.operation);     // Catch: Throwable -> L17
        Object r101 = this.value;     // Catch: Throwable -> L17
        if ((r101 instanceof List) == false) goto L7;
        r101 = p.b((List) r101);     // Catch: Throwable -> L17
    L15:
        r100.put("value", r101);     // Catch: Throwable -> L17
    L19:
        return r100;
    L7:
        if ((r101 instanceof Map) == false) goto L13;
        if (r101 == null) goto L11;
        r101 = p.c((Map) r101);     // Catch: Throwable -> L17
        goto L15
    L11:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");     // Catch: Throwable -> L17
    L13:
        if ((r101 instanceof Integer) == false) goto L15;
        r101 = Long.valueOf(((Number) r101).intValue());     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Logger.f454747c.d(th);
        goto L19
    }

    public RuleConditionBean() {
        this.key = "";
    }

    public final String getKey() {
        return this.key;
    }

    public final int getOperation() {
        return this.operation;
    }

    public final Object getValue() {
        return this.value;
    }

    public static final /* synthetic */ String access$getKey$p(RuleConditionBean r100) {
        return r100.key;
    }

    public static final /* synthetic */ int access$getOperation$p(RuleConditionBean r100) {
        return r100.operation;
    }

    public static final /* synthetic */ Object access$getValue$p(RuleConditionBean r100) {
        return r100.value;
    }

    private final boolean commonEqualMatch(Object r100) {
        int r101 = this.operation;
        if (r101 == 5) goto L28;
        if (r101 == 6) goto L25;
        Object r102 = null;
        if (r101 != 7) goto L9;
        Object r103 = this.value;
        if ((r103 instanceof List) == false) goto L22;
        r102 = r103;
    L22:
        List r104 = (List) r102;
        if (r104 != null) goto L31;
        return false;
    L31:
        return r104.contains(r100);
    L9:
        if (r101 != 8) goto L33;
        Object r105 = this.value;
        if ((r105 instanceof List) == false) goto L15;
        r102 = r105;
    L15:
        List r106 = (List) r102;
        if (r106 == null) goto L29;
        boolean r107 = r106.contains(r100);
    L32:
        return !r107;
    L29:
        return false;
    L33:
        return false;
    L25:
        r107 = Intrinsics.areEqual(r100, this.value);
        goto L32
    L28:
        return Intrinsics.areEqual(r100, this.value);
    }

    public static final /* synthetic */ void access$setKey$p(RuleConditionBean r100, String r101) {
        r100.key = r101;
    }

    public static final /* synthetic */ void access$setOperation$p(RuleConditionBean r100, int r101) {
        r100.operation = r101;
    }

    public static final /* synthetic */ void access$setValue$p(RuleConditionBean r100, Object r101) {
        r100.value = r101;
    }

    private final boolean matchBooleanValue(ControlRule r100, boolean r101) {
        String r102 = this.key;
        int r103 = this.operation;
        Object r104 = this.value;
        Logger r105 = Logger.f454747c;
        r100.getCertId();
        r100.getRuleId();
        Objects.toString(r104);
        r105.b();
        if (isEqualOperation() == true) goto L7;
        n.a(r100, r102, r103);
        return false;
    L7:
        return commonEqualMatch(Boolean.valueOf(r101));
    }

    private final boolean matchListValue(ControlRule r100, Object r101) {
        String r102 = this.key;
        int r103 = this.operation;
        Object r104 = this.value;
        Logger r105 = Logger.f454747c;
        r100.getCertId();
        r100.getRuleId();
        Objects.toString(r104);
        Objects.toString(r101);
        r105.b();
        if ((r104 instanceof List) == true) goto L5;
        Object r106 = null;
    L6:
        List r107 = (List) r106;
        if (r107 != null) goto L11;
        n.b(r100, r102, r103, r104);
        return false;
    L11:
        if (r103 == 7) goto L22;
        if (r103 == 8) goto L19;
        switch(r103) {
            case 12: goto L25;
            case 13: goto L25;
            case 14: goto L25;
            case 15: goto L24;
            case 16: goto L24;
            case 17: goto L24;
            default: goto L15;
        };
    L15:
        n.a(r100, r102, r103);
        return false;
    L24:
        return getOperationResultByNotIn(r104, r101, r103);
    L25:
        return getOperationResultByIn(r104, r101, r103);
    L19:
        if (r107.contains(p.a(r101)) == true) goto L26;
        return true;
    L26:
        return false;
    L22:
        return r107.contains(p.a(r101));
    L5:
        r106 = r104;
        goto L6
    }

    private final boolean matchLongValue(ControlRule r100, long r101) {
        String r102 = this.key;
        int r103 = this.operation;
        Object r104 = this.value;
        Logger r105 = Logger.f454747c;
        r100.getCertId();
        r100.getRuleId();
        Objects.toString(r104);
        r105.b();
        if (isCommonEqualMatchOperation() == true) goto L43;
        Object r106 = null;
        if ((r104 instanceof Integer) == true) goto L8;
        Object r107 = null;
    L9:
        Number r108 = (Integer) r107;
        if (r108 != null) goto L17;
        if ((r104 instanceof Long) == false) goto L15;
        r106 = r104;
    L15:
        r108 = (Long) r106;
    L17:
        if (r108 != null) goto L21;
        n.b(r100, r102, r103, r104);
        return false;
    L21:
        if (r103 == 1) goto L39;
        if (r103 == 2) goto L36;
        if (r103 == 3) goto L33;
        if (r103 == 4) goto L30;
        n.a(r100, r102, r103);
    L41:
        return false;
    L30:
        if (r101 > r108.longValue()) goto L41;
    L40:
        return true;
    L33:
        if (r101 >= r108.longValue()) goto L41;
    L36:
        if (r101 < r108.longValue()) goto L41;
    L39:
        if (r101 <= r108.longValue()) goto L41;
    L8:
        r107 = r104;
        goto L9
    L43:
        return commonEqualMatch(Long.valueOf(r101));
    }

    private final boolean matchMapValue(ControlRule r100, Map<String, ? extends Object> r101) {
        String r102 = this.key;
        int r103 = this.operation;
        Object r104 = this.value;
        Logger r105 = Logger.f454747c;
        r100.getCertId();
        r100.getRuleId();
        Objects.toString(r104);
        Objects.toString(r101);
        r105.b();
        if ((r104 instanceof Map) == true) goto L5;
        Object r106 = null;
    L6:
        Map r107 = (Map) r106;
        if (r107 != null) goto L10;
        n.b(r100, r102, r103, r104);
        return false;
    L10:
        Iterator r108 = r107.entrySet().iterator();
    L12:
        if (r108.hasNext() == false) goto L16;
        Map.Entry r109 = (Map.Entry) r108.next();
        if ((!Intrinsics.areEqual(p.a(r107.get(r109.getKey())), p.a(r101.get(r109.getKey())))) == false) goto L12;
        return false;
    L16:
        return true;
    L5:
        r106 = r104;
        goto L6
    }

    private final boolean matchStringValue(ControlRule r100, String r101) {
        String r102 = this.key;
        int r103 = this.operation;
        Object r104 = this.value;
        Logger r105 = Logger.f454747c;
        r100.getCertId();
        r100.getRuleId();
        Objects.toString(r104);
        r105.b();
        if (isCommonEqualMatchOperation() == false) goto L6;
        return commonEqualMatch(r101);
    L6:
        if ((r104 instanceof String) == true) goto L8;
        Object r106 = null;
    L9:
        String r107 = (String) r106;
        if (r107 != null) goto L14;
        n.b(r100, r102, r103, r104);
        return false;
    L14:
        switch(r103) {
            case 9: goto L19;
            case 10: goto L23;
            case 11: goto L22;
            default: goto L15;
        };
    L15:
        n.a(r100, r102, r103);
        return false;
    L22:
        return StringsKt.endsWith$default(r101, r107, false, 2, null);
    L23:
        return StringsKt.startsWith$default(r101, r107, false, 2, null);
    L19:
        return StringsKt.contains$default(r101, r107, false, 2, null);
    L8:
        r106 = r104;
        goto L9
    }

    public final boolean match(ControlRule r100, o r101) {
        if (this.operation != 0) goto L5;
        return true;
    L5:
        String r102 = this.key;
        switch(r102.hashCode()) {
            case -1967941631: goto L59;
            case -1438232444: goto L55;
            case -1363895713: goto L51;
            case -1263203643: goto L41;
            case -907987547: goto L37;
            case -714528385: goto L33;
            case -98099363: goto L29;
            case 3556: goto L25;
            case 69094146: goto L21;
            case 93028124: goto L17;
            case 688591589: goto L13;
            case 1467830421: goto L9;
            default: goto L63;
        };
    L9:
        if (r102.equals(LAST_CERT_ID_KEY) == false) goto L63;
        return matchStringValue(r100, r101.f454659c.f454618a);
    L13:
        if (r102.equals(VERSION_CODE_KEY) == false) goto L63;
        return matchLongValue(r100, r101.f454663g);
    L17:
        if (r102.equals("appId") == false) goto L63;
        return matchListValue(r100, r101.f454664h);
    L21:
        if (r102.equals("fromScene") == false) goto L63;
        return matchStringValue(r100, r101.f454660d);
    L25:
        if (r102.equals("os") == false) goto L63;
        r101.getClass();
        return matchListValue(r100, "android");
    L29:
        if (r102.equals(BIZ_DATA_KEY) == false) goto L63;
        return matchMapValue(r100, r101.f454666j);
    L33:
        if (r102.equals(TARGET_APP_KEY) == false) goto L63;
        return matchListValue(r100, r101.f454661e);
    L37:
        if (r102.equals("scheme") == false) goto L63;
        return matchListValue(r100, r101.f454658b);
    L41:
        if (r102.equals(OPEN_URL_KEY) == false) goto L63;
        Uri r103 = r101.f454662f;
        if (r103 == null) goto L47;
        String r104 = r103.toString();
        if (r104 == null) goto L47;
    L49:
        return matchStringValue(r100, r104);
    L47:
        r104 = "";
        goto L49
    L51:
        if (r102.equals("certId") == false) goto L63;
        return matchListValue(r100, r101.f454659c.f454619b);
    L55:
        if (r102.equals(PRODUCT_DIVERSION) == false) goto L63;
        return matchBooleanValue(r100, r101.f454665i);
    L59:
        if (r102.equals(ANDROID_INTENT_ACTION_KEY) == false) goto L63;
        return matchListValue(r100, r101.f454657a);
    L63:
        if (j.f454635a.f514027a.contains(this.key) == true) goto L65;
        int r105 = n.f454656a;
        String r106 = this.key;
        Logger r107 = Logger.f454747c;
        r100.getRuleId();
        r107.b();
        n.c(r100, r106, null);
    L65:
        return true;
    }

    private final boolean getOperationResultByIn(Object r100, Object r101, int r102) {
        if ((r100 instanceof List) == true) goto L5;
        r100 = null;
    L5:
        List r103 = (List) r100;
        if ((r101 instanceof String) == true) goto L8;
        r101 = null;
    L8:
        String r104 = (String) r101;
        if (r103 == null) goto L27;
        if (r104 == null) goto L27;
        Iterator r105 = r103.iterator();
    L13:
        if (r105.hasNext() == false) goto L27;
        String r106 = (String) r105.next();
        if (r102 != 12) goto L18;
        boolean r107 = StringsKt.contains$default(r104, r106, false, 2, null);
    L24:
        if (r107 == false) goto L13;
        return true;
    L18:
        if (r102 != 13) goto L21;
        r107 = StringsKt.startsWith$default(r104, r106, false, 2, null);
        goto L24
    L21:
        if (r102 != 14) goto L23;
        r107 = StringsKt.endsWith$default(r104, r106, false, 2, null);
        goto L24
    L23:
        r107 = false;
    L27:
        return false;
    }

    private final boolean getOperationResultByNotIn(Object r100, Object r101, int r102) {
        if ((r100 instanceof List) == true) goto L5;
        r100 = null;
    L5:
        List r103 = (List) r100;
        if ((r101 instanceof String) == true) goto L8;
        r101 = null;
    L8:
        String r104 = (String) r101;
        if (r103 == null) goto L32;
        if (r104 == null) goto L32;
        Iterator r105 = r103.iterator();
    L13:
        if (r105.hasNext() == false) goto L32;
        String r106 = (String) r105.next();
        if (r102 != 15) goto L21;
        if (StringsKt.contains$default(r104, r106, false, 2, null) == true) goto L19;
    L18:
        boolean r107 = true;
    L30:
        if (r107 == true) goto L13;
        return false;
    L19:
        r107 = false;
        goto L30
    L21:
        if (r102 != 16) goto L26;
        if (StringsKt.startsWith$default(r104, r106, false, 2, null) == true) goto L19;
    L26:
        if (r102 != 17) goto L19;
        if (StringsKt.endsWith$default(r104, r106, false, 2, null) == true) goto L19;
    L32:
        return true;
    }
}
