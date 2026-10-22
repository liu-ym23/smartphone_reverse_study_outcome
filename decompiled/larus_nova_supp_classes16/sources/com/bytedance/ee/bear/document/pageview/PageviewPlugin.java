package com.bytedance.ee.bear.document.pageview;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.PageviewResult;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.more.b;
import com.bytedance.ee.bear.more.export.PageviewUIHolder;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import e35.c;
import e35.d;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import jg5.e;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PageviewPlugin extends DocumentPlugin implements p {
    private static final String TAG = "PageviewPlugin";
    private Observer<PageviewResult> mPageviewResultObserver;

    public class a implements i<PageviewResult> {
        public final /* synthetic */ PageviewPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(PageviewPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            PageWordViewModel r3 = PageviewPlugin.access$100(this.a);
            r3.setPageWord((PageviewResult) r1);
        }
    }

    public static /* synthetic */ void c(PageviewPlugin r0, PageviewResult r1) {
        r0.lambda$onAttachToUIContainer$0(r1);
    }

    public static /* synthetic */ void d(PageviewPlugin r0, BaseUnspecifiedOrientationPlugin r1) {
        r0.lambda$showDocPageview$1(r1);
    }

    public static /* synthetic */ void e(PageviewPlugin r0, BaseUnspecifiedOrientationPlugin r1) {
        r0.lambda$showSheetOrBitablePageview$2(r1);
    }

    public static /* synthetic */ void f(PageviewPlugin r0, BaseUnspecifiedOrientationPlugin r1) {
        r0.lambda$showMindNotePageview$3(r1);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private PageWordViewModel getPageWordViewModel() {
        return (PageWordViewModel) ViewModelProviders.of(getActivity()).get(PageWordViewModel.class);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.document.orientation.p
    public boolean shouldDisableLandscape() {
        return super.shouldDisableLandscape();
    }

    public PageviewPlugin() {
    }

    public static /* synthetic */ PageWordViewModel access$100(PageviewPlugin r0) {
        return r0.getPageWordViewModel();
    }

    private String format(int r4) {
        return new DecimalFormat("###,###,###").format(r4);
    }

    private /* synthetic */ void lambda$onAttachToUIContainer$0(PageviewResult r1) {
        if (r1 == null) goto L5;
        setPageviewResult(r1);
        return;
    }

    private /* synthetic */ void lambda$showDocPageview$1(BaseUnspecifiedOrientationPlugin r1) {
        if (r1 == null) goto L5;
        r1.onOrientationSupportPanelDismiss(this);
        return;
    }

    private /* synthetic */ void lambda$showMindNotePageview$3(BaseUnspecifiedOrientationPlugin r1) {
        if (r1 == null) goto L5;
        r1.onOrientationSupportPanelDismiss(this);
        return;
    }

    private /* synthetic */ void lambda$showSheetOrBitablePageview$2(BaseUnspecifiedOrientationPlugin r1) {
        if (r1 == null) goto L5;
        r1.onOrientationSupportPanelDismiss(this);
        return;
    }

    private void setPageviewResult(PageviewResult r3) {
        PageviewUIHolder r0 = new PageviewUIHolder();
        r0.d = format(r3.getWordCount());
        r0.e = format(r3.getCharacterCount());
        ((b) org.koin.java.a.a(b.class)).j(r0);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        r3.put("biz.content.setFileInfo", new a(this));
    }

    public void showPageview(Fragment r11) {
        BaseUnspecifiedOrientationPlugin r5 = (BaseUnspecifiedOrientationPlugin) findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (r5 == null) goto L5;
        r5.onOrientationSupportPanelShowing(this);
    L5:
        DocumentInfo r0 = getDocViewModel().getDocumentInfoData();
        String r1 = getDocViewModel().getDocumentType();
        int r2 = getDocViewModel().getDocumentTypeValue();
        String r3 = getDocViewModel().getToken();
        boolean r4 = false;
        if (r0 == null) goto L16;
        boolean r6 = r0.getVersion().isDocV2();
        if (r0.getDocPermission().a.isFullAccess() == false) goto L10;
    L11:
        r4 = true;
    L12:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (e.a.a.g() == false) goto L15;
        r4 = getDocViewModel().getPermissionResponseWithUserPermission(BizDomain.FileBizDomainCCM, "VIEW_DOC_HISTORY").getAllow();
    L15:
        String r8 = r0.getTitle();
        boolean r7 = r4;
    L18:
        if (TextUtils.isEmpty(r1) == false) goto L20;
    L45:
        tt5.a.d(TAG, "objType or token is null");
        return;
    L20:
        if (TextUtils.isEmpty(r3) == true) goto L45;
        if (r0 == null) goto L26;
        IDocPublicPermission.ConfigInfo r9 = r0.getDocPermission().b.getConfigInfo();
        if (r9 == null) goto L26;
        HashMap<String, Serializable> r10 = new HashMap();
        r10.put("leader_search_number", Integer.valueOf(r9.getLeaderSearchNumber()));
        HashMap<String, Serializable> r12 = r10;
    L28:
        if (sbb.e.o.getType().equals(r1) == false) goto L30;
    L43:
        showDocPageview(r2, r3, r6, r5, r7, r8, r11, r12);
        return;
    L30:
        if (sbb.e.g.getType().equals(r1) == true) goto L43;
        if (sbb.e.h.getType().equals(r1) == false) goto L35;
    L42:
        showSheetOrBitablePageview(r2, r3, r5, r6, r7, r8, r12);
        return;
    L35:
        if (sbb.e.i.getType().equals(r1) == true) goto L42;
        if (sbb.e.m.getType().equals(r1) == true) goto L42;
        if (sbb.e.k.getType().equals(r1) == false) goto L47;
        showMindNotePageview(r2, r3, r6, r5, r7, r8, r12);
        return;
    L47:
        return;
    L26:
        r12 = null;
        goto L28
    L10:
        if (r0.getDocPermission().a.isSinglePageFullAccess() == false) goto L12;
    L16:
        r8 = "";
        r6 = false;
        r7 = false;
        goto L18
    }

    public void onAttachToUIContainer(DocumentPluginHost r2, t r3) {
        super.onAttachToUIContainer(r2, r3);
        if (this.mPageviewResultObserver != null) goto L6;
        this.mPageviewResultObserver = new e35.e(this);
        getPageWordViewModel().getPageWordResult().observe(getLifecycleOwner(), this.mPageviewResultObserver);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    private void showMindNotePageview(int r16, String r17, boolean r18, final BaseUnspecifiedOrientationPlugin r19, boolean r20, String r21, HashMap<String, Serializable> r22) {
        PageviewUIHolder r7 = new PageviewUIHolder();
        r7.f = false;
        ((b) org.koin.java.a.a(b.class)).k(new com.bytedance.ee.bear.more.p(getActivity(), r16, r17, r18, r20, r21, r7, null, false, r22, new e35.b(this, r19)));
    }

    private void showSheetOrBitablePageview(int r16, String r17, final BaseUnspecifiedOrientationPlugin r18, boolean r19, boolean r20, String r21, HashMap<String, Serializable> r22) {
        PageviewUIHolder r8 = new PageviewUIHolder();
        r8.f = false;
        if (r16 == 3) goto L7;
        if (r16 == 30) goto L7;
    L9:
        ((b) org.koin.java.a.a(b.class)).k(new com.bytedance.ee.bear.more.p(getActivity(), r16, r17, r19, r20, r21, r8, null, false, r22, new c(this, r18)));
        return;
    L7:
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.storage.edit_limit_popup") == false) goto L9;
        r8.a = getString(2131889041);
        goto L9
    }

    private void showDocPageview(int r16, String r17, boolean r18, final BaseUnspecifiedOrientationPlugin r19, boolean r20, String r21, Fragment r22, HashMap<String, Serializable> r23) {
        PageviewResult r1 = (PageviewResult) getPageWordViewModel().getPageWordResult().getValue();
        PageviewUIHolder r9 = new PageviewUIHolder();
        r9.f = true;
        r9.a = getString(2131889041);
        r9.b = getString(2131887699);
        r9.c = getString(2131887655);
        if (r1 == null) goto L5;
        r9.d = format(r1.getWordCount());
        r9.e = format(r1.getCharacterCount());
    L5:
        ((b) org.koin.java.a.a(b.class)).k(new com.bytedance.ee.bear.more.p(getActivity(), r16, r17, r18, r20, r21, r9, r22, true, r23, new d(this, r19)));
    }
}
