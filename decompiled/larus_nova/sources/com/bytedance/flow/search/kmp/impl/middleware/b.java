package com.bytedance.flow.search.kmp.impl.middleware;

import com.bytedance.flow.search.kmp.api.model.FlowSearchData;
import com.bytedance.flow.search.kmp.api.model.payload.TitlePayload;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f243585a = 0;

    static {
    }

    public static String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "domain");
        switch(r100.hashCode()) {
            case 97735: goto L18;
            case 95852938: goto L14;
            case 951526432: goto L10;
            case 954925063: goto L6;
            default: goto L21;
        };
    L21:
        return "";
    L6:
        if (r100.equals("message") == false) goto L21;
        int r101 = com.bytedance.flow.search.kmp.impl.util.f.f243669a;
        return yg9.a.a(new yg9.b(R.string.larus_LarkIM_Search_Message_Tab));
    L10:
        if (r100.equals("contact") == false) goto L21;
        return com.bytedance.flow.search.kmp.impl.util.f.a();
    L14:
        if (r100.equals("drive") == false) goto L21;
        int r102 = com.bytedance.flow.search.kmp.impl.util.f.f243669a;
        return yg9.a.a(new yg9.b(R.string.larus_LarkIM_Search_Drive_Tab));
    L18:
        if (r100.equals("bot") == false) goto L21;
        int r103 = com.bytedance.flow.search.kmp.impl.util.f.f243669a;
        return yg9.a.a(new yg9.b(R.string.larus_LarkIM_Search_Bots_Tab));
    }

    public static FlowSearchData a(String r100, boolean r101) {
        if (r101 == false) goto L24;
        Intrinsics.checkNotNullParameter(r100, "domain");
        switch(r100.hashCode()) {
            case 97735: goto L20;
            case 95852938: goto L16;
            case 951526432: goto L12;
            case 954925063: goto L8;
            default: goto L23;
        };
    L23:
        String r102 = "";
    L26:
        return new FlowSearchData(r100, 108, new TitlePayload(r102));
    L8:
        if (r100.equals("message") == false) goto L23;
        r102 = com.bytedance.flow.search.kmp.impl.util.f.c();
        goto L26
    L12:
        if (r100.equals("contact") == false) goto L23;
        r102 = com.bytedance.flow.search.kmp.impl.util.f.c();
        goto L26
    L16:
        if (r100.equals("drive") == false) goto L23;
        int r103 = com.bytedance.flow.search.kmp.impl.util.f.f243669a;
        r102 = yg9.a.a(new yg9.b(R.string.larus_LarkIM_Search_RecentAccess_Option));
        goto L26
    L20:
        if (r100.equals("bot") == false) goto L23;
        r102 = com.bytedance.flow.search.kmp.impl.util.f.c();
        goto L26
    L24:
        r102 = b(r100);
        goto L26
    }
}
