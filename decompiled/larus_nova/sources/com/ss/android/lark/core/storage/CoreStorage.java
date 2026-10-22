package com.ss.android.lark.core.storage;

import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
public final class CoreStorage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ss.android.lark.storage.a f419520a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f419521b = null;

    static {
        f419520a = new com.ss.android.lark.storage.a("CORE");
        f419521b = LazyKt.lazy(CoreStorage$isCoreUniFileStorageEnabled$2.INSTANCE);
    }

    @JvmStatic
    public static final h a() {
        VFSFiles r100 = VFSFiles.f444819b;
        boolean r101 = ((Boolean) f419521b.getValue()).booleanValue();
        r100.getClass();
        return VFSFiles.b(r101);
    }
}
