package com.ss.cast.discovery.mdns;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f456267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f456268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f456269c;

    public final String toString() {
        return "BuriPointInfo(serviceType='" + this.f456269c + "', browseStarted=" + this.f456267a + ", resultFound=" + this.f456268b + ')';
    }

    public a(String r100) {
        this.f456269c = r100;
        this.f456267a = true;
        this.f456268b = false;
    }
}
