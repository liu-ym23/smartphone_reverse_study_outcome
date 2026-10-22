package com.bytedance.ee.bear.drive.biz.preview.media;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.fragment.DrivePreviewFragment;
import com.bytedance.ee.bear.drive.view.preview.media.DriveMediaVM;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sa5.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0001\u0010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/media/DriveMediaPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "<init>", "()V", "driveMediaVM", "Lcom/bytedance/ee/bear/drive/view/preview/media/DriveMediaVM;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onDetachFromHost", "startMediaObserver", "Landroidx/lifecycle/Observer;", "", "onBackPressed", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveMediaPlugin extends AbsDrivePreviewPlugin implements d {
    public static final a Companion = null;
    public static final String TAG = "DriveMediaPlugin";
    private DriveMediaVM driveMediaVM;
    private final Observer<Boolean> startMediaObserver;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DriveMediaPlugin a;

        public b(DriveMediaPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r9) {
            if (((Boolean) r9).booleanValue() != true) goto L30;
            n85.b r10 = n85.b.a.a;
            r10.getClass();
            HashMap r0 = new HashMap();
            Iterator<String> r11 = r10.a.keySet().iterator();
        L7:
            if (r11.hasNext() == false) goto L13;
            String r1 = r11.next();
            DrivePreviewFragment r2 = n85.b.e(r1);
            if (r2 == null) goto L7;
            if (r2.d == false) goto L7;
            r0.put(r1, r2);
            goto L7
        L13:
            DriveMediaVM r12 = DriveMediaPlugin.access$getDriveMediaVM$p(this.a);
            if (r12 == null) goto L16;
            String r13 = r12.getHexString();
        L17:
            Iterator<T> r3 = r0.values().iterator();
        L19:
            if (r3.hasNext() == false) goto L49;
            DrivePreviewFragment r4 = (DrivePreviewFragment) r3.next();
            if (r4 == null) goto L19;
            if (r4.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L19;
            DriveMediaVM r5 = (DriveMediaVM) q.c(r4.g, DriveMediaVM.class, null);
            String r6 = r5.getHexString();
            if (Intrinsics.areEqual(r13, r6) == true) goto L19;
            Object r7 = r5.getStartMedia().getValue();
            Boolean r8 = Boolean.TRUE;
            if (Intrinsics.areEqual(r7, r8) == false) goto L19;
            tt5.a.h(DriveMediaPlugin.TAG, "startMediaObserver find map size= " + r0.size() + ", hexString= " + r13 + ", cacheHexString= " + r6);
            r5.tryReleaseMediaMutex();
            r5.getPauseMedia().setValue(r8);
            goto L19
        L49:
            return;
        L16:
            r13 = null;
            goto L17
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveMediaPlugin() {
        this.startMediaObserver = new b(this);
    }

    @Override // sa5.d
    public boolean onBackPressed() {
        if (getHost().c.isVCFollowMode() == false) goto L5;
        return false;
    L5:
        Integer r0 = (Integer) getHost().c.livePreviewType().getValue();
        if (r0 != null) goto L9;
    L10:
        com.bytedance.ee.bear.drive.biz.preview.screen.a r1 = (com.bytedance.ee.bear.drive.biz.preview.screen.a) k75.a.e(getHost()).liveOuterFullScreenSate.getValue();
        if (r1 == null) goto L15;
        boolean r2 = true;
        if (r1.a != true) goto L15;
    L16:
        if (r2 == true) goto L18;
        ((DriveMediaVM) viewModel(DriveMediaVM.class)).getPauseMedia().setValue(Boolean.TRUE);
    L18:
        return false;
    L15:
        r2 = false;
        goto L16
    L9:
        if (r0.intValue() == 4) goto L18;
        goto L10
    }

    public static final /* synthetic */ DriveMediaVM access$getDriveMediaVM$p(DriveMediaPlugin r0) {
        return r0.driveMediaVM;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        DriveMediaVM r5 = (DriveMediaVM) viewModel(DriveMediaVM.class);
        if (r5 == null) goto L5;
        r5.getStartMedia().observe(getLifecycleOwner(), this.startMediaObserver);
    L6:
        this.driveMediaVM = r5;
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onDetachFromHost(r2);
        DriveMediaVM r3 = this.driveMediaVM;
        if (r3 == null) goto L6;
        r3.tryReleaseMediaMutex();
        r3.getStartMedia().removeObserver(this.startMediaObserver);
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
}
