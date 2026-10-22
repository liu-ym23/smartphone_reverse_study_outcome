package com.ss.android.lark.download.service.impl;

import com.larus.dora.impl.ota.g2.j0;
import com.ss.android.lark.download.service.FileDownloadState;
import com.ss.android.lark.download.service.NetworkType;
import com.ss.android.lark.http.netstate.NetworkUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements com.ss.android.lark.http.netstate.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f420536a;

    public b(a r100) {
        this.f420536a = r100;
    }

    @Override // com.ss.android.lark.http.netstate.a
    public final void a(NetworkUtils.NetworkType r110) {
        switch(a.b.f420534a[r110.ordinal()]) {
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L5;
            case 7: goto L5;
            default: goto L41;
        };
    L5:
        a r111 = this.f420536a;
        r111.f420532g = NetworkType.CELLULAR_DATA_NETWORK;
        if (a.a(r111) == false) goto L41;
        Iterator r112 = ((HashMap) this.f420536a.f420526a).values().iterator();
        boolean r100 = false;
        boolean r101 = false;
    L10:
        if (r112.hasNext() == false) goto L17;
        wbb.a r102 = (wbb.a) r112.next();
        if (r102.f559031b != FileDownloadState.DOWNLOADING) goto L10;
        r100 = true;
        if ((0 - ((((long) r102.f559030a) * 0) / 100)) <= j0.G2_OTA_SPACE_CHECK_BYTES) goto L10;
        this.f420536a.getClass();
        r102.f559031b = FileDownloadState.DOWNLOAD_CANCEL;
        r101 = true;
        goto L10
    L17:
        Set<wbb.b> r113 = this.f420536a.f420528c;
        if (r113 == null) goto L41;
        if (r113.size() == 0) goto L41;
        Iterator<wbb.b> r114 = this.f420536a.f420528c.iterator();
    L24:
        if (r114.hasNext() == false) goto L41;
        wbb.b r103 = r114.next();
        if (r101 == true) goto L27;
        if (r100 == false) goto L24;
        r103.c();
        goto L24
    L27:
        r103.a();
        goto L24
    L30:
        a r115 = this.f420536a;
        r115.f420532g = NetworkType.WIFI;
        goto L41
    L31:
        a r116 = this.f420536a;
        r116.f420532g = NetworkType.NO_INTERNET_CONNECTION;
        Set<wbb.b> r117 = r116.f420528c;
        if (r117 == null) goto L41;
        if (r117.size() <= 0) goto L41;
        if (a.a(this.f420536a) == false) goto L41;
        Iterator<wbb.b> r118 = this.f420536a.f420528c.iterator();
    L39:
        if (r118.hasNext() == false) goto L41;
        r118.next().b();
    L41:
        Iterator<wbb.c> r119 = this.f420536a.f420530e.iterator();
    L43:
        if (r119.hasNext() == false) goto L45;
        wbb.c r104 = r119.next();
        this.f420536a.f420532g.getNumber();
        r104.a();
        goto L43
    }
}
