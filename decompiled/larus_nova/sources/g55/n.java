package g55;

import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.ee.bear.drive.biz.comment.q1;
import com.bytedance.ee.bear.drive.biz.preview.screen.DriveFullScreenVM;
import com.bytedance.ee.bear.drive.core.DriveViewModel;

/* JADX INFO: loaded from: classes16.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DriveViewModel f480042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DriveFullScreenVM f480043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f480044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q1 f480045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f480046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f480047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ValueAnimator f480048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f480049h;

    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f480050a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
        }

        public a(n r100) {
            this.f480050a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            ValueAnimator r101 = this.f480050a.f480048g;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.isRunning() == false) goto L9;
            this.f480050a.f480048g.cancel();
            return;
        }
    }

    public final void a(int r100) {
        w75.a r101 = this.f480042a.getFileModel();
        if (r100 == this.f480047f) goto L23;
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.f480044c == null) goto L25;
        if (r100 != 0) goto L14;
        com.bytedance.ee.bear.drive.biz.preview.screen.a r102 = this.f480043b.getLiveFullScreen().getValue();
        if (r102 == null) goto L14;
        if (r102.f223712a == false) goto L14;
        return;
    L14:
        this.f480047f = r100;
        ValueAnimator r103 = this.f480048g;
        if (r103 == null) goto L18;
        r103.cancel();
    L18:
        if (this.f480047f != 0) goto L20;
        this.f480048g = com.bytedance.ee.util.ui.g.a(this.f480044c, 0, this.f480046e);
    L21:
        this.f480048g.setDuration(150);
        this.f480048g.start();
        return;
    L20:
        this.f480048g = com.bytedance.ee.util.ui.g.a(this.f480044c, this.f480046e, 0);
        goto L21
    L25:
        return;
    }

    public n(DriveViewModel r100, DriveFullScreenVM r101, q1 r102, View r103) {
        this.f480047f = 0;
        this.f480042a = r100;
        this.f480043b = r101;
        this.f480045d = r102;
        this.f480044c = r103;
        if (r103 != null) goto L5;
        return;
    L5:
        r103.post(new m(this));
        r103.addOnAttachStateChangeListener(new a(this));
    }
}
