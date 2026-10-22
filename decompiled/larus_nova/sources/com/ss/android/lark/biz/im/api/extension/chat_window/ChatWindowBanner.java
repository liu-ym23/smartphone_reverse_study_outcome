package com.ss.android.lark.biz.im.api.extension.chat_window;

import androidx.lifecycle.LifecycleOwner;
import com.ss.android.lark.flow.chat.page.flow.plugin.FlowRelationshipBanner;
import com.ss.android.lark.scaffold.IComponent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0015J\u001e\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u001a\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH&J\u0012\u0010\u000b\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\u0006H&J\u001e\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010\u000e\u001a\u00020\u00062\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H&J\u0012\u0010\u0011\u001a\u00020\u00042\b\b\u0001\u0010\u000e\u001a\u00020\u0006H&J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H&¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowBanner;", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/ss/android/lark/scaffold/IComponent;", "showBanner", "", "type", "", "data", "Lcom/ss/android/lark/biz/im/extension/chat_window/banner/IBannerData;", "view", "Landroid/view/View;", "hideBanner", "bannerType", "registerBanner", "key", "banner", "Lcom/ss/android/lark/biz/im/extension/chat_window/banner/IBanner;", "unregisterBanner", "registerBannerCallback", "callback", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowBanner$IBannerComponentCallbacks;", "IBannerComponentCallbacks", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ChatWindowBanner extends LifecycleOwner, IComponent {

    public interface a extends e {
        void c();
    }

    void AI(wya.b r100);

    void U20();

    void VH();

    void lq(FlowRelationshipBanner.d r100);
}
