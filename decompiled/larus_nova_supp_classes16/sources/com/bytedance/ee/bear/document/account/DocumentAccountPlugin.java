package com.bytedance.ee.bear.document.account;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\tH\u0016J\u0012\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/document/account/DocumentAccountPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "disposable", "Lio/reactivex/disposables/Disposable;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onDetachFromHost", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "Companion", "GetCurrentAccountHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentAccountPlugin extends DocumentPlugin {
    private static final String CALLBACK_PARAM_TANENT_TAG = "tanent_tag";
    public static final a Companion = null;
    private static final String GET_CURRENT_USER_INFO = "biz.util.getCurrentUserInfo";
    private static final String TAG = "DocumentAccountPlugin";
    private Disposable disposable;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<Unit> {
        public final /* synthetic */ DocumentAccountPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(DocumentAccountPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, m r5) {
            Unit r6 = (Unit) r4;
            tt5.a.h(DocumentAccountPlugin.TAG, "GetCurrentAccountHandler");
            DocumentAccountPlugin.access$setDisposable$p(this.a, ((h0) org.koin.java.a.c(h0.class, null, null, 6)).T4().subscribe(new com.bytedance.ee.bear.document.account.a(r5), com.bytedance.ee.bear.document.account.b.a));
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DocumentAccountPlugin() {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put(GET_CURRENT_USER_INFO, new b(this));
    }

    public void onDetachFromHost(DocumentPluginHost r1) {
        super.onDetachFromHost(r1);
        Disposable r2 = this.disposable;
        if (r2 == null) goto L6;
        r2.dispose();
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    public static final /* synthetic */ void access$setDisposable$p(DocumentAccountPlugin r0, Disposable r1) {
        r0.disposable = r1;
    }
}
