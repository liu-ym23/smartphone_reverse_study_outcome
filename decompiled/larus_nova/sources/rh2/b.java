package rh2;

import com.bytedance.android.ec.common.api.jump.model.c;
import com.bytedance.android.ec.common.api.jump.model.d;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class b extends com.bytedance.android.ec.common.api.jump.model.a implements c, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Boolean> f537770a;

    public static final class a implements com.bytedance.android.ec.common.api.jump.model.a.InterfaceC0780a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<Boolean> f537771a;

        public a(Function0<Boolean> r100) {
            Intrinsics.checkNotNullParameter(r100, "isShowBottomBtnAnimation");
            this.f537771a = r100;
        }

        @Override // com.bytedance.android.ec.common.api.jump.model.a.InterfaceC0780a
        public final <T extends com.bytedance.android.ec.common.api.jump.model.a> T a(KClass<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "modelClass");
            if (Intrinsics.areEqual(r100, Reflection.getOrCreateKotlinClass(b.class)) == false) goto L7;
            return new b(this.f537771a);
        L7:
            return (T) JvmClassMappingKt.getJavaClass(r100).newInstance();
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f537770a, ((b) r100).f537770a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Function0<Boolean> r100 = this.f537770a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "IntroCardParams(isShowBottomBtnAnimation=" + this.f537770a + ")";
    }

    @Override // com.bytedance.android.ec.common.api.jump.model.c
    public final JSONObject addToCartEntranceInfo() {
        JSONObject r100 = new JSONObject();
        r100.putOpt("carrier_type", "live_popup_card_add_to_cart");     // Catch: Exception -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L7
    }

    @Override // com.bytedance.android.ec.common.api.jump.model.d
    public final JSONObject entranceInfo() {
        return new JSONObject();
    }

    public b(Function0<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "isShowBottomBtnAnimation");
        this.f537770a = r100;
    }
}
