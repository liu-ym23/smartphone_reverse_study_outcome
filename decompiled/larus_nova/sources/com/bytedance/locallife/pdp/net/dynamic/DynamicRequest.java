package com.bytedance.locallife.pdp.net.dynamic;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import okhttp3.MediaType;

/* JADX INFO: loaded from: classes21.dex */
public final class DynamicRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<MediaType> f261597a = null;

    public static final class a {
    }

    static {
        f261597a = LazyKt.lazy(LazyThreadSafetyMode.NONE, DynamicRequest$Companion$contentType$2.INSTANCE);
    }
}
