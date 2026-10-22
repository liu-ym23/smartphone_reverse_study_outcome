package i50;

import android.opengl.Matrix;
import com.bytedance.android.live.core.gl.camera.BaseCamera;

/* JADX INFO: loaded from: classes45.dex */
public final class b extends BaseCamera {
    @Override // com.bytedance.android.live.core.gl.camera.BaseCamera
    public final void a() {
        int[] r100 = this.f64799a;
        int r101 = r100[2];
        if (r101 == 0) goto L5;
    L7:
        float r102 = r101 / r100[3];
        this.f64805g = r102;
        int r103 = a.f488273a[this.f64809k.ordinal()];
        if (r103 == 1) goto L21;
        if (r103 == 2) goto L20;
        if (r103 == 3) goto L16;
        if (r103 == 4) goto L13;
        float r104 = 0.0f;
    L22:
        float r105 = this.f64805g;
        int r106 = a.f488274b[this.f64809k.ordinal()];
        if (r106 == 1) goto L35;
        if (r106 == 2) goto L34;
        if (r106 == 3) goto L31;
        if (r106 == 4) goto L28;
        float r107 = 0.0f;
    L36:
        Matrix.setIdentityM(this.f64800b, 0);
        Matrix.orthoM(this.f64800b, 0, 0.0f - this.f64806h.getLeftMargin(r104), this.f64806h.getRightMargin(r104) + 0.0f, 0.0f - this.f64806h.getBottomMargin(r107), this.f64806h.getTopMargin(r107) + 0.0f, 1.0f, 100.0f);
        return;
    L28:
        float r108 = this.f64808j;
        float r109 = r108 * r105;
        float r110 = this.f64807i;
        r107 = r110 / r105;
        if ((r109 * r108) >= (r110 * r107)) goto L36;
    L33:
        r107 = r108;
        goto L36
    L31:
        r108 = this.f64808j;
        float r111 = r108 * r105;
        float r112 = this.f64807i;
        r107 = r112 / r105;
        if ((r111 * r108) <= (r112 * r107)) goto L36;
    L34:
        r107 = this.f64808j;
        goto L36
    L35:
        r107 = this.f64807i / r105;
        goto L36
    L13:
        float r113 = this.f64808j;
        r104 = r113 * r102;
        float r114 = this.f64807i;
        if ((r113 * r104) < ((r114 / r102) * r114)) goto L22;
    L19:
        r104 = r114;
        goto L22
    L16:
        float r115 = this.f64808j;
        r104 = r115 * r102;
        r114 = this.f64807i;
        if ((r115 * r104) <= ((r114 / r102) * r114)) goto L19;
    L20:
        r104 = r102 * this.f64808j;
        goto L22
    L21:
        r104 = this.f64807i;
        goto L22
    L5:
        if (r100[3] != 0) goto L7;
    }

    public b() {
    }
}
