package com.bytedance.ee.bear.drive.biz.preview.presentation;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/presentation/DrivePresentationPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onDetachFromHost", "initPagePortrait", "startPortrait", "needPortrait", "", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DrivePresentationPlugin extends AbsDrivePlugin {
    public static final a Companion = null;
    private static final String TAG = "DrivePresentationPlugin";

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DrivePresentationPlugin a;

        public b(DrivePresentationPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            DrivePresentationPlugin.access$initPagePortrait(this.a);
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ DrivePresentationPlugin a;

        public c(DrivePresentationPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            DrivePresentationPlugin.access$initPagePortrait(this.a);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void initPagePortrait() {
        if (getActivity() != null) goto L6;
        tt5.a.h(TAG, "initPagePortrait activity is null");
        return;
    L6:
        Boolean r0 = (Boolean) k75.a.i(getHost()).liveInnerIsPresentationMode().getValue();
        if (getHost().c.isVCFollowMode() == false) goto L9;
        return;
    L9:
        Boolean r1 = (Boolean) k75.a.i(getHost()).liveInnerIsWPSPresentationMode().getValue();
        Boolean r2 = Boolean.TRUE;
        if (r2.equals(r0) == false) goto L12;
    L15:
        boolean r3 = true;
    L16:
        startPortrait(r3);
        return;
    L12:
        if (r2.equals(r1) == true) goto L15;
        r3 = false;
        goto L16
    }

    public DrivePresentationPlugin() {
    }

    public static final /* synthetic */ void access$initPagePortrait(DrivePresentationPlugin r0) {
        r0.initPagePortrait();
    }

    private final void startPortrait(boolean r2) {
        if (r2 == false) goto L7;
        int r0 = com.bytedance.ee.bear.drive.biz.preview.orientation.a.a;
        if (com.bytedance.ee.bear.drive.biz.preview.orientation.a.C0152a.b(getActivity()) == false) goto L7;
        getActivity().setRequestedOrientation(0);
        return;
    L7:
        if (r2 == true) goto L12;
        int r3 = com.bytedance.ee.bear.drive.biz.preview.orientation.a.a;
        if (com.bytedance.ee.bear.drive.biz.preview.orientation.a.C0152a.a(getActivity()) == false) goto L13;
        getActivity().setRequestedOrientation(1);
        return;
    L13:
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        k75.a.i(r4).liveInnerIsPresentationMode().observe(getLifecycleOwner(), new b(this));
        k75.a.i(r4).liveInnerIsWPSPresentationMode().observe(getLifecycleOwner(), new c(this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onDetachFromHost(r2);
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
