package cr8;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: classes26.dex */
public final class e extends ShapeDrawable.ShaderFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f465105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f465106b;

    public e(int r100, int r101) {
        this.f465105a = r100;
        this.f465106b = r101;
    }

    @Override // android.graphics.drawable.ShapeDrawable.ShaderFactory
    public final Shader resize(int r110, int r111) {
        int r112 = ColorUtils.setAlphaComponent(this.f465105a, 255);
        return new LinearGradient(0.0f, 0.0f, 0.0f, r111, new int[]{this.f465106b, r112, r112}, new float[]{0.0f, 0.8f, 1.0f}, Shader.TileMode.CLAMP);
    }
}
