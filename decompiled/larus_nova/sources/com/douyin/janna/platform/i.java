package com.douyin.janna.platform;

import android.content.Context;
import android.os.Bundle;
import com.douyin.janna.api.CapabilityType;
import com.oplus.ocs.base.common.Feature;
import com.oplus.ocs.base.utils.ServiceCheck;
import com.oplus.util.OplusHoraeThermalHelper;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes22.dex */
public final class i extends com.douyin.janna.platform.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public a f273622m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.oplus.ocs.hyperboost.b f273623n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f273624o;

    public class a implements com.oplus.ocs.hyperboost.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f273625a;

        public a(i r100) {
            this.f273625a = r100;
        }

        @Override // com.oplus.ocs.hyperboost.a
        public final void a(String r100) {
            boolean r101 = hq7.a.f486512a;
            if (r100 == null) goto L37;
            int r102 = this.f273625a.f273602e;
            if (r100.equals("HighLimit") == false) goto L8;
            this.f273625a.f273602e = 3;
        L33:
            i r103 = this.f273625a;
            int r104 = r103.f273602e;
            if (r102 == r104) goto L38;
            Bundle r105 = new Bundle();
            r105.putInt("thermal_status", r104);
            r105.putFloat("thermal_temp", r103.b());
            r103.g(new fs7.a(1, r105));
            return;
        L38:
            return;
        L8:
            if (r100.equals("LowLimit") == false) goto L11;
            this.f273625a.f273602e = 0;
            goto L33
        L11:
            if (r100.equals("MTS:Support") == false) goto L14;
            Set<CapabilityType> r106 = this.f273625a.f273605h;
            HashSet r107 = (HashSet) r106;
            r107.add(CapabilityType.GET_LOW_POWER_MODE);
            goto L33
        L14:
            if (r100.equals("MTS:LOWPOWER_ON") == false) goto L19;
            i r108 = this.f273625a;
            if (r108.f273603f == 1) goto L33;
            r108.f273603f = 1;
            r108.g(com.douyin.janna.platform.a.a(1));
            goto L33
        L19:
            if (r100.equals("MTS:LOWPOWER_OFF") == false) goto L24;
            i r109 = this.f273625a;
            if (r109.f273603f == 0) goto L33;
            r109.f273603f = 0;
            r109.g(com.douyin.janna.platform.a.a(0));
            goto L33
        L24:
            if (r100.equals("MTS:PreloadOn") == false) goto L29;
            i r110 = this.f273625a;
            if (r110.f273604g == 1) goto L33;
            r110.f273604g = 1;
            Bundle r111 = new Bundle();
            r111.putInt("open", 1);
            r110.g(new fs7.a(12, r111));
            goto L33
        L29:
            if (r100.equals("MTS:PreloadOff") == false) goto L33;
            i r112 = this.f273625a;
            if (r112.f273604g == 0) goto L33;
            r112.f273604g = 0;
            Bundle r113 = new Bundle();
            r113.putInt("open", 0);
            r112.g(new fs7.a(12, r113));
            goto L33
        }
    }

    @Override // com.douyin.janna.platform.a
    public final void f() {
        Context r100 = this.f273598a;
        List<Feature> r101 = com.oplus.ocs.hyperboost.b.f404314g;
        monitor-enter(com.oplus.ocs.hyperboost.b.class);
        com.oplus.ocs.hyperboost.b r102 = com.oplus.ocs.hyperboost.b.f404316i;     // Catch: Throwable -> L24
        if (r102 == null) goto L10;
        r102.addThis2Cache();     // Catch: Throwable -> L24
        com.oplus.ocs.hyperboost.b r103 = com.oplus.ocs.hyperboost.b.f404316i;     // Catch: Throwable -> L24
        monitor-exit(com.oplus.ocs.hyperboost.b.class);
    L16:
        this.f273623n = r103;
        if (r103 != null) goto L19;
        boolean r104 = hq7.a.f486512a;
    L21:
        if (b() == (-1.0f)) goto L28;
        Set<CapabilityType> r105 = this.f273605h;
        HashSet r106 = (HashSet) r105;
        r106.add(CapabilityType.GET_PHONE_TEMP);
        return;
    L28:
        return;
    L19:
        r103.addOnConnectionSucceedListener(new g(this));
        this.f273623n.addOnConnectionFailedListener(new h(this));
        goto L21
    L10:
        if (ServiceCheck.check(r100, "com.oplus.cosa") == false) goto L12;
        com.oplus.ocs.hyperboost.g r107 = new com.oplus.ocs.hyperboost.e();     // Catch: Throwable -> L24
    L13:
        com.oplus.ocs.hyperboost.b r108 = new com.oplus.ocs.hyperboost.b(r100, r107);     // Catch: Throwable -> L24
        com.oplus.ocs.hyperboost.b.f404316i = r108;     // Catch: Throwable -> L24
        monitor-exit(com.oplus.ocs.hyperboost.b.class);
        r103 = r108;
        goto L16
    L12:
        r107 = new com.oplus.ocs.hyperboost.c();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public final void j() {
        if (this.f273600c == true) goto L5;
        return;
    L5:
        if (this.f273623n != null) goto L7;
        return;
    L7:
        if (this.f273622m != null) goto L15;
        a r100 = new a(this);
        this.f273622m = r100;
        com.oplus.ocs.hyperboost.g r101 = com.oplus.ocs.hyperboost.b.f404317j;
        if (r101 == null) goto L12;
        r101.b(r100);
        boolean r102 = hq7.a.f486512a;
        return;
    L12:
        throw new RuntimeException("mHyperBoostUnitInterface has already destroyed, call it before destroy() ");
    }

    @Override // com.douyin.janna.platform.a
    public final float b() {
        float r100 = OplusHoraeThermalHelper.getInstance().getCurrentThermal();
        this.f273601d = r100;
        boolean r101 = hq7.a.f486512a;
        return r100;
    }

    @Override // com.douyin.janna.platform.a
    public final int c() {
        return this.f273602e;
    }

    public i(Context r100) {
        super(r100);
        Set<CapabilityType> r101 = this.f273605h;
        HashSet r102 = (HashSet) r101;
        r102.add(CapabilityType.SET_REFRESH_RATE);
    }

    @Override // com.douyin.janna.platform.a
    public final void h(fs7.b r100, List<Integer> r101) {
        super.h(r100, r101);
        j();
        if (this.f273600c == true) goto L5;
        return;
    L5:
        if (r101.contains(11) == false) goto L11;
        int r102 = this.f273603f;
        if (r102 != 1) goto L12;
        r100.onEvent(com.douyin.janna.platform.a.a(r102));
        return;
    L12:
        return;
    }

    @Override // com.douyin.janna.platform.a
    public final void i(fs7.b r100, List<Integer> r101) {
        super.i(r100, r101);
    }
}
