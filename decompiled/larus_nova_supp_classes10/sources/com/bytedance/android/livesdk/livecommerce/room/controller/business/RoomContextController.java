package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.model.response.n1;
import com.bytedance.android.livesdk.livecommerce.LiveUserDataCenterModule_ProvideFactory;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController$roomResources$1;
import com.bytedance.android.livesdk.livecommerce.room.controller.c0;
import com.bytedance.android.livesdk.livecommerce.room.utils.LiveRoomRedirectInfo;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import sg2.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class RoomContextController extends c0 {
    public static final /* synthetic */ int h = 0;
    public y c;
    public final com.bytedance.android.livesdk.livecommerce.room.utils.d d;
    public final Map<String, Long> e;
    public n1 f;
    public volatile LiveRoomRedirectInfo g;

    public static final class a {
        @JvmStatic
        public static RoomContextController a() {
            RoomContextController r0 = ControllerCenter.c(null, null).m;
            Objects.toString(r0);
            return r0;
        }

        @JvmStatic
        public static RoomContextController b(String r0, String r1) {
            RoomContextController r2 = ControllerCenter.c(r0, r1).m;
            Objects.toString(r2);
            return r2;
        }
    }

    static {
    }

    @JvmStatic
    public static final RoomContextController H() {
        return a.a();
    }

    public final com.bytedance.android.livesdk.livecommerce.room.api.c J() {
        if (this.b.l() == true) goto L7;
        return null;
    L7:
        return q();
    }

    public final String I() {
        long r0 = A().t.l;
        if (r0 <= 0) goto L5;
        Handler r2 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        return String.valueOf(SystemClock.elapsedRealtime() - r0);
    L5:
        return BDLocationException.ERROR_TIMEOUT;
    }

    public final Map<String, String> K() {
        if (w() == true) goto L7;
        return new HashMap();
    L7:
        return C().m;
    }

    public final com.bytedance.android.ec.adapter.api.state.a L() {
        if (w() == true) goto L7;
        return null;
    L7:
        return C();
    }

    public final boolean M() {
        if (w() == true) goto L7;
        return false;
    L7:
        return C().a();
    }

    public final Context getContext() {
        if (u() == true) goto L7;
        return null;
    L7:
        return m();
    }

    public RoomContextController(RealRoomController$roomResources$1 r2) {
        Intrinsics.checkNotNullParameter(r2, "roomResources");
        super(r2);
        this.d = new com.bytedance.android.livesdk.livecommerce.room.utils.d();
        this.e = new LinkedHashMap();
        this.c = LiveUserDataCenterModule_ProvideFactory.proxyProvide(hh2.a.a().a);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.lifecycle.Observer, com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController$onLiveRoomParamsReady$2$observer$1] */
    public final Object N(Continuation<? super Boolean> r5) {
        final kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r5), 1);
        final MutableLiveData r1 = this.b.f();
        final ?? r2 = new RoomContextController$onLiveRoomParamsReady$2$observer$1(r0, r1);
        r1.observeForever(r2);
        r0.i(new RoomContextController$onLiveRoomParamsReady$2$1(r1, r2));
        Object r3 = r0.B();
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r3;
    }
}
