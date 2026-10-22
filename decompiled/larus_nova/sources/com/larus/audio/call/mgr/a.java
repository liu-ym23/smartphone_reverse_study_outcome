package com.larus.audio.call.mgr;

import kotlin.Deprecated;

/* JADX INFO: loaded from: classes24.dex */
@Deprecated(message = "临时兼容使用，仅对齐历史逻辑，不保证对扩展逻辑生效")
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f289217a = 0;

    static {
    }

    public static MajorState.f a(AVKitCoreStates$Error r100) {
        int r101 = r100.f289160a;
        Object r102 = r100.f289162c.get("vui_error_code");
        if ((r102 instanceof Integer) == false) goto L5;
        Integer r103 = (Integer) r102;
    L6:
        if (r103 == null) goto L8;
        int r104 = r103.intValue();
    L10:
        return new MajorState.f(r101, r104, r100.f289161b, 8);
    L8:
        r104 = 0;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public static MajorState b(AVKitDuplexState.UpState r100) {
        if ((r100 instanceof AVKitCoreStates$Invalid) == false) goto L6;
        return MajorState.c.f289181c;
    L6:
        if ((r100 instanceof AVKitCoreStates$Connecting) == false) goto L9;
        return MajorState.a.f289179c;
    L9:
        if ((r100 instanceof AVKitCoreStates$Listening) == false) goto L12;
        return MajorState.j.f289191c;
    L12:
        if ((r100 instanceof AVKitCoreStates$Recognizing) == false) goto L15;
        return new MajorState.d(MajorState.From.ASR, MajorState.InterruptType.NOTHING);
    L15:
        if ((r100 instanceof AVKitCoreStates$Error) == false) goto L18;
        return a((AVKitCoreStates$Error) r100);
    L18:
        if ((r100 instanceof AVKitCoreStates$Paused) == false) goto L21;
        return new MajorState.g(MajorState.j.f289191c);
    L21:
        if ((r100 instanceof AVKitCoreStates$Finished) == false) goto L24;
        return MajorState.c.f289181c;
    L24:
        return MajorState.j.f289191c;
    }
}
