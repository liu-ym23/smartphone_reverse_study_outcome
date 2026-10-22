package com.obric.oui.common.style;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "isSuccess", "", com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class ShadowAnimator$startVisibilityAnim$2 extends Lambda implements Function2<Boolean, Throwable, Unit> {
    final /* synthetic */ List<q> $newShadow;
    final /* synthetic */ l $ouiLayout;

    public ShadowAnimator$startVisibilityAnim$2(l r100, List<q> r101) {
        this.$ouiLayout = r100;
        this.$newShadow = r101;
        super(2);
    }

    public final void invoke(boolean r100, Throwable r101) {
        this.$ouiLayout.A((q) CollectionsKt.getOrNull(this.$newShadow, 0), (q) CollectionsKt.getOrNull(this.$newShadow, 1), false);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100, Throwable r101) {
        invoke(r100.booleanValue(), r101);
        return Unit.INSTANCE;
    }
}
