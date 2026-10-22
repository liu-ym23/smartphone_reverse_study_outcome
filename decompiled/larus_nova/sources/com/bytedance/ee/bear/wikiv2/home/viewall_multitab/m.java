package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class m<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiSpaceTabFragment f240791a;

    public m(WikiSpaceTabFragment r100) {
        this.f240791a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        BaseTitleBar r102 = this.f240791a.V90();
        Intrinsics.checkNotNull(r101);
        r102.setTitle(r101.intValue());
    }
}
