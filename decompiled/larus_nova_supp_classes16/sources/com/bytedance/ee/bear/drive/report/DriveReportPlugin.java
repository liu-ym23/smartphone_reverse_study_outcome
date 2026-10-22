package com.bytedance.ee.bear.drive.report;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.toast.ToastModel;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.a0;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.larus.apm.impl.protector.RunnableProtector;
import i75.h;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t85.e;
import t85.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\u001c\u0010\u000e\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/drive/report/DriveReportPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "handler", "Landroid/os/Handler;", "alreadyReport", "", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onAttachPreview", "onDetachPreview", "onDetachFromUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromHost", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveReportPlugin extends AbsDrivePlugin {
    private boolean alreadyReport;
    private final Handler handler;

    public static final class a implements Runnable {
        public final /* synthetic */ DriveReportPlugin a;

        public a(DriveReportPlugin r1) {
            this.a = r1;
        }

        public final void a() {
            if (DriveReportPlugin.access$isUIContainerDetached(this.a) == false) goto L5;
            return;
        L5:
            Integer r0 = (Integer) this.a.getHost().c.livePreviewType().getValue();
            if (r0 != null) goto L9;
            return;
        L9:
            if (r0.intValue() != 3) goto L16;
            c r1 = k75.a.c(this.a.getHost());
            BaseOpenEntity r2 = this.a.getHost().c.getOpenEntity();
            if (r2 != null) goto L13;
            r1.getClass();
        L14:
            DriveReportPlugin.access$setAlreadyReport$p(this.a, true);
            return;
        L13:
            HashMap<String, Object> r3 = r1.g(r2);
            r3.put("is_degraded", c.k(r1.g.a(r2.getFileId())));
            r3.put("diaplay", "card");
            r1.c(r2.getFileId(), r3);
            r1.A("ccm_drive_page_view", r3);
            goto L14
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

    public static final class b extends u75.b.C0306b {
        public final /* synthetic */ DrivePluginHost a;

        public b(DrivePluginHost r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // u75.b.C0306b, u75.b.a
        public final <T> void a(InfoCode r3, T r4) {
            Intrinsics.checkNotNullParameter(r3, "code");
            if (r3 != InfoCode.FileInfoSuccess) goto L8;
            if ((r4 instanceof w75.a) == false) goto L8;
            k75.a.b(this.a).g((w75.a) r4, 3);
            return;
        L8:
            if (r3 == InfoCode.HitCache) goto L10;
            return;
        L10:
            if ((r4 instanceof w75.a) == false) goto L15;
            k75.a.b(this.a).g((w75.a) r4, 3);
            return;
        }
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveReportPlugin() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        HashMap<String, Object> r0 = k75.a.c(getHost()).g(getHost().c.getOpenEntity());
        TitleBar r1 = getTitleBar();
        if (r1 == null) goto L8;
        BaseTitleBar r2 = r1.getTitleBarLayout();
        if (r2 == null) goto L8;
        r2.setTag(2131388811, r0);
    L8:
        if (this.alreadyReport == true) goto L11;
        this.handler.postDelayed(new a(this), ToastModel.DEFAULT_DURATION);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        super.onDetachPreview();
        c r0 = k75.a.c(getHost());
        w75.a r1 = getHost().c.getFileModel();
        r0.getClass();
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.c() == null) goto L13;
        Disposable r2 = r0.c;
        if (r2 == null) goto L10;
        r2.dispose();
        r0.c = null;
    L10:
        r0.a = System.currentTimeMillis();
        String r3 = r1.c().a;
        String r4 = r1.c().k;
        HashMap<String, Object> r5 = new HashMap();
        r5.put("session_duration", Long.valueOf((r0.a - 0) / 1000));
        r5.put("in_page", String.valueOf(true));
        r5.put("session_id", null);
        r0.z(r5, r3, r4);
        r0.d.v("launch_duration", r5);
        return;
    }

    public static final /* synthetic */ boolean access$isUIContainerDetached(DriveReportPlugin r0) {
        return r0.isUIContainerDetached();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r10) {
        Intrinsics.checkNotNullParameter(r10, "host");
        super.onAttachToHost(r10);
        com.bytedance.ee.bear.drive.report.a r0 = k75.a.b(r10);
        String r1 = k75.a.j(r10.c.getOpenEntity());
        String r2 = h.a(r10.c.getOpenEntity().getPreviewFrom());
        String r3 = r10.c.getOpenEntity().getAppId();
        Bundle r4 = r10.c.getOpenEntity().getExtras();
        int r5 = r10.c.getOpenEntity().getBizType();
        r0.getClass();
        String r6 = e.e(r1, 3);
        e r7 = r0.c.a(r6);
        if (r7 != null) goto L5;
        r7 = new e();
        r0.c.b(r6, r7);
        r0.c.b(r1, r7);
    L5:
        r7.a = r2;
        r7.b = r3;
        r7.c = r4;
        r7.d = r5;
        r10.c().c(new b(r10));
        PreviewViewModel r8 = k75.a.i(r10);
        final DriveViewModel r9 = r10.c;
        final c r11 = o75.b.a().Ke();
        final com.bytedance.ee.bear.drive.report.a r12 = o75.b.a().Tb();
        if (r8 == null) goto L12;
        if (r11 == null) goto L12;
        if (r12 == null) goto L12;
        if (r9 == null) goto L12;
        g<a0> r13 = r8.liveInnerReportMsg();
        r13.a = new t85.a(r9, r11, r12);
    L12:
        com.bytedance.ee.bear.drive.report.a r14 = o75.b.a().Tb();
        r14.f = ForsetiHelper.s(r10.getHostFragment());
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r6) {
        Intrinsics.checkNotNullParameter(r6, "host");
        super.onDetachFromHost(r6);
        if (r6.c.getFileModel() == null) goto L10;
        com.bytedance.ee.bear.drive.report.a r0 = k75.a.b(r6);
        String r2 = k75.a.j(r6.c.getOpenEntity());
        r0.getClass();
        if (TextUtils.isEmpty(r2) == false) goto L7;
    L9:
        r0.e.remove(r2);
        goto L10
    L7:
        if (r0.e.containsKey(r2) == true) goto L9;
        r0.k("nativeFail", "DEC1", r2, 3);
    L10:
        com.bytedance.ee.bear.drive.report.a r1 = k75.a.b(r6);
        String r7 = k75.a.j(r6.c.getOpenEntity());
        t85.c r3 = r1.c;
        String r4 = e.e(r7, 3);
        if (r4 != null) goto L13;
        r3.getClass();
    L14:
        t85.c r5 = r1.c;
        if (r7 != null) goto L17;
        r5.getClass();
        return;
    L17:
        ((ConcurrentHashMap) r5.a).remove(r7);
        return;
    L13:
        ((ConcurrentHashMap) r3.a).remove(r4);
        goto L14
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$setAlreadyReport$p(DriveReportPlugin r0, boolean r1) {
        r0.alreadyReport = r1;
    }

    public void onDetachFromUIContainer(DrivePluginHost r3, t r4) {
        this.handler.removeCallbacksAndMessages(null);
        super.onDetachFromUIContainer(r3, r4);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DrivePluginHost) r1, r2);
    }
}
