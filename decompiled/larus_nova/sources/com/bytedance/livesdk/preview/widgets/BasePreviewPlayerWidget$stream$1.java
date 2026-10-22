package com.bytedance.livesdk.preview.widgets;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/lifecycle/LifecycleOwner;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class BasePreviewPlayerWidget$stream$1 extends Lambda implements Function1<LifecycleOwner, Unit> {
    final /* synthetic */ BasePreviewPlayerWidget this$0;

    public BasePreviewPlayerWidget$stream$1(BasePreviewPlayerWidget r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.this$0.getClass();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(LifecycleOwner r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
