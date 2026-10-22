package com.obric.assistant.cocreationreview;

import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class j1 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CocreationReviewActivity f387326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f387327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Vote f387328c;

    public /* synthetic */ j1(CocreationReviewActivity r100, a r101, Vote r102) {
        this.f387326a = r100;
        this.f387327b = r101;
        this.f387328c = r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        CocreationReviewActivity r100 = this.f387326a;
        a r101 = this.f387327b;
        Vote r102 = this.f387328c;
        Set<String> r103 = CocreationReviewActivity.P1;
        r100.D2(r101, r102);
        return Unit.INSTANCE;
    }
}
