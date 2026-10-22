package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.m1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.f50;
import com.bytedance.android.livesdk.config.v40;
import com.bytedance.android.livesdk.config.x8;
import com.bytedance.android.livesdk.ktvapi.concert_stage.models.DynamicConcertStatusChangeEventType;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.JsonObject;
import io.reactivex.disposables.CompositeDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;
import uf2.h0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements gd2.d {
    public final CompositeDisposable a;
    public final Boolean b;
    public final MutableLiveData<Boolean> c;
    public final AtomicBoolean d;
    public final b e;
    public final C0015c f;

    public static final class a {
    }

    public static final class b extends vb6.a {
        public final /* synthetic */ c a;

        public final void s1() {
            w.b("ConcertEarMonitor", "onPreReleaseLiveClient");
            this.a.g(false, false);
            this.a.getClass();
            com.bytedance.android.live.pushstream.d r0 = c.k();
            if (r0 == null) goto L6;
            r0.h1(this.a.f);
            return;
        }

        public final void t1() {
            w.b("ConcertEarMonitor", "onReleaseLiveClient");
            this.a.d.set(false);
        }

        public b(c r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.concert_stage.biz.c$c, reason: collision with other inner class name */
    public static final class C0015c implements h0.c {
        public final /* synthetic */ c a;

        public C0015c(c r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final void d() {
    }

    public static com.bytedance.android.live.pushstream.d k() {
        ConcertStageDataContext r0 = ConcertStageDataContext.Companion.getContext();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.j<js1.a> r1 = r0.getLinkComponent();
        if (r1 == null) goto L9;
        js1.a r2 = (js1.a) r1.getValue();
        if (r2 == null) goto L9;
        return r2.b();
    L9:
        return null;
    }

    public static void m() {
        StringBuilder r0 = new StringBuilder("supportSoftWareEcho: setting=");
        f50 r1 = f50.a;
        r0.append(((Boolean) r1.getValue()).booleanValue());
        r0.append(" ;; enable_ktv_software_echo=false");
        j();
        w.b("ConcertEarMonitor", r0.toString());
        if (((Boolean) r1.getValue()).booleanValue() == false) goto L6;
        j();
        return;
    }

    public final boolean a() {
        return ((Boolean) com.bytedance.android.livesdk.sharedpref.c.j.getValue()).booleanValue();
    }

    public final void b() {
        StringBuilder r0 = new StringBuilder("supportHardWareEcho: ktv_hardware_echo_ab=");
        x8 r1 = x8.a;
        r0.append((Boolean) r1.getValue());
        r0.append(" ;;audioFilterManager?.isSupportHardWareEarMonitor=false");
        j();
        w.b("ConcertEarMonitor", r0.toString());
        if (((Boolean) r1.getValue()).booleanValue() == false) goto L6;
        j();
        return;
    }

    public final boolean f() {
        Boolean r0 = (Boolean) this.c.getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    public c() {
        this.a = new CompositeDisposable();
        this.b = (Boolean) v40.a.getValue();
        ((Boolean) com.bytedance.android.livesdk.sharedpref.c.j.getValue()).booleanValue();
        this.c = new MutableLiveData();
        this.d = new AtomicBoolean(false);
        this.e = new b(this);
        this.f = new C0015c(this);
    }

    public static void j() {
        com.bytedance.android.live.pushstream.d r0 = k();
        if (r0 == null) goto L6;
        r0.u();
        return;
    }

    public final void e() {
        b();
        m();
    }

    public final boolean h() {
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
        w.b("ConcertEarMonitor", "isOppoDevice == " + r0 + "  ;; isSupportOppoEcho = " + r12 + " ;; hasEchoModeFeature == " + r11 + " ;; hasOppoKaraokeV2Support == " + r8 + " ;; isOppoEchoFileExists == " + r3);
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

    public final void i() {
        b();
        m();
    }

    public final void c(boolean r5) {
        w.b("ConcertEarMonitor", "setSoundCardMode: enable=" + r5);
        gd2.f r0 = ConcertStageDataContext.Companion.a();
        if (r0 == null) goto L5;
        DynamicConcertStatusChangeEventType r1 = DynamicConcertStatusChangeEventType.onExternalSoundCard;
        JsonObject r2 = new JsonObject();
        r2.addProperty("open", Integer.valueOf(r5 ? 1 : 0));
        Unit r6 = Unit.INSTANCE;
        r0.e(new hd2.b(r1, r2));
    L5:
        com.bytedance.android.live.pushstream.d r7 = k();
        if (r7 == null) goto L11;
        d0 r8 = r7.getLiveCore();
        if (r8 == null) goto L12;
        r8.h();
        return;
    L12:
        return;
    }

    public final void l(boolean r6) {
        this.c.setValue(Boolean.valueOf(r6));
        gd2.f r0 = ConcertStageDataContext.Companion.a();
        if (r0 == null) goto L5;
        DynamicConcertStatusChangeEventType r1 = DynamicConcertStatusChangeEventType.onHeadSetChange;
        JsonObject r2 = new JsonObject();
        r2.addProperty("open", Integer.valueOf(r6 ? 1 : 0));
        Unit r3 = Unit.INSTANCE;
        r0.e(new hd2.b(r1, r2));
    L5:
        w.b("ConcertEarMonitor", "onWiredStateChange: " + r6);
    }

    public final void g(boolean r1, boolean r2) {
        b();
        m();
        if (r2 == false) goto L6;
        com.bytedance.android.livesdk.sharedpref.e r3 = com.bytedance.android.livesdk.sharedpref.c.j;
        Boolean r4 = Boolean.valueOf(r1);
        r3.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r3, r4);
        return;
    }
}
