package qfc;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.photoeditor.crop_rotate.PhotoClipView;

/* JADX INFO: loaded from: classes38.dex */
public final class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f532844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PhotoClipView f532845b;

    public class a implements qfc.a.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f532846a;

        public a(x r100) {
            this.f532846a = r100;
        }

        public final void a(y r100) {
            this.f532846a.f532845b.f449183l.d(r100);
            this.f532846a.f532845b.invalidate();
        }
    }

    public class b implements qfc.a.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f532847a;

        public b(x r100) {
            this.f532847a = r100;
        }
    }

    public class c implements qfc.a.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f532848a;

        public c(x r100) {
            this.f532848a = r100;
        }
    }

    public class d implements w.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f532849a;

        public d(x r100) {
            this.f532849a = r100;
        }
    }

    public class e implements w.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f532850a;

        public e(x r100) {
            this.f532850a = r100;
        }
    }

    public class f implements w.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public y f532851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x f532852b;

        public f(x r100) {
            this.f532852b = r100;
        }
    }

    public class g implements w.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f532853a;

        public g(x r100) {
            this.f532853a = r100;
        }
    }

    public final void a() {
        PhotoClipView r100 = this.f532845b;
        Bitmap r101 = r100.f449174c;
        if (r101 == null) goto L7;
        float r102 = Math.min(r101.getWidth(), r100.f449174c.getHeight());
        float r103 = PhotoClipView.f449171p;
        if (r102 >= r103) goto L7;
        float r104 = r103 / r102;
        Bitmap r105 = r100.f449174c;
        r100.f449174c = Bitmap.createScaledBitmap(r105, (int) (r105.getWidth() * r104), (int) (r100.f449174c.getHeight() * r104), true);
    L7:
        PhotoClipView r106 = this.f532845b;
        r106.f449180i = PhotoClipView.l(r106);
        PhotoClipView r107 = this.f532845b;
        r107.f449183l = new y(r107.f449180i, new PointF(this.f532845b.f449180i.centerX(), this.f532845b.f449180i.centerY()));
        float r108 = this.f532845b.f449186o;
        if (r108 > 0.0f) goto L11;
        r108 = 0.42666668f;
    L11:
        Log.i("PhotoClipView", "clipRatio is:" + r108);
        PhotoClipView r109 = this.f532845b;
        r109.f449176e = w.e.a(r109.f449185n, r109.f449180i, r108);
        PhotoClipView r110 = this.f532845b;
        r110.f449178g = new j(r110.f449174c, r110.f449183l);
        PhotoClipView r111 = this.f532845b;
        r111.f449177f = new qfc.a(r111.f449180i, r111.f449183l, r111.f449176e, new a(this), new b(this), new c(this));
        PhotoClipView r112 = this.f532845b;
        PhotoClipView r113 = this.f532845b;
        r112.f449175d = new w(r113.f449180i, r113.f449183l, new d(this), new e(this), new f(this), new g(this));
        this.f532845b.f449182k = true;
        Runnable r114 = this.f532844a;
        if (r114 == null) goto L14;
        r114.run();
    L14:
        PhotoClipView r115 = this.f532845b;
        if (r115.f449173b == null) goto L18;
        r115.f449172a = true;
        qfc.a r116 = r115.f449177f;
        r116.f532767i.b(new RectF(this.f532845b.f449173b), this.f532845b.f449180i, 250);
        this.f532845b.f449173b = null;
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public x(PhotoClipView r100) {
        this.f532845b = r100;
        this.f532844a = null;
    }
}
