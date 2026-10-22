package com.bytedance.ee.bear.middleground.permission.secret;

import com.bytedance.ee.bear.secret.SecretLevel;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d0<T> implements Comparator {
    public static final d0<T> a = null;

    static {
        a = new d0();
    }

    public d0() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r1, Object r2) {
        return Intrinsics.compare(((SecretLevel) r2).getLevel(), ((SecretLevel) r1).getLevel());
    }
}
