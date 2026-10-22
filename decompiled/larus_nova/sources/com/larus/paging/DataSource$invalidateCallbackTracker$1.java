package com.larus.paging;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Key", "Value", "Lcom/larus/paging/DataSource$d;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/larus/paging/DataSource$d;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class DataSource$invalidateCallbackTracker$1 extends Lambda implements Function1<DataSource.d, Unit> {
    public static final DataSource$invalidateCallbackTracker$1 INSTANCE = null;

    static {
        INSTANCE = new DataSource$invalidateCallbackTracker$1();
    }

    public DataSource$invalidateCallbackTracker$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DataSource.d r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        r100.onInvalidated();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DataSource.d r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
