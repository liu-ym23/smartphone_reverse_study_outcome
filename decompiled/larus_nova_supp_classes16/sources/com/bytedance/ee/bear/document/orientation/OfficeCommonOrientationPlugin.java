package com.bytedance.ee.bear.document.orientation;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000  2\u00020\u0001:\u0003 !\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J \u0010\u0013\u001a\u00020\u000e2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u0015H\u0016J\u001c\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/document/orientation/OfficeCommonOrientationPlugin;", "Lcom/bytedance/ee/bear/document/base/DocumentPluginV3;", "<init>", "()V", "switchToPortraitByWeb", "", "getSwitchToPortraitByWeb", "()Z", "setSwitchToPortraitByWeb", "(Z)V", "supportLandscape", "getSupportLandscape", "setSupportLandscape", "onAttachToUIContainer", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "getBridgeHandlers", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "handleOrientationFromJs", "data", "Lcom/bytedance/ee/bear/document/orientation/OfficeCommonOrientationPlugin$LandscapeControlMeta;", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "forcePortrait", "forceLandscape", "isLock", "Companion", "LandscapeHandler", "LandscapeControlMeta", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class OfficeCommonOrientationPlugin extends DocumentPluginV3 {
    public static final a Companion = null;
    private static final String LANDSCAPE_CONTROL = null;
    private static final String TAG = "OfficeCommonOrientationPlugin";
    private boolean supportLandscape;
    private boolean switchToPortraitByWeb;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/document/orientation/OfficeCommonOrientationPlugin$LandscapeControlMeta;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "landscape", "", "getLandscape", "()Z", "setLandscape", "(Z)V", "support_landscape", "getSupport_landscape", "setSupport_landscape", "enableOrientationTip", "getEnableOrientationTip", "setEnableOrientationTip", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public static final class a {
        public a() {
        }
    }

    public final class b implements tb5.i<LandscapeControlMeta> {
        public final /* synthetic */ OfficeCommonOrientationPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(OfficeCommonOrientationPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            OfficeCommonOrientationPlugin r0 = this.a;
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

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    static {
        Companion = new a();
        LANDSCAPE_CONTROL = "biz.control.functions";
    }

    public OfficeCommonOrientationPlugin() {
        this.supportLandscape = true;
    }

    public final boolean getSupportLandscape() {
        return this.supportLandscape;
    }

    public final boolean getSwitchToPortraitByWeb() {
        return this.switchToPortraitByWeb;
    }

    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put(LANDSCAPE_CONTROL, new b(this));
    }

    public final void setSupportLandscape(boolean r1) {
        this.supportLandscape = r1;
    }

    public final void setSwitchToPortraitByWeb(boolean r1) {
        this.switchToPortraitByWeb = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handleOrientationFromJs(LandscapeControlMeta r2, tb5.m r3) {
        if (r2 != null) goto L5;
        tt5.a.d(TAG, "landscape control, data is null");
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

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToUIContainer(ChameleonPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r1, r2);
    }
}
