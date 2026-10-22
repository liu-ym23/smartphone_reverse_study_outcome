package com.bytedance.relax.ttmlstatic.prewarm.page;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.relax.ttmlstatic.CardSession;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import s87.j;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<no name provided>", "", "ptr", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class SrcPrewarmPageRxPage$Companion$task$1 extends Lambda implements Function1<Long, Unit> {
    public static final SrcPrewarmPageRxPage$Companion$task$1 INSTANCE = null;

    static {
        INSTANCE = new SrcPrewarmPageRxPage$Companion$task$1();
    }

    public SrcPrewarmPageRxPage$Companion$task$1() {
        super(1);
    }

    public final void invoke(long r100) {
        final b r101 = new b();
        final CardSession r102 = new CardSession(new j(r100));
        r102.l(new SrcPrewarmPageRxPageKt$RenderEntry$1(r101, r102), new SrcPrewarmPageRxPageKt$RenderEntry$2(r101, r102), new SrcPrewarmPageRxPageKt$RenderEntry$3(r101, r102));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long r100) {
        invoke(r100.longValue());
        return Unit.INSTANCE;
    }
}
