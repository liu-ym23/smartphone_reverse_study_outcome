package ih2;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.WindowManager;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.ui.widget.CJBadgeTextView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.room.coupon.CouponGrowProvider;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class h extends Dialog implements CouponGrowProvider.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f489788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f489789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f489790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f489791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f489792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f489793f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f489794g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f489795h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f489796i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f489797j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f489798k;

    public interface a {
        void a();

        void b();

        void onDismiss();

        void onExitRoom();
    }

    public final void b() {
        if (this.f489793f != null) goto L5;
        return;
    L5:
        CouponGrowProvider.Companion r100 = CouponGrowProvider.f151736l;
        String r101 = this.f489796i;
        r100.getClass();
        if (CouponGrowProvider.Companion.b(r101) > 0) goto L8;
        this.f489793f.setText("去使用");
        return;
    L8:
        this.f489793f.setText("继续观看");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.coupon.CouponGrowProvider.a
    public final void onFinish() {
        this.f489797j = 0;
        onTick(0);
        b();
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L16;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        CouponGrowProvider.f151736l.getClass();
        CouponGrowProvider r100 = CouponGrowProvider.f151730f;
        String r101 = this.f489796i;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "roomId");
        Intrinsics.checkNotNullParameter(this, "listener");
        if (r101.length() != 0) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L18;
        r100.f151738b.put(r101, this);
        return;
    L18:
        return;
    L10:
        r102 = false;
        goto L11
    L16:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public h(Context r100) {
        super(r100, R.style.ECTransparentFullScreenDialogStyle);
        this.f489795h = 0;
        this.f489797j = 0;
        this.f489798k = false;
        setContentView(R.layout.ec_exit_room_coupon_grow_dialog);
        WindowManager.LayoutParams r101 = getWindow().getAttributes();
        r101.width = (int) UIUtils.dip2Px(getContext(), 280.0f);
        r101.height = -2;
        r101.gravity = 17;
        getWindow().setAttributes(r101);
        this.f489788a = (TextView) findViewById(R.id.tv_coupon_title);
        this.f489789b = (TextView) findViewById(R.id.tv_grow_ago_coupon_info);
        this.f489790c = (TextView) findViewById(R.id.tv_grow_ago_coupon_num);
        this.f489791d = (TextView) findViewById(R.id.tv_grow_after_coupon_info);
        this.f489792e = (TextView) findViewById(R.id.tv_grow_after_coupon_num);
        ((TextView) findViewById(R.id.tv_ec_cancel)).setOnClickListener(new e(this));
        TextView r102 = (TextView) findViewById(R.id.tv_ec_confirm);
        this.f489793f = r102;
        r102.setOnClickListener(new f(this));
        setOnDismissListener(new g(this));
    }

    public static void a(h r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.coupon.CouponGrowProvider.a
    public final void onTick(long r100) {
        TextView r101 = this.f489788a;
        if (r101 == null) goto L6;
        r101.setText(c(r100, this.f489795h));
        return;
    }

    public final SpannableStringBuilder c(long r110, long r111) {
        this.f489797j = r110;
        SpannableStringBuilder r100 = new SpannableStringBuilder();
        if (r110 > 0) goto L5;
        r100.append("优惠券已膨胀为" + r111 + "元");     // Catch: Exception -> L7
        r100.setSpan(new ForegroundColorSpan(CJBadgeTextView.BADGE_COLOR), 7, r100.length(), 33);     // Catch: Exception -> L7
    L10:
    L9:
        return r100;
    L5:
        r100.append("就剩" + r110);     // Catch: Exception -> L7
        r100.setSpan(new ForegroundColorSpan(CJBadgeTextView.BADGE_COLOR), 2, r100.length(), 33);     // Catch: Exception -> L7
        r100.append("秒即可膨胀为");     // Catch: Exception -> L7
        int r112 = r100.length();     // Catch: Exception -> L7
        r100.append(r111 + "元");     // Catch: Exception -> L7
        r100.setSpan(new ForegroundColorSpan(CJBadgeTextView.BADGE_COLOR), r112, r100.length(), 33);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L9
    }
}
