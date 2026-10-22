package com.bytedance.android.shopping.store.slicecard.view;

import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static final f a = null;

    static {
        a = new f(CollectionsKt.emptyList(), 0.0f);
    }

    public static final boolean a(h r1) {
        if ((r1 instanceof h.a) == false) goto L6;
    L9:
        return true;
    L6:
        if ((r1 instanceof h.b) == false) goto L13;
        if (StringsKt.isBlank(((h.b) r1).a) == false) goto L9;
        return false;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public static final float b(h r1, float r2) {
        if ((r1 instanceof h.a) == false) goto L6;
        return ((h.a) r1).d;
    L6:
        if ((r1 instanceof h.b) == false) goto L12;
        Float r3 = ((h.b) r1).f;
        if (r3 != null) goto L10;
        return r2;
    L10:
        return r3.floatValue();
    L12:
        throw new NoWhenBranchMatchedException();
    }
}
