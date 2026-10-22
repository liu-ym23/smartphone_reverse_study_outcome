package com.bytedance.ee.bear.search.picker;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.search.picker.filter.type.e;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ SpaceSearchPickerFragment a;

    public c(SpaceSearchPickerFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        ArrayList<e> r4 = (ArrayList) r3;
        tt5.a.h("SpaceSearchPickerFragment", "selectType items is " + r4);
        com.bytedance.ee.bear.search.picker.filter.b r0 = this.a.g;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r4);
        r0.setTypeList(r4);
        return;
    }
}
