package com.bytedance.ee.bear.drive.biz.preview.error._default;

import android.content.res.Resources;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.biz.preview.titlebar.DriveTitleBarVisibilityPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.download.platform.api.ServerErrParser;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.view.preview.retryview.FailedToRetryView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0014¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/error/_default/DriveDlpFailedToRetryPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "showFailedToRetryView", "Lcom/bytedance/ee/bear/drive/view/preview/retryview/FailedToRetryView;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DriveDlpFailedToRetryPlugin extends AbsDrivePreviewPlugin {

    public static final class a extends u75.b.C0306b {
        public final /* synthetic */ DriveDlpFailedToRetryPlugin a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.error._default.DriveDlpFailedToRetryPlugin$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0135a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ErrCode.values().length];
                r0[ErrCode.REQUEST_FILE_INFO_EXP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                a = r0;
            }
        }

        public a(DriveDlpFailedToRetryPlugin r1) {
            this.a = r1;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void c(ErrCode r4) {
            Intrinsics.checkNotNullParameter(r4, "code");
            if (C0135a.a[r4.ordinal()] == 1) goto L5;
            return;
        L5:
            if (ServerErrParser.isPreviewDLPFail(r4.getCause()) == false) goto L11;
            tt5.a.h("DriveComponent", "DriveDlpFailedToRetryPlugin isPreviewDLPFail not show retry and openExternal ");
            FailedToRetryView r5 = this.a.showFailedToRetryView();
            r5.showPrimaryAction(false);
            r5.showSecondaryAction(false);
            r5.setPlaceHolderText(DriveDlpFailedToRetryPlugin.access$getResources(this.a).getString(2131889535));
            DriveTitleBarVisibilityPlugin r6 = (DriveTitleBarVisibilityPlugin) DriveDlpFailedToRetryPlugin.access$findPlugin(this.a, DriveTitleBarVisibilityPlugin.class);
            if (r6 == null) goto L12;
            r6.updateDLpStatus(true);
            return;
        L12:
            return;
        }
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, android.widget.LinearLayout, com.bytedance.ee.bear.drive.view.preview.retryview.FailedToRetryView] */
    public FailedToRetryView showFailedToRetryView() {
        ?? r0 = new ka5.c(getActivity()).a(((DrivePluginHost) getHost()).e(), k75.a.i((DrivePluginHost) getHost()));
        removeAndAddPreviewView(r0);
        r0.setVisibility(0);
        return r0;
    }

    public DriveDlpFailedToRetryPlugin() {
    }

    public static final /* synthetic */ Resources access$getResources(DriveDlpFailedToRetryPlugin r0) {
        return r0.getResources();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onAttachToHost(r2);
        r2.c().c(new a(this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ f access$findPlugin(DriveDlpFailedToRetryPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }
}
