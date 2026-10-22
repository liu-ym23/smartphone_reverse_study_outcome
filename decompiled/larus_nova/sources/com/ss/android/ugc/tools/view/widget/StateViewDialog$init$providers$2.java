package com.ss.android.ugc.tools.view.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 1})
final class StateViewDialog$init$providers$2 extends Lambda implements Function1<ViewGroup, View> {
    public static final StateViewDialog$init$providers$2 INSTANCE = null;

    static {
        INSTANCE = new StateViewDialog$init$providers$2();
    }

    public StateViewDialog$init$providers$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final View invoke2(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.tools_default_empty_state, r100, false);
        TextView r102 = (TextView) r101.findViewById(R.id.tv_title);
        TextView r103 = (TextView) r101.findViewById(R.id.tv_desc);
        return r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ View invoke(ViewGroup r100) {
        return invoke2(r100);
    }
}
