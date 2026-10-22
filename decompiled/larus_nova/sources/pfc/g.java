package pfc;

import android.graphics.RectF;
import android.view.MotionEvent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f529065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f529066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<MotionEvent> f529067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public w f529068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f529069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public pfc.b f529070f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f529071g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f529072h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f529073i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d f529074j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final e f529075k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a f529076l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f529077m;

    public class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f529078a;

        @Override // pfc.g.c
        public final int b() {
            return 1;
        }

        public a(g r100) {
            this.f529078a = r100;
        }

        @Override // pfc.g.c
        public final void a(MotionEvent r100) {
            e r101 = this.f529078a.f529075k;
            if (r101 == null) goto L6;
            r101.a(r100);
        L6:
            if (r100.getAction() != 1) goto L8;
        L9:
            this.f529078a.f529069e = null;
            return;
        L8:
            if (r100.getAction() == 3) goto L9;
        }
    }

    public class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f529079a;

        @Override // pfc.g.c
        public final int b() {
            return 2;
        }

        public b(g r100) {
            this.f529079a = r100;
        }

        @Override // pfc.g.c
        public final void a(MotionEvent r100) {
            this.f529079a.f529068d.a(r100);
        }
    }

    public interface c {
        void a(MotionEvent r100);

        int b();
    }

    public static abstract class d {
        public d() {
        }

        public abstract void a(RectF r100);

        public void b() {
        }

        public void c(RectF r100) {
        }
    }

    public interface e {
        void a(MotionEvent r100);
    }

    public final void a(MotionEvent r100) {
        if (this.f529071g == false) goto L6;
        return;
    L6:
        if (this.f529069e != null) goto L27;
        if (r100.getAction() != 0) goto L11;
        List<MotionEvent> r101 = this.f529067c;
        ArrayList r102 = (ArrayList) r101;
        r102.add(MotionEvent.obtain(r100));
    L15:
        c r103 = null;
    L25:
        this.f529069e = r103;
        return;
    L11:
        if (r100.getAction() == 2) goto L17;
        if (r100.getAction() != 1) goto L15;
    L17:
        if (r100.getPointerCount() != 2) goto L19;
        c r104 = this.f529077m;
    L20:
        int r105 = 0;
    L22:
        if (r105 >= ((ArrayList) this.f529067c).size()) goto L24;
        MotionEvent r106 = (MotionEvent) ListProtector.get(this.f529067c, r105);
        r104.a(r106);
        r106.recycle();
        r105 = r105 + 1;
        goto L22
    L24:
        r104.a(r100);
        ((ArrayList) this.f529067c).clear();
        r103 = r104;
        goto L25
    L19:
        r104 = this.f529076l;
        goto L20
    L27:
        if (r100.getPointerCount() == 2) goto L29;
    L31:
        this.f529069e.a(r100);
        return;
    L29:
        if (this.f529069e.b() != 1) goto L31;
        MotionEvent r107 = MotionEvent.obtain(r100);
        r107.setAction(3);
        this.f529069e.a(r107);
        this.f529069e = this.f529077m;
        r107.recycle();
        goto L31
    }

    public g(RectF r100, RectF r101, d r102, e r110) {
        this(r100, r101, r102, r110, 0.0f);
    }

    public g(RectF r100, RectF r101, d r102, e r103, float r104) {
        this.f529067c = new ArrayList();
        this.f529076l = new a(this);
        this.f529077m = new b(this);
        this.f529066b = r100;
        this.f529065a = r101;
        this.f529074j = r102;
        this.f529075k = r103;
        this.f529071g = false;
        if (r104 <= 0.0f) goto L5;
        float r105 = Math.max(r100.width() * 2.5f, r104);
    L6:
        this.f529072h = r105;
        this.f529073i = r100.width() * 0.4f;
        this.f529070f = new pfc.b(new i(this));
        this.f529068d = new w(new h(this));
        return;
    L5:
        r105 = r100.width() * 2.5f;
        goto L6
    }
}
