package wd2;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public Disposable a;
    public Function1<? super Long, Unit> b;
    public long c;
    public final long d;
    public boolean e;
    public long f;
    public String g;
    public final int h;
    public final long i;

    /* JADX INFO: renamed from: wd2.a$a, reason: collision with other inner class name */
    public static final class C0183a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ WeakReference b;

        public b(a r1, WeakReference r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r11) {
            Long r12 = (Long) r11;
            if (KtvSettingHelper.r().booleanValue() == false) goto L5;
            a r13 = (a) this.b.get();
        L6:
            if (r13 == null) goto L23;
            long r0 = r13.c + r13.i;
            long r2 = r13.f;
            if (r2 != 0) goto L10;
            int r3 = 0;
        L19:
            long r1 = r0 + ((long) r3);
            r13.c = r1;
            Function1<? super Long, Unit> r14 = r13.b;
            if (r14 == null) goto L24;
            Unit r15 = (Unit) r14.invoke(Long.valueOf(r1));
            return;
        L24:
            return;
        L10:
            if (r2 <= 0) goto L15;
            int r6 = r13.h;
            long r7 = r2 - ((long) r6);
            if (r7 >= 0) goto L14;
            r3 = (int) r2;
            r13.f = 0;
            goto L19
        L14:
            r13.f = r7;
            r3 = r6;
            goto L19
        L15:
            int r8 = r13.h;
            long r9 = ((long) r8) + r2;
            if (r9 <= 0) goto L18;
            r3 = (int) r2;
            r13.f = 0;
            goto L19
        L18:
            r13.f = r9;
            r3 = -r8;
            goto L19
        L23:
            return;
        L5:
            r13 = this.a;
            goto L6
        }
    }

    static {
    }

    public final void e() {
        ALogger.i(bb0.b.b() + "-lyric-" + (this.g + "_KtvListenerLyricTimer"), "stop, invoke class :".concat(a.class.getSimpleName()));
        ALogger.i("歌词排查", "stop");
        Disposable r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        this.e = false;
        this.f = 0;
        this.c = 0;
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r0.dispose();
        goto L7
    }

    public a() {
        SystemClock.elapsedRealtime();
        this.d = h.u();
        new Handler(Looper.getMainLooper());
        this.g = "";
        this.h = 25;
        this.i = h.K();
    }

    public static void b(a r4) {
        r4.getClass();
        String r0 = bb0.b.b() + "-lyric-" + (r4.g + "_KtvListenerLyricTimer");
        ALogger.i(r0, ("pause:null") + ", invoke class :" + a.class.getSimpleName());
        r4.e = false;
        Disposable r5 = r4.a;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isDisposed() == true) goto L9;
        r5.dispose();
        return;
    }

    public static void c(a r2) {
        r2.d(r2.c);
        r2.e = true;
        r2.f(null);
    }

    public final void a(long r9) {
        SystemClock.elapsedRealtime();
        if (this.e == false) goto L11;
        long r0 = Math.abs(r9 - this.c);
        long r2 = this.d;
        if (r0 > r2) goto L10;
        long r1 = this.c;
        if ((r9 - r1) > (r2 / ((long) 5))) goto L10;
        this.f = r9 - r1;
    L10:
        d(r9);
    L11:
        f(Long.valueOf(r9));
    }

    public final void d(long r5) {
        String r0 = this.g + "_KtvListenerLyricTimer";
        String r1 = "seek:" + r5 + "---" + this.c;
        ALogger.i(bb0.b.b() + "-lyric-" + r0, r1 + ", invoke class :" + a.class.getSimpleName());
        SystemClock.elapsedRealtime();
        this.f = 0;
        this.c = r5;
        Function1<? super Long, Unit> r2 = this.b;
        if (r2 == null) goto L6;
        Unit r6 = (Unit) r2.invoke(Long.valueOf(r5));
        return;
    }

    public final void f(Long r6) {
        String r0 = this.g + "_KtvListenerLyricTimer";
        StringBuilder r2 = new StringBuilder("StartTimer isStart ");
        r2.append(this.e);
        r2.append(" isDisposed ");
        Disposable r3 = this.a;
        if (r3 == null) goto L5;
        Boolean r4 = Boolean.valueOf(r3.isDisposed());
    L6:
        r2.append(r4);
        String r5 = r2.toString();
        ALogger.i(bb0.b.b() + "-lyric-" + r0, r5 + ", invoke class :" + a.class.getSimpleName());
        if (this.e == false) goto L22;
        Disposable r1 = this.a;
        if (r1 != null) goto L11;
    L12:
        ALogger.i(bb0.b.b() + "-lyric-" + (this.g + "_KtvListenerLyricTimer"), "StartTimer, invoke class :".concat(a.class.getSimpleName()));
        ALogger.i("歌词排查", "StartTimer");
        SystemClock.elapsedRealtime();
        if (r6 == null) goto L15;
        r6.longValue();
    L15:
        Disposable r7 = this.a;
        if (r7 != null) goto L18;
    L20:
        this.a = du2.a.b(0, this.i, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, new WeakReference(this)));
        return;
    L18:
        if (r7.isDisposed() == true) goto L20;
        r7.dispose();
        goto L20
    L11:
        if (r1.isDisposed() == true) goto L12;
        return;
    L22:
        return;
    L5:
        r4 = null;
        goto L6
    }
}
