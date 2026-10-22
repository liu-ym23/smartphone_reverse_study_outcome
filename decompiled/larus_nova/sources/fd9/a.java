package fd9;

import com.larus.im.constant.CompensateScene;
import com.larus.im.internal.jni.bean.OmniFetchCmdChainScene;
import com.larus.im.internal.jni.bean.OmniFetchRecentConvScene;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: fd9.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C5883a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f476543a = null;

        static {
            int[] r100 = new int[CompensateScene.values().length];
            r100[CompensateScene.COLD_LAUNCH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[CompensateScene.FRONTIER_DISCONNECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[CompensateScene.FRONTIER_RECOVER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[CompensateScene.ACCOUNT_SWITCH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[CompensateScene.FRONTIER_NEW_MSG.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[CompensateScene.GET_MAIN_CONVERSATION.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[CompensateScene.ON_DATABASE_CORRUPTED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[CompensateScene.DOWNGRADE_REFORM.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f476543a = r100;
        }
    }

    public static final OmniFetchCmdChainScene a(CompensateScene r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        switch(C5883a.f476543a[r100.ordinal()]) {
            case 1: goto L14;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L15:
        return OmniFetchCmdChainScene.REFORM;
    L16:
        return OmniFetchCmdChainScene.ON_DATABASE_CORRUPTED;
    L17:
        return OmniFetchCmdChainScene.GET_MAIN_CONVERSATION;
    L18:
        return OmniFetchCmdChainScene.VERSION_CHANGE;
    L19:
        return OmniFetchCmdChainScene.ACCOUNT_SWITCH;
    L20:
        return OmniFetchCmdChainScene.FRONTIER_RECOVER;
    L21:
        return OmniFetchCmdChainScene.FRONTIER_DISCONNECT;
    L14:
        return OmniFetchCmdChainScene.COLD_LAUNCH;
    }

    public static final OmniFetchRecentConvScene b(CompensateScene r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        switch(C5883a.f476543a[r100.ordinal()]) {
            case 1: goto L14;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L15:
        return OmniFetchRecentConvScene.DOWNGRADE_REFORM;
    L16:
        return OmniFetchRecentConvScene.ON_DATABASE_CORRUPTED;
    L17:
        return OmniFetchRecentConvScene.GET_MAIN_CONVERSATION;
    L18:
        return OmniFetchRecentConvScene.VERSION_CHANGE;
    L19:
        return OmniFetchRecentConvScene.ACCOUNT_SWITCH;
    L20:
        return OmniFetchRecentConvScene.FRONTIER_RECOVER;
    L21:
        return OmniFetchRecentConvScene.FRONTIER_DISCONNECT;
    L14:
        return OmniFetchRecentConvScene.COLD_LAUNCH;
    }
}
