package com.larus.bmhome.chat.component.bottom.core;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class j7 implements Function1<ICoreInputAbility.e, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CharSequence f299260a;

    public j7(CharSequence r100) {
        this.f299260a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(ICoreInputAbility.e r100) {
        ICoreInputAbility.e r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "$this$intercept");
        CharSequence r102 = this.f299260a;
        if (r102 == null) goto L5;
        String r103 = r102.toString();
    L6:
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        r101.j(r103);
        return Boolean.FALSE;
    L5:
        r103 = null;
        goto L6
    }
}
