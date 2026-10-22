package com.bytedance.badger.x;

import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes47.dex */
public final class c0 implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f0 f199370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f199371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ z f199372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f199373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f199374e;

    public c0(f0 r100, long r101, z r102, Ref.ObjectRef r103, Ref.ObjectRef r104) {
        this.f199370a = r100;
        this.f199371b = r101;
        this.f199372c = r102;
        this.f199373d = r103;
        this.f199374e = r104;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.String] */
    public final void a() {
        String r100 = p.b();     // Catch: Throwable -> L6
        this.f199370a.c(this.f199371b, new y(0, "success", this.f199372c, r100, "service", 32), null, null);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        com.bytedance.badger.e.c("DeviceFp1Task", "GetDeviceIdByAsk failed", th);
        this.f199373d.element = "service: " + th.getClass().getName() + " " + th.getMessage();
        f0 r101 = this.f199370a;
        long r102 = this.f199371b;
        String r103 = (String) this.f199373d.element;
        r101.c(r102, new y(-1000, r103, this.f199372c, null, null, 56), (String) this.f199374e.element, r103);
    }
}
