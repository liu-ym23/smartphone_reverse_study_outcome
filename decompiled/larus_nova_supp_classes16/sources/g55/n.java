package g55;

import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.ee.bear.drive.biz.comment.q1;
import com.bytedance.ee.bear.drive.biz.preview.screen.DriveFullScreenVM;
import com.bytedance.ee.bear.drive.core.DriveViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n {
    public final DriveViewModel a;
    public final DriveFullScreenVM b;
    public final View c;
    public final q1 d;
    public int e;
    public int f;
    public ValueAnimator g;
    public boolean h;

    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ n a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r1) {
        }

        public a(n r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r1) {
            ValueAnimator r2 = this.a.g;
            if (r2 != null) goto L5;
            return;
        L5:
            if (r2.isRunning() == false) goto L9;
            this.a.g.cancel();
            return;
        }
    }

    public final void a(int r3) {
        w75.a r0 = this.a.getFileModel();
        if (r3 == this.f) goto L23;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.c == null) goto L25;
        if (r3 != 0) goto L14;
        com.bytedance.ee.bear.drive.biz.preview.screen.a r1 = (com.bytedance.ee.bear.drive.biz.preview.screen.a) this.b.getLiveFullScreen().getValue();
        if (r1 == null) goto L14;
        if (r1.a == false) goto L14;
        return;
    L14:
        this.f = r3;
        ValueAnimator r4 = this.g;
        if (r4 == null) goto L18;
        r4.cancel();
    L18:
        if (this.f != 0) goto L20;
        this.g = com.bytedance.ee.util.ui.g.a(this.c, 0, this.e);
    L21:
        this.g.setDuration(150);
        this.g.start();
        return;
    L20:
        this.g = com.bytedance.ee.util.ui.g.a(this.c, this.e, 0);
        goto L21
    L25:
        return;
    }

    public n(DriveViewModel r2, DriveFullScreenVM r3, q1 r4, View r5) {
        this.f = 0;
        this.a = r2;
        this.b = r3;
        this.d = r4;
        this.c = r5;
        if (r5 != null) goto L5;
        return;
    L5:
        r5.post(new m(this));
        r5.addOnAttachStateChangeListener(new a(this));
    }
}
