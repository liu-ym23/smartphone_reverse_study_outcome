package com.ss.android.ugc.route_monitor.impl.route_out.control;

import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f454618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f454619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f454620c;

    public final String toString() {
        return "{lastCertId=" + this.f454618a + ", nowCertId=" + this.f454619b + ", certIdList=" + this.f454620c + '}';
    }

    public d(String r100, String r101, List<String> r102) {
        this.f454618a = r100;
        this.f454619b = r101;
        this.f454620c = r102;
    }
}
