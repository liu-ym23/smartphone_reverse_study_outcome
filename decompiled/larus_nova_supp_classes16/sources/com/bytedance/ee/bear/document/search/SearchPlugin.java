package com.bytedance.ee.bear.document.search;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.follow.FollowPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.Map;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SearchPlugin extends DocumentPlugin implements BaseSearchPlugin<DocumentPluginHost> {
    private m clearSearchDelegate;
    protected SearchViewModel searchViewModel;
    private m switchSearchDelegate;
    private m updateSearchDelegate;

    public class a implements tb5.i<String> {
        public final /* synthetic */ SearchPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(SearchPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            String r3 = (String) r1;
            SearchPlugin.access$802(this.a, r2);
        }
    }

    public class b implements tb5.i<String> {
        public final /* synthetic */ SearchPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(SearchPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            String r3 = (String) r1;
            this.a.startSearch();
        }
    }

    public class c implements tb5.i<String> {
        public final /* synthetic */ SearchPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(SearchPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            String r3 = (String) r1;
            this.a.searchViewModel.setActive(false);
        }
    }

    public class d implements SearchViewModel.b {
        public final /* synthetic */ SearchPlugin a;

        @Override // com.bytedance.ee.bear.document.search.SearchViewModel.b
        public final boolean a() {
            DocViewModel r0 = SearchPlugin.access$900(this.a);
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.getOpenSource() != DocsOpenSource.vc) goto L7;
            return true;
        }

        @Override // com.bytedance.ee.bear.document.search.SearchViewModel.b
        public void b() {
            if (SearchPlugin.access$800(this.a) == null) goto L6;
            SearchPlugin.access$800(this.a).b(new JSONObject());
            return;
        }

        public d(SearchPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.search.SearchViewModel.b
        public void c(int r3) {
            if (SearchPlugin.access$700(this.a) == null) goto L6;
            JSONObject r0 = new JSONObject();
            r0.put("index", Integer.valueOf(r3));
            SearchPlugin.access$700(this.a).b(r0);
            return;
        }

        @Override // com.bytedance.ee.bear.document.search.SearchViewModel.b
        public void d(String r3, boolean r4) {
            if (SearchPlugin.access$600(this.a) == null) goto L6;
            JSONObject r0 = new JSONObject();
            r0.put("content", r3);
            r0.put("inKeyboard", Boolean.valueOf(r4));
            SearchPlugin.access$600(this.a).b(r0);
            return;
        }
    }

    public class e implements tb5.i<String> {
        public final /* synthetic */ SearchPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public e(SearchPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            String r3 = (String) r1;
            SearchPlugin.access$602(this.a, r2);
        }
    }

    public class f implements tb5.i<String> {
        public final /* synthetic */ SearchPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public f(SearchPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            String r3 = (String) r1;
            SearchPlugin.access$702(this.a, r2);
        }
    }

    public class g implements tb5.i<SearchResult> {
        public final /* synthetic */ SearchPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public g(SearchPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            SearchResult r4 = (SearchResult) r2;
            this.a.searchViewModel.updateSearchResult(r4.getCurrentIndex(), r4.getTotalNum());
        }
    }

    public static /* synthetic */ void c(SearchPlugin r0, Boolean r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.document.search.BaseSearchPlugin
    public LiveData<Boolean> getActive() {
        return this.searchViewModel.getActive();
    }

    @Override // com.bytedance.ee.bear.document.search.BaseSearchPlugin
    public void startSearch() {
        this.searchViewModel.setActive(true);
    }

    public void ensureSearchFragment() {
        if (getDocViewModel().getOpenSource() == DocsOpenSource.vc) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L10;
        Fragment r1 = instantiateFragment(SearchToolbarFragment.class);
        getUIContainer().i(this, r1);
        return;
    L10:
        this.searchViewModel.setActive(false);
        return;
    L5:
        if (((FollowPlugin) findPlugin(FollowPlugin.class)).getDocumentFollow().isReplay() == false) goto L7;
        r0 = true;
        goto L8
    }

    public SearchPlugin() {
    }

    @Override // com.bytedance.ee.bear.document.search.BaseSearchPlugin
    public Class<? extends SearchViewModel> getModelClass() {
        return SearchViewModel.class;
    }

    public static /* synthetic */ m access$600(SearchPlugin r0) {
        return r0.updateSearchDelegate;
    }

    public static /* synthetic */ m access$700(SearchPlugin r0) {
        return r0.switchSearchDelegate;
    }

    public static /* synthetic */ m access$800(SearchPlugin r0) {
        return r0.clearSearchDelegate;
    }

    public static /* synthetic */ DocViewModel access$900(SearchPlugin r0) {
        return r0.getDocViewModel();
    }

    private /* synthetic */ void lambda$onAttachToHost$0(Boolean r2) {
        if (Boolean.TRUE.equals(r2) == false) goto L5;
        ensureSearchFragment();
        return;
    L5:
        getUIContainer().d(this);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        r3.put("biz.content.enterSearch", new b(this));
        r3.put("biz.content.search", new e(this));
        r3.put("biz.content.clearSearchResult", new a(this));
        r3.put("biz.content.switchSearchResult", new f(this));
        r3.put("biz.content.updateSearchResult", new g(this));
        r3.put("biz.content.exitSearch", new c(this));
    }

    public void onAttachToHost(DocumentPluginHost r3) {
        super.onAttachToHost(r3);
        SearchViewModel r4 = (SearchViewModel) viewModel(getModelClass());
        this.searchViewModel = r4;
        r4.getActive().observe(getLifecycleOwner(), new com.bytedance.ee.bear.document.search.d(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public static /* synthetic */ m access$602(SearchPlugin r0, m r1) {
        r0.updateSearchDelegate = r1;
        return r1;
    }

    public static /* synthetic */ m access$702(SearchPlugin r0, m r1) {
        r0.switchSearchDelegate = r1;
        return r1;
    }

    public static /* synthetic */ m access$802(SearchPlugin r0, m r1) {
        r0.clearSearchDelegate = r1;
        return r1;
    }

    public void onAttachToUIContainer(DocumentPluginHost r3, t r4) {
        super.onAttachToUIContainer(r3, r4);
        this.searchViewModel.onAttachToUI(r3, getWeb());
        r3.b().registerEditPanel(getLifecycleOwner(), this.searchViewModel);
        pcb.a.a.b(r3.getActivity()).c(this.searchViewModel);
        this.searchViewModel.setDelegate(new d(this));
    }

    public void onDetachFromUIContainer(DocumentPluginHost r3, t r4) {
        pcb.a.a.b(r3.getActivity()).a(this.searchViewModel);
        super.onDetachFromUIContainer(r3, r4);
        this.searchViewModel.onDetachFromUI();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
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
