package com.larus.doc.impl.operation;

import com.larus.common_ui.dialog.u;
import com.larus.utils.logger.FLogger;
import tx9.u0;

/* JADX INFO: loaded from: classes27.dex */
public final class l implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f331421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f331422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f331423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f331424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f331425e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ by7.e f331426f;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        FLogger.f375446a.i("DocListPage", "delete cancel");
        u0.f(this.f331421a, "0", "cancel", "delete", this.f331422b, this.f331423c, Integer.valueOf(this.f331424d), this.f331425e, null, this.f331426f, 256);
    }

    public l(String r100, String r101, String r102, int r103, String r104, by7.e r105) {
        this.f331421a = r100;
        this.f331422b = r101;
        this.f331423c = r102;
        this.f331424d = r103;
        this.f331425e = r104;
        this.f331426f = r105;
    }
}
