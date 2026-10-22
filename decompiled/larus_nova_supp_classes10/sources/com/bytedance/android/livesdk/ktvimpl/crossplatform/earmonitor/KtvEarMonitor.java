package com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.m1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.config.f50;
import com.bytedance.android.livesdk.config.lf1;
import com.bytedance.android.livesdk.config.v40;
import com.bytedance.android.livesdk.config.x8;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import hg6.g;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;
import uf2.h0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvEarMonitor implements com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.a {
    public final CompositeDisposable a;
    public final Boolean b;
    public final MutableLiveData<Boolean> c;
    public final AtomicBoolean d;
    public final e e;
    public final f f;
    public final j1 g;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ KtvEarMonitor a;

        public b(KtvEarMonitor r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.n(((Boolean) r2).booleanValue());
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ KtvEarMonitor a;

        public c(KtvEarMonitor r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            KtvEarMonitor r4 = this.a;
            o r0 = m.i();
            if (r0 == null) goto L9;
            com.bytedance.live.datacontext.m r1 = r0.X1();
            if (r1 == null) goto L9;
            Boolean r5 = (Boolean) r1.getValue();
            if (r5 == null) goto L9;
            boolean r6 = r5.booleanValue();
        L10:
            r4.n(r6);
            return;
        L9:
            r6 = false;
            goto L10
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ KtvEarMonitor a;

        public d(KtvEarMonitor r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            KtvEarMonitor r4 = this.a;
            o r0 = m.i();
            if (r0 == null) goto L9;
            com.bytedance.live.datacontext.m r1 = r0.X1();
            if (r1 == null) goto L9;
            Boolean r5 = (Boolean) r1.getValue();
            if (r5 == null) goto L9;
            boolean r6 = r5.booleanValue();
        L10:
            r4.n(r6);
            return;
        L9:
            r6 = false;
            goto L10
        }
    }

    public static final class e extends vb6.a {
        public final /* synthetic */ KtvEarMonitor a;

        public final void s1() {
            com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvEarMonitor", "onPreReleaseLiveClient");
            this.a.e();
            com.bytedance.android.live.pushstream.d r0 = this.a.i();
            if (r0 == null) goto L6;
            r0.h1(this.a.f);
            return;
        }

        public final void t1() {
            com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvEarMonitor", "onReleaseLiveClient");
            this.a.d.set(false);
        }

        public e(KtvEarMonitor r1) {
            this.a = r1;
        }
    }

    public static final class f implements h0.c {
        public final /* synthetic */ KtvEarMonitor a;

        public f(KtvEarMonitor r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.a
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.a
    public final void e() {
        p(false, false);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.a
    public final boolean a() {
        return ((Boolean) com.bytedance.android.livesdk.sharedpref.c.j.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.a
    public final void b() {
        StringBuilder r0 = new StringBuilder("supportHardWareEcho: ktv_hardware_echo_ab=");
        x8 r1 = x8.a;
        r0.append((Boolean) r1.getValue());
        r0.append(" ;;audioFilterManager?.isSupportHardWareEarMonitor=false");
        g();
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvEarMonitor", r0.toString());
        if (((Boolean) r1.getValue()).booleanValue() == false) goto L6;
        g();
        return;
    }

    public final void g() {
        j1 r0 = this.g;
        if (r0 == null) goto L14;
        cg6.a r1 = r0.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r1 == null) goto L15;
        g r2 = r1.getRtcManager();
        if (r2 == null) goto L16;
        ec6.b r3 = r2.R();
        if (r3 == null) goto L17;
        com.bytedance.android.live.pushstream.d r4 = gc6.b.a(r3);
        if (r4 == null) goto L18;
        r4.u();
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    public final boolean h() {
        Boolean r0 = (Boolean) this.c.getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    public final com.bytedance.android.live.pushstream.d i() {
        j1 r0 = this.g;
        if (r0 == null) goto L11;
        cg6.a r1 = r0.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r1 == null) goto L11;
        g r2 = r1.getRtcManager();
        if (r2 == null) goto L11;
        ec6.b r3 = r2.R();
        if (r3 == null) goto L11;
        return gc6.b.a(r3);
    L11:
        return null;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.a
    public final void init() {
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvEarMonitor", "init");
        o r0 = m.i();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m r1 = r0.X1();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L9;
        boolean r3 = r2.booleanValue();
    L10:
        n(r3);
        o r4 = m.i();
        if (r4 == null) goto L19;
        com.bytedance.live.datacontext.m r5 = r4.X1();
        if (r5 == null) goto L19;
        Observable r6 = r5.a();
        if (r6 == null) goto L19;
        Disposable r7 = r6.subscribe(new b(this));
        if (r7 == null) goto L19;
        RxUtilKt.c(r7, this.a);
    L19:
        o r8 = m.i();
        if (r8 == null) goto L28;
        com.bytedance.live.datacontext.m r9 = r8.n2();
        if (r9 == null) goto L28;
        Observable r10 = r9.a();
        if (r10 == null) goto L28;
        Disposable r11 = r10.subscribe(new c(this));
        if (r11 == null) goto L28;
        RxUtilKt.c(r11, this.a);
    L28:
        o r12 = m.i();
        if (r12 == null) goto L37;
        com.bytedance.live.datacontext.m r13 = r12.N2();
        if (r13 == null) goto L37;
        Observable r14 = r13.a();
        if (r14 == null) goto L37;
        Disposable r15 = r14.subscribe(new d(this));
        if (r15 == null) goto L37;
        RxUtilKt.c(r15, this.a);
    L37:
        j1 r16 = this.g;
        if (r16 == null) goto L45;
        cg6.a r17 = r16.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r17 == null) goto L46;
        vb6.g r18 = r17.O5();
        if (r18 == null) goto L47;
        r18.X0(this.e, true);
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L9:
        r3 = false;
        goto L10
    }

    public final boolean j() {
        return ((Boolean) com.bytedance.android.livesdk.sharedpref.c.N.getValue()).booleanValue();
    }

    public final boolean l() {
        return ((lf1) KtvSettingHelper.F.getValue()).c();
    }

    public final void q() {
        StringBuilder r0 = new StringBuilder("supportSoftWareEcho: setting=");
        f50 r1 = f50.a;
        r0.append(((Boolean) r1.getValue()).booleanValue());
        r0.append(" ;; enable_ktv_software_echo=false");
        g();
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvEarMonitor", r0.toString());
        if (((Boolean) r1.getValue()).booleanValue() == false) goto L6;
        g();
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.a
    public final void release() {
        j1 r0 = this.g;
        if (r0 == null) goto L9;
        cg6.a r1 = r0.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r1 == null) goto L9;
        vb6.g r2 = r1.O5();
        if (r2 == null) goto L9;
        r2.a1(this.e);
    L9:
        com.bytedance.android.live.pushstream.d r3 = i();
        if (r3 == null) goto L12;
        r3.h1(this.f);
    L12:
        this.a.clear();
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvEarMonitor", "release");
    }

    public final boolean k() {
        if (m1.b() == false) goto L5;
    L10:
        boolean r0 = true;
    L11:
        boolean r3 = new PolarisFileWrapper("/my_product/etc/permissions/oplus.product.feature_ktv.xml").exists();
        Context r4 = s1.getContext();
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
        Context r9 = s1.getContext();
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
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvEarMonitor", "isOppoDevice == " + r0 + "  ;; isSupportOppoEcho = " + r12 + " ;; hasEchoModeFeature == " + r11 + " ;; hasOppoKaraokeV2Support == " + r8 + " ;; isOppoEchoFileExists == " + r3);
        if (r0 == false) goto L42;
        if (r12 == true) goto L39;
        return false;
    L39:
        if (this.b.booleanValue() == false) goto L44;
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

    public final void m() {
        b();
        q();
    }

    public final void o() {
        b();
        q();
    }

    public KtvEarMonitor(j1 r2) {
        this.g = r2;
        this.a = new CompositeDisposable();
        this.b = (Boolean) v40.a.getValue();
        ((Boolean) com.bytedance.android.livesdk.sharedpref.c.j.getValue()).booleanValue();
        this.c = new MutableLiveData();
        this.d = new AtomicBoolean(false);
        this.e = new e(this);
        this.f = new f(this);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.a
    public final void c(final boolean r3) {
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvEarMonitor", "setSoundCardMode: enable=" + r3);
        UtilityKotlinExtentionsKt.b(this, new KtvEarMonitor$setSoundCardMode$1(r3));
        com.bytedance.android.live.pushstream.d r4 = i();
        if (r4 == null) goto L8;
        d0 r5 = r4.getLiveCore();
        if (r5 == null) goto L9;
        r5.h();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.a
    public final void f(boolean r2) {
        if (this.d.get() == true) goto L8;
        g();
        com.bytedance.android.live.pushstream.d r3 = i();
        if (r3 == null) goto L7;
        r3.I0(this.f);
    L7:
        g();
        b();
        return;
    L8:
        b();
        q();
        Boolean r4 = (Boolean) com.bytedance.android.livesdk.sharedpref.c.j.getValue();
        if (r4 == null) goto L12;
        r4.booleanValue();
    L12:
        if (this.d.get() == true) goto L16;
        g();
        return;
    }

    public final void n(final boolean r3) {
        this.c.setValue(Boolean.valueOf(r3));
        UtilityKotlinExtentionsKt.b(this, new KtvEarMonitor$onWiredStateChange$1(r3));
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvEarMonitor", "onWiredStateChange: " + r3);
    }

    public final void p(boolean r1, boolean r2) {
        b();
        q();
        if (r2 == false) goto L6;
        com.bytedance.android.livesdk.sharedpref.e r3 = com.bytedance.android.livesdk.sharedpref.c.j;
        Boolean r4 = Boolean.valueOf(r1);
        r3.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r3, r4);
        return;
    }
}
