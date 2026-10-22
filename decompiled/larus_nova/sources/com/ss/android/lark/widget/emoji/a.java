package com.ss.android.lark.widget.emoji;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f445831a = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.widget.emoji.a$a, reason: collision with other inner class name */
    public static final class C5392a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f445832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f445833b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Deque<Integer> f445834c;

        public C5392a() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5392a) == true) goto L8;
            return false;
        L8:
            C5392a r101 = (C5392a) r100;
            if (this.f445832a == r101.f445832a) goto L12;
            return false;
        L12:
            if (this.f445833b == r101.f445833b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f445834c, r101.f445834c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f445832a * 31;
            if (this.f445833b == false) goto L5;
            int r101 = 1231;
        L7:
            return ((r100 + r101) * 31) + this.f445834c.hashCode();
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "InnerNode(startIndex=" + this.f445832a + ", isEmoji=" + this.f445833b + ", codePoint=" + this.f445834c + ')';
        }

        public C5392a(int r100) {
            LinkedList r101 = new LinkedList();
            Intrinsics.checkNotNullParameter(r101, "codePoint");
            this.f445832a = r100;
            this.f445833b = false;
            this.f445834c = r101;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f445835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f445836b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f445837c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<Integer> f445838d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f445835a == r101.f445835a) goto L12;
            return false;
        L12:
            if (this.f445836b == r101.f445836b) goto L15;
            return false;
        L15:
            if (this.f445837c == r101.f445837c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f445838d, r101.f445838d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f445835a * 31) + this.f445836b) * 31;
            if (this.f445837c == false) goto L5;
            int r101 = 1231;
        L7:
            return ((r100 + r101) * 31) + this.f445838d.hashCode();
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "Node(startIndex=" + this.f445835a + ", length=" + this.f445836b + ", isEmoji=" + this.f445837c + ", codePoint=" + this.f445838d + ')';
        }

        public b(int r100, int r101, boolean r102, List<Integer> r103) {
            Intrinsics.checkNotNullParameter(r103, "codePoint");
            this.f445835a = r100;
            this.f445836b = r101;
            this.f445837c = r102;
            this.f445838d = r103;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final IntRange f445839g = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<Integer> f445840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<C5392a> f445841b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f445842c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f445843d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public C5392a f445844e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f445845f;

        /* JADX INFO: renamed from: com.ss.android.lark.widget.emoji.a$c$a, reason: collision with other inner class name */
        public static final class C5393a {
        }

        public static boolean b(int r100) {
            if (127488 <= r100) goto L5;
        L7:
            boolean r101 = false;
        L8:
            if (r101 == false) goto L10;
        L28:
            return true;
        L10:
            if (9472 <= r100) goto L12;
        L14:
            boolean r102 = false;
        L15:
            if (r102 == true) goto L28;
            if (r100 != 12336) goto L19;
        L26:
            boolean r103 = true;
        L27:
            if (r103 == true) goto L28;
            return false;
        L19:
            if (r100 == 169) goto L26;
            if (r100 == 174) goto L26;
            if (r100 == 8482) goto L26;
            r103 = false;
            goto L27
        L12:
            if (r100 >= 12288) goto L14;
            r102 = true;
            goto L15
        L5:
            if (r100 >= 131072) goto L7;
            r101 = true;
            goto L8
        }

        public final void a() {
            this.f445845f = 0;
            if ((!this.f445844e.f445834c.isEmpty()) == false) goto L6;
            ((ArrayList) this.f445841b).add(this.f445844e);
            this.f445844e = new C5392a(this.f445842c);
            return;
        }

        static {
            f445839g = new IntRange(917536, 917631);
        }

        public final void c() {
            this.f445844e.f445834c.add(Integer.valueOf(this.f445843d));
            this.f445842c += Character.charCount(this.f445843d);
        }

        public c() {
            this.f445840a = SetsKt.plus(SetsKt.setOf(new Integer[]{65038, 65039, 8419}), f445839g);
            this.f445841b = new ArrayList();
            this.f445844e = new C5392a(0);
        }
    }

    static {
    }

    public static boolean a(CharSequence r110, final int r111) {
        Intrinsics.checkNotNullParameter(r110, "str");
        Intrinsics.checkNotNullParameter(r110, "str");
        c r100 = new c();
        int r101 = r110.length();
        Intrinsics.checkNotNullParameter(r110, "str");
    L4:
        if (r100.f445842c >= r110.length()) goto L54;
        int r102 = Character.codePointAt(r110, r100.f445842c);
        r100.f445843d = r102;
        int r103 = r100.f445845f;
        if (r103 != 65536) goto L12;
        if (c.b(r102) == false) goto L10;
        r100.f445845f = 1;
        r100.c();
    L53:
        if (((ArrayList) r100.f445841b).size() < r101) goto L4;
    L10:
        Integer r104 = r100.f445844e.f445834c.removeLast();
        int r105 = r100.f445842c;
        Intrinsics.checkNotNull(r104);
        r100.f445842c = r105 - Character.charCount(r104.intValue());
        r100.a();
        goto L53
    L12:
        if (r103 != 257) goto L21;
        if (126976 > r102) goto L16;
        if (r102 >= 127488) goto L16;
        boolean r106 = true;
    L17:
        if (r106 == false) goto L19;
        r100.c();
        r100.f445844e.f445833b = true;
        r100.a();
        goto L53
    L19:
        r100.f445844e.f445833b = true;
        r100.a();
    L16:
        r106 = false;
        goto L17
    L21:
        if (r103 != 16) goto L27;
        if (r100.f445840a.contains(Integer.valueOf(r102)) == false) goto L25;
        r100.f445845f = 4097;
        r100.c();
        goto L53
    L25:
        r100.a();
        goto L53
    L27:
        if ((r103 & 1) != 0) goto L29;
        if (126976 > r102) goto L38;
        if (r102 >= 127488) goto L38;
        boolean r107 = true;
    L39:
        if (r107 == false) goto L41;
        r100.f445845f = 257;
        r100.c();
        goto L53
    L41:
        if (r102 >= 0) goto L43;
    L45:
        boolean r108 = false;
    L46:
        if (r108 == false) goto L49;
        r100.f445845f = 16;
        r100.c();
        goto L53
    L49:
        if (c.b(r102) == false) goto L51;
        r100.f445845f = 1;
        r100.c();
        goto L53
    L51:
        r100.c();
        r100.a();
        goto L53
    L43:
        if (r102 >= 58) goto L45;
        r108 = true;
    L38:
        r107 = false;
        goto L39
    L29:
        if (8205 != r102) goto L32;
        r100.f445845f = 65536;
        r100.c();
        goto L53
    L32:
        if (r100.f445840a.contains(Integer.valueOf(r102)) == false) goto L34;
        r100.f445845f = 4097;
        r100.c();
        goto L53
    L34:
        r100.f445844e.f445833b = true;
        r100.a();
    L54:
        int r112 = r100.f445845f;
        if (r112 != 0) goto L57;
    L60:
        List<C5392a> r113 = r100.f445841b;
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator r114 = ((ArrayList) r113).iterator();
    L62:
        if (r114.hasNext() == false) goto L68;
        C5392a r115 = (C5392a) r114.next();
        Iterator<T> r116 = r115.f445834c.iterator();
        int r117 = 0;
    L65:
        if (r116.hasNext() == false) goto L67;
        Integer r118 = (Integer) r116.next();
        Intrinsics.checkNotNull(r118);
        r117 = r117 + Character.charCount(r118.intValue());
        goto L65
    L67:
        r109.add(new b(r115.f445832a, r117, r115.f445833b, CollectionsKt.toList(r115.f445834c)));
        goto L62
    L68:
        Intrinsics.checkNotNullParameter(r109, "nodeList");
        int r119 = CollectionsKt.binarySearch$default(r109, 0, 0, new EmojiReader$isEmojiOfCharIndex$visionIdx$1(r111), 3, null);
        if (r119 < 0) goto L78;
        Intrinsics.checkNotNullParameter(r109, "nodeList");
        return ((b) ListProtector.get(r109, r119)).f445837c;
    L78:
        return false;
    L57:
        if ((r112 & 1) == 0) goto L59;
        r100.f445844e.f445833b = true;
    L59:
        r100.a();
        goto L60
    }
}
