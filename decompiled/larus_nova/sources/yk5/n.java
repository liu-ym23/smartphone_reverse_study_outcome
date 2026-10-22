package yk5;

import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class n extends yk5.b {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f568183t = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final FragmentActivity f568184k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f568185l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TextView f568186m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final View f568187n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final View f568188o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f568189p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f568190q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f568191r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b f568192s;

    public static final class a {
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f568193a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n f568194a;

            public a(n r100) {
                this.f568194a = r100;
            }

            public final void a() {
                n r100 = this.f568194a;
                Handler r101 = DialogLancet.resolveDialogHandler(r100);
                if (r101 != null) goto L5;
            L7:
                DialogLancet.beforeDialogDismiss(r100);
                r100.dismiss();     // Catch: Throwable -> L10 Exception -> L12
            L16:
                DialogLancet.afterDialogDismiss(r100);
                return;
            L10:
                th = move-exception;
                DialogLancet.afterDialogDismiss(r100);
                throw th;
            L12:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
                Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
                if (r102 == null) goto L16;
                com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
                goto L16
            L5:
                if (Looper.myLooper() == r101.getLooper()) goto L7;
                r101.post(DialogLancet.createDismissRunnable(r100));
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
        }

        public b(n r100) {
            this.f568193a = r100;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            if (this.f568193a.isShowing() == false) goto L9;
            n r101 = this.f568193a;
            r101.f568129b = true;
            sk5.d.b r102 = r101.f568137j;
            if (r102 == null) goto L7;
            ((vk5.b) r102).b();
        L7:
            post(new a(this.f568193a));
            String r103 = n.f568183t;
            tt5.a.h(n.f568183t, "auto dismiss dialog");
            return;
        }
    }

    static {
        f568183t = n.class.getSimpleName();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f568192s.removeMessages(this.f568191r);
    }

    @Override // yk5.b, ep5.a, android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(this);
    L8:
        if (this.f568190q > 0) goto L10;
        return;
    L10:
        if (this.f568192s.hasMessages(this.f568191r) == true) goto L17;
        this.f568192s.sendEmptyMessageDelayed(this.f568191r, this.f568190q);
        return;
    L17:
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L8
    }

    public n(FragmentActivity r100, Window r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "currentActiveWindow");
        super(r100, r101, R.style.Space_OnBoardingDialog);
        this.f568184k = r100;
        this.f568191r = 1;
        this.f568192s = new b(this);
        View r102 = LayoutInflater.from(r100).inflate(R.layout.onboarding_text_onboarding, null);
        this.f568128a = r102;
        this.f568185l = (TextView) r102.findViewById(R.id.onBoarding_text_title);
        this.f568186m = (TextView) this.f568128a.findViewById(R.id.onBoarding_text_hint);
        this.f568187n = this.f568128a.findViewById(R.id.onBoarding_text_arrow);
        this.f568188o = this.f568128a.findViewById(R.id.onBoarding_text_layout);
        this.f568189p = r100.getResources().getDimensionPixelSize(R.dimen.onBoarding_arrow_width);
        this.f568190q = -1;
    }

    @Override // yk5.b
    public final void e(int r100, int r101, int r102) {
        this.f568188o.setBackgroundTintList(ColorStateList.valueOf(r100));
        this.f568187n.setBackgroundTintList(ColorStateList.valueOf(r100));
        if (Build.VERSION.SDK_INT < 28) goto L6;
        this.f568188o.setOutlineSpotShadowColor(r101);
        this.f568188o.setOutlineAmbientShadowColor(r101);
        this.f568187n.setOutlineSpotShadowColor(r101);
        this.f568187n.setOutlineAmbientShadowColor(r101);
        return;
    }
}
