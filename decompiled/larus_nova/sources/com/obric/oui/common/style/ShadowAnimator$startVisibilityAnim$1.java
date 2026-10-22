package com.obric.oui.common.style;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "value", "", "velocity", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class ShadowAnimator$startVisibilityAnim$1 extends Lambda implements Function3<String, Object, Object, Unit> {
    final /* synthetic */ List<q> $newShadow;
    final /* synthetic */ List<q> $oldShadow;
    final /* synthetic */ l $ouiLayout;

    public ShadowAnimator$startVisibilityAnim$1(List<q> r100, List<q> r101, l r102) {
        this.$oldShadow = r100;
        this.$newShadow = r101;
        this.$ouiLayout = r102;
        super(3);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100, Object r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "$noName_0");
        Intrinsics.checkNotNullParameter(r101, "value");
        Intrinsics.checkNotNullParameter(r102, "velocity");
        float r103 = ((Float) r101).floatValue();
        q r104 = q.f399591h;
        List<q> r105 = q.a.b(r103, this.$oldShadow, this.$newShadow);
        if (r105 == null) goto L7;
        this.$ouiLayout.C1(r105);
        return;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(String r100, Object r101, Object r102) {
        invoke2(r100, r101, r102);
        return Unit.INSTANCE;
    }
}
