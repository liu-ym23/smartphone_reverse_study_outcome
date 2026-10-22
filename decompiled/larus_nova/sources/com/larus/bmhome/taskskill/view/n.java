package com.larus.bmhome.taskskill.view;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes26.dex */
public final class n implements com.larus.platform.api.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f314639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PcConnectionStatusManager f314640b;

    public n(String r100, PcConnectionStatusManager r101) {
        this.f314639a = r100;
        this.f314640b = r101;
    }

    @Override // com.larus.platform.api.a
    public final void onSuccess(String r100, String r101) {
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("[handleConnectionStatusAction][startMfaVerify] success, localPcDeviceId=");
        r103.append(this.f314639a);
        r103.append(", deviceName=");
        bs8.a r104 = this.f314640b.f314599f;
        if (r104 == null) goto L5;
        String r105 = r104.f20296a;
    L6:
        r103.append(r105);
        r103.append(", verifyWay=");
        r103.append(r100);
        r102.i("PcConnectionStatusManager", r103.toString());
        PcConnectionStatusManager r106 = this.f314640b;
        String r107 = this.f314639a;
        if (r107 != null) goto L9;
        r107 = "";
    L9:
        r106.a(r107, r101, false);
        return;
    L5:
        r105 = null;
        goto L6
    }

    @Override // com.larus.platform.api.a
    public final void a(int r100, String r101, Throwable r102) {
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("[handleConnectionStatusAction][startMfaVerify] failed, localPcDeviceId=");
        bs8.a r105 = this.f314640b.f314599f;
        String r106 = null;
        if (r105 == null) goto L5;
        String r107 = r105.f20300e;
    L6:
        r104.append(r107);
        r104.append(", deviceName=");
        bs8.a r108 = this.f314640b.f314599f;
        if (r108 == null) goto L9;
        r106 = r108.f20296a;
    L9:
        r104.append(r106);
        r104.append(", code=");
        r104.append(r100);
        r104.append(", msg=");
        r104.append(r101);
        r103.w("PcConnectionStatusManager", r104.toString(), r102);
        return;
    L5:
        r107 = null;
        goto L6
    }
}
