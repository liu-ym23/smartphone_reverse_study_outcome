package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class z implements com.larksuite.framework.section.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f443908a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f443908a, ((z) r100).f443908a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f443908a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "SummaryInlineInfo(chatId=" + this.f443908a + ')';
    }

    public z(String r100) {
        this.f443908a = r100;
    }
}
