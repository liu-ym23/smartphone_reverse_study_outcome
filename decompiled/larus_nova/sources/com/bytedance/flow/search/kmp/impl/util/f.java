package com.bytedance.flow.search.kmp.impl.util;

import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f243669a = 0;

    static {
    }

    public static String a() {
        return yg9.a.a(new yg9.b(R.string.larus_globalSearch_searchPage_tab_contacts));
    }

    public static String c() {
        return yg9.a.a(new yg9.b(R.string.larus_LarkIM_Search_RecentChats_Title));
    }

    public static String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "domainName");
        String r101 = yg9.a.a(new yg9.b(R.string.larus_globalSearch_searchPage_ctn_viewAll));
        if (Intrinsics.areEqual(r100, a()) == true) goto L5;
        return r101;
    L5:
        boolean r102 = false;
        int r103 = 0;
    L7:
        if (r103 >= r101.length()) goto L35;
        char r104 = r101.charAt(r103);
        if (19968 <= r104) goto L11;
    L13:
        boolean r105 = false;
    L14:
        if (r105 == false) goto L16;
    L31:
        boolean r106 = true;
    L32:
        if (r106 == true) goto L33;
        r103 = r103 + 1;
        goto L7
    L33:
        r102 = true;
        goto L35
    L16:
        if (12352 <= r104) goto L18;
    L20:
        boolean r107 = false;
    L21:
        if (r107 == true) goto L31;
        if (44032 <= r104) goto L25;
    L27:
        boolean r108 = false;
    L28:
        if (r108 == true) goto L31;
        r106 = false;
        goto L32
    L25:
        if (r104 >= 55216) goto L27;
        r108 = true;
        goto L28
    L18:
        if (r104 >= 12544) goto L20;
        r107 = true;
        goto L21
    L11:
        if (r104 >= 40960) goto L13;
        r105 = true;
    L35:
        if (r102 == false) goto L38;
        return r101 + r100;
    L38:
        return r101 + ' ' + r100;
    }
}
