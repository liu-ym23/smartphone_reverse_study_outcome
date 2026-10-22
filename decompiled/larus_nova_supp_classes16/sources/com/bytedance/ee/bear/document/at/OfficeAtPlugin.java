package com.bytedance.ee.bear.document.at;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.atfinder.MentionModel;
import com.bytedance.ee.bear.bean.MentionPanelType;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.document.authors.Author;
import com.bytedance.ee.bear.document.authors.OfficeAuthorsPlugin;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.edit.component.document.at.AtFinderHandler;
import com.bytedance.ee.bear.edit.component.document.at.AtPanelFragment;
import com.bytedance.ee.bear.edit.component.document.at.AtPanelViewModel;
import com.bytedance.ee.bear.utils.AtUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfficeAtPlugin extends DocumentPluginV3 {
    private static final String BIZ_COMMON_PARAMS = "bizCommonParams";
    private static final String TAG = "OfficeAtPlugin";
    private Observer<Boolean> activeObserver;
    private com.bytedance.ee.bear.contract.d analyticService;
    private final AtFinderHandler atFinderHandler;
    private AtPanelViewModel atViewModel;
    private ArrayList<String> authorIds;
    private EditPanelsManager editPanelsManager;
    private boolean isOwner;
    private String ownerId;

    public class a implements AtFinderHandler.b {
        public final /* synthetic */ OfficeAtPlugin a;

        @Override // com.bytedance.ee.bear.edit.component.document.at.AtFinderHandler.b
        public final void b() {
            OfficeAtPlugin.access$000(this.a).h("bizCommonParams");
        }

        public a(OfficeAtPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.edit.component.document.at.AtFinderHandler.b
        public final void a(String r3, String r4) {
            OfficeAtPlugin.access$000(this.a).j("bizCommonParams", r3, r4);
        }
    }

    public class b extends q {
        public final /* synthetic */ OfficeAtPlugin b;

        public final bo4.c a() {
            ((i0) org.koin.java.a.a(i0.class)).a();
            return new bo4.c(kn4.f.a().e(), kn4.f.a().f());
        }

        public b(OfficeAtPlugin r1) {
            this.b = r1;
        }

        @Override // com.bytedance.ee.bear.document.at.q
        public final List<Disposable> b(MentionModel r3) {
            OfficeAtPlugin r0 = this.b;
            r3.setChatId(OfficeAtPlugin.access$100(r0, r0.getDocumentMetadata().getUrl()));
            r3.setOwnerId(OfficeAtPlugin.access$200(this.b));
            r3.setOwner(OfficeAtPlugin.access$300(this.b));
            r3.setAuthorIds(OfficeAtPlugin.access$400(this.b));
            return super.b(r3);
        }

        @Override // com.bytedance.ee.bear.document.at.q
        public final void c(ArrayList<ln4.m> r12) {
            com.bytedance.ee.bear.atfinder.f r0 = OfficeAtPlugin.access$500(this.b);
            ln4.m r8 = new ln4.m(2131231737, OfficeAtPlugin.access$600(this.b).getString(2131887572), Arrays.asList(com.bytedance.ee.bear.utils.a.c), MentionPanelType.user, r0, 2131889125);
            ln4.m r10 = new ln4.m(2131231737, OfficeAtPlugin.access$700(this.b).getString(2131887569), AtUtils.c(), MentionPanelType.file, r0, 2131889122);
            r12.add(r8);
            r12.add(r10);
            String r1 = this.b.getDocumentMetadata().getBearUrl().a;
            if (sbb.e.k.getType().equals(r1) == true) goto L6;
            r12.add(new ln4.m(2131231737, OfficeAtPlugin.access$800(this.b).getString(2131887570), Arrays.asList(com.bytedance.ee.bear.utils.a.d), MentionPanelType.chat, r0, 2131889124));
            return;
        }
    }

    public static /* synthetic */ void a(OfficeAtPlugin r0, Boolean r1) {
        r0.lambda$onAttachToUIContainer$2(r1);
    }

    public static /* synthetic */ void c(OfficeAtPlugin r0, DocumentInfo r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    public static /* synthetic */ void d(OfficeAtPlugin r0, List r1) {
        r0.lambda$onAttachToHost$1(r1);
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private com.bytedance.ee.bear.atfinder.e createMentionDelegate() {
        return new b(this);
    }

    private com.bytedance.ee.bear.contract.d getAnalyticService() {
        if (this.analyticService != null) goto L6;
        this.analyticService = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
    L6:
        return this.analyticService;
    }

    public OfficeAtPlugin() {
        AtFinderHandler r0 = new AtFinderHandler();
        this.atFinderHandler = r0;
        this.authorIds = new ArrayList();
        r0.b = new a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void ensureAtFragment() {
        if (getUIContainer().l(this) != null) goto L6;
        Fragment r0 = instantiateFragment(AtPanelFragment.class);
        getUIContainer().i(this, r0);
        return;
    }

    private com.bytedance.ee.bear.atfinder.f getMentionSearch() {
        return kn4.f.a().b();
    }

    public static /* synthetic */ com.bytedance.ee.bear.contract.d access$000(OfficeAtPlugin r0) {
        return r0.getAnalyticService();
    }

    public static /* synthetic */ String access$200(OfficeAtPlugin r0) {
        return r0.ownerId;
    }

    public static /* synthetic */ boolean access$300(OfficeAtPlugin r0) {
        return r0.isOwner;
    }

    public static /* synthetic */ ArrayList access$400(OfficeAtPlugin r0) {
        return r0.authorIds;
    }

    public static /* synthetic */ com.bytedance.ee.bear.atfinder.f access$500(OfficeAtPlugin r0) {
        return r0.getMentionSearch();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Context access$600(OfficeAtPlugin r0) {
        return r0.getContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Context access$700(OfficeAtPlugin r0) {
        return r0.getContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Context access$800(OfficeAtPlugin r0) {
        return r0.getContext();
    }

    private String getChatId(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L11;
        return "";
    L11:
        String r4 = UriProtector.getQueryParameter(UriProtector.parse(r3), "chat_id");     // Catch: Throwable -> L10
        if (r4 != null) goto L9;
        return "";
    L9:
        return r4;
    L14:
        return "";
    }

    private /* synthetic */ void lambda$onAttachToHost$0(DocumentInfo r2) {
        this.ownerId = r2.getOwnerUid();
        this.isOwner = r2.isOwner();
        tt5.a.h(TAG, "documentInfo updated. ownerId: " + this.ownerId + ", isOwner: " + this.isOwner);
    }

    private /* synthetic */ void lambda$onAttachToHost$1(List r5) {
        ArrayList<String> r0 = new ArrayList();
        Iterator r1 = r5.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Author r2 = (Author) r1.next();
        if (r2.getId() == null) goto L4;
        r0.add(r2.getId());
        goto L4
    L8:
        this.authorIds = r0;
        tt5.a.h(TAG, "authors updated. size: " + r5.size());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ void lambda$onAttachToUIContainer$2(Boolean r2) {
        if (Boolean.TRUE.equals(r2) == false) goto L5;
        ensureAtFragment();
        return;
    L5:
        getUIContainer().d(this);
    }

    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        r3.put("biz.util.atfinder", this.atFinderHandler);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(ChameleonPluginHost r5) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r5);
    L8:
        th = move-exception;
        tt5.a.e(TAG, "AtModuleProvider init failed", th, false);
    L10:
        AtPanelViewModel r0 = (AtPanelViewModel) viewModel(AtPanelViewModel.class);
        this.atViewModel = r0;
        AtFinderHandler r1 = this.atFinderHandler;
        r1.c = r0;
        r0.setDataCallback(r1.d);
        this.editPanelsManager = h35.a.a(r5);
        this.editPanelsManager.needSetPanelHeight(!"mindnote".equals(getDocumentMetadata().getDocumentType()));
        this.atViewModel.setEditPanelsManager(this.editPanelsManager);
        w05.b r6 = (w05.b) r5.getHostAbilityOrNull(w05.b.class);
        if (r6 == null) goto L16;
        if (r6.getDocumentInfoProvider() == null) goto L16;
        r6.getDocumentInfoProvider().j().observe(getLifecycleOwner(), new v(this));
    L16:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mention.owner_recommend_optimize.mobile") == false) goto L23;
        OfficeAuthorsPlugin r7 = (OfficeAuthorsPlugin) findPlugin(OfficeAuthorsPlugin.class);
        if (r7 == null) goto L24;
        r7.getAuthorsLiveData().observe(getLifecycleOwner(), new w(this));
        return;
    L24:
        return;
    L23:
        return;
    L4:
        if (getContext() == null) goto L6;
        m.a = getContext().getApplicationContext();     // Catch: Throwable -> L8
    L6:
        m.a();     // Catch: Throwable -> L8
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromHost(ChameleonPluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r2);
        getAnalyticService().c("bizCommonParams");
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }

    public static /* synthetic */ String access$100(OfficeAtPlugin r0, String r1) {
        return r0.getChatId(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToUIContainer(ChameleonPluginHost r3, com.bytedance.ee.bear.browser.plugin.t r4) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r3, r4);
        if (this.activeObserver != null) goto L5;
        this.activeObserver = new u(this);
        this.atViewModel.getActive().observe(getLifecycleOwner(), this.activeObserver);
    L5:
        this.editPanelsManager.registerEditPanel(getLifecycleOwner(), this.atViewModel);
        if (this.atViewModel.getMentionDelegate() != null) goto L8;
        this.atViewModel.setMentionDelegate(createMentionDelegate());
    L8:
        pcb.a.a.b(r3.getActivity()).c(this.atViewModel);
        if (getTitleBar() != null) goto L11;
        return;
    L11:
        if (getTitleBar().getTitleBarLayout() == null) goto L15;
        int[] r5 = new int[2];
        getTitleBar().getTitleBarLayout().getLocationInWindow(r5);
        this.atViewModel.setTitleBarLocation(r5[1]);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromUIContainer(ChameleonPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r1, r2);
        pcb.a.a.b(r1.getActivity()).a(this.atViewModel);
        this.atViewModel.onDetachFromUI();
        this.atViewModel.setActive(false);
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }
}
