package com.bytedance.locallife.common.utils;

import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class ViewExtensionFunctionsKt$onDebounceClick$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<View, Unit> $onClick;
    final /* synthetic */ View $this_onDebounceClick;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewExtensionFunctionsKt$onDebounceClick$1(Function1<? super View, Unit> r100, View r101) {
        this.$onClick = r100;
        this.$this_onDebounceClick = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$onClick.invoke(this.$this_onDebounceClick);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
