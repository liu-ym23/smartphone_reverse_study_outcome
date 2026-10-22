package com.bytedance.ee.bear.list.recent;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f extends com.bytedance.ee.bear.list.e<DocumentListInfo> implements b {
    public final String b;
    public final String c;
    public final String d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.list.e
    public final NetService.d<DocumentListInfo> m() {
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new g());
    }

    public f() {
        this.b = "RecentListLoader";
        this.c = "/api/explorer/doubao/recent/list";
        this.d = "/api/explorer/doubao/children/list/";
    }

    @Override // com.bytedance.ee.bear.list.e
    public final String n() {
        return this.b;
    }

    @Override // com.bytedance.ee.bear.list.recent.b
    public final com.bytedance.ee.bear.list.d d(String r3, List r4, int r5, int r6, int r7, int r8, int r9, nc5.a r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
        tt5.a.h("RecentListLoader", "fetchRecentList, lastLabel: " + r3 + ", length: " + r5);
        String r0 = this.c;
        Integer r11 = Integer.valueOf(r5);
        Integer r12 = Integer.valueOf(r6);
        Intrinsics.checkNotNullParameter(r0, "apiPath");
        NetService.f r1 = new NetService.f(r0);
        if (r11 == null) goto L5;
        r1.b("length", r11.toString());
    L5:
        if (r4 != null) goto L7;
    L13:
        if (r12 == null) goto L16;
        r1.b("rank", r12.toString());
    L16:
        if (TextUtils.isEmpty(r3) == true) goto L18;
        r1.b("last_label", r3);
    L18:
        r1.b("thumbnail_width", String.valueOf(r7));
        r1.b("thumbnail_height", String.valueOf(r8));
        r1.b("thumbnail_policy", String.valueOf(r9));
        return l(r1, r10);
    L7:
        if ((!r4.isEmpty()) == false) goto L13;
        ArrayList r13 = new ArrayList();
        Iterator r14 = r4.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        r13.add(String.valueOf(((Number) r14.next()).intValue()));
        goto L10
    L12:
        r1.a("obj_type", r13);
        goto L13
    }

    @Override // com.bytedance.ee.bear.list.recent.b
    public final com.bytedance.ee.bear.list.d i(String r4, String r5, Integer r6, List r7, int r8, int r9, int r10, int r11, int r12, nc5.a r13) {
        Intrinsics.checkNotNullParameter(r4, "parentToken");
        Intrinsics.checkNotNullParameter(r13, "callback");
        tt5.a.h("RecentListLoader", "fetchChildrenList, parentToken: " + du5.b.k(r4) + ", lastLabel: " + r5 + ", length: " + r8);
        String r1 = this.d;
        Integer r14 = Integer.valueOf(r8);
        Integer r15 = Integer.valueOf(r9);
        Intrinsics.checkNotNullParameter(r1, "apiPath");
        Intrinsics.checkNotNullParameter(r4, "parentToken");
        NetService.f r0 = new NetService.f(r1);
        r0.b("need_total", "1");
        if (TextUtils.isEmpty(r4) == true) goto L5;
        r0.b(ResourceData.KEY_TOKEN, r4);
    L5:
        if (r14 == null) goto L7;
        r0.b("length", r14.toString());
    L7:
        if (r7 != null) goto L9;
    L15:
        if (r15 == null) goto L17;
        r0.b("rank", r15.toString());
    L17:
        if (r6 == null) goto L20;
        r0.b("asc", r6.toString());
    L20:
        if (TextUtils.isEmpty(r5) == true) goto L22;
        r0.b("last_label", r5);
    L22:
        r0.b("thumbnail_width", String.valueOf(r10));
        r0.b("thumbnail_height", String.valueOf(r11));
        r0.b("thumbnail_policy", String.valueOf(r12));
        return l(r0, r13);
    L9:
        if ((!r7.isEmpty()) == false) goto L15;
        ArrayList r16 = new ArrayList();
        Iterator r17 = r7.iterator();
    L12:
        if (r17.hasNext() == false) goto L14;
        r16.add(String.valueOf(((Number) r17.next()).intValue()));
        goto L12
    L14:
        r0.a("obj_type", r16);
        goto L15
    }
}
