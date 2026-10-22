package com.bytedance.jedi.model.repository;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import com.bytedance.jedi.model.merge.MergeStrategy;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*$\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0005H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "V", "K1", OuterPayLoginWrapper.LOGIN_STYLE_V1, "Lcom/bytedance/jedi/model/merge/MergeStrategy$BatchMerge;", "", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 176)
public final class SyncExtensions$syncChangedListTo$2 extends Lambda implements Function1<?, Unit> {
    final /* synthetic */ Function1<Object, Pair<Object, Object>> $map;

    /* JADX WARN: Multi-variable type inference failed */
    public SyncExtensions$syncChangedListTo$2(Function1<Object, ? extends Pair<Object, Object>> r100) {
        this.$map = r100;
        super(1);
    }

    public final void invoke(MergeStrategy.BatchMerge<? extends Object, List<Object>, Object, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$batchSyncTo");
        final Function1<Object, Pair<Object, Object>> r101 = this.$map;
        Function1<List<Object>, List<? extends Pair<Object, Object>>> r102 = new AnonymousClass1(r101);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "block");
        r100.f251182a = r102;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object r100) {
        invoke((MergeStrategy.BatchMerge) r100);
        return Unit.INSTANCE;
    }
}
