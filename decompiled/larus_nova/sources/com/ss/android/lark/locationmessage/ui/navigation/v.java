package com.ss.android.lark.locationmessage.ui.navigation;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.integrator.im.message.MessageLocationProvider$1$1;
import com.ss.android.lark.statistics.Statistics;

/* JADX INFO: loaded from: classes36.dex */
public final class v implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NavigateView f431380a;

    public v(NavigateView r100) {
        this.f431380a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r110) {
        if (r110 != 0) goto L4;
        NavigateView r101 = this.f431380a;
        String[] r111 = NavigateView.f431337p;
        r101.getClass();
        Statistics.sendEvent("message_location_share_click");
        if (r101.f431346h != null) goto L21;
        LKUIToast.show(r101.f431340b, R.string.Lark_Legacy_FailedToForward);
        return;
    L21:
        MessageLocationProvider$1$1 r112 = lqb.b.f510384a.getChatDependency();
        String r102 = r101.f431345g;
        if (r102 != null) goto L24;
        r102 = "";
    L24:
        Activity r103 = r101.f431340b;
        Message r104 = r101.f431346h;
        r112.getClass();
        int r105 = FlowChatModule.f422022d;
        egb.e r106 = FlowChatModule.a.a().a().getForwardDependency();
        r106.d(r103, 6, r104, r102, false, null);
        return;
    L4:
        if (r110 != 1) goto L31;
        NavigateView r107 = this.f431380a;
        if (r107.f431351m == true) goto L9;
        return;
    L9:
        if (r107.f431348j != null) goto L17;
        Statistics.sendEvent("message_location_favorite_click");
        Message r113 = r107.f431346h;
        if (r113 != null) goto L13;
    L16:
        LKUIToast.show(r107.f431340b, R.string.Lark_Legacy_SaveBoxSaveFail);
        return;
    L13:
        if (TextUtils.isEmpty(r113.getId()) == true) goto L16;
        new NavigateView.AnonymousClass7(r107);
        com.ss.android.lark.integrator.im.message.b r114 = lqb.b.f510384a.getFavoriteDependency();
        new UIGetDataCallback(new NavigateView.AnonymousClass8(r107));
        r114.getClass();
        return;
    L17:
        new NavigateView.AnonymousClass9(r107);
        com.ss.android.lark.integrator.im.message.b r115 = lqb.b.f510384a.getFavoriteDependency();
        new UIGetDataCallback(new NavigateView.AnonymousClass10(r107));
        r115.getClass();
        return;
    }
}
