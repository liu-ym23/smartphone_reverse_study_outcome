package com.bytedance.ee.bear.drive.biz.ability;

import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import kotlin.Metadata;
import w45.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\rB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u000f\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/ability/WikiDriveFileHostPlugin;", "Lcom/bytedance/ee/bear/browser/plugin/BasePlugin;", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "Lcom/bytedance/ee/bear/drive/ability/FileHostAbility;", "<init>", "()V", "onAttachToHost", "", "host", "onDetachFromHost", "getFileSize", "", "()Ljava/lang/Long;", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiDriveFileHostPlugin extends BasePlugin<DrivePluginHost> implements b {
    public static final a Companion = null;
    private static final String TAG = "WikiDriveFileHostPlugin";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // w45.b
    public Long getFileSize() {
        w75.a r0 = getHost().c.getFileModel();
        if (r0 == null) goto L7;
        w75.b r1 = r0.c();
        if (r1 == null) goto L7;
        Long r2 = Long.valueOf(r1.c);
    L8:
        StringBuilder r3 = new StringBuilder("getFileSize = ");
        if (r2 != null) goto L11;
        Object r4 = DiagramData$RESULT.FAIL;
    L12:
        r3.append(r4);
        tt5.a.h(TAG, r3.toString());
        return r2;
    L11:
        r4 = r2;
    L7:
        r2 = null;
        goto L8
    }

    public WikiDriveFileHostPlugin() {
    }

    public void onAttachToHost(DrivePluginHost r1) {
        super.onAttachToHost(r1);
        if (r1 == null) goto L6;
        r1.registerHostAbility(this);
        return;
    }

    public void onDetachFromHost(DrivePluginHost r1) {
        super.onDetachFromHost(r1);
        if (r1 == null) goto L6;
        r1.unregisterHostAbility(this);
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
}
