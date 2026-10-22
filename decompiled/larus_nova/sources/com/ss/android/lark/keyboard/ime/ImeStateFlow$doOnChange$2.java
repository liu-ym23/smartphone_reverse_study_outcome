package com.ss.android.lark.keyboard.ime;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "old", "Lcom/ss/android/lark/keyboard/ime/ImeStateDetail;", "new", AbsMethodDelegate.TAG_INVOKE, "(Lcom/ss/android/lark/keyboard/ime/ImeStateDetail;Lcom/ss/android/lark/keyboard/ime/ImeStateDetail;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ImeStateFlow$doOnChange$2 extends Lambda implements Function2<ImeStateDetail, ImeStateDetail, Boolean> {
    final /* synthetic */ Function2<ImeStateDetail, ImeStateDetail, Unit> $collector;

    /* JADX WARN: Multi-variable type inference failed */
    public ImeStateFlow$doOnChange$2(Function2<? super ImeStateDetail, ? super ImeStateDetail, Unit> r100) {
        this.$collector = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(ImeStateDetail r100, ImeStateDetail r101) {
        Intrinsics.checkNotNullParameter(r100, "old");
        Intrinsics.checkNotNullParameter(r101, "new");
        if (r100 == r101) goto L6;
        this.$collector.invoke(r100, r101);
    L6:
        return Boolean.FALSE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(ImeStateDetail r100, ImeStateDetail r101) {
        return invoke2(r100, r101);
    }
}
