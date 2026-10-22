package com.bytedance.ee.bear.bitable.titlebar;

import android.view.View;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ee.bear.document.customheader.CustomHeaderFragment;
import com.bytedance.ee.bear.document.customheader.CustomHeaderPlugin;
import com.bytedance.ee.bear.document.customheader.CustomHeaderViewModel;
import com.bytedance.ee.bear.document.y5;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016J \u0010\t\u001a\u00020\n2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\fH\u0016J\"\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\rH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0006\"\u0004\b\u0007\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/bitable/titlebar/ExtensionHeaderPlugin;", "Lcom/bytedance/ee/bear/document/customheader/CustomHeaderPlugin;", "isImmersive", "", "<init>", "(Z)V", "()Z", "setImmersive", "isViewImmersive", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "decorateHeader", "customHeaderConfig", "Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig;", "customHeaderFragment", "Lcom/bytedance/ee/bear/document/customheader/CustomHeaderFragment;", "viewModel", "Lcom/bytedance/ee/bear/document/customheader/CustomHeaderViewModel;", "getPluginId", "BitableHeaderHandler", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtensionHeaderPlugin extends CustomHeaderPlugin {
    private boolean isImmersive;

    public final class a extends CustomHeaderPlugin.a<BitableHeaderConfig> {
        public a(ExtensionHeaderPlugin r1) {
            super(r1);
        }

        @Override // com.bytedance.ee.bear.document.customheader.CustomHeaderPlugin.a
        public final /* bridge */ /* synthetic */ void a(CustomHeaderConfig r1, m r2) {
            d((BitableHeaderConfig) r1, r2);
        }

        public final void d(BitableHeaderConfig r4, m r5) {
            String r0 = null;
            if (r4 == null) goto L5;
            BitableCatalogModel r1 = r4.getBitableCatalog();
        L6:
            if (r1 == null) goto L19;
            CustomHeaderConfig.TitleConfig r2 = r4.getTitleConfig();
            if (r2 == null) goto L10;
            r2.setId("catalog");
        L10:
            CustomHeaderConfig.TitleConfig r3 = r4.getTitleConfig();
            if (r3 == null) goto L13;
            r3.setShowFoldBtn(true);
        L13:
            CustomHeaderConfig.TitleConfig r6 = r4.getTitleConfig();
            if (r6 == null) goto L19;
            BitableCatalogModel r7 = r4.getBitableCatalog();
            if (r7 == null) goto L18;
            r0 = r7.getViewName();
        L18:
            r6.setTitle(r0);
        L19:
            super.a(r4, r5);
            return;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.bytedance.ee.bear.document.customheader.CustomHeaderPlugin.a, tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
            d((BitableHeaderConfig) r1, r2);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ CustomHeaderViewModel a;

        public b(CustomHeaderViewModel r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            CustomHeaderViewModel.a r4 = this.a.getDelegate();
            if (r4 == null) goto L6;
            r4.a("catalog", "");
            return;
        }
    }

    @Override // com.bytedance.ee.bear.document.customheader.CustomHeaderPlugin, com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin
    public String getPluginId() {
        String r0 = y5.a;
        return y5.e;
    }

    public final boolean isImmersive() {
        return this.isImmersive;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public boolean isViewImmersive() {
        return this.isImmersive;
    }

    public ExtensionHeaderPlugin(boolean r1) {
        this.isImmersive = r1;
    }

    @Override // com.bytedance.ee.bear.document.customheader.CustomHeaderPlugin, com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super.getBridgeHandlers(r3);
        r3.put("biz.navigation.setCustomHeader", new a(this));
    }

    public final void setImmersive(boolean r1) {
        this.isImmersive = r1;
    }

    @Override // com.bytedance.ee.bear.document.customheader.CustomHeaderPlugin
    public void decorateHeader(CustomHeaderConfig r3, CustomHeaderFragment r4, CustomHeaderViewModel r5) {
        Intrinsics.checkNotNullParameter(r4, "customHeaderFragment");
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        if ((r3 instanceof BitableHeaderConfig) == false) goto L9;
        BitableHeaderConfig r0 = (BitableHeaderConfig) r3;
        if (r0.getBitableCatalog() == null) goto L9;
        BitableCatalogModel r6 = r0.getBitableCatalog();
        if (r6 == null) goto L11;
        r4.W90(true, r6.getViewName(), r6.getIcon(getContext()), new b(r5));
        return;
    L11:
        return;
    L9:
        super.decorateHeader(r3, r4, r5);
    }
}
