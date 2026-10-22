package com.larus.avlink.plugins;

import com.larus.avlink.business.api.DoraAvlinkDeviceLightAction;
import com.larus.avlink.business.api.DoraAvlinkDeviceSound;
import com.larus.avlink.business.api.DoraAvlinkSessionEndReason;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class l implements y88.d {
    public l() {
    }

    @Override // y88.d
    public final y88.a X1() {
        d r100 = b3.f293837a;
        d r101 = b3.f293837a;
        if (r101 == null) goto L18;
        List<com.larus.audio.call.arch.a<n4>> r102 = r101.f293861f;
        if (r102 == null) goto L18;
        Iterator r103 = ((ArrayList) r102).iterator();
    L8:
        if (r103.hasNext() == false) goto L18;
        Object r104 = (com.larus.audio.call.arch.a) r103.next();
        y88.a r105 = null;
        if ((r104 instanceof z2) == false) goto L12;
        z2 r106 = (z2) r104;
    L13:
        if (r106 == null) goto L15;
        r105 = r106.p2();
    L15:
        if (r105 == null) goto L8;
        return r105;
    L12:
        r106 = null;
    L18:
        return new y88.a(false);
    }

    @Override // y88.d
    public final void j1() {
        d r100 = b3.f293837a;
        d r101 = b3.f293837a;
        if (r101 == null) goto L15;
        List<com.larus.audio.call.arch.a<n4>> r102 = r101.f293861f;
        if (r102 == null) goto L21;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L22;
        Object r104 = (com.larus.audio.call.arch.a) r103.next();
        if ((r104 instanceof z2) == false) goto L12;
        z2 r105 = (z2) r104;
    L13:
        if (r105 == null) goto L8;
        r105.Z0();
        goto L8
    L12:
        r105 = null;
        goto L13
    L22:
        return;
    L21:
        return;
    }

    @Override // y88.d
    public final void X(int r100) {
        d r101 = b3.f293837a;
        d r102 = b3.f293837a;
        if (r102 == null) goto L27;
        List<com.larus.audio.call.arch.a<n4>> r103 = r102.f293861f;
        if (r103 == null) goto L38;
        Iterator r104 = ((ArrayList) r103).iterator();
    L8:
        if (r104.hasNext() == false) goto L39;
        Object r105 = (com.larus.audio.call.arch.a) r104.next();
        DoraAvlinkSessionEndReason r106 = null;
        if ((r105 instanceof z2) == false) goto L12;
        z2 r107 = (z2) r105;
    L13:
        if (r107 == null) goto L8;
        Iterator<DoraAvlinkSessionEndReason> r108 = DoraAvlinkSessionEndReason.getEntries().iterator();
    L16:
        if (r108.hasNext() == false) goto L23;
        DoraAvlinkSessionEndReason r109 = r108.next();
        if (r109.getValue() != r100) goto L20;
        boolean r110 = true;
    L21:
        if (r110 == false) goto L16;
        r106 = r109;
        goto L23
    L20:
        r110 = false;
    L23:
        DoraAvlinkSessionEndReason r111 = r106;
        if (r111 != null) goto L26;
        r111 = DoraAvlinkSessionEndReason.UNKNOWN;
    L26:
        r107.X0(r111);
        goto L8
    L12:
        r107 = null;
        goto L13
    L39:
        return;
    L38:
        return;
    }

    @Override // y88.d
    public final void j2(int r100) {
        d r101 = b3.f293837a;
        d r102 = b3.f293837a;
        if (r102 == null) goto L18;
        List<com.larus.audio.call.arch.a<n4>> r103 = r102.f293861f;
        if (r103 == null) goto L24;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L25;
        Object r105 = (com.larus.audio.call.arch.a) r104.next();
        if ((r105 instanceof z2) == false) goto L12;
        z2 r106 = (z2) r105;
    L13:
        if (r106 == null) goto L8;
        DoraAvlinkDeviceSound r107 = (DoraAvlinkDeviceSound) CollectionsKt.getOrNull(DoraAvlinkDeviceSound.getEntries(), r100);
        if (r107 != null) goto L17;
        r107 = DoraAvlinkDeviceSound.VUI_ERROR;
    L17:
        r106.F(r107);
        goto L8
    L12:
        r106 = null;
        goto L13
    L25:
        return;
    L24:
        return;
    }

    @Override // y88.d
    public final void k1(int r100) {
        d r101 = b3.f293837a;
        d r102 = b3.f293837a;
        if (r102 == null) goto L18;
        List<com.larus.audio.call.arch.a<n4>> r103 = r102.f293861f;
        if (r103 == null) goto L24;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L25;
        Object r105 = (com.larus.audio.call.arch.a) r104.next();
        if ((r105 instanceof z2) == false) goto L12;
        z2 r106 = (z2) r105;
    L13:
        if (r106 == null) goto L8;
        DoraAvlinkDeviceLightAction r107 = (DoraAvlinkDeviceLightAction) CollectionsKt.getOrNull(DoraAvlinkDeviceLightAction.getEntries(), r100);
        if (r107 != null) goto L17;
        r107 = DoraAvlinkDeviceLightAction.INDICATOR_RAPID_FLASHING;
    L17:
        r106.c2(r107);
        goto L8
    L12:
        r106 = null;
        goto L13
    L25:
        return;
    L24:
        return;
    }

    @Override // y88.d
    public final void log(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        com.larus.avlink.n1.d("DoraSessionKMPPlugin", r100);
    }

    @Override // y88.d
    public final void k(boolean r100, int r101) {
        d r102 = b3.f293837a;
        d r103 = b3.f293837a;
        if (r103 == null) goto L15;
        List<com.larus.audio.call.arch.a<n4>> r104 = r103.f293861f;
        if (r104 == null) goto L21;
        Iterator<T> r105 = r104.iterator();
    L8:
        if (r105.hasNext() == false) goto L22;
        Object r106 = (com.larus.audio.call.arch.a) r105.next();
        if ((r106 instanceof z2) == false) goto L12;
        z2 r107 = (z2) r106;
    L13:
        if (r107 == null) goto L8;
        r107.h0(r100, r101);
        goto L8
    L12:
        r107 = null;
        goto L13
    L22:
        return;
    L21:
        return;
    }

    @Override // y88.d
    public final void trackEvent(String r100, String r101) {
        Intrinsics.checkNotNullParameter("dora_avlink_timeout", "event");
        Intrinsics.checkNotNullParameter(r101, "paramsJson");
        d r102 = b3.f293837a;
        d r103 = b3.f293837a;
        if (r103 == null) goto L15;
        List<com.larus.audio.call.arch.a<n4>> r104 = r103.f293861f;
        if (r104 == null) goto L21;
        Iterator r105 = ((ArrayList) r104).iterator();
    L8:
        if (r105.hasNext() == false) goto L22;
        Object r106 = (com.larus.audio.call.arch.a) r105.next();
        if ((r106 instanceof z2) == false) goto L12;
        z2 r107 = (z2) r106;
    L13:
        if (r107 == null) goto L8;
        r107.Y(r101);
        goto L8
    L12:
        r107 = null;
        goto L13
    L22:
        return;
    L21:
        return;
    }

    @Override // y88.d
    public final void v1(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "paramsJson");
        d r102 = b3.f293837a;
        d r103 = b3.f293837a;
        if (r103 == null) goto L15;
        List<com.larus.audio.call.arch.a<n4>> r104 = r103.f293861f;
        if (r104 == null) goto L21;
        Iterator<T> r105 = r104.iterator();
    L8:
        if (r105.hasNext() == false) goto L22;
        Object r106 = (com.larus.audio.call.arch.a) r105.next();
        if ((r106 instanceof z2) == false) goto L12;
        z2 r107 = (z2) r106;
    L13:
        if (r107 == null) goto L8;
        r107.g2(r100, r101);
        goto L8
    L12:
        r107 = null;
        goto L13
    L22:
        return;
    L21:
        return;
    }
}
