package com.larus.business.markdown.impl.markwon;

import android.text.SpannableStringBuilder;
import android.view.View;
import io.noties.markwon.ext.tables.TableRowSpan2;
import io.noties.markwon.ext.tables.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<View, a> f320686a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SpannableStringBuilder f320687a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap<String, Integer> f320688b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f320689c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f320687a, r101.f320687a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f320688b, r101.f320688b) == true) goto L15;
            return false;
        L15:
            if (this.f320689c == r101.f320689c) goto L17;
            return false;
        L17:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v7 */
        public final int hashCode() {
            int r100 = this.f320687a.hashCode() * 31;
            HashMap<String, Integer> r101 = this.f320688b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r100 + r102) * 31;
            boolean r104 = this.f320689c;
            ?? r105 = r104;
            if (r104 == false) goto L10;
            r105 = 1;
        L10:
            return r103 + r105;
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "IncrementalTextSpanCache(markdownSpan=" + this.f320687a + ", nodeInfo=" + this.f320688b + ", hasTable=" + this.f320689c + ')';
        }

        public a(SpannableStringBuilder r100, HashMap<String, Integer> r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "markdownSpan");
            this.f320687a = r100;
            this.f320688b = r101;
            this.f320689c = r102;
        }
    }

    /* JADX INFO: loaded from: classes26.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f320690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f320691b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f320692c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f320690a, r101.f320690a) == true) goto L12;
            return false;
        L12:
            if (this.f320691b == r101.f320691b) goto L15;
            return false;
        L15:
            if (this.f320692c == r101.f320692c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f320690a.hashCode() * 31) + this.f320691b) * 31) + this.f320692c;
        }

        public final String toString() {
            return "SpanRecord(span=" + this.f320690a + ", start=" + this.f320691b + ", flags=" + this.f320692c + ')';
        }

        public b(Object r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "span");
            this.f320690a = r100;
            this.f320691b = r101;
            this.f320692c = r102;
        }
    }

    static {
        f320686a = Collections.synchronizedMap(new WeakHashMap());
    }

    public static SpannableStringBuilder a(SpannableStringBuilder r210, boolean r211) {
        SpannableStringBuilder r100 = new SpannableStringBuilder(r210);
        if (r211 == false) goto L41;
        IdentityHashMap r101 = new IdentityHashMap();
        Object[] r102 = r210.getSpans(0, r210.length(), s.class);
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L41;
        s r105 = (s) r102[r104];
        int r106 = r210.getSpanStart(r105);
        int r107 = r210.getSpanEnd(r105);
        if (r106 < 0) goto L39;
        if (r107 < r106) goto L39;
        IdentityHashMap r110 = new IdentityHashMap();
        IdentityHashMap r111 = new IdentityHashMap();
        r101.clear();
        Object[] r112 = r210.getSpans(r106, r107, TableRowSpan2.class);
        int r113 = r112.length;
        int r114 = 0;
    L11:
        if (r114 >= r113) goto L34;
        TableRowSpan2 r115 = (TableRowSpan2) r112[r114];
        int r108 = r210.getSpanStart(r115);
        Object[] r116 = r102;
        int r109 = r210.getSpanEnd(r115);
        if (r108 < r106) goto L32;
        if (r109 > r107) goto L32;
        r115.getClass();
        List<io.noties.markwon.ext.tables.g.b> r117 = r115.f492500n;
        Object r118 = r110.get(r117);
        if (r118 != null) goto L23;
        List<io.noties.markwon.ext.tables.g.b> r119 = r115.f492500n;
        ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r119, 10));
        Iterator r121 = r119.iterator();
    L19:
        if (r121.hasNext() == false) goto L21;
        io.noties.markwon.ext.tables.g.b r122 = (io.noties.markwon.ext.tables.g.b) r121.next();
        Iterator r123 = r121;
        io.noties.markwon.ext.tables.g.b r124 = TableRowSpan2.c(r122);
        r111.put(r122, r124);
        r120.add(r124);
        r121 = r123;
        goto L19
    L21:
        r110.put(r117, r120);
        r118 = r120;
    L23:
        List r212 = (List) r118;
        io.noties.markwon.ext.tables.g.b r125 = (io.noties.markwon.ext.tables.g.b) r111.get(r115.f492501o);
        if (r125 != null) goto L27;
        r125 = TableRowSpan2.c(r115.f492501o);
        r111.put(r115.f492501o, r125);
    L27:
        io.noties.markwon.ext.tables.g.b r213 = r125;
        ctc.a r126 = r115.f492502p;
        Object r127 = r101.get(r126);
        if (r127 != null) goto L31;
        ctc.a r128 = r115.f492502p;
        r128.getClass();
        ctc.a r129 = new ctc.a(r128.f465382c);
        r129.f465381b = Math.max(0.0f, r128.f465381b);
        r129.b(r128.f465380a);
        r101.put(r126, r129);
        r127 = r129;
    L31:
        ctc.a r214 = (ctc.a) r127;
        TableRowSpan2 r130 = new TableRowSpan2(r115.f492498l, r115.f492499m, r212, r213, r214);
        r130.f492488b = r115.f492488b;
        b(r210, r100, r115, r130);
    L33:
        r114 = r114 + 1;
        r102 = r116;
        r103 = r103;
        r106 = r106;
        r107 = r107;
    L32:
        r103 = r103;
        r106 = r106;
        r107 = r107;
        goto L33
    L34:
        Object[] r131 = r102;
        int r132 = r103;
        Iterator r133 = r101.entrySet().iterator();
    L36:
        if (r133.hasNext() == false) goto L38;
        Map.Entry r134 = (Map.Entry) r133.next();
        b(r210, r100, (ctc.a) r134.getKey(), (ctc.a) r134.getValue());
        goto L36
    L38:
        r105.getClass();
        b(r210, r100, r105, new s(r105.f492546a));
    L40:
        r104 = r104 + 1;
        r102 = r131;
        r103 = r132;
    L39:
        r131 = r102;
        r132 = r103;
    L41:
        return r100;
    }

    public static void b(SpannableStringBuilder r100, SpannableStringBuilder r101, Object r102, Object r103) {
        int r104 = r100.getSpanStart(r102);
        int r105 = r100.getSpanEnd(r102);
        if (r104 < 0) goto L7;
        if (r105 < r104) goto L8;
        int r106 = r100.getSpanFlags(r102);
        r101.removeSpan(r102);
        r101.setSpan(r103, r104, r105, r106);
        return;
    L8:
        return;
    }
}
