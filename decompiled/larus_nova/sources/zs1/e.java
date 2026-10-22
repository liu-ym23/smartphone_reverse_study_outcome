package zs1;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.livesdk.coupon.balancecoupon.CouponSubType;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f573465a;

    public interface a {
        void a(com.bytedance.android.livesdk.coupon.balancecoupon.model.a r100);

        void b(com.bytedance.android.livesdk.coupon.balancecoupon.model.a r100);

        void onClose();
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        com.bytedance.android.livesdk.f.d().a();
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
        com.bytedance.android.livesdk.f.d().f();
    }

    public static String a(long r100) {
        double r101 = r100 / ((double) 100);
        Double r102 = Double.valueOf(r101 % ((double) 1));
        Double r103 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        if (r102.equals(r103) == true) goto L9;
        if (Double.valueOf(r101 % ((double) 2)).equals(r103) == true) goto L9;
        return String.valueOf(r101);
    L9:
        return String.valueOf((int) r101);
    }

    public e(Context r110, com.bytedance.android.livesdk.coupon.balancecoupon.model.a r111, i r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "data");
        Intrinsics.checkNotNullParameter(r112, "callback");
        super(r110, R.style.ttlive_balance_coupon_dialog);
        Long r100 = null;
        View r113 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_balance_coupon_layout, null);
        this.f573465a = r113;
        TextView r101 = (TextView) r113.findViewById(R.id.coupon_title);
        TextView r102 = (TextView) r113.findViewById(R.id.balance_coupon_left_amount);
        TextView r103 = (TextView) r113.findViewById(R.id.balance_coupon_right_amount);
        TextView r104 = (TextView) r113.findViewById(R.id.balance_coupon_right_amount_threshold);
        TextView r105 = (TextView) r113.findViewById(R.id.coupon_btn);
        TextView r106 = (TextView) r113.findViewById(R.id.coupon_rule_description);
        TextView r107 = (TextView) r113.findViewById(R.id.coupon_rule);
        ImageView r108 = (ImageView) r113.findViewById(R.id.coupon_rule_arrow);
        ImageView r109 = (ImageView) r113.findViewById(R.id.coupon_close_btn);
        setContentView(r113);
        r107.setOnClickListener(new zs1.a(r112, r111));
        r108.setOnClickListener(new b(r112, r111));
        r105.setOnClickListener(new c(r112, r111));
        r109.setOnClickListener(new d(r112));
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r114 = r111.d();
        if (r114 == null) goto L20;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.d r115 = r114.b();
        if (r115 == null) goto L20;
        String r116 = r115.a();
        if (r116 == null) goto L20;
        if (r116.length() <= 0) goto L11;
        boolean r117 = true;
    L12:
        if (r117 != true) goto L20;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r118 = r111.d();
        if (r118 == null) goto L18;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.d r119 = r118.b();
        if (r119 == null) goto L18;
        String r120 = r119.a();
    L19:
        r101.setText(r120);
    L18:
        r120 = null;
        goto L19
    L11:
        r117 = false;
    L20:
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r121 = r111.d();
        if (r121 == null) goto L25;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.b r122 = r121.a();
        if (r122 == null) goto L25;
        String r123 = a(r122.a());
    L26:
        r102.setText(r123);
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r124 = r111.d();
        if (r124 == null) goto L31;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.d r125 = r124.b();
        if (r125 == null) goto L31;
        String r126 = a(r125.d());
    L32:
        r103.setText(r126);
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r127 = r111.d();
        if (r127 == null) goto L45;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.d r128 = r127.b();
        if (r128 == null) goto L45;
        if (r128.b() != CouponSubType.CouponSubType_FullAmount.getValue()) goto L45;
        Object[] r129 = new Object[1];
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r130 = r111.d();
        if (r130 == null) goto L43;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.d r131 = r130.b();
        if (r131 == null) goto L43;
        String r132 = a(r131.e());
    L44:
        r129[0] = r132;
        r104.setText(LiveResUtil.getString(R.string.ttlive_balance_coupon_amount_threshold_2, r129));
    L46:
        Object[] r133 = new Object[2];
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r134 = r111.d();
        if (r134 == null) goto L51;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.b r135 = r134.a();
        if (r135 == null) goto L51;
        String r136 = a(r135.a());
    L52:
        r133[0] = r136;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r137 = r111.d();
        if (r137 == null) goto L57;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.d r138 = r137.b();
        if (r138 == null) goto L57;
        String r139 = a(r138.d());
    L58:
        r133[1] = r139;
        r105.setText(LiveResUtil.getString(R.string.ttlive_balance_coupon_btn_desc, r133));
        Object[] r140 = new Object[1];
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r141 = r111.d();
        if (r141 == null) goto L63;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.d r142 = r141.b();
        if (r142 == null) goto L63;
        r100 = Long.valueOf((long) Math.floor(r142.f() / ((long) 86400)));
    L63:
        r140[0] = r100;
        r106.setText(LiveResUtil.getString(R.string.ttlive_balance_coupon_rule_desc, r140));
        return;
    L57:
        r139 = null;
    L51:
        r136 = null;
    L43:
        r132 = null;
    L45:
        r104.setText(LiveResUtil.getString(R.string.ttlive_balance_coupon_amount_threshold_1));
    L31:
        r126 = null;
    L25:
        r123 = null;
        goto L26
    }
}
