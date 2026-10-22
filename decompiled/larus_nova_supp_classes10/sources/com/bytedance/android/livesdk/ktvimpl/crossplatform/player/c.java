package com.bytedance.android.livesdk.ktvimpl.crossplatform.player;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.KtvEarMonitor;
import com.google.gson.JsonObject;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface c {
    String b();

    fe2.a c();

    com.bytedance.android.livesdk.ktvimpl.crossplatform.midi.a d();

    void e(LifecycleOwner r1, Observer<jd2.c> r2);

    jd2.c f();

    KtvEarMonitor g();

    void h();

    boolean i();

    void j();

    b k();

    void l(LifecycleOwner r1, Observer<jd2.c> r2);

    void m(JsonObject r1);

    jd2.a o();

    void observeMusicPlayerState(LifecycleOwner r1, com.ss.android.ugc.aweme.compat.nullable.Observer<Boolean> r2);

    Pair<Boolean, Boolean> p(String r1);

    void q(jd2.c r1);

    void r(LifecycleOwner r1, Observer<jd2.a> r2);

    void s();
}
