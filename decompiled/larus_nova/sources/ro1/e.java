package ro1;

import android.view.View;
import com.bytedance.android.live.browser.d0;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.base.BaseBannerWidget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e extends d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseBannerWidget f538758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BannerInRoomCollection.BannerInfo f538759b;

    @Override // com.bytedance.android.live.browser.d0
    public final void a() {
        this.f538758a.Cq(this.f538759b);
    }

    @Override // com.bytedance.android.live.browser.d0
    public final void g(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        BaseBannerWidget r101 = this.f538758a;
        BannerInRoomCollection.BannerInfo r102 = this.f538759b;
        r101.Aq(r100, r102.lynxUrl, r102);
    }

    public e(BaseBannerWidget r100, BannerInRoomCollection.BannerInfo r101) {
        this.f538758a = r100;
        this.f538759b = r101;
    }

    @Override // com.bytedance.android.live.browser.d0
    public final void f(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        BaseBannerWidget r102 = this.f538758a;
        r102.f115163b = true;
        r102.Bq(r100, this.f538759b.lynxUrl, r101);
    }
}
