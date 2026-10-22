package com.ss.android.lark.widget.richtext.utils;

import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f448388a = 0;

    static {
    }

    public static List a(RichText r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "richText");
        e r102 = new e(r101);
        Intrinsics.checkNotNullParameter(r100, "richText");
        List<String> r103 = r100.getElementIds();
        Map<String, RichTextElement> r104 = r100.getElements().getDictionary();
        AtomicInteger r105 = new AtomicInteger(0);
        ArrayList r106 = new ArrayList();
        Intrinsics.checkNotNull(r103);
        Iterator<T> r107 = r103.iterator();
    L4:
        if (r107.hasNext() == false) goto L9;
        RichTextElement r108 = r104.get((String) r107.next());
        if (r108 == null) goto L4;
        Intrinsics.checkNotNull(r104);
        r106.addAll(r102.a(r108, r104, r105));
        goto L4
    L9:
        return r106;
    }
}
