package com.bytedance.ee.bear.document.associateddocs;

import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.associated.QuickLaunchBarItemType;
import com.bytedance.ee.bear.document.associateddocs.bean.AppUrlAssociatedDocResult;
import com.bytedance.ee.bear.document.associateddocs.bean.AssociatedCcmPluginInfo;
import com.bytedance.ee.bear.document.associateddocs.bean.AssociatedPluginsInfo;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        public final /* synthetic */ e05.b a;
        public final /* synthetic */ AssociatedDocViewModel b;
        public final /* synthetic */ String c;
        public final /* synthetic */ NetService d;

        @Override // com.bytedance.ee.bear.document.associateddocs.a.b
        public final void a(AssociatedPluginsInfo r6) {
            if (r6 == null) goto L5;
            AssociatedCcmPluginInfo r1 = r6.getCcmPlugin();
        L6:
            if (r1 != null) goto L8;
        L14:
            this.a.a(null);
            return;
        L8:
            if (r6.getCcmPlugin().getVisible() == false) goto L14;
            AssociatedDocViewModel.access$setUrlMetaId$p(this.b, r6.getUrlMetaId());
            if (Intrinsics.areEqual(r6.getCcmPlugin().getReferenceExist(), Boolean.FALSE) == false) goto L13;
            this.a.a(new e05.c(QuickLaunchBarItemType.ADD_ASSOCIATION_DOC, "", this.b.getQuickLaunchBarItemShowOnBoarding()));
            AssociatedDocViewModel r7 = this.b;
            r7.reportCcmApplicationDocsPluginView(this.c, "add_docs", AssociatedDocViewModel.access$getUrlMetaId$p(r7), null);
            return;
        L13:
            this.b.getAppUrlAssociatedDoc(this.d, this.c, this.a);
            return;
        L5:
            r1 = null;
            goto L6
        }

        public b(e05.b r1, AssociatedDocViewModel r2, String r3, NetService r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class c implements com.bytedance.ee.bear.document.associateddocs.a.InterfaceC0055a {
        public final /* synthetic */ e05.b a;
        public final /* synthetic */ AssociatedDocViewModel b;
        public final /* synthetic */ String c;

        @Override // com.bytedance.ee.bear.document.associateddocs.a.InterfaceC0055a
        public final void a(AppUrlAssociatedDocResult r7) {
            if (r7 != null) goto L4;
            this.a.a(null);
        L4:
            if (r7 == null) goto L7;
            cmb.a r0 = this.a;
            AssociatedDocViewModel r1 = this.b;
            String r2 = this.c;
            String r8 = r7.getReferences().get(0).getUrl();
            cmb.a r3 = r0;
            r3.a(new e05.c(QuickLaunchBarItemType.ASSOCIATED_DOC, r8, r1.getQuickLaunchBarItemShowOnBoarding()));
            BearUrl r9 = ((t45.c) e0c.k.a(LarkContext.getApplication(), t45.c.class)).Z(r8);
            r1.reportCcmApplicationDocsPluginView(r2, "view_docs", AssociatedDocViewModel.access$getUrlMetaId$p(r1), r9);
            return;
        }

        public c(e05.b r1, AssociatedDocViewModel r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
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

    public static final /* synthetic */ String access$getUrlMetaId$p(AssociatedDocViewModel r0) {
        return r0.urlMetaId;
    }

    public final void refreshQuickLaunchBarItemInfo(String r4) {
        Intrinsics.checkNotNullParameter(r4, "url");
        e05.c r0 = new e05.c(QuickLaunchBarItemType.ASSOCIATED_DOC, r4, getQuickLaunchBarItemShowOnBoarding());
        cmb.a r5 = this.quickLaunchBarItemInfoCallback;
        if (r5 == null) goto L6;
        r5.a(r0);
        return;
    }

    public final void setAssociatedAnalytic(g05.a r1) {
        this.associatedAnalytic = r1;
    }

    public static final /* synthetic */ void access$setUrlMetaId$p(AssociatedDocViewModel r0, String r1) {
        r0.urlMetaId = r1;
    }

    public final void checkAppUrlAssociatedDocEnable(NetService r6, String r7, e05.b r8) {
        Intrinsics.checkNotNullParameter(r6, "netService");
        Intrinsics.checkNotNullParameter(r7, "appUrl");
        Intrinsics.checkNotNullParameter(r8, "callback");
        this.quickLaunchBarItemInfoCallback = r8;
        com.bytedance.ee.bear.document.associateddocs.a r3 = this.associatedDocNetExecutor;
        b r4 = new b(r8, this, r7, r6);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r6, "netService");
        Intrinsics.checkNotNullParameter(r7, "appUrl");
        Intrinsics.checkNotNullParameter(r4, "callback");
        NetService.d r9 = r6.Vc(new com.bytedance.ee.bear.document.associateddocs.a.c());
        NetService.e r10 = new NetService.f("/space/api/plugins/");
        r10.c = 2;
        r10.b("app_url", r7);
        r10.b("type", "2");
        HashMap r11 = new HashMap();
        r11.put("Content-Type", "application/x-www-form-urlencoded");
        r10.c(r11);
        r9.a(r10).subscribe(new d(r4), new e(r4));
    }

    public final void createAndAssociatedDoc(NetService r6, String r7, com.bytedance.ee.bear.document.associateddocs.a.e r8) {
        Intrinsics.checkNotNullParameter(r6, "netService");
        Intrinsics.checkNotNullParameter(r7, "appUrl");
        Intrinsics.checkNotNullParameter(r8, "callback");
        this.associatedDocNetExecutor.getClass();
        Intrinsics.checkNotNullParameter(r6, "netService");
        Intrinsics.checkNotNullParameter(r7, "appUrl");
        Intrinsics.checkNotNullParameter(r8, "callback");
        NetService.d r9 = r6.Vc(new com.bytedance.ee.bear.document.associateddocs.a.h());
        int r0 = sbb.e.o.b;
        NetService.e r1 = new NetService.f("/space/api/explorer/v2/create/object/");
        r1.c = 1;
        HashMap r2 = new HashMap();
        r2.put("source", DiagramData$RESULT.FAIL);
        r2.put("type", String.valueOf(r0));
        JSONObject r3 = new JSONObject();
        r3.put("app_url", r7);
        r2.put("ext_info", r3.toString());
        r1.d(r2);
        HashMap r10 = new HashMap();
        r10.put("Content-Type", "application/x-www-form-urlencoded");
        r1.c(r10);
        r9.a(r1).observeOn(fo5.d.a()).subscribeOn(fo5.d.d()).subscribe(new f(r8), new g(r8));
    }

    public final void getAppUrlAssociatedDoc(NetService r6, String r7, e05.b r8) {
        Intrinsics.checkNotNullParameter(r6, "netService");
        Intrinsics.checkNotNullParameter(r7, "appUrl");
        Intrinsics.checkNotNullParameter(r8, "callback");
        com.bytedance.ee.bear.document.associateddocs.a r3 = this.associatedDocNetExecutor;
        c r4 = new c(r8, this, r7);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r6, "netService");
        Intrinsics.checkNotNullParameter(r7, "appUrl");
        Intrinsics.checkNotNullParameter(r4, "callback");
        NetService.d r9 = r6.Vc(new com.bytedance.ee.bear.document.associateddocs.a.d());
        NetService.e r10 = new NetService.f("/space/api/app/references/");
        r10.c = 2;
        r10.b("app_url", r7);
        HashMap r11 = new HashMap();
        r11.put("Content-Type", "application/x-www-form-urlencoded");
        r10.c(r11);
        r9.a(r10).subscribe(new j(r4), new k(r4));
    }

    public final void associatedExistingDoc(NetService r6, String r7, List<Pair<String, String>> r8, com.bytedance.ee.bear.document.associateddocs.a.e r9) {
        Intrinsics.checkNotNullParameter(r6, "netService");
        Intrinsics.checkNotNullParameter(r7, "appUrl");
        Intrinsics.checkNotNullParameter(r8, "docs");
        Intrinsics.checkNotNullParameter(r9, "callback");
        this.associatedDocNetExecutor.getClass();
        Intrinsics.checkNotNullParameter(r6, "netService");
        Intrinsics.checkNotNullParameter(r7, "appUrl");
        Intrinsics.checkNotNullParameter(r8, "docs");
        Intrinsics.checkNotNullParameter(r9, "callback");
        r6.Vc(new com.bytedance.ee.bear.document.associateddocs.a.f()).a(com.bytedance.ee.bear.document.associateddocs.a.a(r7, r8, "/space/api/references/create/")).observeOn(fo5.d.a()).subscribeOn(fo5.d.d()).subscribe(new com.bytedance.ee.bear.document.associateddocs.b(r9), new com.bytedance.ee.bear.document.associateddocs.c(r9));
    }

    public final void reportCcmApplicationDocsPluginView(String r4, String r5, String r6, BearUrl r7) {
        HashMap r0 = new HashMap();
        r0.put("plugin_type", "docs");
        r0.put("show_type", r5);
        r0.put("url_id", r6);
        if (r4 == null) goto L6;
        String r8 = f05.b.a(r4);
        if (r8 == null) goto L6;
    L7:
        r0.put("biz_type", r8);
        r0.put("op_app_id", "");
        Pattern r9 = com.larksuite.framework.utils.g.a;
        if (r7 == null) goto L10;
        String r10 = r7.b;
    L11:
        String r11 = com.larksuite.framework.utils.g.a(r10);
        if (r11 != null) goto L14;
        r11 = "";
    L14:
        r0.put("obj_file_id", r11);
        if (r7 == null) goto L18;
        String r12 = r7.a;
        if (r12 == null) goto L18;
    L19:
        r0.put("obj_file_type", r12);
        r0.put("obj_file_permission_type", "");
        g05.a r13 = this.associatedAnalytic;
        if (r13 == null) goto L23;
        Intrinsics.checkNotNullParameter(r0, "evenParams");
        r13.a("ccm_application_docs_plugin_view", r0);
        return;
    L23:
        return;
    L18:
        r12 = "";
        goto L19
    L10:
        r10 = null;
    L6:
        r8 = "";
        goto L7
    }
}
