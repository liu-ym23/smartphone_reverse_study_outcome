package com.ss.ugc.live.sdk.msg;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vlc.g;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements vlc.c, a, com.ss.ugc.live.sdk.msg.dispatch.e, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f458204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.ugc.live.sdk.msg.dispatch.e f458205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f458206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f458207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f458208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final vlc.c f458209f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g f458210g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f458211h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.ss.ugc.live.sdk.msg.utils.task.c f458212i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final amc.c f458213j;

    @Override // vlc.c
    public final boolean a() {
        return this.f458209f.a();
    }

    @Override // vlc.g
    public final void b(String r100, Throwable r101) {
        this.f458210g.b(r100, r101);
    }

    @Override // vlc.g
    public final void d(long r100, JSONObject r101, JSONObject r110, JSONObject r111) {
        this.f458210g.d(r100, r101, r110, r111);
    }

    @Override // vlc.g
    public final void e(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        this.f458210g.e(r100, r101, r102, r103);
    }

    @Override // com.ss.ugc.live.sdk.msg.a
    public final boolean isRunning() {
        return this.f458211h.isRunning();
    }

    @Override // vlc.c
    public final void log(String r100, String r101) {
        this.f458209f.log(r100, r101);
    }

    @Override // com.ss.ugc.live.sdk.msg.dispatch.e
    public final void c(List<? extends tlc.d> r100) {
        com.ss.ugc.live.sdk.msg.dispatch.e r101 = this.f458205b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("messageConsumer");
    L5:
        r101.c(r100);
    }

    public c(vlc.c r100, g r101, MessageState r102, com.ss.ugc.live.sdk.msg.utils.task.c r103, amc.c r104) {
        Intrinsics.checkNotNullParameter(r100, "logger");
        Intrinsics.checkNotNullParameter(r101, "monitor");
        Intrinsics.checkNotNullParameter(r102, "messageState");
        Intrinsics.checkNotNullParameter(r103, "taskScheduler");
        Intrinsics.checkNotNullParameter(r104, "historyMessageConfig");
        this.f458209f = r100;
        this.f458210g = r101;
        this.f458211h = r102;
        this.f458212i = r103;
        this.f458213j = r104;
        this.f458204a = "0";
        this.f458206c = "0";
        this.f458208e = true;
    }
}
