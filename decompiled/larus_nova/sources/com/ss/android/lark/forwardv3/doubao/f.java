package com.ss.android.lark.forwardv3.doubao;

import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.forwardv3.messageforward.MergeMessageForwardContent;
import com.ss.android.lark.forwardv3.messageforward.OneByOneMessageForwardContent;
import com.ss.android.lark.forwardv3.messageforward.SingleMessageForwardContent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class f {
    public static final int a(IForwardContent r100) {
        if ((r100 instanceof SingleMessageForwardContent) == true) goto L56;
        int r101 = 0;
        if ((r100 instanceof MergeMessageForwardContent) == false) goto L24;
        MergeMessageForwardContent r102 = (MergeMessageForwardContent) r100;
        if (r102.f425400e == true) goto L57;
        ArrayList<String> r103 = r102.f425398c;
        if ((r103 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r104 = r103.iterator();
    L17:
        if (r104.hasNext() == false) goto L55;
        if ((!StringsKt.isBlank((String) r104.next())) == false) goto L17;
        r101 = r101 + 1;
        if (r101 >= 0) goto L17;
        CollectionsKt.throwCountOverflow();
    L55:
        return r101;
    L13:
        if (r103.isEmpty() == false) goto L15;
    L39:
        return 0;
    L57:
        return 1;
    L24:
        if ((r100 instanceof OneByOneMessageForwardContent) == false) goto L39;
        ArrayList<String> r105 = ((OneByOneMessageForwardContent) r100).f425414c;
        if ((r105 instanceof Collection) == true) goto L28;
    L30:
        Iterator<T> r106 = r105.iterator();
    L32:
        if (r106.hasNext() == false) goto L55;
        if ((!StringsKt.isBlank((String) r106.next())) == false) goto L32;
        r101 = r101 + 1;
        if (r101 >= 0) goto L32;
        CollectionsKt.throwCountOverflow();
        goto L32
    L28:
        if (r105.isEmpty() == false) goto L30;
    L56:
        return 1;
    }
}
