package com.bytedance.dux.panel;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class DuxBasicPanelFragment$exeEnterAnim$1$1 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ DuxBasicPanelFragment this$0;

    public DuxBasicPanelFragment$exeEnterAnim$1$1(DuxBasicPanelFragment r100) {
        this.this$0 = r100;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Float r100) {
        invoke(r100.floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float r100) {
        DuxBasicPanelFragment r101 = this.this$0;
        int r102 = DuxBasicPanelFragment.f205323p;
        r101.getClass();
    }
}
