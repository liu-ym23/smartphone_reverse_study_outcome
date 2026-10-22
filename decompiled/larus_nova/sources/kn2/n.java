package kn2;

import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.livesdk.overscroll.adapters.ViewPagerOverScrollDecorAdapter;
import com.bytedance.android.livesdk.overscroll.view.OverScrollFooterView;
import com.bytedance.android.livesdk.overscroll.view.OverScrollHeaderRefreshView;

/* JADX INFO: loaded from: classes11.dex */
public final class n extends k {

    public static class a extends k.b {
        public a() {
            this.f504184a = View.TRANSLATION_Y;
        }

        @Override // kn2.k.b
        public final void a(View r100) {
            this.f504185b = r100.getTranslationY();
            this.f504186c = r100.getHeight();
        }
    }

    public static class b extends k.g {
        public b() {
        }

        @Override // kn2.k.g
        public final boolean a(View r100, MotionEvent r101) {
            boolean r102 = false;
            if (r101.getHistorySize() != 0) goto L5;
            return false;
        L5:
            float r103 = r101.getY(0) - r101.getHistoricalY(0, 0);
            if (Math.abs(r101.getX(0) - r101.getHistoricalX(0, 0)) <= Math.abs(r103)) goto L8;
            return false;
        L8:
            this.f504198a = r100.getTranslationY();
            this.f504199b = r103;
            if (r103 <= 0.0f) goto L11;
            r102 = true;
        L11:
            this.f504200c = r102;
            return true;
        }
    }

    @Override // kn2.k
    public final k.b b() {
        return new a();
    }

    @Override // kn2.k
    public final k.g c() {
        return new b();
    }

    @Override // kn2.k
    public final void j(View r100, float r101) {
        r100.setTranslationY(l(r100, r101));
    }

    public final float l(View r100, float r101) {
        float r102 = 0.5f;
        if (r101 >= 0.0f) goto L20;
        View r103 = this.A;
        if (r103 != null) goto L8;
        return 0.0f;
    L8:
        if ((r103 instanceof OverScrollFooterView) == false) goto L15;
        float r104 = Math.abs(r101);
        float r105 = k.C;
        if (r104 >= r105) goto L13;
        r102 = 0.5f * (Math.abs(r101) / r105);
    L13:
        if (Math.abs(r102 - ((OverScrollFooterView) this.A).getTextAlpha()) <= 0.01f) goto L18;
        ((OverScrollFooterView) this.A).setTextAlpha(r102);
    L18:
        this.A.setTranslationY((r100.getBottom() + r101) - 5.0f);
    L45:
        return r101;
    L15:
        float r106 = r103.getHeight() - 5;
        if (Math.abs(r101) <= Math.abs(r106)) goto L18;
        r101 = -r106;
        goto L18
    L20:
        if (r101 <= 0.0f) goto L45;
        View r107 = this.f504182z;
        if (r107 != null) goto L25;
        return 0.0f;
    L25:
        if ((r107 instanceof OverScrollHeaderRefreshView) == false) goto L41;
        float r108 = k.B;
        if (r101 <= r108) goto L36;
        if (this.f504167k == true) goto L36;
        if (jc1.a.b() == null) goto L36;
        if ((jc1.a.b().getSystemService("vibrator") instanceof Vibrator) == false) goto L36;
        ((Vibrator) jc1.a.b().getSystemService("vibrator")).vibrate(100);
        this.f504167k = true;
    L36:
        if (r101 >= r108) goto L39;
        r102 = 0.5f * (r101 / r108);
    L39:
        if (Math.abs(r102 - ((OverScrollHeaderRefreshView) this.f504182z).getTextAlpha()) <= 0.01f) goto L41;
        ((OverScrollHeaderRefreshView) this.f504182z).setTextAlpha(r102);
    L41:
        float r109 = this.f504182z.getHeight() - 5;
        if (Math.abs(r101) <= Math.abs(r109)) goto L44;
        r101 = r109;
    L44:
        View r110 = this.f504182z;
        r110.setTranslationY((r101 - r110.getHeight()) + 5.0f);
        goto L45
    }

    public n(ViewPagerOverScrollDecorAdapter r100, View r101, View r102) {
        super(r100, r101, r102);
    }

    @Override // kn2.k
    public final void k(View r100, float r101, MotionEvent r102) {
        float r103 = l(r100, r101);
        r100.setTranslationY(r103);
        r102.offsetLocation(r103 - r102.getY(0), 0.0f);
    }
}
