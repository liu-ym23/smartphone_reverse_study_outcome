package com.bytedance.ee.bear.wikiv2.browser.plugin;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.y4;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiLoaderPlugin extends DocumentPlugin {
    private static final String TAG = "WikiLoaderPlugin";
    private k0 wikiLoader;

    public class a implements Observer<DocumentInfo> {
        public final /* synthetic */ WikiLoaderPlugin a;

        public a(WikiLoaderPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            DocumentInfo r3 = (DocumentInfo) r2;
            WikiLoaderPlugin.access$100(this.a).liveDocumentInfoData().removeObserver(this);
            if (r3 != null) goto L6;
            tt5.a.k(WikiLoaderPlugin.TAG, "liveDocInfoData observer receive null result");
            return;
        }
    }

    public class b implements tb5.i<JSWikiInfo> {
        public final /* synthetic */ WikiLoaderPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(WikiLoaderPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r3, tb5.m r4) {
            WikiInfo r5 = ((JSWikiInfo) r3).toWikiInfo();
            tt5.a.h(WikiLoaderPlugin.TAG, "Wiki info from js :" + r5);
            WikiException.validate(WikiLoaderPlugin.access$400(this.a), r5);     // Catch: WikiException -> L5
            e = null;
        L6:
            if (e != null) goto L8;
            return;
        L8:
            if (e.getCode() != (-8010)) goto L10;
            return;
        L10:
            if (WikiLoaderPlugin.access$200(this.a) == false) goto L14;
            y4 r0 = this.a.getHost().getDocumentLoader();
            if ((r0 instanceof y4) == false) goto L20;
            r0.k(e, null);
            return;
        L20:
            return;
        L14:
            WikiLoaderPlugin.access$300(this.a).k(e, null);
            return;
        L5:
            e = e;
            goto L6
        }
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void bindViewModel() {
        getDocViewModel().liveDocumentInfoData().observe(getLifecycleOwner(), new a(this));
    }

    private boolean isBitableNewLoader() {
        return TextUtils.equals(getDocViewModel().getBearUrl().a, sbb.e.i.getType());
    }

    public WikiLoaderPlugin() {
    }

    public static /* synthetic */ DocViewModel access$100(WikiLoaderPlugin r0) {
        return r0.getDocViewModel();
    }

    public static /* synthetic */ boolean access$200(WikiLoaderPlugin r0) {
        return r0.isBitableNewLoader();
    }

    public static /* synthetic */ k0 access$300(WikiLoaderPlugin r0) {
        return r0.wikiLoader;
    }

    public static /* synthetic */ Context access$400(WikiLoaderPlugin r0) {
        return r0.getContext();
    }

    public void onAttachToHost(DocumentPluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r2);
        if (isBitableNewLoader() == true) goto L5;
        k0 r0 = new k0(r2);
        this.wikiLoader = r0;
        r2.d = r0;
    L5:
        bindViewModel();
        bindBridgeHandler("biz.wiki.setWikiInfo", new b(this));
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }
}
