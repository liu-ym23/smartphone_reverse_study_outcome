package com.ss.android.lark.passportc.ffi;

import com.lark.kmp.basic.ActionContext;
import com.lark.kmp.basic.ActionType;
import com.lark.kmp.basic.ExecuteStrategy;
import com.lark.kmp.basic.ReturnType;
import com.lark.kmp.basic.Scene;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.entity.UserState;
import f0c.g;
import f0c.h;
import gy7.p;
import gy7.u;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f438166a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f438167a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f438168b = null;

        static {
            int[] r100 = new int[ActionType.values().length];
            r100[ActionType.Online.ordinal()] = 1;     // Catch: NoSuchFieldError -> L50
        L106:
            r100[ActionType.Offline.ordinal()] = 2;     // Catch: NoSuchFieldError -> L51
        L118:
            r100[ActionType.Clean.ordinal()] = 3;     // Catch: NoSuchFieldError -> L52
        L128:
            r100[ActionType.BringOnline.ordinal()] = 4;     // Catch: NoSuchFieldError -> L53
        L130:
            r100[ActionType.BringForeground.ordinal()] = 5;     // Catch: NoSuchFieldError -> L54
        L12:
            int[] r101 = new int[ExecuteStrategy.values().length];
            r101[ExecuteStrategy.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L55
        L92:
            r101[ExecuteStrategy.RETRY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L56
        L102:
            r101[ExecuteStrategy.ROLLBACK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L57
        L16:
            int[] r102 = new int[Scene.values().length];
            r102[Scene.FIRST_ONLINE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L58
        L126:
            r102[Scene.SWITCH_ONLINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L59
        L134:
            r102[Scene.FAST_ONLINE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L60
        L140:
            r102[Scene.SWITCH_BACKGROUND.ordinal()] = 4;     // Catch: NoSuchFieldError -> L61
        L148:
            r102[Scene.SWITCH_FOREGROUND.ordinal()] = 5;     // Catch: NoSuchFieldError -> L62
        L90:
            r102[Scene.CREATE_USER_COMPONENT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L63
        L24:
            int[] r103 = new int[ReturnType.values().length];
            r103[ReturnType.QUICK_ONLINE_RETURN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L64
        L114:
            r103[ReturnType.Foreground.ordinal()] = 2;     // Catch: NoSuchFieldError -> L65
        L124:
            r103[ReturnType.All.ordinal()] = 3;     // Catch: NoSuchFieldError -> L66
        L28:
            int[] r104 = new int[ActionContext.values().length];
            r104[ActionContext.LoginContext.ordinal()] = 1;     // Catch: NoSuchFieldError -> L67
        L144:
            r104[ActionContext.LogoutContext.ordinal()] = 2;     // Catch: NoSuchFieldError -> L68
        L86:
            r104[ActionContext.SwitchContext.ordinal()] = 3;     // Catch: NoSuchFieldError -> L69
        L98:
            r104[ActionContext.InternalContext.ordinal()] = 4;     // Catch: NoSuchFieldError -> L70
        L33:
            int[] r105 = new int[UserState.values().length];
            r105[UserState.ONLINE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L71
        L120:
            r105[UserState.OFFLINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L72
        L132:
            r105[UserState.ABSENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L73
        L37:
            f438167a = r105;
            int[] r106 = new int[com.ss.android.lark.passportc.api.Scene.values().length];
            r106[com.ss.android.lark.passportc.api.Scene.FIRST_ONLINE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L74
        L84:
            r106[com.ss.android.lark.passportc.api.Scene.SWITCH_ONLINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L75
        L96:
            r106[com.ss.android.lark.passportc.api.Scene.FAST_ONLINE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L76
        L104:
            r106[com.ss.android.lark.passportc.api.Scene.SWITCH_BACKGROUND.ordinal()] = 4;     // Catch: NoSuchFieldError -> L77
        L112:
            r106[com.ss.android.lark.passportc.api.Scene.SWITCH_FOREGROUND.ordinal()] = 5;     // Catch: NoSuchFieldError -> L78
        L122:
            r106[com.ss.android.lark.passportc.api.Scene.CREATE_USER_COMPONENT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L79
        L44:
            f438168b = r106;
            int[] r107 = new int[com.lark.kmp.basic.UserState.values().length];
            r107[com.lark.kmp.basic.UserState.ONLINE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L80
        L146:
            r107[com.lark.kmp.basic.UserState.OFFLINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L81
        L88:
            r107[com.lark.kmp.basic.UserState.PRE_ONLINE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L82
        L100:
            r107[com.lark.kmp.basic.UserState.ABSENT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L83
            return;
        }
    }

    static {
    }

    public static Scene a(com.ss.android.lark.passportc.api.Scene r100) {
        if (r100 != null) goto L4;
        int r101 = -1;
    L5:
        switch(r101) {
            case -1: goto L14;
            case 0: goto L7;
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            default: goto L7;
        };
    L14:
        return null;
    L7:
        throw new NoWhenBranchMatchedException();
    L16:
        return Scene.CREATE_USER_COMPONENT;
    L17:
        return Scene.SWITCH_FOREGROUND;
    L18:
        return Scene.SWITCH_BACKGROUND;
    L19:
        return Scene.FAST_ONLINE;
    L20:
        return Scene.SWITCH_ONLINE;
    L21:
        return Scene.FIRST_ONLINE;
    L4:
        r101 = a.f438168b[r100.ordinal()];
        goto L5
    }

    public static p b(g r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        User r101 = r100.f475033a;
        loa.a r102 = new loa.a(r101.userId, r101.name);
        UserSession r103 = r100.f475034b;
        return new p(r102, r103.f438138b, r103.f438137a);
    }

    public static u c(h r100) {
        Intrinsics.checkNotNullParameter(r100, "userStatePayload");
        UserState r101 = r100.f475035a;
        int r102 = a.f438167a[r101.ordinal()];
        if (r102 != 1) goto L5;
        com.lark.kmp.basic.UserState r103 = com.lark.kmp.basic.UserState.ONLINE;
    L13:
        a(r100.f475036b);
        Intrinsics.checkNotNullParameter(r100.getContext(), "userActionContext");
        return new u(r103, ActionContext.InternalContext);
    L5:
        if (r102 != 2) goto L7;
        r103 = com.lark.kmp.basic.UserState.OFFLINE;
        goto L13
    L7:
        if (r102 != 3) goto L10;
        r103 = com.lark.kmp.basic.UserState.ABSENT;
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
