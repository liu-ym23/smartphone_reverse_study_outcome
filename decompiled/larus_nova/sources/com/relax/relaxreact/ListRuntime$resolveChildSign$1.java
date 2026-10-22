package com.relax.relaxreact;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<no name provided>", "", "value", "Lcom/relax/relaxreact/SnapshotInstance;", "key", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class ListRuntime$resolveChildSign$1 extends Lambda implements Function2<SnapshotInstance, Long, Unit> {
    final /* synthetic */ Ref.ObjectRef<SnapshotInstance> $recycledCtx;
    final /* synthetic */ Ref.ObjectRef<Long> $reusedSign;

    public ListRuntime$resolveChildSign$1(Ref.ObjectRef<Long> r100, Ref.ObjectRef<SnapshotInstance> r101) {
        this.$reusedSign = r100;
        this.$recycledCtx = r101;
        super(2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.Long] */
    public final void invoke(SnapshotInstance r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Ref.ObjectRef<Long> r102 = this.$reusedSign;
        if (r102.element != null) goto L6;
        r102.element = Long.valueOf(r101);
        this.$recycledCtx.element = r100;
        return;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(SnapshotInstance r100, Long r101) {
        invoke(r100, r101.longValue());
        return Unit.INSTANCE;
    }
}
