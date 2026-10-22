package com.bytedance.ee.bear.basesdk.config.strategy.base;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.browser.plugin.BasePluginV2;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.z5;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.d;
import com.bytedance.ee.bear.route.h;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u000b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/basesdk/config/strategy/base/OfficePopLastWikiRoutePlugin;", "Lcom/bytedance/ee/bear/browser/plugin/BasePluginV2;", "<init>", "()V", "routeService", "Lcom/bytedance/ee/bear/route/RouteService;", "reloadAbility", "Lcom/bytedance/ee/bear/document/ReloadAbility;", "interceptorAdded", "", "routeInterceptor", "com/bytedance/ee/bear/basesdk/config/strategy/base/OfficePopLastWikiRoutePlugin$routeInterceptor$1", "Lcom/bytedance/ee/bear/basesdk/config/strategy/base/OfficePopLastWikiRoutePlugin$routeInterceptor$1;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "onDetachFromHost", "Companion", "basesdk_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficePopLastWikiRoutePlugin extends BasePluginV2 {
    public static final a Companion = null;
    private static final String TAG = "OfficePopLastWikiRoutePlugin";
    private boolean interceptorAdded;
    private z5 reloadAbility;
    private final b routeInterceptor;
    private h routeService;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficePopLastWikiRoutePlugin f206603a;

        public b(OfficePopLastWikiRoutePlugin r100) {
            this.f206603a = r100;
        }

        @Override // com.bytedance.ee.bear.route.d
        public final boolean b(Context r100, BearUrl r101, RouteBean r102) {
            if (r101 != null) goto L5;
            return false;
        L5:
            if (r102 != null) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(r101.f222560a, e.f541303n.getType()) == true) goto L10;
            return false;
        L10:
            Bundle r103 = r102.f236649n;
            if (r103 != null) goto L13;
        L15:
            boolean r104 = false;
        L17:
            if (r104 == true) goto L20;
            tt5.a.h(OfficePopLastWikiRoutePlugin.TAG, "not pop last");
            return false;
        L20:
            String r105 = r101.f222564e;
            if ((!TextUtils.isEmpty(r105)) == true) goto L24;
            r105 = null;
        L24:
            if (r105 != null) goto L27;
            r105 = r102.f236647l;
        L27:
            if (TextUtils.isEmpty(r105) == false) goto L30;
            tt5.a.h(OfficePopLastWikiRoutePlugin.TAG, "targetUrl is null");
            return false;
        L30:
            z5 r106 = OfficePopLastWikiRoutePlugin.access$getReloadAbility$p(this.f206603a);
            if (r106 != null) goto L33;
            return false;
        L33:
            tt5.a.h(OfficePopLastWikiRoutePlugin.TAG, "reloadDocumentFragment");
            r106.reloadDocumentFragment(r105, r102.f236646k);
            return true;
        L13:
            if (r103.getBoolean("popLastDocument", false) != true) goto L15;
            r104 = true;
            goto L17
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public OfficePopLastWikiRoutePlugin() {
        this.routeInterceptor = new b(this);
    }

    public static final /* synthetic */ z5 access$getReloadAbility$p(OfficePopLastWikiRoutePlugin r100) {
        return r100.reloadAbility;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        super.onAttachToHost(r100);
        z5 r101 = (z5) r100.getHostAbilityOrNull(z5.class);
        if (r101 != null) goto L5;
        return;
    L5:
        this.reloadAbility = r101;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        Object r103 = Result.m9449constructorimpl((h) r100.getUserComponent().a(h.class));     // Catch: Throwable -> L8
    L11:
        if (Result.m9455isFailureimpl(r103) == false) goto L13;
        r103 = null;
    L13:
        h r104 = (h) r103;
        if (r104 != null) goto L16;
        return;
    L16:
        this.routeService = r104;
        r104.Td(this.routeInterceptor);
        this.interceptorAdded = true;
        tt5.a.h(TAG, "onAttachToHost");
        return;
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        if (this.interceptorAdded == false) goto L8;
        h r101 = this.routeService;
        if (r101 == null) goto L7;
        r101.s5(this.routeInterceptor);
    L7:
        this.interceptorAdded = false;
    L8:
        this.routeService = null;
        this.reloadAbility = null;
        super.onDetachFromHost(r100);
    }
}
