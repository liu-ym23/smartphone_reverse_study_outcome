package com.bytedance.ee.bear.document.render.init;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.officesdk.CCMOfficeSDKAssembleFG;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.a6;
import com.bytedance.ee.bear.document.e4;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.document.s4;
import com.bytedance.ee.bear.document.titlebar.d0;
import com.bytedance.ee.bear.document.titlebar.e0;
import com.bytedance.ee.bear.document.v4;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.document.z5;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.google.android.material.appbar.AppBarLayout;
import com.ss.android.lark.chameleon.ChameleonContainerLifecycleListener;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleonv2.container.webcontainer.util.ContainerType;
import com.ss.android.lark.insets.WindowInsetsUtils;
import java.io.Serializable;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class a implements ChameleonContainerLifecycleListener {
    public static final /* synthetic */ int d = 0;
    public final v4 a;
    public DocViewModel b;
    public DocumentLoaderV3 c;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.render.init.a$a, reason: collision with other inner class name */
    public static final class C0098a {
    }

    public static final class b implements vz4.f {
        public final /* synthetic */ AppBarLayout a;

        @Override // vz4.f
        public final FrameLayout il() {
            return (FrameLayout) this.a.findViewById(2131369339);
        }

        @Override // vz4.f
        public final AppBarLayout getTitleBar() {
            return this.a;
        }

        public b(AppBarLayout r1) {
            this.a = r1;
        }
    }

    static {
    }

    public a(v4 r2) {
        Intrinsics.checkNotNullParameter(r2, "docOpenStrategy");
        this.a = r2;
    }

    public void onPreCreateTitleBar(ChameleonPluginHost r1) {
        ChameleonContainerLifecycleListener.DefaultImpls.onPreCreateTitleBar(this, r1);
    }

    public final void onPreFragmentDestroy(ChameleonPluginHost r1) {
        ChameleonContainerLifecycleListener.DefaultImpls.onPreFragmentDestroy(this, r1);
    }

    public void onPreFragmentDestroyView(ChameleonPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        ChameleonContainerLifecycleListener.DefaultImpls.onPreFragmentDestroyView(this, r2);
        DocumentLoaderV3 r3 = this.c;
        if (r3 == null) goto L6;
        r3.bi(false);
        return;
    }

    public final void onPreFragmentPause(ChameleonPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        d25.d.j(null, null);
        d25.d.l(null);
    }

    public final void onPreFragmentResume(ChameleonPluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "pluginHost");
        DocViewModel r4 = this.b;
        BearUrl r0 = null;
        if (r4 == null) goto L5;
        BearUrl r5 = r4.getOriginBearUrl();
    L6:
        DocViewModel r1 = this.b;
        if (r1 == null) goto L9;
        String r2 = r1.getToken();
    L10:
        d25.d.j(r5, r2);
        DocViewModel r6 = this.b;
        if (r6 == null) goto L13;
        r0 = r6.getOriginBearUrl();
    L13:
        d25.d.l(r0);
        return;
    L9:
        r2 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    public final void onPreFragmentStart(ChameleonPluginHost r1) {
        ChameleonContainerLifecycleListener.DefaultImpls.onPreFragmentStart(this, r1);
    }

    public final void onPreFragmentStop(ChameleonPluginHost r1) {
        ChameleonContainerLifecycleListener.DefaultImpls.onPreFragmentStop(this, r1);
    }

    public void onPreFragmentViewCreated(ChameleonPluginHost r1) {
        ChameleonContainerLifecycleListener.DefaultImpls.onPreFragmentViewCreated(this, r1);
    }

    public void a(ChameleonPluginHost r7, t r8) {
        Intrinsics.checkNotNullParameter(r7, "pluginHost");
        Intrinsics.checkNotNullParameter(r8, "uiContainer");
        if (r8.findView(2131369266) == null) goto L5;
        return;
    L5:
        View r0 = r8.findView(2131367053);
        AppBarLayout r2 = null;
        if ((r0 instanceof ViewStub) == false) goto L8;
        ViewStub r1 = (ViewStub) r0;
    L10:
        if (r1 != null) goto L13;
        tt5.a.d("CompatContainerLifecycleListener", "titleBarViewStub is null");
        return;
    L13:
        r1.setLayoutResource(2131559990);
        AppBarLayout r3 = r1.inflate();
        if ((r3 instanceof AppBarLayout) == false) goto L16;
        r2 = r3;
    L16:
        if (r2 != null) goto L19;
        tt5.a.h("CompatContainerLifecycleListener", "appBarLayout == null");
        return;
    L19:
        r7.registerHostAbility(new b(r2));
        if (CCMOfficeSDKAssembleFG.a() == false) goto L25;
        FrameLayout r4 = (FrameLayout) r2.findViewById(2131369339);
        if (r4 == null) goto L26;
        BaseTitleBar r5 = new BaseTitleBar(r7.getContext());
        r5.setId(2131369338);
        r4.addView(r5, new ViewGroup.LayoutParams(-1, com.bytedance.ee.util.ui.n.d(50)));
        d0 r6 = new d0(new e0(r7, r2), this.b);
        r6.setMenuIconTint(2131101926);
        r8.g(r6);
        return;
    L26:
        return;
    L25:
        return;
    L8:
        r1 = null;
        goto L10
    }

    /* JADX WARN: Type inference failed for: r2v22, types: [o45.a, vv4.a] */
    public void onPluginHostCreated(ChameleonPluginHost r12, Function0<Unit> r13) {
        Intrinsics.checkNotNullParameter(r12, "pluginHost");
        Intrinsics.checkNotNullParameter(r13, "pluginMounter");
        yv4.e r1 = null;
        if (r12.getHostAbilityOrNull(x2.class) != null) goto L5;
    L9:
        Fragment r14 = r12.getFragment();
        w05.b r2 = (w05.b) r12.getHostAbilityOrNull(w05.b.class);
        if (r2 != null) goto L12;
        r2 = new w05.c();
        r12.registerHostAbility(r2);
    L12:
        w05.i r3 = r2.getDocumentInfoProvider();
        Bundle r4 = r14.getArguments();
        if (r4 != null) goto L15;
        r4 = new Bundle();
    L15:
        DocViewModel r5 = (DocViewModel) q.c(r12, DocViewModel.class, DocViewModel.newFactory(r4));
        this.b = r5;
        r5.setDocumentInfoProvider(r3);
        a05.c r6 = new a05.c(com.bytedance.ee.bear.contract.j.a.a, (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6), (b0) org.koin.java.a.c(b0.class, null, null, 6), (com.bytedance.ee.bear.contract.f) org.koin.java.a.c(com.bytedance.ee.bear.contract.f.class, null, null, 6), ((b0) org.koin.java.a.c(b0.class, null, null, 6)).e(), r5);
        BearUrl r7 = r5.getOriginBearUrl();
        if (r7 == null) goto L18;
        String r8 = r7.h;
    L19:
        if (r8 != null) goto L21;
        r8 = "tab_other";
    L21:
        r6.o = r8;
        DocumentLoaderV3 r9 = new DocumentLoaderV3(r6, r12, this.a);
        this.c = r9;
        r12.registerHostAbility(new f(r12, r5, r9));
        r12.registerHostAbility(r5);
        r12.registerHostAbility(r9);
        tt5.a.h("CompatContainerLifecycleListener", "init render stage dependencies, pluginHost = " + r12 + ", fragment = " + r14.hashCode() + ", documentLoader = " + r9.hashCode() + ", docType = " + r5.getDocumentType());
    L22:
        boolean r16 = false;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L29
        if (CCMOfficeSDKAssembleFG.a() == false) goto L26;
        WindowInsetsUtils.c(r12.getActivity()).o(false);     // Catch: Throwable -> L29
    L27:
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        Throwable r17 = Result.exceptionOrNull-impl(r11);
        if (r17 == null) goto L35;
        tt5.a.l("CompatContainerLifecycleListener", "init insetsHandler failed", r17);
    L35:
        if (r12.getHostAbilityOrNull(s4.class) != null) goto L40;
        DocViewModel r18 = this.b;
        if (r18 == null) goto L40;
        Intrinsics.checkNotNull(r18);
        r12.registerHostAbility(new k(r18, r12.getFragment(), r12));
    L40:
        if (r12.getHostAbilityOrNull(z5.class) != null) goto L43;
        r12.registerHostAbility(new j(r12));
    L43:
        if (r12.getHostAbilityOrNull(vz4.b.class) != null) goto L45;
        r12.registerHostAbility(new vz4.c());
    L45:
        ?? r19 = (o45.a) r12.getWebService(o45.a.class);
        if (r19 == 0) goto L60;
        DocViewModel r20 = this.b;
        if (r20 == null) goto L50;
        BearUrl r21 = r20.getBearUrl();
    L51:
        r19.a = r21;
        StringBuilder r22 = new StringBuilder("injectDocInfo()... doc_from=");
        if (r21 == null) goto L54;
        String r23 = r21.h;
    L55:
        r22.append(r23);
        r22.append(", type=");
        if (r21 == null) goto L58;
        String r24 = r21.a;
    L59:
        r22.append(r24);
        r22.append(", mWebViewId=");
        r22.append(r19.getWeb().getWebViewId());
        tt5.a.h("WebViewExtendWebService", r22.toString());
        goto L60
    L58:
        r24 = null;
        goto L59
    L54:
        r23 = null;
        goto L55
    L50:
        r21 = null;
    L60:
        DocumentLoaderV3 r26 = this.c;
        if (r26 == null) goto L64;
        r26.m(new e(this));
    L64:
        if (r12.getHostAbilityOrNull(a6.class) != null) goto L114;
        Bundle r27 = r12.getFragment().getArguments();
        FragmentActivity r28 = r12.getActivity();     // Catch: Throwable -> L79
        if (r28 == null) goto L72;
        Intent r29 = r28.getIntent();     // Catch: Throwable -> L79
        if (r29 == null) goto L72;
        Serializable r30 = r29.getSerializableExtra("extra_data_map");     // Catch: Throwable -> L79
    L74:
        if ((r30 instanceof Map) == false) goto L76;
        Map r31 = (Map) r30;     // Catch: Throwable -> L79
    L77:
        Object r32 = Result.constructor-impl(r31);     // Catch: Throwable -> L79
    L81:
        Throwable r33 = Result.exceptionOrNull-impl(r32);
        if (r33 == null) goto L85;
        tt5.a.e("CompatContainerLifecycleListener", "parse route extra data from activity error", r33, false);
    L85:
        if (Result.isFailure-impl(r32) == false) goto L87;
        r32 = null;
    L87:
        Map r34 = (Map) r32;
        if (r34 != null) goto L110;
        if (r27 != null) goto L130;
        Serializable r36 = null;
    L95:
        if ((r36 instanceof Map) == false) goto L97;
        Map r37 = (Map) r36;     // Catch: Throwable -> L91
    L98:
        Object r38 = Result.constructor-impl(r37);     // Catch: Throwable -> L91
    L101:
        Throwable r39 = Result.exceptionOrNull-impl(r38);
        if (r39 == null) goto L105;
        tt5.a.e("CompatContainerLifecycleListener", "parse route extra data from fragment error", r39, false);
    L105:
        if (Result.isFailure-impl(r38) == false) goto L107;
        r38 = null;
    L107:
        r34 = (Map) r38;
        if (r34 != null) goto L110;
        r34 = MapsKt.emptyMap();
    L91:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        r38 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L101
    L97:
        r37 = null;
        goto L98
    L130:
        r36 = r27.getSerializable("extra_data_map");     // Catch: Throwable -> L91
    L110:
        Map r0 = MapsKt.toMutableMap(r34);
        if (r27 == null) goto L113;
        r16 = r27.getBoolean("enable_fetch_before_render", false);
    L113:
        r0.put("enable_fetch_before_render", String.valueOf(r16));
        r12.registerHostAbility(new i(r0));
        goto L114
    L76:
        r31 = null;
    L72:
        r30 = null;
    L79:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        r32 = Result.constructor-impl(ResultKt.createFailure(th));
    L114:
        DocViewModel r110 = (DocViewModel) r12.getHostAbilityOrNull(DocViewModel.class);
        if (r110 != null) goto L119;
        r110 = this.b;
        if (r110 != null) goto L119;
    L120:
        yv4.f r111 = r12.getPluginMounter();
        if ((r111 instanceof yv4.e) == false) goto L123;
        r1 = (yv4.e) r111;
    L123:
        if (r1 == null) goto L136;
        DocumentLoaderV3 r112 = this.c;
        if (r112 == null) goto L137;
        r112.S3(new com.bytedance.ee.bear.document.render.init.b(r1));
        r112.m(new c(r112, r1));
        return;
    L137:
        return;
    L136:
        return;
    L119:
        r110.getDeleted().observe(r12.getFragment(), new h(this, r110, r12));
        goto L120
    L26:
        WindowInsetsUtils.c(r12.getActivity()).o(true);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    L18:
        r8 = null;
        goto L19
    L5:
        if (r12.getHostAbilityOrNull(e4.class) == null) goto L9;
        if (r12.getHostAbilityOrNull(DocViewModel.class) == null) goto L9;
        tt5.a.h("CompatContainerLifecycleListener", "render stage dependencies already initialized");
        goto L22
    }

    public final void onPreConfigurationChanged(ChameleonPluginHost r1, Configuration r2) {
        ChameleonContainerLifecycleListener.DefaultImpls.onPreConfigurationChanged(this, r1, r2);
    }

    public void onPreCreateUIContainer(ChameleonPluginHost r7, t r8) {
        Intrinsics.checkNotNullParameter(r7, "pluginHost");
        Intrinsics.checkNotNullParameter(r8, "uiContainer");
        Intrinsics.checkNotNullParameter(r7, "pluginHost");
        Intrinsics.checkNotNullParameter(r8, "uiContainer");
        a(r7, r8);
        if (r8.findView(2131363249) != null) goto L10;
        ViewGroup r1 = r7.getContainer(ContainerType.Right.getValue());
        if (r1 == null) goto L10;
        FrameLayout r4 = new FrameLayout(r1.getContext());
        r4.setId(2131363249);
        r4.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        r1.addView(r4);
    L10:
        if (r8.findView(2131371520) != null) goto L17;
        ViewGroup r2 = r7.getContainer(ContainerType.Left.getValue());
        if (r2 == null) goto L17;
        FrameLayout r5 = new FrameLayout(r2.getContext());
        r5.setId(2131371520);
        r5.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        r2.addView(r5);
    L17:
        if (r8.findView(2131387152) != null) goto L23;
        ViewGroup r9 = r7.getContainer(ContainerType.Web.getValue());
        if (r9 == null) goto L23;
        FrameLayout r3 = new FrameLayout(r9.getContext());
        r3.setId(2131387152);
        r3.setVisibility(8);
        r3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r9.addView(r3);
    L23:
        WebView r10 = r7.getWeb().getWebView();
        if (r10 == null) goto L28;
        ViewCompat.setOnApplyWindowInsetsListener(r10, d.a);
        return;
    }
}
