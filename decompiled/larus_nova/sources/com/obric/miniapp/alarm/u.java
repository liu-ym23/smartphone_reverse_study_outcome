package com.obric.miniapp.alarm;

import com.ixigua.lib.track.TrackParams;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class u implements m {
    public u() {
    }

    @Override // com.obric.miniapp.alarm.m
    public final void report(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a(r100);
        r103.f21463a.merge(r102);
        r103.b();
    }
}
