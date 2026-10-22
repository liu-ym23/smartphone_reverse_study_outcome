package com.bytedance.ee.bear.office.list.adapter;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements nj5.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Integer f235707a;

    public a(Integer r100) {
        this.f235707a = r100;
    }

    @Override // nj5.e
    public final String transform(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        b r101 = b.f235722a;
        Integer r102 = this.f235707a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "url");
        boolean r103 = StringsKt.isBlank(r100);
        String r104 = r100;
        if (r103 == false) goto L31;
    L26:
        s45.i.f540569a.getClass();
        Intrinsics.checkNotNullParameter(r104, "rawUrl");
        if (StringsKt.isBlank(r104) == false) goto L30;
        return r104;
    L30:
        return s45.i.a(r104);
    L31:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L19
        t45.c r106 = s45.p.a();     // Catch: Throwable -> L19
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type com.bytedance.ee.bear.domain.container.ISpaceKitUrlHelper");     // Catch: Throwable -> L19
        String r107 = r106.T6(r100, r102);     // Catch: Throwable -> L19
        if (r107 != null) goto L8;
    L11:
        boolean r108 = true;
    L12:
        if (r108 == true) goto L14;
        String r109 = r107;
    L15:
        if (r109 != null) goto L17;
        r109 = r100;
    L17:
        Object r110 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L19
    L21:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 != null) goto L24;
        Object r112 = r110;
    L25:
        r104 = (String) r112;
        goto L26
    L24:
        tt5.a.l("OfficeCopyLinkUrlTransformers", "concat office copy link url for doubao failed", r111);
        r112 = r100;
        goto L25
    L14:
        r109 = null;
        goto L15
    L8:
        if (StringsKt.isBlank(r107) == true) goto L11;
        r108 = false;
    L19:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }
}
