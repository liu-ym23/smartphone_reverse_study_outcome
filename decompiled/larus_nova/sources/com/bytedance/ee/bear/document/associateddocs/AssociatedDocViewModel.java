package com.bytedance.ee.bear.document.associateddocs;

import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.associated.QuickLaunchBarItemType;
import com.bytedance.ee.bear.document.associateddocs.bean.AppUrlAssociatedDocResult;
import com.bytedance.ee.bear.document.associateddocs.bean.AssociatedCcmPluginInfo;
import com.bytedance.ee.bear.document.associateddocs.bean.AssociatedPluginsInfo;
import com.bytedance.ee.bear.domain.BearUrl;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.utils.SingleLiveEvent;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007J\u0006\u0010\u0012\u001a\u00020\u000eJ\u001e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018J8\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000e2\u0018\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u001c0\u001b2\u0006\u0010\u0017\u001a\u00020\u0018J\u001e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\nJ.\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u000e2\b\u0010\"\u001a\u0004\u0018\u00010#J\u001e\u0010$\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\nJ\u0006\u0010%\u001a\u00020\u0010J\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/document/associateddocs/AssociatedDocViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "associatedDocNetExecutor", "Lcom/bytedance/ee/bear/document/associateddocs/AssociatedDocNetExecutor;", "resultBaseInfo", "Lcom/ss/android/lark/widget/utils/SingleLiveEvent;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "quickLaunchBarItemInfoCallback", "Lcom/bytedance/ee/bear/document/associated/IDocQuickLaunchBarItemInfoCallback;", "associatedAnalytic", "Lcom/bytedance/ee/bear/document/associateddocs/analytic/AssociatedAnalytic;", "urlMetaId", "", "setAssociatedAnalytic", "", "getAssociatedDoc", "getUrlMetaId", "createAndAssociatedDoc", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "appUrl", "callback", "Lcom/bytedance/ee/bear/document/associateddocs/AssociatedDocNetExecutor$AssociateDocEventCallback;", "associatedExistingDoc", "docs", "", "Lkotlin/Pair;", "checkAppUrlAssociatedDocEnable", "reportCcmApplicationDocsPluginView", "url", "showType", "urlId", "bearUrl", "Lcom/bytedance/ee/bear/domain/BearUrl;", "getAppUrlAssociatedDoc", "onQuickLaunchBarItemClick", "getQuickLaunchBarItemShowOnBoarding", "", "refreshQuickLaunchBarItemInfo", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssociatedDocViewModel extends ViewModel {
    private static final String ASSOCIATED_ONBOARDING_SHOW = "associated_onboarding_show";
    public static final a Companion = null;
    private static final String TAG = "AssociatedDocViewModel";
    private g05.a associatedAnalytic;
    private final com.bytedance.ee.bear.document.associateddocs.a associatedDocNetExecutor;
    private e05.b quickLaunchBarItemInfoCallback;
    private final SingleLiveEvent<SearchBaseInfo> resultBaseInfo;
    private String urlMetaId;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements com.bytedance.ee.bear.document.associateddocs.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e05.b f218982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AssociatedDocViewModel f218983b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f218984c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ NetService f218985d;

        @Override // com.bytedance.ee.bear.document.associateddocs.a.b
        public final void a(AssociatedPluginsInfo r100) {
            if (r100 == null) goto L5;
            AssociatedCcmPluginInfo r101 = r100.getCcmPlugin();
        L6:
            if (r101 != null) goto L8;
        L14:
            ((cmb.a) this.f218982a).a(null);
            return;
        L8:
            if (r100.getCcmPlugin().getVisible() == false) goto L14;
            AssociatedDocViewModel.access$setUrlMetaId$p(this.f218983b, r100.getUrlMetaId());
            if (Intrinsics.areEqual(r100.getCcmPlugin().getReferenceExist(), Boolean.FALSE) == false) goto L13;
            ((cmb.a) this.f218982a).a(new e05.c(QuickLaunchBarItemType.ADD_ASSOCIATION_DOC, "", this.f218983b.getQuickLaunchBarItemShowOnBoarding()));
            AssociatedDocViewModel r102 = this.f218983b;
            r102.reportCcmApplicationDocsPluginView(this.f218984c, "add_docs", AssociatedDocViewModel.access$getUrlMetaId$p(r102), null);
            return;
        L13:
            this.f218983b.getAppUrlAssociatedDoc(this.f218985d, this.f218984c, this.f218982a);
            return;
        L5:
            r101 = null;
            goto L6
        }

        public b(e05.b r100, AssociatedDocViewModel r101, String r102, NetService r103) {
            this.f218982a = r100;
            this.f218983b = r101;
            this.f218984c = r102;
            this.f218985d = r103;
        }
    }

    public static final class c implements com.bytedance.ee.bear.document.associateddocs.a.InterfaceC3111a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e05.b f218986a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AssociatedDocViewModel f218987b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f218988c;

        @Override // com.bytedance.ee.bear.document.associateddocs.a.InterfaceC3111a
        public final void a(AppUrlAssociatedDocResult r100) {
            if (r100 != null) goto L4;
            ((cmb.a) this.f218986a).a(null);
        L4:
            if (r100 == null) goto L7;
            e05.b r101 = this.f218986a;
            AssociatedDocViewModel r102 = this.f218987b;
            String r103 = this.f218988c;
            String r104 = r100.getReferences().get(0).getUrl();
            cmb.a r105 = (cmb.a) r101;
            r105.a(new e05.c(QuickLaunchBarItemType.ASSOCIATED_DOC, r104, r102.getQuickLaunchBarItemShowOnBoarding()));
            BearUrl r106 = ((t45.c) e0c.k.a(LarkContext.getApplication(), t45.c.class)).Z(r104);
            r102.reportCcmApplicationDocsPluginView(r103, "view_docs", AssociatedDocViewModel.access$getUrlMetaId$p(r102), r106);
            return;
        }

        public c(e05.b r100, AssociatedDocViewModel r101, String r102) {
            this.f218986a = r100;
            this.f218987b = r101;
            this.f218988c = r102;
        }
    }

    static {
        Companion = new a();
    }

    public final boolean getQuickLaunchBarItemShowOnBoarding() {
        return ay4.b.d("document", 6).getBoolean(ASSOCIATED_ONBOARDING_SHOW, true);
    }

    public final void onQuickLaunchBarItemClick() {
        ay4.b.d("document", 6).putBoolean(ASSOCIATED_ONBOARDING_SHOW, false);
    }

    public AssociatedDocViewModel() {
        this.associatedDocNetExecutor = new com.bytedance.ee.bear.document.associateddocs.a();
        this.resultBaseInfo = new SingleLiveEvent();
        this.urlMetaId = "";
    }

    public final SingleLiveEvent<SearchBaseInfo> getAssociatedDoc() {
        return this.resultBaseInfo;
    }

    public final String getUrlMetaId() {
        return this.urlMetaId;
    }

    public static final /* synthetic */ String access$getUrlMetaId$p(AssociatedDocViewModel r100) {
        return r100.urlMetaId;
    }

    public final void refreshQuickLaunchBarItemInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        e05.c r101 = new e05.c(QuickLaunchBarItemType.ASSOCIATED_DOC, r100, getQuickLaunchBarItemShowOnBoarding());
        e05.b r102 = this.quickLaunchBarItemInfoCallback;
        if (r102 == null) goto L6;
        ((cmb.a) r102).a(r101);
        return;
    }

    public final void setAssociatedAnalytic(g05.a r100) {
        this.associatedAnalytic = r100;
    }

    public static final /* synthetic */ void access$setUrlMetaId$p(AssociatedDocViewModel r100, String r101) {
        r100.urlMetaId = r101;
    }

    public final void checkAppUrlAssociatedDocEnable(NetService r100, String r101, e05.b r102) {
        Intrinsics.checkNotNullParameter(r100, "netService");
        Intrinsics.checkNotNullParameter(r101, "appUrl");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.quickLaunchBarItemInfoCallback = r102;
        com.bytedance.ee.bear.document.associateddocs.a r103 = this.associatedDocNetExecutor;
        b r104 = new b(r102, this, r101, r100);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "netService");
        Intrinsics.checkNotNullParameter(r101, "appUrl");
        Intrinsics.checkNotNullParameter(r104, "callback");
        NetService.d r105 = r100.Vc(new com.bytedance.ee.bear.document.associateddocs.a.c());
        NetService.e r106 = new NetService.f("/space/api/plugins/");
        r106.f216906c = 2;
        r106.b("app_url", r101);
        r106.b("type", "2");
        HashMap r107 = new HashMap();
        r107.put("Content-Type", "application/x-www-form-urlencoded");
        r106.c(r107);
        r105.a(r106).subscribe(new d(r104), new e(r104));
    }

    public final void createAndAssociatedDoc(NetService r100, String r101, com.bytedance.ee.bear.document.associateddocs.a.e r102) {
        Intrinsics.checkNotNullParameter(r100, "netService");
        Intrinsics.checkNotNullParameter(r101, "appUrl");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.associatedDocNetExecutor.getClass();
        Intrinsics.checkNotNullParameter(r100, "netService");
        Intrinsics.checkNotNullParameter(r101, "appUrl");
        Intrinsics.checkNotNullParameter(r102, "callback");
        NetService.d r103 = r100.Vc(new com.bytedance.ee.bear.document.associateddocs.a.h());
        int r104 = sbb.e.f541304o.f541317b;
        NetService.e r105 = new NetService.f("/space/api/explorer/v2/create/object/");
        r105.f216906c = 1;
        HashMap r106 = new HashMap();
        r106.put("source", "0");
        r106.put("type", String.valueOf(r104));
        JSONObject r107 = new JSONObject();
        r107.put("app_url", r101);
        r106.put("ext_info", r107.toString());
        r105.d(r106);
        HashMap r108 = new HashMap();
        r108.put("Content-Type", "application/x-www-form-urlencoded");
        r105.c(r108);
        r103.a(r105).observeOn(fo5.d.a()).subscribeOn(fo5.d.d()).subscribe(new f(r102), new g(r102));
    }

    public final void getAppUrlAssociatedDoc(NetService r100, String r101, e05.b r102) {
        Intrinsics.checkNotNullParameter(r100, "netService");
        Intrinsics.checkNotNullParameter(r101, "appUrl");
        Intrinsics.checkNotNullParameter(r102, "callback");
        com.bytedance.ee.bear.document.associateddocs.a r103 = this.associatedDocNetExecutor;
        c r104 = new c(r102, this, r101);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "netService");
        Intrinsics.checkNotNullParameter(r101, "appUrl");
        Intrinsics.checkNotNullParameter(r104, "callback");
        NetService.d r105 = r100.Vc(new com.bytedance.ee.bear.document.associateddocs.a.d());
        NetService.e r106 = new NetService.f("/space/api/app/references/");
        r106.f216906c = 2;
        r106.b("app_url", r101);
        HashMap r107 = new HashMap();
        r107.put("Content-Type", "application/x-www-form-urlencoded");
        r106.c(r107);
        r105.a(r106).subscribe(new j(r104), new k(r104));
    }

    public final void associatedExistingDoc(NetService r100, String r101, List<Pair<String, String>> r102, com.bytedance.ee.bear.document.associateddocs.a.e r103) {
        Intrinsics.checkNotNullParameter(r100, "netService");
        Intrinsics.checkNotNullParameter(r101, "appUrl");
        Intrinsics.checkNotNullParameter(r102, "docs");
        Intrinsics.checkNotNullParameter(r103, "callback");
        this.associatedDocNetExecutor.getClass();
        Intrinsics.checkNotNullParameter(r100, "netService");
        Intrinsics.checkNotNullParameter(r101, "appUrl");
        Intrinsics.checkNotNullParameter(r102, "docs");
        Intrinsics.checkNotNullParameter(r103, "callback");
        r100.Vc(new com.bytedance.ee.bear.document.associateddocs.a.f()).a(com.bytedance.ee.bear.document.associateddocs.a.a(r101, r102, "/space/api/references/create/")).observeOn(fo5.d.a()).subscribeOn(fo5.d.d()).subscribe(new com.bytedance.ee.bear.document.associateddocs.b(r103), new com.bytedance.ee.bear.document.associateddocs.c(r103));
    }

    public final void reportCcmApplicationDocsPluginView(String r100, String r101, String r102, BearUrl r103) {
        HashMap r104 = new HashMap();
        r104.put("plugin_type", "docs");
        r104.put("show_type", r101);
        r104.put("url_id", r102);
        if (r100 == null) goto L6;
        String r105 = f05.b.a(r100);
        if (r105 == null) goto L6;
    L7:
        r104.put("biz_type", r105);
        r104.put("op_app_id", "");
        Pattern r106 = com.larksuite.framework.utils.g.f285989a;
        if (r103 == null) goto L10;
        String r107 = r103.f222561b;
    L11:
        String r108 = com.larksuite.framework.utils.g.a(r107);
        if (r108 != null) goto L14;
        r108 = "";
    L14:
        r104.put("obj_file_id", r108);
        if (r103 == null) goto L18;
        String r109 = r103.f222560a;
        if (r109 == null) goto L18;
    L19:
        r104.put("obj_file_type", r109);
        r104.put("obj_file_permission_type", "");
        g05.a r110 = this.associatedAnalytic;
        if (r110 == null) goto L23;
        Intrinsics.checkNotNullParameter(r104, "evenParams");
        r110.a("ccm_application_docs_plugin_view", r104);
        return;
    L23:
        return;
    L18:
        r109 = "";
        goto L19
    L10:
        r107 = null;
    L6:
        r105 = "";
        goto L7
    }
}
