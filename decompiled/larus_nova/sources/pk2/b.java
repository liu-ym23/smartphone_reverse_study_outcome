package pk2;

import com.bytedance.android.ec.model.response.ExtendInfoContent;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class b extends com.bytedance.android.ec.common.api.jump.model.a implements com.bytedance.android.ec.common.api.jump.model.c, com.bytedance.android.ec.common.api.jump.model.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gf.a f529582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<ExtendInfoContent> f529583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Boolean> f529584c;

    public static final class a implements com.bytedance.android.ec.common.api.jump.model.a.InterfaceC0780a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final gf.a f529585a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<ExtendInfoContent> f529586b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function0<Boolean> f529587c;

        @Override // com.bytedance.android.ec.common.api.jump.model.a.InterfaceC0780a
        public final <T extends com.bytedance.android.ec.common.api.jump.model.a> T a(KClass<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "modelClass");
            if (Intrinsics.areEqual(r100, Reflection.getOrCreateKotlinClass(b.class)) == false) goto L7;
            return new b(this.f529585a, this.f529586b, this.f529587c);
        L7:
            return (T) JvmClassMappingKt.getJavaClass(r100).newInstance();
        }

        public a(gf.a r100, Function0<ExtendInfoContent> r101, Function0<Boolean> r102) {
            Intrinsics.checkNotNullParameter(r100, "fromType");
            Intrinsics.checkNotNullParameter(r102, "isShowBottomBtnAnimation");
            this.f529585a = r100;
            this.f529586b = r101;
            this.f529587c = r102;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f529582a, r101.f529582a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f529583b, r101.f529583b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f529584c, r101.f529584c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        gf.a r100 = this.f529582a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Function0<ExtendInfoContent> r104 = this.f529583b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Function0<Boolean> r107 = this.f529584c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ExplainCardParams(fromType=" + this.f529582a + ", extendInfo=" + this.f529583b + ", isShowBottomBtnAnimation=" + this.f529584c + ")";
    }

    @Override // com.bytedance.android.ec.common.api.jump.model.c
    public final JSONObject addToCartEntranceInfo() {
        JSONObject r100 = new JSONObject();
        r100.putOpt("carrier_type", "live_popup_card_add_to_cart");
        return r100;
    }

    @Override // com.bytedance.android.ec.common.api.jump.model.d
    public final JSONObject entranceInfo() {
        JSONObject r100 = new JSONObject();
        Function0<ExtendInfoContent> r101 = this.f529583b;
        if (r101 == null) goto L12;
        ExtendInfoContent r102 = r101.invoke();
        if (r102 == null) goto L12;
        Map<String, String> r103 = r102.getEventParam();
        if (r103 == null) goto L12;
        Iterator<Map.Entry<String, String>> r104 = r103.entrySet().iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        Map.Entry<String, String> r105 = r104.next();
        r100.put(r105.getKey(), r105.getValue());
    L12:
        return r100;
    }

    public b(gf.a r100, Function0<ExtendInfoContent> r101, Function0<Boolean> r102) {
        Intrinsics.checkNotNullParameter(r100, "fromType");
        Intrinsics.checkNotNullParameter(r102, "isShowBottomBtnAnimation");
        this.f529582a = r100;
        this.f529583b = r101;
        this.f529584c = r102;
    }
}
