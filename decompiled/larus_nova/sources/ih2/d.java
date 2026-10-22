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
import com.android.ttcjpaysdk.base.ui.widget.CJBadgeTextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes10.dex */
public final class d extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f489777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f489778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f489779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f489780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f489781e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Button f489782f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f489783g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f489784h;

    public interface a {
        void a(long r100);

        void b();
    }

    public d(Context r100) {
        super(r100, R.style.ECTransparentFullScreenDialogStyle);
        this.f489784h = 0;
        setContentView(R.layout.ec_enter_room_coupon_grow_dialog);
        WindowManager.LayoutParams r101 = getWindow().getAttributes();
        r101.width = -1;
        r101.height = -2;
        r101.gravity = 80;
        getWindow().setAttributes(r101);
        this.f489777a = (TextView) findViewById(R.id.tv_coupon_title);
        this.f489778b = (TextView) findViewById(R.id.tv_grow_ago_coupon_info);
        this.f489779c = (TextView) findViewById(R.id.tv_grow_ago_coupon_num);
        this.f489780d = (TextView) findViewById(R.id.tv_grow_after_coupon_info);
        this.f489781e = (TextView) findViewById(R.id.tv_grow_after_coupon_num);
        Button r102 = (Button) findViewById(R.id.btn_direct_obtain);
        this.f489782f = r102;
        r102.setOnClickListener(new b(this));
        ((Button) findViewById(R.id.btn_coupon_grow)).setOnClickListener(new c(this));
    }

    public static void a(d r100) {
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

    public static SpannableStringBuilder b(long r100, long r101) {
        SpannableStringBuilder r102 = new SpannableStringBuilder();
        r102.append("完成观看直播间");     // Catch: Exception -> L5
        int r103 = r102.length();     // Catch: Exception -> L5
        r102.append(r100 + "秒");     // Catch: Exception -> L5
        r102.setSpan(new ForegroundColorSpan(CJBadgeTextView.BADGE_COLOR), r103, r102.length(), 33);     // Catch: Exception -> L5
        r102.append("任务\n优惠券金额可膨胀至");     // Catch: Exception -> L5
        int r104 = r102.length();     // Catch: Exception -> L5
        r102.append(r101 + "元");     // Catch: Exception -> L5
        r102.setSpan(new ForegroundColorSpan(CJBadgeTextView.BADGE_COLOR), r104, r102.length(), 33);     // Catch: Exception -> L5
    L4:
        return r102;
    }
}
