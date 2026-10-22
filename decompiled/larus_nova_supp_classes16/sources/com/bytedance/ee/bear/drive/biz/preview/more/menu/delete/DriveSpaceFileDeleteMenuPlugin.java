package com.bytedance.ee.bear.drive.biz.preview.more.menu.delete;

import android.text.TextUtils;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.c0;
import com.bytedance.ee.bear.contract.q0;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.util.ui.m;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/more/menu/delete/DriveSpaceFileDeleteMenuPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "mDocDataListener", "Lcom/bytedance/ee/bear/contract/SimpleListDataChangeCallback;", "mDelayRunnable", "Ljava/lang/Runnable;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onDetachFromHost", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSpaceFileDeleteMenuPlugin extends AbsDrivePlugin {
    private Runnable mDelayRunnable;
    private q0 mDocDataListener;

    public static final class a extends q0 {
        public final /* synthetic */ DriveSpaceFileDeleteMenuPlugin a;
        public final /* synthetic */ DrivePluginHost b;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.more.menu.delete.DriveSpaceFileDeleteMenuPlugin$a$a, reason: collision with other inner class name */
        public static final class RunnableC0148a implements Runnable {
            public final /* synthetic */ DrivePluginHost a;

            public RunnableC0148a(DrivePluginHost r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                k75.a.a(this.a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.bytedance.ee.bear.contract.q0, com.bytedance.ee.bear.contract.c0.d
        public final void a(String r3) {
            if (TextUtils.equals(r3, k75.a.d(this.a)) == false) goto L9;
            tt5.a.h("DriveComponent", "DriveSpaceFileDeleteMenuPlugin() deleted file, close page");
            if (DriveSpaceFileDeleteMenuPlugin.access$getMDelayRunnable$p(this.a) != null) goto L7;
            DriveSpaceFileDeleteMenuPlugin.access$setMDelayRunnable$p(this.a, new RunnableC0148a(this.b));
        L7:
            m.b(DriveSpaceFileDeleteMenuPlugin.access$getMDelayRunnable$p(this.a), 100);
            return;
        }

        public a(DriveSpaceFileDeleteMenuPlugin r1, DrivePluginHost r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveSpaceFileDeleteMenuPlugin() {
    }

    public static final /* synthetic */ Runnable access$getMDelayRunnable$p(DriveSpaceFileDeleteMenuPlugin r0) {
        return r0.mDelayRunnable;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        c0 r0 = (c0) org.koin.java.a.c(c0.class, null, null, 6);
        a r1 = new a(this, r4);
        this.mDocDataListener = r1;
        r0.q0(r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onDetachFromHost(r4);
        q0 r5 = this.mDocDataListener;
        if (r5 == null) goto L5;
        ((c0) org.koin.java.a.c(c0.class, null, null, 6)).d0(r5);
    L5:
        Runnable r6 = this.mDelayRunnable;
        if (r6 == null) goto L9;
        m.e(r6);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$setMDelayRunnable$p(DriveSpaceFileDeleteMenuPlugin r0, Runnable r1) {
        r0.mDelayRunnable = r1;
    }
}
