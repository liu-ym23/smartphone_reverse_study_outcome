package com.ss.android.lark.todo.impl.features.common.richtext2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class h extends com.ss.android.lark.keyboard.edittext2.edittors.at.common.b {
    public h() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.common.b, com.ss.android.lark.keyboard.edittext2.edittors.at.c
    public final com.ss.android.lark.keyboard.edittext2.edittors.at.a<hob.c> c(com.ss.android.lark.keyboard.edittext2.edittors.a r100, hob.c r101) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        Intrinsics.checkNotNullParameter(r101, "data");
        return new TodoCommonAtSpanHolder(r100, r101);
    }
}
