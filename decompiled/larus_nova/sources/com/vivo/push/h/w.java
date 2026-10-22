package com.vivo.push.h;

import android.text.TextUtils;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.util.HashMap;

/* JADX INFO: loaded from: classes41.dex */
final class w implements u.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f462379a;

    @Override // com.vivo.push.h.u.a
    public final void b() {
        HashMap r100 = new HashMap();
        r100.put(com.heytap.mcssdk.constant.b.f276353c, String.valueOf(this.f462379a.f462376b.h()));
        String r101 = com.vivo.push.restructure.a.a().e().a();
        if (TextUtils.isEmpty(r101) == true) goto L5;
        r100.put("remoteAppId", r101);
    L5:
        com.vivo.push.util.f.a(2122, r100);
    }

    @Override // com.vivo.push.h.u.a
    public final void a() {
        long r100 = com.vivo.push.m.a().k();
        if (r100 < 1400) goto L5;
    L8:
        HashMap r101 = new HashMap();
        r101.put("srt", "1");
        r101.put(MusicAppletPage.KEY_MESSAGE_ID, String.valueOf(this.f462379a.f462376b.h()));
        String r102 = com.vivo.push.restructure.a.a().e().a();
        if (TextUtils.isEmpty(r102) == true) goto L11;
        r101.put("app_id", r102);
    L11:
        r101.put("type", "1");
        r101.put("dtp", "1");
        com.vivo.push.util.f.a(6, r101);
        return;
    L5:
        if (r100 == 1340) goto L8;
        com.vivo.push.util.t.b("OnNotificationArrivedTask", "引擎版本太低，不支持正向展示功能，pushEngineSDKVersion：".concat(String.valueOf(r100)));
    }

    public w(v r100) {
        this.f462379a = r100;
    }
}
