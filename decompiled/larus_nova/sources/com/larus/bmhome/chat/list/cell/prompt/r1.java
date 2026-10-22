package com.larus.bmhome.chat.list.cell.prompt;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class r1 implements ICoreInputAbility.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s1 f305687a;

    public r1(s1 r100) {
        this.f305687a = r100;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility.e
    public final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility.e
    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        s1 r101 = this.f305687a;
        if (r101.f305697g == true) goto L6;
        return;
    L6:
        if (r101.e() == true) goto L10;
        if (this.f305687a.f305699i == true) goto L10;
    L12:
        boolean r102 = false;
    L13:
        s1 r103 = this.f305687a;
        if (r102 == r103.f305696f) goto L16;
        r103.c(r102, true);
    L16:
        if (r102 == true) goto L19;
        this.f305687a.f305699i = false;
        return;
    L19:
        return;
    L10:
        if ((!StringsKt.isBlank(r100)) == false) goto L12;
        r102 = true;
        goto L13
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility.e
    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
    }
}
