package com.bytedance.ee.bear.document;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.bear.BitableSubtype;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.view.NestedScrollWebViewV2;
import com.bytedance.ee.bear.container.ContainerFragment;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.FragmentBackPressedHelperKt;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.nova.R;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes16.dex */
public abstract class DocumentFragment extends WebViewFragment {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f218583r = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public i5c.a f218584q;

    public class a implements a7.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocumentFragment f218585a;

        @Override // com.bytedance.ee.bear.document.a7.c
        public final a7.b getActionProvider() {
            return this.f218585a.ha0();
        }

        @Override // com.bytedance.ee.bear.document.a7.c
        public FragmentActivity getActivity() {
            return this.f218585a.getActivity();
        }

        @Override // com.bytedance.ee.bear.document.a7.c
        public final View getRootView() {
            return this.f218585a.getView();
        }

        @Override // com.bytedance.ee.bear.document.a7.c
        public final AppBarLayout getTitleBarLayout() {
            return (AppBarLayout) this.f218585a.getView().findViewById(R.id.doc_appbar_layout);
        }

        static {
        }

        @Override // com.bytedance.ee.bear.document.a7.c
        public final LifecycleOwner getTitleBarLifecycleOwner() {
            return this.f218585a;
        }

        public a(DocumentFragment r100) {
            this.f218585a = r100;
        }
    }

    public a7.b ha0() {
        return null;
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment
    public TitleBar X90() {
        final a7 r100 = new a7(new a(this), H0());
        r100.setMenuIconTint(R.color.facade_selector_icon_n1);
        r100.setLeftClickListener(new t2(this, r100));
        return r100;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final com.bytedance.ee.bear.browser.plugin.o getPluginListProvider() {
        return (com.bytedance.ee.bear.browser.plugin.o) org.koin.java.a.a(com.bytedance.ee.bear.browser.plugin.o.class);
    }

    public final Boolean fa0() {
        DocViewModel r100 = H0();
        String r101 = null;
        if (r100 == null) goto L5;
        BearUrl r102 = r100.getOriginBearUrl();
    L6:
        if (r102 == null) goto L9;
        r101 = com.bytedance.ee.bear.route.c.f(r102);
    L9:
        return Boolean.valueOf(((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).D4(r101));
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.document.WebViewFragment, com.bytedance.ee.bear.browser.WebFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        d25.d.j(null, null);
        d25.d.l(null);
    }

    @Override // com.bytedance.ee.bear.document.WebViewFragment, com.bytedance.ee.bear.browser.WebFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (H0() != null) goto L7;
        tt5.a.k("DocumentFragment", "getDocViewModel is null");
        return;
    L7:
        if (H0().getWikiInfo() == null) goto L9;
        String r100 = H0().getWikiInfo().getObjToken();
    L10:
        d25.d.j(H0().getOriginBearUrl(), r100);
        d25.d.l(H0().getOriginBearUrl());
        FragmentBackPressedHelperKt.a(this, new u2(this));
        return;
    L9:
        r100 = null;
        goto L10
    }

    public DocumentFragment() {
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment
    public com.bytedance.ee.bear.browser.plugin.t Y90(View r100) {
        DocViewModel r101 = H0();
        if (r101 != null) goto L5;
        DocsOpenSource r102 = null;
    L6:
        if (r102 == null) goto L11;
        if (TextUtils.equals(r102.name(), DocsOpenSource.template_preview.name()) == false) goto L11;
        xu5.b.a(getActivity()).a();
    L11:
        return super.Y90(r100);
    L5:
        r102 = r101.getOpenSource();
        goto L6
    }

    @Override // com.bytedance.ee.bear.document.WebViewFragment
    public final void ea0(DocBridgeWebViewV2 r100) {
        super.ea0(r100);
        if (H0().getOriginBearUrl().b() == false) goto L6;
        l7 r101 = y7.f222541j;
        y7.a.f222551a.e(r100);
        return;
    }

    public static v05.a ia0(String r100, String r101) {
        v05.a r102 = (v05.a) ((ConcurrentHashMap) v05.f.f552312a).get(r100);
        if (r102 != null) goto L12;
        if (TextUtils.equals(r100, sbb.e.f541298i.getType()) == false) goto L7;
    L10:
        Class<? extends DocumentFragment> r103 = ((com.bytedance.ee.bear.document.bitable.f) org.koin.java.a.a(com.bytedance.ee.bear.document.bitable.f.class)).d();
        ((com.bytedance.ee.bear.document.bitable.f) org.koin.java.a.a(com.bytedance.ee.bear.document.bitable.f.class)).b();
        r102 = new v05.a(r103, R.layout.bitable_document_fragment);
        goto L12
    L7:
        if (TextUtils.equals(r100, sbb.e.f541299j.getType()) == true) goto L10;
        r102 = new v05.a(UserContainerDocumentFragment.class, R.layout.document_fragment);
    L12:
        if (((bn4.a) org.koin.java.a.a(bn4.a.class)).i(r100, r101) == true) goto L14;
        return r102;
    L14:
        if (ContainerFragment.class.equals(r102.f552304a) == true) goto L18;
        Class<? extends DocumentFragment> r104 = ((com.bytedance.ee.bear.document.bitable.f) org.koin.java.a.a(com.bytedance.ee.bear.document.bitable.f.class)).a();
        ((com.bytedance.ee.bear.document.bitable.f) org.koin.java.a.a(com.bytedance.ee.bear.document.bitable.f.class)).c();
        return new v05.a(r104, R.layout.bitable_app_fragment);
    L18:
        return r102;
    }

    public static BaseFragment ja0(BearUrl r100, Bundle r101) {
        if (AppInfoUtils.f().booleanValue() == false) goto L6;
        tt5.a.h("DocumentFragment", "newInstance DocumentFragment in OfficeSDK");
        iu5.d.a("DocumentFragment", new Throwable("newInstance DocumentFragment in OfficeSDK"));
        return new BaseFragment();
    L6:
        String r102 = r100.f222564e;
        if (r102 != null) goto L9;
        tt5.a.k("DocumentFragment", "newInstance URL empty");
        r102 = "";
    L9:
        if (r101 != null) goto L11;
        r101 = new Bundle();
    L11:
        r101.putString("url", r102);
        r101.putParcelable("bear_url", r100);
        PassportcConvention.f(r101, LarkContext.getApplication());
        BaseFragment r103 = ia0(r100.f222560a, r102).f552304a.newInstance();     // Catch: Exception -> L15
        r103.setArguments(r101);
        return r103;
    L15:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static BaseFragment ka0(String r100, Bundle r101) {
        if (r100 != null) goto L4;
        tt5.a.k("DocumentFragment", "newInstance URL empty");
        r100 = "";
    L4:
        if (r101 != null) goto L7;
        r101 = new Bundle();
    L7:
        return ja0(s45.p.a().Z(s45.p.a().v8(r100)), r101);
    }

    public View ga0(ViewGroup r100, String r101) {
        if (H0() != null) goto L5;
        String r102 = null;
    L6:
        v05.a r103 = ia0(r101, r102);
        return v05.f.a(getContext(), r100, r103);
    L5:
        r102 = H0().getUrl();
        goto L6
    }

    @Override // com.bytedance.ee.bear.document.WebViewFragment, com.bytedance.ee.bear.browser.WebFragment, com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        b5 r102 = this.f218640k;
        if (r102 == null) goto L8;
        if ((r102.getWebView() instanceof NestedScrollWebViewV2) == false) goto L8;
        ((NestedScrollWebViewV2) this.f218640k.getWebView()).setNestedScrollStrategy(null);
    L8:
        if (U90() != null) goto L10;
        return;
    L10:
        if (TextUtils.equals(H0().getOpenSource().name(), DocsOpenSource.base_instruction_docx.name()) == false) goto L14;
        U90().getTitleBarLayout().setVisibility(8);
        return;
    }

    @Override // com.bytedance.ee.bear.document.WebViewFragment, com.bytedance.ee.bear.browser.WebFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        DocViewModel r103 = H0();
        View r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.getDocumentType();
    L6:
        if (r103 == null) goto L17;
        Context r106 = getContext();
        String r107 = r103.getUrl();
        Map<String, Queue<View>> r108 = v05.e.f552307a;
        tt5.a.h("DocumentViewCache", "popViewCache " + r105);
        if (TextUtils.equals(r105, sbb.e.f541298i.getType()) == true) goto L10;
    L12:
        String r109 = null;
    L13:
        Queue r110 = (Queue) ((ConcurrentHashMap) v05.e.f552307a).get(v05.e.c(r105, r109));
        if (r110 == null) goto L16;
        r104 = (View) r110.poll();
    L16:
        v05.e.f(r106.getApplicationContext(), r105);
        goto L17
    L10:
        if (((bn4.a) org.koin.java.a.a(bn4.a.class)).i(r105, r107) == false) goto L12;
        r109 = BitableSubtype.APP.getTypeName();
    L17:
        StringBuilder r111 = new StringBuilder("onCreateView:type:");
        r111.append(r105);
        r111.append(",hasCache? ");
        boolean r112 = true;
        if (r104 == null) goto L20;
        boolean r113 = true;
    L21:
        r111.append(r113);
        tt5.a.h("DocumentFragment", r111.toString());
        if (r104 != null) goto L24;
        r104 = ga0(r101, r105);
    L24:
        StringBuilder r114 = new StringBuilder("onCreateView:type:");
        r114.append(r105);
        r114.append(",hasCache? ");
        if (r104 != null) goto L28;
        r112 = false;
    L28:
        r114.append(r112);
        tt5.a.h("DocumentFragment", r114.toString());
        this.f218584q = (i5c.a) ApiUtils.getApi(i5c.a.class);
        return r104;
    L20:
        r113 = false;
        goto L21
    L5:
        r105 = null;
        goto L6
    }

    public static BaseFragment la0(String r100, String r101, Bundle r102, UserSession r103) {
        if (r101 != null) goto L4;
        tt5.a.k("DocumentFragment", "newInstance URL empty");
        r101 = "";
    L4:
        if (r102 != null) goto L6;
        r102 = new Bundle();
    L6:
        r102.putString("url", r101);
        PassportcConvention.h(r102, r103);
        BaseFragment r104 = ia0(r100, r101).f552304a.newInstance();     // Catch: Exception -> L10
        r104.setArguments(r102);
        return r104;
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
