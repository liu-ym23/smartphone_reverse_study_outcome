package com.relax.relaxframework;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f405310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f405311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f405312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PhaseType f405313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c1 f405314e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<c1> f405315f;

    public v0(String r100, EventType r101, boolean r102, PhaseType r103) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "eventType");
        Intrinsics.checkNotNullParameter(r103, "phaseType");
        this.f405311b = "";
        this.f405312c = true;
        this.f405315f = com.bytedance.rts.foundation.j.k(new c1[0]);
        this.f405311b = r100;
        this.f405310a = 0;
        this.f405312c = r102;
        this.f405313d = r103;
    }
}
