package com.bytedance.ee.bear.document.search;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Map;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfficeSearchPlugin extends DocumentPluginV3 implements BaseSearchPlugin<ChameleonPluginHost> {
    private m clearSearchDelegate;
    protected SearchViewModel searchViewModel;
    private m switchSearchDelegate;
    private m updateSearchDelegate;

    public class a implements tb5.i<String> {
        public final /* synthetic */ OfficeSearchPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(OfficeSearchPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            String r3 = (String) r1;
            OfficeSearchPlugin.access$802(this.a, r2);
        }
    }

    public class b implements tb5.i<String> {
        public final /* synthetic */ OfficeSearchPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(OfficeSearchPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            String r3 = (String) r1;
            this.a.startSearch();
        }
    }

    public class c implements tb5.i<String> {
        public final /* synthetic */ OfficeSearchPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(OfficeSearchPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            String r3 = (String) r1;
            this.a.searchViewModel.setActive(false);
        }
    }

    public class d implements SearchViewModel.b {
        public final /* synthetic */ OfficeSearchPlugin a;

        @Override // com.bytedance.ee.bear.document.search.SearchViewModel.b
        public final boolean a() {
            y3 r0 = (y3) this.a.getHostAbilityOrNull(y3.class);
            if (r0 != null) goto L6;
            return false;
        L6:
            if (r0.getOpenSource() != DocsOpenSource.vc) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // com.bytedance.ee.bear.document.search.SearchViewModel.b
        public void b() {
            if (OfficeSearchPlugin.access$800(this.a) == null) goto L6;
            OfficeSearchPlugin.access$800(this.a).b(new JSONObject());
            return;
        }

        public d(OfficeSearchPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.search.SearchViewModel.b
        public void c(int r3) {
            if (OfficeSearchPlugin.access$700(this.a) == null) goto L6;
            JSONObject r0 = new JSONObject();
            r0.put("index", Integer.valueOf(r3));
            OfficeSearchPlugin.access$700(this.a).b(r0);
            return;
        }

        @Override // com.bytedance.ee.bear.document.search.SearchViewModel.b
        public void d(String r3, boolean r4) {
            if (OfficeSearchPlugin.access$600(this.a) == null) goto L6;
            JSONObject r0 = new JSONObject();
            r0.put("content", r3);
            r0.put("inKeyboard", Boolean.valueOf(r4));
            OfficeSearchPlugin.access$600(this.a).b(r0);
            return;
        }
    }

    public class e implements tb5.i<String> {
        public final /* synthetic */ OfficeSearchPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public e(OfficeSearchPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            String r3 = (String) r1;
            OfficeSearchPlugin.access$602(this.a, r2);
        }
    }

    public class f implements tb5.i<String> {
        public final /* synthetic */ OfficeSearchPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public f(OfficeSearchPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            String r3 = (String) r1;
            OfficeSearchPlugin.access$702(this.a, r2);
        }
    }

    public class g implements tb5.i<SearchResult> {
        public final /* synthetic */ OfficeSearchPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public g(OfficeSearchPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            SearchResult r4 = (SearchResult) r2;
            this.a.searchViewModel.updateSearchResult(r4.getCurrentIndex(), r4.getTotalNum());
        }
    }

    public static /* synthetic */ void a(OfficeSearchPlugin r0, Boolean r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ensureSearchFragment() {
        Fragment r0 = instantiateFragment(SearchToolbarFragment.class);
        getUIContainer().i(this, r0);
    }

    @Override // com.bytedance.ee.bear.document.search.BaseSearchPlugin
    public LiveData<Boolean> getActive() {
        return this.searchViewModel.getActive();
    }

    @Override // com.bytedance.ee.bear.document.search.BaseSearchPlugin
    public void startSearch() {
        this.searchViewModel.setActive(true);
    }

    public OfficeSearchPlugin() {
    }

    @Override // com.bytedance.ee.bear.document.search.BaseSearchPlugin
    public Class<? extends SearchViewModel> getModelClass() {
        return SearchViewModel.class;
    }

    public static /* synthetic */ m access$600(OfficeSearchPlugin r0) {
        return r0.updateSearchDelegate;
    }

    public static /* synthetic */ m access$700(OfficeSearchPlugin r0) {
        return r0.switchSearchDelegate;
    }

    public static /* synthetic */ m access$800(OfficeSearchPlugin r0) {
        return r0.clearSearchDelegate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ void lambda$onAttachToHost$0(Boolean r2) {
        if (Boolean.TRUE.equals(r2) == false) goto L5;
        ensureSearchFragment();
        return;
    L5:
        getUIContainer().d(this);
    }

    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        r3.put("biz.content.enterSearch", new b(this));
        r3.put("biz.content.search", new e(this));
        r3.put("biz.content.clearSearchResult", new a(this));
        r3.put("biz.content.switchSearchResult", new f(this));
        r3.put("biz.content.updateSearchResult", new g(this));
        r3.put("biz.content.exitSearch", new c(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(ChameleonPluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        SearchViewModel r4 = (SearchViewModel) viewModel(getModelClass());
        this.searchViewModel = r4;
        r4.getActive().observe(getLifecycleOwner(), new com.bytedance.ee.bear.document.search.a(this));
    }

    @Override // com.bytedance.ee.bear.document.search.BaseSearchPlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public static /* synthetic */ m access$602(OfficeSearchPlugin r0, m r1) {
        r0.updateSearchDelegate = r1;
        return r1;
    }

    public static /* synthetic */ m access$702(OfficeSearchPlugin r0, m r1) {
        r0.switchSearchDelegate = r1;
        return r1;
    }

    public static /* synthetic */ m access$802(OfficeSearchPlugin r0, m r1) {
        r0.clearSearchDelegate = r1;
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToUIContainer(ChameleonPluginHost r3, t r4) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r3, r4);
        this.searchViewModel.onAttachToUI(r3, getWeb());
        h35.a.a(r3).registerEditPanel(getLifecycleOwner(), this.searchViewModel);
        pcb.a.a.b(r3.getActivity()).c(this.searchViewModel);
        this.searchViewModel.setDelegate(new d(this));
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r3, t r4) {
        pcb.a.a.b(r3.getActivity()).a(this.searchViewModel);
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r3, r4);
        this.searchViewModel.onDetachFromUI();
    }

    @Override // com.bytedance.ee.bear.document.search.BaseSearchPlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.document.search.BaseSearchPlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }
}
