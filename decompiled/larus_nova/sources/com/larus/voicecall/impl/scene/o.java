package com.larus.voicecall.impl.scene;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.bean.bot.SceneModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SceneModel f378741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f378742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f378743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f378744d;

    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.voicecall.impl.scene.n] */
    public o(SceneModel r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "impl");
        this.f378741a = r100;
        this.f378742b = r101;
        this.f378743c = new n(this);
    }
}
