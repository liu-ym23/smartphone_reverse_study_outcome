package com.ss.android.lark.chat.message.menu.v2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class l implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MessageActionPanel f415758a;

    public l(MessageActionPanel r100) {
        this.f415758a = r100;
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.o0
    public final void a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "reactionKey");
        o0 r102 = this.f415758a.f415564d;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }
}
