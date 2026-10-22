package com.ss.android.lark.videosend.tools;

import com.ss.android.lark.storage.kv.repo.KVRepo;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes38.dex */
public final class DebugParamInjector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f444968a = null;

    static {
        f444968a = LazyKt.lazy(DebugParamInjector$kvRepo$2.INSTANCE);
    }

    public static KVRepo a() {
        return (KVRepo) f444968a.getValue();
    }
}
