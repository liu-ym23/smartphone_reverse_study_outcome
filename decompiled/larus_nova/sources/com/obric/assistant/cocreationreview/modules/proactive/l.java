package com.obric.assistant.cocreationreview.modules.proactive;

import com.obric.assistant.cocreationreview.a5;
import com.obric.assistant.cocreationreview.l5;
import com.obric.assistant.cocreationreview.w4;
import com.obric.assistant.cocreationreview.y4;
import com.obric.assistant.cocreationreview.z4;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class l extends w4<q> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f387486b = null;

    static {
        f387486b = new l();
    }

    public l() {
        l5 r100 = e.f387469a;
        super(i.a());
    }

    @Override // com.obric.assistant.cocreationreview.w4, com.obric.assistant.cocreationreview.n5
    public final boolean a(com.obric.assistant.cocreationreview.a r100) {
        Intrinsics.checkNotNullParameter((q) r100, "record");
        return true;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String b(com.obric.assistant.cocreationreview.a r100) {
        q r101 = (q) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return r101.f387515y;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final List c(com.obric.assistant.cocreationreview.a r100) {
        Intrinsics.checkNotNullParameter((q) r100, "record");
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String d(com.obric.assistant.cocreationreview.a r100) {
        q r101 = (q) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return r101.f387497g;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String h(com.obric.assistant.cocreationreview.a r100) {
        q r101 = (q) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return r101.f387500j;
    }

    @Override // com.obric.assistant.cocreationreview.w4
    public final String k(com.obric.assistant.cocreationreview.a r100) {
        q r101 = (q) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return r101.f387498h;
    }

    @Override // com.obric.assistant.cocreationreview.w4
    public final String l(com.obric.assistant.cocreationreview.a r100) {
        Intrinsics.checkNotNullParameter((q) r100, "record");
        return null;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final z4.a f(com.obric.assistant.cocreationreview.a r110, a5 r111) {
        final q r112 = (q) r110;
        Intrinsics.checkNotNullParameter(r112, "record");
        Intrinsics.checkNotNullParameter(r111, "feedback");
        String r100 = r112.f387491a;
        StringBuilder r101 = new StringBuilder();
        l5 r102 = e.f387469a;
        r101.append(i.a().f387359b);
        r101.append("详情");
        String r103 = r101.toString();
        Intrinsics.checkNotNullParameter(r112, "record");
        String r104 = r112.f387500j;
        Intrinsics.checkNotNullParameter(r112, "record");
        String r105 = null;
        com.obric.assistant.cocreationreview.e r106 = new com.obric.assistant.cocreationreview.e(r104, null, r112.f387497g);
        y4[] r107 = new y4[3];
        r107[0] = new y4.a("建议内容", null, new k(r112));
        r107[1] = new y4.c("推荐原因", r112.f387501k);
        String r113 = r112.f387507q;
        if (r113 == null) goto L5;
        r105 = StringsKt.trim(r113).toString();
    L5:
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        if (StringsKt.isBlank(r105) == false) goto L10;
        r105 = "暂无依据";
    L10:
        r107[2] = new y4.c("依据", r105);
        return new z4.a(r100, r103, r106, r111, CollectionsKt.listOf(r107), null, null, 224);
    }
}
