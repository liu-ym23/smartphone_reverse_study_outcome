package com.bytedance.awemeopen.domain.base.repo;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes44.dex */
public final class ConstantsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f198237a = null;

    static {
        f198237a = LazyKt.lazy(ConstantsKt$OPEN_AWEME_BASE_URL$2.INSTANCE);
    }

    public static final String a() {
        return (String) f198237a.getValue();
    }
}
