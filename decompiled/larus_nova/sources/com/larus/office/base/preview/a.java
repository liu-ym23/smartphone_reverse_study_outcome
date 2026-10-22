package com.larus.office.base.preview;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a {
    public static final ArrayList<DocMeta> a(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(r100.getSerializable(r101));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == false) goto L11;
        r103 = null;
    L11:
        if ((r103 instanceof List) == false) goto L13;
        List r104 = (List) r103;
    L14:
        if (r104 != null) goto L16;
        return null;
    L16:
        ArrayList r105 = new ArrayList();
        Iterator r106 = r104.iterator();
    L18:
        if (r106.hasNext() == false) goto L23;
        Object r107 = r106.next();
        if ((r107 instanceof DocMeta) == false) goto L18;
        r105.add(r107);
        goto L18
    L23:
        if (r105.isEmpty() == false) goto L26;
        return null;
    L26:
        return new ArrayList(r105);
    L13:
        r104 = null;
    L5:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
