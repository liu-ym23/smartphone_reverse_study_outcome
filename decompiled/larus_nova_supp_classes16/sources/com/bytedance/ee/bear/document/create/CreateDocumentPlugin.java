package com.bytedance.ee.bear.document.create;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.k;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import fo5.d;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import o05.b;
import o05.c;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class CreateDocumentPlugin extends DocumentPlugin {
    private static final String CREATE_NEW_PAGE = "biz.util.createNewPage";
    private static final String TAG = "CreateDocumentPlugin";
    private final CompositeDisposable mDisposable;

    public class a implements i<Void> {
        public final /* synthetic */ CreateDocumentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(CreateDocumentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r5, m r6) {
            Void r7 = (Void) r5;
            final int r8 = CreateDocumentPlugin.access$100(this.a).getDocumentTypeValue();
            String r9 = CreateDocumentPlugin.access$200(this.a).getDocumentType();
            if (r8 != 2) goto L5;
        L8:
            boolean r0 = true;
        L9:
            boolean r1 = ((rc5.a) org.koin.java.a.a(rc5.a.class)).B();
            if (r0 == false) goto L12;
            Disposable r10 = ((rc5.a) org.koin.java.a.a(rc5.a.class)).J(r8, r9, r1).observeOn(d.d()).subscribe(new o05.a(r8), new b());
        L13:
            CreateDocumentPlugin.access$400(this.a).add(r10);
            return;
        L12:
            r10 = ((rc5.a) org.koin.java.a.a(rc5.a.class)).t(new k(CreateDocumentPlugin.access$300(this.a), r8, r9, r1)).observeOn(d.d()).subscribe(new c(), new o05.d(this));
            goto L13
        L5:
            if (r8 == 3) goto L8;
            r0 = false;
            goto L9
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public CreateDocumentPlugin() {
        this.mDisposable = new CompositeDisposable();
    }

    public static /* synthetic */ DocViewModel access$100(CreateDocumentPlugin r0) {
        return r0.getDocViewModel();
    }

    public static /* synthetic */ DocViewModel access$200(CreateDocumentPlugin r0) {
        return r0.getDocViewModel();
    }

    public static /* synthetic */ Context access$300(CreateDocumentPlugin r0) {
        return r0.getContext();
    }

    public static /* synthetic */ CompositeDisposable access$400(CreateDocumentPlugin r0) {
        return r0.mDisposable;
    }

    public static /* synthetic */ boolean access$500(CreateDocumentPlugin r0) {
        return r0.isUIContainerAttached();
    }

    public static /* synthetic */ FragmentActivity access$600(CreateDocumentPlugin r0) {
        return r0.getActivity();
    }

    public static /* synthetic */ FragmentActivity access$700(CreateDocumentPlugin r0) {
        return r0.getActivity();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        r3.put(CREATE_NEW_PAGE, new a(this));
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        this.mDisposable.clear();
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }
}
