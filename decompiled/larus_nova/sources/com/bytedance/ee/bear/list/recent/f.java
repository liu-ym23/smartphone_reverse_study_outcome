package com.bytedance.ee.bear.list.recent;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.DocumentListInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f extends com.bytedance.ee.bear.list.e<DocumentListInfo> implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f229279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f229280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f229281d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.list.e
    public final NetService.d<DocumentListInfo> m() {
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new g());
    }

    public f() {
        this.f229279b = "RecentListLoader";
        this.f229280c = "/api/explorer/doubao/recent/list";
        this.f229281d = "/api/explorer/doubao/children/list/";
    }

    @Override // com.bytedance.ee.bear.list.e
    public final String n() {
        return this.f229279b;
    }

    @Override // com.bytedance.ee.bear.list.recent.b
    public final com.bytedance.ee.bear.list.d d(String r100, List r101, int r102, int r103, int r104, int r105, int r106, nc5.a r110) {
        Intrinsics.checkNotNullParameter(r110, "callback");
        tt5.a.h("RecentListLoader", "fetchRecentList, lastLabel: " + r100 + ", length: " + r102);
        String r107 = this.f229280c;
        Integer r108 = Integer.valueOf(r102);
        Integer r109 = Integer.valueOf(r103);
        Intrinsics.checkNotNullParameter(r107, "apiPath");
        NetService.f r111 = new NetService.f(r107);
        if (r108 == null) goto L5;
        r111.b("length", r108.toString());
    L5:
        if (r101 != null) goto L7;
    L13:
        if (r109 == null) goto L16;
        r111.b("rank", r109.toString());
    L16:
        if (TextUtils.isEmpty(r100) == true) goto L18;
        r111.b("last_label", r100);
    L18:
        r111.b("thumbnail_width", String.valueOf(r104));
        r111.b("thumbnail_height", String.valueOf(r105));
        r111.b("thumbnail_policy", String.valueOf(r106));
        return l(r111, r110);
    L7:
        if ((!r101.isEmpty()) == false) goto L13;
        ArrayList r112 = new ArrayList();
        Iterator r113 = r101.iterator();
    L10:
        if (r113.hasNext() == false) goto L12;
        r112.add(String.valueOf(((Number) r113.next()).intValue()));
        goto L10
    L12:
        r111.a("obj_type", r112);
        goto L13
    }

    @Override // com.bytedance.ee.bear.list.recent.b
    public final com.bytedance.ee.bear.list.d i(String r100, String r101, Integer r102, List r103, int r104, int r105, int r110, int r111, int r112, nc5.a r113) {
        Intrinsics.checkNotNullParameter(r100, "parentToken");
        Intrinsics.checkNotNullParameter(r113, "callback");
        tt5.a.h("RecentListLoader", "fetchChildrenList, parentToken: " + du5.b.k(r100) + ", lastLabel: " + r101 + ", length: " + r104);
        String r106 = this.f229281d;
        Integer r107 = Integer.valueOf(r104);
        Integer r108 = Integer.valueOf(r105);
        Intrinsics.checkNotNullParameter(r106, "apiPath");
        Intrinsics.checkNotNullParameter(r100, "parentToken");
        NetService.f r109 = new NetService.f(r106);
        r109.b("need_total", "1");
        if (TextUtils.isEmpty(r100) == true) goto L5;
        r109.b("token", r100);
    L5:
        if (r107 == null) goto L7;
        r109.b("length", r107.toString());
    L7:
        if (r103 != null) goto L9;
    L15:
        if (r108 == null) goto L17;
        r109.b("rank", r108.toString());
    L17:
        if (r102 == null) goto L20;
        r109.b("asc", r102.toString());
    L20:
        if (TextUtils.isEmpty(r101) == true) goto L22;
        r109.b("last_label", r101);
    L22:
        r109.b("thumbnail_width", String.valueOf(r110));
        r109.b("thumbnail_height", String.valueOf(r111));
        r109.b("thumbnail_policy", String.valueOf(r112));
        return l(r109, r113);
    L9:
        if ((!r103.isEmpty()) == false) goto L15;
        ArrayList r114 = new ArrayList();
        Iterator r115 = r103.iterator();
    L12:
        if (r115.hasNext() == false) goto L14;
        r114.add(String.valueOf(((Number) r115.next()).intValue()));
        goto L12
    L14:
        r109.a("obj_type", r114);
        goto L15
    }
}
