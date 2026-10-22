package com.bytedance.caijing.sdk.infra.base.event;

import android.text.TextUtils;
import com.alibaba.gaiax.model.GXAnimation;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class DynamicEventTracker {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<DynamicEventTracker> f202325b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<String, ArrayList<d>> f202326c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, b> f202327a;

    /* JADX INFO: loaded from: classes15.dex */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/event/DynamicEventTracker$EventTyp;", "", "", "type", "I", "getType", "()I", GXAnimation.STATE_START, GXAnimation.STATE_END, "PROCESS", "base-context_release"}, k = 1, mv = {1, 6, 0})
    public static final enum EventTyp extends Enum<EventTyp> {
        public static final EventTyp END = null;
        public static final EventTyp PROCESS = null;
        public static final EventTyp START = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EventTyp[] f202328a = null;
        private final int type;

        public static EventTyp valueOf(String r100) {
            return (EventTyp) r27.a.a(EventTyp.class, r100);
        }

        public static EventTyp[] values() {
            return (EventTyp[]) f202328a.clone();
        }

        static {
            EventTyp r100 = new EventTyp(GXAnimation.STATE_START, 0, 1);
            START = r100;
            EventTyp r101 = new EventTyp(GXAnimation.STATE_END, 1, 2);
            END = r101;
            EventTyp r102 = new EventTyp("PROCESS", 2, 3);
            PROCESS = r102;
            f202328a = new EventTyp[]{r100, r101, r102};
        }

        public final int getType() {
            return this.type;
        }

        public EventTyp(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f202329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f202330b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f202331c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f202332d;

        public a() {
            this.f202329a = "";
            this.f202330b = "";
            EventTyp r100 = EventTyp.START;
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f202333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f202334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f202335c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ArrayList<a> f202336d;

        public b() {
            this.f202333a = "";
            this.f202334b = "";
            this.f202335c = "";
            this.f202336d = new ArrayList();
        }
    }

    public static final class c {
        @JvmStatic
        public static void b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r101, "scene");
            if (TextUtils.isEmpty(r101) == false) goto L5;
            return;
        L5:
            CJPayCallBackCenter r102 = CJPayCallBackCenter.getInstance();
            JSONObject r103 = new JSONObject();
            KtSafeMethodExtensionKt.safePut(r103, "trace_name", r101);
            Unit r104 = Unit.INSTANCE;
            r102.onEvent(r100, new JSONObject[]{r103});
        }

        @JvmStatic
        public static void a(String r100, String r101, long r110, String r111, JSONObject r112) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "name");
            Intrinsics.checkNotNullParameter(r111, SocialConstants.PARAM_APP_DESC);
            JSONObject r102 = new JSONObject();
            switch(r100.hashCode()) {
                case -1777706480: goto L35;
                case -787098428: goto L31;
                case -474236405: goto L27;
                case 883847853: goto L20;
                case 1150405419: goto L13;
                case 1746121394: goto L6;
                default: goto L41;
            };
        L41:
            r101 = "";
        L40:
            String r103 = r101;
            if (TextUtils.isEmpty(r103) == true) goto L48;
            if (r112 == null) goto L46;
            CJPayCallBackCenter.getInstance().getCjContext().c(CJPayBasicUtils.json2MapObject(r112));
        L46:
            CJReporter r104 = CJReporter.f202294a;
            CJReporter.g(CJPayCallBackCenter.getInstance().getCjContext(), r103, CJPayBasicUtils.Json2Map(r102), null, r110, false);
            return;
        L48:
            return;
        L6:
            if (r100.equals("request_start") == false) goto L41;
            if (TextUtils.isEmpty(r111) == true) goto L11;
            r101 = r111;
        L11:
            r102.put("trace_name", r101);
            r101 = "wallet_rd_common_network_start";
            goto L40
        L13:
            if (r100.equals("request_end") == false) goto L41;
            if (TextUtils.isEmpty(r111) == true) goto L18;
            r101 = r111;
        L18:
            r102.put("trace_name", r101);
            r101 = "wallet_rd_common_network_end";
            goto L40
        L20:
            if (r100.equals("page_show") == false) goto L41;
            if (TextUtils.isEmpty(r111) == true) goto L25;
            r101 = r111;
        L25:
            r102.put("trace_name", r101);
            r101 = "wallet_rd_common_page_show";
            goto L40
        L27:
            if (r100.equals(CheckPointType.PAY_START) == false) goto L41;
            r102.put("trace_name", r101);
            r101 = "wallet_rd_common_pay_start";
            goto L40
        L31:
            if (r100.equals("pay_end") == false) goto L41;
            r102.put("trace_name", r101);
            r101 = "wallet_rd_common_pay_end";
            goto L40
        L35:
            if (r100.equals("custom_node") == false) goto L41;
            if (TextUtils.isEmpty(r111) == true) goto L40;
            r102.put("trace_name", r111);
            goto L40
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f202337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f202338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f202339c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public EventTyp f202340d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f202341e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f202342f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public HashMap<String, String> f202343g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f202344h;

        public d() {
            this.f202337a = "";
            this.f202338b = "";
            this.f202339c = "";
            this.f202340d = EventTyp.PROCESS;
            this.f202342f = "";
            this.f202344h = "";
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f202345a = null;

        static {
            int[] r100 = new int[EventTyp.values().length];
            r100[EventTyp.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[EventTyp.PROCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[EventTyp.END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f202345a = r100;
        }
    }

    static {
        f202325b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, DynamicEventTracker$Companion$singleInstance$2.INSTANCE);
        f202326c = new HashMap();
    }

    public DynamicEventTracker() {
        this.f202327a = new HashMap();
    }

    public static a a(d r110, HashMap r210, long r211) {
        a r100 = new a();
        String r101 = r110.f202339c;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r100.f202329a = r101;
        r100.f202332d = r110.f202341e;
        HashMap<String, String> r102 = f.f202351a;
        String r103 = r110.f202339c;
        String r104 = r110.f202342f;
        Intrinsics.checkNotNullParameter(r103, "eventName");
        Intrinsics.checkNotNullParameter(r104, "defaultDesc");
        String r111 = null;
        String r112 = "";
        switch(r103.hashCode()) {
            case -1473179305: goto L132;
            case -1309878656: goto L111;
            case -1282537891: goto L90;
            case 149809508: goto L69;
            case 1262289897: goto L48;
            case 1627004382: goto L27;
            case 1892922352: goto L6;
            default: goto L152;
        };
    L152:
        if (r210 == null) goto L154;
        Object r105 = r210.get("trace_name");
    L156:
        if ((r105 instanceof String) == false) goto L158;
        r111 = (String) r105;
    L158:
        if (r111 == null) goto L162;
        r112 = r111;
    L162:
        if (TextUtils.isEmpty(r112) == true) goto L165;
        r103 = r112;
    L167:
        r112 = r103;
    L168:
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        r100.f202330b = r112;
        Intrinsics.checkNotNullParameter(r110.f202340d, "<set-?>");
        if (r211 != (-1)) goto L171;
        long r106 = System.currentTimeMillis();
    L172:
        r100.f202331c = r106;
        return r100;
    L171:
        r106 = r211;
        goto L172
    L165:
        if (TextUtils.isEmpty(r104) == true) goto L167;
        r103 = r104;
        goto L167
    L154:
        r105 = null;
        goto L156
    L6:
        if (r103.equals("wallet_rd_common_sdk_start") == false) goto L152;
        if (r210 == null) goto L10;
        Object r107 = r210.get("trace_name");
    L12:
        if ((r107 instanceof String) == false) goto L14;
        r111 = (String) r107;
    L14:
        if (r111 != null) goto L17;
        r111 = "";
    L17:
        if (TextUtils.isEmpty(r111) == true) goto L168;
        HashMap<String, String> r108 = f.f202351a;
        if (r108.containsKey(r111) == false) goto L25;
        String r109 = r108.get(r111);
        if (r109 == null) goto L24;
        r112 = r109;
    L24:
        r111 = r112;
    L25:
        r112 = r111.concat("SDK开始");
        goto L168
    L10:
        r107 = null;
        goto L12
    L27:
        if (r103.equals("wallet_rd_common_pay_start") == false) goto L152;
        if (r210 == null) goto L31;
        Object r113 = r210.get("trace_name");
    L33:
        if ((r113 instanceof String) == false) goto L35;
        r111 = (String) r113;
    L35:
        if (r111 != null) goto L38;
        r111 = "";
    L38:
        if (TextUtils.isEmpty(r111) == true) goto L168;
        HashMap<String, String> r114 = f.f202351a;
        if (r114.containsKey(r111) == false) goto L46;
        String r115 = r114.get(r111);
        if (r115 == null) goto L45;
        r112 = r115;
    L45:
        r111 = r112;
    L46:
        r112 = r111.concat("开始");
        goto L168
    L31:
        r113 = null;
        goto L33
    L48:
        if (r103.equals("wallet_rd_common_sdk_end") == false) goto L152;
        if (r210 == null) goto L52;
        Object r116 = r210.get("trace_name");
    L54:
        if ((r116 instanceof String) == false) goto L56;
        r111 = (String) r116;
    L56:
        if (r111 != null) goto L59;
        r111 = "";
    L59:
        if (TextUtils.isEmpty(r111) == true) goto L168;
        HashMap<String, String> r117 = f.f202351a;
        if (r117.containsKey(r111) == false) goto L67;
        String r118 = r117.get(r111);
        if (r118 == null) goto L66;
        r112 = r118;
    L66:
        r111 = r112;
    L67:
        r112 = r111.concat("SDK结束");
        goto L168
    L52:
        r116 = null;
        goto L54
    L69:
        if (r103.equals("wallet_rd_common_network_start") == false) goto L152;
        if (r210 == null) goto L73;
        Object r119 = r210.get("trace_name");
    L75:
        if ((r119 instanceof String) == false) goto L77;
        String r120 = (String) r119;
    L78:
        if (r120 != null) goto L81;
        r120 = "";
    L81:
        if (TextUtils.isEmpty(r120) == true) goto L168;
        Iterator<Map.Entry<String, String>> r121 = f.f202352b.entrySet().iterator();
        String r122 = r120;
    L84:
        if (r121.hasNext() == false) goto L88;
        Map.Entry<String, String> r123 = r121.next();
        if (StringsKt.contains$default(r120, r123.getKey(), false, 2, null) == false) goto L84;
        r122 = StringsKt.replace$default(r122, r123.getKey(), r123.getValue(), false, 4, null);
        goto L84
    L88:
        r112 = r122 + "开始";
        goto L168
    L77:
        r120 = null;
        goto L78
    L73:
        r119 = null;
        goto L75
    L90:
        if (r103.equals("wallet_rd_common_network_end") == false) goto L152;
        if (r210 == null) goto L94;
        Object r124 = r210.get("trace_name");
    L96:
        if ((r124 instanceof String) == false) goto L98;
        String r125 = (String) r124;
    L99:
        if (r125 != null) goto L102;
        r125 = "";
    L102:
        if (TextUtils.isEmpty(r125) == true) goto L168;
        Iterator<Map.Entry<String, String>> r126 = f.f202352b.entrySet().iterator();
        String r127 = r125;
    L105:
        if (r126.hasNext() == false) goto L109;
        Map.Entry<String, String> r128 = r126.next();
        if (StringsKt.contains$default(r125, r128.getKey(), false, 2, null) == false) goto L105;
        r127 = StringsKt.replace$default(r127, r128.getKey(), r128.getValue(), false, 4, null);
        goto L105
    L109:
        r112 = r127 + "结束";
        goto L168
    L98:
        r125 = null;
        goto L99
    L94:
        r124 = null;
        goto L96
    L111:
        if (r103.equals("wallet_rd_common_page_show") == false) goto L152;
        if (r210 == null) goto L115;
        Object r129 = r210.get("trace_name");
    L117:
        if ((r129 instanceof String) == false) goto L119;
        r111 = (String) r129;
    L119:
        if (r111 != null) goto L122;
        r111 = "";
    L122:
        if (TextUtils.isEmpty(r111) == true) goto L168;
        HashMap<String, String> r130 = f.f202353c;
        if (r130.containsKey(r111) == false) goto L130;
        String r131 = r130.get(r111);
        if (r131 == null) goto L129;
        r112 = r131;
    L129:
        r111 = r112;
    L130:
        r112 = r111.concat("曝光");
        goto L168
    L115:
        r129 = null;
        goto L117
    L132:
        if (r103.equals("wallet_rd_common_pay_end") == false) goto L152;
        if (r210 == null) goto L136;
        Object r132 = r210.get("trace_name");
    L138:
        if ((r132 instanceof String) == false) goto L140;
        r111 = (String) r132;
    L140:
        if (r111 != null) goto L143;
        r111 = "";
    L143:
        if (TextUtils.isEmpty(r111) == true) goto L168;
        HashMap<String, String> r133 = f.f202351a;
        if (r133.containsKey(r111) == false) goto L151;
        String r134 = r133.get(r111);
        if (r134 == null) goto L150;
        r112 = r134;
    L150:
        r111 = r112;
    L151:
        r112 = r111.concat("结束");
        goto L168
    L136:
        r132 = null;
        goto L138
    }
}
