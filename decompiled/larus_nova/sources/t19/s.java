package t19;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.lynx.lottieadapter.LottieAdapterView;
import com.obric.assistant.common.spi.toast.ObricToastHelperDelegate;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f544207a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReference<u19.f> f544208b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u19.f f544209a;

        public a(u19.f r100) {
            Intrinsics.checkNotNullParameter(r100, "toastHolder");
            this.f544209a = r100;
        }
    }

    public static final class b implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f544210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LottieAdapterView f544211b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            this.f544210a.removeOnAttachStateChangeListener(this);
            this.f544211b.setAnimation("lottie/toast_loading.json");
            this.f544211b.playAnimation();
        }

        public b(View r100, LottieAdapterView r101) {
            this.f544210a = r100;
            this.f544211b = r101;
        }
    }

    public static final class c implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f544212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LottieAdapterView f544213b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            this.f544212a.removeOnAttachStateChangeListener(this);
            this.f544213b.setAnimation("lottie/toast_loading.json");
            this.f544213b.playAnimation();
        }

        public c(View r100, LottieAdapterView r101) {
            this.f544212a = r100;
            this.f544213b = r101;
        }
    }

    public s() {
    }

    public final synchronized void a() {
        monitor-enter(this);
        FLogger.f375446a.d("ToastLogger", "toast util dismiss");     // Catch: Throwable -> L6
        t0.e(new n());     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        f544207a = new s();
        f544208b = new AtomicReference(null);
    }

    public static Context f(Context r100) {
        Context r101 = ObricToastHelperDelegate.f387851b.resolveContext(r100);
        if (r101 != null) goto L6;
        return r100;
    L6:
        return r101;
    }

    public final synchronized void r(final u19.f r100) {
        monitor-enter(this);
        t0.e(new p(r100));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static void c(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r101, "text");
        l(r100, R.drawable.larus_toast_failure_icon, r101, null, null, false);
    }

    public static void p(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r101, "text");
        l(r100, v19.c.b(R.attr.larus_toast_success_icon, null, R.drawable.larus_toast_success_icon), r101, null, null, false);
    }

    public static void s(Context r100, int r101) {
        t0.e(new i(r100, r101, v19.c.b(R.attr.larus_toast_warning_icon, null, R.drawable.larus_toast_warning_icon), false));
    }

    public static void t(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "text");
        k(r100, v19.c.b(R.attr.larus_toast_warning_icon, null, R.drawable.larus_toast_warning_icon), r101, null);
    }

    public static void b(Context r100, int r101, boolean r102) {
        t0.e(new i(r100, r101, R.drawable.larus_toast_failure_icon, r102));
    }

    public static void e(FragmentActivity r100, CharSequence r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "text");
        m(r100, r101, 0, r102, new h());
    }

    public static void o(Context r100, int r101, boolean r102) {
        t0.e(new i(r100, r101, v19.c.b(R.attr.larus_toast_success_icon, null, R.drawable.larus_toast_success_icon), r102));
    }

    public static void q(Context r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r101, "text");
        l(r100, v19.c.b(R.attr.larus_toast_success_icon, null, R.drawable.larus_toast_success_icon), r101, Integer.valueOf(r102), null, false);
    }

    public static void u(Context r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "text");
        k(r100, v19.c.b(R.attr.larus_toast_warning_icon, null, R.drawable.larus_toast_warning_icon), r101, Integer.valueOf(r102));
    }

    public final void g(Context r100, int r101, boolean r110) {
        if (r100 != null) goto L4;
        Context r102 = AppHost.f326268a.getApplication();
    L5:
        String r103 = r102.getResources().getString(r101);
        FLogger.f375446a.d("ToastLogger", "toast utils show, method name: show");
        j(this, r100, r103, null, r110, 12);
        return;
    L4:
        r102 = r100;
        goto L5
    }

    public static void d(Context r100, CharSequence r101, Integer r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r101, "text");
        Context r102 = f(r100);
        if ((r102 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r103 = (FragmentActivity) r102;
    L6:
        if (r103 != null) goto L9;
        String r104 = r101.toString();
        Intrinsics.checkNotNullParameter(r104, "text");
        Intrinsics.checkNotNullParameter(r104, "text");
        i(r100, r104, r110, false, false, null);
        return;
    L9:
        if (r110 == null) goto L11;
        int r105 = r110.intValue();
    L12:
        m(r103, r101, r105, r111, new m());
        return;
    L11:
        r105 = 0;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    public static void k(Context r100, int r101, String r102, Integer r110) {
        Intrinsics.checkNotNullParameter(r102, "text");
        l(r100, r101, r102, r110, null, false);
    }

    public static void n(s r100, final Fragment r101, final CharSequence r102, final Function1 r103) {
        final int r104 = 0;
        final boolean r105 = false;
        Intrinsics.checkNotNullParameter(r102, "text");
        Intrinsics.checkNotNullParameter(r103, "config");
        t0.e(new d(r102, r103, r104, r105, r101));
    }

    public static void h(Context r100, String r101, Integer r102, boolean r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r101, "text");
        i(r100, r101, r102, r110, r111, null);
    }

    public static void m(Context r100, final CharSequence r101, final int r102, final boolean r110, final Function1 r111) {
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r111, "config");
        final Context r103 = f(r100);
        if (r103 != null) goto L5;
        return;
    L5:
        t0.e(new t19.c(r101, r111, r102, r110, r103));
    }

    public static void i(Context r100, final String r101, final Integer r110, final boolean r111, final boolean r112, final Integer r113) {
        Intrinsics.checkNotNullParameter(r101, "text");
        final Context r102 = f(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        t0.e(new k(r101, r113, r102, r112, r110, r111));
    }

    public static /* synthetic */ void j(s r100, Context r101, String r102, Integer r103, boolean r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r103 = null;
    L6:
        if ((r105 & 8) == 0) goto L8;
        boolean r106 = true;
    L10:
        if ((r105 & 16) == 0) goto L12;
        r104 = false;
    L12:
        r100.getClass();
        h(r101, r102, r103, r106, r104);
        return;
    L8:
        r106 = false;
        goto L10
    }

    public static void l(Context r100, final int r101, final String r110, final Integer r111, final Integer r112, final boolean r113) {
        Intrinsics.checkNotNullParameter(r110, "text");
        final Context r102 = f(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        t0.e(new l(r101, r110, r112, r111, r102, r113));
    }
}
