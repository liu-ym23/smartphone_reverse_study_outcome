package com.bytedance.android.livesdk.landscapeslide;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.utils.landscape.LandscapeLiveMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrlExtra;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.live.datacontext.DataContext;
import java.util.HashMap;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/landscapeslide/PreRoomInfoContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "mPreRoomId", "J", "", "mPreOrientation", "I", "mCurRoomId", "mCurOrientation", "", "mCurSupportLand", "Z", "Lcom/bytedance/android/livesdk/landscapeslide/h;", "mCurRoomInfo", "Lcom/bytedance/android/livesdk/landscapeslide/h;", "<init>", "()V", "Companion", "a", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreRoomInfoContext extends DataContext {
    public static final a Companion = null;
    private static final String TAG = "PreRoomInfoContext";
    private int mCurOrientation;
    private long mCurRoomId;
    private h mCurRoomInfo;
    private boolean mCurSupportLand;
    private int mPreOrientation;
    private long mPreRoomId;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static HashMap c() {
            Pair[] r0 = new Pair[2];
            PreRoomInfoContext r1 = d();
            if (r1 == null) goto L5;
            int r2 = PreRoomInfoContext.access$getMPreOrientation$p(r1);
        L6:
            int r3 = 0;
            r0[0] = TuplesKt.to("pre_room_orientation", String.valueOf(r2));
            PreRoomInfoContext r4 = d();
            if (r4 != null) goto L9;
        L11:
            r0[1] = TuplesKt.to("is_support_landscape", String.valueOf(r3));
            return MapsKt.hashMapOf(r0);
        L9:
            if (PreRoomInfoContext.access$getMCurSupportLand$p(r4) != true) goto L11;
            r3 = 1;
            goto L11
        L5:
            r2 = -1;
            goto L6
        }

        @JvmStatic
        public static HashMap b() {
            com.bytedance.android.livesdk.user.e r0 = k.n(IMiddlewareUserService.class).user();
            String r1 = null;
            if (r0 == null) goto L5;
            String r2 = r0.n();
        L6:
            PreRoomInfoContext r3 = d();
            if (r3 == null) goto L11;
            h r4 = PreRoomInfoContext.access$getMCurRoomInfo$p(r3);
            if (r4 == null) goto L11;
            long r5 = r4.a;
        L12:
            PreRoomInfoContext r6 = d();
            if (r6 == null) goto L18;
            h r7 = PreRoomInfoContext.access$getMCurRoomInfo$p(r6);
            if (r7 == null) goto L18;
            r1 = r7.b;
        L18:
            return MapsKt.hashMapOf(new Pair[]{TuplesKt.to("room_id", String.valueOf(r5)), TuplesKt.to("anchor_id", String.valueOf(r1)), TuplesKt.to("user_id", String.valueOf(r2))});
        L11:
            r5 = 0;
            goto L12
        L5:
            r2 = null;
            goto L6
        }

        @JvmStatic
        public static PreRoomInfoContext d() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(PreRoomInfoContext.TAG);
            if ((r0 instanceof PreRoomInfoContext) == true) goto L6;
            r0 = null;
        L6:
            return (PreRoomInfoContext) r0;
        }

        @JvmStatic
        public static h a(ds0.d r12) {
            Intrinsics.checkNotNullParameter(r12, "roomSession");
            Room r0 = r12.w();
            if (r0 == null) goto L5;
            StreamUrlExtra r1 = r0.getStreamUrlExtra();
        L7:
            if (r1 == null) goto L9;
            int r4 = r1.getWidth();
        L10:
            Integer r5 = Integer.valueOf(r4);
            if (r1 == null) goto L13;
            int r2 = r1.getHeight();
        L14:
            Pair r3 = new Pair(r5, Integer.valueOf(r2));
            long r6 = r12.x();
            String r8 = r12.getUserId();
            ILivePlayerClient r7 = r12.m();
            if (r7 == null) goto L20;
            Pair r9 = r7.getVideoSize();
            if (r9 == null) goto L20;
            Pair r10 = r9;
        L21:
            int r11 = r12.getScreenOrientation();
            if (r0 != null) goto L24;
        L31:
            boolean r13 = true;
        L33:
            return new h(r6, r8, r10, r11, r13);
        L24:
            if (r0.getRoomAuthStatus() == null) goto L31;
            if (r0.getRoomAuthStatus().isEnableSwitchLandscape() == true) goto L31;
            if (r0.isPaidRoom() == true) goto L31;
            r13 = false;
        L20:
            r10 = r3;
            goto L21
        L13:
            r2 = 0;
            goto L14
        L9:
            r4 = 0;
            goto L10
        L5:
            r1 = null;
            goto L7
        }

        @JvmStatic
        public static void e(h r8) {
            Intrinsics.checkNotNullParameter(r8, "roomInfo");
            boolean r1 = false;
            if (r8.d != 1) goto L5;
            int r0 = 0;
        L6:
            Pair<Integer, Integer> r3 = r8.c;
            int r4 = ((Number) r3.component1()).intValue();
            int r5 = ((Number) r3.component2()).intValue();
            PreRoomInfoContext r6 = d();
            if (r6 == null) goto L13;
            PreRoomInfoContext r7 = d();
            if (r7 == null) goto L11;
            long r9 = PreRoomInfoContext.access$getMCurRoomId$p(r7);
        L12:
            PreRoomInfoContext.access$setMPreRoomId$p(r6, r9);
            goto L13
        L11:
            r9 = -1;
        L13:
            PreRoomInfoContext r10 = d();
            if (r10 == null) goto L20;
            PreRoomInfoContext r11 = d();
            if (r11 == null) goto L18;
            int r12 = PreRoomInfoContext.access$getMCurOrientation$p(r11);
        L19:
            PreRoomInfoContext.access$setMPreOrientation$p(r10, r12);
            goto L20
        L18:
            r12 = -1;
        L20:
            PreRoomInfoContext r13 = d();
            if (r13 == null) goto L23;
            PreRoomInfoContext.access$setMCurRoomId$p(r13, r8.a);
        L23:
            PreRoomInfoContext r14 = d();
            if (r14 == null) goto L26;
            PreRoomInfoContext.access$setMCurOrientation$p(r14, r0);
        L26:
            PreRoomInfoContext r2 = d();
            if (r2 == null) goto L33;
            if (r4 > r5) goto L30;
        L32:
            PreRoomInfoContext.access$setMCurSupportLand$p(r2, r1);
            goto L33
        L30:
            if (r8.e == false) goto L32;
            r1 = true;
        L33:
            PreRoomInfoContext r15 = d();
            if (r15 == null) goto L36;
            PreRoomInfoContext.access$setMCurRoomInfo$p(r15, r8);
        L36:
            com.bytedance.android.livesdk.utils.landscape.b.c(r8.toString());
            return;
        L5:
            r0 = 1;
            goto L6
        }
    }

    @JvmStatic
    public static final h createInfo(ds0.d r1) {
        Companion.getClass();
        return a.a(r1);
    }

    @JvmStatic
    public static final HashMap<String, String> getCurRoomInfo() {
        Companion.getClass();
        return a.b();
    }

    @JvmStatic
    public static final HashMap<String, String> getPreRoomInfo() {
        Companion.getClass();
        return a.c();
    }

    @JvmStatic
    public static final void setCurRoomInfo(h r1) {
        Companion.getClass();
        a.e(r1);
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    private static final PreRoomInfoContext getShared() {
        Companion.getClass();
        return a.d();
    }

    @JvmStatic
    public static final boolean isPreRoomLand() {
        Companion.getClass();
        PreRoomInfoContext r0 = a.d();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (access$getMPreOrientation$p(r0) != 1) goto L7;
        return true;
    }

    public PreRoomInfoContext() {
        this.mPreRoomId = -1;
        this.mPreOrientation = -1;
        this.mCurRoomId = -1;
        this.mCurOrientation = -1;
    }

    public static final /* synthetic */ int access$getMCurOrientation$p(PreRoomInfoContext r0) {
        return r0.mCurOrientation;
    }

    public static final /* synthetic */ long access$getMCurRoomId$p(PreRoomInfoContext r2) {
        return r2.mCurRoomId;
    }

    public static final /* synthetic */ h access$getMCurRoomInfo$p(PreRoomInfoContext r0) {
        return r0.mCurRoomInfo;
    }

    public static final /* synthetic */ boolean access$getMCurSupportLand$p(PreRoomInfoContext r0) {
        return r0.mCurSupportLand;
    }

    public static final /* synthetic */ int access$getMPreOrientation$p(PreRoomInfoContext r0) {
        return r0.mPreOrientation;
    }

    public static final /* synthetic */ long access$getMPreRoomId$p(PreRoomInfoContext r2) {
        return r2.mPreRoomId;
    }

    @JvmStatic
    public static final void init(FragmentActivity r2) {
        Companion.getClass();
        LandscapeLiveMonitor.a r0 = LandscapeLiveMonitor.Companion;
        PreRoomInfoContext$Companion$init$1 r1 = PreRoomInfoContext$Companion$init$1.INSTANCE;
        r0.getClass();
        LandscapeLiveMonitor.a.c(r2, r1);
        if (a.d() != null) goto L8;
        if (r2 == null) goto L9;
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r2, "owner");
        ViewModelProvider r3 = ViewModelProviders.of(r2);
        Intrinsics.checkNotNullParameter(PreRoomInfoContext.class, "cls");
        com.bytedance.live.datacontext.d.c(r3.get(PreRoomInfoContext.class), TAG);
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final void setCurRoomInfo(ds0.d r1) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r1, "roomSession");
        a.e(a.a(r1));
    }

    public static final /* synthetic */ void access$setMCurOrientation$p(PreRoomInfoContext r0, int r1) {
        r0.mCurOrientation = r1;
    }

    public static final /* synthetic */ void access$setMCurRoomId$p(PreRoomInfoContext r0, long r1) {
        r0.mCurRoomId = r1;
    }

    public static final /* synthetic */ void access$setMCurRoomInfo$p(PreRoomInfoContext r0, h r1) {
        r0.mCurRoomInfo = r1;
    }

    public static final /* synthetic */ void access$setMCurSupportLand$p(PreRoomInfoContext r0, boolean r1) {
        r0.mCurSupportLand = r1;
    }

    public static final /* synthetic */ void access$setMPreOrientation$p(PreRoomInfoContext r0, int r1) {
        r0.mPreOrientation = r1;
    }

    public static final /* synthetic */ void access$setMPreRoomId$p(PreRoomInfoContext r0, long r1) {
        r0.mPreRoomId = r1;
    }

    @JvmStatic
    public static final void updateCurRoomOrientation(long r3, int r5) {
        Companion.getClass();
        PreRoomInfoContext r0 = a.d();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 != access$getMCurRoomId$p(r0)) goto L16;
        int r4 = 1;
        if (r5 != 1) goto L10;
        r4 = 0;
    L10:
        PreRoomInfoContext r6 = a.d();
        if (r6 == null) goto L15;
        access$setMCurOrientation$p(r6, r4);
        return;
    L15:
        return;
    }
}
