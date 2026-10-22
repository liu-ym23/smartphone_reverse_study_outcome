package com.larus.sheet.operation;

import com.larus.common_ui.dialog.u;
import com.larus.utils.logger.FLogger;
import tx9.u0;

/* JADX INFO: loaded from: classes31.dex */
public final class e implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f369093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f369094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f369095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f369096d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f369097e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ by7.e f369098f;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        FLogger.f375446a.i("SheetOpManager", "delete cancel");
        u0.f(this.f369093a, "0", "cancel", "delete", this.f369094b, this.f369095c, Integer.valueOf(this.f369096d), this.f369097e, null, this.f369098f, 256);
    }

    public e(String r100, String r101, String r102, int r103, String r104, by7.e r105) {
        this.f369093a = r100;
        this.f369094b = r101;
        this.f369095c = r102;
        this.f369096d = r103;
        this.f369097e = r104;
        this.f369098f = r105;
    }
}
