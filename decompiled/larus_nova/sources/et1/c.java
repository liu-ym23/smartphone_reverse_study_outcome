package et1;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f473872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f473873b;

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
        com.bytedance.android.livesdk.f.d().f();
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(this.f473872a);
        com.bytedance.android.livesdk.f.d().a();
    }

    public c(Context r110, com.bytedance.android.livesdk.coupon.balancecoupon.model.c r111, f r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "data");
        Intrinsics.checkNotNullParameter(r112, "dialogCallback");
        super(r110, R.style.ttlive_full_refund_coupon_dialog);
        this.f473873b = r112;
        Long r100 = null;
        View r113 = LayoutInflater.from(r110).inflate(R.layout.ttlive_full_refund_coupon_dialog, null);
        this.f473872a = r113;
        HSImageView r101 = (HSImageView) r113.findViewById(R.id.full_refund_coupon_bg);
        com.bytedance.android.livesdk.coupon.refundcoupon.model.b r102 = r111.b();
        if (r102 == null) goto L5;
        String r103 = r102.a();
    L6:
        Uri r104 = UriProtector.parse(r103);
        if (r101 == null) goto L11;
        if (r104 == null) goto L11;
        r101.setImageURI(r104);
    L11:
        HSImageView r105 = (HSImageView) r113.findViewById(R.id.user_avatar);
        TextView r106 = (TextView) r113.findViewById(R.id.refund_coupon_main_text);
        TextView r107 = (TextView) r113.findViewById(R.id.refund_coupon_sub_text);
        HSImageView r108 = (HSImageView) r113.findViewById(R.id.coupon_dialog_dismiss);
        Button r109 = (Button) r113.findViewById(R.id.do_obtain_btn);
        TextView r114 = (TextView) r113.findViewById(R.id.refund_coupon_price_text);
        RoomContext r115 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r115 == null) goto L16;
        m<Room> r116 = r115.getRoom();
        if (r116 == null) goto L16;
        Room r117 = r116.getValue();
    L17:
        if (r117 == null) goto L23;
        User r118 = r117.mo8271getOwner();
        if (r118 == null) goto L21;
        ImageModel r119 = r118.getAvatarThumbByRoomAuth(r117.getMRoomAuthStatus());
    L22:
        ImageUtil.loadRoundImage(r105, r119);
        goto L23
    L21:
        r119 = null;
    L23:
        if (r108 == null) goto L25;
        r108.setOnClickListener(new a(this));
    L25:
        if (r109 == null) goto L27;
        r109.setOnClickListener(new b(this, r110));
    L27:
        if (r106 == null) goto L33;
        com.bytedance.android.livesdk.coupon.refundcoupon.model.b r120 = r111.b();
        if (r120 == null) goto L31;
        String r121 = r120.d();
    L32:
        r106.setText(r121);
        goto L33
    L31:
        r121 = null;
    L33:
        if (r107 == null) goto L39;
        com.bytedance.android.livesdk.coupon.refundcoupon.model.b r122 = r111.b();
        if (r122 == null) goto L37;
        String r123 = r122.b();
    L38:
        r107.setText(r123);
        goto L39
    L37:
        r123 = null;
    L39:
        if (r114 == null) goto L48;
        com.bytedance.android.livesdk.coupon.refundcoupon.model.b r124 = r111.b();
        if (r124 == null) goto L43;
        r100 = r124.c();
    L43:
        if (r100 != null) goto L45;
        String r125 = "";
    L46:
        r114.setText(r125);
        return;
    L45:
        r125 = String.valueOf(r100.longValue() / ((long) 100));
        goto L46
    L48:
        return;
    L16:
        r117 = null;
        goto L17
    L5:
        r103 = null;
        goto L6
    }
}
