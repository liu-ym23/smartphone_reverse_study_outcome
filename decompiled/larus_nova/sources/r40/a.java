package r40;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.crash.d;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends Dialog {

    /* JADX INFO: renamed from: r40.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC7431a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f536015a;

        public ViewOnClickListenerC7431a(a r100) {
            this.f536015a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a r101 = this.f536015a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
        L17:
            this.f536015a.cancel();
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L12:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
            goto L17
        }
    }

    public a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.loading_dialog_theme);
        View r102 = LayoutInflater.from(r100).inflate(R.layout.ttlive_dialog_loading, null);
        setContentView(r102);
        setCanceledOnTouchOutside(false);
        Window r103 = getWindow();
        if (r103 == null) goto L5;
        WindowManager.LayoutParams r104 = r103.getAttributes();
        r104.height = (int) UIUtils.dip2Px(r100, 86.0f);
        r104.width = (int) UIUtils.dip2Px(r100, 104.0f);
        r103.setAttributes(r104);
        r103.setBackgroundDrawable(new ColorDrawable(0));
    L5:
        ((TextView) r102.findViewById(R.id.text)).setText(r101);
        ((ImageView) r102.findViewById(R.id.close_btn)).setOnClickListener(new ViewOnClickListenerC7431a(this));
    }
}
