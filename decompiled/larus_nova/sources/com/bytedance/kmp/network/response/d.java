package com.bytedance.kmp.network.response;

import com.bytedance.kmp.network.NetError;
import com.bytedance.kmp.network.Protocol;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jd6.c f252563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f252564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f252565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<com.bytedance.kmp.network.b> f252566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f252567e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final NetError f252568f;

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append("Response(code=" + this.f252565c + ", message='" + this.f252564b + '\'');
        if (this.f252568f == null) goto L5;
        r100.append(", error=" + this.f252568f);
    L5:
        r100.append(", headers=" + this.f252566d);
        r100.append(")");
        return r100.toString();
    }

    public d(jd6.c r100, Protocol r101, String r102, int r103, List<com.bytedance.kmp.network.b> r104, e r105, NetError r106, com.bytedance.kmp.network.e r107) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "protocol");
        Intrinsics.checkNotNullParameter(r102, "message");
        Intrinsics.checkNotNullParameter(r104, "headers");
        this.f252563a = r100;
        this.f252564b = r102;
        this.f252565c = r103;
        this.f252566d = r104;
        this.f252567e = r105;
        this.f252568f = r106;
        buc.b.d(r107);
    }
}
