package com.bytedance.ee.bear.drive.biz.preview.loading;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.external.f;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PlaceHolderView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.x;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/loading/DriveGeneratingPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "mIsGenerating", "", "mGeneratingStartTime", "", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onDetachFromHost", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveGeneratingPlugin extends AbsDrivePreviewPlugin {
    private long mGeneratingStartTime;
    private boolean mIsGenerating;

    public static final class a implements Runnable {
        public final /* synthetic */ DriveGeneratingPlugin a;
        public final /* synthetic */ DrivePluginHost b;

        public a(DriveGeneratingPlugin r1, DrivePluginHost r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            DriveGeneratingPlugin.access$setMIsGenerating$p(this.a, true);
            DriveGeneratingPlugin.access$setMGeneratingStartTime$p(this.a, SystemClock.uptimeMillis());
            w75.a r0 = this.b.c.getFileModel();
            if (r0 == null) goto L5;
            z r7 = r0.i();
        L6:
            if (r7 == null) goto L17;
            DriveGeneratingPlugin r1 = this.a;
            DrivePluginHost r2 = this.b;
            FragmentActivity r3 = DriveGeneratingPlugin.access$getActivity(r1);
            o75.b.a().getMimeTypeManager();
            ViewOwner r4 = r2.d();
            ViewOwner r6 = new ViewOwner(r2, DriveGeneratingPlugin.access$getLifecycleOwner(r1));
            f r5 = f.e(r2.c.getBizType(), DriveGeneratingPlugin.access$getActivity(r1), r2.b());
            g85.f r8 = o75.b.a().getMimeTypeManager();
            PlaceHolderView r9 = new PlaceHolderView(r3);
            r9.b(r4, r6);
            r9.setLottiePlaceHolder(2131820626);
            if (((g85.b) r8).o(r7.b, null) == false) goto L14;
            Context r10 = r9.getContext();
            r9.setDescText(r10.getString(2131889547));
            r9.setPrimaryText(r10.getString(2131888429));
            if (((g85.b) r8).l(r7.b) == true) goto L12;
        L15:
            DriveGeneratingPlugin.access$removeAndAddPreviewView(r1, new x(r3, r9, r5, r6, r7).b);
            return;
        L12:
            if (a95.b.a("ccm.drive.mobile.enable_user_download_video_during_transcoding") == false) goto L15;
            r9.setSecondaryClickText(r10.getString(2131889067));
            goto L15
        L14:
            Context r11 = r9.getContext();
            r9.setDescText(r11.getString(2131888482));
            r9.setPrimaryText(r11.getString(2131888429));
            goto L15
        L17:
            return;
        L5:
            r7 = null;
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

    public static final class b implements Runnable {
        public final /* synthetic */ DriveGeneratingPlugin a;

        public b(DriveGeneratingPlugin r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DriveGeneratingPlugin.access$setMIsGenerating$p(this.a, false);     // Catch: Throwable -> L4
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

    public DriveGeneratingPlugin() {
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveGeneratingPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ LifecycleOwner access$getLifecycleOwner(DriveGeneratingPlugin r0) {
        return r0.getLifecycleOwner();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r5) {
        Intrinsics.checkNotNullParameter(r5, "host");
        super.onAttachToHost(r5);
        addInfoHandler(new a(this, r5), new InfoCode[]{InfoCode.Generating});
        addInfoHandler(new b(this), new InfoCode[]{InfoCode.GenerateFailed, InfoCode.GenerateFinished});
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r13) {
        Intrinsics.checkNotNullParameter(r13, "host");
        super.onDetachFromHost(r13);
        if (this.mIsGenerating == false) goto L12;
        long r6 = SystemClock.uptimeMillis() - this.mGeneratingStartTime;
        com.bytedance.ee.bear.drive.report.a r4 = o75.b.a().Tb();
        w75.a r14 = r13.c.getFileModel();
        r4.getClass();
        if (r14 != null) goto L7;
    L10:
        this.mIsGenerating = false;
        return;
    L7:
        if (r14.c() == null) goto L10;
        r4.h(2, r6, r14.c().a, r14.c().k, r14.c().c);
        goto L10
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$removeAndAddPreviewView(DriveGeneratingPlugin r0, View r1) {
        r0.removeAndAddPreviewView(r1);
    }

    public static final /* synthetic */ void access$setMGeneratingStartTime$p(DriveGeneratingPlugin r0, long r1) {
        r0.mGeneratingStartTime = r1;
    }

    public static final /* synthetic */ void access$setMIsGenerating$p(DriveGeneratingPlugin r0, boolean r1) {
        r0.mIsGenerating = r1;
    }
}
