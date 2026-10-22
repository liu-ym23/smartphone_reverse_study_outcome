package wt0;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profit.api.ProfitApi;
import com.bytedance.android.live.profit.util.ProfitNitaViewInfo;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.g;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import dr2.h;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import zt0.f;

/* JADX INFO: loaded from: classes47.dex */
public class d implements yt0.a, o {
    public d() {
    }

    @Override // com.bytedance.android.scope.o
    public void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public void onStop() {
    }

    @Override // yt0.b
    public List<zo2.a> getProfitNitaViewList() {
        ArrayList r100 = new ArrayList();
        r100.add(ProfitNitaViewInfo.TTLIVE_VIEW_USER_INFO_MVI_FOLLOW);
        return r100;
    }

    @Override // yt0.b
    public f getPrivilegeSlardarMonitor() {
        return com.bytedance.android.live.profit.privilege.e.f88414a;
    }

    public g<?, ?> provideJsbImpl(String r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "jsbName");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        if (Intrinsics.areEqual(r100, "hasCart") == false) goto L7;
        return new pp2.c(r101);
    L7:
        if (Intrinsics.areEqual(r100, "openCart") == true) goto L9;
        return null;
    L9:
        return new pp2.e(r101);
    }

    @Override // yt0.b
    public void showVipEmojiTemplatePanel(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "requestPage");
        Intrinsics.checkNotNullParameter(r101, "authorId");
        KmpEnv r102 = KmpEnv.f255139a;
        if (KmpEnv.b() == false) goto L10;
        h r103 = (h) vh6.c.b(h.class);
        boolean r104 = r103.checkPluginLoaded("m.l.plugin.veffect_engine");
        boolean r105 = r103.checkPluginLoaded("m.l.plugin.tools_plugin");
        boolean r106 = r103.checkPluginLoaded("com.ss.android.live.broadcast");
        if (r104 == false) goto L8;
        if (r105 == false) goto L8;
        if (r106 == true) goto L10;
    L8:
        int r107 = ToastUtil.f90810a;
        ToastUtil.b(s1.B(R.string.vip_emoji_template_dialog_not_ready), 0);
        return;
    L10:
        ((com.bytedance.android.livesdk.revenue.service.room.b) vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class)).we();
        Activity r108 = ((wh6.a) vh6.c.b(wh6.a.class)).getCurrentActivity();
        LiveDialogFragment r109 = null;
        if ((r108 instanceof FragmentActivity) == true) goto L13;
        r108 = null;
    L13:
        FragmentActivity r110 = (FragmentActivity) r108;
        if (r110 == null) goto L21;
        m r111 = m.f163449e;
        cy0.e.f465759a.getClass();
        sc1.a r112 = (sc1.a) r111.d(cy0.e.a.f465760a, sc1.a.class);
        if (r112 == null) goto L18;
        r109 = r112.q0();
    L18:
        if (r109 == null) goto L22;
        FragmentManager r113 = r110.getSupportFragmentManager();
        sc1.a.f541333r2.getClass();
        INVOKEVIRTUAL_com_bytedance_android_live_profit_ProfitServiceImpl_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r109, r113, "VipEmojiTemplatePanel");
        return;
    L22:
        return;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_live_profit_ProfitServiceImpl_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(LiveDialogFragment r100, FragmentManager r101, String r102) {
        if ((r100 instanceof Fragment) == false) goto L5;
        LiveDialogFragment r103 = r100;
    L6:
        LandscapeRestrictionOperation r104 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r103, r102, r104);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r103, r104) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r100.show(r101, r102);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // yt0.b
    public Single<com.bytedance.android.live.network.response.e<com.bytedance.android.live.profit.vip.model.b>> uploadVipCustomEmoji(int r100, String r101, MultipartTypedOutput r102) {
        Intrinsics.checkNotNullParameter(r101, "authorId");
        Intrinsics.checkNotNullParameter(r102, "typedOutput");
        return RxUtilKt.i(((ProfitApi) ((com.bytedance.android.livesdk.revenue.service.network.a) vh6.c.b(com.bytedance.android.livesdk.revenue.service.network.a.class)).getService(ProfitApi.class)).uploadSubscribeCustomEmoji(r100, r101, r102).singleOrError());
    }
}
