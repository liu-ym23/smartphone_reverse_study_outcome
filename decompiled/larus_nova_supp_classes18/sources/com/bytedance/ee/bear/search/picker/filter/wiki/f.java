package com.bytedance.ee.bear.search.picker.filter.wiki;

import androidx.lifecycle.Observer;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ WikiSearchPickerFragment a;

    public f(WikiSearchPickerFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        ArrayList<com.bytedance.ee.bear.search.picker.filter.type.e> r4 = (ArrayList) r3;
        tt5.a.h("WikiSearchPickerFragment", "selectType items is " + r4);
        b r0 = this.a.h;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r4);
        r0.setTypeList(r4);
        return;
    }
}
