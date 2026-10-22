package com.larus.bmhome.chat.component.bottom.core.inputtext;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes25.dex */
public final class p1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f299015f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f299016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f299017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<n1> f299018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f299019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<n1> f299020e;

    public static final class a {
        public static p1 a(String r110, Continuation r111) {
            CoroutineContext r112 = r111.getContext();
            StringBuilder r100 = new StringBuilder();
            StringBuilder r101 = new StringBuilder();
            ArrayList r102 = new ArrayList();
            ArrayList r103 = new ArrayList();
            int r104 = 0;
        L4:
            if (r104 >= r110.length()) goto L40;
            JobKt.ensureActive(r112);
            int r105 = Character.charCount(r110.codePointAt(r104)) + r104;
            n1 r106 = new n1(r104, r105);
            if ((r105 - r104) != 1) goto L19;
            char r107 = r110.charAt(r104);
            if (19968 > r107) goto L14;
            if (r107 > 40869) goto L14;
            if (ru7.c.b(r107) <= 0) goto L14;
        L15:
            boolean r108 = true;
        L17:
            if (r108 == false) goto L19;
            boolean r109 = true;
        L20:
            if (r109 == false) goto L22;
            String r113 = ru7.c.c(r110.charAt(r104));
        L23:
            Intrinsics.checkNotNull(r113);
            String r114 = r113.toLowerCase(Locale.ROOT);
            StringBuilder r115 = new StringBuilder();
            int r116 = 0;
        L25:
            if (r116 >= r114.length()) goto L30;
            char r117 = r114.charAt(r116);
            if (CharsKt.isWhitespace(r117) == true) goto L29;
            r115.append(r117);
        L29:
            r116 = r116 + 1;
            goto L25
        L30:
            String r118 = r115.toString();
            r100.append(r118);
            int r119 = r118.length();
            int r120 = 0;
        L31:
            if (r120 >= r119) goto L33;
            r102.add(r106);
            r120 = r120 + 1;
            goto L31
        L33:
            if (r109 == false) goto L35;
            r118 = StringsKt.take(r118, 1);
        L35:
            r101.append(r118);
            int r121 = r118.length();
            int r122 = 0;
        L36:
            if (r122 >= r121) goto L38;
            r103.add(r106);
            r122 = r122 + 1;
            goto L36
        L38:
            r104 = r105;
            goto L4
        L22:
            r113 = r110.substring(r104, r105);
        L14:
            if (12295 == r107) goto L15;
            r108 = false;
        L19:
            r109 = false;
            goto L20
        L40:
            return new p1(r110, r100.toString(), r102, r101.toString(), r103);
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p1) == true) goto L8;
        return false;
    L8:
        p1 r101 = (p1) r100;
        if (Intrinsics.areEqual(this.f299016a, r101.f299016a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f299017b, r101.f299017b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f299018c, r101.f299018c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f299019d, r101.f299019d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f299020e, r101.f299020e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f299016a.hashCode() * 31) + this.f299017b.hashCode()) * 31) + this.f299018c.hashCode()) * 31) + this.f299019d.hashCode()) * 31) + this.f299020e.hashCode();
    }

    public final String toString() {
        return "SearchTextIndex(original=" + this.f299016a + ", pinyin=" + this.f299017b + ", pinyinRanges=" + this.f299018c + ", initials=" + this.f299019d + ", initialRanges=" + this.f299020e + ')';
    }

    public p1(String r100, String r101, List<n1> r102, String r103, List<n1> r104) {
        Intrinsics.checkNotNullParameter(r100, "original");
        Intrinsics.checkNotNullParameter(r101, "pinyin");
        Intrinsics.checkNotNullParameter(r102, "pinyinRanges");
        Intrinsics.checkNotNullParameter(r103, "initials");
        Intrinsics.checkNotNullParameter(r104, "initialRanges");
        this.f299016a = r100;
        this.f299017b = r101;
        this.f299018c = r102;
        this.f299019d = r103;
        this.f299020e = r104;
    }
}
