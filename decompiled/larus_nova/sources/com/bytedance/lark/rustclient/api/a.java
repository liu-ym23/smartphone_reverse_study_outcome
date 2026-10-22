package com.bytedance.lark.rustclient.api;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.sdk.StreamDataSource;

/* JADX INFO: loaded from: classes20.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Command f253892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f253893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StreamDataSource f253894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.sdk.h f253895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.ss.android.lark.pb.improto.Command f253896e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f253897f;

    public final Command a() {
        if (this.f253896e == null) goto L6;
        return Command.POST_GATEWAY;
    L6:
        return this.f253892a;
    }

    public a(Command r100, String r101, StreamDataSource r102, com.ss.android.lark.sdk.h r103, com.ss.android.lark.pb.improto.Command r104, Boolean r105) {
        this.f253892a = r100;
        this.f253893b = r101;
        this.f253894c = r102;
        this.f253895d = r103;
        this.f253896e = r104;
        this.f253897f = r105;
    }
}
