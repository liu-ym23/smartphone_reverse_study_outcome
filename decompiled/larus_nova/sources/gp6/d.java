package gp6;

import com.bytedance.locallife.cube.api.i.IPoiLynxKitDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d {
    public static final void a(IPoiLynxKitDelegate r100, Function1<? super b, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "update");
        b r102 = r100.getCubeTiming();
        if (r102 == null) goto L5;
        r101.invoke(r102);
        return;
    L5:
        com.bytedance.locallife.cube.d.b("cubeTiming is null!!!!!!");
    }
}
