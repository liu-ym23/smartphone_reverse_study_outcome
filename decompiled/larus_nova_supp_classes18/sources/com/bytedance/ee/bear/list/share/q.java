package com.bytedance.ee.bear.list.share;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q extends com.bytedance.ee.bear.route.b {
    public ww4.a b;

    public q() {
        super(new com.bytedance.ee.bear.route.d[0]);
    }

    @Override // com.bytedance.ee.bear.route.a
    public final String e(BearUrl r1, RouteBean r2) {
        return "/list/share/activity";
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r3, BearUrl r4, RouteBean r5) {
        if (this.b != null) goto L6;
        this.b = (ww4.a) org.koin.java.a.a(ww4.a.class);
    L6:
        if (this.b.a().d().a == true) goto L9;
        return false;
    L9:
        if (TextUtils.equals(r4.a, "history_shared_folder") == false) goto L12;
        tt5.a.h("HistorySharedFolderRouteInterceptor", "dispatchUrl()..." + r4.a);
        d(r4, r5).l("show_history_folders", true).e();
        return true;
    L12:
        return false;
    }
}
