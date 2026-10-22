package kn2;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends k {

    /* JADX INFO: renamed from: kn2.a$a, reason: collision with other inner class name */
    public static class C6576a extends k.b {
        public C6576a() {
            this.f504184a = View.TRANSLATION_X;
        }

        @Override // kn2.k.b
        public final void a(View r100) {
            this.f504185b = r100.getTranslationX();
            this.f504186c = r100.getWidth();
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
            float r104 = r101.getX(0) - r101.getHistoricalX(0, 0);
            if (Math.abs(r104) >= Math.abs(r103)) goto L8;
            return false;
        L8:
            this.f504198a = r100.getTranslationX();
            this.f504199b = r104;
            if (r104 <= 0.0f) goto L11;
            r102 = true;
        L11:
            this.f504200c = r102;
            return true;
        }
    }

    @Override // kn2.k
    public final k.b b() {
        return new C6576a();
    }

    @Override // kn2.k
    public final k.g c() {
        return new b();
    }

    public a(ln2.b r100) {
        super(r100);
    }

    @Override // kn2.k
    public final void j(View r100, float r101) {
        r100.setTranslationX(r101);
    }

    @Override // kn2.k
    public final void k(View r100, float r101, MotionEvent r102) {
        r100.setTranslationX(r101);
        r102.offsetLocation(r101 - r102.getX(0), 0.0f);
    }
}
