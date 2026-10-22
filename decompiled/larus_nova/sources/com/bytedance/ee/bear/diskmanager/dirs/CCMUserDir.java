package com.bytedance.ee.bear.diskmanager.dirs;

import com.ss.android.lark.storage.f;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import com.suite.lark.platform.component.storage.file.dirs.UniPathProvider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class CCMUserDir extends com.bytedance.ee.bear.diskmanager.dirs.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<CCMUserDir> f217600b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<CCMUserDir> f217601c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<CCMUserDir> f217602d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy<CCMUserDir> f217603e = null;

    public static final class a {
    }

    static {
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.SYNCHRONIZED;
        f217600b = LazyKt.lazy(r100, CCMUserDir$Companion$INTERNAL_CACHE$2.INSTANCE);
        f217601c = LazyKt.lazy(r100, CCMUserDir$Companion$INTERNAL_FILES$2.INSTANCE);
        f217602d = LazyKt.lazy(r100, CCMUserDir$Companion$EXTERNAL_FILES$2.INSTANCE);
        f217603e = LazyKt.lazy(r100, CCMUserDir$Companion$EXTERNAL_CACHE$2.INSTANCE);
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final UniPathProvider.SpaceType c() {
        return UniPathProvider.SpaceType.USER;
    }

    public CCMUserDir(f r100) {
        Intrinsics.checkNotNullParameter(r100, ITTVideoEngineEventSource.KEY_VOLUME);
        super(r100);
    }
}
