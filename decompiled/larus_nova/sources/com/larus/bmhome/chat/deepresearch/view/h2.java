package com.larus.bmhome.chat.deepresearch.view;

import com.larus.im.bean.message.SearchImageInfo;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class h2 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchImageInfo f302393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j2 f302394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f302395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f302396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f302397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f302398f;

    public /* synthetic */ h2(SearchImageInfo r100, j2 r101, String r102, int r103, int r104, int r105) {
        this.f302393a = r100;
        this.f302394b = r101;
        this.f302395c = r102;
        this.f302396d = r103;
        this.f302397e = r104;
        this.f302398f = r105;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r110) {
        final SearchImageInfo r100 = this.f302393a;
        final j2 r101 = this.f302394b;
        final String r102 = this.f302395c;
        final int r103 = this.f302396d;
        final int r104 = this.f302397e;
        final int r105 = this.f302398f;
        ii9.b r111 = (ii9.b) r110;
        Intrinsics.checkNotNullParameter(r111, "$this$expose");
        Function0<String> r106 = new q1(r100);
        r111.getClass();
        Intrinsics.checkNotNullParameter(r106, "cellId");
        r111.f490008a = r106;
        r111.a(CollectionsKt.listOf(new Integer[]{0, 1, 2}));
        float[] r107 = {0.5f};
        Intrinsics.checkNotNullParameter(r107, "percentages");
        r111.f490010c = r107;
        r111.f490012e = true;
        Function1<? super Float, Unit> r108 = new r1(r101, r100, r102, r103, r104, r105);
        Intrinsics.checkNotNullParameter(r108, "block");
        r111.f490009b = r108;
        return Unit.INSTANCE;
    }
}
