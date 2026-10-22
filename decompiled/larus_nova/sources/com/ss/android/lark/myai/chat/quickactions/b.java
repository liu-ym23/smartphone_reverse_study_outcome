package com.ss.android.lark.myai.chat.quickactions;

import android.text.SpannableStringBuilder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f432865a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final QuickActionParamSpan f432866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f432867b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f432868c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f432866a, r101.f432866a) == true) goto L12;
            return false;
        L12:
            if (this.f432867b == r101.f432867b) goto L15;
            return false;
        L15:
            if (this.f432868c == r101.f432868c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f432866a.hashCode() * 31) + this.f432867b) * 31) + this.f432868c;
        }

        public final String toString() {
            return "QuickActionParamSpanInfo(span=" + this.f432866a + ", start=" + this.f432867b + ", end=" + this.f432868c + ')';
        }

        public a(QuickActionParamSpan r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "span");
            this.f432866a = r100;
            this.f432867b = r101;
            this.f432868c = r102;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.myai.chat.quickactions.b$b, reason: collision with other inner class name */
    public static final class C5146b<T> implements Comparator {
        public C5146b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((a) r100).f432867b), Integer.valueOf(((a) r101).f432867b));
        }
    }

    static {
    }

    public static Map a(SpannableStringBuilder r110) {
        Intrinsics.checkNotNullParameter(r110, "text");
        LinkedHashMap r100 = new LinkedHashMap();
        Object[] r101 = r110.getSpans(0, r110.length(), QuickActionParamSpan.class);
        ArrayList r102 = new ArrayList(r101.length);
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        QuickActionParamSpan r105 = (QuickActionParamSpan) r101[r104];
        r102.add(new a(r105, r110.getSpanStart(r105), r110.getSpanEnd(r105)));
        r104 = r104 + 1;
        goto L3
    L5:
        ArrayList r106 = new ArrayList();
        Iterator r107 = r102.iterator();
    L7:
        if (r107.hasNext() == false) goto L17;
        Object r108 = r107.next();
        a r109 = (a) r108;
        int r111 = r109.f432867b;
        if (r111 < 0) goto L14;
        int r112 = r109.f432868c;
        if (r112 < 0) goto L14;
        if (r112 < r111) goto L14;
        boolean r113 = true;
    L15:
        if (r113 == false) goto L7;
        r106.add(r108);
    L14:
        r113 = false;
        goto L15
    L17:
        List r114 = CollectionsKt.sortedWith(r106, new C5146b());
        int r115 = r114.size();
        int r116 = 0;
    L18:
        if (r116 >= r115) goto L30;
        a r117 = (a) ListProtector.get(r114, r116);
        r116 = r116 + 1;
        a r118 = (a) CollectionsKt.getOrNull(r114, r116);
        if (r118 == null) goto L22;
        int r119 = r118.f432867b;
    L24:
        if (r117.f432868c == r119) goto L25;
        IntRange r120 = new IntRange(r117.f432868c, r119);
        if (((QuickActionParamPlaceholderSpan) ArraysKt.getOrNull(r110.getSpans(r120.getFirst(), r120.getLast(), QuickActionParamPlaceholderSpan.class), 0)) != null) goto L28;
        r100.put(r117.f432866a.f432850a, r110.subSequence(r120.getFirst(), r120.getLast()));
        goto L18
    L28:
        r100.put(r117.f432866a.f432850a, "");
        goto L18
    L25:
        r100.put(r117.f432866a.f432850a, "");
        goto L18
    L22:
        r119 = r110.length();
        goto L24
    L30:
        return r100;
    }
}
