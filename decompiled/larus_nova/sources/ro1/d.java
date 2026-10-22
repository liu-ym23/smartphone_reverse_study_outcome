package ro1;

import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.base.BaseBannerWidget;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements com.bytedance.ies.web.jsbridge2.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseBannerWidget f538757a;

    public d(BaseBannerWidget r100) {
        this.f538757a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f.b
    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return new wo1.c(this.f538757a.contentView, "活动入口");
    }
}
