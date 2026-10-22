package com.ss.ugc.live.sdk.message.wrsc.data;

import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import tlc.c;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f458180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f458181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f458182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ByteString f458183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f458184e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f458185f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f458186g;

    @Override // tlc.c
    public final Object getData() {
        return this.f458184e;
    }

    @Override // tlc.c
    public final long getWRDSVersion() {
        return this.f458180a;
    }

    public a(long r100, String r101, WebcastRoomDataSyncKeyValue r102, Object r103) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "webcastRoomDataSyncKeyValue");
        this.f458185f = r100;
        this.f458186g = r101;
        Long r104 = r102.version;
        if (r104 == null) goto L5;
        long r105 = r104.longValue();
    L6:
        this.f458180a = r105;
        Long r106 = r102.msgID;
        if (r106 == null) goto L9;
        long r107 = r106.longValue();
    L10:
        this.f458181b = r107;
        String r108 = r102.bizLogID;
        if (r108 != null) goto L14;
        r108 = "";
    L14:
        this.f458182c = r108;
        this.f458183d = r102.payload;
        this.f458184e = r103;
        return;
    L9:
        r107 = 0;
        goto L10
    L5:
        r105 = -1;
        goto L6
    }
}
