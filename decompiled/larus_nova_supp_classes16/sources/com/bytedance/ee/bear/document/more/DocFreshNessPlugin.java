package com.bytedance.ee.bear.document.more;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfoPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001\u000eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/document/more/DocFreshNessPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "Lcom/bytedance/ee/bear/more/item/IDocFreshNessChangeListener;", "<init>", "()V", "retryToken", "", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "onDetachFromHost", "onDocFreshNessChange", "getRetryToken", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocFreshNessPlugin extends DocumentPlugin implements qj5.b {
    public static final a Companion = null;
    public static final String TAG = "DocFreshNessPlugin";
    private String retryToken;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DocFreshNessPlugin a;

        public b(DocFreshNessPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            String r6 = (String) r5;
            Intrinsics.checkNotNull(r6);
            if (r6.length() <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == true) goto L8;
            return;
        L8:
            if (((a4) org.koin.java.a.c(a4.class, null, null, 6)).c(DocFreshNessPlugin.access$getRetryToken$p(this.a)) == true) goto L10;
            return;
        L10:
            if (Intrinsics.areEqual(DocFreshNessPlugin.access$getRetryToken$p(this.a), r6) == true) goto L15;
            ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).L(r6, DocFreshNessPlugin.access$getRetryToken$p(this.a), this.a);
            return;
        L15:
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public void onDocFreshNessChange() {
        DocumentInfoPlugin r0 = (DocumentInfoPlugin) findPlugin(DocumentInfoPlugin.class);
        if (r0 == null) goto L6;
        r0.requestDocumentInfo();
        return;
    }

    public DocFreshNessPlugin() {
        this.retryToken = "";
    }

    public String getRetryToken() {
        return this.retryToken;
    }

    public static final /* synthetic */ String access$getRetryToken$p(DocFreshNessPlugin r0) {
        return r0.retryToken;
    }

    public void onAttachToHost(DocumentPluginHost r3) {
        super.onAttachToHost(r3);
        this.retryToken = getDocViewModel().getToken();
        getDocViewModel().liveDocObjToken().observe(getLifecycleOwner(), new b(this));
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).n(getDocViewModel().getToken(), this);
    }

    public void onDetachFromHost(DocumentPluginHost r3) {
        super.onDetachFromHost(r3);
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).p(getDocViewModel().getToken(), this);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }
}
