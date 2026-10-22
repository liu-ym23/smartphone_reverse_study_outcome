package com.larus.bmhome.clarification;

import com.ixigua.lib.track.TrackParams;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class i2 {
    public static final void a(String r100, JSONObject r101, by7.e r102) {
        by7.a r103 = new by7.a(r100);
        if (r102 == null) goto L5;
        r103.f21464b = r102;
    L5:
        TrackParams r104 = new TrackParams().merge(r101);
        r103.f21463a.merge(r104);
        r103.b();
    }
}
