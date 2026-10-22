package com.larus.bmhome.chat.bubble.floating.source;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerDismissReason;
import com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener;
import com.larus.commercemembership.api.ICommerceMembershipService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sc8.b;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/source/CommerceMembershipCTABubbleBannerSourceListener;", "Lcom/larus/bmhome/chat/bubble/floating/event/BubbleBannerSourceListener;", "<init>", "()V", "bannerSource", "", "getBannerSource", "()Ljava/lang/String;", "popupType", "event", "Lcom/larus/bmhome/chat/bubble/floating/event/BubbleBannerEvent;", SendEventContainerMethodParamModel.EventKinds.onShow, "", SendEventContainerMethodParamModel.EventKinds.onClick, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommerceMembershipCTABubbleBannerSourceListener implements BubbleBannerSourceListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f297558a;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final String b(b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return "ug_free_subs_download_pc";
    }

    public CommerceMembershipCTABubbleBannerSourceListener() {
        this.f297558a = "commerce_pc_new_user_campaign";
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final String c() {
        return this.f297558a;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void e(b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        ICommerceMembershipService.f325827a.getClass();
        ICommerceMembershipService r101 = ICommerceMembershipService.a.a();
        if (r101 == null) goto L6;
        r101.o();
        return;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void g(b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void i(b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        ICommerceMembershipService.f325827a.getClass();
        ICommerceMembershipService r101 = ICommerceMembershipService.a.a();
        if (r101 == null) goto L6;
        r101.h();
        return;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void d(b r100, BubbleBannerDismissReason r101) {
        BubbleBannerSourceListener.a.b(r100, r101);
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void h(b r100, sc8.a r101) {
        BubbleBannerSourceListener.a.a(r100, r101);
    }
}
