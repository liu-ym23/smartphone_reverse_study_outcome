package gt8;

import android.animation.ValueAnimator;
import android.graphics.RectF;
import android.view.animation.DecelerateInterpolator;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f482621a;

    public static final class a {
    }

    public static abstract class b {
        public b() {
        }

        public abstract void a();

        public abstract void b();

        public abstract void c();

        public abstract void d(RectF r100);
    }

    static {
    }

    public j(gt8.b r100) {
        Intrinsics.checkNotNullParameter(r100, "mLocationChangedListener");
        this.f482621a = r100;
    }

    public final boolean a(RectF r100, RectF r110) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        Intrinsics.checkNotNullParameter(r110, VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT);
        boolean r101 = false;
        boolean r102 = true;
        if (Math.abs((r100.width() / r100.height()) - (r110.width() / r110.height())) >= 0.001f) goto L24;
        RectF r103 = new RectF(r100);
        RectF r104 = new RectF();
        if (r103.width() < r110.width()) goto L7;
    L9:
        r104.set(r100);
        float r105 = r104.top;
        float r106 = r110.top;
        if (r105 <= r106) goto L12;
        r104.offset(0.0f, r106 - r105);
        r101 = true;
    L12:
        float r107 = r104.left;
        float r108 = r110.left;
        if (r107 <= r108) goto L15;
        r104.offset(r108 - r107, 0.0f);
        r101 = true;
    L15:
        float r109 = r104.bottom;
        float r111 = r110.bottom;
        if (r109 >= r111) goto L18;
        r104.offset(0.0f, r111 - r109);
        r101 = true;
    L18:
        float r112 = r104.right;
        float r113 = r110.right;
        if (r112 >= r113) goto L21;
        r104.offset(r113 - r112, 0.0f);
    L22:
        if (r102 == false) goto L49;
        b(r103, r104);
    L49:
        return r102;
    L21:
        r102 = r101;
        goto L22
    L7:
        if (r103.height() >= r110.height()) goto L9;
        r104.set(r110);
        goto L22
    L24:
        RectF r114 = new RectF(r100);
        RectF r115 = new RectF();
        if (r114.width() < r110.width()) goto L43;
        if (r114.height() < r110.height()) goto L43;
        r115.set(r100);
        float r116 = r115.top;
        float r117 = r110.top;
        if (r116 <= r117) goto L32;
        r115.offset(0.0f, r117 - r116);
        r101 = true;
    L32:
        float r118 = r115.left;
        float r119 = r110.left;
        if (r118 <= r119) goto L35;
        r115.offset(r119 - r118, 0.0f);
        r101 = true;
    L35:
        float r120 = r115.bottom;
        float r121 = r110.bottom;
        if (r120 >= r121) goto L38;
        r115.offset(0.0f, r121 - r120);
        r101 = true;
    L38:
        float r122 = r115.right;
        float r123 = r110.right;
        if (r122 >= r123) goto L41;
        r115.offset(r123 - r122, 0.0f);
    L47:
        if (r102 == false) goto L49;
        b(r114, r115);
        goto L49
    L41:
        r102 = r101;
    L43:
        if ((r100.width() / r100.height()) <= (r110.width() / r110.height())) goto L45;
        float r124 = r110.height();
        float r125 = r100.width() * (r124 / r100.height());
    L46:
        float r126 = 2;
        float r127 = r125 / r126;
        float r128 = r124 / r126;
        r115.set(r110.centerX() - r127, r110.centerY() - r128, r110.centerX() + r127, r110.centerY() + r128);
        goto L47
    L45:
        float r129 = r110.width();
        r124 = r100.height() * (r129 / r100.width());
        r125 = r129;
        goto L46
    }

    public final void b(final RectF r100, final RectF r101) {
        final RectF r102 = new RectF();
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(300);
        r103.addUpdateListener(new i(r102, r101, r100, this));
        r103.setInterpolator(new DecelerateInterpolator());
        r103.addListener(new k(this));
        r103.start();
    }
}
