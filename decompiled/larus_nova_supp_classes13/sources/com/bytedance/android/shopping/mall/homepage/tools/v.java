package com.bytedance.android.shopping.mall.homepage.tools;

import android.util.LruCache;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class v<Int> extends LruCache<Int, Object> {
    public static final Object c = null;
    public final List<Int> a;
    public Boolean b;

    public static final class a {
    }

    static {
        c = new Object();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v(Int r2) {
        if (r2 == 0) goto L6;
        super(((Integer) r2).intValue());
        this.a = Collections.synchronizedList(new ArrayList());
        this.b = Boolean.FALSE;
        return;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    @Override // android.util.LruCache
    public final void trimToSize(int r1) {
        super.trimToSize(r1);
    }

    @Override // android.util.LruCache
    public final void entryRemoved(boolean r1, Int r2, Object r3, Object r4) {
        super.entryRemoved(r1, r2, r3, r4);
        if (r1 == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.b, Boolean.FALSE) == true) goto L7;
        return;
    L7:
        if ((!Intrinsics.areEqual(r2, null)) == true) goto L9;
        return;
    L9:
        if ((!Intrinsics.areEqual(r2, 0)) == false) goto L15;
        this.a.add(r2);
        return;
    }
}
