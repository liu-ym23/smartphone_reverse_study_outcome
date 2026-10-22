package com.relax.relaxreact;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\"\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<no name provided>", "", "gestureVersions", "", "", "Lcom/bytedance/rts/kmp/foundation/RTSMap;", "ele", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class GestureBindingManager$dispose$1 extends Lambda implements Function2<Map<Integer, Integer>, Long, Unit> {
    final /* synthetic */ mpa.l $renderer;

    public GestureBindingManager$dispose$1(mpa.l r100) {
        this.$renderer = r100;
        super(2);
    }

    public final void invoke(Map<Integer, Integer> r100, final long r101) {
        Intrinsics.checkNotNullParameter(r100, "gestureVersions");
        final mpa.l r102 = this.$renderer;
        com.bytedance.rts.kmp.foundation.j.b(r100, new AnonymousClass1(r102, r101));
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Map<Integer, Integer> r100, Long r101) {
        invoke(r100, r101.longValue());
        return Unit.INSTANCE;
    }
}
