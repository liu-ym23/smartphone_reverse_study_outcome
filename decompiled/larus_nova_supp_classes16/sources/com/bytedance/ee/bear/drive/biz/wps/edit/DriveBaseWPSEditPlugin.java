package com.bytedance.ee.bear.drive.biz.wps.edit;

import android.content.Intent;
import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.preview.DrivePreviewContentPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.WpsPreviewView;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0015B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u0007H&J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/wps/edit/DriveBaseWPSEditPlugin;", "Lcom/bytedance/ee/bear/browser/plugin/BasePlugin;", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "Lcom/bytedance/ee/bear/facade/common/ActivityResultHandler;", "<init>", "()V", "mConfigEditable", "", "mKeyboardHeightObserver", "Lcom/ss/android/lark/edit/keyboard/KeyboardHeightObserver;", "isEditable", "onAttachToHost", "", "pluginHost", "onDetachFromHost", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DriveBaseWPSEditPlugin extends BasePlugin<DrivePluginHost> implements sa5.a {
    public static final a Companion = null;
    public static final String TAG = "DrivePlatform_WPSEditPlugin";
    private boolean mConfigEditable;
    private final ocb.a mKeyboardHeightObserver;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements ocb.a {
        public final /* synthetic */ DriveBaseWPSEditPlugin a;

        public b(DriveBaseWPSEditPlugin r1) {
            this.a = r1;
        }

        public final void onKeyboardHeightChanged(pcb.a r1, int r2, int r3) {
            k75.a.i(this.a.getHost()).liveInnerWPSViewPaddingChanged().postValue(Integer.valueOf(r2));
        }
    }

    static {
        Companion = new a();
    }

    public abstract boolean isEditable();

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveBaseWPSEditPlugin() {
        this.mKeyboardHeightObserver = new b(this);
    }

    public void onAttachToHost(DrivePluginHost r3) {
        super.onAttachToHost(r3);
        this.mConfigEditable = isEditable();
        tt5.a.h(TAG, "isEditable=" + this.mConfigEditable);
        k75.a.i(getHost()).liveInnerWPSEditModeAvailable().postValue(Boolean.valueOf(this.mConfigEditable));
        if (this.mConfigEditable == false) goto L6;
        tt5.a.h(TAG, "enable wps keyboard");
        pcb.a.a.b(getActivity()).c(this.mKeyboardHeightObserver);
        return;
    }

    public void onDetachFromHost(DrivePluginHost r2) {
        super.onDetachFromHost(r2);
        if (this.mConfigEditable == false) goto L6;
        tt5.a.h(TAG, "close wps keyboard");
        pcb.a.a.b(getActivity()).a(this.mKeyboardHeightObserver);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    @Override // sa5.a
    public void onActivityResult(int r3, int r4, Intent r5) {
        DrivePreviewContentPlugin r0 = (DrivePreviewContentPlugin) findPlugin(DrivePreviewContentPlugin.class);
        if (r0 == null) goto L5;
        AbsPreviewView r1 = r0.currentPreviewView();
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        if ((r1 instanceof sa5.a) == true) goto L10;
        return;
    L10:
        if ((r1 instanceof WpsPreviewView) == false) goto L15;
        ((WpsPreviewView) r1).onActivityResult(r3, r4, r5);
        return;
    L15:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
