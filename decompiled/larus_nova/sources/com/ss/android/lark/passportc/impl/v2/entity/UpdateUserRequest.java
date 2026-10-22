package com.ss.android.lark.passportc.impl.v2.entity;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class UpdateUserRequest {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicInteger f438262d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f438263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d> f438264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f438265c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f438266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<d> f438267b;

        public a() {
        }

        public final UpdateUserRequest a() {
            return new UpdateUserRequest(this.f438266a, this.f438267b, UpdateUserRequest.f438262d.incrementAndGet());
        }
    }

    public static final class b {
    }

    static {
        f438262d = new AtomicInteger(100000);
    }

    public final String toString() {
        List<d> r100 = this.f438264b;
        if (r100 == null) goto L5;
        String r101 = "[" + CollectionsKt.joinToString$default(r100, "\n", null, null, 0, null, new UpdateUserRequest$toString$background$1$1(this), 30, null) + ']';
    L7:
        return "{id=" + this.f438265c + ", foreground=" + a(this.f438263a) + ", background=" + r101 + '}';
    L5:
        r101 = null;
        goto L7
    }

    public static String a(d r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.f438282c == false) goto L6;
        String r101 = ", reset=true";
    L10:
        return "{" + r100.f438280a.userId + ", " + r100.f438281b + r101 + '}';
    L6:
        r101 = "";
        goto L10
    }

    public UpdateUserRequest(d r100, List r101, int r102) {
        this.f438263a = r100;
        this.f438264b = r101;
        this.f438265c = r102;
    }
}
