package com.bytedance.ee.bear.document.orientation;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/document/orientation/CommonOrientationPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "TAG", "", "LANDSCAPE_CONTROL", "switchToPortraitByWeb", "", "getSwitchToPortraitByWeb", "()Z", "setSwitchToPortraitByWeb", "(Z)V", "supportLandscape", "getSupportLandscape", "setSupportLandscape", "onAttachToUIContainer", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "handleOrientationFromJs", "data", "Lcom/bytedance/ee/bear/document/orientation/CommonOrientationPlugin$LandscapeControlMeta;", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "forcePortrait", "forceLandscape", "isLock", "LandscapeHandler", "LandscapeControlMeta", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CommonOrientationPlugin extends DocumentPlugin {
    private final String LANDSCAPE_CONTROL;
    private final String TAG;
    private boolean supportLandscape;
    private boolean switchToPortraitByWeb;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/document/orientation/CommonOrientationPlugin$LandscapeControlMeta;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "landscape", "", "getLandscape", "()Z", "setLandscape", "(Z)V", "support_landscape", "getSupport_landscape", "setSupport_landscape", "enableOrientationTip", "getEnableOrientationTip", "setEnableOrientationTip", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LandscapeControlMeta implements NonProguard {
        private boolean enableOrientationTip;
        private boolean landscape;
        private boolean support_landscape;

        public LandscapeControlMeta() {
            this.support_landscape = true;
            this.enableOrientationTip = true;
        }

        public final boolean getEnableOrientationTip() {
            return this.enableOrientationTip;
        }

        public final boolean getLandscape() {
            return this.landscape;
        }

        public final boolean getSupport_landscape() {
            return this.support_landscape;
        }

        public final void setEnableOrientationTip(boolean r1) {
            this.enableOrientationTip = r1;
        }

        public final void setLandscape(boolean r1) {
            this.landscape = r1;
        }

        public final void setSupport_landscape(boolean r1) {
            this.support_landscape = r1;
        }
    }

    public final class a implements tb5.i<LandscapeControlMeta> {
        public final /* synthetic */ CommonOrientationPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(CommonOrientationPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            CommonOrientationPlugin r0 = this.a;
            r0.handleOrientationFromJs((LandscapeControlMeta) r2, r3);
        }
    }

    public void forceLandscape() {
    }

    public void forcePortrait() {
    }

    public boolean isLock() {
        return false;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public CommonOrientationPlugin() {
        this.TAG = "CommonOrientationPlugin";
        this.LANDSCAPE_CONTROL = "biz.control.functions";
        this.supportLandscape = true;
    }

    public final boolean getSupportLandscape() {
        return this.supportLandscape;
    }

    public final boolean getSwitchToPortraitByWeb() {
        return this.switchToPortraitByWeb;
    }

    public final void setSupportLandscape(boolean r1) {
        this.supportLandscape = r1;
    }

    public final void setSwitchToPortraitByWeb(boolean r1) {
        this.switchToPortraitByWeb = r1;
    }

    public void handleOrientationFromJs(LandscapeControlMeta r2, tb5.m r3) {
        if (r2 != null) goto L5;
        tt5.a.d(this.TAG, "landscape control, data is null");
        return;
    L5:
        boolean r4 = r2.getLandscape();
        if (r4 == true) goto L8;
    L10:
        if (r4 == true) goto L14;
        this.switchToPortraitByWeb = true;
        this.supportLandscape = r2.getSupport_landscape();
        forcePortrait();
        return;
    L14:
        return;
    L8:
        if (isLock() == true) goto L10;
        getActivity().setRequestedOrientation(-1);
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super.onAttachToUIContainer(r1, r2);
        bindBridgeHandler(this.LANDSCAPE_CONTROL, new a(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }
}
