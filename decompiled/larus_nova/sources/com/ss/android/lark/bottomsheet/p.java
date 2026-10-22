package com.ss.android.lark.bottomsheet;

import androidx.lifecycle.Observer;
import com.ss.android.lark.bottomsheet.view.ExpandValueAnimatorInForseti;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class p<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomSheetContainerFragment f410723a;

    public p(BottomSheetContainerFragment r100) {
        this.f410723a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        BottomSheetContainerFragment r102 = this.f410723a;
        int r103 = BottomSheetContainerFragment.f410674u;
        Integer r104 = r102.Z90().getState().getValue();
        if (r104 != null) goto L6;
    L8:
        BottomSheetContainerFragment r105 = this.f410723a;
        ExpandValueAnimatorInForseti r106 = r105.f410677n;
        if (r106 == null) goto L12;
        ExpandValueAnimatorInForseti.b r107 = r105.W90();
        Intrinsics.checkNotNullParameter(r107, "animatorConfig");
        r106.f410737c = r107;
        return;
    L12:
        return;
    L6:
        if (r104.intValue() != 2) goto L8;
    }
}
