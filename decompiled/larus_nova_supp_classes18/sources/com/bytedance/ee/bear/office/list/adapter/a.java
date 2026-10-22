package com.bytedance.ee.bear.office.list.adapter;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements nj5.e {
    public final /* synthetic */ Integer a;

    public a(Integer r1) {
        this.a = r1;
    }

    @Override // nj5.e
    public final String transform(String r4) {
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_URL);
        b r1 = b.a;
        Integer r2 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_URL);
        boolean r0 = StringsKt.isBlank(r4);
        String r5 = r4;
        if (r0 == false) goto L31;
    L26:
        s45.i.a.getClass();
        Intrinsics.checkNotNullParameter(r5, "rawUrl");
        if (StringsKt.isBlank(r5) == false) goto L30;
        return r5;
    L30:
        return s45.i.a(r5);
    L31:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L19
        t45.c r6 = s45.p.a();     // Catch: Throwable -> L19
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.bytedance.ee.bear.domain.container.ISpaceKitUrlHelper");     // Catch: Throwable -> L19
        String r7 = r6.T6(r4, r2);     // Catch: Throwable -> L19
        if (r7 != null) goto L8;
    L11:
        boolean r8 = true;
    L12:
        if (r8 == true) goto L14;
        String r9 = r7;
    L15:
        if (r9 != null) goto L17;
        r9 = r4;
    L17:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L19
    L21:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 != null) goto L24;
        Object r12 = r10;
    L25:
        r5 = (String) r12;
        goto L26
    L24:
        tt5.a.l("OfficeCopyLinkUrlTransformers", "concat office copy link url for doubao failed", r11);
        r12 = r4;
        goto L25
    L14:
        r9 = null;
        goto L15
    L8:
        if (StringsKt.isBlank(r7) == true) goto L11;
        r8 = false;
    L19:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }
}
