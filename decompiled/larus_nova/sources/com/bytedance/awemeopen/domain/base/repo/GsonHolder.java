package com.bytedance.awemeopen.domain.base.repo;

import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes44.dex */
public final class GsonHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f198238a = null;

    static {
        f198238a = LazyKt.lazy(GsonHolder$gson$2.INSTANCE);
    }

    public static final Gson a() {
        return (Gson) f198238a.getValue();
    }
}
