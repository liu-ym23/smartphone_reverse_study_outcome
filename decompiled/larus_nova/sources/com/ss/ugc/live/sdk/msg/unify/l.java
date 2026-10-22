package com.ss.ugc.live.sdk.msg.unify;

import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWUplinkPacket;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<Long, k> f458430a;

    public l() {
        this.f458430a = new LinkedHashMap();
    }

    public final void a(UMGWUplinkPacket r100, c r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, "uplinkPacket");
        Intrinsics.checkNotNullParameter(r101, "bridge");
        LinkedHashMap<Long, k> r103 = this.f458430a;
        Long r104 = r100.unique_id;
        k r105 = new k(r100, r101, r102);
        r105.f458427a = System.currentTimeMillis();
        Unit r106 = Unit.INSTANCE;
        r103.put(r104, r105);
    }
}
