package yk5;

import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends b {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f568141t = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final FragmentActivity f568142k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f568143l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TextView f568144m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Button f568145n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final View f568146o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final View f568147p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final View f568148q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final BearLottieView f568149r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ImageView f568150s;

    public static final class a {
    }

    static {
        f568141t = c.class.getSimpleName();
    }

    @Override // yk5.b, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L18:
        if (this.f568149r.isAnimating() == false) goto L26;
        this.f568149r.cancelAnimation();
        return;
    L26:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r101 == null) goto L16;
        com.bytedance.crash.d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L18
    }

    public c(FragmentActivity r100, Window r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "currentActiveWindow");
        super(r100, r101, R.style.Space_OnBoardingDialog);
        this.f568142k = r100;
        View r102 = LayoutInflater.from(r100).inflate(R.layout.onboarding_card_onboarding, null);
        this.f568128a = r102;
        this.f568143l = (TextView) r102.findViewById(R.id.onBoarding_card_title);
        this.f568144m = (TextView) this.f568128a.findViewById(R.id.onBoarding_card_hint);
        this.f568147p = this.f568128a.findViewById(R.id.onBoarding_card_layout);
        this.f568146o = this.f568128a.findViewById(R.id.onBoarding_card_fl_close);
        this.f568145n = (Button) this.f568128a.findViewById(R.id.onBoarding_card_btn_confirm);
        this.f568148q = this.f568128a.findViewById(R.id.onBoarding_card_tips_layout);
        this.f568149r = (BearLottieView) this.f568128a.findViewById(R.id.onBoarding_card_anim_image);
        this.f568150s = (ImageView) this.f568128a.findViewById(R.id.onBoarding_card_image);
        this.f568128a.setBackgroundColor(j08.b.b(com.bytedance.ee.util.ui.n.h(getContext(), R.color.static_black), 0.2f));
    }

    @Override // yk5.b
    public final void e(int r100, int r101, int r102) {
        this.f568128a.setBackgroundColor(r102);
        this.f568148q.setBackgroundTintList(ColorStateList.valueOf(r100));
        this.f568145n.setTextColor(r100);
        if (Build.VERSION.SDK_INT < 28) goto L6;
        this.f568147p.setOutlineSpotShadowColor(r101);
        this.f568147p.setOutlineAmbientShadowColor(r101);
        return;
    }
}
