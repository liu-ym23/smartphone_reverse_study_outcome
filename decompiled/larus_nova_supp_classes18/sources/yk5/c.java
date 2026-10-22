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
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends b {
    public static final String t = null;
    public final FragmentActivity k;
    public final TextView l;
    public final TextView m;
    public final Button n;
    public final View o;
    public final View p;
    public final View q;
    public final BearLottieView r;
    public final ImageView s;

    public static final class a {
    }

    static {
        t = c.class.getSimpleName();
    }

    @Override // yk5.b, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L18:
        if (this.r.isAnimating() == false) goto L26;
        this.r.cancelAnimation();
        return;
    L26:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L18
    }

    public c(FragmentActivity r2, Window r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "currentActiveWindow");
        super(r2, r3, 2131953437);
        this.k = r2;
        View r4 = LayoutInflater.from(r2).inflate(2131564119, null);
        this.a = r4;
        this.l = (TextView) r4.findViewById(2131381444);
        this.m = (TextView) this.a.findViewById(2131381440);
        this.p = this.a.findViewById(2131381442);
        this.o = this.a.findViewById(2131381439);
        this.n = (Button) this.a.findViewById(2131381438);
        this.q = this.a.findViewById(2131381443);
        this.r = this.a.findViewById(2131381437);
        this.s = (ImageView) this.a.findViewById(2131381441);
        this.a.setBackgroundColor(j08.b.b(com.bytedance.ee.util.ui.n.h(getContext(), 2131106500), 0.2f));
    }

    @Override // yk5.b
    public final void e(int r2, int r3, int r4) {
        this.a.setBackgroundColor(r4);
        this.q.setBackgroundTintList(ColorStateList.valueOf(r2));
        this.n.setTextColor(r2);
        if (Build.VERSION.SDK_INT < 28) goto L6;
        this.p.setOutlineSpotShadowColor(r3);
        this.p.setOutlineAmbientShadowColor(r3);
        return;
    }
}
