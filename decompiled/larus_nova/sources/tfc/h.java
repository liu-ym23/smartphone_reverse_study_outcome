package tfc;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.photoeditor.mosaic.MosaicPhotoEditorPlugin;
import com.ss.android.photoeditor.mosaic.MosaicView;

/* JADX INFO: loaded from: classes38.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f545822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MosaicView f545823b;

    public class a extends pfc.g.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f545824a;

        public a(h r100) {
            this.f545824a = r100;
        }

        @Override // pfc.g.d
        public final void a(RectF r100) {
            this.f545824a.f545823b.f449293h.set(r100);
            this.f545824a.f545823b.invalidate();
        }
    }

    public class b implements pfc.g.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f545825a;

        public b(h r100) {
            this.f545825a = r100;
        }

        @Override // pfc.g.e
        public final void a(MotionEvent r100) {
            if (this.f545825a.f545823b.f449288c == null) goto L6;
            sfc.a.f541747a.getClass();
            sfc.a.f541749c = true;
            this.f545825a.f545823b.f449288c.b(r100);
            return;
        }
    }

    public final void a() {
        MosaicView r100 = this.f545823b;
        r100.f449296k = r100.getImageRect();
        this.f545823b.f449293h = new RectF(this.f545823b.f449296k);
        MosaicView r101 = this.f545823b;
        r101.f449290e = r101.j(r101.f449289d);
        this.f545823b.f449291f = new Canvas(this.f545823b.f449290e);
        MosaicView r102 = this.f545823b;
        RectF r103 = r102.f449296k;
        RectF r104 = r102.f449293h;
        a r105 = new a(this);
        b r106 = new b(this);
        if (r102.f449302q == false) goto L5;
        float r107 = r102.getWidth();
    L6:
        r102.f449295j = new pfc.g(r103, r104, r105, r106, r107);
        this.f545823b.f449297l = true;
        Runnable r108 = this.f545822a;
        if (r108 == null) goto L9;
        r108.run();
    L9:
        this.f545823b.l();
        return;
    L5:
        r107 = 0.0f;
        goto L6
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

    public h(MosaicView r100, MosaicPhotoEditorPlugin.b r101) {
        this.f545823b = r100;
        this.f545822a = r101;
    }
}
