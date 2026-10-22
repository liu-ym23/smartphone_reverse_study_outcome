package com.bytedance.ee.bear.bitable.cardview.viewsetting;

import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class p<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CardViewSettingFragment f209278a;

    public p(CardViewSettingFragment r100) {
        this.f209278a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        LinearLayout r102 = this.f209278a.f209208e;
        Integer r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mobileSettingLayout");
        r102 = null;
    L5:
        Integer r104 = 0;
        r104.intValue();
        Intrinsics.checkNotNull(r101);
        if (r101.booleanValue() == false) goto L8;
        r103 = r104;
    L8:
        if (r103 == null) goto L10;
        int r105 = r103.intValue();
    L11:
        r102.setVisibility(r105);
        return;
    L10:
        r105 = 8;
        goto L11
    }
}
