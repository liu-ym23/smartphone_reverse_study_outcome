package com.ss.android.lark.statistics.doc;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import q5c.a;

/* JADX INFO: loaded from: classes38.dex */
public final class DocHitPoint extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocHitPoint f440717a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f440718b = null;

    static {
        f440717a = new DocHitPoint();
        f440718b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, DocHitPoint$statistics$2.INSTANCE);
    }

    public DocHitPoint() {
    }
}
