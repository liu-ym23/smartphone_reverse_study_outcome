package com.ss.android.ugc.aweme.search.utils.extensions;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"trade-search-impl_release"}, k = 2, mv = {1, 4, 3})
public final class ViewExtensionsKt {
    public static final void b(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L6;
        r102.width = r101;
    L6:
        r100.setLayoutParams(r102);
    }

    public static final void a(final View r100, long r101, final Function1<? super View, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, SendEventContainerMethodParamModel.EventKinds.onClick);
        r100.setOnClickListener(new ViewDebounceClickListener(r101, new ViewExtensionsKt$onViewDebounceClick$1(r102, r100)));
    }
}
