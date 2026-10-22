package com.obric.oui.orecyclerview.widget;

import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class ODragItemTouchHelper$CallbackImpl$animatePickUp$1 extends Lambda implements Function2<Boolean, Throwable, Unit> {
    final /* synthetic */ View $mirror;
    final /* synthetic */ y this$0;

    public ODragItemTouchHelper$CallbackImpl$animatePickUp$1(View r100, y r101) {
        this.$mirror = r100;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100, Throwable r101) {
        invoke(r100.booleanValue(), r101);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean r100, Throwable r101) {
        this.$mirror.setAlpha(1.0f);
        int r102 = y.f401968a;
        throw null;
    }
}
