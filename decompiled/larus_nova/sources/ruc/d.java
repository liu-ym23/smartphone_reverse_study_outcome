package ruc;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes42.dex */
public final class d extends c {

    public static class a extends c.a {
        public a() {
            this.f539343a = View.TRANSLATION_Y;
        }

        @Override // ruc.c.a
        public final void a(View r100) {
            this.f539344b = r100.getTranslationY();
            this.f539345c = r100.getHeight();
        }
    }

    public static class b extends c.e {
        public b() {
        }

        @Override // ruc.c.e
        public final boolean a(View r100, MotionEvent r101) {
            boolean r102 = false;
            if (r101.getHistorySize() != 0) goto L5;
            return false;
        L5:
            float r103 = r101.getY(0) - r101.getHistoricalY(0, 0);
            if (Math.abs(r101.getX(0) - r101.getHistoricalX(0, 0)) <= Math.abs(r103)) goto L8;
            return false;
        L8:
            this.f539353a = r100.getTranslationY();
            this.f539354b = r103;
            if (r103 <= 0.0f) goto L11;
            r102 = true;
        L11:
            this.f539355c = r102;
            return true;
        }
    }

    @Override // ruc.c
    public final c.a a() {
        return new a();
    }

    @Override // ruc.c
    public final c.e b() {
        return new b();
    }

    public d(suc.b r100) {
        super(r100);
    }

    @Override // ruc.c
    public final void c(View r100, float r101) {
        r100.setTranslationY(r101);
    }

    @Override // ruc.c
    public final void d(View r100, float r101, MotionEvent r102) {
        r100.setTranslationY(r101);
        r102.offsetLocation(r101 - r102.getY(0), 0.0f);
    }
}
