package com.ss.android.ugc.tools.view.widget.state;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "parent", "Landroid/view/ViewGroup;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 1})
final class StateViewFunctionsKt$loadMoreFooters$2 extends Lambda implements Function1<ViewGroup, TextView> {
    final /* synthetic */ Function1 $configureEmptyView;

    public StateViewFunctionsKt$loadMoreFooters$2(Function1 r100) {
        this.$configureEmptyView = r100;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TextView invoke(ViewGroup r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final TextView invoke2(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Function1 r101 = this.$configureEmptyView;
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.tools_default_load_more_empty_footer, r100, false);
        if (r102 == null) goto L9;
        TextView r103 = (TextView) r102;
        r103.setGravity(17);
        if (r101 == null) goto L7;
        Unit r104 = (Unit) r101.invoke(r103);
    L7:
        return r103;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }
}
