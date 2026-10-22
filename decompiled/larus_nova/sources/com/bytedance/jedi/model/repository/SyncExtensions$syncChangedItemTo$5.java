package com.bytedance.jedi.model.repository;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import com.bytedance.jedi.model.merge.MergeStrategy;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005*\u001a\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "K", "V", "K1", OuterPayLoginWrapper.LOGIN_STYLE_V1, "Lcom/bytedance/jedi/model/merge/MergeStrategy$KeyMerge;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 176)
public final class SyncExtensions$syncChangedItemTo$5 extends Lambda implements Function1<MergeStrategy.KeyMerge<Object, Object, Object, Object>, Unit> {
    final /* synthetic */ Function2<Object, Object, Object> $update;
    final /* synthetic */ Function1<Object, Object> $where;

    public SyncExtensions$syncChangedItemTo$5(Function1<Object, Object> r100, Function2<Object, Object, Object> r101) {
        this.$where = r100;
        this.$update = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MergeStrategy.KeyMerge<Object, Object, Object, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$keySyncTo");
        final Function1<Object, Object> r101 = this.$where;
        Function2<? super K, ? super V, ? extends K1> r102 = new AnonymousClass1(r101);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "block");
        r100.f251184a = r102;
        final Function2<Object, Object, Object> r103 = this.$update;
        Function3<? super K, ? super V, ? super V1, ? extends V1> r104 = new AnonymousClass2(r103);
        Intrinsics.checkNotNullParameter(r104, "block");
        r100.f251185b = r104;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MergeStrategy.KeyMerge<Object, Object, Object, Object> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
