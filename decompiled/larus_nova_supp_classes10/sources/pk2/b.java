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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends com.bytedance.android.ec.common.api.jump.model.a implements com.bytedance.android.ec.common.api.jump.model.c, com.bytedance.android.ec.common.api.jump.model.d {
    public final gf.a a;
    public final Function0<ExtendInfoContent> b;
    public final Function0<Boolean> c;

    public static final class a implements com.bytedance.android.ec.common.api.jump.model.a.a {
        public final gf.a a;
        public final Function0<ExtendInfoContent> b;
        public final Function0<Boolean> c;

        public final <T extends com.bytedance.android.ec.common.api.jump.model.a> T a(KClass<T> r4) {
            Intrinsics.checkNotNullParameter(r4, "modelClass");
            if (Intrinsics.areEqual(r4, Reflection.getOrCreateKotlinClass(b.class)) == false) goto L7;
            return new b(this.a, this.b, this.c);
        L7:
            return (T) JvmClassMappingKt.getJavaClass(r4).newInstance();
        }

        public a(gf.a r2, Function0<ExtendInfoContent> r3, Function0<Boolean> r4) {
            Intrinsics.checkNotNullParameter(r2, "fromType");
            Intrinsics.checkNotNullParameter(r4, "isShowBottomBtnAnimation");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L12;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        gf.a r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Function0<ExtendInfoContent> r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Function0<Boolean> r7 = this.c;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ExplainCardParams(fromType=" + this.a + ", extendInfo=" + this.b + ", isShowBottomBtnAnimation=" + this.c + ")";
    }

    public final JSONObject addToCartEntranceInfo() {
        JSONObject r0 = new JSONObject();
        r0.putOpt("carrier_type", "live_popup_card_add_to_cart");
        return r0;
    }

    public final JSONObject entranceInfo() {
        JSONObject r0 = new JSONObject();
        Function0<ExtendInfoContent> r1 = this.b;
        if (r1 == null) goto L12;
        ExtendInfoContent r2 = (ExtendInfoContent) r1.invoke();
        if (r2 == null) goto L12;
        Map r3 = r2.getEventParam();
        if (r3 == null) goto L12;
        Iterator r4 = r3.entrySet().iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        Map.Entry r5 = (Map.Entry) r4.next();
        r0.put((String) r5.getKey(), (String) r5.getValue());
    L12:
        return r0;
    }

    public b(gf.a r2, Function0<ExtendInfoContent> r3, Function0<Boolean> r4) {
        Intrinsics.checkNotNullParameter(r2, "fromType");
        Intrinsics.checkNotNullParameter(r4, "isShowBottomBtnAnimation");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
