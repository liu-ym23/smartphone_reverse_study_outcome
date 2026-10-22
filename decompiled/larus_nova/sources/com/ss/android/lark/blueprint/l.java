package com.ss.android.lark.blueprint;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class l {
    public static final <ViewType extends View> s a(ViewType r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = r100.getTag(R.id.blueprint_block_view);
        if ((r101 instanceof t) == false) goto L5;
        t r102 = (t) r101;
    L6:
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.a();
    L5:
        r102 = null;
        goto L6
    }

    public static final <ViewBindingType extends ViewBinding> b<ViewBindingType> b(ViewBindingType r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new b(r100);
    }

    public static final w c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new w(r100);
    }
}
