package r42;

import android.text.TextUtils;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyContext;
import com.bytedance.android.livesdk.g7;
import com.bytedance.android.livesdk.interactivity.api.base.utils.InteractivityOpt;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import r52.f3;
import r52.h3;
import r52.j0;

/* JADX INFO: loaded from: classes9.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f536040a = 0;

    @JvmStatic
    public static final boolean b() {
        if (j0.f536200a.getValue().booleanValue() == true) goto L5;
        return false;
    L5:
        IRoomContextService r100 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        Boolean r101 = null;
        if (r100 == null) goto L8;
        com.bytedance.android.livesdk.chatroom.o r102 = IRoomContextService.a.a(r100, null, 0, 3);
    L9:
        if (r102 == null) goto L12;
        r101 = r102.isAnchor();
    L12:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L14;
        return false;
    L14:
        if (r102 == null) goto L25;
        com.bytedance.live.datacontext.m<IRoom> r103 = r102.getRoom();
        if (r103 == null) goto L25;
        IRoom r104 = r103.getValue();
        if (r104 == null) goto L25;
        IRoomAuthStatus r105 = r104.getRoomAuthStatus();
        if (r105 == null) goto L25;
        if (r105.isEnableLoadMoreHistory() != true) goto L25;
        return true;
    L25:
        return false;
    L8:
        r102 = null;
        goto L9
    }

    @JvmStatic
    public static final boolean c() {
        if (h3.f536191a.getValue().booleanValue() == false) goto L5;
    L8:
        return true;
    L5:
        if (g7.f125384a.getValue().getForceUseV3() == true) goto L8;
        return false;
    }

    public static int d() {
        Lazy r100 = PublicScreenABHelper.f133581a;
        if (TextUtils.isEmpty(f3.f536179a.getValue()) == false) goto L5;
        return 7;
    L5:
        IRoomContextService r101 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        com.bytedance.android.livesdk.chatroom.o r102 = null;
        if (r101 == null) goto L8;
        r102 = IRoomContextService.a.a(r101, null, 0, 3);
    L8:
        if (r102 == null) goto L19;
        com.bytedance.live.datacontext.j<IDynamicStrategyContext> r103 = r102.r2();
        if (r103 == null) goto L20;
        IDynamicStrategyContext r104 = r103.getValue();
        if (r104 == null) goto L21;
        PropertyOwner<ju1.n> r105 = r104.getStrategy("public_screen_load_history_strategy");
        if (r105 == null) goto L22;
        ju1.n r106 = r105.f64752a;
        if (r106 != null) goto L18;
        return 7;
    L18:
        return r106.b(7);
    L22:
        return 7;
    L21:
        return 7;
    L20:
        return 7;
    L19:
        return 7;
    }

    static {
    }

    @JvmStatic
    public static final boolean a(IRoom r100, Boolean r101) {
        if (((Boolean) InteractivityOpt.c(j0.f536200a)).booleanValue() == true) goto L5;
        return false;
    L5:
        IRoomContextService r102 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r102 == null) goto L8;
        com.bytedance.android.livesdk.chatroom.o r103 = IRoomContextService.a.a(r102, null, 0, 3);
    L9:
        if (r101 != null) goto L14;
        if (r103 == null) goto L12;
        r101 = r103.isAnchor();
        goto L14
    L12:
        r101 = null;
    L14:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L16;
        return false;
    L16:
        if (r100 != null) goto L22;
        if (r103 == null) goto L21;
        com.bytedance.live.datacontext.m<IRoom> r104 = r103.getRoom();
        if (r104 == null) goto L21;
        r100 = r104.getValue();
    L21:
        r100 = null;
    L22:
        if (r100 == null) goto L29;
        IRoomAuthStatus r105 = r100.getRoomAuthStatus();
        if (r105 == null) goto L29;
        if (r105.isEnableFirstFetchHistory() != true) goto L29;
        return true;
    L29:
        return false;
    L8:
        r103 = null;
        goto L9
    }
}
