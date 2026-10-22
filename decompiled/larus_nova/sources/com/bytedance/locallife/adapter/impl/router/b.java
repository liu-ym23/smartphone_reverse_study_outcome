package com.bytedance.locallife.adapter.impl.router;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.ai.api.navi.AppletNaviType;
import com.bytedance.android.locallife.core.service.LifeServiceManager;
import com.bytedance.locallife.adapter.impl.page.pdp.LifePdpActivity;
import com.bytedance.locallife.biz.perf.PageEnum;
import com.bytedance.locallife.biz.perf.WholeProcessOptimizationWrapper;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.poi.bean.PoiBizCode;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class b extends fo6.a {

    public static final class a {
    }

    static {
    }

    public b(xu6.d r100) {
        super(r100);
    }

    @Override // fo6.d
    public final boolean a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        boolean r101 = TextUtils.equals(AppletNaviType.POI, r100.getHost());
        if (TextUtils.equals("/goodsdetail", r100.getPath()) == false) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r101 == false) goto L13;
        if (r102 == false) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L5:
        if (TextUtils.equals("/goodsdetail/", r100.getPath()) == true) goto L8;
        r102 = false;
        goto L9
    }

    @Override // fo6.a, fo6.d
    public final void b(Context r110, Uri r111, Intent r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r112, "intent");
        super.b(r110, r111, r112);
        WholeProcessOptimizationWrapper r100 = WholeProcessOptimizationWrapper.f256838a;
        Object r101 = null;
        if (r111 != null) goto L63;
    L13:
        String r102 = "default";
    L14:
        PoiBizCode[] r103 = PoiBizCode.values();
        boolean r104 = false;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L23
        int r106 = r103.length;     // Catch: Throwable -> L23
        int r107 = 0;
    L16:
        if (r107 >= r106) goto L22;
        PoiBizCode r108 = r103[r107];     // Catch: Throwable -> L23
        if (Intrinsics.areEqual(r108.bizCode, r102) == true) goto L19;
        r107 = r107 + 1;     // Catch: Throwable -> L23
        goto L16
    L19:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L23
    L26:
        if (Result.m9455isFailureimpl(r109) == true) goto L29;
        r101 = r109;
    L29:
        PoiBizCode r113 = (PoiBizCode) r101;
        if (r113 != null) goto L32;
        r113 = PoiBizCode.DEFAULT;
    L32:
        PoiBizCode r114 = r113;
        PageEnum r115 = PageEnum.GOODS_DETAIL;
        yv6.a r116 = WholeProcessOptimizationWrapper.b();
        if (r116 == null) goto L37;
        Boolean r117 = r116.a();
        if (r117 == null) goto L37;
        boolean r118 = r117.booleanValue();
    L38:
        yv6.a r119 = WholeProcessOptimizationWrapper.b();
        if (r119 == null) goto L43;
        Boolean r120 = r119.b();
        if (r120 == null) goto L43;
        boolean r121 = r120.booleanValue();
    L44:
        yv6.a r122 = WholeProcessOptimizationWrapper.b();
        if (r122 == null) goto L49;
        Boolean r123 = r122.c();
        if (r123 == null) goto L49;
        boolean r124 = r123.booleanValue();
    L50:
        WholeProcessOptimizationWrapper.f(r100, r114, r115, r118, r121, Boolean.valueOf(r124), null, 32);
        String r125 = UriProtector.getQueryParameter(r111, "popup");
        if (r125 != null) goto L53;
    L54:
        r104 = true;
    L55:
        if (r104 == false) goto L57;
    L60:
        r112.setClass(r110, LifePdpActivity.class);
        r112.putExtra("launch_timestamps", SystemClock.elapsedRealtime());
        r110.startActivity(r112);
        return;
    L57:
        if (Intrinsics.areEqual(r125, "0") == true) goto L60;
        ConcurrentHashMap<Class<?>, Object> r126 = LifeServiceManager.f162660a;
        ((com.bytedance.locallife.pdp.d) LifeServiceManager.b(com.bytedance.locallife.pdp.d.class)).f(r110, r111, Long.valueOf(SystemClock.elapsedRealtime()), null, null, null, null);
        return;
    L53:
        if (r125.length() != 0) goto L55;
    L49:
        r124 = true;
    L43:
        r121 = false;
    L37:
        r118 = true;
        goto L38
    L22:
        throw new NoSuchElementException("Array contains no element matching the predicate.");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Result.Companion r127 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    L63:
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L6
        Object r129 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r111, UniContext.KEY_OF_BIZ_CODE));     // Catch: Throwable -> L6
    L9:
        if (Result.m9455isFailureimpl(r129) == false) goto L11;
        r129 = null;
    L11:
        r102 = (String) r129;
        if (r102 != null) goto L14;
    L6:
        th = move-exception;
        Result.Companion r130 = Result.Companion;
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }
}
