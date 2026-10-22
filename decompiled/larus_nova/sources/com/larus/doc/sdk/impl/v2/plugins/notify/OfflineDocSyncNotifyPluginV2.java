package com.larus.doc.sdk.impl.v2.plugins.notify;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import vz4.h;
import vz4.i;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/notify/OfflineDocSyncNotifyPluginV2;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "<init>", "()V", "listener", "Lcom/bytedance/ee/bear/document/ability/OfflineSyncCollabStatusListener;", "onAttachToHost", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onDetachFromHost", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfflineDocSyncNotifyPluginV2 extends OfficeDocumentPlugin {
    public static final Companion Companion = null;
    private static final String TAG = "OfflineDocSyncNotifyPluginV2";
    private final i listener;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/notify/OfflineDocSyncNotifyPluginV2$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.bytedance.ee.bear.document.OfficeDocumentPlugin, com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public OfflineDocSyncNotifyPluginV2() {
        this.listener = new OfflineDocSyncNotifyPluginV2$listener$1(this);
    }

    public static final /* synthetic */ i access$getListener$p(OfflineDocSyncNotifyPluginV2 r100) {
        return r100.listener;
    }

    public void onAttachToHost(ChameleonPluginHost r100) {
        super.onAttachToHost(r100);
        if (r100 == null) goto L8;
        h r101 = (h) r100.getHostAbility(h.class);
        if (r101 == null) goto L9;
        r101.addOfflineSyncCollabStatusListener(this.listener);
        return;
    L9:
        return;
    }

    public void onDetachFromHost(ChameleonPluginHost r100) {
        super.onDetachFromHost(r100);
        if (r100 == null) goto L8;
        h r101 = (h) r100.getHostAbility(h.class);
        if (r101 == null) goto L9;
        r101.removeOfflineSyncCollabStatusListener(this.listener);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((ChameleonPluginHost) r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r100) {
        onDetachFromHost((ChameleonPluginHost) r100);
    }
}
