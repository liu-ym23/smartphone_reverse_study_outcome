package com.bytedance.ee.bear.drive.biz.preview.screen;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/screen/DriveScreenStatePlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveScreenStatePlugin extends AbsDrivePlugin {

    public static final class a<T> implements Observer {
        public final /* synthetic */ DriveScreenStatePlugin a;

        public a(DriveScreenStatePlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            tt5.a.h("DriveComponent", "liveInnerKeepScreenOn() on=" + r4);
            if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L5;
            DriveScreenStatePlugin.access$getActivity(this.a).getWindow().addFlags(Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE);
            return;
        L5:
            DriveScreenStatePlugin.access$getActivity(this.a).getWindow().clearFlags(Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE);
        }
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveScreenStatePlugin() {
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveScreenStatePlugin r0) {
        return r0.getActivity();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super.onAttachToHost(r3);
        k75.a.i(r3).liveInnerKeepScreenOn().observe(getLifecycleOwner(), new a(this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }
}
