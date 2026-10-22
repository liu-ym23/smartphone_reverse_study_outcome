package com.bytedance.ee.bear.document;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "Lcom/ss/android/lark/chameleon/AbsChameleonPlugin;", "<init>", "()V", "getDocumentMetadata", "Lcom/bytedance/ee/bear/document/BaseDocumentMetadata;", "getDocumentLoader", "Lcom/bytedance/ee/bear/document/DocumentLoader;", "getWeb", "Lcom/bytedance/ee/bear/browser/Web;", "docs-document-sdk-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class OfficeDocumentPlugin extends AbsChameleonPlugin {
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final x2 getDocumentLoader() {
        ChameleonPluginHost r0 = getHost();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (x2) r0.getHostAbility(x2.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final d getDocumentMetadata() {
        ChameleonPluginHost r0 = getHost();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (d) r0.getHostAbility(d.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final vv4.k getWeb() {
        ChameleonPluginHost r0 = getHost();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getWeb();
    }

    public OfficeDocumentPlugin() {
    }
}
