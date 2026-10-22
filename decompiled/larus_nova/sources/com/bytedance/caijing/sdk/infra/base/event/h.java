package com.bytedance.caijing.sdk.infra.base.event;

import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f202354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CJContext f202355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f202356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f202357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final tf4.a f202358e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f202359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f202360g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f202361h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f202362i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, Object> f202363j;

    public final String getType() {
        return this.f202354a;
    }

    public h(String r100, CJContext r101, String r102, Map<String, ? extends Object> r103, tf4.a r104, long r105, boolean r106, String r110, String r111, Map<String, ? extends Object> r112) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "cjContext");
        Intrinsics.checkNotNullParameter(r102, "eventName");
        Intrinsics.checkNotNullParameter(r103, "evtParams");
        this.f202354a = r100;
        this.f202355b = r101;
        this.f202356c = r102;
        this.f202357d = r103;
        this.f202358e = r104;
        this.f202359f = r105;
        this.f202360g = r106;
        this.f202361h = r110;
        this.f202362i = r111;
        this.f202363j = r112;
    }
}
