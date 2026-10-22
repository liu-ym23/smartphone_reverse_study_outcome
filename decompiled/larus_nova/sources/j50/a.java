package j50;

import com.bytedance.android.live.core.gl.camera.BaseCamera;
import com.bytedance.android.live.core.gl.core.shader.Shaders;
import com.bytedance.android.live.core.gl.primitive.Align;
import com.monitor.cloudmessage.consts.CloudControlInf;
import k50.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends n50.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public s50.a f497444e;

    public a() {
        n50.b r100 = new n50.b();
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.SP);
        super(r100);
    }

    @Override // n50.a
    public final void c(f r100) {
        Intrinsics.checkNotNullParameter(r100, "rendererParams");
        super.c(r100);
    }

    public final void f(f r100) {
        Intrinsics.checkNotNullParameter(r100, "rendererParams");
        Intrinsics.checkNotNullParameter(r100, "rendererParams");
        this.f517988b = r100;
        com.bytedance.android.live.core.gl.core.shader.b r101 = r100.f501810a.f501809b;
        Shaders r102 = Shaders.DEFAULT_TEXTURE_SHADER;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "shader");
        int r103 = r102.ordinal();
        if (r101.f64825a.containsKey(Integer.valueOf(r103)) == true) goto L7;
        r101.f64825a.put(Integer.valueOf(r103), r102.createShader());
        return;
    }

    @Override // n50.a
    public final void d(f r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "rendererParams");
        float r103 = 375.0f;
        if (r101 <= r102) goto L9;
        BaseCamera r104 = this.f517990d.f517991a;
        s50.a r105 = this.f497444e;
        if (r105 == null) goto L7;
        r105.a();
    L8:
        r104.f64808j = r103;
        r104.f64807i = 0.0f;
        r104.f64809k = BaseCamera.ClampType.VERTICAL;
    L14:
        BaseCamera r106 = this.f517990d.f517991a;
        Align r107 = Align.CENTER;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "align");
        r106.f64806h = r107;
        this.f517990d.f517991a.a();
        super.d(r100, r101, r102);
        return;
    L7:
        r103 = 1.0f;
        goto L8
    L9:
        BaseCamera r108 = this.f517990d.f517991a;
        s50.a r109 = this.f497444e;
        if (r109 == null) goto L12;
        r109.a();
    L13:
        r108.f64807i = r103;
        r108.f64808j = 0.0f;
        r108.f64809k = BaseCamera.ClampType.HORIZONTAL;
        goto L14
    L12:
        r103 = 1.0f;
        goto L13
    }
}
