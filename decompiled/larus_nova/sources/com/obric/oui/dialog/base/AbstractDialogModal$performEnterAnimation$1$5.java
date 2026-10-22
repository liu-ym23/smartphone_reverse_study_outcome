package com.obric.oui.dialog.base;

import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/obric/oui/animation/easy/b;", "Landroid/view/View;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/obric/oui/animation/easy/b;)V", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class AbstractDialogModal$performEnterAnimation$1$5 extends Lambda implements Function1<com.obric.oui.animation.easy.b<View>, Unit> {
    final /* synthetic */ AbstractDialogModal this$0;

    public AbstractDialogModal$performEnterAnimation$1$5(AbstractDialogModal r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.obric.oui.animation.easy.b<View> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.this$0.b();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.obric.oui.animation.easy.b<View> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
