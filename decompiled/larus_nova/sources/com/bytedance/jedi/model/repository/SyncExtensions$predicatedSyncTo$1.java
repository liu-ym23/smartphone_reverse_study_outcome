package com.bytedance.jedi.model.repository;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import com.bytedance.jedi.model.merge.MergeStrategy;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005*\u001a\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "K", "V", "K1", OuterPayLoginWrapper.LOGIN_STYLE_V1, "Lcom/bytedance/jedi/model/merge/MergeStrategy$PredicatedMerge;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class SyncExtensions$predicatedSyncTo$1 extends Lambda implements Function1 {
    public static final SyncExtensions$predicatedSyncTo$1 INSTANCE = null;

    static {
        INSTANCE = new SyncExtensions$predicatedSyncTo$1();
    }

    public SyncExtensions$predicatedSyncTo$1() {
        super(1);
    }

    public final void invoke(MergeStrategy.PredicatedMerge r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$null");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r100) {
        invoke((MergeStrategy.PredicatedMerge) r100);
        return Unit.INSTANCE;
    }
}
