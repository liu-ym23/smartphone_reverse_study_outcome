package wu7;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes23.dex */
public abstract class g extends f {
    public final f[] B;
    public int C;

    @Override // wu7.f
    public final void b(Canvas r100) {
    }

    @Override // wu7.f
    public ValueAnimator d() {
        return null;
    }

    public void k(f... r100) {
    }

    public abstract f[] l();

    @Override // wu7.f, android.graphics.drawable.Animatable
    public final boolean isRunning() {
        f[] r100 = this.B;
        int r101 = r100.length;
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L9;
        if (r100[r102].isRunning() == true) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
    L13:
        return true;
    L12:
        if (super.isRunning() == true) goto L13;
        return false;
    L9:
        r103 = false;
        goto L10
    }

    public final int j() {
        f[] r100 = this.B;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.length;
    }

    public g() {
        f[] r100 = l();
        this.B = r100;
        if (r100 == null) goto L7;
        int r101 = r100.length;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L7;
        r100[r102].setCallback(this);
        r102 = r102 + 1;
    L7:
        k(this.B);
    }

    @Override // wu7.f, android.graphics.drawable.Animatable
    public final void start() {
        super.start();
        f[] r100 = this.B;
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r100[r102].start();
        r102 = r102 + 1;
        goto L3
    }

    @Override // wu7.f, android.graphics.drawable.Animatable
    public final void stop() {
        super.stop();
        f[] r100 = this.B;
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r100[r102].stop();
        r102 = r102 + 1;
        goto L3
    }

    @Override // wu7.f
    public final int c() {
        return this.C;
    }

    @Override // wu7.f, android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        super.draw(r100);
        h(r100);
    }

    @Override // wu7.f
    public final void e(int r100) {
        this.C = r100;
        int r101 = 0;
    L4:
        if (r101 >= j()) goto L6;
        i(r101).e(r100);
        r101 = r101 + 1;
        goto L4
    }

    public void h(Canvas r100) {
        f[] r101 = this.B;
        if (r101 == null) goto L7;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L9;
        f r104 = r101[r103];
        int r105 = r100.save();
        r104.draw(r100);
        r100.restoreToCount(r105);
        r103 = r103 + 1;
        goto L5
    L9:
        return;
    }

    public final f i(int r100) {
        f[] r101 = this.B;
        if (r101 != null) goto L6;
        return null;
    L6:
        return r101[r100];
    }

    @Override // wu7.f, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r100) {
        super.onBoundsChange(r100);
        f[] r101 = this.B;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101[r103].setBounds(r100);
        r103 = r103 + 1;
        goto L3
    }
}
