package com.bytedance.ee.bear.lynx.impl.page;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.api.bean.ForsetiScreenMode;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import com.ss.android.lark.api.ui.j;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.utils.ApiUtils;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0006*\u0002\r\u0010\b\u0007\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0013H\u0002J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u001bH\u0016J\u001c\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(J\b\u0010*\u001a\u00020&H\u0016J\b\u0010+\u001a\u00020&H\u0016J\b\u0010,\u001a\u00020\u001bH\u0016J\b\u0010-\u001a\u00020\u001bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006/"}, d2 = {"Lcom/bytedance/ee/bear/lynx/impl/page/CCMLynxPageFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/lynx/impl/route/RouterAbilityProvider;", "<init>", "()V", "uri", "Landroid/net/Uri;", "titleContainer", "Landroid/widget/FrameLayout;", "contentContainer", "ccmLynxCardView", "Lcom/bytedance/ee/bear/lynx/api/CCMLynxCardView;", "viewModeListener", "com/bytedance/ee/bear/lynx/impl/page/CCMLynxPageFragment$viewModeListener$1", "Lcom/bytedance/ee/bear/lynx/impl/page/CCMLynxPageFragment$viewModeListener$1;", "screenModeChangedListener", "com/bytedance/ee/bear/lynx/impl/page/CCMLynxPageFragment$screenModeChangedListener$1", "Lcom/bytedance/ee/bear/lynx/impl/page/CCMLynxPageFragment$screenModeChangedListener$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initView", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "checkFieldInitIsValid", "", "onDestroy", "sendEvent", "eventName", "", "params", "", "", "getBid", "getContainerId", "close", "dismiss", "Companion", "features-lynx-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CCMLynxPageFragment extends BaseFragment implements com.bytedance.ee.bear.lynx.impl.route.c {
    public Uri e;
    public FrameLayout f;
    public FrameLayout g;
    public CCMLynxCardView h;
    public final c i;
    public final b j;

    public static final class a {
    }

    public static final class b implements Function1<ForsetiScreenMode, Unit> {
        public final /* synthetic */ CCMLynxPageFragment a;

        public b(CCMLynxPageFragment r1) {
            this.a = r1;
        }

        public final Object invoke(Object r3) {
            ForsetiScreenMode r4 = (ForsetiScreenMode) r3;
            Intrinsics.checkNotNullParameter(r4, "mode");
            if (ForsetiHelper.f() == true) goto L5;
            tt5.a.h("CCMLynxPageFragment", "invoke: screenMode = " + r4 + ", is not splitWindow .return");
        L7:
            return Unit.INSTANCE;
        L5:
            WindowInsetsUtils.b(this.a).h(r4.isCompact());
            goto L7
        }
    }

    public static final class c implements j {
        public final /* synthetic */ CCMLynxPageFragment a;

        public c(CCMLynxPageFragment r1) {
            this.a = r1;
        }

        public final void a(ForsetiViewMode r3) {
            Intrinsics.checkNotNullParameter(r3, "viewMode");
            if (ForsetiHelper.i() == false) goto L6;
            tt5.a.h("CCMLynxPageFragment", "onForsetiViewModeChanged: viewMode = " + r3 + ", is splitWindow .return");
            return;
        L6:
            WindowInsetsUtils.b(this.a).h(r3.isCompact());
        }
    }

    static {
    }

    public CCMLynxPageFragment() {
        this.i = new c(this);
        this.j = new b(this);
    }

    @Override // com.bytedance.ee.bear.lynx.impl.route.c
    public final void close() {
        g r0 = f.b(this);
        if (r0 == null) goto L6;
        r0.g(null);
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        CCMLynxCardView r0 = this.h;
        if (r0 == null) goto L6;
        r0.destroy();
    L6:
        if (ForsetiHelper.s(this) == true) goto L8;
        return;
    L8:
        if (ForsetiHelper.m() == true) goto L10;
        return;
    L10:
        if (ForsetiHelper.f() == false) goto L14;
        tt5.a.h("CCMLynxPageFragment", "onDestroy(),  removeScreenModeChangedListener");
        tua.b r1 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(requireActivity());
        if (r1 == null) goto L20;
        r1.j(this.j);
        return;
    L20:
        return;
    L14:
        tt5.a.h("CCMLynxPageFragment", "onDestroy(),  removeViewModeChangedListener");
        tua.b r2 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(requireActivity());
        if (r2 == null) goto L22;
        r2.e(this.i);
        return;
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        CCMLynxCardView r3 = this.h;
        if (r3 == null) goto L6;
        r3.b();
        return;
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        Bundle r10 = getArguments();
        Serializable r0 = null;
        if (r10 == null) goto L5;
        Uri r11 = (Uri) r10.getParcelable("uri");
    L6:
        this.e = r11;
        this.f = (FrameLayout) r8.findViewById(2131379308);
        this.g = (FrameLayout) r8.findViewById(2131379283);
        CCMLynxCardView r12 = (CCMLynxCardView) org.koin.java.a.c(CCMLynxCardView.class, null, new CCMLynxPageFragment$initView$1(this), 2);
        this.h = r12;
        if (this.e != null) goto L9;
    L12:
        boolean r13 = false;
    L13:
        if (r13 == true) goto L17;
        g r14 = f.b(this);
        if (r14 == null) goto L65;
        r14.g(null);
    L65:
        if (ForsetiHelper.s(this) == true) goto L67;
        return;
    L67:
        if (ForsetiHelper.m() == true) goto L69;
        return;
    L69:
        if (ForsetiHelper.i() == false) goto L73;
        tt5.a.h("CCMLynxPageFragment", "onViewCreated(), use addScreenModeChangedListener");
        tua.b r15 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(requireActivity());
        if (r15 == null) goto L84;
        r15.D(this.j);
        return;
    L84:
        return;
    L73:
        tt5.a.h("CCMLynxPageFragment", "onViewCreated(), use addViewModeChangedListener");
        tua.b r16 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(requireActivity());
        if (r16 == null) goto L86;
        r16.P(this.i);
        return;
    L86:
        return;
    L17:
        Bundle r17 = getArguments();
        if (r17 == null) goto L20;
        Object r18 = r17.get("template-data-bundle-key");
    L22:
        if ((r18 instanceof HashMap) == false) goto L24;
        HashMap r4 = (HashMap) r18;
    L25:
        Bundle r19 = getArguments();
        if (r19 == null) goto L28;
        String r6 = r19.getString("share-context-ID");
    L29:
        Bundle r20 = getArguments();
        if (r20 == null) goto L34;
        Bundle r21 = r20.getBundle("ori-bundle");
        if (r21 == null) goto L34;
        r21.getInt("status-bar-and-navigator-color", -1);
    L34:
        FrameLayout r2 = this.g;
        if (r2 == null) goto L44;
        CCMLynxCardView r1 = this.h;
        if (r1 == null) goto L44;
        Uri r22 = this.e;
        if (r22 == null) goto L42;
        String r23 = r22.toString();
        if (r23 == null) goto L42;
    L43:
        r1.a(r2, r23, r4, new ViewGroup.LayoutParams(-1, -1), r6);
    L42:
        r23 = "";
    L44:
        CCMLynxCardView r24 = this.h;
        if (r24 == null) goto L47;
        r24.f(new com.bytedance.ee.bear.lynx.impl.page.a(this));
    L47:
        XBridgeMethod r25 = new je5.b(this);
        CCMLynxCardView r26 = this.h;
        if (r26 == null) goto L50;
        r26.h(r25.c, r25);
    L50:
        Bundle r27 = getArguments();
        if (r27 == null) goto L53;
        r0 = r27.getSerializable("biz-method");
    L53:
        ArrayList r3 = (ArrayList) r0;
        if (r3 == null) goto L61;
        Iterator r28 = r3.iterator();
    L57:
        if (r28.hasNext() == false) goto L61;
        XBridgeMethod r29 = (XBridgeMethod) ((Class) r28.next()).newInstance();
        CCMLynxCardView r5 = this.h;
        if (r5 == null) goto L57;
        String r7 = r29.getName();
        Intrinsics.checkNotNull(r29);
        r5.h(r7, r29);
    L61:
        CCMLynxCardView r30 = this.h;
        if (r30 == null) goto L65;
        r30.registerWeakHolder(Fragment.class, this);
        goto L65
    L28:
        r6 = null;
        goto L29
    L24:
        r4 = null;
        goto L25
    L20:
        r18 = null;
        goto L22
    L9:
        if (this.g == null) goto L12;
        if (r12 == null) goto L12;
        r13 = true;
        goto L13
    L5:
        r11 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        com.ss.android.lark.insets.f r6 = WindowInsetsUtils.b(this);
        r6.b(UIUtils.getColor(getContext(), 2131100548));
        r6.h(true);
        r6.c(true);
        View r7 = r3.inflate(2131563605, r4, false);
        r7.setFitsSystemWindows(true);
        return r7;
    }
}
