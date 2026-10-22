package com.ss.ugc.live.barrage.barrage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes36.dex */
public abstract class AbsBarrage {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f458050n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static float f458051o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f458052p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f458053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f458054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f458055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f458056d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f458057e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f458058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile State f458059g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f458060h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f458061i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f458062j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f458063k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final d f458064l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f458065m;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/ugc/live/barrage/barrage/AbsBarrage$State;", "", "CREATED", "ADDED", "PREPARING", "VISIBLE", "HIDDEN", "barrage_release"}, k = 1, mv = {1, 4, 0})
    public static final enum State extends Enum<State> {
        public static final State ADDED = null;
        public static final State CREATED = null;
        public static final State HIDDEN = null;
        public static final State PREPARING = null;
        public static final State VISIBLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f458066a = null;

        static {
            State r100 = new State("CREATED", 0);
            CREATED = r100;
            State r101 = new State("ADDED", 1);
            ADDED = r101;
            State r102 = new State("PREPARING", 2);
            PREPARING = r102;
            State r103 = new State("VISIBLE", 3);
            VISIBLE = r103;
            State r104 = new State("HIDDEN", 4);
            HIDDEN = r104;
            f458066a = new State[]{r100, r101, r102, r103, r104};
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f458066a.clone();
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f458067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f458068b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f458069c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final olc.a f458070d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Executor f458071e;

        public b() {
            this(0, 0, null, 31);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L27:
            return true;
        L5:
            if ((r100 instanceof b) == false) goto L26;
            b r101 = (b) r100;
            if (this.f458067a != r101.f458067a) goto L9;
            boolean r102 = true;
        L10:
            if (r102 == false) goto L26;
            if (this.f458068b != r101.f458068b) goto L14;
            boolean r103 = true;
        L15:
            if (r103 == false) goto L26;
            if (this.f458069c != r101.f458069c) goto L19;
            boolean r104 = true;
        L20:
            if (r104 == false) goto L26;
            if (Intrinsics.areEqual(this.f458070d, r101.f458070d) == false) goto L26;
            if (Intrinsics.areEqual(this.f458071e, r101.f458071e) == false) goto L26;
        L19:
            r104 = false;
            goto L20
        L14:
            r103 = false;
            goto L15
        L9:
            r102 = false;
        L26:
            return false;
        }

        public final int hashCode() {
            int r100 = ((((this.f458067a * 31) + this.f458068b) * 31) + this.f458069c) * 31;
            olc.a r101 = this.f458070d;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            int r104 = (r100 + r103) * 31;
            Executor r105 = this.f458071e;
            if (r105 == null) goto L10;
            r102 = r105.hashCode();
        L10:
            return r104 + r102;
        L5:
            r103 = 0;
            goto L6
        }

        public final String toString() {
            return "Config(alpha=" + this.f458067a + ", paddingHorizontal=" + this.f458068b + ", paddingVertical=" + this.f458069c + ", bitmapProvider=" + this.f458070d + ", workingExecutor=" + this.f458071e + ")";
        }

        public b(int r100, int r101, olc.b r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r100 = 255;
        L6:
            if ((r103 & 2) == 0) goto L8;
            r101 = 0;
        L8:
            olc.a r104 = r102;
            if ((r103 & 8) == 0) goto L12;
            r104 = olc.e.f524202b;
        L12:
            if ((r103 & 16) == 0) goto L14;
            Executor r105 = AsyncTask.THREAD_POOL_EXECUTOR;
        L15:
            this.f458067a = r100;
            this.f458068b = r101;
            this.f458069c = 0;
            this.f458070d = r104;
            this.f458071e = r105;
            return;
        L14:
            r105 = null;
            goto L15
        }
    }

    public interface c {
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsBarrage f458072a;

        public d(AbsBarrage r100) {
            this.f458072a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AbsBarrage r100 = this.f458072a;     // Catch: Throwable -> L6
            r100.f458063k = true;     // Catch: Throwable -> L6
            if (r100.f458056d == null) goto L9;
            Intrinsics.checkNotNullParameter(r100, IPerformanceManager.MODULE_BARRAGE);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
        f458050n = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AbsBarrage.class), "paint", "getPaint()Landroid/graphics/Paint;"))};
        f458052p = new a();
        f458051o = 1.0f;
    }

    public abstract Bitmap h();

    public final Paint i() {
        Lazy r100 = this.f458053a;
        KProperty r101 = f458050n[0];
        return (Paint) r100.getValue();
    }

    public void j() {
    }

    public AbsBarrage() {
        this(new b(0, 0, null, 31));
    }

    public final void m() {
        f458051o = 1.0f;
        i().setAlpha(this.f458065m.f458067a);
    }

    public void k() {
        Bitmap r100 = h();
        if (r100 == null) goto L5;
        o(r100.getWidth() + (this.f458065m.f458068b * 2), r100.getHeight() + (this.f458065m.f458069c * 2));
    L5:
        this.f458054b = true;
    }

    public AbsBarrage(b r100) {
        this.f458065m = r100;
        this.f458053a = LazyKt.lazy(LazyThreadSafetyMode.NONE, new AbsBarrage$paint$2(this));
        this.f458055c = -1;
        this.f458058f = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.f458059g = State.CREATED;
        this.f458062j = 500;
        this.f458064l = new d(this);
    }

    public void g(Canvas r100) {
        Bitmap r101 = h();
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.f458059g == State.VISIBLE) goto L7;
        return;
    L7:
        if (r101.isRecycled() == true) goto L13;
        RectF r102 = this.f458058f;
        float r103 = r102.left;
        b r104 = this.f458065m;
        r100.drawBitmap(r101, r103 + r104.f458068b, r102.top + r104.f458069c, i());
        return;
    }

    public final void n(float r100) {
        f458051o = r100;
        i().setAlpha((int) (f458051o * this.f458065m.f458067a));
    }

    public final void p(State r100) {
        State r101 = this.f458059g;
        this.f458059g = r100;
        if (r101 != r100) goto L6;
        return;
    L6:
        if (r101.compareTo(r100) >= 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L23;
        int r103 = com.ss.ugc.live.barrage.barrage.a.f458083a[r100.ordinal()];
        if (r103 == 1) goto L21;
        if (r103 != 3) goto L15;
        k();
        return;
    L15:
        if (r103 != 5) goto L26;
        j();
        return;
    L26:
        return;
    L21:
        throw new IllegalStateException("Shouldn't set state to CREATED.");
    L23:
        throw new IllegalStateException(("Wrong state! Prev: " + r101 + ", Target: " + r100).toString());
    L8:
        r102 = false;
        goto L9
    }

    public final boolean l(MotionEvent r100, View r110) {
        int r101 = r100.getAction();
        if (r101 == 0) goto L28;
        if (r101 == 1) goto L17;
        if (r101 != 2) goto L8;
        float r102 = 10;
        if (Math.abs(r100.getX() - this.f458060h) <= r102) goto L14;
    L15:
        r110.removeCallbacks(this.f458064l);
    L29:
        return true;
    L14:
        if (Math.abs(r100.getY() - this.f458061i) <= r102) goto L29;
    L8:
        if (r101 != 3) goto L31;
        r110.removeCallbacks(this.f458064l);
        this.f458063k = false;
        goto L29
    L31:
        return false;
    L17:
        if (this.f458063k == true) goto L27;
        c r103 = this.f458056d;
        if (r103 == null) goto L27;
        float r104 = this.f458060h;
        float r105 = this.f458061i;
        com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.b r106 = (com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.b) r103;
        Intrinsics.checkNotNullParameter(this, IPerformanceManager.MODULE_BARRAGE);
        View r107 = r106.f108955c;
        if (r107 == null) goto L27;
        if (r106.f108953a == false) goto L27;
        r106.f108953a = false;
        r107.postDelayed(r106.f108954b, 800);
        r106.f108956d.invoke(this, new PointF(r104, r105));
    L27:
        r110.removeCallbacks(this.f458064l);
        this.f458063k = false;
        goto L29
    L28:
        this.f458060h = r100.getX();
        this.f458061i = r100.getY();
        this.f458063k = false;
        r110.postDelayed(this.f458064l, this.f458062j);
        goto L29
    }

    public final void o(float r100, float r101) {
        RectF r102 = this.f458058f;
        float r103 = r102.left + r100;
        b r104 = this.f458065m;
        r102.right = r103 + (r104.f458068b * 2);
        r102.bottom = (r102.top + r101) + (r104.f458069c * 2);
    }
}
