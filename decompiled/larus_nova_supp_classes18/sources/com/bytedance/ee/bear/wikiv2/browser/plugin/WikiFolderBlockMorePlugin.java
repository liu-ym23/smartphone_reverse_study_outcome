package com.bytedance.ee.bear.wikiv2.browser.plugin;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetNodePermPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeMoreProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/browser/plugin/WikiFolderBlockMorePlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "wikiViewModel", "Lcom/bytedance/ee/bear/wikiv2/browser/plugin/WikiViewModel;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "onDetachFromHost", "Companion", "WikiFolderMoreHandler", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiFolderBlockMorePlugin extends DocumentPlugin {
    public static final a Companion = null;
    public static final String TAG = "WikiFolderBlockMorePlugin";
    private final CompositeDisposable disposables;
    private NetService netService;
    private WikiViewModel wikiViewModel;

    public static final class a {
        public a() {
        }
    }

    public final class b implements tb5.i<JSWikiMoreModel> {
        public final /* synthetic */ WikiFolderBlockMorePlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(WikiFolderBlockMorePlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r20, tb5.m r21) {
            JSWikiMoreModel r1 = (JSWikiMoreModel) r20;
            if (r1 == null) goto L5;
            TreeNode r3 = r1.m664getTreeNode();
        L6:
            if (r3 != null) goto L8;
            tt5.a.d(WikiFolderBlockMorePlugin.TAG, "JSWikiMoreModel data is null, return");
            return;
        L8:
            NetService r10 = WikiFolderBlockMorePlugin.access$getNetService$p(this.a);
            if (r10 == null) goto L28;
            WikiFolderBlockMorePlugin r4 = this.a;
            TreeNode r2 = r1.m664getTreeNode();
            WikiTreeMoreProvider r15 = new WikiTreeMoreProvider(r2, WikNodePerm.defaulted(), new SpaceInfo(), false, new ce5.a(r4.getHost().getUserComponent()));
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.t r14 = new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.t(r4.getHost().getContext(), com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j.a(r2, new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a()), r2, r4.getHost().c(), r4.getHost(), r10);
            r15.r = r14;
            WikiDialogs r5 = new WikiDialogs();
            FragmentActivity r12 = r4.getHost().getActivity();
            SpaceInfo r6 = new SpaceInfo();
            r6.space_id = r2.space_id;
            Unit r7 = Unit.INSTANCE;
            r5.l(r12, r2, r6, r14, r15, null, null);
            if (r2.isShortcut() == false) goto L23;
            String r8 = r2.origin_title;
            if (r8 != null) goto L15;
        L18:
            boolean r9 = true;
        L19:
            if (r9 == false) goto L23;
            Disposable r11 = ((com.bytedance.ee.bear.d) org.koin.java.a.c(com.bytedance.ee.bear.d.class, null, null, 6)).b(r2.obj_token, r2.obj_type).subscribe(new c0(r2), d0.a);
            if (r11 == null) goto L23;
            up5.g.a(r11, WikiFolderBlockMorePlugin.access$getDisposables$p(this.a));
            goto L23
        L15:
            if (r8.length() == 0) goto L18;
            r9 = false;
        L23:
            Disposable r13 = new GetNodePermPuller((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).d(new GetNodePermPuller.Params(r2.space_id, r2.wiki_token)).subscribe(new e0(r2, r5), f0.a);
            if (r13 == null) goto L29;
            up5.g.a(r13, WikiFolderBlockMorePlugin.access$getDisposables$p(this.a));
            return;
        L29:
            return;
        L28:
            return;
        L5:
            r3 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public WikiFolderBlockMorePlugin() {
        this.disposables = new CompositeDisposable();
    }

    public static final /* synthetic */ CompositeDisposable access$getDisposables$p(WikiFolderBlockMorePlugin r0) {
        return r0.disposables;
    }

    public static final /* synthetic */ NetService access$getNetService$p(WikiFolderBlockMorePlugin r0) {
        return r0.netService;
    }

    public void onAttachToHost(DocumentPluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        tt5.a.h(TAG, "onAttachToHost, bindBridgeHandler");
        bindBridgeHandler("biz.wiki.folderBlockMore", new b(this));
        this.wikiViewModel = g1.a(getHost());
        if (r3 == null) goto L7;
        vo5.a r4 = r3.getUserComponent();
        if (r4 == null) goto L7;
        NetService r5 = (NetService) r4.a(NetService.class);
    L8:
        this.netService = r5;
        return;
    L7:
        r5 = null;
        goto L8
    }

    public void onDetachFromHost(DocumentPluginHost r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r1);
        this.disposables.dispose();
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }
}
