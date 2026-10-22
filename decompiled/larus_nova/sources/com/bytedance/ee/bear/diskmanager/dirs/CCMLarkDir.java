package com.bytedance.ee.bear.diskmanager.dirs;

import com.ss.android.lark.storage.f;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import com.suite.lark.platform.component.storage.file.dirs.UniPathProvider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class CCMLarkDir extends com.bytedance.ee.bear.diskmanager.dirs.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<CCMLarkDir> f217595b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<CCMLarkDir> f217596c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<CCMLarkDir> f217597d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy<CCMLarkDir> f217598e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy<CCMLarkDir> f217599f = null;

    public static final class a {
    }

    static {
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.SYNCHRONIZED;
        f217595b = LazyKt.lazy(r100, CCMLarkDir$Companion$INTERNAL_CACHE$2.INSTANCE);
        f217596c = LazyKt.lazy(r100, CCMLarkDir$Companion$INTERNAL_FILES$2.INSTANCE);
        f217597d = LazyKt.lazy(r100, CCMLarkDir$Companion$EXTERNAL_FILES$2.INSTANCE);
        f217598e = LazyKt.lazy(r100, CCMLarkDir$Companion$EXTERNAL_CACHE$2.INSTANCE);
        f217599f = LazyKt.lazy(r100, CCMLarkDir$Companion$PUBLIC_ROOT$2.INSTANCE);
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final UniPathProvider.SpaceType c() {
        return UniPathProvider.SpaceType.LARK;
    }

    public CCMLarkDir(f r100) {
        Intrinsics.checkNotNullParameter(r100, ITTVideoEngineEventSource.KEY_VOLUME);
        super(r100);
    }
}
