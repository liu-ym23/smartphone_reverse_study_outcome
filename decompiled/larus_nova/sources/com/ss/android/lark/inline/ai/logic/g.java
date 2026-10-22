package com.ss.android.lark.inline.ai.logic;

import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g {
    public static final h a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (h) CollectionsKt.getOrNull(r100.f427291d, r100.f427292e);
    }

    public static final String b(f r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        h r101 = (h) CollectionsKt.getOrNull(r100.f427291d, r100.f427292e);
        if (r101 == null) goto L6;
        String r102 = r101.f427295a;
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public static final String c(f r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return "InlineAIState(status=" + r100.f427288a + ", conversationId='" + r100.f427289b + "', promptGroups=" + r100.f427290c + ", taskHistory=" + r100.f427291d + ", currentTaskIndex=" + r100.f427292e + ", userInputText=" + r100.f427293f + ", showKeyboard=" + r100.f427294g + ')';
    }

    public static final String d(j r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof j.a) == false) goto L6;
        return ((j.a) r100).f427308a;
    L6:
        if ((r100 instanceof j.b) == false) goto L10;
        return ((j.b) r100).f427311c;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
