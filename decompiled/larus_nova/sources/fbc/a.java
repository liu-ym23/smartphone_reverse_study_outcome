package fbc;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f476317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f476318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f476319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Runnable f476320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final fbc.b f476321e;

    /* JADX INFO: renamed from: fbc.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC5878a {

        /* JADX INFO: renamed from: fbc.a$a$a, reason: collision with other inner class name */
        public static final class C5879a extends AbstractC5878a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final MotionEvent f476322a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C5879a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f476322a, ((C5879a) r100).f476322a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f476322a.hashCode();
            }

            public final String toString() {
                return "Cancel(event=" + this.f476322a + ')';
            }

            public C5879a(MotionEvent r100) {
                Intrinsics.checkNotNullParameter(r100, "event");
                this.f476322a = r100;
            }
        }

        /* JADX INFO: renamed from: fbc.a$a$b */
        public static final class b extends AbstractC5878a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final MotionEvent f476323a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f476323a, ((b) r100).f476323a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f476323a.hashCode();
            }

            public final String toString() {
                return "Down(event=" + this.f476323a + ')';
            }

            public b(MotionEvent r100) {
                Intrinsics.checkNotNullParameter(r100, "event");
                this.f476323a = r100;
            }
        }

        /* JADX INFO: renamed from: fbc.a$a$c */
        public static final class c extends AbstractC5878a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f476324a = null;

            static {
                f476324a = new c();
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof c) == true) goto L9;
                return false;
            L9:
                c r101 = (c) r100;
                return true;
            }

            public final int hashCode() {
                return 747411398;
            }

            public final String toString() {
                return "LongPress";
            }

            public c() {
            }
        }

        /* JADX INFO: renamed from: fbc.a$a$d */
        public static final class d extends AbstractC5878a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final MotionEvent f476325a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof d) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f476325a, ((d) r100).f476325a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f476325a.hashCode();
            }

            public final String toString() {
                return "Move(event=" + this.f476325a + ')';
            }

            public d(MotionEvent r100) {
                Intrinsics.checkNotNullParameter(r100, "event");
                this.f476325a = r100;
            }
        }

        /* JADX INFO: renamed from: fbc.a$a$e */
        public static final class e extends AbstractC5878a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final MotionEvent f476326a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f476327b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof e) == true) goto L8;
                return false;
            L8:
                e r101 = (e) r100;
                if (Intrinsics.areEqual(this.f476326a, r101.f476326a) == true) goto L12;
                return false;
            L12:
                if (this.f476327b == r101.f476327b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                int r100 = this.f476326a.hashCode() * 31;
                if (this.f476327b == false) goto L5;
                int r101 = 1231;
            L7:
                return r100 + r101;
            L5:
                r101 = 1237;
                goto L7
            }

            public final String toString() {
                return "Up(event=" + this.f476326a + ", isClick=" + this.f476327b + ')';
            }

            public e(MotionEvent r100, boolean r101) {
                Intrinsics.checkNotNullParameter(r100, "event");
                this.f476326a = r100;
                this.f476327b = r101;
            }
        }

        public AbstractC5878a() {
        }
    }

    public interface b {
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f476328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f476329b;

        public c(a r100, View r101) {
            this.f476328a = r100;
            this.f476329b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f476328a.f476320d = null;     // Catch: Throwable -> L11
            fbc.b r100 = this.f476328a.f476321e;     // Catch: Throwable -> L11
            boolean r101 = this.f476329b.isPressed();     // Catch: Throwable -> L11
            if (r100.f476333d == true) goto L7;
            if (r101 == false) goto L7;
            boolean r102 = true;
            r100.f476332c = true;     // Catch: Throwable -> L11
        L8:
            if (r102 == false) goto L14;
            b r103 = this.f476328a.f476319c;     // Catch: Throwable -> L11
            com.larus.larkfeed.impl.voice.c r104 = (com.larus.larkfeed.impl.voice.c) r103;     // Catch: Throwable -> L11
            r104.a(this.f476329b, AbstractC5878a.c.f476324a);     // Catch: Throwable -> L11
            return;
        L14:
            return;
        L7:
            r102 = false;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }
    }

    public final void a() {
        fbc.b r100 = this.f476321e;
        r100.f476332c = false;
        r100.f476333d = false;
        Runnable r101 = this.f476320d;
        if (r101 == null) goto L5;
        this.f476317a.removeCallbacks(r101);
    L5:
        this.f476320d = null;
        this.f476317a.getParent().requestDisallowInterceptTouchEvent(false);
        this.f476317a.setPressed(false);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "event");
        int r102 = r101.getActionMasked();
        boolean r103 = false;
        if (r102 == 0) goto L33;
        if (r102 != 1) goto L6;
        fbc.b r104 = this.f476321e;
        boolean r105 = r100.isPressed();
        float r106 = r101.getRawX();
        float r107 = r101.getRawY();
        float r108 = ViewConfiguration.get(r100.getContext()).getScaledTouchSlop();
        if (r105 == true) goto L22;
        r104.getClass();
    L32:
        a();
        ((com.larus.larkfeed.impl.voice.c) this.f476319c).a(r100, new AbstractC5878a.e(r101, r103));
    L34:
        return true;
    L22:
        if (r104.f476332c == true) goto L32;
        if (r104.f476333d == true) goto L32;
        float r109 = r106 - r104.f476330a;
        float r110 = r107 - r104.f476331b;
        if (((r109 * r109) + (r110 * r110)) <= (r108 * r108)) goto L28;
        boolean r111 = true;
    L29:
        if (r111 == true) goto L32;
        r103 = true;
        goto L32
    L28:
        r111 = false;
        goto L29
    L6:
        if (r102 != 2) goto L8;
        fbc.b r112 = this.f476321e;
        float r113 = r101.getRawX();
        float r114 = r101.getRawY();
        float r115 = ViewConfiguration.get(r100.getContext()).getScaledTouchSlop();
        if (r112.f476333d == true) goto L18;
        float r116 = r113 - r112.f476330a;
        float r117 = r114 - r112.f476331b;
        if (((r116 * r116) + (r117 * r117)) <= (r115 * r115)) goto L16;
        r103 = true;
    L16:
        if (r103 == false) goto L18;
        r112.f476333d = true;
    L18:
        ((com.larus.larkfeed.impl.voice.c) this.f476319c).a(r100, new AbstractC5878a.d(r101));
        goto L34
    L8:
        if (r102 != 3) goto L34;
        a();
        ((com.larus.larkfeed.impl.voice.c) this.f476319c).a(r100, new AbstractC5878a.C5879a(r101));
        goto L34
    L33:
        a();
        fbc.b r118 = this.f476321e;
        float r119 = r101.getRawX();
        float r120 = r101.getRawY();
        r118.f476330a = r119;
        r118.f476331b = r120;
        r118.f476332c = false;
        r118.f476333d = false;
        r100.setPressed(true);
        this.f476317a.getParent().requestDisallowInterceptTouchEvent(true);
        this.f476320d = new c(this, r100);
        r100.postDelayed(this.f476320d, this.f476318b);
        ((com.larus.larkfeed.impl.voice.c) this.f476319c).a(r100, new AbstractC5878a.b(r101));
        goto L34
    }

    public a(View r100, long r101, com.larus.larkfeed.impl.voice.c r102) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r102, "listener");
        this.f476317a = r100;
        this.f476318b = r101;
        this.f476319c = r102;
        if (r101 < 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L10;
        this.f476321e = new fbc.b();
        return;
    L10:
        throw new IllegalArgumentException("longPressTimeoutMillis must not be negative".toString());
    L5:
        r103 = false;
        goto L6
    }
}
