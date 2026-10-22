package com.bytedance.jedi.model.repository;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import com.bytedance.jedi.model.merge.MergeStrategy;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*(\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u0002H\u0002\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00060\u0004H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "V", OuterPayLoginWrapper.LOGIN_STYLE_V1, "Lcom/bytedance/jedi/model/merge/MergeStrategy$PredicatedMerge;", "", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 176)
public final class SyncExtensions$syncChangedItemTo$7 extends Lambda implements Function1<?, Unit> {
    final /* synthetic */ Function2<Object, Object, Boolean> $needUpdate;
    final /* synthetic */ Function2<Object, Object, Object> $update;

    public SyncExtensions$syncChangedItemTo$7(Function2<Object, Object, Boolean> r100, Function2<Object, Object, Object> r101) {
        this.$needUpdate = r100;
        this.$update = r101;
        super(1);
    }

    public final void invoke(MergeStrategy.PredicatedMerge<? extends Object, Object, ? extends Object, List<Object>> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$predicatedSyncTo");
        AnonymousClass1 r101 = AnonymousClass1.INSTANCE;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "block");
        r100.f251186a = r101;
        final Function2<Object, Object, Boolean> r102 = this.$needUpdate;
        final Function2<Object, Object, Object> r103 = this.$update;
        Function2<? super V, ? super V1, ? extends V1> r104 = new AnonymousClass2(r102, r103);
        Intrinsics.checkNotNullParameter(r104, "block");
        r100.f251187b = r104;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object r100) {
        invoke((MergeStrategy.PredicatedMerge) r100);
        return Unit.INSTANCE;
    }
}
