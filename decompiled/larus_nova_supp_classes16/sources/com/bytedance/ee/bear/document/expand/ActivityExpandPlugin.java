package com.bytedance.ee.bear.document.expand;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import bx4.b;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.DriveShadowFileEntity;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.r4;
import com.bytedance.ee.bear.route.ExpandDocHelperForKA;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import com.larksuite.component.universe_design.toast.UDToast;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lw4.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\u0013J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0002J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0013H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/document/expand/ActivityExpandPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "Lcom/bytedance/ee/bear/content/expand/OnExpandActivityClickListener;", "<init>", "()V", "expandWrapper", "Lcom/bytedance/ee/bear/content/expand/ActivityExpandWrapper;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "onDetachFromHost", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onConfigurationChanged", "newConfiguration", "Landroid/content/res/Configuration;", "isExpandActivity", "", "extraCloseExpandItemMenu", "titleBar", "Lcom/bytedance/ee/bear/browser/plugin/TitleBar;", "activity", "Landroid/app/Activity;", "onExpandItemClick", "onExpandItemClickWhenDowngrade", "reportTopBarClickExpandEvent", "isExpand", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActivityExpandPlugin extends DocumentPlugin implements c {
    public static final a Companion = null;
    private static final String TAG = "ActivityExpandPlugin";
    private final lw4.a expandWrapper;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void onExpandItemClickWhenDowngrade() {
        int r0 = lw4.a.g;
        boolean r1 = com.bytedance.ee.util.ui.a.a(getActivity());
        reportTopBarClickExpandEvent(!r1);
        if (r1 == false) goto L5;
        getActivity().finish();     // Catch: Exception -> L14
        return;
    L5:
        r4 r2 = (r4) getHostAbilityOrNull(r4.class);     // Catch: Exception -> L14
        if (r2 != null) goto L8;
        return;
    L8:
        String r3 = r2.getContainerUrl();     // Catch: Exception -> L14
        RouteBean r4 = new RouteBean();     // Catch: Exception -> L14
        Bundle r5 = new Bundle();     // Catch: Exception -> L14
        r5.putBoolean("addToBackStack", false);     // Catch: Exception -> L14
        r5.putBoolean("force_load_same", true);     // Catch: Exception -> L14
        r5.putBoolean("force_single_top", true);     // Catch: Exception -> L14
        DocViewModel r6 = getDocViewModel();     // Catch: Exception -> L14
        if (r6 == null) goto L11;
        DriveShadowFileEntity r7 = r6.getShadowFileEntity();     // Catch: Exception -> L14
    L12:
        r5.putSerializable(DriveShadowFileEntity.SHADOW_FILE_DATA, r7);     // Catch: Exception -> L14
        r4.n = r5;     // Catch: Exception -> L14
        r4.o = true;     // Catch: Exception -> L14
        ((h) this.expandWrapper.b.a(h.class)).m9(r3, r4);     // Catch: Exception -> L14
        return;
    L11:
        r7 = null;
    L14:
        e = move-exception;
        tt5.a.d(TAG, "onExpandItemClick fail: " + e);
    }

    public final boolean isExpandActivity() {
        if (this.expandWrapper.c == false) goto L7;
        int r0 = lw4.a.g;
        if (com.bytedance.ee.util.ui.a.a(getActivity()) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public ActivityExpandPlugin() {
        this.expandWrapper = new lw4.a(this);
    }

    @Override // lw4.c
    public void onExpandItemClick() {
        if (ExpandDocHelperForKA.a() == false) goto L7;
        onExpandItemClickWhenDowngrade();
        return;
    L7:
        if (b.b(getDocViewModel().getToken()) == false) goto L10;
        UDToast.show(getContext(), 2131887326);
        tt5.a.k(TAG, "document fake token is not support expand or shrink activity");
        return;
    L10:
        int r0 = lw4.a.g;
        boolean r1 = com.bytedance.ee.util.ui.a.a(getActivity());
        reportTopBarClickExpandEvent(!r1);
        r4 r2 = (r4) getHostAbilityOrNull(r4.class);     // Catch: Exception -> L20
        if (r2 != null) goto L14;
        return;
    L14:
        String r3 = r2.getContainerUrl();     // Catch: Exception -> L20
        RouteBean r4 = new RouteBean();     // Catch: Exception -> L20
        Bundle r5 = new Bundle();     // Catch: Exception -> L20
        r5.putBoolean("addToBackStack", false);     // Catch: Exception -> L20
        r5.putBoolean("force_load_same", true);     // Catch: Exception -> L20
        r5.putBoolean("force_single_top", true);     // Catch: Exception -> L20
        DocViewModel r7 = getDocViewModel();     // Catch: Exception -> L20
        if (r7 == null) goto L17;
        DriveShadowFileEntity r8 = r7.getShadowFileEntity();     // Catch: Exception -> L20
    L18:
        r5.putSerializable(DriveShadowFileEntity.SHADOW_FILE_DATA, r8);     // Catch: Exception -> L20
        r4.n = r5;     // Catch: Exception -> L20
        r4.o = !r1;     // Catch: Exception -> L20
        ((h) this.expandWrapper.b.a(h.class)).m9(r3, r4);     // Catch: Exception -> L20
        getActivity().finish();     // Catch: Exception -> L20
        return;
    L17:
        r8 = null;
    L20:
        e = move-exception;
        tt5.a.d(TAG, "onExpandItemClick fail: " + e);
    }

    private final void reportTopBarClickExpandEvent(boolean r5) {
        d r1 = (d) org.koin.java.a.c(d.class, null, null, 6);     // Catch: Exception -> L9
        HashMap r3 = new HashMap(r1.m("docCommonParams"));     // Catch: Exception -> L9
        if (r5 == false) goto L6;
        String r6 = "full_screen";
    L7:
        r3.put("click", r6);     // Catch: Exception -> L9
        r3.put("target", "none");     // Catch: Exception -> L9
        r1.n("ccm_space_docs_topbar_click", r3);     // Catch: Exception -> L9
        tt5.a.h(TAG, "reportTopBarClickExpandEvent finish");     // Catch: Exception -> L9
        return;
    L6:
        r6 = "normal_screen";
    L9:
        e = move-exception;
        tt5.a.d(TAG, "reportTopBarClickExpandEvent fail: " + e);
    }

    public void onAttachToHost(DocumentPluginHost r2) {
        super.onAttachToHost(r2);
        this.expandWrapper.d(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r3) {
        super.onConfigurationChanged(r3);
        this.expandWrapper.f(getTitleBar(), getActivity());
    }

    public void onDetachFromHost(DocumentPluginHost r2) {
        super.onDetachFromHost(r2);
        this.expandWrapper.e(getTitleBar());
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // lw4.c
    public boolean extraCloseExpandItemMenu(TitleBar r1, Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        DocumentPluginHost r3 = (DocumentPluginHost) getHost();
        if (r3 == null) goto L7;
        DocViewModel r4 = r3.a();
        if (r4 == null) goto L7;
        String r5 = r4.getEditionId();
    L9:
        return !TextUtils.isEmpty(r5);
    L7:
        r5 = null;
        goto L9
    }

    public void onAttachToUIContainer(DocumentPluginHost r2, t r3) {
        super.onAttachToUIContainer(r2, r3);
        this.expandWrapper.f(getTitleBar(), getActivity());
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }
}
