package wsc;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes41.dex */
public class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f561116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f561117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f561118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p f561119d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f561120e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C8156a f561121f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f561122g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f561123h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f561124i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f561125j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f561126k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f561127l;

    /* JADX INFO: renamed from: wsc.a$a, reason: collision with other inner class name */
    public class C8156a implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable.Callback f561128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f561129b;

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable r100) {
            this.f561128a.invalidateDrawable(this.f561129b);
        }

        public C8156a(a r100, Drawable.Callback r101) {
            this.f561129b = r100;
            this.f561128a = r101;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable r100, Runnable r101) {
            this.f561128a.unscheduleDrawable(this.f561129b, r101);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
            this.f561128a.scheduleDrawable(this.f561129b, r101, r102);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    public final boolean a() {
        if (this.f561120e == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void b() {
        if (this.f561122g != 0) goto L15;
        this.f561124i = true;
        Drawable r100 = this.f561120e;
        if (r100 == null) goto L12;
        Rect r101 = r100.getBounds();
        if (r101.isEmpty() == false) goto L13;
        r101 = m.a(r100);
        if (r101.isEmpty() == true) goto L12;
    L13:
        setBounds(r101);
        return;
    L12:
        r101 = new Rect(0, 0, 1, 1);
        goto L13
    L15:
        this.f561124i = false;
        Rect r102 = this.f561119d.a(this);
        this.f561120e.setBounds(r102);
        this.f561120e.setCallback(this.f561121f);
        setBounds(r102);
    }

    public final String toString() {
        return "AsyncDrawable{destination='" + this.f561116a + "', imageSize=" + this.f561118c + ", result=" + this.f561120e + ", canvasWidth=" + this.f561122g + ", textSize=" + this.f561123h + ", waitingForDimensions=" + this.f561124i + '}';
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        if (a() == true) goto L7;
        return 1;
    L7:
        return this.f561120e.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        if (a() == true) goto L7;
        return 1;
    L7:
        return this.f561120e.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        if (a() == true) goto L7;
        return -2;
    L7:
        return this.f561120e.getOpacity();
    }

    public final void c(Drawable.Callback r100) {
        if (r100 != null) goto L5;
        C8156a r101 = null;
    L6:
        this.f561121f = r101;
        super.setCallback(r100);
        if (this.f561121f == null) goto L30;
        Drawable r102 = this.f561120e;
        if (r102 == null) goto L14;
        if (r102.getCallback() != null) goto L14;
        this.f561120e.setCallback(this.f561121f);
    L14:
        if (this.f561127l == false) goto L16;
    L20:
        boolean r103 = false;
    L21:
        Drawable r104 = this.f561120e;
        if (r104 == null) goto L28;
        r104.setCallback(this.f561121f);
        Object r105 = this.f561120e;
        if ((r105 instanceof Animatable) == false) goto L28;
        if (this.f561125j == false) goto L28;
        ((Animatable) r105).start();
    L28:
        if (r103 == false) goto L39;
        this.f561117b.b(this);
        return;
    L39:
        return;
    L16:
        if (this.f561120e != null) goto L18;
    L19:
        r103 = true;
        goto L21
    L18:
        if (this.f561126k == false) goto L20;
    L30:
        Drawable r106 = this.f561120e;
        if (r106 == null) goto L37;
        r106.setCallback(null);
        Object r107 = this.f561120e;
        if ((r107 instanceof Animatable) == false) goto L37;
        Animatable r108 = (Animatable) r107;
        boolean r109 = r108.isRunning();
        this.f561125j = r109;
        if (r109 == false) goto L37;
        r108.stop();
    L37:
        this.f561117b.a(this);
        return;
    L5:
        r101 = new C8156a(this, r100);
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        if (a() == false) goto L6;
        this.f561120e.draw(r100);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        super.onBoundsChange(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        Drawable r101 = this.f561120e;
        if (r101 == null) goto L6;
        r101.setAlpha(r100);
        return;
    }

    public void setResult(Drawable r100) {
        if (this.f561127l == true) goto L5;
    L7:
        this.f561125j = false;
        Drawable r101 = this.f561120e;
        if (r101 == null) goto L14;
        r101.setCallback(null);
        Object r102 = this.f561120e;
        if ((r102 instanceof Animatable) == false) goto L14;
        Animatable r103 = (Animatable) r102;
        if (r103.isRunning() == false) goto L14;
        r103.stop();
    L14:
        this.f561120e = r100;
        b();
        this.f561126k = false;
        return;
    L5:
        if (this.f561126k == true) goto L7;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean r100, boolean r101) {
        Drawable r102 = this.f561120e;
        if (r102 == null) goto L6;
        r102.setVisible(r100, r101);
    L6:
        return super.setVisible(r100, r101);
    }

    public a(String r100, b r101, p r102) {
        this.f561125j = false;
        this.f561126k = false;
        this.f561127l = false;
        this.f561116a = r100;
        this.f561117b = r101;
        this.f561119d = r102;
        this.f561118c = null;
    }
}
