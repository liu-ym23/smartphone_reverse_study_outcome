package com.bytedance.applog.priority;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f192620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f192621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.applog.log.a f192622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f192623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f192624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f192625f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f192620a, r101.f192620a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f192621b, r101.f192621b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f192622c, r101.f192622c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f192623d, r101.f192623d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f192624e, r101.f192624e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f192625f, r101.f192625f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f192620a.hashCode() * 31) + this.f192621b.hashCode()) * 31) + this.f192622c.hashCode()) * 31) + this.f192623d.hashCode()) * 31) + this.f192624e.hashCode()) * 31) + this.f192625f.hashCode();
    }

    public final String toString() {
        return "PriorityContext(context=" + this.f192620a + ", config=" + this.f192621b + ", logger=" + this.f192622c + ", dbDir=" + this.f192623d + ", defaultReportHost=" + this.f192624e + ", defaultReportPath=" + this.f192625f + ')';
    }

    public final Context getContext() {
        return this.f192620a;
    }

    public h(Context r100, f r101, com.bytedance.applog.log.a r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "logger");
        Intrinsics.checkNotNullParameter(r103, "dbDir");
        Intrinsics.checkNotNullParameter(r104, "defaultReportHost");
        Intrinsics.checkNotNullParameter(r105, "defaultReportPath");
        this.f192620a = r100;
        this.f192621b = r101;
        this.f192622c = r102;
        this.f192623d = r103;
        this.f192624e = r104;
        this.f192625f = r105;
    }
}
