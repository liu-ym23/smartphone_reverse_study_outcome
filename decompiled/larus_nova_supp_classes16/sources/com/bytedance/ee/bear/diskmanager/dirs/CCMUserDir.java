package com.bytedance.ee.bear.diskmanager.dirs;

import com.ss.android.lark.storage.f;
import com.suite.lark.platform.component.storage.file.dirs.UniPathProvider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class CCMUserDir extends com.bytedance.ee.bear.diskmanager.dirs.a {
    public static final Lazy<CCMUserDir> b = null;
    public static final Lazy<CCMUserDir> c = null;
    public static final Lazy<CCMUserDir> d = null;
    public static final Lazy<CCMUserDir> e = null;

    public static final class a {
    }

    static {
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.SYNCHRONIZED;
        b = LazyKt.lazy(r0, CCMUserDir$Companion$INTERNAL_CACHE$2.INSTANCE);
        c = LazyKt.lazy(r0, CCMUserDir$Companion$INTERNAL_FILES$2.INSTANCE);
        d = LazyKt.lazy(r0, CCMUserDir$Companion$EXTERNAL_FILES$2.INSTANCE);
        e = LazyKt.lazy(r0, CCMUserDir$Companion$EXTERNAL_CACHE$2.INSTANCE);
    }

    public final UniPathProvider.SpaceType c() {
        return UniPathProvider.SpaceType.USER;
    }

    public CCMUserDir(f r2) {
        Intrinsics.checkNotNullParameter(r2, "volume");
        super(r2);
    }
}
