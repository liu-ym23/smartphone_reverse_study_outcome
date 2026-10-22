package com.bytedance.ee.bear.profile;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements VerticalScrollInterceptLayout.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HalfProfileActivity f236281a;

    public b(HalfProfileActivity r100) {
        this.f236281a = r100;
    }

    @Override // com.bytedance.ee.bear.profile.VerticalScrollInterceptLayout.a
    public final boolean a(float r100) {
        j r101 = this.f236281a.f236248j;
        if (r101 == null) goto L11;
        View r102 = r101.f226590e;
        if (r102 == null) goto L7;
        Float r103 = Float.valueOf(r102.getTranslationY());
    L9:
        if (Intrinsics.areEqual(r103, 0.0f) == true) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L14;
    L17:
        return true;
    L14:
        if (r100 > 0.0f) goto L16;
        return false;
    L16:
        if (this.f236281a.f236250l == true) goto L17;
        return false;
    L7:
        r103 = null;
    L11:
        r104 = false;
        goto L12
    }
}
