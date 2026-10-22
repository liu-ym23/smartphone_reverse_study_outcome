package com.bytedance.ee.bear.drive.biz.preview.imattachment;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.drive.biz.permission.DrivePermissionViewModel;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.OpenExternalMenu;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0002¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/imattachment/DriveImAttachmentDefaultPreviewModelStatePlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "initExportVisible", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveImAttachmentDefaultPreviewModelStatePlugin extends AbsDrivePlugin {
    public static final a Companion = null;
    public static final String TAG = "DriveImAttachmentDefaultPreviewModelStatePlugin";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void initExportVisible() {
        Iterator<BaseMoreMenuAction> r0 = getHost().c.getOpenEntity().getMoreMenuActions().iterator();
        boolean r1 = false;
    L4:
        if (r0.hasNext() == false) goto L8;
        if ((r0.next() instanceof OpenExternalMenu) == false) goto L4;
        r1 = true;
        goto L4
    L8:
        tt5.a.h(TAG, "canExport=" + r1);
        k75.a.i(getHost()).liveOuterExportVisible().postValue(Boolean.valueOf(r1));
    }

    public DriveImAttachmentDefaultPreviewModelStatePlugin() {
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super.onAttachToHost(r3);
        PreviewViewModel r4 = k75.a.i(r3);
        DrivePermissionViewModel r0 = (DrivePermissionViewModel) viewModel(DrivePermissionViewModel.class);
        initExportVisible();
        r4.liveOuterCommentable().postValue(Boolean.FALSE);
        MutableLiveData<Boolean> r5 = r0.getLiveOuterRawCopyable();
        Boolean r1 = Boolean.TRUE;
        r5.postValue(r1);
        r0.getLiveOuterEditable().postValue(r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }
}
