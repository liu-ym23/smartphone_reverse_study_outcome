package com.bytedance.ee.bear.profile;

import android.animation.ValueAnimator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements com.bytedance.ee.bear.facade.common.widget.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f236282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HalfProfileActivity f236283b;

    public c(j r100, HalfProfileActivity r101) {
        this.f236282a = r100;
        this.f236283b = r101;
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.d.b
    public final void a(int r100) {
        View r101 = this.f236282a.f226590e;
        if (r101 == null) goto L5;
        Float r102 = Float.valueOf(r101.getTranslationY());
    L7:
        if (Intrinsics.areEqual(r102, 0.0f) == false) goto L9;
        HalfProfileActivity r103 = this.f236283b;
        int r104 = HalfProfileActivity.f236243q;
        r103.D1(true, true);
        return;
    L9:
        if (r100 != 0) goto L11;
        this.f236283b.finish();
        return;
    L11:
        HalfProfileActivity r105 = this.f236283b;
        ValueAnimator r106 = this.f236282a.f226591f;
        if (r106 != null) goto L14;
    L16:
        boolean r107 = false;
    L17:
        r105.D1(false, !r107);
        return;
    L14:
        if (r106.isRunning() != true) goto L16;
        r107 = true;
        goto L17
    L5:
        r102 = null;
        goto L7
    }
}
