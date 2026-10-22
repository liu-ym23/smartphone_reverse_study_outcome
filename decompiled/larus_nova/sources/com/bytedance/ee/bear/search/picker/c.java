package com.bytedance.ee.bear.search.picker;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.search.picker.filter.type.e;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpaceSearchPickerFragment f236838a;

    public c(SpaceSearchPickerFragment r100) {
        this.f236838a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ArrayList<e> r101 = (ArrayList) r100;
        tt5.a.h("SpaceSearchPickerFragment", "selectType items is " + r101);
        com.bytedance.ee.bear.search.picker.filter.b r102 = this.f236838a.f236831g;
        if (r102 == null) goto L6;
        Intrinsics.checkNotNull(r101);
        r102.setTypeList(r101);
        return;
    }
}
