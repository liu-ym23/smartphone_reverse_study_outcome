package com.bytedance.locallife.photo.album.model;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes21.dex */
public final class AlbumPageModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f261964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f261965b;

    public static final class a {
    }

    static {
    }

    public AlbumPageModel() {
        this.f261965b = LazyKt.lazy(AlbumPageModel$api$2.INSTANCE);
    }
}
