package com.larus.avlink.plugins;

import com.byted.cast.common.TeaEventTrack;
import com.larus.avlink.business.api.DoraAvlinkSessionState;
import com.larus.avlink.platform.AndroidPlatformKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes25.dex */
public final class d extends com.larus.audio.call.arch.a<n4> implements y2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<com.larus.audio.call.arch.a<n4>> f293861f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f293862g;

    public static final class a implements a3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f293863a;

        @Override // com.larus.avlink.plugins.a3
        public final void b() {
            this.f293863a.getClass();
            y88.f r100 = d.l3();
            if (r100 == null) goto L6;
            r100.e3();
            return;
        }

        public a(d r100) {
            this.f293863a = r100;
        }

        @Override // com.larus.avlink.plugins.a3
        public final void a(DoraAvlinkSessionState r100) {
            Intrinsics.checkNotNullParameter(r100, TeaEventTrack.ACTION_DRAMA_NEXT);
            this.f293863a.getClass();
            d.k3(new y88.e.f(r100));
        }

        @Override // com.larus.avlink.plugins.a3
        public final void c(y88.g r100) {
            Intrinsics.checkNotNullParameter(r100, "config");
            this.f293863a.getClass();
            d.j3(r100);
        }

        @Override // com.larus.avlink.plugins.a3
        public final void e(y88.e r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            this.f293863a.getClass();
            d.k3(r100);
        }

        @Override // com.larus.avlink.plugins.a3
        public final void d(y88.g r100, y88.c r101) {
            Intrinsics.checkNotNullParameter(r100, "config");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f293863a.getClass();
            d.j3(r100);
            y88.f r102 = d.l3();
            if (r102 == null) goto L6;
            r102.f2(r101);
            return;
        }
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return "DoraSessionKMPPlugin";
    }

    @Override // com.larus.audio.call.arch.a
    public final void b3() {
    }

    public static y88.f l3() {
        pd6.b r100 = pd6.c.f528682a;
        return (y88.f) pd6.c.a(Reflection.getOrCreateKotlinClass(y88.f.class));
    }

    @Override // com.larus.audio.call.arch.a
    public final void V2() {
        Iterator<T> r100 = this.f293861f.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.larus.audio.call.arch.a) r100.next()).V2();
        goto L4
    }

    @Override // com.larus.audio.call.arch.a
    public final void W2() {
        Iterator<T> r100 = this.f293861f.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.larus.audio.call.arch.a) r100.next()).W2();
        goto L4
    }

    @Override // com.larus.audio.call.arch.a
    public final void X2() {
        Iterator<T> r100 = this.f293861f.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.larus.audio.call.arch.a) r100.next()).X2();
        goto L4
    }

    @Override // com.larus.audio.call.arch.a
    public final void Y2() {
        Iterator<T> r100 = this.f293861f.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.larus.audio.call.arch.a) r100.next()).Y2();
        goto L4
    }

    @Override // com.larus.audio.call.arch.a
    public final void a3() {
        Iterator<T> r100 = this.f293861f.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.larus.audio.call.arch.a) r100.next()).a3();
        goto L4
    }

    @Override // com.larus.audio.call.arch.a
    public final void g3() {
        Iterator r100 = ((ArrayList) this.f293861f).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.larus.audio.call.arch.a) r100.next()).g3();
        goto L4
    L6:
        super.g3();
        Iterator r101 = ((ArrayList) this.f293861f).iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        ((com.larus.audio.call.arch.a) r101.next()).b3();
        goto L8
    L10:
        y88.f r102 = l3();
        if (r102 == null) goto L13;
        r102.release();
    L13:
        d r103 = b3.f293837a;
        if (b3.f293837a != this) goto L19;
        b3.f293837a = null;
        return;
    }

    @Override // com.larus.audio.call.arch.a
    public final void h3() {
        Iterator<T> r100 = this.f293861f.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.larus.audio.call.arch.a) r100.next()).h3();
        goto L4
    }

    @Override // com.larus.audio.call.arch.a
    public final void e3() {
        super.e3();
        Iterator r100 = ((ArrayList) this.f293861f).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.larus.audio.call.arch.a) r100.next()).e3();
        goto L4
    }

    public d(n4 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f293861f = new ArrayList();
        this.f293862g = new a(this);
    }

    public static void j3(y88.g r100) {
        y88.f r101 = l3();
        if (r101 != null) goto L6;
        com.larus.avlink.n1.e("DoraSessionKMPPlugin", "DoraAvlinkSessionService unavailable");
        return;
    L6:
        AndroidPlatformKt.a();
        r101.I(r100.f566930a);
    }

    public static void k3(y88.e r100) {
        y88.f r101 = l3();
        if (r101 != null) goto L6;
        return;
    L6:
        if ((r100 instanceof y88.e.f) == false) goto L9;
        r101.c2(((y88.e.f) r100).f566926a.ordinal());
        return;
    L9:
        if (Intrinsics.areEqual(r100, y88.e.h.f566929a) == false) goto L12;
        r101.s1();
        return;
    L12:
        if (Intrinsics.areEqual(r100, y88.e.b.f566922a) == false) goto L15;
        r101.B0();
        return;
    L15:
        if ((r100 instanceof y88.e.C8315e) == false) goto L18;
        r101.I2(((y88.e.C8315e) r100).f566925a);
        return;
    L18:
        if (Intrinsics.areEqual(r100, y88.e.a.f566921a) == false) goto L21;
        r101.D();
        return;
    L21:
        if ((r100 instanceof y88.e.c) == false) goto L24;
        r101.R0(((y88.e.c) r100).f566923a);
        return;
    L24:
        if ((r100 instanceof y88.e.d) == false) goto L27;
        r101.r(((y88.e.d) r100).f566924a);
        return;
    L27:
        if ((r100 instanceof y88.e.g) == false) goto L31;
        y88.e.g r102 = (y88.e.g) r100;
        r101.u0(r102.f566927a, r102.f566928b.ordinal());
        return;
    L31:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.avlink.plugins.y2
    public final void r(boolean r100) {
        k3(new y88.e.d(r100));
    }
}
