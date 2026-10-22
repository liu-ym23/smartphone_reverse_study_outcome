package com.bytedance.ee.bear.wikiv2.browser.plugin;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.BasePluginV2;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.d4;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.e3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J0\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J,\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010\u001d\u001a\u00020\rH\u0002J\b\u0010\u001e\u001a\u00020\rH\u0002J\u0016\u0010\u001f\u001a\u00020\r2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/browser/plugin/WikiTreePlugin;", "Lcom/bytedance/ee/bear/browser/plugin/BasePluginV2;", "<init>", "()V", "isInit", "", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "lastInitWikiToken", "", "wikiFakeTokenChangedObserver", "Landroidx/lifecycle/Observer;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "refreshWikiTreeIfNeed", "wikiViewModel", "Lcom/bytedance/ee/bear/wikiv2/browser/plugin/WikiViewModel;", "onDetachFromHost", "initWikiTree", "spaceId", WikiFolderPushPlugin.WIKI_TOKEN, "snapshot", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/Workspace;", "pathResolveContext", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/pathresolve/WikiPathResolveContext;", "initViewModel", "bindReusedWikiTree", "setViewModelDelegate", "checkWikiDeleted", "addOnLoadSuccess", "callback", "Lkotlin/Function0;", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiTreePlugin extends BasePluginV2 {
    public static final a Companion = null;
    private static final String TAG = "WikiTreePlugin";
    private boolean isInit;
    private String lastInitWikiToken;
    private ce5.a userComponentAbility;
    private Observer<String> wikiFakeTokenChangedObserver;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements com.bytedance.ee.bear.contract.route.parcelable.i.a {
        public final /* synthetic */ Function0<Unit> a;

        public final void onLoadFail() {
        }

        public final void onLoadStart() {
        }

        public final void onLoadSuccess() {
            this.a.invoke();
        }

        public b(Function0<Unit> r1) {
            this.a = r1;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ WikiTreePlugin a;
        public final /* synthetic */ PluginHost b;

        public c(WikiTreePlugin r1, PluginHost r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r8) {
            String r2 = (String) r8;
            Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
            boolean r9 = bx4.b.b(r2);
            tt5.a.h(WikiTreePlugin.TAG, "wikiFakeTokenChangedObserver onChanged, token?=false, isFakeToken= " + r9);
            if (r9 == true) goto L6;
            WikiTreePlugin.initWikiTree$default(this.a, g1.a(this.b).getSpaceId(), r2, null, null, 12, null);
            return;
        }
    }

    public static final class d extends WikiTreeCtrlView.d {
        public final /* synthetic */ WikiTreePlugin a;

        public d(WikiTreePlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
        public final void j(String r2) {
            Intrinsics.checkNotNullParameter(r2, "delParentToken");
            WikiTreePlugin.access$checkWikiDeleted(this.a);
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
        public final void n(String r2) {
            Intrinsics.checkNotNullParameter(r2, "delParentToken");
            WikiTreePlugin.access$checkWikiDeleted(this.a);
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
        public final void i(String r2, List<String> r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "toSpaceId");
            Intrinsics.checkNotNullParameter(r3, "movTokenList");
            Intrinsics.checkNotNullParameter(r4, "focusToken");
            WikiTreePlugin.access$checkWikiDeleted(this.a);
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
        public final void k(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "toSpaceId");
            Intrinsics.checkNotNullParameter(r3, "movToken");
            Intrinsics.checkNotNullParameter(r4, "focusToken");
            WikiTreePlugin.access$checkWikiDeleted(this.a);
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void setViewModelDelegate() {
        int r0 = WikiTreeCtrlView.q;
        ViewModelStoreOwner r1 = getHost();
        ce5.a r2 = null;
        if (ForsetiHelper.s(r1.getHostFragment()) == true) goto L6;
        r1 = null;
    L6:
        if (r1 != null) goto L9;
        r1 = getActivity();
    L9:
        Intrinsics.checkNotNull(r1);
        LifecycleOwner r3 = getLifecycleOwner();
        d r4 = new d(this);
        ce5.a r5 = this.userComponentAbility;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("userComponentAbility");
    L13:
        Intrinsics.checkNotNullParameter(r1, "dataLifeOwner");
        Intrinsics.checkNotNullParameter(r3, "delegateLifeOwner");
        Intrinsics.checkNotNullParameter(r4, "delegate");
        Intrinsics.checkNotNullParameter(r2, "userComponentAbility");
        WikiTreeCtrlView.a.a(r1, r2).getWikiUIList().observe(r3, new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.u0(r4));
        return;
    L12:
        r2 = r5;
        goto L13
    }

    private final void checkWikiDeleted() {
        String r0 = g1.a(getHost()).getWikiToken();
        int r1 = WikiTreeCtrlView.q;
        ViewModelStoreOwner r2 = getHost();
        ce5.a r3 = null;
        if (ForsetiHelper.s(r2.getHostFragment()) == true) goto L6;
        r2 = null;
    L6:
        if (r2 != null) goto L9;
        r2 = getActivity();
    L9:
        Intrinsics.checkNotNull(r2);
        ce5.a r4 = this.userComponentAbility;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("userComponentAbility");
    L13:
        Intrinsics.checkNotNullParameter(r2, "dataLifeOwner");
        Intrinsics.checkNotNullParameter(r0, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r3, "userComponentAbility");
        TreeNode r5 = WikiTreeCtrlView.a.a(r2, r3).getNode(r0);
        boolean r6 = false;
        if (r5 != null) goto L16;
        boolean r7 = true;
    L17:
        tt5.a.h(TAG, "checkWikiDeleted. deleted: " + r7);
        d4 r8 = getHostAbilityOrNull(d4.class);
        if (r8 == null) goto L20;
        r6 = r8.isEditionDoc();
    L20:
        if (r7 == false) goto L28;
        if (r6 == false) goto L23;
        return;
    L23:
        if (ForsetiHelper.s(getHost().getHostFragment()) == true) goto L30;
        FragmentActivity r9 = getHost().getActivity();
        if (r9 == null) goto L31;
        r9.finish();
        return;
    L31:
        return;
    L30:
        return;
    L28:
        return;
    L16:
        r7 = false;
        goto L17
    L12:
        r3 = r4;
        goto L13
    }

    public WikiTreePlugin() {
    }

    public static final /* synthetic */ void access$checkWikiDeleted(WikiTreePlugin r0) {
        r0.checkWikiDeleted();
    }

    private final void addOnLoadSuccess(Function0<Unit> r4) {
        com.bytedance.ee.bear.contract.route.parcelable.i r0 = getHost().getHostAbilityOrNull(com.bytedance.ee.bear.contract.route.parcelable.i.class);
        StringBuilder r1 = new StringBuilder("loadingCallbackAbility?=");
        if (r0 != null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        tt5.a.h(TAG, r1.toString());
        if (r0 == null) goto L10;
        r0.addLoadingCallback(new b(r4));
        return;
    L10:
        return;
    L5:
        r2 = false;
        goto L6
    }

    private final void bindReusedWikiTree(String r2) {
        if (this.isInit == false) goto L5;
        return;
    L5:
        if (com.ss.android.lark.utils.y0.a(this.lastInitWikiToken, r2) == true) goto L13;
        this.lastInitWikiToken = r2;
        setViewModelDelegate();
        if (bx4.b.b(r2) == true) goto L12;
        this.isInit = true;
        return;
    L12:
        return;
    }

    public void onAttachToHost(PluginHost r9) {
        Intrinsics.checkNotNullParameter(r9, "host");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r9);
        this.userComponentAbility = new ce5.a(r9.getUserComponent());
        final WikiViewModel r0 = g1.a(r9);
        final String r2 = r0.getSpaceId();
        final String r3 = r0.getWikiToken();
        e3 r4 = g3.a.a.a.getAndSet(null);
        if (r4 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
    L12:
        addOnLoadSuccess(new AnonymousClass1(r0, this, r2, r3));
    L13:
        refreshWikiTreeIfNeed(r9, r0);
        return;
    L10:
        if (r0.hasPathResolveContext() == true) goto L12;
        initWikiTree$default(this, r2, r3, r4, null, 8, null);
        goto L13
    L5:
        if (r4.x(r3) == false) goto L7;
        r1 = true;
        goto L8
    }

    public void onDetachFromHost(PluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r2);
        Observer<String> r0 = this.wikiFakeTokenChangedObserver;
        if (r0 == null) goto L6;
        g1.a(r2).getWikiTokenLiveData().removeObserver(r0);
        return;
    }

    public static final /* synthetic */ void access$bindReusedWikiTree(WikiTreePlugin r0, String r1) {
        r0.bindReusedWikiTree(r1);
    }

    private final void refreshWikiTreeIfNeed(PluginHost r2, WikiViewModel r3) {
        if (bx4.b.b(r3.getWikiToken()) == false) goto L6;
        c r0 = new c(this, r2);
        r3.getWikiTokenLiveData().observe(r2.getLifecycleOwner(), r0);
        this.wikiFakeTokenChangedObserver = r0;
        return;
    }

    private final void initViewModel(String r12, String r13, e3 r14, ar5.a r15) {
        WikiTreeCtrlView.c r0 = new WikiTreeCtrlView.c();
        r0.e = true;
        r0.f = true;
        Intrinsics.checkNotNullParameter("Wiki_WikiTreePanelDialog", "<set-?>");
        r0.p = "Wiki_WikiTreePanelDialog";
        r0.t = r15;
        ce5.a r4 = null;
        if (r14 == null) goto L16;
        int r16 = WikiTreeCtrlView.q;
        ViewModelStoreOwner r17 = getHost();
        if (ForsetiHelper.s(r17.getHostFragment()) == true) goto L8;
        r17 = null;
    L8:
        if (r17 != null) goto L11;
        r17 = getActivity();
    L11:
        Intrinsics.checkNotNull(r17);
        ce5.a r18 = this.userComponentAbility;
        if (r18 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("userComponentAbility");
    L15:
        Intrinsics.checkNotNullParameter(r17, "dataLifeOwner");
        Intrinsics.checkNotNullParameter(r14, "workspace");
        Intrinsics.checkNotNullParameter(r0, "config");
        Intrinsics.checkNotNullParameter(r4, "userComponentAbility");
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r5 = WikiTreeCtrlView.a.a(r17, r4);
        r5.setChainPushEnable(r0.e);
        r5.setLocalPushEnable(r0.f);
        r5.setTagSuffix(r0.p);
        r5.load(r14, "", "", true, true);
        return;
    L14:
        r4 = r18;
        goto L15
    L16:
        int r19 = WikiTreeCtrlView.q;
        ViewModelStoreOwner r110 = getHost();
        if (ForsetiHelper.s(r110.getHostFragment()) == true) goto L20;
        r110 = null;
    L20:
        if (r110 != null) goto L23;
        r110 = getActivity();
    L23:
        Intrinsics.checkNotNull(r110);
        ce5.a r6 = this.userComponentAbility;
        if (r6 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("userComponentAbility");
    L27:
        Intrinsics.checkNotNullParameter(r110, "dataLifeOwner");
        Intrinsics.checkNotNullParameter(r12, "spaceId");
        Intrinsics.checkNotNullParameter(r13, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r0, "config");
        Intrinsics.checkNotNullParameter(r4, "userComponentAbility");
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r111 = WikiTreeCtrlView.a.a(r110, r4);
        r111.setChainPushEnable(r0.e);
        r111.setLocalPushEnable(r0.f);
        r111.setTagSuffix(r0.p);
        if (r0.t == null) goto L30;
        r111.setViewConfig(r0);
    L30:
        r111.load(r12, r13, "", true);
        return;
    L26:
        r4 = r6;
        goto L27
    }

    private final void initWikiTree(String r5, String r6, e3 r7, ar5.a r8) {
        boolean r0 = com.ss.android.lark.utils.y0.a(this.lastInitWikiToken, r6);
        StringBuilder r1 = new StringBuilder("initWikiTree. isInit: ");
        r1.append(this.isInit);
        r1.append(", snapshot?=");
        if (r7 != null) goto L5;
        boolean r3 = true;
    L6:
        r1.append(r3);
        r1.append(", wikiToken=");
        if ((r6 instanceof Object) == false) goto L9;
        String r4 = r6;
    L10:
        r1.append(du5.b.f(r4));
        r1.append(", initWikiTokenRepeat=");
        r1.append(r0);
        tt5.a.h(TAG, r1.toString());
        this.lastInitWikiToken = r6;
        if (this.isInit == true) goto L18;
        if (r0 == true) goto L20;
        initViewModel(r5, r6, r7, r8);
        setViewModelDelegate();
        if (bx4.b.b(r6) == true) goto L19;
        this.isInit = true;
        return;
    L19:
        return;
    L20:
        return;
    L18:
        return;
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = false;
        goto L6
    }

    public static /* synthetic */ void initWikiTree$default(WikiTreePlugin r1, String r2, String r3, e3 r4, ar5.a r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        r1.initWikiTree(r2, r3, r4, r5);
    }
}
