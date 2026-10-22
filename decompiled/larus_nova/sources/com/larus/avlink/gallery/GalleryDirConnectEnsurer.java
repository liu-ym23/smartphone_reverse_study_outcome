package com.larus.avlink.gallery;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes25.dex */
public final class GalleryDirConnectEnsurer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f292334a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f292335b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final GalleryDirConnectEnsurer$doraLinkCallback$1 f292336c = null;

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.avlink.gallery.GalleryDirConnectEnsurer$doraLinkCallback$1] */
    static {
        f292334a = new AtomicBoolean(false);
        f292335b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f292336c = new GalleryDirConnectEnsurer$doraLinkCallback$1();
    }
}
