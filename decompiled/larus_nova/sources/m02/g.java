package m02;

import com.bytedance.android.live.revenue.common.x0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f511479a = 0;

    static {
    }

    public static void a(x0 r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaUri");
        ReadOnlyProperty r101 = com.bytedance.android.livesdk.gift.platform.business.effect.a.f129053j;
        KProperty<?>[] r102 = com.bytedance.android.livesdk.gift.platform.business.effect.a.f129044a;
        if (((Boolean) r101.getValue(null, r102[8])).booleanValue() == true) goto L5;
        Intrinsics.checkNotNullParameter("enable_dynamic_v8", "key");
        r100.f91014a.remove("enable_dynamic_v8");
    L5:
        Intrinsics.checkNotNullParameter(r100, "schemaUri");
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.a.f129054k.getValue(null, r102[9])).booleanValue() == false) goto L9;
        r100.b("enable_dynamic_v8", "1");
        return;
    }
}
