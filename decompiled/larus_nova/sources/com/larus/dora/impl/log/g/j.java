package com.larus.dora.impl.log.g;

/* JADX INFO: loaded from: classes27.dex */
public final class j implements ff7.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f336131a;

    @Override // ff7.e
    public final void onSuccess() {
        g49.d.d("DoraGLogManager", "upload log success");
        DoraGLogManager.f336103a.r(true, "upload log success");
        int r100 = a.f336120a;
        a.b(0, System.currentTimeMillis() - this.f336131a);
    }

    public j(long r100) {
        this.f336131a = r100;
    }

    @Override // ff7.e
    public final void onFail(String r100) {
        g49.d.b("DoraGLogManager", "upload log failed msg:" + r100);
        DoraGLogManager.f336103a.r(false, "upload log failed");
        int r101 = a.f336120a;
        a.b(1, System.currentTimeMillis() - this.f336131a);
    }
}
