package com.ss.android.lark.integrator.ccm.dependency.di;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.location.dto.POIInfo;

/* JADX INFO: loaded from: classes36.dex */
public final class a1 implements ew4.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.lark.dependency.r.a f427838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f427839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ z0 f427840c;

    public a1(vp4.h r100, FragmentActivity r101, z0 r102) {
        this.f427838a = r100;
        this.f427839b = r101;
        this.f427840c = r102;
    }

    @Override // ew4.p
    public final void a(ew4.o r100) {
        com.bytedance.ee.bear.lark.dependency.r.a r101 = this.f427838a;
        if (r101 == null) goto L10;
        Activity r102 = this.f427839b;
        if (r100 == null) goto L7;
        POIInfo r103 = z0.i(this.f427840c, r100);
    L8:
        r101.a(r102, r103);
        return;
    L7:
        r103 = null;
        goto L8
    }
}
