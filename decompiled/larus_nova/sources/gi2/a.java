package gi2;

import cf.u;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.common.api.jump.model.c;
import com.bytedance.android.ec.common.api.jump.model.d;
import com.bytedance.android.ec.common.api.jump.model.f;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageRoomInfo;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends com.bytedance.android.ec.common.api.jump.model.a implements d, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.shopping.ligo.context.b<?> f481335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f481336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f481337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Boolean> f481338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<LivePromotionPageRoomInfo> f481339e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f481340f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<u, Unit> f481341g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Boolean> f481342h;

    /* JADX INFO: renamed from: gi2.a$a, reason: collision with other inner class name */
    public static final class C6025a implements com.bytedance.android.ec.common.api.jump.model.a.InterfaceC0780a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f481343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f481344b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function0<Boolean> f481345c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function0<LivePromotionPageRoomInfo> f481346d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<String, String> f481347e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Function1<u, Unit> f481348f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Function0<Boolean> f481349g;

        @Override // com.bytedance.android.ec.common.api.jump.model.a.InterfaceC0780a
        public final <T extends com.bytedance.android.ec.common.api.jump.model.a> T a(KClass<T> r110) {
            Intrinsics.checkNotNullParameter(r110, "modelClass");
            if (Intrinsics.areEqual(r110, Reflection.getOrCreateKotlinClass(a.class)) == false) goto L7;
            return new a(this.f481343a, this.f481344b, this.f481345c, this.f481346d, this.f481347e, this.f481348f, this.f481349g);
        L7:
            return (T) JvmClassMappingKt.getJavaClass(r110).newInstance();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C6025a(String r100, String r101, Function0<Boolean> r102, Function0<LivePromotionPageRoomInfo> r103, Map<String, String> r104, Function1<? super u, Unit> r105, Function0<Boolean> r106) {
            Intrinsics.checkNotNullParameter(r102, "isShowing");
            Intrinsics.checkNotNullParameter(r103, "pageRoomInfo");
            this.f481343a = r100;
            this.f481344b = r101;
            this.f481345c = r102;
            this.f481346d = r103;
            this.f481347e = r104;
            this.f481348f = r105;
            this.f481349g = r106;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L20;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f481336b, r101.f481336b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f481337c, r101.f481337c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f481338d, r101.f481338d) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f481339e, r101.f481339e) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f481340f, r101.f481340f) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f481341g, r101.f481341g) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f481342h, r101.f481342h) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f481336b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f481337c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Function0<Boolean> r107 = this.f481338d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Function0<LivePromotionPageRoomInfo> r110 = this.f481339e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, String> r113 = this.f481340f;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Function1<u, Unit> r116 = this.f481341g;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Function0<Boolean> r119 = this.f481342h;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PromotionListParams(liveListChannel=" + this.f481336b + ", extraEntranceInfoJson=" + this.f481337c + ", isShowing=" + this.f481338d + ", pageRoomInfo=" + this.f481339e + ", schemaEventParams=" + this.f481340f + ", setSkuPanelService=" + this.f481341g + ", isInstantStoreFusion=" + this.f481342h + ")";
    }

    @Override // com.bytedance.android.ec.common.api.jump.model.c
    public final JSONObject addToCartEntranceInfo() {
        return new JSONObject();
    }

    @Override // com.bytedance.android.ec.common.api.jump.model.d
    public final JSONObject entranceInfo() {
        JSONObject r100 = new JSONObject();
        f r101 = (f) getParamsModel(Reflection.getOrCreateKotlinClass(f.class));
        if (r101 == null) goto L6;
        jf.b r102 = r101.f42861c;
        if (r102 == null) goto L6;
    L7:
        LiveRoomParams r103 = (LiveRoomParams) getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        String r104 = this.f481337c;
        if (r104 == null) goto L48;
        JSONObject r105 = com.bytedance.android.shopping.anchorv3.a.d(r104);
        if (r105 == null) goto L48;
        Iterator<String> r106 = r105.keys();
    L13:
        if (r106.hasNext() == false) goto L48;
        String r107 = r106.next();
        r100.put(r107, r105.opt(r107));     // Catch: Exception -> L17
    L17:
        e = move-exception;
        ye.a.b(e);
    L48:
        r100.put("enter_from", "live");     // Catch: Exception -> L25
        if (r103 == null) goto L22;
        String r108 = r103.getSourcePage();     // Catch: Exception -> L25
    L23:
        r100.put("category_name", r108);     // Catch: Exception -> L25
        r100.put("carrier_type", r102.f498849a);     // Catch: Exception -> L25
    L27:
        if (r103 == null) goto L54;
        Map<String, String> r109 = r103.getEcomLiveParamsEventParams();
        if (r109 == null) goto L54;
        Iterator<Map.Entry<String, String>> r110 = r109.entrySet().iterator();
    L32:
        if (r110.hasNext() == false) goto L54;
        Map.Entry<String, String> r111 = r110.next();
        r100.put(r111.getKey(), r111.getValue());     // Catch: Exception -> L36
    L36:
        e = move-exception;
        ye.a.b(e);
    L54:
        r100.put(com.bytedance.android.ec.core.event.a.KEY_LIVE_LIST_CHANNEL, this.f481336b);     // Catch: Exception -> L45
        if (r103 == null) goto L42;
        String r112 = r103.getEcomSceneId();     // Catch: Exception -> L45
        if (r112 == null) goto L42;
    L43:
        r100.put("ecom_scene_id", r112);     // Catch: Exception -> L45
    L47:
        return r100;
    L42:
        r112 = AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF;
    L45:
        e = move-exception;
        ye.a.b(e);
        goto L47
    L22:
        r108 = null;
    L25:
        e = move-exception;
        ye.a.b(e);
    L6:
        r102 = jf.b.d.f498852b;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r100, String r101, Function0<Boolean> r102, Function0<LivePromotionPageRoomInfo> r103, Map<String, String> r104, Function1<? super u, Unit> r105, Function0<Boolean> r106) {
        Intrinsics.checkNotNullParameter(r102, "isShowing");
        Intrinsics.checkNotNullParameter(r103, "pageRoomInfo");
        this.f481336b = r100;
        this.f481337c = r101;
        this.f481338d = r102;
        this.f481339e = r103;
        this.f481340f = r104;
        this.f481341g = r105;
        this.f481342h = r106;
    }
}
