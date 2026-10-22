package com.bytedance.android.shopping.api.mall.feed;

import androidx.lifecycle.LifecycleOwner;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final Map<String, Object> e;
    public final String f;
    public final LifecycleOwner g;
    public final f h;
    public final com.bytedance.android.shopping.api.mall.j i;

    public static final class a {
    }

    static {
    }

    public h() {
        throw null;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof h) == false) goto L24;
        h r4 = (h) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        boolean r10 = this.d;
        ?? r11 = r10;
        if (r10 == false) goto L17;
        r11 = 1;
    L17:
        int r12 = (r9 + r11) * 31;
        Map<String, Object> r13 = this.e;
        if (r13 == null) goto L20;
        int r14 = r13.hashCode();
    L21:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 == null) goto L24;
        int r17 = r16.hashCode();
    L25:
        int r18 = (r15 + r17) * 31;
        LifecycleOwner r19 = this.g;
        if (r19 == null) goto L28;
        int r20 = r19.hashCode();
    L29:
        int r21 = (r18 + r20) * 31;
        f r22 = this.h;
        if (r22 == null) goto L32;
        int r23 = r22.hashCode();
    L33:
        int r24 = (r21 + r23) * 31;
        com.bytedance.android.shopping.api.mall.j r25 = this.i;
        if (r25 == null) goto L37;
        r1 = r25.hashCode();
    L37:
        return r24 + r1;
    L32:
        r23 = 0;
        goto L33
    L28:
        r20 = 0;
        goto L29
    L24:
        r17 = 0;
        goto L25
    L20:
        r14 = 0;
        goto L21
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "MallGulConfig(pageName=" + this.a + ", enterFrom=" + this.b + ", ecomSceneId=" + this.c + ", isDarkMode=" + this.d + ", queryParams=" + this.e + ", title=" + this.f + ", lifeCycleOwner=" + this.g + ", stateListener=" + this.h + ", loadMoreContainer=" + this.i + ")";
    }

    public h(String r3, String r4, boolean r5, LifecycleOwner r6, com.bytedance.android.shopping.collect.custom_view.d r7) {
        Intrinsics.checkNotNullParameter("collect_list_page", "pageName");
        Intrinsics.checkNotNullParameter(r6, "lifeCycleOwner");
        this.a = "collect_list_page";
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = null;
        this.f = null;
        this.g = r6;
        this.h = r7;
        this.i = null;
    }
}
