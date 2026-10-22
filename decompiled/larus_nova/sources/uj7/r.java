package uj7;

import android.view.View;
import com.bytedance.ug.sdk.luckycat.impl.lynx.LuckyFloatBarViewManager;
import com.bytedance.ug.sdk.luckycat.impl.project.ProjectActivity;

/* JADX INFO: loaded from: classes22.dex */
public final class r implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProjectActivity f550430a;

    public r(ProjectActivity r100) {
        this.f550430a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LuckyFloatBarViewManager.p(this.f550430a, "sslocal://polaris/lynxview?is_floating_bar=true&preload_popup=false&left_margin=10&top_margin=10&right_margin=87&use_bullet_container=1&gravity=top&surl=https%3A%2F%2Ftosv.byted.org%2Fobj%2Fgecko-internal%2F10147%2Fgecko%2Fresource%2Fnovel_fission_lynx_card%2Fpopup%2Ftest_bar%2Ftemplate.js&scene=main&extra_jsb=luckycat&first_frame_data={\"icon\":\"https://p1-luckycatopen.byteimg.com/tos-cn-i-gnrt7m25cu/fm-cash-ios.png~tplv-gnrt7m25cu-image.image\",\"desc\":\"你有0.3元可提现到微信\",\"action_desc\":\"立即提现\",\"amount\":30,\"take_cash_ways\":[1,3,8],\"task_key\":\"take_cash_low_active\",\"ali_auth_conf\":{\"is_alipay_oauth\":false,\"alipay_name\":\"\",\"is_alipay_trend\":false,\"alipay_uid\":\"\"}}&popup_after_jsb_ready=1&gecko_enable=1&expire_time=1903229881&pop_name=novel_fission_withdraw_guide");
    }
}
