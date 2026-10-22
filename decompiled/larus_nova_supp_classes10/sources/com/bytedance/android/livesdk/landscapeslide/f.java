package com.bytedance.android.livesdk.landscapeslide;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.filter.u;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrlExtra;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static /* synthetic */ void d(String r1) {
        c(r1, "LiveLandScapeSlideExtUtil");
    }

    @JvmStatic
    public static final boolean b(Room r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "from");
        if (r7 != null) goto L6;
        return false;
    L6:
        if (r7.isMediaRoom() == false) goto L10;
        d(r8 + " is media room roomid " + r7.id);
        return false;
    L10:
        if (r7.isMergeVSRoom() == false) goto L14;
        d(r8 + " is VS stream room roomid " + r7.id);
        return false;
    L14:
        if (r7.isVrRoom() == false) goto L17;
        d(r8 + " is vr room roomid " + r7.id);
        return false;
    L17:
        com.bytedance.android.livesdk.utils.landscape.g r1 = com.bytedance.android.livesdk.utils.landscape.f.a;
        Intrinsics.checkNotNullParameter(r7, "room");
        List r2 = com.bytedance.android.livesdk.utils.landscape.f.a.c();
        Object r3 = null;
        if (r2 == null) goto L31;
        Iterator r4 = r2.iterator();
    L21:
        if (r4.hasNext() == false) goto L30;
        Object r5 = r4.next();
        String r6 = (String) r5;
        Map r9 = r7.getLinkMap();
        if (r9 != null) goto L25;
    L27:
        boolean r10 = false;
    L28:
        if (r10 == false) goto L21;
        r3 = r5;
        goto L30
    L25:
        if (r9.containsKey(r6) != true) goto L27;
        r10 = true;
    L30:
        r3 = (String) r3;
    L31:
        if (r3 == null) goto L33;
        boolean r11 = true;
    L34:
        if (r11 == false) goto L37;
        d(r8 + " is linker room roomid " + r7.id);
        return false;
    L37:
        StreamUrl r12 = r7.getStreamUrl();
        if (r12 != null) goto L40;
    L43:
        StreamUrlExtra r13 = r7.getStreamUrlExtraSafely();
        if (r13.getWidth() <= r13.getHeight()) goto L46;
        boolean r14 = true;
    L47:
        if (r14 == false) goto L50;
        d(r8 + " is horizontal by new roomid " + r7.id);
        return true;
    L50:
        d(r8 + " not support roomid " + r7.id);
        return false;
    L46:
        r14 = false;
        goto L47
    L40:
        if (r12.getStreamOrientation() != 2) goto L43;
        d(r8 + " is horizontal by old roomid " + r7.id);
        return true;
    L33:
        r11 = false;
        goto L34
    }

    @JvmStatic
    public static final void c(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        Intrinsics.checkNotNullParameter(r4, LocationMonitorConst.TAG);
        LocalTestManager.a(new Class[]{wy.a.class});
        ALogger.i(r4, r3);
    }

    @JvmStatic
    public static final void f(DataCenter r4, int r5) {
        if (com.bytedance.android.livesdk.utils.landscape.f.a() == false) goto L13;
        MiddlewareRoomContext r6 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r4, 0, 2);
        if (r6 != null) goto L7;
        return;
    L7:
        m r7 = r6.isLiveLandSlideReturn();
        if (r5 != 1) goto L10;
        String r8 = "1";
    L11:
        r7.setValue(r8);
        return;
    L10:
        r8 = BDLocationException.ERROR_TIMEOUT;
        goto L11
    }

    @JvmStatic
    public static final void a(Room r5, boolean r6, boolean r7) {
        if (com.bytedance.android.livesdk.utils.landscape.f.a() == false) goto L36;
        o r0 = j0.l().c(IRoom.class);
        if ((r0 instanceof u) == true) goto L7;
        r0 = null;
    L7:
        u r1 = (u) r0;
        if (r1 == null) goto L37;
        String r2 = "1";
        if (r6 == false) goto L12;
        r1.remove("is_landscape_button_show");
    L25:
        if (e5.n() == false) goto L34;
        if (r7 == true) goto L34;
        LiveLandSlideContext.Companion.getClass();
        LiveLandSlideContext r8 = LiveLandSlideContext.a.a();
        if (r8 == null) goto L30;
        int r9 = r8.getRelateRoomIndex();
    L31:
        if (r9 != 0) goto L33;
        r2 = BDLocationException.ERROR_TIMEOUT;
    L33:
        r1.c("is_landscape_stream", r2);
        return;
    L30:
        r9 = 0;
    L34:
        r1.c("is_landscape_stream", BDLocationException.ERROR_TIMEOUT);
        return;
    L12:
        if (r5 == null) goto L22;
        IRoomAuthStatus r10 = r5.getRoomAuthStatus();
        if (r10 == null) goto L22;
        if (r10.isEnableSwitchLandscape() != true) goto L22;
        IBaseStreamUrl r11 = r5.getStreamUrl();
        if (r11 == null) goto L22;
        if (r11.getStreamOrientation() != 2) goto L22;
        String r12 = "1";
    L23:
        r1.c("is_landscape_button_show", r12);
    L22:
        r12 = BDLocationException.ERROR_TIMEOUT;
        goto L23
    L37:
        return;
    }

    @JvmStatic
    public static final List<String> e(List<? extends IRoom> r8, int r9, Function1<? super Integer, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r8, "roomList");
        Intrinsics.checkNotNullParameter(r10, "isFollowRecommend");
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r11 = r8.iterator();
        int r2 = 0;
    L4:
        if (r11.hasNext() == false) goto L27;
        Object r3 = r11.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        IRoom r5 = (IRoom) r3;
        StringBuilder r6 = new StringBuilder();
        String r7 = "";
        if (r2 != r9) goto L11;
        String r12 = "*";
    L12:
        r6.append(r12);
        if (((Boolean) r10.invoke(Integer.valueOf(r2))).booleanValue() == false) goto L15;
        r7 = "(f)";
    L15:
        r6.append(r7);
        r6.append(r5.getRoomId());
        IBaseStreamUrl r13 = r5.getStreamUrl();
        if (r13 != null) goto L18;
    L19:
        IStreamUrlExtra r14 = r5.getStreamUrlExtraSafely();
        if (r14.getWidth() <= r14.getHeight()) goto L22;
        boolean r15 = true;
    L23:
        if (r15 == false) goto L25;
    L24:
        String r16 = "(l)";
    L26:
        r6.append(r16);
        r0.add(r6.toString());
        r2 = r4;
        goto L4
    L25:
        r16 = "(p)";
        goto L26
    L22:
        r15 = false;
        goto L23
    L18:
        if (r13.getStreamOrientation() == 2) goto L24;
    L11:
        r12 = "";
        goto L12
    L27:
        return r0;
    }
}
