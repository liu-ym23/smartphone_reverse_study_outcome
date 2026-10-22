package com.bytedance.ee.bear.drive.biz.preview.show;

import android.text.TextUtils;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.services.v;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.util.ui.m;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/show/DrivePreviewShowResultPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "mAddPreviewCacheEnable", "", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DrivePreviewShowResultPlugin extends AbsDrivePlugin {
    public static final a Companion = null;
    private static final String TAG = "DrivePreviewShowResultPlugin";
    private boolean mAddPreviewCacheEnable;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DrivePluginHost a;
        public final /* synthetic */ DrivePreviewShowResultPlugin b;

        public b(DrivePluginHost r1, DrivePreviewShowResultPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            Integer r4 = (Integer) r3;
            if (r4 != null) goto L6;
            return;
        L6:
            if (r4.intValue() != 3) goto L17;
            w75.a r5 = this.a.c.getFileModel();
            if (r5 == null) goto L10;
            String r6 = r5.w;
        L11:
            tt5.a.k(DrivePreviewShowResultPlugin.TAG, "liveInnerPreviewShowStatus, status=PREVIEW_SHOW_STATUS_FAILED, mAddPreviewCacheEnable=" + DrivePreviewShowResultPlugin.access$getMAddPreviewCacheEnable$p(this.b) + ", cacheSourceFrom=" + r6);
            if (DrivePreviewShowResultPlugin.access$getMAddPreviewCacheEnable$p(this.b) == false) goto L18;
            int r0 = v.a;
            if (TextUtils.equals("3", r6) == false) goto L19;
            m.a(new com.bytedance.ee.bear.drive.biz.preview.show.a(this.b));
            return;
        L19:
            return;
        L18:
            return;
        L10:
            r6 = null;
            goto L11
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DrivePreviewShowResultPlugin() {
    }

    public static final /* synthetic */ boolean access$getMAddPreviewCacheEnable$p(DrivePreviewShowResultPlugin r0) {
        return r0.mAddPreviewCacheEnable;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        this.mAddPreviewCacheEnable = getDriveUserComponentAbility().c.isEnable("ccm.mobile.drive.add_preview_cache_enable");
        ((PreviewViewModel) viewModel(PreviewViewModel.class)).liveInnerPreviewShowStatus().observe(getLifecycleOwner(), new b(r4, this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ f access$findPlugin(DrivePreviewShowResultPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static final /* synthetic */ ViewModel access$viewModel(DrivePreviewShowResultPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }
}
