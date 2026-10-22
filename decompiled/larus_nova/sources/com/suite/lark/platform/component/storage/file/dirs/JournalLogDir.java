package com.suite.lark.platform.component.storage.file.dirs;

import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes36.dex */
@Deprecated(message = " temporary using, may refactor in the future")
public final class JournalLogDir {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f460633a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f460634b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f460635c;

    static {
        f460633a = LazyKt.lazy(JournalLogDir$internalPath$2.INSTANCE);
        f460634b = LazyKt.lazy(JournalLogDir$externalPath$2.INSTANCE);
    }
}
