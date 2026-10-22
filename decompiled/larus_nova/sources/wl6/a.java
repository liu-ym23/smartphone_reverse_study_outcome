package wl6;

import com.bytedance.locallife.cube.api.config.CubeConfig;
import com.bytedance.locallife.cube.api.config.LynxInitConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public class a implements et6.a {
    public a() {
    }

    @Override // et6.a
    public final void a() {
    }

    @Override // et6.a
    public final void b(CubeConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "cubeConfig");
    }

    @Override // et6.a
    public void c(LynxInitConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxInitConfig");
    }

    @Override // et6.a
    public float getCurrentFontScale() {
        return 1.0f;
    }
}
