package ih2;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.WindowManager;
import android.widget.TextView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.room.coupon.CouponGrowProvider;
import com.bytedance.common.utility.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h extends Dialog implements CouponGrowProvider.a {
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public a g;
    public long h;
    public String i;
    public long j;
    public boolean k;

    public interface a {
        void a();

        void b();

        void onDismiss();

        void onExitRoom();
    }

    public final void b() {
        if (this.f != null) goto L5;
        return;
    L5:
        CouponGrowProvider.Companion r0 = CouponGrowProvider.l;
        String r1 = this.i;
        r0.getClass();
        if (CouponGrowProvider.Companion.b(r1) > 0) goto L8;
        this.f.setText("去使用");
        return;
    L8:
        this.f.setText("继续观看");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.coupon.CouponGrowProvider.a
    public final void onFinish() {
        this.j = 0;
        onTick(0);
        b();
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L16;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        CouponGrowProvider.l.getClass();
        CouponGrowProvider r0 = CouponGrowProvider.f;
        String r1 = this.i;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "roomId");
        Intrinsics.checkNotNullParameter(this, "listener");
        if (r1.length() != 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L18;
        r0.b.put(r1, this);
        return;
    L18:
        return;
    L10:
        r2 = false;
        goto L11
    L16:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public h(Context r3) {
        super(r3, 2131952367);
        this.h = 0;
        this.j = 0;
        this.k = false;
        setContentView(2131560680);
        WindowManager.LayoutParams r4 = getWindow().getAttributes();
        r4.width = (int) UIUtils.dip2Px(getContext(), 280.0f);
        r4.height = -2;
        r4.gravity = 17;
        getWindow().setAttributes(r4);
        this.a = (TextView) findViewById(2131390449);
        this.b = (TextView) findViewById(2131390723);
        this.c = (TextView) findViewById(2131390724);
        this.d = (TextView) findViewById(2131390719);
        this.e = (TextView) findViewById(2131390720);
        ((TextView) findViewById(2131390545)).setOnClickListener(new e(this));
        TextView r5 = (TextView) findViewById(2131390549);
        this.f = r5;
        r5.setOnClickListener(new f(this));
        setOnDismissListener(new g(this));
    }

    public static void a(h r3) {
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

    @Override // com.bytedance.android.livesdk.livecommerce.room.coupon.CouponGrowProvider.a
    public final void onTick(long r4) {
        TextView r0 = this.a;
        if (r0 == null) goto L6;
        r0.setText(c(r4, this.h));
        return;
    }

    public final SpannableStringBuilder c(long r10, long r12) {
        this.j = r10;
        SpannableStringBuilder r2 = new SpannableStringBuilder();
        if (r10 > 0) goto L5;
        r2.append("优惠券已膨胀为" + r12 + "元");     // Catch: Exception -> L7
        r2.setSpan(new ForegroundColorSpan(-119723), 7, r2.length(), 33);     // Catch: Exception -> L7
    L10:
    L9:
        return r2;
    L5:
        r2.append("就剩" + r10);     // Catch: Exception -> L7
        r2.setSpan(new ForegroundColorSpan(-119723), 2, r2.length(), 33);     // Catch: Exception -> L7
        r2.append("秒即可膨胀为");     // Catch: Exception -> L7
        int r11 = r2.length();     // Catch: Exception -> L7
        r2.append(r12 + "元");     // Catch: Exception -> L7
        r2.setSpan(new ForegroundColorSpan(-119723), r11, r2.length(), 33);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L9
    }
}
