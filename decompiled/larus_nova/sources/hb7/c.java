package hb7;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.crash.d;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes22.dex */
public final class c extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public hb7.b f484497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f484498b;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f484499a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f484500b;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            c.a(this.f484500b);
            View.OnClickListener r101 = this.f484499a;
            if (r101 == null) goto L6;
            r101.onClick(r100);
            return;
        }

        public a(c r100, View.OnClickListener r101) {
            this.f484500b = r100;
            this.f484499a = r101;
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f484501a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f484502b;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            c.a(this.f484502b);
            View.OnClickListener r101 = this.f484501a;
            if (r101 == null) goto L6;
            r101.onClick(r100);
            return;
        }

        public b(c r100, View.OnClickListener r101) {
            this.f484502b = r100;
            this.f484501a = r101;
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L18:
        if (this.f484498b == true) goto L28;
        hb7.b r101 = this.f484497a;
        if (r101 == null) goto L29;
        r101.getClass();
        return;
    L29:
        return;
    L28:
        return;
    L12:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r102 == null) goto L16;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L18
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        Window r100 = getWindow();
        if (r100 == null) goto L14;
        Resources r101 = getContext().getResources();
        r100.setLayout((int) (((double) WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).widthPixels) * 0.73d), -2);
        return;
    L14:
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public c(Context r100) {
        super(r100, R.style.account_more_login_dialog_style);
        this.f484498b = false;
    }

    public static void a(c r100) {
        r100.f484498b = true;
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
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r102 == null) goto L16;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L7;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        View r111 = LayoutInflater.from(getContext()).inflate(R.layout.account_tips_dialog_content, null);
        TextView r100 = (TextView) r111.findViewById(R.id.tv_title);
        TextView r101 = (TextView) r111.findViewById(R.id.tv_message);
        r111.findViewById(R.id.vertical_divider);
        r111.findViewById(R.id.click_item_layout);
        TextView r102 = (TextView) r111.findViewById(R.id.item_negative);
        TextView r103 = (TextView) r111.findViewById(R.id.item_positive);
        View r104 = r111.findViewById(R.id.horizontal_divider);
        int r105 = getContext().getResources().getColor(R.color.account_main_text_color);
        int r106 = getContext().getResources().getColor(R.color.account_primary_color);
        if (TextUtils.isEmpty(this.f484497a.f484492a) == false) goto L5;
        r100.setVisibility(8);
    L7:
        if (TextUtils.isEmpty(this.f484497a.f484493b) == false) goto L9;
        r101.setVisibility(8);
    L10:
        hb7.b r107 = this.f484497a;
        hb7.a r108 = r107.f484494c;
        hb7.a r109 = r107.f484495d;
        if (r108 != null) goto L13;
    L15:
        if (r109 != null) goto L17;
    L19:
        setCanceledOnTouchOutside(this.f484497a.f484496e);
        setContentView(r111);
        return;
    L17:
        if (TextUtils.isEmpty(r109.f484490a) == true) goto L19;
        r103.setVisibility(0);
        r103.setText(r109.f484490a);
        r103.setTextColor(r106);
        r103.setOnClickListener(new b(this, r109.f484491b));
        goto L19
    L13:
        if (TextUtils.isEmpty(r108.f484490a) == true) goto L15;
        r104.setVisibility(0);
        r102.setVisibility(0);
        r102.setText(r108.f484490a);
        r102.setTextColor(r105);
        r102.setOnClickListener(new a(this, r108.f484491b));
        goto L15
    L9:
        r101.setText(this.f484497a.f484493b);
        r101.setTextColor(r105);
        goto L10
    L5:
        r100.setText(this.f484497a.f484492a);
        r100.setTextColor(r105);
        goto L7
    }
}
