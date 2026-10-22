package com.vivo.push;

import com.vivo.push.listener.IPushQueryActionListener;

/* JADX INFO: loaded from: classes41.dex */
public class a {
    public a() {
    }

    public void getRegId(IPushQueryActionListener r100) {
        com.vivo.push.util.g.a().execute(new b(this, r100));
    }

    public void querySubscribeState(IPushActionListener r100) {
        com.vivo.push.util.g.a().execute(new c(this, r100));
    }

    public void deleteRegid(IPushActionListener r100, String r101, String r102) {
        com.vivo.push.restructure.a.a().h().a(r100, r101, r102);
    }
}
