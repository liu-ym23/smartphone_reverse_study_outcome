package com.larus.uaigc.chat.notification;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f371337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f371338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f371339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f371340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f371341e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f371342f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f371343g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Bundle f371344h;

    public k(int r100, String r101, String r102, long r103, int r104, String r105, boolean r106, Bundle r110) {
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "content");
        Intrinsics.checkNotNullParameter(r105, "messageId");
        this.f371337a = r100;
        this.f371338b = r101;
        this.f371339c = r102;
        this.f371340d = r103;
        this.f371341e = r104;
        this.f371342f = r105;
        this.f371343g = r106;
        this.f371344h = r110;
    }
}
