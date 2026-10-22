package com.bytedance.ee.bear.drive.biz.preview.loading;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.view.preview.loadingview.AbsLoadingView;
import com.bytedance.ee.bear.drive.view.preview.loadingview.NotSupportLoadingView;
import com.bytedance.ee.bear.drive.view.preview.loadingview.d;
import com.bytedance.ee.bear.drive.view.preview.loadingview.f;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.drive.render.k;
import g85.e;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import u75.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/loading/DriveDownloadingPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "mDownloadProgressView", "Lcom/bytedance/ee/bear/drive/view/preview/loadingview/ILoadingView;", "mLoadingViewManager", "Lcom/bytedance/ee/bear/drive/view/preview/loadingview/LoadingViewManager;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveDownloadingPlugin extends AbsDrivePreviewPlugin {
    private d mDownloadProgressView;
    private f mLoadingViewManager;

    public static final class a extends b.C0306b {
        public final /* synthetic */ DrivePluginHost a;
        public final /* synthetic */ DriveDownloadingPlugin b;

        @Override // u75.b.C0306b, u75.b.a
        public final void b(z r2) {
            Intrinsics.checkNotNullParameter(r2, "previewFileModel");
            d r3 = DriveDownloadingPlugin.access$getMDownloadProgressView$p(this.b);
            if (r3 == null) goto L8;
            View r4 = r3.getView();
            if (r4 == null) goto L9;
            r4.setVisibility(8);
            return;
        L9:
            return;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void c(ErrCode r2) {
            Intrinsics.checkNotNullParameter(r2, "code");
            d r3 = DriveDownloadingPlugin.access$getMDownloadProgressView$p(this.b);
            if (r3 == null) goto L8;
            View r4 = r3.getView();
            if (r4 == null) goto L9;
            r4.setVisibility(8);
            return;
        L9:
            return;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void onProgress(int r17) {
            w75.a r0 = this.a.c.getFileModel();
            if (r0 != null) goto L5;
        L7:
            boolean r4 = false;
        L8:
            if (r4 == true) goto L62;
            if (r0 != null) goto L11;
        L13:
            boolean r1 = false;
        L14:
            if (r1 == true) goto L64;
            w75.a r2 = this.a.c.getFileModel();
            d r5 = null;
            if (r2 == null) goto L19;
            z r6 = r2.i();
        L21:
            if (DriveDownloadingPlugin.access$getMDownloadProgressView$p(this.b) == null) goto L29;
            d r3 = DriveDownloadingPlugin.access$getMDownloadProgressView$p(this.b);
            if (r3 == null) goto L27;
            View r7 = r3.getView();
            if (r7 == null) goto L27;
            ViewParent r8 = r7.getParent();
        L28:
            if (r8 == null) goto L29;
        L56:
            d r9 = DriveDownloadingPlugin.access$getMDownloadProgressView$p(this.b);
            if (r9 == null) goto L63;
            r9.setProgress(r17);
            return;
        L63:
            return;
        L27:
            r8 = null;
        L29:
            k r10 = DriveDownloadingPlugin.access$getDriveUIConfig(this.b);
            if (r10 == null) goto L32;
            k.b r11 = r10.a();
        L33:
            if (r6 == null) goto L55;
            DriveDownloadingPlugin r12 = this.b;
            DrivePluginHost r13 = this.a;
            f r14 = DriveDownloadingPlugin.access$getMLoadingViewManager$p(r12);
            if (r14 == null) goto L48;
            FragmentActivity r16 = DriveDownloadingPlugin.access$getActivity(r12);
            ViewOwner r18 = r13.d();
            e r19 = ((g85.b) r14.a).b(r6.b, "");
            if (r14.b == false) goto L40;
            AbsLoadingView r20 = new com.bytedance.ee.bear.drive.view.preview.loadingview.b(r16, r18, r6, r19);
        L39:
            r5 = r20;
            goto L48
        L40:
            Class<? extends AbsLoadingView> r21 = ((com.bytedance.ee.drive.preview.f) org.koin.java.a.a(com.bytedance.ee.drive.preview.f.class)).f4(r19.d, r6);
            if (r21 != null) goto L60;
            tt5.a.d("LoadingViewManager", "MimeTypeProvider get class is null");
            r20 = new NotSupportLoadingView(r16, r18, r6, r19);
            goto L39
        L60:
            Constructor<? extends AbsLoadingView> r22 = r21.getDeclaredConstructor(new Class[]{Context.class, ViewOwner.class, z.class, e.class});     // Catch: Exception -> L45
            r22.setAccessible(true);     // Catch: Exception -> L45
            r20 = r22.newInstance(new Object[]{r16, r18, r6, r19});     // Catch: Exception -> L45
        L45:
            e = move-exception;
            tt5.a.f("LoadingViewManager", e, false);
            r20 = new NotSupportLoadingView(r16, r18, r6, r19);
        L48:
            DriveDownloadingPlugin.access$setMDownloadProgressView$p(r12, r5);
            d r23 = DriveDownloadingPlugin.access$getMDownloadProgressView$p(r12);
            if (r23 == null) goto L51;
            r23.show();
        L51:
            d r24 = DriveDownloadingPlugin.access$getMDownloadProgressView$p(r12);
            if (r24 == null) goto L54;
            r24.setUIConfig(r11);
        L54:
            d r26 = DriveDownloadingPlugin.access$getMDownloadProgressView$p(r12);
            Intrinsics.checkNotNull(r26);
            DriveDownloadingPlugin.access$removeAndAddPreviewView(r12, r26.getView());
            goto L56
        L55:
            tt5.a.d("DriveComponent", "DriveDownloadingPlugin() # onProgress error filePreviewModel null");
            goto L56
        L32:
            r11 = null;
            goto L33
        L19:
            r6 = null;
            goto L21
        L64:
            return;
        L11:
            if (r0.x != true) goto L13;
            r1 = true;
            goto L14
        L62:
            return;
        L5:
            if (r0.e() != true) goto L7;
            r4 = true;
            goto L8
        }

        public a(DrivePluginHost r1, DriveDownloadingPlugin r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveDownloadingPlugin() {
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveDownloadingPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ k access$getDriveUIConfig(DriveDownloadingPlugin r0) {
        return r0.getDriveUIConfig();
    }

    public static final /* synthetic */ d access$getMDownloadProgressView$p(DriveDownloadingPlugin r0) {
        return r0.mDownloadProgressView;
    }

    public static final /* synthetic */ f access$getMLoadingViewManager$p(DriveDownloadingPlugin r0) {
        return r0.mLoadingViewManager;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        this.mLoadingViewManager = new f(o75.b.a().getMimeTypeManager(), r4.c.isInBlockState());
        r4.c().c(new a(r4, this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$removeAndAddPreviewView(DriveDownloadingPlugin r0, View r1) {
        r0.removeAndAddPreviewView(r1);
    }

    public static final /* synthetic */ void access$setMDownloadProgressView$p(DriveDownloadingPlugin r0, d r1) {
        r0.mDownloadProgressView = r1;
    }
}
