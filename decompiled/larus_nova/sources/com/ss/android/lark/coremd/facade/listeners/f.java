package com.ss.android.lark.coremd.facade.listeners;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.ss.android.lark.coremd.span.BlockQuoteSpan;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.codeblock.preview.CodeBlockV2Span;
import com.ss.android.lark.widget.span.e0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<Class<? extends Object>> f419734a = null;

    static {
        f419734a = SetsKt.setOf(new Class[]{ImageSpan.class, CodeBlockV2Span.class, y9b.a.class, BlockQuoteSpan.class});
    }

    public static int a(SpannableStringBuilder r100, Class r101) {
        Object[] r102 = r100.getSpans(0, r100.length(), r101);
        Intrinsics.checkNotNull(r102);
        int r103 = 1;
        if (r102.length != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L10;
        return -1;
    L10:
        if (r102.length != 0) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == true) goto L27;
        Object r106 = r102[0];
        int r107 = ArraysKt.getLastIndex(r102);
        if (r107 == 0) goto L25;
        int r108 = r100.getSpanEnd(r106);
        if (1 > r107) goto L25;
    L19:
        Object r109 = r102[r103];
        int r110 = r100.getSpanEnd(r109);
        if (r108 >= r110) goto L22;
        r106 = r109;
        r108 = r110;
    L22:
        if (r103 == r107) goto L25;
        r103 = r103 + 1;
    L25:
        return r100.getSpanEnd(r106);
    L27:
        throw new NoSuchElementException();
    L12:
        r105 = false;
        goto L13
    L5:
        r104 = false;
        goto L6
    }

    public static void b(SpannableStringBuilder r100, Context r110) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Iterator<T> r101 = f419734a.iterator();
        if (r101.hasNext() == false) goto L39;
        int r102 = a(r100, (Class) r101.next());
    L6:
        if (r101.hasNext() == false) goto L10;
        int r103 = a(r100, (Class) r101.next());
        if (r102 >= r103) goto L6;
        r102 = r103;
        goto L6
    L10:
        boolean r104 = false;
        if (r102 != (-1)) goto L14;
    L35:
        if (r104 == false) goto L48;
        r100.append("\n\n");
        e0.a r105 = new e0.a();
        r105.f448672a = zz7.b.g(r110, 5);
        r100.setSpan(new e0(r105), r100.length() - 1, r100.length(), 33);
        return;
    L48:
        return;
    L14:
        if (r102 == r100.length()) goto L34;
        x9b.e[] r106 = (x9b.e[]) r100.getSpans(r102, r100.length(), x9b.e.class);
        if (r106.length != 0) goto L19;
        boolean r107 = true;
    L20:
        if (r107 == true) goto L35;
        ArrayList r108 = new ArrayList(r106.length);
        int r109 = r106.length;
        int r111 = 0;
    L23:
        if (r111 >= r109) goto L25;
        x9b.e r112 = r106[r111];
        r108.add(TuplesKt.to(Integer.valueOf(r100.getSpanStart(r112)), Integer.valueOf(r100.getSpanEnd(r112))));
        r111 = r111 + 1;
        goto L23
    L25:
        Iterator r113 = CollectionsKt.sortedWith(r108, new e()).iterator();
    L27:
        if (r113.hasNext() == false) goto L33;
        Pair r114 = (Pair) r113.next();
        if (((Number) r114.getFirst()).intValue() > r102) goto L35;
        r102 = Math.max(r102, ((Number) r114.getSecond()).intValue());
        goto L27
    L33:
        if (r102 < r100.length()) goto L35;
    L19:
        r107 = false;
    L34:
        r104 = true;
        goto L35
    L39:
        throw new NoSuchElementException();
    }
}
