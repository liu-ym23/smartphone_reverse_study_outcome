package com.bytedance.ee.bear.document.quota;

import a35.d0;
import a35.e0;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.offline.sync.sync.SyncStatusModel;
import com.bytedance.ee.bear.quoto.t;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/document/quota/MindnoteSyncStatusPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "onAttachToUIContainer", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MindnoteSyncStatusPlugin extends DocumentPlugin {
    public static final a Companion = null;
    public static final String TAG = "MindnoteQuotaSyncStatusPlugin";

    public static final class a {
        public a() {
        }
    }

    public static final class b implements d0 {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // a35.d0
        public final void a(SyncStatusModel r6) {
            StringBuilder r0 = new StringBuilder("notifySyncStatus    FEdata.status: ");
            if (r6 == null) goto L5;
            Integer r2 = Integer.valueOf(r6.status);
        L6:
            r0.append(r2);
            r0.append("    FEdata.objToken: ");
            if (r6 == null) goto L10;
            String r3 = r6.objToken;
            if (r3 == null) goto L10;
        L11:
            r0.append(du5.b.e(r3));
            r0.append("    code: ");
            if (r6 == null) goto L14;
            Integer r4 = Integer.valueOf(r6.code);
        L15:
            r0.append(r4);
            tt5.a.h(MindnoteSyncStatusPlugin.TAG, r0.toString());
            if (r6 == null) goto L20;
            boolean r5 = true;
            if (r6.status != 1) goto L20;
        L21:
            if (r5 == false) goto L24;
            ((t) org.koin.java.a.c(t.class, null, null, 6)).l(r6.code, null);
            ((t) org.koin.java.a.c(t.class, null, null, 6)).h(r6.code, null, false);
            return;
        L24:
            return;
        L20:
            r5 = false;
            goto L21
        L14:
            r4 = null;
        L10:
            r3 = "";
            goto L11
        L5:
            r2 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public MindnoteSyncStatusPlugin() {
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super.onAttachToUIContainer(r1, r2);
        bindBridgeHandler("biz.util.notifySyncStatus", new e0(b.a));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }
}
