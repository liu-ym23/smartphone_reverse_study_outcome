package hy8;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.c;
import com.bytedance.router.i;
import com.larus.canvas.feature.CanvasProxyActivity;
import com.larus.utils.k0;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements q97.a {

    /* JADX INFO: renamed from: hy8.a$a, reason: collision with other inner class name */
    public static final class C6213a {
    }

    static {
    }

    public a() {
    }

    @Override // q97.a
    public final boolean b(c r100) {
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("Router matchInterceptRules -> ");
        String r103 = null;
        if (r100 == null) goto L7;
        Uri r104 = r100.f267530d;
        if (r104 == null) goto L7;
        String r105 = r104.getAuthority();
    L8:
        r102.append(r105);
        r101.d("CanvasRouterInterceptor", r102.toString());
        int r106 = k0.f375428a;
        if (r100 == null) goto L11;
        Uri r107 = r100.f267530d;
    L12:
        String r108 = k0.a(String.valueOf(r107));
        if (r108 != null) goto L15;
    L17:
        boolean r109 = false;
    L18:
        if (r109 == false) goto L26;
        if (r100 == null) goto L24;
        Uri r110 = r100.f267530d;
        if (r110 == null) goto L24;
        r103 = UriProtector.getQueryParameter(r110, "require_image");
    L24:
        if (Intrinsics.areEqual(r103, "1") == false) goto L26;
        return true;
    L26:
        return false;
    L15:
        if (StringsKt.contains$default(r108, "//flow/canvas", false, 2, null) != true) goto L17;
        r109 = true;
        goto L18
    L11:
        r107 = null;
    L7:
        r105 = null;
        goto L8
    }

    @Override // q97.a
    public final boolean a(Context r100, c r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L9;
        FLogger.f375446a.i("CanvasRouterInterceptor", "Router onInterceptRoute, redirect to CanvasProxyActivity");
        int r102 = CanvasProxyActivity.f323011a;
        Bundle r103 = r101.f267528b.getExtras();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        i r104 = SmartRouter.buildRoute(r100, "//flow/canvas_schema_proxy");
        r104.f267554c.putExtras(r103);
        r104.d();
        return true;
    L9:
        return false;
    L7:
        return false;
    }
}
