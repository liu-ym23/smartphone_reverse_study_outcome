package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability;

import am2.x;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.m1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.model.bean.h;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningVolumeType;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.ability.TuningEffectAbility;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.multilink.internal.api.core.service.IMultiLinkInternalService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.config.lf1;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.i;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.w;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.n;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements com.bytedance.android.live.ktv.common.tuningpanel.ability.a, com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a {
    public final boolean a;
    public final a b;
    public boolean c;
    public boolean d;
    public long e;
    public final MutableLiveData<List<h>> f;
    public final com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.c g;
    public final Lazy h;
    public final Lazy i;
    public double j;
    public String k;
    public float l;
    public float m;
    public float n;
    public float o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final com.bytedance.android.live.pushstream.d s;
    public final ec0.a t;
    public final WeakReference<Context> u;

    public final class a {
        public final MutableLiveData<Boolean> a;
        public final MutableLiveData<Boolean> b;
        public Boolean c;
        public boolean d;
        public Boolean e;
        public final AtomicBoolean f;
        public float g;
        public final MutableLiveData<Boolean> h;

        public a(b r4) {
            this.a = new MutableLiveData();
            this.b = new MutableLiveData();
            ((Boolean) com.bytedance.android.livesdk.sharedpref.c.j.getValue()).booleanValue();
            this.f = new AtomicBoolean(false);
            if (r4.isInRealTimeChorus() == false) goto L12;
            com.bytedance.android.livesdk.sharedpref.e r5 = com.bytedance.android.livesdk.sharedpref.c.a0;
            Float r0 = (Float) r5.getValue();
            if (r0 != null) goto L7;
        L10:
            float r6 = ((Number) r5.getValue()).floatValue();
            int r1 = KtvSettingHelper.c().h();
        L28:
            float r2 = r1;
            float r3 = r6;
            float r7 = r2;
        L29:
            this.g = r7 * r3;
            this.h = new MutableLiveData(Boolean.FALSE);
            return;
        L7:
            if (r0.floatValue() != (-1.0f)) goto L10;
            r7 = KtvSettingHelper.c().d();
            int r8 = KtvSettingHelper.c().h();
        L19:
            r3 = r8;
            goto L29
        L12:
            if (r4.Z() == false) goto L21;
            com.bytedance.android.livesdk.sharedpref.e r9 = com.bytedance.android.livesdk.sharedpref.c.b0;
            Float r10 = (Float) r9.getValue();
            if (r10 != null) goto L16;
        L20:
            r6 = ((Number) r9.getValue()).floatValue();
            r1 = KtvSettingHelper.d().d();
            goto L28
        L16:
            if (r10.floatValue() != (-1.0f)) goto L20;
            r7 = KtvSettingHelper.d().a();
            r8 = KtvSettingHelper.d().d();
            goto L19
        L21:
            com.bytedance.android.livesdk.sharedpref.e r11 = com.bytedance.android.livesdk.sharedpref.c.Z;
            Float r12 = (Float) r11.getValue();
            if (r12 != null) goto L24;
        L27:
            r6 = ((Number) r11.getValue()).floatValue();
            r1 = vm2.h.M().e();
            goto L28
        L24:
            if (r12.floatValue() != (-1.0f)) goto L27;
            r6 = vm2.h.M().a();
            r1 = vm2.h.M().e();
            goto L28
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.b$b, reason: collision with other inner class name */
    public static final class C0012b {
    }

    public static final class c implements cc0.c {
        public final /* synthetic */ b a;
        public final /* synthetic */ h b;
        public final /* synthetic */ boolean c;

        public final void a(String r7) {
            Intrinsics.checkNotNullParameter(r7, "filePath");
            if (this.a.h0(false) == false) goto L25;
            int r1 = com.bytedance.android.livesdk.ktvimpl.base.util.g.a;
            h r2 = this.b;
            Intrinsics.checkNotNullParameter(r2, "targetEffect");
            Intrinsics.checkNotNullParameter(r7, "filePath");
            JSONObject r0 = new JSONObject();
            JSONObject r3 = new JSONObject();
            r3.put("tuning_name", r2.d());
            r3.put("tuning_version", String.valueOf(r2.f()));
            String r4 = (String) CollectionsKt.getOrNull(r2.b().getUrls(), 0);
            if (r4 != null) goto L7;
            r4 = "";
        L7:
            r3.put("tuning_url", r4);
            r3.put("tuning_local_path", r7);
            Unit r5 = Unit.INSTANCE;
            r0.put("tuning_log", r3);
            b0.o().k("ttlive_ktv", r0);
            if ((!Intrinsics.areEqual(r7, "")) == false) goto L12;
            b r6 = this.a;
            h r8 = this.b;
            r6.getClass();
            Intrinsics.checkNotNullParameter(r7, "effectFilePath");
            Intrinsics.checkNotNullParameter(r8, BaseCoreViewModel.CORE_TAG_EFFECT);
            r6.k = r8.d();
            ALogger.i("KSongTuningCore", "setTuningEffect ;; effectFilePath == " + r7);
            if (this.c == false) goto L13;
            Long r9 = KtvLoggerHelper.a;
            KtvLoggerHelper.i0(System.currentTimeMillis() - this.a.z(), this.a.k, j.c());
            this.a.e = System.currentTimeMillis();
        L13:
            this.a.g.a(this.b, this.c);
            b r10 = this.a;
            h r11 = this.b;
            List r12 = (List) r10.f.getValue();
            if (r12 == null) goto L21;
            List r13 = r12;
            ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
            Iterator r15 = r13.iterator();
        L17:
            if (r15.hasNext() == false) goto L19;
            h r16 = (h) r15.next();
            r16.a = Intrinsics.areEqual(r16.d(), r11.d());
            r14.add(r16);
            goto L17
        L19:
            Object r17 = CollectionsKt.toMutableList(r14);
            if (r17 == null) goto L21;
        L22:
            r10.f.setValue(r17);
            return;
        L21:
            r17 = new ArrayList();
            goto L22
        L12:
            this.a.B(true);
            goto L13
        }

        public c(b r1, h r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ b a;

        public d(b r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.K(((Boolean) r2).booleanValue());
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ b a;

        public e(b r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            b r0 = this.a;
            boolean r3 = ((Boolean) r2).booleanValue();
            r0.b.b.setValue(Boolean.valueOf(r3));
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ b a;

        public f(b r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            b r0 = this.a;
            boolean r3 = ((Boolean) r2).booleanValue();
            r0.b.b.setValue(Boolean.valueOf(r3));
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ b a;

        public g(b r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L6;
            this.a.k0();
            ALogger.i("KSongTuningCore", "syncTuningEffects ;; observe currentUserIsSinger");
            return;
        }
    }

    static {
    }

    public final void b0() {
        if (h0(false) == true) goto L5;
        B(false);
        return;
    L5:
        i0((List) this.f.getValue());
    }

    public final void s() {
    }

    public final float A() {
        if (this.n <= N()) goto L7;
        return N();
    L7:
        return this.n;
    }

    public final void C() {
        if (Intrinsics.areEqual((Boolean) this.b.h.getValue(), Boolean.TRUE) == false) goto L6;
        m0(false);
        return;
    }

    public final void E() {
        int r0 = com.bytedance.android.livesdk.ktvimpl.base.c.a;
        if (vm2.h.r().a() == true) goto L5;
        return;
    L5:
        if (this.d == false) goto L13;
        ec0.a r1 = this.t;
        if (r1 == null) goto L22;
        MusicPanel r2 = r1.e();
        if (r2 == null) goto L23;
        KtvMusic r3 = r2.a;
        if (r3 == null) goto L24;
        r3.getMFullTrack();
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L13:
        ec0.a r4 = this.t;
        if (r4 == null) goto L26;
        MusicPanel r5 = r4.e();
        if (r5 == null) goto L27;
        KtvMusic r6 = r5.a;
        if (r6 == null) goto L28;
        r6.getMAccompanimentTrack();
        return;
    L28:
        return;
    L27:
        return;
    }

    public final MutableLiveData<Boolean> F() {
        return this.b.h;
    }

    public final Boolean I() {
        return (Boolean) this.b.a.getValue();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a
    public final Boolean J() {
        a r0 = this.b;
        Boolean r1 = r0.c;
        r0.c = null;
        return r1;
    }

    public final void L() {
        int r0 = com.bytedance.android.livesdk.ktvimpl.base.c.a;
        if (vm2.h.r().a() == false) goto L14;
        DataCenter r1 = (DataCenter) this.q.getValue();
        String r2 = null;
        if (r1 == null) goto L7;
        IRoom r3 = (IRoom) r1.get("data_room", null);
    L8:
        if (r3 == null) goto L10;
        r2 = r3.getOwnerUserIdString();
    L10:
        com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.c.n;
        Set r5 = (Set) r4.getValue();
        if (r5.contains(r2) == true) goto L15;
        f2.b(2131918195, 0);
        r5.add(r2);
        r4.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r4, r5);
        return;
    L15:
        return;
    L7:
        r3 = null;
        goto L8
    }

    public final void P() {
        ALogger.e("KSongTuningCore", "supportSoftWareEcho: setting=" + vm2.h.L() + " ;; enable_ktv_software_echo=false");
        vm2.h.L();
    }

    public final float V() {
        if (this.m <= D()) goto L7;
        return D();
    L7:
        return this.m;
    }

    public final boolean a() {
        this.b.getClass();
        return ((Boolean) com.bytedance.android.livesdk.sharedpref.c.j.getValue()).booleanValue();
    }

    public final void b() {
        ALogger.e("KSongTuningCore", "supportHardWareEcho: ktv_hardware_echo_ab=" + vm2.h.c() + " ;;audioFilterManager?.isSupportHardWareEarMonitor=false");
        vm2.h.c();
    }

    public final void c() {
        if (this.b.f.get() == true) goto L8;
        com.bytedance.android.live.pushstream.d r0 = this.s;
        if (r0 == null) goto L7;
        r0.I0((KSongTuningCore$liveStreamInfoListener$2.a) this.p.getValue());
    L7:
        this.b.getClass();
        b();
        return;
    L8:
        b();
        P();
        Boolean r1 = (Boolean) com.bytedance.android.livesdk.sharedpref.c.j.getValue();
        if (r1 == null) goto L11;
        r1.booleanValue();
    L11:
        this.b.f.get();
    }

    public final void clearData() {
        l0(100.0f);
        B(false);
        C();
        f0();
        o();
        ((CompositeDisposable) this.r.getValue()).clear();
        com.bytedance.android.live.pushstream.d r0 = this.s;
        if (r0 == null) goto L5;
        r0.h1((KSongTuningCore$liveStreamInfoListener$2.a) this.p.getValue());
    L5:
        ALogger.i("KSongTuningCore", "onDestroy ;; hashcode == " + hashCode());
    }

    public final float e() {
        if (this.l <= w()) goto L7;
        return w();
    L7:
        return this.l;
    }

    public final float f() {
        if (this.b.g <= U()) goto L7;
        return N();
    L7:
        return this.b.g;
    }

    public final void f0() {
        this.j = 0.0d;
        vm2.h.d();
    }

    public final void i() {
        if (this.b.f.get() == false) goto L6;
        b();
        P();
        return;
    }

    public final boolean isInRealTimeChorus() {
        RealTimeChorusBusinessContext.Companion.getClass();
        return RealTimeChorusBusinessContext.a.g();
    }

    public final void j0() {
        KtvContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.util.h r0 = (com.bytedance.android.livesdk.ktvimpl.base.util.h) KtvContext.a.g().getBigEventHelper().getValue();
        if (r0 == null) goto L7;
        NextLiveData r1 = r0.f;
        if (r1 == null) goto L7;
        r1.observeForever((Observer) this.i.getValue());
    L7:
        o r2 = m.i();
        if (r2 == null) goto L14;
        com.bytedance.live.datacontext.m r3 = r2.X1();
        if (r3 == null) goto L14;
        Boolean r4 = (Boolean) r3.getValue();
        if (r4 == null) goto L14;
        boolean r5 = r4.booleanValue();
    L15:
        K(r5);
        o r6 = m.i();
        if (r6 == null) goto L24;
        com.bytedance.live.datacontext.m r7 = r6.X1();
        if (r7 == null) goto L24;
        Observable r8 = r7.a();
        if (r8 == null) goto L24;
        Disposable r9 = r8.subscribe(new d(this));
        if (r9 == null) goto L24;
        RxUtilKt.c(r9, (CompositeDisposable) this.r.getValue());
    L24:
        o r10 = m.i();
        if (r10 == null) goto L33;
        com.bytedance.live.datacontext.m r11 = r10.n2();
        if (r11 == null) goto L33;
        Observable r12 = r11.a();
        if (r12 == null) goto L33;
        Disposable r13 = r12.subscribe(new e(this));
        if (r13 == null) goto L33;
        RxUtilKt.c(r13, (CompositeDisposable) this.r.getValue());
    L33:
        o r14 = m.i();
        if (r14 == null) goto L42;
        com.bytedance.live.datacontext.m r15 = r14.N2();
        if (r15 == null) goto L42;
        Observable r16 = r15.a();
        if (r16 == null) goto L42;
        Disposable r17 = r16.subscribe(new f(this));
        if (r17 == null) goto L42;
        RxUtilKt.c(r17, (CompositeDisposable) this.r.getValue());
    L42:
        ALogger.i("KSongTuningCore", "onCreate ;; hashcode == " + hashCode());
        return;
    L14:
        r5 = false;
        goto L15
    }

    public final void k0() {
        Collection r0 = (Collection) this.f.getValue();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
    L13:
        b0();
    L14:
        c();
        return;
    L11:
        if (KtvSettingHelper.g().c() == false) goto L13;
        this.g.g((cc0.b) this.h.getValue());
        this.g.k((cc0.b) this.h.getValue());
        goto L14
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void n0() {
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L12;
        k0();
        ec0.a r0 = KSongTuningPanelHelperKt.e();
        if (r0 == null) goto L11;
        i r2 = (i) KtvContext.a.g().getKtvCoreController().getValue();
        if (r2 == null) goto L9;
        MusicPanel r3 = r2.f;
    L10:
        r0.m(r3);
        goto L11
    L9:
        r3 = null;
    L11:
        q(KtvUtilsKt.b(false, 3), false);
        ALogger.i("KSongTuningCore", "syncTuningEffects ;; check currentUserIsSinger");
    L12:
        RealTimeChorusBusinessContext.a r1 = RealTimeChorusBusinessContext.Companion;
        r1.getClass();
        if (RealTimeChorusBusinessContext.a.g() == true) goto L15;
    L17:
        Disposable r4 = KtvContext.observerCurrentUserIsSinger$default(KtvContext.a.g(), null, false, new g(this), 3, null);
        if (r4 == null) goto L21;
        RxUtilKt.c(r4, (CompositeDisposable) this.r.getValue());
        return;
    L21:
        return;
    L15:
        if (r1.j() == false) goto L17;
        k0();
        ALogger.i("KSongTuningCore", "syncTuningEffectsForViceSinger");
        goto L17
    }

    public final void o() {
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.c r0 = this.g;
        ((CompositeDisposable) ((TuningEffectAbility) r0).d.getValue()).clear();
        DownloadTask r1 = ((TuningEffectAbility) r0).e;
        if (r1 == null) goto L5;
        r1.mainThreadListener(null);
    L5:
        KtvContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.util.h r2 = (com.bytedance.android.livesdk.ktvimpl.base.util.h) KtvContext.a.g().getBigEventHelper().getValue();
        if (r2 == null) goto L11;
        NextLiveData r3 = r2.f;
        if (r3 == null) goto L12;
        r3.removeObserver((Observer) this.i.getValue());
        return;
    L12:
        return;
    }

    public final void onPageCreate() {
        a r0 = this.b;
        r0.d = false;
        r0.e = Boolean.FALSE;
    }

    public final void onPageResume() {
        a r0 = this.b;
        r0.d = false;
        Boolean r1 = r0.e;
        if (r1 == null) goto L6;
        m0(r1.booleanValue());
        return;
    }

    public final void onPageStop() {
        a r0 = this.b;
        r0.e = (Boolean) r0.h.getValue();
        C();
        this.b.d = true;
    }

    public final boolean p() {
        return ((Boolean) com.bytedance.android.livesdk.sharedpref.c.N.getValue()).booleanValue();
    }

    public final boolean r() {
        if (RealTimeChorusBusinessContext.Companion.a() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final int u() {
        return (int) this.j;
    }

    public final boolean v() {
        if (((Boolean) vm2.h.M0.getValue(null, vm2.h.a[89])).booleanValue() == false) goto L7;
        KtvContext.Companion.getClass();
        if (((Boolean) KtvContext.a.g().getSoundCardSelectedStatus().getValue()).booleanValue() == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final void y() {
        com.bytedance.android.live.pushstream.d r0 = this.s;
        if (r0 == null) goto L8;
        d0 r1 = r0.getLiveCore();
        if (r1 == null) goto L9;
        r1.h();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a
    public final long z() {
        ec0.a r0 = this.t;
        if (r0 == null) goto L7;
        MusicPanel r1 = r0.e();
        if (r1 == null) goto L7;
        KtvMusic r2 = r1.a;
    L8:
        if (r2 != null) goto L11;
        return 0;
    L11:
        return this.e;
    L7:
        r2 = null;
        goto L8
    }

    public final int D() {
        return KtvSettingHelper.c().j();
    }

    public final int M() {
        if (isInRealTimeChorus() == false) goto L6;
        return KtvSettingHelper.c().b();
    L6:
        return vm2.h.M().f();
    }

    public final int N() {
        if (isInRealTimeChorus() == false) goto L6;
        return KtvSettingHelper.c().i();
    L6:
        return vm2.h.M().f();
    }

    public final boolean O() {
        if (jc0.a.a() == true) goto L5;
    L7:
        return false;
    L5:
        if (((lf1) KtvSettingHelper.F.getValue()).c() == false) goto L7;
        return true;
    }

    public final int U() {
        if (isInRealTimeChorus() == false) goto L6;
        return KtvSettingHelper.c().h();
    L6:
        if (Z() == false) goto L9;
        return KtvSettingHelper.d().d();
    L9:
        return vm2.h.M().e();
    }

    public final boolean Z() {
        o r0 = m.i();
        if (r0 == null) goto L15;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L15;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L15;
        z5 r3 = r2.getLinkerDetail();
        if (r3 == null) goto L15;
        List<Long> r4 = r3.getPlayModes();
        if (r4 == null) goto L15;
        if (r4.contains(Long.valueOf(39)) != true) goto L15;
        return true;
    L15:
        return false;
    }

    public final boolean h() {
        if (m1.b() == false) goto L5;
    L10:
        boolean r0 = true;
    L11:
        boolean r3 = new PolarisFileWrapper("/my_product/etc/permissions/oplus.product.feature_ktv.xml").exists();
        Context r4 = this.u.get();
        String r5 = null;
        if (r4 == null) goto L14;
        Object r6 = r4.getSystemService("audio");
    L16:
        if ((r6 instanceof AudioManager) == true) goto L18;
        r6 = null;
    L18:
        AudioManager r7 = (AudioManager) r6;
        if (r7 == null) goto L21;
        r5 = r7.getParameters("OPLUS_AUDIO_GET_KARAOKE_V2_SUPPORT");
    L21:
        boolean r8 = Intrinsics.areEqual(r5, "true");
        Context r9 = this.u.get();
        if (r9 == null) goto L28;
        PackageManager r10 = r9.getPackageManager();
        if (r10 == null) goto L28;
        if (r10.hasSystemFeature("oplus.software.audio.karaoke_v2.support") != true) goto L28;
        boolean r11 = true;
    L29:
        if (r11 == true) goto L34;
        if (r8 == true) goto L34;
        if (r3 == true) goto L34;
        boolean r12 = false;
    L35:
        ALogger.i("KSongTuningCore", "isOppoDevice == " + r0 + "  ;; isSupportOppoEcho = " + r12 + " ;; hasEchoModeFeature == " + r11 + " ;; hasOppoKaraokeV2Support == " + r8 + " ;; isOppoEchoFileExists == " + r3);
        if (r0 == false) goto L42;
        if (r12 == true) goto L39;
        return false;
    L39:
        if (this.a == false) goto L44;
        return true;
    L44:
        return false;
    L42:
        return false;
    L34:
        r12 = true;
    L28:
        r11 = false;
        goto L29
    L14:
        r6 = null;
        goto L16
    L5:
        if (m1.a() == true) goto L10;
        if (m1.c() == true) goto L10;
        r0 = false;
        goto L11
    }

    public final boolean n() {
        return isInRealTimeChorus();
    }

    public final int w() {
        if (isInRealTimeChorus() == false) goto L6;
        return KtvSettingHelper.c().k();
    L6:
        return vm2.h.M().g();
    }

    public final boolean R() {
        return this.d;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a
    public final String T() {
        return this.k;
    }

    public final float X() {
        return this.o;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a
    public final boolean d0() {
        return this.c;
    }

    public final void B(boolean r4) {
        ALogger.i("KSongTuningCore", "closeTuningEffect");
        if (((Boolean) KtvSettingHelper.v0.getValue()).booleanValue() == false) goto L15;
        if (r4 == true) goto L15;
        List r5 = (List) this.f.getValue();
        if (r5 == null) goto L13;
        List r6 = r5;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L11;
        h r1 = (h) r7.next();
        r1.a = false;
        r0.add(r1);
        goto L9
    L11:
        Object r8 = CollectionsKt.toMutableList(r0);
        if (r8 == null) goto L13;
    L14:
        this.f.setValue(r8);
    L13:
        r8 = new ArrayList();
    L15:
        this.k = "none";
    }

    public final void G(float r3) {
        float r0 = N();
        if (r3 >= 0.0f) goto L5;
        return;
    L5:
        if (r3 <= r0) goto L7;
        return;
    L7:
        if (isInRealTimeChorus() == false) goto L9;
        com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.c.k0;
        Float r2 = Float.valueOf(r3 / N());
        r1.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r1, r2);
    L10:
        Lazy r4 = KtvSettingHelper.a;
        if (((Boolean) KtvSettingHelper.Y.getValue()).booleanValue() == false) goto L13;
        isInRealTimeChorus();
    L13:
        this.n = r3;
        return;
    L9:
        com.bytedance.android.livesdk.sharedpref.e r5 = com.bytedance.android.livesdk.sharedpref.c.i0;
        Float r6 = Float.valueOf(r3 / N());
        r5.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r5, r6);
        goto L10
    }

    public final void K(boolean r2) {
        this.b.a.setValue(Boolean.valueOf(r2));
    }

    public final void S(boolean r4) {
        if (this.d == r4) goto L26;
        ec0.a r0 = this.t;
        if (r0 != null) goto L7;
    L11:
        ec0.a r5 = this.t;
        if (r5 == null) goto L18;
        MusicPanel r6 = r5.e();
        if (r6 == null) goto L18;
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.p(r6) != true) goto L18;
        f2.b(2131918458, 0);
        return;
    L18:
        ec0.a r7 = this.t;
        if (r7 == null) goto L30;
        MusicPanel r8 = r7.e();
        if (r8 != null) goto L23;
        return;
    L23:
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.o(r8) != true) goto L32;
        f2.b(2131918460, 0);
        return;
    L32:
        return;
    L30:
        return;
    L7:
        if (r0.g() != true) goto L11;
        q(r4, false);
        KtvContext.Companion.getClass();
        oe2.b r1 = (oe2.b) KtvContext.a.g().getKtvRoomProvider().getValue();
        if (r1 == null) goto L27;
        r1.f(r4);
        return;
    L27:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a
    public final void W(boolean r1) {
        if (r1 == true) goto L4;
    L6:
        boolean r2 = false;
    L7:
        this.c = r2;
        return;
    L4:
        if (this.d == false) goto L6;
        r2 = true;
        goto L7
    }

    public final void Y(boolean r3) {
        a r0 = this.b;
        if (r0.d == false) goto L5;
        r0.e = Boolean.valueOf(r3);
        return;
    L5:
        m0(r3);
    }

    public final void c0(double r3) {
        double r0 = this.j + r3;
        this.j = r0;
        this.j = RangesKt.coerceAtMost(r0, 4.0d);
        vm2.h.d();
    }

    public final boolean d(TuningVolumeType r5) {
        Intrinsics.checkNotNullParameter(r5, "volumeType");
        if (r5 != TuningVolumeType.ACCOMPANIMENT_VOLUME) goto L12;
        ChorusContext.a r6 = ChorusContext.Companion;
        if (r6.c() == true) goto L7;
    L10:
        return true;
    L7:
        if (r6.a() != 2) goto L10;
        f2.b(2131918311, 0);
        return false;
    L12:
        if (r5 != TuningVolumeType.TONE_VOLUME) goto L19;
        ChorusContext.a r7 = ChorusContext.Companion;
        if (r7.c() == false) goto L19;
        if (r7.a() != 2) goto L19;
        f2.b(2131918308, 0);
        return false;
    L19:
        return true;
    }

    public final void e0(float r3) {
        float r0 = M();
        if (r3 >= 0.0f) goto L5;
        return;
    L5:
        if (r3 <= r0) goto L7;
        return;
    L7:
        if (isInRealTimeChorus() == false) goto L9;
        com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.c.j0;
        Float r2 = Float.valueOf(r3);
        r1.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r1, r2);
    L9:
        this.o = r3;
    }

    public final void g(float r3) {
        float r0 = U();
        if (r3 >= 0.0f) goto L5;
        return;
    L5:
        if (r3 <= r0) goto L7;
        return;
    L7:
        if (isInRealTimeChorus() == false) goto L9;
        com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.c.a0;
        Float r2 = Float.valueOf(r3 / U());
        r1.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r1, r2);
    L10:
        b();
        P();
        this.b.g = r3;
        return;
    L9:
        com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.c.Z;
        Float r5 = Float.valueOf(r3 / U());
        r4.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r4, r5);
        goto L10
    }

    public final void g0(double r3) {
        double r0 = this.j - r3;
        this.j = r0;
        this.j = RangesKt.coerceAtLeast(r0, -4.0d);
        vm2.h.d();
    }

    public final boolean h0(boolean r6) {
        StringBuilder r0 = new StringBuilder("isTuningEffectAvailable ;; isSinger == ");
        KtvContext.Companion.getClass();
        r0.append(KtvContext.a.g().isCurrentUserIsSinger());
        r0.append("  ;; isViceSinger == ");
        RealTimeChorusBusinessContext.a r1 = RealTimeChorusBusinessContext.Companion;
        r0.append(r1.j());
        r0.append(" ;; wiredState == ");
        r0.append((Boolean) this.b.a.getValue());
        ALogger.i("KSongTuningCore", r0.toString());
        if (KtvSettingHelper.g().c() == true) goto L5;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == true) goto L16;
        if (r6 == false) goto L15;
        f2.b(2131918632, 0);
    L15:
        return false;
    L16:
        return true;
    L5:
        if (Intrinsics.areEqual((Boolean) this.b.a.getValue(), Boolean.TRUE) == false) goto L11;
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L9;
    L10:
        r2 = true;
        goto L12
    L9:
        if (r1.j() == false) goto L11;
        goto L10
    }

    public final void i0(List<h> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if ((!r2.isEmpty()) != true) goto L10;
        h r3 = this.g.c();
        if (r3 == null) goto L11;
        Q(r3, false);
        return;
    L11:
        return;
    }

    public final void j(float r3) {
        float r0 = D();
        if (r3 >= 0.0f) goto L5;
        return;
    L5:
        if (r3 > r0) goto L9;
        com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.c.g0;
        Float r2 = Float.valueOf(r3 / D());
        r1.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r1, r2);
        l0(r3);
        this.m = r3;
        return;
    }

    public final void k(boolean r3) {
        if ((!Intrinsics.areEqual((Boolean) this.b.a.getValue(), Boolean.TRUE)) == false) goto L7;
        if (r3 == false) goto L11;
        f2.b(2131918632, 0);
        return;
    L11:
        return;
    L7:
        i();
        if (r3 == false) goto L12;
        f2.b(2131918381, 0);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a
    public final void l(long r1) {
        this.e = r1;
    }

    public final void l0(float r5) {
        if (RealTimeChorusBusinessContext.Companion.f() == false) goto L7;
        w.a("KSongTuningCore", "setPlayerVolume " + (r5 / D()));
        ILivePlayerClient r0 = hs0.a.b.getCurrentClient();
        if (r0 == null) goto L20;
        r0.setPlayerVolume(r5 / D());
        return;
    L20:
        return;
    L7:
        IMultiLinkInternalService r1 = k.f(IMultiLinkInternalService.class);
        ei6.a r2 = null;
        if (r1 == null) goto L14;
        cg6.a r3 = r1.getMultiLinkComponentService(null, m.i());
        if (r3 == null) goto L14;
        hg6.g r4 = r3.getRtcManager();
        if (r4 == null) goto L14;
        r2 = r4.V0();
    L14:
        w.a("KSongTuningCore", "setPlayerVolume  normal " + r5 + ' ' + r2);
        if (r2 == null) goto L22;
        ri6.b r6 = r2.r();
        if (r6 == null) goto L23;
        r6.d((int) r5);
        return;
    L23:
        return;
    }

    public final void m0(boolean r3) {
        if (r3 == false) goto L4;
        b();
    L4:
        ALogger.i("KSongTuningCore", "setEchoModeInner ;; open == " + r3);
        b();
        P();
        this.b.h.setValue(Boolean.valueOf(r3));
        if (r3 == true) goto L7;
        return;
    L7:
        if ((!Intrinsics.areEqual(Boolean.valueOf(r3), this.b.c)) == false) goto L19;
        o r4 = m.i();
        if (r4 == null) goto L20;
        com.bytedance.live.datacontext.m r5 = r4.X1();
        if (r5 != null) goto L13;
        return;
    L13:
        if (((Boolean) r5.getValue()).booleanValue() == true) goto L15;
        return;
    L15:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.j.getValue()).booleanValue() == false) goto L23;
        this.b.c = Boolean.TRUE;
        return;
    L23:
        return;
    L20:
        return;
    }

    public final void setTuningEffect(String r6) {
        Intrinsics.checkNotNullParameter(r6, "effectName");
        List r0 = (List) this.f.getValue();
        if (r0 == null) goto L25;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L15;
        Object r2 = r1.next();
        h r3 = (h) r2;
        if (Intrinsics.areEqual(r6, r3.d()) == true) goto L10;
    L12:
        boolean r4 = false;
    L13:
        if (r4 == false) goto L6;
    L16:
        h r5 = (h) r2;
        if (r5 == null) goto L26;
        Q(r5, true);
        return;
    L26:
        return;
    L10:
        if (r3.a == true) goto L12;
        r4 = true;
        goto L13
    L15:
        r2 = null;
        goto L16
    }

    public final void Q(h r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "targetEffect");
        if (h0(r10) == true) goto L5;
        return;
    L5:
        if (r10 == false) goto L24;
        KtvContext.Companion.getClass();
        oe2.b r0 = (oe2.b) KtvContext.a.g().getKtvRoomProvider().getValue();
        if (r0 == null) goto L10;
        String r2 = r0.getEnterFrom();
        if (r2 == null) goto L10;
    L11:
        if (r0 == null) goto L14;
        String r3 = r0.c();
        if (r3 == null) goto L14;
    L15:
        if (r0 == null) goto L18;
        String r1 = r0.a();
        if (r1 == null) goto L18;
    L19:
        Long r4 = KtvLoggerHelper.a;
        String r5 = j.d();
        String r6 = j.d();
        String r7 = r9.d();
        Intrinsics.checkNotNullParameter(r5, "liveType");
        Intrinsics.checkNotNullParameter(r6, "roomType");
        Intrinsics.checkNotNullParameter(r7, "effectName");
        Intrinsics.checkNotNullParameter("", "functionType");
        HashMap r8 = new HashMap();
        r8.put("room_type", r6);
        r8.put("effect_type", r7);
        r8.put("function_type", KtvLoggerHelper.H(""));
        r8.put("user_type", KtvLoggerHelper.I());
        if (Intrinsics.areEqual(r7, (String) com.bytedance.android.livesdk.sharedpref.c.e.getValue()) == false) goto L22;
        r8.put("if_default", BDLocationException.ERROR_TIMEOUT);
    L23:
        r8.put("live_type", KtvLoggerHelper.F());
        KtvLoggerHelper.o0(r8);
        r8.put("enter_from", r2);
        r8.put("ksong_element_source", r3);
        r8.put("element_open_method", r1);
        r8.put("function_type2", k.n(IInteractService.class).getFunctionType2());
        xe2.h.b(r8);
        j0.l().sendLog("anchor_ksong_audio_effect_click", r8, new Object[]{IRoom.class, new x()});
        goto L24
    L22:
        r8.put("if_default", "1");
    L18:
        r1 = "";
    L14:
        r3 = "";
    L10:
        r2 = "";
    L24:
        this.g.b(r9, new c(this, r9, r10));
    }

    public final void a0(LifecycleOwner r2, Observer<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.b.b.observe(r2, r3);
    }

    public final void q(boolean r2, boolean r3) {
        if (r3 == false) goto L4;
    L6:
        boolean r4 = false;
    L7:
        if (r4 == false) goto L9;
        return;
    L9:
        this.d = r2;
        pd2.d.n.getClass();
        JSONObject r5 = new JSONObject().put("isOrigin", r2 ? 1 : 0);
        pd2.d.w(LinkMonitorData.BusinessChangeOrigin, r5);
        E();
        KtvContext.Companion.getClass();
        if (KtvContext.a.k() == false) goto L12;
    L23:
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r6 = KtvRoomContext.a.a();
        if (r6 == null) goto L34;
        com.bytedance.live.datacontext.k<Boolean> r7 = r6.getOriginSwitch();
        if (r7 == null) goto L35;
        r7.post(Boolean.valueOf(r2));
        return;
    L35:
        return;
    L34:
        return;
    L12:
        if (KtvContext.a.j() == true) goto L23;
        KtvComponentContext r8 = KtvComponentContext.Companion.getContext();
        if (r8 == null) goto L29;
        n<KtvComponentUIContext> r9 = r8.getKtvComponentUIContext();
        if (r9 == null) goto L30;
        KtvComponentUIContext r10 = (KtvComponentUIContext) r9.getValue();
        if (r10 == null) goto L31;
        MutableLiveData<Boolean> r11 = r10.getOriginOpen();
        if (r11 == null) goto L32;
        r11.setValue(Boolean.valueOf(r2));
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L4:
        if (this.d != r2) goto L6;
        r4 = true;
        goto L7
    }

    public final void t(LifecycleOwner r2, Observer<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.b.a.observe(r2, r3);
    }

    public final void x(LifecycleOwner r2, com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.view.e r3) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.f.observe(r2, r3);
    }

    public b(com.bytedance.android.live.pushstream.d r4, KSongTuningMusicControl r5, WeakReference r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        this.s = r4;
        this.t = r5;
        this.u = r6;
        this.a = ((Boolean) vm2.h.L0.getValue(null, vm2.h.a[88])).booleanValue();
        this.b = new a(this);
        this.d = KtvUtilsKt.b(true, 1);
        this.f = new MutableLiveData();
        this.g = new com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.c();
        this.h = LazyKt.lazy(new KSongTuningCore$loadTuningEffectCallback$2(this));
        if (r4 == null) goto L7;
        d0 r7 = r4.A();
        if (r7 == null) goto L7;
        r7.u();
    L7:
        this.i = LazyKt.lazy(new KSongTuningCore$effectContentObserver$2(this));
        vm2.h.d();
        this.j = 0.0d;
        this.k = "none";
        if (isInRealTimeChorus() == true) goto L10;
        com.bytedance.android.livesdk.sharedpref.e r8 = com.bytedance.android.livesdk.sharedpref.c.d0;
        if ((!Intrinsics.areEqual((Float) r8.getValue(), -1.0f)) == false) goto L26;
        float r9 = ((Number) r8.getValue()).floatValue();
        int r0 = vm2.h.M().g();
    L27:
        float r1 = r0;
        float r2 = r9;
        float r10 = r1;
    L28:
        float r11 = r10 * r2;
    L29:
        this.l = r11;
        com.bytedance.android.livesdk.sharedpref.e r12 = com.bytedance.android.livesdk.sharedpref.c.g0;
        Float r3 = (Float) r12.getValue();
        if (r3 != null) goto L32;
    L35:
        float r13 = ((Number) r12.getValue()).floatValue() * KtvSettingHelper.c().j();
    L36:
        this.m = r13;
        if (isInRealTimeChorus() == false) goto L45;
        com.bytedance.android.livesdk.sharedpref.e r14 = com.bytedance.android.livesdk.sharedpref.c.k0;
        Float r15 = (Float) r14.getValue();
        if (r15 != null) goto L41;
    L44:
        float r16 = ((Number) r14.getValue()).floatValue();
        int r17 = KtvSettingHelper.c().i();
    L49:
        float r18 = r16 * r17;
    L50:
        this.n = r18;
        if (isInRealTimeChorus() == false) goto L57;
        com.bytedance.android.livesdk.sharedpref.e r19 = com.bytedance.android.livesdk.sharedpref.c.j0;
        if ((true ^ Intrinsics.areEqual((Float) r19.getValue(), -1.0f)) == false) goto L55;
        Float r20 = (Float) r19.getValue();
    L56:
        float r21 = r20.floatValue();
    L58:
        this.o = r21;
        this.p = LazyKt.lazy(new KSongTuningCore$liveStreamInfoListener$2(this));
        this.q = LazyKt.lazy(KSongTuningCore$dataCenter$2.INSTANCE);
        this.r = LazyKt.lazy(KSongTuningCore$compositeDisposable$2.INSTANCE);
        return;
    L55:
        r20 = Float.valueOf(KtvSettingHelper.c().c());
        goto L56
    L57:
        r21 = this.n;
        goto L58
    L41:
        if (r15.floatValue() != (-1.0f)) goto L44;
        r18 = KtvSettingHelper.c().e() * KtvSettingHelper.c().i();
        goto L50
    L45:
        com.bytedance.android.livesdk.sharedpref.e r22 = com.bytedance.android.livesdk.sharedpref.c.i0;
        if ((!Intrinsics.areEqual((Float) r22.getValue(), -1.0f)) == false) goto L48;
        r16 = ((Number) r22.getValue()).floatValue();
        r17 = vm2.h.M().f();
        goto L49
    L48:
        r16 = vm2.h.M().b();
        r17 = vm2.h.M().f();
        goto L49
    L32:
        if (r3.floatValue() != (-1.0f)) goto L35;
        r13 = KtvSettingHelper.c().f() * KtvSettingHelper.c().j();
        goto L36
    L26:
        r9 = vm2.h.M().c();
        r0 = vm2.h.M().g();
        goto L27
    L10:
        if (r() == true) goto L12;
        com.bytedance.android.livesdk.sharedpref.e r23 = com.bytedance.android.livesdk.sharedpref.c.e0;
        Float r24 = (Float) r23.getValue();
        if (r24 != null) goto L19;
    L22:
        r9 = ((Number) r23.getValue()).floatValue();
        r0 = KtvSettingHelper.c().k();
        goto L27
    L19:
        if (r24.floatValue() != (-1.0f)) goto L22;
        r10 = KtvSettingHelper.c().g();
        r2 = KtvSettingHelper.c().k();
        goto L28
    L12:
        if (RealTimeChorusBusinessContext.Companion.e() == false) goto L14;
        int r25 = KtvSettingHelper.c().a();
    L15:
        r11 = r25;
        goto L29
    L14:
        r25 = KtvSettingHelper.c().l();
        goto L15
    }

    public final void H(boolean r3, String r4, Function1<? super Boolean, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        Intrinsics.checkNotNullParameter(r5, "callback");
        ALogger.i("KSongTuningCore", "updateCellularConfig : " + r3 + ", reason : " + r4);
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r6 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r6 == null) goto L11;
        hg6.g r7 = r6.rtcManger();
        if (r7 == null) goto L11;
        ei6.a r8 = r7.V0();
        if (r8 == null) goto L11;
        si6.b r9 = r8.b();
        if (r9 == null) goto L11;
        r9.l(new dg2.d(0));
    L11:
        r5.invoke(Boolean.TRUE);
    }

    public final void m(float r3, boolean r4, boolean r5) {
        float r0 = w();
        if (r3 >= 0.0f) goto L5;
        return;
    L5:
        if (r3 > r0) goto L17;
        float r1 = r3 / 100.0f;
        if (r4 == true) goto L9;
    L12:
        if (r5 == false) goto L14;
        this.l = r3;
    L14:
        w.a("KSongTuningCore", "updateVoiceVolume " + r1);
        com.bytedance.android.livesdk.ktvimpl.base.m.a(r1, "KSongTuningCore#updateVoiceVolume");
        return;
    L9:
        if (isInRealTimeChorus() == false) goto L11;
        com.bytedance.android.livesdk.sharedpref.e r6 = com.bytedance.android.livesdk.sharedpref.c.e0;
        Float r2 = Float.valueOf(r3 / w());
        r6.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r6, r2);
        goto L12
    L11:
        com.bytedance.android.livesdk.sharedpref.e r7 = com.bytedance.android.livesdk.sharedpref.c.d0;
        Float r8 = Float.valueOf(r3 / w());
        r7.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r7, r8);
        goto L12
    }
}
