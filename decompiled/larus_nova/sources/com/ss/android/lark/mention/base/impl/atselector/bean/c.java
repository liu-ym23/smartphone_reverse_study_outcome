package com.ss.android.lark.mention.base.impl.atselector.bean;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class c {
    public static final String a(BaseAtBean r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof WantAtMemBean) == false) goto L6;
        String r101 = ((WantAtMemBean) r100).chatterInfo.f431706l;
    L8:
        Intrinsics.checkNotNull(r101);
        Character r102 = StringsKt.firstOrNull(r101);
        if (r102 == null) goto L12;
        String r103 = r102.toString();
        if (r103 == null) goto L12;
        return r103;
    L12:
        return "";
    L6:
        if ((r100 instanceof SearchBean) == false) goto L12;
        r101 = ((SearchBean) r100).chatterInfo.f431706l;
        goto L8
    }
}
