package com.ss.android.lark.biz.im.api.extension.scroll;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {
    public static final void a(c r110, ScrollScene r111, long r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "scene");
        Intrinsics.checkNotNullParameter(r111, "scene");
        Function1<RecyclerView, Integer> r100 = ScrollEvent.f410222j;
        Intrinsics.checkNotNullParameter(r100, "value");
        ScrollAlign r101 = ScrollAlign.BOTTOM;
        Intrinsics.checkNotNullParameter(r101, "value");
        r110.f(new ScrollEvent(r111, r100, null, r101, r113, r112, null));
    }
}
