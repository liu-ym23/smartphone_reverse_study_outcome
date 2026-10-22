package ih2;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d extends Dialog {
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public Button f;
    public a g;
    public long h;

    public interface a {
        void a(long r1);

        void b();
    }

    public d(Context r3) {
        super(r3, 2131952367);
        this.h = 0;
        setContentView(2131560679);
        WindowManager.LayoutParams r4 = getWindow().getAttributes();
        r4.width = -1;
        r4.height = -2;
        r4.gravity = 80;
        getWindow().setAttributes(r4);
        this.a = (TextView) findViewById(2131390449);
        this.b = (TextView) findViewById(2131390723);
        this.c = (TextView) findViewById(2131390724);
        this.d = (TextView) findViewById(2131390719);
        this.e = (TextView) findViewById(2131390720);
        Button r5 = (Button) findViewById(2131364711);
        this.f = r5;
        r5.setOnClickListener(new b(this));
        ((Button) findViewById(2131364697)).setOnClickListener(new c(this));
    }

    public static void a(d r3) {
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

    public static SpannableStringBuilder b(long r4, long r6) {
        SpannableStringBuilder r0 = new SpannableStringBuilder();
        r0.append("完成观看直播间");     // Catch: Exception -> L5
        int r1 = r0.length();     // Catch: Exception -> L5
        r0.append(r4 + "秒");     // Catch: Exception -> L5
        r0.setSpan(new ForegroundColorSpan(-119723), r1, r0.length(), 33);     // Catch: Exception -> L5
        r0.append("任务\n优惠券金额可膨胀至");     // Catch: Exception -> L5
        int r5 = r0.length();     // Catch: Exception -> L5
        r0.append(r6 + "元");     // Catch: Exception -> L5
        r0.setSpan(new ForegroundColorSpan(-119723), r5, r0.length(), 33);     // Catch: Exception -> L5
    L4:
        return r0;
    }
}
