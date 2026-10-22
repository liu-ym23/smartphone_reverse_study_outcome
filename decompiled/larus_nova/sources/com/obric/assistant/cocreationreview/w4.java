package com.obric.assistant.cocreationreview;

import com.obric.assistant.cocreationreview.a;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public abstract class w4<R extends a> implements n5<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l5 f387770a;

    public String l(R r100) {
        Intrinsics.checkNotNullParameter(r100, "record");
        return null;
    }

    public w4(l5 r100) {
        Intrinsics.checkNotNullParameter(r100, "moduleMeta");
        this.f387770a = r100;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public boolean a(R r100) {
        Intrinsics.checkNotNullParameter(r100, "record");
        return false;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public String e(R r100) {
        Intrinsics.checkNotNullParameter(r100, "record");
        return null;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public boolean g(R r100) {
        Intrinsics.checkNotNullParameter(r100, "record");
        return false;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public List<d> i(R r110) {
        Intrinsics.checkNotNullParameter(r110, "record");
        d[] r100 = new d[2];
        r100[0] = new d(k(r110), CardTemplateTagTone.NEUTRAL, Integer.valueOf(this.f387770a.f387362e), Integer.valueOf(this.f387770a.f387361d), 16);
        String r111 = l(r110);
        d r101 = null;
        if (r111 != null) goto L5;
    L10:
        r100[1] = r101;
        return CollectionsKt.listOfNotNull(r100);
    L5:
        if ((!StringsKt.isBlank(r111)) == false) goto L7;
        String r102 = r111;
    L8:
        if (r102 == null) goto L10;
        r101 = new d(r102, CardTemplateTagTone.ACCENT, null, null, 28);
        goto L10
    L7:
        r102 = null;
        goto L8
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public int j(R r100) {
        Intrinsics.checkNotNullParameter(r100, "record");
        return 0;
    }

    public String k(R r100) {
        Intrinsics.checkNotNullParameter(r100, "record");
        return this.f387770a.f387359b;
    }
}
