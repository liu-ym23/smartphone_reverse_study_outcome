package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.e6;
import com.bytedance.android.livesdk.f6;
import com.bytedance.android.livesdk.g6;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveRTChorusSpatialAudioConfig;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\t\u0010\nR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RealTimeChorusBusinessContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/j;", "Lfd2/s;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "<init>", "()V", "Companion", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RealTimeChorusBusinessContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final int NEW_VERSION = 1;
    public static final int OLD_VERSION = 0;
    public static final String REAL_TIME_CHORUS_ENABLE_KEY = "linkmic_real_time_chorus";
    public static final String TAG = "RealTimeChorusBusinessContext";
    private final com.bytedance.live.datacontext.p service$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static boolean h() {
            if (((LiveRTChorusSpatialAudioConfig) g6.a.getValue()).getChorusSpatialEnable() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @JvmStatic
        public static boolean i() {
            Integer r0 = (Integer) f6.a.getValue();
            if (r0 != null) goto L6;
        L21:
            if (r0 != null) goto L24;
        L26:
            if (r0 != null) goto L29;
            return false;
        L29:
            if (r0.intValue() != 2) goto L33;
        L30:
            return true;
        L33:
            return false;
        L24:
            if (r0.intValue() != 1) goto L26;
            return false;
        L6:
            if (r0.intValue() != 0) goto L21;
            com.bytedance.android.livesdk.chatroom.o r1 = o3.f();
            if (r1 == null) goto L18;
            com.bytedance.live.datacontext.m r2 = r1.getRoom();
            if (r2 == null) goto L18;
            IRoom r3 = (IRoom) r2.getValue();
            if (r3 == null) goto L18;
            Map r4 = r3.getAnchorABMap();
            if (r4 == null) goto L18;
            String r5 = (String) r4.get("lead_real_time_chorus");
            if (r5 == null) goto L18;
            int r6 = CastIntegerProtector.parseInt(r5);
        L19:
            if (r6 > 1) goto L30;
            return false;
        L18:
            r6 = 0;
            goto L19
        }

        @JvmStatic
        public final RealTimeChorusBusinessContext getContext() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(RealTimeChorusBusinessContext.class);
            if ((r0 instanceof RealTimeChorusBusinessContext) == true) goto L6;
            r0 = null;
        L6:
            return (RealTimeChorusBusinessContext) r0;
        }

        @JvmStatic
        public static boolean g() {
            com.bytedance.android.livesdk.chatroom.u r0 = o3.d();
            Integer r1 = null;
            if (r0 == null) goto L11;
            com.bytedance.live.datacontext.j r2 = r0.s();
            if (r2 == null) goto L11;
            com.bytedance.android.livesdk.chatroom.viewmodel.f r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r2.getValue();
            if (r3 == null) goto L11;
            com.bytedance.android.livesdk.chatroom.viewmodel.i r4 = r3.t();
            if (r4 == null) goto L11;
            Integer r5 = Integer.valueOf(r4.a);
        L12:
            com.bytedance.android.livesdk.chatroom.u r6 = o3.d();
            if (r6 == null) goto L21;
            com.bytedance.live.datacontext.j r7 = r6.s();
            if (r7 == null) goto L21;
            com.bytedance.android.livesdk.chatroom.viewmodel.f r8 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r7.getValue();
            if (r8 == null) goto L21;
            com.bytedance.android.livesdk.chatroom.viewmodel.i r9 = r8.t();
            if (r9 == null) goto L21;
            r1 = Integer.valueOf(r9.b);
        L21:
            if (r5 != null) goto L24;
        L30:
            return false;
        L24:
            if (r5.intValue() != 9) goto L30;
            if (r1 == null) goto L30;
            if (r1.intValue() != 61) goto L30;
            return true;
        L11:
            r5 = null;
            goto L12
        }

        @JvmStatic
        public final int a() {
            RealTimeChorusBusinessContext r0 = getContext();
            if (r0 == null) goto L9;
            com.bytedance.live.datacontext.j<fd2.s> r1 = r0.m454getService();
            if (r1 == null) goto L9;
            fd2.s r2 = (fd2.s) r1.getValue();
            if (r2 == null) goto L9;
            return r2.sb();
        L9:
            return 0;
        }

        @JvmStatic
        public final int b() {
            RealTimeChorusBusinessContext r0 = getContext();
            if (r0 == null) goto L9;
            com.bytedance.live.datacontext.j<fd2.s> r1 = r0.m454getService();
            if (r1 == null) goto L9;
            fd2.s r2 = (fd2.s) r1.getValue();
            if (r2 == null) goto L9;
            return r2.i0();
        L9:
            return 0;
        }

        @JvmStatic
        public final fd2.s c() {
            RealTimeChorusBusinessContext r0 = getContext();
            if (r0 == null) goto L7;
            com.bytedance.live.datacontext.j<fd2.s> r1 = r0.m454getService();
            if (r1 == null) goto L7;
            return (fd2.s) r1.getValue();
        L7:
            return null;
        }

        @JvmStatic
        public final int d() {
            fd2.s r0 = c();
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.f8();
        }

        @JvmStatic
        public final boolean e() {
            RealTimeChorusBusinessContext r0 = getContext();
            if (r0 == null) goto L9;
            com.bytedance.live.datacontext.j<fd2.s> r1 = r0.m454getService();
            if (r1 == null) goto L9;
            fd2.s r2 = (fd2.s) r1.getValue();
            if (r2 == null) goto L9;
            return r2.ko();
        L9:
            return false;
        }

        @JvmStatic
        public final boolean f() {
            if (j() == true) goto L5;
        L9:
            return false;
        L5:
            if (d() != 3) goto L7;
        L8:
            return true;
        L7:
            if (d() != 4) goto L9;
            goto L8
        }

        @JvmStatic
        public final boolean j() {
            if (b() != 2) goto L5;
            return true;
        L5:
            return false;
        }

        @JvmStatic
        public final void m(LifecycleOwner r2, Observer<Integer> r3) {
            Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
            Intrinsics.checkNotNullParameter(r3, "observer");
            RealTimeChorusBusinessContext r0 = getContext();
            if (r0 == null) goto L10;
            com.bytedance.live.datacontext.j<fd2.s> r1 = r0.m454getService();
            if (r1 == null) goto L11;
            fd2.s r4 = (fd2.s) r1.getValue();
            if (r4 == null) goto L12;
            r4.pn(r2, r3);
            return;
        L12:
            return;
        L11:
            return;
        }

        @JvmStatic
        public final void n(LifecycleOwner r2, Observer<Boolean> r3) {
            Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
            Intrinsics.checkNotNullParameter(r3, "observer");
            RealTimeChorusBusinessContext r0 = getContext();
            if (r0 == null) goto L10;
            com.bytedance.live.datacontext.j<fd2.s> r1 = r0.m454getService();
            if (r1 == null) goto L11;
            fd2.s r4 = (fd2.s) r1.getValue();
            if (r4 == null) goto L12;
            r4.kj(r2, r3);
            return;
        L12:
            return;
        L11:
            return;
        }

        @JvmStatic
        public final void o(LifecycleOwner r2, Observer<Integer> r3) {
            Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
            Intrinsics.checkNotNullParameter(r3, "observer");
            RealTimeChorusBusinessContext r0 = getContext();
            if (r0 == null) goto L10;
            com.bytedance.live.datacontext.j<fd2.s> r1 = r0.m454getService();
            if (r1 == null) goto L11;
            fd2.s r4 = (fd2.s) r1.getValue();
            if (r4 == null) goto L12;
            r4.cp(r2, r3);
            return;
        L12:
            return;
        L11:
            return;
        }

        @JvmStatic
        public final void k(MusicPanel r2, Function1<Object, Unit> r3, Function1<? super Throwable, Unit> r4) {
            Intrinsics.checkNotNullParameter(r2, "music");
            Intrinsics.checkNotNullParameter(r3, "successCallback");
            Intrinsics.checkNotNullParameter(r4, "failCallback");
            RealTimeChorusBusinessContext r0 = getContext();
            if (r0 == null) goto L10;
            com.bytedance.live.datacontext.j<fd2.s> r1 = r0.m454getService();
            if (r1 == null) goto L11;
            fd2.s r5 = (fd2.s) r1.getValue();
            if (r5 == null) goto L12;
            r5.Fi(r2, r3, r4);
            return;
        L12:
            return;
        L11:
            return;
        }

        @JvmStatic
        public final void l(double r2, int r4, Function1<? super Boolean, Unit> r5) {
            RealTimeChorusBusinessContext r0 = getContext();
            if (r0 == null) goto L10;
            com.bytedance.live.datacontext.j<fd2.s> r1 = r0.m454getService();
            if (r1 == null) goto L11;
            fd2.s r3 = (fd2.s) r1.getValue();
            if (r3 == null) goto L12;
            r3.km(r2, r4, r5);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(RealTimeChorusBusinessContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final RealTimeChorusBusinessContext getContext() {
        return Companion.getContext();
    }

    @JvmStatic
    public static final int getCurrentChorusMode() {
        return Companion.a();
    }

    @JvmStatic
    public static final int getRealTimeChorusRole() {
        return Companion.b();
    }

    @JvmStatic
    public static final fd2.s getService() {
        return Companion.c();
    }

    @JvmStatic
    public static final int getUserType() {
        return Companion.d();
    }

    @JvmStatic
    public static final boolean isAssignLead() {
        return Companion.e();
    }

    @JvmStatic
    public static final boolean isCDNViceSinger() {
        return Companion.f();
    }

    @JvmStatic
    public static final boolean isInRealTimeChorus() {
        Companion.getClass();
        return a.g();
    }

    @JvmStatic
    public static final boolean isRTChorusSpatialAudioEnable() {
        Companion.getClass();
        return a.h();
    }

    @JvmStatic
    public static final boolean isRealTimeLeadChorusEnable() {
        Companion.getClass();
        return a.i();
    }

    @JvmStatic
    public static final boolean isViceSinger() {
        return Companion.j();
    }

    @JvmStatic
    public static final void joinRealTimeChorus(MusicPanel r1, Function1<Object, Unit> r2, Function1<? super Throwable, Unit> r3) {
        Companion.k(r1, r2, r3);
    }

    @JvmStatic
    public static final void leaveRealTimeChorus(double r1, int r3, Function1<? super Boolean, Unit> r4) {
        Companion.l(r1, r3, r4);
    }

    @JvmStatic
    public static final void observerCurUserRealTimeChorusUserType(LifecycleOwner r1, Observer<Integer> r2) {
        Companion.m(r1, r2);
    }

    @JvmStatic
    public static final void observerIsChorusAssignLeader(LifecycleOwner r1, Observer<Boolean> r2) {
        Companion.n(r1, r2);
    }

    @JvmStatic
    public static final void observerRealTimeChorusRole(LifecycleOwner r1, Observer<Integer> r2) {
        Companion.o(r1, r2);
    }

    /* JADX INFO: renamed from: getService, reason: collision with other method in class */
    public final com.bytedance.live.datacontext.j<fd2.s> m454getService() {
        return (com.bytedance.live.datacontext.j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    @JvmStatic
    public static final boolean curUserIsLead() {
        RealTimeChorusBusinessContext r0 = Companion.getContext();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.j<fd2.s> r1 = r0.m454getService();
        if (r1 == null) goto L9;
        fd2.s r2 = (fd2.s) r1.getValue();
        if (r2 == null) goto L9;
        return r2.Y5();
    L9:
        return false;
    }

    @JvmStatic
    public static final fd2.e0 getLocalNetworkQualityStats() {
        RealTimeChorusBusinessContext r0 = Companion.getContext();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.j<fd2.s> r1 = r0.m454getService();
        if (r1 == null) goto L9;
        fd2.s r2 = (fd2.s) r1.getValue();
        if (r2 == null) goto L9;
        return r2.D7();
    L9:
        return null;
    }

    @JvmStatic
    public static final int getSpatialAudioDistance() {
        Companion.getClass();
        return ((LiveRTChorusSpatialAudioConfig) g6.a.getValue()).getDistanceParams();
    }

    @JvmStatic
    public static final zi6.c getSpatialAudioLayout() {
        Companion.getClass();
        if (((LiveRTChorusSpatialAudioConfig) g6.a.getValue()).getSpatialLayout() != 0) goto L6;
        return zi6.c.b.a;
    L6:
        return zi6.c.c.a;
    }

    @JvmStatic
    public static final boolean isLeadSinger() {
        if (Companion.b() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @JvmStatic
    public static final boolean isRealTimeChorusEnable() {
        Companion.getClass();
        Integer r0 = (Integer) e6.a.getValue();
        if (r0 != null) goto L6;
    L21:
        if (r0 != null) goto L24;
    L26:
        if (r0 != null) goto L29;
        return false;
    L29:
        if (r0.intValue() != 2) goto L33;
    L30:
        return true;
    L33:
        return false;
    L24:
        if (r0.intValue() != 1) goto L26;
        return false;
    L6:
        if (r0.intValue() != 0) goto L21;
        com.bytedance.android.livesdk.chatroom.o r1 = o3.f();
        if (r1 == null) goto L18;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L18;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L18;
        Map r4 = r3.getAnchorABMap();
        if (r4 == null) goto L18;
        String r5 = (String) r4.get("real_time_chorus");
        if (r5 == null) goto L18;
        int r6 = CastIntegerProtector.parseInt(r5);
    L19:
        if (r6 > 0) goto L30;
        return false;
    L18:
        r6 = 0;
        goto L19
    }

    public RealTimeChorusBusinessContext() {
        this.service$delegate = ConstantKt.c(this);
    }

    @JvmStatic
    public static final void updateSubToken(String r2) {
        a r0 = Companion;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "token");
        fd2.s r1 = r0.c();
        if (r1 == null) goto L6;
        r1.W8(r2);
        return;
    }
}
