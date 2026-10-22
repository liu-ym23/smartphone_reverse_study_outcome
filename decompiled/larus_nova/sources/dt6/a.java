package dt6;

import com.bytedance.locallife.cube.api.config.LynxInitConfig;
import com.larus.bmhome.chat.font.FontLevel;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import we8.e;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends wl6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f470007a = null;

    static {
        f470007a = new a();
    }

    public static float d() {
        Lazy r100 = e.f559400a;
        int r101 = e.f559403d;
        if (r101 > FontLevel.STANDARD.getValue()) goto L6;
    L14:
        return 1.0f;
    L6:
        if (r101 > FontLevel.LARGE.getValue()) goto L9;
    L13:
        return 1.15f;
    L9:
        if (r101 <= FontLevel.EXTRA_LARGE.getValue()) goto L13;
        if (r101 > FontLevel.SUPER_EXTRA_LARGE.getValue()) goto L14;
        goto L13
    }

    @Override // wl6.a, et6.a
    public final float getCurrentFontScale() {
        return d();
    }

    public a() {
    }

    @Override // wl6.a, et6.a
    public final void c(LynxInitConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxInitConfig");
        r100.setFontScaleEnable(Boolean.TRUE);
        float r101 = d();
        if (r101 < 1.15f) goto L5;
        Float r102 = Float.valueOf(1.15f);
    L6:
        r100.setFontScale(r102);
        return;
    L5:
        r102 = Float.valueOf(r101);
        goto L6
    }
}
