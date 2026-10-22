package il0;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.openlive.realtime.IUserRealtimeSignalFeature;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public class a implements IService {
    public a() {
    }

    public void broadcastAuthUtilsCheckLogin(Context r100, boolean r101, Function1<? super IBaseUser, Unit> r102, Function1<? super Throwable, Unit> r103) {
        Intrinsics.checkNotNullParameter(r102, "onAuth");
        Intrinsics.checkNotNullParameter(r103, LynxVideoManagerLite.EVENT_ON_ERROR);
    }

    public void commonPopupMessageWidgetOnInRoomPushEvent(Widget r100, WeakHandler r101, Object r102, int r103, Function0<Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        Intrinsics.checkNotNullParameter(r101, "handler");
        Intrinsics.checkNotNullParameter(r102, "event");
        Intrinsics.checkNotNullParameter(r104, "dismissBlock");
    }

    public String getSecKey() {
        return "";
    }

    public IUserRealtimeSignalFeature getUserRealtimeSignalFeature() {
        return null;
    }

    public boolean initAudioSDKPluginLoader() {
        return false;
    }

    public void openAgreeToStartLiveDialog(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "verifyParam");
    }

    public void preloadOnlineEmoji() {
    }

    public void readLocationForSaas(Context r100, Function1<? super String, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "runAfter");
    }

    public static /* synthetic */ void broadcastAuthUtilsCheckLogin$default(a r100, Context r101, boolean r102, Function1 r103, Function1 r104, int r105, Object r106) {
        if (r106 != null) goto L9;
        if ((r105 & 2) == 0) goto L6;
        r102 = false;
    L6:
        r100.broadcastAuthUtilsCheckLogin(r101, r102, r103, r104);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: broadcastAuthUtilsCheckLogin");
    }
}
