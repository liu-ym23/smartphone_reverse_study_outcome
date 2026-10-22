package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public final Activity a;
    public final View b;
    public final ViewGroup c;
    public final LifecycleOwner d;
    public final ViewModelStoreOwner e;
    public final boolean f;
    public final Map<String, Object> g;
    public final int h;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L32;
        return false;
    L32:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        boolean r1 = this.f;
        ?? r2 = r1;
        if (r1 == false) goto L6;
        r2 = 1;
    L6:
        return ((((r0 + r2) * 31) + this.g.hashCode()) * 31) + this.h;
    }

    public final String toString() {
        return "AosPageOwner(activity=" + this.a + ", rootView=" + this.b + ", viewPager=" + this.c + ", lifecycleOwner=" + this.d + ", viewModelStoreOwner=" + this.e + ", isMultiTab=" + this.f + ", extraMap=" + this.g + ", writeCommentHeight=" + this.h + ')';
    }

    public final Activity getActivity() {
        return this.a;
    }

    public b(Activity r2, View r3, ViewGroup r4, LifecycleOwner r5, ViewModelStoreOwner r6, boolean r7, Map<String, Object> r8, int r9) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r4, "viewPager");
        Intrinsics.checkNotNullParameter(r5, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r6, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(r8, "extraMap");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }

    public /* synthetic */ b(Activity r10, View r11, ViewGroup r12, LifecycleOwner r13, ViewModelStoreOwner r14, Map r15, int r16, int r17) {
        if ((r17 & 64) == 0) goto L5;
        Map r7 = new LinkedHashMap();
    L7:
        if ((r17 & 128) == 0) goto L9;
        int r8 = 0;
    L10:
        this(r10, r11, r12, r13, r14, false, r7, r8);
        return;
    L9:
        r8 = r16;
        goto L10
    L5:
        r7 = r15;
        goto L7
    }
}
