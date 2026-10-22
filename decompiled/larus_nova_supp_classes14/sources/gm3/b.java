package gm3;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public final hm3.b a;
    public final hm3.a b;
    public final List<gm3.a> c;
    public final String d;
    public final Dialog e;
    public boolean f;

    public static final class a implements DialogInterface.OnDismissListener {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r2) {
            b r3 = this.a;
            if (r3.f == true) goto L8;
            hm3.a r4 = r3.b;
            if (r4 == null) goto L9;
            r4.onCancel();
            return;
        L9:
            return;
        }
    }

    public final void b() {
        Dialog r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L8;
        a(r0);
    L8:
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(r0);
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L11:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
    }

    public static void a(Dialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public b(hm3.b r9, hm3.a r10, String r11, List<gm3.a> r12, Context r13, String r14) {
        this.a = r9;
        this.b = r10;
        this.c = r12;
        this.d = r14;
        if (r13 == null) goto L31;
        Dialog r15 = new Dialog(r13, 2131954893);
        this.e = r15;
        r15.setCancelable(true);
        Window r0 = r15.getWindow();
        if (r0 == null) goto L7;
        r0.setBackgroundDrawableResource(R.color.transparent);
        r0.setWindowAnimations(2131954905);
        r0.setAttributes(r0.getAttributes());
        r0.setGravity(80);
    L7:
        View r1 = LayoutInflater.from(r13).inflate(2131568107, null);
        r1.setMinimumWidth(10000);
        TextView r2 = (TextView) r1.findViewById(2131362135);
        if (r11 == null) goto L10;
        r2.setText(r11);
    L10:
        r2.setOnClickListener(new d(this));
        TextView r16 = (TextView) r1.findViewById(2131362137);
        if (TextUtils.isEmpty(r14) == false) goto L13;
        r16.setVisibility(8);
    L14:
        LinearLayout r17 = (LinearLayout) r1.findViewById(2131362136);
        if (r12 == null) goto L26;
        int r18 = r12.size();
        int r3 = 0;
    L17:
        if (r3 >= r18) goto L26;
        if (r3 == 0) goto L20;
    L22:
        boolean r4 = false;
    L23:
        if (r4 == true) goto L25;
        View r5 = new View(r13);
        r5.setBackgroundColor(r13.getResources().getColor(2131108356));
        r5.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        r17.addView(r5);
    L25:
        View r6 = LayoutInflater.from(r13).inflate(2131568108, null);
        r17.addView(r6);
        gm3.a r7 = (gm3.a) ListProtector.get(r12, r3);
        ((TextView) r6.findViewById(2131362140)).setText(r7.b);
        r6.setOnClickListener(new c(r7, this));
        r3 = r3 + 1;
        goto L17
    L20:
        if (TextUtils.isEmpty(this.d) == false) goto L22;
        r4 = true;
    L26:
        r15.setContentView(r1);
        r15.setOnDismissListener(new a(this));
        return;
    L13:
        r16.setVisibility(0);
        r16.setText(r14);
        goto L14
    }
}
