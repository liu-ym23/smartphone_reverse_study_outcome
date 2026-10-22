package pl.droidsonroids.gif;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.TypedValue;
import android.widget.MediaController;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes41.dex */
public final class d extends Drawable implements Animatable, MediaController.MediaPlayerControl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f529708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f529709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f529710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f529711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f529712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bitmap f529713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final GifInfoHandle f529714g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ConcurrentLinkedQueue<pl.droidsonroids.gif.a> f529715h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ColorStateList f529716i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PorterDuffColorFilter f529717j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PorterDuff.Mode f529718k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f529719l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final k f529720m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final n f529721n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Rect f529722o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ScheduledFuture<?> f529723p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f529724q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f529725r;

    public class a extends o {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f529726b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f529727c;

        @Override // pl.droidsonroids.gif.o
        public final void a() {
            d r100 = this.f529727c;
            r100.f529714g.y(this.f529726b, r100.f529713f);
            this.f529747a.f529720m.sendEmptyMessageAtTime(-1, 0);
        }

        public a(d r100, d r101, int r102) {
            this.f529727c = r100;
            this.f529726b = r102;
            super(r101);
        }
    }

    public d() throws IOException {
        throw null;
    }

    public final void c() {
        this.f529709b = false;
        this.f529720m.removeMessages(-1);
        this.f529714g.s();
        this.f529713f.recycle();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getAudioSessionId() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getBufferPercentage() {
        return 100;
    }

    @Override // android.graphics.drawable.Animatable, android.widget.MediaController.MediaPlayerControl
    public final void start() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f529709b == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L7:
        this.f529709b = true;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        d(this.f529714g.v());
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f529709b == true) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L7:
        this.f529709b = false;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        ScheduledFuture<?> r100 = this.f529723p;
        if (r100 == null) goto L12;
        r100.cancel(false);
    L12:
        this.f529720m.removeMessages(-1);
        this.f529714g.x();
    }

    public final GifError a() {
        return GifError.fromCode(this.f529714g.j());
    }

    public final int b() {
        return this.f529714g.k();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f529712e.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.f529712e.getColorFilter();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getCurrentPosition() {
        return this.f529714g.e();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getDuration() {
        return this.f529714g.f();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        if (this.f529714g.n() == true) goto L5;
        return -2;
    L5:
        if (this.f529712e.getAlpha() < 255) goto L11;
        return -1;
    L11:
        return -2;
    }

    public final String toString() {
        return String.format(Locale.ENGLISH, "GIF: size: %dx%d, frames: %d, error: %d", new Object[]{Integer.valueOf(this.f529714g.m()), Integer.valueOf(this.f529714g.g()), Integer.valueOf(this.f529714g.k()), Integer.valueOf(this.f529714g.j())});
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekBackward() {
        if (b() > 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekForward() {
        if (b() > 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        super.invalidateSelf();
        if (this.f529719l == true) goto L5;
        return;
    L5:
        if (this.f529709b == false) goto L11;
        long r100 = this.f529710c;
        if (r100 == Long.MIN_VALUE) goto L12;
        long r101 = Math.max(0, r100 - SystemClock.uptimeMillis());
        this.f529710c = Long.MIN_VALUE;
        this.f529708a.remove(this.f529721n);
        this.f529723p = this.f529708a.schedule(this.f529721n, r101, TimeUnit.MILLISECONDS);
        return;
    L12:
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        if (super.isStateful() == true) goto L10;
        ColorStateList r100 = this.f529716i;
        if (r100 != null) goto L7;
    L9:
        return false;
    L7:
        if (r100.isStateful() == false) goto L9;
    L10:
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f529725r;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f529724q;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean isPlaying() {
        return this.f529709b;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f529709b;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void pause() {
        stop();
    }

    public d(GifInfoHandle r100) {
        this.f529709b = true;
        this.f529710c = Long.MIN_VALUE;
        this.f529711d = new Rect();
        this.f529712e = new Paint(6);
        this.f529715h = new ConcurrentLinkedQueue();
        n r101 = new n(this);
        this.f529721n = r101;
        this.f529719l = true;
        int r102 = h.f529731a;
        this.f529708a = h.a.f529732a;
        this.f529714g = r100;
        Bitmap r103 = Bitmap.createBitmap(r100.m(), r100.g(), Bitmap.Config.ARGB_8888);
        this.f529713f = r103;
        r103.setHasAlpha(true ^ r100.n());
        this.f529722o = new Rect(0, 0, r100.m(), r100.g());
        this.f529720m = new k(this);
        r101.a();
        this.f529724q = r100.m();
        this.f529725r = r100.g();
    }

    public final void d(long r100) {
        if (this.f529719l == false) goto L5;
        this.f529710c = 0;
        this.f529720m.sendEmptyMessageAtTime(-1, 0);
        return;
    L5:
        ScheduledFuture<?> r101 = this.f529723p;
        if (r101 == null) goto L8;
        r101.cancel(false);
    L8:
        this.f529720m.removeMessages(-1);
        this.f529723p = this.f529708a.schedule(this.f529721n, Math.max(r100, 0), TimeUnit.MILLISECONDS);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        if (this.f529717j != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        r100.drawBitmap(this.f529713f, this.f529722o, this.f529711d, this.f529712e);
        if (r101 == false) goto L12;
        this.f529712e.setColorFilter(null);
        return;
    L12:
        return;
    L5:
        if (this.f529712e.getColorFilter() != null) goto L7;
        this.f529712e.setColorFilter(this.f529717j);
        r101 = true;
        goto L8
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        this.f529711d.set(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] r100) {
        ColorStateList r101 = this.f529716i;
        if (r101 == null) goto L8;
        PorterDuff.Mode r102 = this.f529718k;
        if (r102 == null) goto L10;
        this.f529717j = e(r101, r102);
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void seekTo(int r100) {
        if (r100 < 0) goto L6;
        this.f529708a.execute(new a(this, this, r100));
        return;
    L6:
        throw new IllegalArgumentException("Position is not positive");
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f529712e.setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f529712e.setColorFilter(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean r100) {
        this.f529712e.setDither(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean r100) {
        this.f529712e.setFilterBitmap(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList r100) {
        this.f529716i = r100;
        this.f529717j = e(r100, this.f529718k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode r100) {
        this.f529718k = r100;
        this.f529717j = e(this.f529716i, r100);
        invalidateSelf();
    }

    public d(Resources r100, int r101) throws Resources.NotFoundException, IOException {
        this(new GifInfoHandle(r100.openRawResourceFd(r101)));
        List<String> r102 = i.f529733a;
        TypedValue r103 = new TypedValue();
        r100.getValue(r101, r103, true);
        int r104 = r103.density;
        if (r104 != 0) goto L6;
        r104 = 160;
    L9:
        int r105 = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).densityDpi;
        if (r104 <= 0) goto L13;
        if (r105 <= 0) goto L13;
        float r106 = r105 / r104;
    L14:
        this.f529725r = (int) (this.f529714g.g() * r106);
        this.f529724q = (int) (this.f529714g.m() * r106);
        return;
    L13:
        r106 = 1.0f;
        goto L14
    L6:
        if (r104 != 65535) goto L9;
        r104 = 0;
        goto L9
    }

    public final PorterDuffColorFilter e(ColorStateList r100, PorterDuff.Mode r101) {
        if (r100 == null) goto L7;
        if (r101 != null) goto L6;
        return null;
    L6:
        return new PorterDuffColorFilter(r100.getColorForState(getState(), 0), r101);
    L7:
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean r100, boolean r101) {
        boolean r102 = super.setVisible(r100, r101);
        if (this.f529719l == true) goto L11;
        if (r100 == false) goto L9;
        if (r101 == false) goto L7;
        this.f529708a.execute(new c(this, this));
    L7:
        if (r102 == false) goto L11;
        start();
        goto L11
    L9:
        if (r102 == false) goto L11;
        stop();
    L11:
        return r102;
    }
}
