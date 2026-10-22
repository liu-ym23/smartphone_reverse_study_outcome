package com.bytedance.ee.bear.drive.biz.expand;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.r4;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.route.ExpandDocHelperForKA;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lw4.c;
import o75.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/expand/DriveSpaceActivityExpandPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "Lcom/bytedance/ee/bear/content/expand/OnExpandActivityClickListener;", "<init>", "()V", "expandWrapper", "Lcom/bytedance/ee/bear/content/expand/ActivityExpandWrapper;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onDetachFromHost", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onConfigurationChanged", "newConfiguration", "Landroid/content/res/Configuration;", "extraCloseExpandItemMenu", "", "titleBar", "Lcom/bytedance/ee/bear/browser/plugin/TitleBar;", "activity", "Landroid/app/Activity;", "onExpandItemClick", "onExpandItemClickWhenDowngrade", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSpaceActivityExpandPlugin extends AbsDrivePlugin implements c {
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

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void onExpandItemClickWhenDowngrade() {
        int r0 = lw4.a.g;
        boolean r1 = com.bytedance.ee.util.ui.a.a(getActivity());
        b.a().Ke().G(!r1);
        if (r1 == false) goto L5;
        getActivity().finish();     // Catch: Exception -> L10
    L13:
        return;
    L5:
        r4 r2 = (r4) getHostAbilityOrNull(r4.class);     // Catch: Exception -> L10
        if (r2 != null) goto L8;
        return;
    L8:
        String r3 = r2.getOriginUrl();     // Catch: Exception -> L10
        RouteBean r4 = new RouteBean();     // Catch: Exception -> L10
        Bundle r5 = new Bundle();     // Catch: Exception -> L10
        r5.putBoolean("addToBackStack", false);     // Catch: Exception -> L10
        r5.putBoolean("force_load_same", true);     // Catch: Exception -> L10
        r5.putBoolean("force_single_top", true);     // Catch: Exception -> L10
        r4.n = r5;     // Catch: Exception -> L10
        r4.o = true;     // Catch: Exception -> L10
        ((h) this.expandWrapper.b.a(h.class)).m9(r3, r4);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        tt5.a.d(TAG, "onExpandItemClick fail: " + e);
    }

    public DriveSpaceActivityExpandPlugin() {
        this.expandWrapper = new lw4.a(this);
    }

    @Override // lw4.c
    public void onExpandItemClick() {
        if (ExpandDocHelperForKA.a() == false) goto L6;
        onExpandItemClickWhenDowngrade();
        return;
    L6:
        int r0 = lw4.a.g;
        boolean r1 = com.bytedance.ee.util.ui.a.a(getActivity());
        b.a().Ke().G(!r1);
        r4 r2 = (r4) getHostAbilityOrNull(r4.class);     // Catch: Exception -> L12
        if (r2 != null) goto L10;
        return;
    L10:
        String r3 = r2.getOriginUrl();     // Catch: Exception -> L12
        RouteBean r4 = new RouteBean();     // Catch: Exception -> L12
        Bundle r5 = new Bundle();     // Catch: Exception -> L12
        r5.putBoolean("addToBackStack", false);     // Catch: Exception -> L12
        r5.putBoolean("force_load_same", true);     // Catch: Exception -> L12
        r5.putBoolean("force_single_top", true);     // Catch: Exception -> L12
        r4.n = r5;     // Catch: Exception -> L12
        r4.o = !r1;     // Catch: Exception -> L12
        ((h) this.expandWrapper.b.a(h.class)).m9(r3, r4);     // Catch: Exception -> L12
        getActivity().finish();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        tt5.a.d(TAG, "onExpandItemClick fail: " + e);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onAttachToHost(r2);
        this.expandWrapper.d(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r3) {
        super.onConfigurationChanged(r3);
        this.expandWrapper.f(getTitleBar(), getActivity());
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onDetachFromHost(r2);
        this.expandWrapper.e(getTitleBar());
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    @Override // lw4.c
    public boolean extraCloseExpandItemMenu(TitleBar r1, Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        return TextUtils.equals(getHost().c.getOpenEntity().getPreviewFrom(), "history");
    }

    public void onAttachToUIContainer(DrivePluginHost r2, t r3) {
        super.onAttachToUIContainer(r2, r3);
        this.expandWrapper.f(getTitleBar(), getActivity());
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DrivePluginHost) r1, r2);
    }
}
