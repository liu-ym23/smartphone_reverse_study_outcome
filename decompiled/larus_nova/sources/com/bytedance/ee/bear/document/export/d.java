package com.bytedance.ee.bear.document.export;

import g15.k;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements ut5.a<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f219694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int[] f219695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f219696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f219697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f219698e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ e f219699f;

    @Override // ut5.a
    public final void onResult(Boolean r100) {
        e r101 = this.f219699f;
        Map r102 = this.f219694a;
        int[] r103 = this.f219695b;
        int r104 = this.f219696c;
        String r105 = this.f219697d;
        Boolean r106 = Boolean.TRUE;
        e.b r107 = new e.b(r106.equals(r100), true, false);
        r101.f219740a.runOnUiThread(new k(r101, r102, r105, r107, r103, r104));
    }

    @Override // ut5.a
    public final void onError(int r110, Throwable r111) {
        tt5.a.e("DocumentExportAction", "minutes action/state validate failed, optionId = " + this.f219697d + ", token = " + du5.b.k(this.f219698e), r111, false);
        e r100 = this.f219699f;
        Map r101 = this.f219694a;
        int[] r102 = this.f219695b;
        int r103 = this.f219696c;
        String r104 = this.f219697d;
        r100.getClass();
        r100.f219740a.runOnUiThread(new k(r100, r101, r104, new e.b(false, false, true), r102, r103));
    }

    public d(e r100, Map r101, int[] r102, int r103, String r104, String r105) {
        this.f219699f = r100;
        this.f219694a = r101;
        this.f219695b = r102;
        this.f219696c = r103;
        this.f219697d = r104;
        this.f219698e = r105;
    }
}
