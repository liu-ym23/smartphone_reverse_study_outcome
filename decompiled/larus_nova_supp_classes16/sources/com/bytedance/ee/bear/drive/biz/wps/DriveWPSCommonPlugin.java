package com.bytedance.ee.bear.drive.biz.wps;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.drive.biz.preview.DrivePreviewContentPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/wps/DriveWPSCommonPlugin;", "Lcom/bytedance/ee/bear/browser/plugin/BasePlugin;", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "<init>", "()V", "mCurrentRetryCount", "", "onAttachToHost", "", "host", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveWPSCommonPlugin extends BasePlugin<DrivePluginHost> {
    public static final a Companion = null;
    private static final int MAX_RETRY_COUNT = 0;
    private static final String TAG = "DriveWPSCommonPlugin";
    private int mCurrentRetryCount;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DriveWPSCommonPlugin a;

        public b(DriveWPSCommonPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            tt5.a.h(DriveWPSCommonPlugin.TAG, "liveWpsTryReload currentRetryCount=" + DriveWPSCommonPlugin.access$getMCurrentRetryCount$p(this.a));
            if (Intrinsics.areEqual((Boolean) r3, Boolean.TRUE) == false) goto L10;
            int r4 = DriveWPSCommonPlugin.access$getMCurrentRetryCount$p(this.a);
            DriveWPSCommonPlugin.Companion.getClass();
            if (r4 < DriveWPSCommonPlugin.access$getMAX_RETRY_COUNT$cp()) goto L7;
            tt5.a.k(DriveWPSCommonPlugin.TAG, "retryRenderDocument fail, because retry count over limit");
            return;
        L7:
            DriveWPSCommonPlugin.access$setMCurrentRetryCount$p(this.a, DriveWPSCommonPlugin.access$getMCurrentRetryCount$p(this.a) + 1);
            DrivePreviewContentPlugin r5 = (DrivePreviewContentPlugin) DriveWPSCommonPlugin.access$findPlugin(this.a, DrivePreviewContentPlugin.class);
            if (r5 == null) goto L13;
            r5.reloadCurrentPreviewView();
            return;
        L13:
            return;
        L10:
            DriveWPSCommonPlugin.access$setMCurrentRetryCount$p(this.a, 0);
        }
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    static {
        Companion = new a();
        MAX_RETRY_COUNT = o75.b.a().getDriveConfig().a().getWps_render_gone_retry_count();
    }

    public DriveWPSCommonPlugin() {
    }

    public static final /* synthetic */ int access$getMAX_RETRY_COUNT$cp() {
        return MAX_RETRY_COUNT;
    }

    public static final /* synthetic */ int access$getMCurrentRetryCount$p(DriveWPSCommonPlugin r0) {
        return r0.mCurrentRetryCount;
    }

    public void onAttachToHost(DrivePluginHost r3) {
        super.onAttachToHost(r3);
        ((DriveWPSPreviewViewModel) viewModel(DriveWPSPreviewViewModel.class)).getLiveWpsTryReload().observe(getLifecycleOwner(), new b(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ f access$findPlugin(DriveWPSCommonPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static final /* synthetic */ void access$setMCurrentRetryCount$p(DriveWPSCommonPlugin r0, int r1) {
        r0.mCurrentRetryCount = r1;
    }
}
