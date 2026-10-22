package gi2;

import cf.u;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.common.api.jump.model.c;
import com.bytedance.android.ec.common.api.jump.model.d;
import com.bytedance.android.ec.common.api.jump.model.f;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageRoomInfo;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends com.bytedance.android.ec.common.api.jump.model.a implements d, c {
    public com.bytedance.android.shopping.ligo.context.b<?> a;
    public final String b;
    public final String c;
    public final Function0<Boolean> d;
    public final Function0<LivePromotionPageRoomInfo> e;
    public final Map<String, String> f;
    public final Function1<u, Unit> g;
    public final Function0<Boolean> h;

    /* JADX INFO: renamed from: gi2.a$a, reason: collision with other inner class name */
    public static final class C0140a implements com.bytedance.android.ec.common.api.jump.model.a.a {
        public final String a;
        public final String b;
        public final Function0<Boolean> c;
        public final Function0<LivePromotionPageRoomInfo> d;
        public final Map<String, String> e;
        public final Function1<u, Unit> f;
        public final Function0<Boolean> g;

        public final <T extends com.bytedance.android.ec.common.api.jump.model.a> T a(KClass<T> r10) {
            Intrinsics.checkNotNullParameter(r10, "modelClass");
            if (Intrinsics.areEqual(r10, Reflection.getOrCreateKotlinClass(a.class)) == false) goto L7;
            return new a(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
        L7:
            return (T) JvmClassMappingKt.getJavaClass(r10).newInstance();
        }

        public C0140a(String r2, String r3, Function0<Boolean> r4, Function0<LivePromotionPageRoomInfo> r5, Map<String, String> r6, Function1<? super u, Unit> r7, Function0<Boolean> r8) {
            Intrinsics.checkNotNullParameter(r4, "isShowing");
            Intrinsics.checkNotNullParameter(r5, "pageRoomInfo");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L20;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.c;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Function0<Boolean> r7 = this.d;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Function0<LivePromotionPageRoomInfo> r10 = this.e;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Map<String, String> r13 = this.f;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Function1<u, Unit> r16 = this.g;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Function0<Boolean> r19 = this.h;
        if (r19 == null) goto L30;
        r1 = r19.hashCode();
    L30:
        return r18 + r1;
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PromotionListParams(liveListChannel=" + this.b + ", extraEntranceInfoJson=" + this.c + ", isShowing=" + this.d + ", pageRoomInfo=" + this.e + ", schemaEventParams=" + this.f + ", setSkuPanelService=" + this.g + ", isInstantStoreFusion=" + this.h + ")";
    }

    public final JSONObject addToCartEntranceInfo() {
        return new JSONObject();
    }

    public final JSONObject entranceInfo() {
        JSONObject r0 = new JSONObject();
        f r1 = getParamsModel(Reflection.getOrCreateKotlinClass(f.class));
        if (r1 == null) goto L6;
        jf.b r2 = r1.c;
        if (r2 == null) goto L6;
    L7:
        LiveRoomParams r3 = getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        String r4 = this.c;
        if (r4 == null) goto L48;
        JSONObject r5 = com.bytedance.android.shopping.anchorv3.a.d(r4);
        if (r5 == null) goto L48;
        Iterator<String> r6 = r5.keys();
    L13:
        if (r6.hasNext() == false) goto L48;
        String r7 = r6.next();
        r0.put(r7, r5.opt(r7));     // Catch: Exception -> L17
    L17:
        e = move-exception;
        ye.a.b(e);
    L48:
        r0.put("enter_from", "live");     // Catch: Exception -> L25
        if (r3 == null) goto L22;
        String r8 = r3.getSourcePage();     // Catch: Exception -> L25
    L23:
        r0.put("category_name", r8);     // Catch: Exception -> L25
        r0.put("carrier_type", r2.a);     // Catch: Exception -> L25
    L27:
        if (r3 == null) goto L54;
        Map r9 = r3.getEcomLiveParamsEventParams();
        if (r9 == null) goto L54;
        Iterator r10 = r9.entrySet().iterator();
    L32:
        if (r10.hasNext() == false) goto L54;
        Map.Entry r11 = (Map.Entry) r10.next();
        r0.put((String) r11.getKey(), r11.getValue());     // Catch: Exception -> L36
    L36:
        e = move-exception;
        ye.a.b(e);
    L54:
        r0.put("live_list_channel", this.b);     // Catch: Exception -> L45
        if (r3 == null) goto L42;
        String r12 = r3.getEcomSceneId();     // Catch: Exception -> L45
        if (r12 == null) goto L42;
    L43:
        r0.put("ecom_scene_id", r12);     // Catch: Exception -> L45
    L47:
        return r0;
    L42:
        r12 = "1001";
    L45:
        e = move-exception;
        ye.a.b(e);
        goto L47
    L22:
        r8 = null;
    L25:
        e = move-exception;
        ye.a.b(e);
    L6:
        r2 = jf.b.d.b;
        goto L7
    }

    public a(String r2, String r3, Function0<Boolean> r4, Function0<LivePromotionPageRoomInfo> r5, Map<String, String> r6, Function1<? super u, Unit> r7, Function0<Boolean> r8) {
        Intrinsics.checkNotNullParameter(r4, "isShowing");
        Intrinsics.checkNotNullParameter(r5, "pageRoomInfo");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
