package com.ss.android.lark.chat.message.menu.v2;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class o implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MessageActionPanel f415765a;

    public o(MessageActionPanel r100) {
        this.f415765a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f415765a.i(false);
        MessageActionPanel r101 = this.f415765a;
        View r102 = r101.D;
        View r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("secondLevelActionsContainer");
        r102 = null;
    L5:
        View r104 = this.f415765a.C;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("firstLevelActionsContainer");
    L9:
        r101.o(r102, r103);
        return;
    L8:
        r103 = r104;
        goto L9
    }
}
