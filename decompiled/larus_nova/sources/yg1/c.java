package yg1;

import android.content.Context;
import android.os.MessageQueue;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.android.livehostapi.foundation.depend.PluginType;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.qe0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import com.mammon.audiosdk.BuildConfig;
import com.ss.android.lark.utils.statistics.PerfLog;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements yg1.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f567475c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f567476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f567477b;

    public static final class a {
    }

    public static final class b implements MessageQueue.IdleHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f567478a;

        public b(c r100) {
            this.f567478a = r100;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            c r100 = this.f567478a;
            r100.getClass();
            PluginType r101 = PluginType.Camera;
            if (r101.isInstalled() == false) goto L5;
            ALogger.d("LoadLiveSourceTask", "has installed camera");
            c.a();
            c.b();
        L6:
            return false;
        L5:
            r101.checkInstall(r100.getContext(), PbRequest.SwitchType.GIFT, new d(r100), false);
            goto L6
        }
    }

    static {
        f567475c = new String[]{"yuv", "NailSLAM_jni", "ttffmpeg", "c++_shared", "AGFX", "bytenn", BuildConfig.LIBNAME, "byteaudio", "gaia_lib", "effect"};
    }

    public static void a() {
        IHostPlugin r100 = (IHostPlugin) k.f(IHostPlugin.class);
        String[] r101 = f567475c;
        int r102 = r101.length;
        int r110 = 0;
    L3:
        if (r110 >= r102) goto L13;
        String r111 = r101[r110];
        ALogger.d("LoadLiveSourceTask", "start load library: " + r111);     // Catch: Throwable -> L10
        if (qe0.f121049a.getValue().booleanValue() == false) goto L8;
        Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L10
        r100.loadLibraryV2(2, s1.getContext(), "", r111, null);     // Catch: Throwable -> L10
    L12:
        r110 = r110 + 1;
        goto L3
    L8:
        Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L10
        r100.loadLibrary(2, s1.getContext(), "", r111, null);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        ALogger.e("LoadLiveSourceTask", "load library " + r111 + " fail: " + th.getMessage());
        goto L12
    }

    public static void b() {
        RoomContext.a r100 = RoomContext.Companion;
        String r101 = null;
        RoomContext r102 = RoomContext.a.c(r100, null, 0, 3);
        if (r102 == null) goto L7;
        m<Boolean> r103 = r102.isLoadLiveSourcePlugin();
        if (r103 == null) goto L7;
        r103.setValue(Boolean.FALSE);
    L7:
        RoomContext r104 = RoomContext.a.c(r100, null, 0, 3);
        if (r104 == null) goto L12;
        m<Room> r105 = r104.getRoom();
        if (r105 == null) goto L12;
        Room r106 = r105.getValue();
    L13:
        if (r106 != null) goto L15;
        return;
    L15:
        if (r106.isVsRoom() == false) goto L17;
        return;
    L17:
        if (r106.isMergeVSRoom() == true) goto L28;
        IGiftServiceExternal r107 = (IGiftServiceExternal) k.n(IGiftServiceExternal.class);
        long r108 = r106.f162599id;
        if (r106.mo8271getOwner() == null) goto L23;
        User r109 = r106.mo8271getOwner();
        if (r109 == null) goto L24;
        r101 = r109.getCastSecUid();
    L24:
        r107.syncGiftList(null, r108, 2, false, r101);
        return;
    L23:
        r101 = "";
        goto L24
    L28:
        return;
    L12:
        r106 = null;
        goto L13
    }

    @Override // yg1.a
    public Context getContext() {
        return this.f567477b;
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f567477b = r100;
        this.f567476a = new b(this);
    }
}
