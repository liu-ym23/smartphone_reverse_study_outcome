package com.larus.business.markdown.api.depend;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes4.dex */
public final class IMarkdownLoggerKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f320461a = null;

    static {
        f320461a = LazyKt.lazy(IMarkdownLoggerKt$markdownLoggerDelegate$2.INSTANCE);
    }

    public static final d a() {
        return (d) f320461a.getValue();
    }
}
