package com.douyin.janna.platform;

import com.douyin.janna.api.CapabilityType;
import com.oplus.ocs.base.common.api.OnConnectionSucceedListener;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes22.dex */
public final class g implements OnConnectionSucceedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f273620a;

    @Override // com.oplus.ocs.base.common.api.OnConnectionSucceedListener
    public final void onConnectionSucceed() {
        if (this.f273620a.f273623n != null) goto L5;
        return;
    L5:
        com.oplus.ocs.hyperboost.g r100 = com.oplus.ocs.hyperboost.b.f404317j;
        if (r100 == null) goto L13;
        r100.a();
        i r101 = this.f273620a;
        Set<CapabilityType> r102 = r101.f273605h;
        HashSet r103 = (HashSet) r102;
        r103.add(CapabilityType.GET_THERMAL_STATUS_INFO);
        Set<CapabilityType> r104 = r101.f273605h;
        HashSet r105 = (HashSet) r104;
        r105.add(CapabilityType.RECEIVE_THERMAL_STATUS_INFO);
        r101.b();
        r101.f273602e = 1;
        boolean r106 = hq7.a.f486512a;
        Set<CapabilityType> r107 = r101.f273605h;
        HashSet r108 = (HashSet) r107;
        r108.add(CapabilityType.SET_FPS);
        Set<CapabilityType> r109 = r101.f273605h;
        HashSet r110 = (HashSet) r109;
        r110.add(CapabilityType.CANCEL_FPS);
        Set<CapabilityType> r111 = r101.f273605h;
        HashSet r112 = (HashSet) r111;
        r112.add(CapabilityType.APP_LONG_BOOST);
        Set<CapabilityType> r113 = r101.f273605h;
        HashSet r114 = (HashSet) r113;
        r114.add(CapabilityType.APP_SHORT_BOOST);
        Set<CapabilityType> r115 = r101.f273605h;
        HashSet r116 = (HashSet) r115;
        r116.add(CapabilityType.GPU_BOOST);
        Set<CapabilityType> r117 = r101.f273605h;
        HashSet r118 = (HashSet) r117;
        r118.add(CapabilityType.DDR_BOOST);
        Set<CapabilityType> r119 = r101.f273605h;
        HashSet r120 = (HashSet) r119;
        r120.add(CapabilityType.SET_IMPORTANT_THREAD);
        Set<CapabilityType> r121 = r101.f273605h;
        HashSet r122 = (HashSet) r121;
        r122.add(CapabilityType.SET_CPU_SCENE_INFO);
        this.f273620a.f273600c = true;
        i r123 = this.f273620a;
        if (r123.f273622m != null) goto L10;
        r123.j();
    L10:
        boolean r124 = this.f273620a.f273600c;
        this.f273620a.g(new fs7.a(0, null));
        return;
    L13:
        throw new RuntimeException("mHyperBoostUnitInterface has already destroyed, call it before destroy() ");
    }

    public g(i r100) {
        this.f273620a = r100;
    }
}
