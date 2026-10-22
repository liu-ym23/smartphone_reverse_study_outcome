package com.bytedance.ee.bear.document.downgrade;

import a05.f;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.drive.sdk.service.g;
import com.bytedance.ee.bear.middleground.drive.export.DowngradeStrategy;
import com.bytedance.ee.util.ui.m;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0007\u001a\u00020\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\nH\u0016J\u001c\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/document/downgrade/DowngradePlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "Lcom/bytedance/ee/bear/middleground/drive/export/DowngradeListener;", "<init>", "()V", "rustInterface", "Lcom/bytedance/ee/bear/drive/sdk/service/IDriveUploadDownloadService;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToUIContainer", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "onStrategyChange", "strategy", "Lcom/bytedance/ee/bear/middleground/drive/export/DowngradeStrategy;", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DowngradePlugin extends DocumentPlugin implements rf5.a {
    public static final String BIZ_UTIL_DOWNGRADE = "javascript:lark.biz.perf.onDowngradeStatusChange";
    public static final a Companion = null;
    public static final String TAG = "DowngradePlugin";
    private final g rustInterface;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ DowngradeStrategy a;
        public final /* synthetic */ DowngradePlugin b;

        public b(DowngradeStrategy r1, DowngradePlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L24;
            throw th;
        L24:
            return;
        L3:
            if (this.a != null) goto L5;
            return;
        L5:
            if (DowngradePlugin.access$isUIContainerDetached(this.b) == true) goto L25;
            f r0 = (f) ((DocumentPluginHost) this.b.getHost()).getHostAbilityOrNull(f.class);     // Catch: Throwable -> L11
            if (r0 == null) goto L23;
            r0.onDowngade();     // Catch: Throwable -> L11
        L26:
            return;
        L23:
            return;
        L11:
            th = move-exception;
            tt5.a.f(DowngradePlugin.TAG, th, false);     // Catch: Throwable -> L14
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DowngradePlugin() {
        this.rustInterface = ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.c(com.bytedance.ee.bear.drive.sdk.service.f.class, null, null, 6)).d0();
    }

    public static final /* synthetic */ boolean access$isUIContainerDetached(DowngradePlugin r0) {
        return r0.isUIContainerDetached();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r2) {
        Intrinsics.checkNotNullParameter(r2, "handlersHolder");
        super.getBridgeHandlers(r2);
    }

    public void onStrategyChange(DowngradeStrategy r3) {
        tt5.a.h(TAG, "onStrategyChange=" + r3);
        if (isUIContainerDetached() == false) goto L5;
        return;
    L5:
        getWeb().u(BIZ_UTIL_DOWNGRADE, r3);
        m.a(new b(r3, this));
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
        this.rustInterface.q(this);
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        this.rustInterface.c(this);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }
}
