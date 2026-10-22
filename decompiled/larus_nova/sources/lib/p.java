package lib;

import com.ss.android.lark.forwardv2.impl.utils.ForwardUtil$ReceiveAuthorizationState;

/* JADX INFO: loaded from: classes36.dex */
public final /* synthetic */ class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f509485a = null;

    static {
        int[] r100 = new int[ForwardUtil$ReceiveAuthorizationState.values().length];
        f509485a = r100;
        r100[ForwardUtil$ReceiveAuthorizationState.MIDDLE_AUTHORIZATION_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L14:
        f509485a[ForwardUtil$ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L18:
        f509485a[ForwardUtil$ReceiveAuthorizationState.UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L22:
        f509485a[ForwardUtil$ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_PASS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L16:
        f509485a[ForwardUtil$ReceiveAuthorizationState.NORMAL_STATE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
        return;
    }
}
