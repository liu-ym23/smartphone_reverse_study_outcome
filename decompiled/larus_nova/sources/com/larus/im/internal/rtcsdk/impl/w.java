package com.larus.im.internal.rtcsdk.impl;

import com.ss.bytertc.engine.RTCRoom;
import com.ss.bytertc.engine.UserInfo;
import com.ss.bytertc.engine.aigc.IRTCRoomEventHandlerAIGC;
import com.ss.bytertc.engine.aigc.StartSessionResult;
import java.nio.ByteBuffer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class w extends IRTCRoomEventHandlerAIGC {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RTCRoom f350051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f350052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<String, ff9.i, Unit> f350053c;

    public static final class a {
    }

    static {
    }

    public w(RTCRoom r100, boolean r101, z r102) {
        Intrinsics.checkNotNullParameter(r100, "rtcRoom");
        Intrinsics.checkNotNullParameter(r102, "transfer");
        this.f350051a = r100;
        this.f350052b = r101;
        this.f350053c = r102;
    }

    @Override // com.ss.bytertc.engine.aigc.IRTCRoomEventHandlerAIGC
    public final void onStartSessionResult(StartSessionResult r100, UserInfo r101, ByteBuffer r102) {
        Integer r103 = null;
        if (this.f350052b == true) goto L9;
        com.larus.im.internal.delegate.a r104 = com.larus.im.internal.delegate.a.f348188b;
        StringBuilder r105 = new StringBuilder("[onStartSessionResult] result: ");
        if (r100 == null) goto L7;
        r103 = Integer.valueOf(r100.ordinal());
    L7:
        r105.append(r103);
        r105.append(", disabled");
        r104.e("FlowRTCRoomServiceImpl_HandlerAIGC", r105.toString());
        return;
    L9:
        fe9.h r106 = fe9.h.f476628a;
        StringBuilder r107 = new StringBuilder("[onStartSessionResult] uid=");
        if (r101 == null) goto L12;
        String r108 = r101.uid;
    L13:
        r107.append(r108);
        r107.append(", result: ");
        if (r100 == null) goto L16;
        Integer r109 = Integer.valueOf(r100.ordinal());
    L17:
        r107.append(r109);
        r106.e("FlowRTCRoomServiceImpl_HandlerAIGC", r107.toString());
        if (r100 != StartSessionResult.START_SESSION_RESULT_HAS_IN_SESSION) goto L20;
        return;
    L20:
        Function2<String, ff9.i, Unit> r110 = this.f350053c;
        String r111 = this.f350051a.getRoomId();
        if (r100 != StartSessionResult.START_SESSION_RESULT_SUCCESS) goto L23;
        boolean r112 = true;
    L24:
        ue9.c.m r113 = ue9.c.m.f549857c;
        r110.invoke(r111, new ff9.i.v(r112, r102, null));
        return;
    L23:
        r112 = false;
        goto L24
    L16:
        r109 = null;
        goto L17
    L12:
        r108 = null;
        goto L13
    }

    @Override // com.ss.bytertc.engine.aigc.IRTCRoomEventHandlerAIGC
    public final void onStartSessionResultWithErrorCode(StartSessionResult r100, int r101, UserInfo r102, ByteBuffer r103) {
        Integer r104 = null;
        if (this.f350052b == false) goto L9;
        com.larus.im.internal.delegate.a r105 = com.larus.im.internal.delegate.a.f348188b;
        StringBuilder r106 = new StringBuilder("[onStartSessionResultWithErrorCode] result: ");
        if (r100 == null) goto L7;
        r104 = Integer.valueOf(r100.ordinal());
    L7:
        r106.append(r104);
        r106.append(", error_code: ");
        r106.append(r101);
        r106.append(", disabled");
        r105.e("FlowRTCRoomServiceImpl_HandlerAIGC", r106.toString());
        return;
    L9:
        fe9.h r107 = fe9.h.f476628a;
        StringBuilder r108 = new StringBuilder("[onStartSessionResultWithErrorCode] result: ");
        if (r100 == null) goto L12;
        r104 = Integer.valueOf(r100.ordinal());
    L12:
        r108.append(r104);
        r108.append(", error_code: ");
        r108.append(r101);
        r107.e("FlowRTCRoomServiceImpl_HandlerAIGC", r108.toString());
        if (r100 != StartSessionResult.START_SESSION_RESULT_HAS_IN_SESSION) goto L15;
        return;
    L15:
        Function2<String, ff9.i, Unit> r109 = this.f350053c;
        String r110 = this.f350051a.getRoomId();
        if (r100 != StartSessionResult.START_SESSION_RESULT_SUCCESS) goto L18;
        boolean r111 = true;
    L19:
        ue9.c.m r112 = ue9.c.m.f549857c;
        r109.invoke(r110, new ff9.i.v(r111, r103, Integer.valueOf(r101)));
        return;
    L18:
        r111 = false;
        goto L19
    }
}
