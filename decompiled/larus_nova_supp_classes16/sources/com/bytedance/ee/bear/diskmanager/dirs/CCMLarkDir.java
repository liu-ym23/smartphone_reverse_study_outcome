package com.bytedance.ee.bear.diskmanager.dirs;

import com.ss.android.lark.storage.f;
import com.suite.lark.platform.component.storage.file.dirs.UniPathProvider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class CCMLarkDir extends com.bytedance.ee.bear.diskmanager.dirs.a {
    public static final Lazy<CCMLarkDir> b = null;
    public static final Lazy<CCMLarkDir> c = null;
    public static final Lazy<CCMLarkDir> d = null;
    public static final Lazy<CCMLarkDir> e = null;
    public static final Lazy<CCMLarkDir> f = null;

    public static final class a {
    }

    static {
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.SYNCHRONIZED;
        b = LazyKt.lazy(r0, CCMLarkDir$Companion$INTERNAL_CACHE$2.INSTANCE);
        c = LazyKt.lazy(r0, CCMLarkDir$Companion$INTERNAL_FILES$2.INSTANCE);
        d = LazyKt.lazy(r0, CCMLarkDir$Companion$EXTERNAL_FILES$2.INSTANCE);
        e = LazyKt.lazy(r0, CCMLarkDir$Companion$EXTERNAL_CACHE$2.INSTANCE);
        f = LazyKt.lazy(r0, CCMLarkDir$Companion$PUBLIC_ROOT$2.INSTANCE);
    }

    public final UniPathProvider.SpaceType c() {
        return UniPathProvider.SpaceType.LARK;
    }

    public CCMLarkDir(f r2) {
        Intrinsics.checkNotNullParameter(r2, "volume");
        super(r2);
    }
}
