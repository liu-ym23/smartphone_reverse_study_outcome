package com.bytedance.ee.bear.drive.biz.preview.error.copy;

import android.content.Context;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockViewSwitchManager;
import com.bytedance.ee.bear.drive.view.preview.retryview.FailedToRetryView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.larus.apm.impl.protector.RunnableProtector;
import ka5.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import z95.d;
import z95.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/error/copy/DriveCopyFailedPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveCopyFailedPlugin extends AbsDrivePreviewPlugin {

    public static final class a implements Runnable {
        public final /* synthetic */ DriveCopyFailedPlugin a;
        public final /* synthetic */ DrivePluginHost b;

        public a(DriveCopyFailedPlugin r1, DrivePluginHost r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Type inference failed for: r4v1, types: [android.widget.LinearLayout, com.bytedance.ee.bear.drive.view.preview.retryview.FailedToRetryView] */
        public final void a() {
            Context r0 = DriveCopyFailedPlugin.access$getContext(this.a);
            ViewOwner r1 = this.b.e();
            PreviewViewModel r2 = k75.a.i(this.b);
            String r3 = DriveCopyFailedPlugin.access$getString(this.a, 2131887249);
            ?? r4 = new FailedToRetryView(r0);
            r4.g = r2;
            DriveBlockViewSwitchManager r5 = new DriveBlockViewSwitchManager(r1);
            if (r5.b.getLiveBlockState().getValue() == null) goto L5;
            boolean r6 = true;
        L6:
            r4.d = r6;
            r4.g.liveOuterNetState().observe(r1.lifecycleOwner(), new d(r4));
            r5.a(new h(r4));
            r4.setDescriptionText(r3);
            r4.setRetryClickListener(new b(r2));
            r4.g();
            r4.setVisibility(0);
            return;
        L5:
            r6 = false;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveCopyFailedPlugin() {
    }

    public static final /* synthetic */ Context access$getContext(DriveCopyFailedPlugin r0) {
        return r0.getContext();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        addErrorHandler(new a(this, r4), new ErrCode[]{ErrCode.COPY_FAILED});
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ String access$getString(DriveCopyFailedPlugin r0, int r1) {
        return r0.getString(r1);
    }
}
