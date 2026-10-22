package com.ss.android.lark.feed.export.feedcard;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f420998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FeedCardComponent<?, ?> f420999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FeedCardComponent<?, ?> f421000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FeedCardComponent<?, ?>[] f421001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FeedCardComponent<?, ?>[] f421002e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FeedCardComponent<?, ?>[] f421003f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FeedCardComponent<?, ?>[] f421004g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FeedCardComponent<?, ?>[] f421005h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FeedCardComponent<?, ?> f421006i;

    public a(com.ss.android.lark.feed.cardcomponent.avatar.a r100, com.ss.android.lark.feed.cardcomponent.teams.b r101, FeedCardComponent[] r102, FeedCardComponent[] r103, FeedCardComponent[] r104, FeedCardComponent[] r110, dhb.a r111, int r112) {
        if ((r112 & 2) == 0) goto L6;
        r100 = null;
    L6:
        if ((r112 & 4) == 0) goto L9;
        r101 = null;
    L9:
        if ((r112 & 8) == 0) goto L12;
        r102 = new FeedCardComponent[0];
    L12:
        if ((r112 & 16) == 0) goto L15;
        r103 = new FeedCardComponent[0];
    L15:
        if ((r112 & 32) == 0) goto L17;
        FeedCardComponent<?, ?>[] r105 = new FeedCardComponent[0];
    L19:
        if ((r112 & 64) == 0) goto L22;
        r104 = new FeedCardComponent[0];
    L22:
        if ((r112 & 128) == 0) goto L25;
        r110 = new FeedCardComponent[0];
    L25:
        if ((r112 & 256) == 0) goto L27;
        r111 = null;
    L27:
        Intrinsics.checkNotNullParameter(r102, "title");
        Intrinsics.checkNotNullParameter(r103, "titleRight");
        Intrinsics.checkNotNullParameter(r105, "subtitle");
        Intrinsics.checkNotNullParameter(r104, "preview");
        Intrinsics.checkNotNullParameter(r110, "bottomAction");
        this.f420998a = null;
        this.f420999b = r100;
        this.f421000c = r101;
        this.f421001d = r102;
        this.f421002e = r103;
        this.f421003f = r105;
        this.f421004g = r104;
        this.f421005h = r110;
        this.f421006i = r111;
        return;
    L17:
        r105 = null;
        goto L19
    }
}
