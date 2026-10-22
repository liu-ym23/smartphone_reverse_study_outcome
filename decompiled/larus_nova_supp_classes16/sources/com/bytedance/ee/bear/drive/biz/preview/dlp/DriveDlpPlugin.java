package com.bytedance.ee.bear.drive.biz.preview.dlp;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.extra_info.meta.DriveMetaInfoVM;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground_permission_export.model.d;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/dlp/DriveDlpPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "isDlpMigrate", "", "dlpContext", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/CCMOpenFileSceneContext;", "hasFetch", "metaInfoObserver", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/ee/bear/drive/biz/permission/model/DriveMetaInfo;", "getDomain", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;", "handleGetData", "", "metaInfo", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "timer", "Ljava/lang/Runnable;", "getTimer", "()Ljava/lang/Runnable;", "setTimer", "(Ljava/lang/Runnable;)V", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onDetachFromHost", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveDlpPlugin extends AbsDrivePreviewPlugin {
    public static final a Companion = null;
    private static final String TAG = "DriveDlpPlugin";
    private com.ss.android.lark.security.compliance.api.model.filepolicy.c dlpContext;
    private Handler handler;
    private boolean hasFetch;
    private boolean isDlpMigrate;
    private u55.a metaInfo;
    private final Observer<u55.a> metaInfoObserver;
    private Runnable timer;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DriveDlpPlugin a;

        public b(DriveDlpPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r8) {
            u55.a r9 = (u55.a) r8;
            Intrinsics.checkNotNullParameter(r9, "it");
            if (r9.b != null) goto L6;
            tt5.a.h(DriveDlpPlugin.TAG, "empty meta info");
        L6:
            if (DriveDlpPlugin.access$isDlpMigrate$p(this.a) == false) goto L10;
            com.ss.android.lark.security.compliance.api.model.filepolicy.c r0 = DriveDlpPlugin.access$getDlpContext$p(this.a);
            if (r0 == null) goto L12;
            FileBizDomain r1 = DriveDlpPlugin.access$getDomain(this.a);
            Long r2 = Long.valueOf(yu5.c.g(r9.b.getOwnerUid(), 0));
            Long r10 = Long.valueOf(yu5.c.g(r9.b.getCreatorTenantId(), 0));
            Intrinsics.checkNotNullParameter(r1, "fileBizDomain");
            r0.a(r1, r2, r10);
            return;
        L12:
            return;
        L10:
            DriveDlpPlugin.access$setMetaInfo$p(this.a, r9);
            DriveDlpPlugin.access$handleGetData(this.a);
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ DriveDlpPlugin a;

        public final void a() {
            if (DriveDlpPlugin.access$getMetaInfo$p(this.a) == null) goto L13;
            u55.a r1 = null;
            d r0 = (d) org.koin.java.a.c(d.class, null, null, 6);
            u55.a r3 = DriveDlpPlugin.access$getMetaInfo$p(this.a);
            if (r3 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("metaInfo");
            r3 = null;
        L7:
            long r5 = r0.g(r3.a);
            this.a.getHandler().removeCallbacksAndMessages(null);
            d r2 = (d) org.koin.java.a.c(d.class, null, null, 6);
            u55.a r4 = DriveDlpPlugin.access$getMetaInfo$p(this.a);
            if (r4 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("metaInfo");
        L11:
            r2.c(r1.a, e.l.b);
            this.a.getHandler().postDelayed(this, r5);
            return;
        L10:
            r1 = r4;
            goto L11
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

        public c(DriveDlpPlugin r1) {
            this.a = r1;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void handleGetData() {
        if (this.hasFetch == true) goto L6;
        this.hasFetch = true;
        this.handler.post(this.timer);
        return;
    }

    public DriveDlpPlugin() {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        this.isDlpMigrate = jg5.e.a.a.g();
        this.metaInfoObserver = new b(this);
        Looper r1 = Looper.myLooper();
        Intrinsics.checkNotNull(r1);
        this.handler = new Handler(r1);
        this.timer = new c(this);
    }

    private final FileBizDomain getDomain() {
        if (getHost() == null) goto L15;
        if (getHost().c == null) goto L15;
        if (getHost().c.getOpenEntity() == null) goto L15;
        String r0 = getHost().c.getOpenEntity().getMountPoint();
        if (r0 != null) goto L12;
        r0 = "";
    L12:
        BizDomain r1 = pw4.b.a(r0);
        return ((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).a(r1);
    L15:
        return FileBizDomain.FileBizDomainCCM;
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public final Runnable getTimer() {
        return this.timer;
    }

    public static final /* synthetic */ com.ss.android.lark.security.compliance.api.model.filepolicy.c access$getDlpContext$p(DriveDlpPlugin r0) {
        return r0.dlpContext;
    }

    public static final /* synthetic */ FileBizDomain access$getDomain(DriveDlpPlugin r0) {
        return r0.getDomain();
    }

    public static final /* synthetic */ u55.a access$getMetaInfo$p(DriveDlpPlugin r0) {
        return r0.metaInfo;
    }

    public static final /* synthetic */ void access$handleGetData(DriveDlpPlugin r0) {
        r0.handleGetData();
    }

    public static final /* synthetic */ boolean access$isDlpMigrate$p(DriveDlpPlugin r0) {
        return r0.isDlpMigrate;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r6) {
        Intrinsics.checkNotNullParameter(r6, "host");
        super.onAttachToHost(r6);
        this.hasFetch = false;
        if (this.isDlpMigrate == true) goto L5;
    L7:
        ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).getLiveMetaInfo().observe(getLifecycleOwner(), this.metaInfoObserver);
        return;
    L5:
        if (r6.c == null) goto L7;
        String r0 = ((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).c(12);
        com.ss.android.lark.security.compliance.api.model.filepolicy.c r3 = new com.ss.android.lark.security.compliance.api.model.filepolicy.c(r6.c.getFileId(), r0, 12, new AnonymousClass1(this));
        this.dlpContext = r3;
        r3.a(getDomain(), null, null);
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onDetachFromHost(r2);
        this.hasFetch = true;
        if (this.isDlpMigrate == false) goto L7;
        com.ss.android.lark.security.compliance.api.model.filepolicy.c r3 = this.dlpContext;
        if (r3 == null) goto L9;
        r3.c();
        return;
    L9:
        return;
    L7:
        this.handler.removeCallbacksAndMessages(null);
        ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).getLiveMetaInfo().removeObserver(this.metaInfoObserver);
    }

    public final void setHandler(Handler r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.handler = r2;
    }

    public final void setTimer(Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.timer = r2;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$setMetaInfo$p(DriveDlpPlugin r0, u55.a r1) {
        r0.metaInfo = r1;
    }

    public static final /* synthetic */ ViewModel access$viewModel(DriveDlpPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }
}
