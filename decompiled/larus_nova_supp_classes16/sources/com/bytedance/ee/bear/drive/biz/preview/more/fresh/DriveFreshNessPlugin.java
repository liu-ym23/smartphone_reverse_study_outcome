package com.bytedance.ee.bear.drive.biz.preview.more.fresh;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.extra_info.meta.DriveMetaInfoVM;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import kotlin.Metadata;
import qj5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/more/fresh/DriveFreshNessPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "Lcom/bytedance/ee/bear/more/item/IDocFreshNessChangeListener;", "<init>", "()V", "onAttachPreview", "", "onDetachPreview", "onDocFreshNessChange", "getRetryToken", "", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveFreshNessPlugin extends AbsDrivePlugin implements b {
    public static final a Companion = null;
    public static final String TAG = "DriveFreshNessPlugin";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public String getRetryToken() {
        return "";
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public void onDocFreshNessChange() {
        ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).fetchMetaInfo(k75.a.d(this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).n(k75.a.d(this), this);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        super.onDetachPreview();
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).p(k75.a.d(this), this);
    }

    public DriveFreshNessPlugin() {
    }
}
