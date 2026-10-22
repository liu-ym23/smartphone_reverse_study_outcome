package com.bytedance.ee.bear.bizwidget.shareview;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@AppConfig(key = "external_share_config")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/bizwidget/shareview/ExternalShareMinaConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "WXConfig", "Lcom/bytedance/ee/bear/bizwidget/shareview/ExternalShareMinaConfig$ChannelConfig;", "getWXConfig", "()Lcom/bytedance/ee/bear/bizwidget/shareview/ExternalShareMinaConfig$ChannelConfig;", "setWXConfig", "(Lcom/bytedance/ee/bear/bizwidget/shareview/ExternalShareMinaConfig$ChannelConfig;)V", "QQConfig", "getQQConfig", "setQQConfig", "WBConfig", "getWBConfig", "setWBConfig", "enableShareMiniApp", "", "getEnableShareMiniApp", "()Z", "setEnableShareMiniApp", "(Z)V", "isShareChannelBanned", "type", "Lcom/bytedance/ee/bear/bizwidget/shareview/ShareType;", "isShareDomainBanned", "isEnableShareMiniApp", "ChannelConfig", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExternalShareMinaConfig implements NonProguard {
    private ChannelConfig QQConfig;
    private ChannelConfig WBConfig;
    private ChannelConfig WXConfig;
    private boolean enableShareMiniApp;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bizwidget/shareview/ExternalShareMinaConfig$ChannelConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "isShareChannelBanned", "", "()Z", "setShareChannelBanned", "(Z)V", "isShareDomainBanned", "setShareDomainBanned", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ChannelConfig implements NonProguard {
        private boolean isShareChannelBanned;
        private boolean isShareDomainBanned;

        public ChannelConfig() {
            this.isShareChannelBanned = true;
        }

        public final boolean isShareChannelBanned() {
            return this.isShareChannelBanned;
        }

        public final boolean isShareDomainBanned() {
            return this.isShareDomainBanned;
        }

        public final void setShareChannelBanned(boolean r1) {
            this.isShareChannelBanned = r1;
        }

        public final void setShareDomainBanned(boolean r1) {
            this.isShareDomainBanned = r1;
        }
    }

    public ExternalShareMinaConfig() {
        this.WXConfig = new ChannelConfig();
        this.QQConfig = new ChannelConfig();
        this.WBConfig = new ChannelConfig();
    }

    public final boolean getEnableShareMiniApp() {
        return this.enableShareMiniApp;
    }

    public final ChannelConfig getQQConfig() {
        return this.QQConfig;
    }

    public final ChannelConfig getWBConfig() {
        return this.WBConfig;
    }

    public final ChannelConfig getWXConfig() {
        return this.WXConfig;
    }

    public final boolean isEnableShareMiniApp() {
        return this.enableShareMiniApp;
    }

    public final boolean isShareChannelBanned(ShareType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        if (r2 == ShareType.Wechat) goto L18;
        if (r2 == ShareType.WechatMoments) goto L18;
        if (r2 != ShareType.QQ) goto L12;
        return this.QQConfig.isShareChannelBanned();
    L12:
        if (r2 == ShareType.Weibo) goto L14;
        return true;
    L14:
        return this.WBConfig.isShareChannelBanned();
    L18:
        return this.WXConfig.isShareChannelBanned();
    }

    public final boolean isShareDomainBanned(ShareType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        if (r2 == ShareType.Wechat) goto L18;
        if (r2 == ShareType.WechatMoments) goto L18;
        if (r2 != ShareType.QQ) goto L12;
        return this.QQConfig.isShareDomainBanned();
    L12:
        if (r2 == ShareType.Weibo) goto L14;
        return false;
    L14:
        return this.WBConfig.isShareDomainBanned();
    L18:
        return this.WXConfig.isShareDomainBanned();
    }

    public final void setEnableShareMiniApp(boolean r1) {
        this.enableShareMiniApp = r1;
    }

    public final void setQQConfig(ChannelConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.QQConfig = r2;
    }

    public final void setWBConfig(ChannelConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.WBConfig = r2;
    }

    public final void setWXConfig(ChannelConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.WXConfig = r2;
    }
}
