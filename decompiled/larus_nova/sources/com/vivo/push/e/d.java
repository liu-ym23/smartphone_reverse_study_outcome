package com.vivo.push.e;

import android.content.Context;
import android.text.TextUtils;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.t;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class d implements a {
    public d() {
    }

    @Override // com.vivo.push.e.a
    public final void deleteAllProfileId(IPushRequestCallback<Integer> r100) {
        com.vivo.push.util.g.a().execute(new g(this, r100));
    }

    @Override // com.vivo.push.e.a
    public final void queryProfileIds(IPushRequestCallback<List<String>> r100) {
        com.vivo.push.util.g.a().execute(new h(this, r100));
    }

    @Override // com.vivo.push.e.a
    public final void addProfileId(String r100, IPushRequestCallback<Integer> r101) {
        com.vivo.push.util.g.a().execute(new e(this, r100, r101));
    }

    @Override // com.vivo.push.e.a
    public final void deleteProfileId(String r100, IPushRequestCallback<Integer> r101) {
        com.vivo.push.util.g.a().execute(new f(this, r100, r101));
    }

    public static /* synthetic */ void a(d r100, String r101, IPushRequestCallback r102, int r103) {
        if (com.vivo.push.restructure.a.a().g().b() == 0) goto L8;
        t.b("core not support sync profileInfo");
        if (r102 == null) goto L8;
        r102.onError(AVMDLDataLoader.KeyIsLiveEnableMdlProto);
        return;
    L8:
        Context r104 = com.vivo.push.restructure.a.a().b();
        ArrayList r105 = new ArrayList();
        if (TextUtils.isEmpty(r101) == true) goto L11;
        r105.add(new b(r101));
    L11:
        com.vivo.push.restructure.request.b r106 = new com.vivo.push.restructure.request.b(new com.vivo.push.e.a.a(new com.vivo.push.e.a.b(r104.getPackageName(), r105, r103)), new j(r100, r102, r103), 20000);
        com.vivo.push.restructure.request.d.a().a(r106);
    }
}
