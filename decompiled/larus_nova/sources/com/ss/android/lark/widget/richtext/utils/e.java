package com.ss.android.lark.widget.richtext.utils;

import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f448392a;

    public e(boolean r100) {
        this.f448392a = r100;
    }

    public final List<jec.c> a(RichTextElement r100, Map<String, RichTextElement> r101, AtomicInteger r102) {
        ArrayList r103 = new ArrayList();
        RichTextElement.RichTextTag r104 = r100.getTag();
        List<String> r105 = r100.getChildIds();
        Intrinsics.checkNotNull(r105);
        Iterator<T> r106 = r105.iterator();
    L4:
        if (r106.hasNext() == false) goto L10;
        RichTextElement r107 = r101.get((String) r106.next());
        if (r107 == null) goto L4;
        r103.addAll(a(r107, r101, r102));
        goto L4
    L10:
        if (r104 != RichTextElement.RichTextTag.DOCS) goto L13;
        return r103;
    L13:
        if (r102.get() == 0) goto L15;
    L17:
        r102.incrementAndGet();
        if (r100.getTag() == RichTextElement.RichTextTag.ANCHOR) goto L20;
    L22:
        RichTextElement.RichTextProperty r108 = r100.getProperty();
        Intrinsics.checkNotNull(r108);
        RichTextElement r109 = RichTextElementCreator.h(r108);
        r109.setStyle(r100.getStyle());
        RichTextElement r110 = r109;
    L24:
        return CollectionsKt.listOf(new jec.c(r110, r103));
    L20:
        if (this.f448392a == false) goto L22;
        Map<String, String> r111 = r100.getStyle();
        r110 = RichTextElementCreator.e(((RichTextElement.AnchorProperty) r100.getProperty()).getHref());
        r110.setStyle(r111);
        goto L24
    L15:
        if (r104 != RichTextElement.RichTextTag.PARAGRAPH) goto L17;
        return r103;
    }
}
