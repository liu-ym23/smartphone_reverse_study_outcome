package com.ss.android.ugc.route_monitor.impl.route_in;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f454495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f454496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f454497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f454498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f454499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f454500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f454501g;

    public final String toString() {
        return "{\"act_name\": \"" + this.f454497c + "\", \"stage_name\": \"" + this.f454498d + "\", \"cost_time\": " + this.f454496b + ", \"index\": " + this.f454500f + ", \"total_cost_time\": " + this.f454501g + ", \"session\": \"" + this.f454499e + "\"}";
    }

    public a(String r100, String r101, String r102, long r103, long r104) {
        this.f454497c = r100;
        this.f454498d = r101;
        this.f454499e = r102;
        this.f454500f = r103;
        this.f454501g = r104;
        this.f454495a = SystemClock.uptimeMillis();
    }
}
