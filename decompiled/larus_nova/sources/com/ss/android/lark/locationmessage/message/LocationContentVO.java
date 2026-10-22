package com.ss.android.lark.locationmessage.message;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.LocationContent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class LocationContentVO extends v5b.a<LocationContent> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Message f431287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f431288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f431289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f431290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f431291f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f431292g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f431293h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f431294i;

    public LocationContentVO(final LocationContent r100, Message r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "message");
        super(r100);
        this.f431287b = r101;
        this.f431288c = LazyKt.lazy(new LocationContentVO$locationDescription$2(r100));
        this.f431289d = LazyKt.lazy(new LocationContentVO$longitude$2(r100));
        this.f431290e = LazyKt.lazy(new LocationContentVO$latitude$2(r100));
        this.f431291f = LazyKt.lazy(new LocationContentVO$zoomLevel$2(r100));
        this.f431292g = LazyKt.lazy(new LocationContentVO$image$2(r100));
        this.f431293h = LazyKt.lazy(new LocationContentVO$vendor$2(r100));
        this.f431294i = LazyKt.lazy(new LocationContentVO$isInternal$2(r100));
    }
}
