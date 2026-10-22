package com.larus.asr.session.component;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f287692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f287693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f287694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f287695d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<String> f287696e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<k0, Long> f287697f;

    public e(boolean r100, boolean r101, Function0 r102, com.larus.asr.session.p0 r103, int r104) {
        boolean r105 = false;
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L8;
        boolean r106 = true;
    L10:
        if ((r104 & 4) == 0) goto L13;
        r101 = false;
    L13:
        if ((r104 & 8) == 0) goto L16;
        r105 = true;
    L16:
        if ((r104 & 16) == 0) goto L18;
        r102 = d.f287689a;
    L18:
        Function1<k0, Long> r107 = r103;
        if ((r104 & 32) == 0) goto L21;
        r107 = new c();
    L21:
        Intrinsics.checkNotNullParameter(r102, "bizSceneProvider");
        Intrinsics.checkNotNullParameter(r107, "startTimeProvider");
        this.f287692a = r100;
        this.f287693b = r106;
        this.f287694c = r101;
        this.f287695d = r105;
        this.f287696e = r102;
        this.f287697f = r107;
        return;
    L8:
        r106 = false;
        goto L10
    }
}
