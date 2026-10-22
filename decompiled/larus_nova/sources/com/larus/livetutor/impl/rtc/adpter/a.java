package com.larus.livetutor.impl.rtc.adpter;

import com.larus.livetutor.api.idl.ConnectedStatus;
import com.larus.livetutor.impl.rtc.api.RTCAction;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements com.larus.livetutor.impl.rtc.api.a {

    /* JADX INFO: renamed from: com.larus.livetutor.impl.rtc.adpter.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C4413a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f356274a = null;

        static {
            int[] r100 = new int[ConnectedStatus.values().length];
            r100[ConnectedStatus.Idle.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f356274a = r100;
        }
    }

    public a() {
    }

    @Override // com.larus.livetutor.impl.rtc.api.a
    public final ij9.a b(RTCAction.ConnectSuccess r100) {
        Intrinsics.checkNotNullParameter(r100, "successAction");
        ConnectedStatus r101 = r100.getStartStatus();
        if (r101 != null) goto L5;
        int r102 = -1;
    L6:
        if (r102 == (-1)) goto L13;
        if (r102 != 1) goto L11;
        return CustomConnectedStatus.Idle.INSTANCE;
    L11:
        throw new NoWhenBranchMatchedException();
    L13:
        return CustomConnectedStatus.Idle.INSTANCE;
    L5:
        r102 = C4413a.f356274a[r101.ordinal()];
        goto L6
    }

    @Override // com.larus.livetutor.impl.rtc.api.a
    public final ij9.a a(ij9.a r100, RTCAction r101) {
        Intrinsics.checkNotNullParameter(r100, "current");
        Intrinsics.checkNotNullParameter(r101, "action");
        if ((r100 instanceof CustomConnectedStatus.Idle) == false) goto L9;
        if ((r101 instanceof RTCAction.ReceiveAnswerStart) == false) goto L46;
        return CustomConnectedStatus.Speaking.INSTANCE;
    L46:
        return (CustomConnectedStatus) r100;
    L9:
        if ((r100 instanceof CustomConnectedStatus.Listening) == false) goto L18;
        if ((r101 instanceof RTCAction.ReceiveUserAsrEnd) == false) goto L14;
        return CustomConnectedStatus.Thinking.INSTANCE;
    L14:
        if ((r101 instanceof RTCAction.ReceiveAnswerStart) == false) goto L49;
        return CustomConnectedStatus.Speaking.INSTANCE;
    L49:
        return (CustomConnectedStatus) r100;
    L18:
        if ((r100 instanceof CustomConnectedStatus.Thinking) == false) goto L33;
        if ((r101 instanceof RTCAction.ReceiveAnswerStart) == false) goto L23;
        return CustomConnectedStatus.Speaking.INSTANCE;
    L23:
        if ((r101 instanceof RTCAction.ReceiveAnswerEnd) == false) goto L26;
        return CustomConnectedStatus.Listening.INSTANCE;
    L26:
        if ((r101 instanceof RTCAction.UserAsrStart) == false) goto L29;
        return CustomConnectedStatus.Listening.INSTANCE;
    L29:
        if ((r101 instanceof RTCAction.UserInterrupt) == false) goto L54;
        return CustomConnectedStatus.Listening.INSTANCE;
    L54:
        return (CustomConnectedStatus) r100;
    L33:
        if ((r100 instanceof CustomConnectedStatus.Speaking) == true) goto L35;
        return r100;
    L35:
        if ((r101 instanceof RTCAction.ReceiveAnswerEnd) == false) goto L38;
        return CustomConnectedStatus.Listening.INSTANCE;
    L38:
        if ((r101 instanceof RTCAction.UserAsrStart) == false) goto L41;
        return CustomConnectedStatus.Listening.INSTANCE;
    L41:
        if ((r101 instanceof RTCAction.UserInterrupt) == false) goto L44;
        return CustomConnectedStatus.Listening.INSTANCE;
    L44:
        return (CustomConnectedStatus) r100;
    }
}
