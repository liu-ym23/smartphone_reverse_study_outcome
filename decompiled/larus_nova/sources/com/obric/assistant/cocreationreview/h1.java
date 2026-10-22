package com.obric.assistant.cocreationreview;

import java.util.List;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class h1 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f387296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f387297b;

    public /* synthetic */ h1(String r100, String r101) {
        this.f387296a = r100;
        this.f387297b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r110) {
        String r100 = this.f387296a;
        String r101 = this.f387297b;
        a5 r102 = (a5) r110;
        Set<String> r111 = CocreationReviewActivity.P1;
        Intrinsics.checkNotNullParameter(r102, "current");
        Set<String> r112 = r102.f387185c;
        List<Integer> r103 = t3.f387735a;
        Intrinsics.checkNotNullParameter(r112, "currentReasons");
        Intrinsics.checkNotNullParameter(r100, "reason");
        if (r112.contains(r100) == false) goto L5;
        Set r113 = SetsKt.minus(r112, r100);
    L6:
        Set r104 = r113;
        int r114 = s3.f387719a;
        s3.b("draft.action", "toggleReason recordId=" + r101 + ", reason=" + r100 + ", selected=" + r104.contains(r100) + ", reasonCount=" + r104.size());
        return a5.a(r102, null, r104, null, false, 0, null, 203);
    L5:
        r113 = SetsKt.plus(r112, r100);
        goto L6
    }
}
