package yl9;

import com.baidu.naviapi.open.BNAFuncFactory;
import com.baidu.naviapi.open.IRouteResult;
import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import ul9.f;

/* JADX INFO: loaded from: classes30.dex */
public final class b implements IRouteResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tl9.d f568337a;

    @Override // com.baidu.naviapi.open.IRouteResult
    public final void onNaviEnd() {
        BNAFuncFactory.getBNAManager().exitNavi();
        FLogger.f375446a.i("bd_navi", "[plan][onNaviEnd]");
        this.f568337a.a("navi_end");
    }

    public b(tl9.d r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f568337a = r100;
    }

    @Override // com.baidu.naviapi.open.IRouteResult
    public final void onFailed(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        BNAFuncFactory.getBNAManager().exitNavi();
        FLogger.f375446a.e("bd_navi", "[plan][onFailed]" + r100);
        this.f568337a.a(r100);
    }

    @Override // com.baidu.naviapi.open.IRouteResult
    public final void onSuccess(String r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        FLogger r101 = FLogger.f375446a;
        r101.i("bd_navi", "[plan][onSuccess]");
        if (tl9.b.a() == false) goto L5;
        r101.d("bd_navi", "[plan][onSuccess]" + r100);
    L5:
        BNAFuncFactory.getBNAManager().exitNavi();
        f r102 = (f) new Gson().fromJson(r100, f.class);     // Catch: Exception -> L8
        tl9.d r103 = this.f568337a;     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r102);     // Catch: Exception -> L8
        r103.b(r102);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        if (tl9.b.a() == false) goto L12;
        FLogger r104 = FLogger.f375446a;
        r104.e("bd_navi", "[routePlan][onSuccess][ParseError] type=".concat(e.getClass().getSimpleName()));
        r104.d("bd_navi", "[routePlan][onSuccess][ParseError]" + r100);
    L13:
        this.f568337a.a("[ParseError]" + r100);
        return;
    L12:
        FLogger.f375446a.e("bd_navi", "[routePlan][onSuccess][ParseError]", e);
        goto L13
    }
}
