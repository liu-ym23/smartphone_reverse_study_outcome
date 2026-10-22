package com.ss.android.lark.bottomsheet.fragment;

import androidx.lifecycle.Observer;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.ss.android.lark.bottomsheet.view.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomSheetFrameFragment f410712a;

    public b(BottomSheetFrameFragment r100) {
        this.f410712a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        LKUIRoundableLayout r102 = null;
        if (r101 != null) goto L6;
    L15:
        if (r101 != null) goto L18;
    L27:
        LKUIRoundableLayout r103 = this.f410712a.f410705e;
        if (r103 == null) goto L30;
        r102 = r103;
    L31:
        r102.setRadius(this.f410712a.S90(), 0.0f, this.f410712a.S90(), 0.0f);
        return;
    L30:
        Intrinsics.throwUninitializedPropertyAccessException("roundContainer");
        goto L31
    L18:
        if (r101.intValue() != 1) goto L27;
        j r104 = this.f410712a.f410708h;
        if (r104 == null) goto L22;
        r104.c();
    L22:
        LKUIRoundableLayout r105 = this.f410712a.f410705e;
        if (r105 == null) goto L25;
        r102 = r105;
    L26:
        r102.setRadius(this.f410712a.S90(), 0.0f, this.f410712a.S90(), 0.0f);
        return;
    L25:
        Intrinsics.throwUninitializedPropertyAccessException("roundContainer");
        goto L26
    L6:
        if (r101.intValue() != 2) goto L15;
        j r106 = this.f410712a.f410708h;
        if (r106 == null) goto L10;
        r106.b();
    L10:
        LKUIRoundableLayout r107 = this.f410712a.f410705e;
        if (r107 == null) goto L13;
        r102 = r107;
    L14:
        r102.setRadius(0.0f, 0.0f, 0.0f, 0.0f);
        return;
    L13:
        Intrinsics.throwUninitializedPropertyAccessException("roundContainer");
        goto L14
    }
}
