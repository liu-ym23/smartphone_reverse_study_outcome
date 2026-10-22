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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends com.bytedance.android.ec.common.api.jump.model.a implements c, d {
    public final Function0<Boolean> a;

    public static final class a implements com.bytedance.android.ec.common.api.jump.model.a.a {
        public final Function0<Boolean> a;

        public a(Function0<Boolean> r2) {
            Intrinsics.checkNotNullParameter(r2, "isShowBottomBtnAnimation");
            this.a = r2;
        }

        public final <T extends com.bytedance.android.ec.common.api.jump.model.a> T a(KClass<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "modelClass");
            if (Intrinsics.areEqual(r2, Reflection.getOrCreateKotlinClass(b.class)) == false) goto L7;
            return new b(this.a);
        L7:
            return (T) JvmClassMappingKt.getJavaClass(r2).newInstance();
        }
    }

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof b) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((b) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Function0<Boolean> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "IntroCardParams(isShowBottomBtnAnimation=" + this.a + ")";
    }

    public final JSONObject addToCartEntranceInfo() {
        JSONObject r0 = new JSONObject();
        r0.putOpt("carrier_type", "live_popup_card_add_to_cart");     // Catch: Exception -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L7
    }

    public final JSONObject entranceInfo() {
        return new JSONObject();
    }

    public b(Function0<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "isShowBottomBtnAnimation");
        this.a = r2;
    }
}
