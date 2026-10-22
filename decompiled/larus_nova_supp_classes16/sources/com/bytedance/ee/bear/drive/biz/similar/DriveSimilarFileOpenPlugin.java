package com.bytedance.ee.bear.drive.biz.similar;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0002¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/similar/DriveSimilarFileOpenPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onProcessSimilarFileOpen", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSimilarFileOpenPlugin extends AbsDrivePlugin {
    public static final a Companion = null;
    private static final String TAG = "DriveSimilarFileOpenPlugin";

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DriveSimilarFileOpenPlugin a;

        public b(DriveSimilarFileOpenPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            tt5.a.h(DriveSimilarFileOpenPlugin.TAG, "liveInnerSimilarFileOpen receive, data=" + ((String) r3));
            DriveSimilarFileOpenPlugin.access$onProcessSimilarFileOpen(this.a);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void onProcessSimilarFileOpen() {
        w75.a r0 = getHost().c.getFileModel();
        if (r0 == null) goto L5;
        List<Integer> r2 = r0.b;
    L6:
        List<Integer> r3 = r2;
        if (r3 != null) goto L9;
    L12:
        boolean r4 = true;
    L14:
        if (r4 == false) goto L16;
    L20:
        tt5.a.k(TAG, "onProcessSimilarFileOpen fail, serverSupportPreviewType not support");
        return;
    L16:
        if (r2.contains(-2) == false) goto L20;
        tt5.a.h(TAG, "onProcessSimilarFileOpen step running");
        r0.q = 4;
        r0.w = "7";
        r0.b = CollectionsKt.listOf(-2);
        getHost().c().a();
        return;
    L9:
        if (r3.isEmpty() == true) goto L12;
        r4 = false;
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    public DriveSimilarFileOpenPlugin() {
    }

    public static final /* synthetic */ void access$onProcessSimilarFileOpen(DriveSimilarFileOpenPlugin r0) {
        r0.onProcessSimilarFileOpen();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super.onAttachToHost(r3);
        k75.a.i(r3).liveInnerSimilarFileOpen().observe(getLifecycleOwner(), new b(this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }
}
