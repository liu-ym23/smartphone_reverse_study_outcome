package com.ss.android.lark.chat.configurator;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f<I> implements com.ss.android.lark.chat.base.view.recycleview.b.InterfaceC4792b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f<I> f414740a = null;

    static {
        f414740a = new f();
    }

    public f() {
    }

    @Override // com.ss.android.lark.chat.base.view.recycleview.b.InterfaceC4792b
    public final boolean a(Object r100, Object r101) {
        y6b.c r102 = (y6b.c) r100;
        y6b.c r103 = (y6b.c) r101;
        String r104 = null;
        if (r102 == null) goto L5;
        String r105 = r102.f566482c;
    L6:
        if (r103 == null) goto L9;
        r104 = r103.f566482c;
    L9:
        return Intrinsics.areEqual(r105, r104);
    L5:
        r105 = null;
        goto L6
    }
}
