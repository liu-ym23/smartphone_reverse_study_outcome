package com.larus.bmhome.chat.trace;

import com.ixigua.lib.track.TrackParams;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f310221a = 0;

    static {
    }

    public i0() {
    }

    public static void a(String r100, JSONObject r101, by7.e r102) {
        TrackParams r103 = new TrackParams().merge(r101);
        by7.a r104 = new by7.a(r100);
        if (r102 == null) goto L5;
        r104.f21464b = r102;
    L5:
        r104.f21463a.merge(r103);
        r104.b();
    }
}
