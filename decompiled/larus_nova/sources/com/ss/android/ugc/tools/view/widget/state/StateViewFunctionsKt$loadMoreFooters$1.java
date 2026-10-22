package com.ss.android.ugc.tools.view.widget.state;

import android.view.ViewGroup;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/ss/android/ugc/tools/view/widget/state/LoadingView;", "parent", "Landroid/view/ViewGroup;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 1})
final class StateViewFunctionsKt$loadMoreFooters$1 extends Lambda implements Function1<ViewGroup, LoadingView> {
    public static final StateViewFunctionsKt$loadMoreFooters$1 INSTANCE = null;

    static {
        INSTANCE = new StateViewFunctionsKt$loadMoreFooters$1();
    }

    public StateViewFunctionsKt$loadMoreFooters$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ LoadingView invoke(ViewGroup r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final LoadingView invoke2(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new LoadingView(r100.getContext(), null);
    }
}
