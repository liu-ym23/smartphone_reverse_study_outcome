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
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class DocumentFragment extends WebViewFragment {
    public static final /* synthetic */ int r = 0;
    public i5c.a q;

    public class a implements a7.c {
        public final /* synthetic */ DocumentFragment a;

        @Override // com.bytedance.ee.bear.document.a7.c
        public final a7.b getActionProvider() {
            return this.a.ha0();
        }

        @Override // com.bytedance.ee.bear.document.a7.c
        public FragmentActivity getActivity() {
            return this.a.getActivity();
        }

        @Override // com.bytedance.ee.bear.document.a7.c
        public final View getRootView() {
            return this.a.getView();
        }

        @Override // com.bytedance.ee.bear.document.a7.c
        public final AppBarLayout getTitleBarLayout() {
            return this.a.getView().findViewById(2131369266);
        }

        static {
        }

        @Override // com.bytedance.ee.bear.document.a7.c
        public final LifecycleOwner getTitleBarLifecycleOwner() {
            return this.a;
        }

        public a(DocumentFragment r1) {
            this.a = r1;
        }
    }

    public a7.b ha0() {
        return null;
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment
    public TitleBar X90() {
        final a7 r1 = new a7(new a(this), H0());
        r1.setMenuIconTint(2131101926);
        r1.setLeftClickListener(new t2(this, r1));
        return r1;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final com.bytedance.ee.bear.browser.plugin.o getPluginListProvider() {
        return (com.bytedance.ee.bear.browser.plugin.o) org.koin.java.a.a(com.bytedance.ee.bear.browser.plugin.o.class);
    }

    public final Boolean fa0() {
        DocViewModel r0 = H0();
        String r1 = null;
        if (r0 == null) goto L5;
        BearUrl r2 = r0.getOriginBearUrl();
    L6:
        if (r2 == null) goto L9;
        r1 = com.bytedance.ee.bear.route.c.f(r2);
    L9:
        return Boolean.valueOf(((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).D4(r1));
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.document.WebViewFragment, com.bytedance.ee.bear.browser.WebFragment
    public final void onPause() {
        super.onPause();
        d25.d.j(null, null);
        d25.d.l(null);
    }

    @Override // com.bytedance.ee.bear.document.WebViewFragment, com.bytedance.ee.bear.browser.WebFragment
    public void onResume() {
        super.onResume();
        if (H0() != null) goto L7;
        tt5.a.k("DocumentFragment", "getDocViewModel is null");
        return;
    L7:
        if (H0().getWikiInfo() == null) goto L9;
        String r0 = H0().getWikiInfo().getObjToken();
    L10:
        d25.d.j(H0().getOriginBearUrl(), r0);
        d25.d.l(H0().getOriginBearUrl());
        FragmentBackPressedHelperKt.a(this, new u2(this));
        return;
    L9:
        r0 = null;
        goto L10
    }

    public DocumentFragment() {
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment
    public com.bytedance.ee.bear.browser.plugin.t Y90(View r3) {
        DocViewModel r0 = H0();
        if (r0 != null) goto L5;
        DocsOpenSource r1 = null;
    L6:
        if (r1 == null) goto L11;
        if (TextUtils.equals(r1.name(), DocsOpenSource.template_preview.name()) == false) goto L11;
        xu5.b.a(getActivity()).a();
    L11:
        return super.Y90(r3);
    L5:
        r1 = r0.getOpenSource();
        goto L6
    }

    @Override // com.bytedance.ee.bear.document.WebViewFragment
    public final void ea0(DocBridgeWebViewV2 r2) {
        super.ea0(r2);
        if (H0().getOriginBearUrl().b() == false) goto L6;
        l7 r0 = y7.j;
        y7.a.a.e(r2);
        return;
    }

    public static v05.a ia0(String r3, String r4) {
        v05.a r0 = (v05.a) ((ConcurrentHashMap) v05.f.a).get(r3);
        if (r0 != null) goto L12;
        if (TextUtils.equals(r3, sbb.e.i.getType()) == false) goto L7;
    L10:
        Class<? extends DocumentFragment> r1 = ((com.bytedance.ee.bear.document.bitable.f) org.koin.java.a.a(com.bytedance.ee.bear.document.bitable.f.class)).d();
        ((com.bytedance.ee.bear.document.bitable.f) org.koin.java.a.a(com.bytedance.ee.bear.document.bitable.f.class)).b();
        r0 = new v05.a(r1, 2131558952);
        goto L12
    L7:
        if (TextUtils.equals(r3, sbb.e.j.getType()) == true) goto L10;
        r0 = new v05.a(UserContainerDocumentFragment.class, 2131560124);
    L12:
        if (((bn4.a) org.koin.java.a.a(bn4.a.class)).i(r3, r4) == true) goto L14;
        return r0;
    L14:
        if (ContainerFragment.class.equals(r0.a) == true) goto L18;
        Class<? extends DocumentFragment> r5 = ((com.bytedance.ee.bear.document.bitable.f) org.koin.java.a.a(com.bytedance.ee.bear.document.bitable.f.class)).a();
        ((com.bytedance.ee.bear.document.bitable.f) org.koin.java.a.a(com.bytedance.ee.bear.document.bitable.f.class)).c();
        return new v05.a(r5, 2131558805);
    L18:
        return r0;
    }

    public static BaseFragment ja0(BearUrl r2, Bundle r3) {
        if (AppInfoUtils.f().booleanValue() == false) goto L6;
        tt5.a.h("DocumentFragment", "newInstance DocumentFragment in OfficeSDK");
        iu5.d.a("DocumentFragment", new Throwable("newInstance DocumentFragment in OfficeSDK"));
        return new BaseFragment();
    L6:
        String r0 = r2.e;
        if (r0 != null) goto L9;
        tt5.a.k("DocumentFragment", "newInstance URL empty");
        r0 = "";
    L9:
        if (r3 != null) goto L11;
        r3 = new Bundle();
    L11:
        r3.putString("url", r0);
        r3.putParcelable("bear_url", r2);
        PassportcConvention.f(r3, LarkContext.getApplication());
        BaseFragment r4 = ia0(r2.a, r0).a.newInstance();     // Catch: Exception -> L15
        r4.setArguments(r3);
        return r4;
    L15:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static BaseFragment ka0(String r2, Bundle r3) {
        if (r2 != null) goto L4;
        tt5.a.k("DocumentFragment", "newInstance URL empty");
        r2 = "";
    L4:
        if (r3 != null) goto L7;
        r3 = new Bundle();
    L7:
        return ja0(s45.p.a().Z(s45.p.a().v8(r2)), r3);
    }

    public View ga0(ViewGroup r2, String r3) {
        if (H0() != null) goto L5;
        String r0 = null;
    L6:
        v05.a r4 = ia0(r3, r0);
        return v05.f.a(getContext(), r2, r4);
    L5:
        r0 = H0().getUrl();
        goto L6
    }

    @Override // com.bytedance.ee.bear.document.WebViewFragment, com.bytedance.ee.bear.browser.WebFragment, com.bytedance.ee.bear.facade.common.BaseFragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        b5 r3 = this.k;
        if (r3 == null) goto L8;
        if ((r3.getWebView() instanceof NestedScrollWebViewV2) == false) goto L8;
        ((NestedScrollWebViewV2) this.k.getWebView()).setNestedScrollStrategy(null);
    L8:
        if (U90() != null) goto L10;
        return;
    L10:
        if (TextUtils.equals(H0().getOpenSource().name(), DocsOpenSource.base_instruction_docx.name()) == false) goto L14;
        U90().getTitleBarLayout().setVisibility(8);
        return;
    }

    @Override // com.bytedance.ee.bear.document.WebViewFragment, com.bytedance.ee.bear.browser.WebFragment
    public View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        DocViewModel r10 = H0();
        View r11 = null;
        if (r10 == null) goto L5;
        String r0 = r10.getDocumentType();
    L6:
        if (r10 == null) goto L17;
        Context r1 = getContext();
        String r12 = r10.getUrl();
        Map<String, Queue<View>> r2 = v05.e.a;
        tt5.a.h("DocumentViewCache", "popViewCache " + r0);
        if (TextUtils.equals(r0, sbb.e.i.getType()) == true) goto L10;
    L12:
        String r13 = null;
    L13:
        Queue r14 = (Queue) ((ConcurrentHashMap) v05.e.a).get(v05.e.c(r0, r13));
        if (r14 == null) goto L16;
        r11 = (View) r14.poll();
    L16:
        v05.e.f(r1.getApplicationContext(), r0);
        goto L17
    L10:
        if (((bn4.a) org.koin.java.a.a(bn4.a.class)).i(r0, r12) == false) goto L12;
        r13 = BitableSubtype.APP.getTypeName();
    L17:
        StringBuilder r16 = new StringBuilder("onCreateView:type:");
        r16.append(r0);
        r16.append(",hasCache? ");
        boolean r3 = true;
        if (r11 == null) goto L20;
        boolean r5 = true;
    L21:
        r16.append(r5);
        tt5.a.h("DocumentFragment", r16.toString());
        if (r11 != null) goto L24;
        r11 = ga0(r8, r0);
    L24:
        StringBuilder r17 = new StringBuilder("onCreateView:type:");
        r17.append(r0);
        r17.append(",hasCache? ");
        if (r11 != null) goto L28;
        r3 = false;
    L28:
        r17.append(r3);
        tt5.a.h("DocumentFragment", r17.toString());
        this.q = (i5c.a) ApiUtils.getApi(i5c.a.class);
        return r11;
    L20:
        r5 = false;
        goto L21
    L5:
        r0 = null;
        goto L6
    }

    public static BaseFragment la0(String r1, String r2, Bundle r3, UserSession r4) {
        if (r2 != null) goto L4;
        tt5.a.k("DocumentFragment", "newInstance URL empty");
        r2 = "";
    L4:
        if (r3 != null) goto L6;
        r3 = new Bundle();
    L6:
        r3.putString("url", r2);
        PassportcConvention.h(r3, r4);
        BaseFragment r5 = ia0(r1, r2).a.newInstance();     // Catch: Exception -> L10
        r5.setArguments(r3);
        return r5;
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
