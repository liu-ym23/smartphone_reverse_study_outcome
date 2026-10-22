package com.bytedance.ee.bear.list.share;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;

/* JADX INFO: loaded from: classes18.dex */
public final class q extends com.bytedance.ee.bear.route.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ww4.a f229521b;

    public q() {
        super(new com.bytedance.ee.bear.route.d[0]);
    }

    @Override // com.bytedance.ee.bear.route.a
    public final String e(BearUrl r100, RouteBean r101) {
        return "/list/share/activity";
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r100, BearUrl r101, RouteBean r102) {
        if (this.f229521b != null) goto L6;
        this.f229521b = (ww4.a) org.koin.java.a.a(ww4.a.class);
    L6:
        if (this.f229521b.a().d().f217118a == true) goto L9;
        return false;
    L9:
        if (TextUtils.equals(r101.f222560a, "history_shared_folder") == false) goto L12;
        tt5.a.h("HistorySharedFolderRouteInterceptor", "dispatchUrl()..." + r101.f222560a);
        d(r101, r102).l("show_history_folders", true).e();
        return true;
    L12:
        return false;
    }
}
