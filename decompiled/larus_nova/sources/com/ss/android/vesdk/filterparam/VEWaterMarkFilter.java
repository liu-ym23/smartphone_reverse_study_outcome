package com.ss.android.vesdk.filterparam;

import com.ss.android.ttve.nativePort.TEBundle;
import com.ss.android.vesdk.VEWaterMarkPosition;

/* JADX INFO: loaded from: classes40.dex */
public class VEWaterMarkFilter extends VEBaseFilterParam {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VEWaterMarkPosition f455824a;

    public VEWaterMarkFilter() {
        this.f455824a = VEWaterMarkPosition.TL_BR;
        this.filterType = 5;
        this.filterName = "WaterMark";
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam
    public final TEBundle getBundle() {
        TEBundle r100 = super.getBundle();
        r100.setInt("Width", 0);
        r100.setInt("Height", 0);
        r100.setInt("xOffset", 0);
        r100.setInt("yOffset", 0);
        r100.setInt("Position", this.f455824a.ordinal());
        r100.setInt("Rotation", 0);
        return r100;
    }
}
