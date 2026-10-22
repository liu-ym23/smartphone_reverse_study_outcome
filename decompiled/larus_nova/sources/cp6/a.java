package cp6;

import com.bytedance.locallife.cube.api.config.CubeConfig;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    public static final void a(CubeConfig r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "config");
        r101.invoke(r100.getCubeInitConfig());
    }

    public static final void b(CubeConfig r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "config");
        r101.invoke(r100.getLynxInitConfig());
    }

    public static final void c(CubeConfig r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "config");
        r101.invoke(r100.getLynxLoadConfig());
    }
}
