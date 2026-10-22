package kd5;

import android.os.Bundle;
import com.bytedance.ee.bear.list.dto.Document;
import com.ss.android.cert.manager.constants.EventConstant;

/* JADX INFO: loaded from: classes18.dex */
public final class b2 implements com.bytedance.ee.bear.contract.c0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.contract.j0 f502733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c2.a f502734b;

    public final void a(Document r100) {
        tt5.a.h("OfflineCacheManager", "onConfirmDownload()...");
        com.bytedance.ee.bear.contract.j0 r101 = this.f502733a;
        r101.f217095e = r100;
        c2 r102 = this.f502734b.f502762c;
        boolean r103 = c2.f502736w;
        r102.getClass();
        Document r104 = r101.f217095e;
        if (r104 != null) goto L5;
        tt5.a.k("OfflineCacheManager", "download()...module = " + r101.f217093c + ", document = null");
        return;
    L5:
        pw4.d r105 = new pw4.d();
        r105.f530834a = r104.f227873d;
        r105.f530835b = r104.f227891p;
        Bundle r106 = new Bundle();
        r105.f530836c = r106;
        r106.putString(EventConstant.Key.MODULE, r101.f217093c);
        ((com.bytedance.ee.bear.h) org.koin.java.a.a(com.bytedance.ee.bear.h.class)).j3(false, r105, new d2(r102, r101));
    }

    public final void b(Document r100) {
        tt5.a.h("OfflineCacheManager", "onWaitingWifi()...");
        r100.f227885k0 = true;
        c2 r101 = this.f502734b.f502762c;
        com.bytedance.ee.bear.contract.j0 r102 = this.f502733a;
        boolean r103 = r102.f217092b;
        boolean r104 = r102.f217094d;
        String r105 = r102.f217093c;
        boolean r106 = c2.f502736w;
        r101.h(r100, r103, r104, r105, false);
    }

    public b2(c2.a r100, com.bytedance.ee.bear.contract.j0 r101) {
        this.f502734b = r100;
        this.f502733a = r101;
    }
}
