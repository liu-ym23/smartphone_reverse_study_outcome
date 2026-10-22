package com.obric.oui.animation.easy;

import android.view.View;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f {
    public static final <T extends View> b<T> a(T r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = r100.getTag(R.id.view_property_spring_animator_key);
        if ((r101 instanceof b) == false) goto L5;
        b<T> r102 = (b) r101;
    L6:
        if (r102 != null) goto L9;
        b<T> r103 = new b(r100);
        r100.setTag(R.id.view_property_spring_animator_key, r103);
        return r103;
    L9:
        return r102;
    L5:
        r102 = null;
        goto L6
    }
}
