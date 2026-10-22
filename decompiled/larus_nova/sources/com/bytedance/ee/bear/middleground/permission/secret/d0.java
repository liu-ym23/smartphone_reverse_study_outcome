package com.bytedance.ee.bear.middleground.permission.secret;

import com.bytedance.ee.bear.secret.SecretLevel;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d0<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0<T> f234036a = null;

    static {
        f234036a = new d0();
    }

    public d0() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        return Intrinsics.compare(((SecretLevel) r101).getLevel(), ((SecretLevel) r100).getLevel());
    }
}
