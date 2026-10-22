package com.obric.oui.orecyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class ODragItemTouchHelper$CallbackImpl$animateDrop$1 extends Lambda implements Function2<Boolean, Throwable, Unit> {
    final /* synthetic */ View $item;
    final /* synthetic */ View $mirror;
    final /* synthetic */ RecyclerView.y $viewHolder;
    final /* synthetic */ y this$0;

    public ODragItemTouchHelper$CallbackImpl$animateDrop$1(View r100, View r101, y r102, RecyclerView.y r103) {
        this.$item = r100;
        this.$mirror = r101;
        this.$viewHolder = r103;
        super(2);
    }

    public final void invoke(boolean r100, Throwable r101) {
        this.$item.setScaleX(1.0f);
        this.$item.setScaleY(1.0f);
        this.$item.setVisibility(0);
        this.$mirror.setScaleX(1.0f);
        this.$mirror.setScaleY(1.0f);
        ViewParent r102 = this.$mirror.getParent();
        if ((r102 instanceof ViewGroup) == false) goto L5;
        ViewGroup r103 = (ViewGroup) r102;
    L6:
        if (r103 == null) goto L9;
        r103.removeView(this.$mirror);
    L9:
        int r104 = y.f401968a;
        throw null;
    L5:
        r103 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100, Throwable r101) {
        invoke(r100.booleanValue(), r101);
        return Unit.INSTANCE;
    }
}
