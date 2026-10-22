package com.bytedance.iesgurd.request;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Long> f250821e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f250822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f250823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f250824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final UpdateRequest f250825d;

    public static final class a {
    }

    static {
        f250821e = new ConcurrentHashMap();
    }

    public e(boolean r100, boolean r101, String r102, UpdateRequest r103) {
        this.f250822a = r100;
        this.f250823b = r101;
        this.f250824c = r102;
        this.f250825d = r103;
    }
}
