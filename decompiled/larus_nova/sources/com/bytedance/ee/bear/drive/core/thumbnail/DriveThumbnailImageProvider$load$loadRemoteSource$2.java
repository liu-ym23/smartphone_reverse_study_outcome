package com.bytedance.ee.bear.drive.core.thumbnail;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DriveThumbnailImageProvider$load$loadRemoteSource$2 extends FunctionReferenceImpl implements Function1<i, Unit> {
    final /* synthetic */ Function1<i, Unit> $callback;
    final /* synthetic */ AtomicBoolean $loadDisposed;
    final /* synthetic */ DriveThumbnailImageProvider this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public DriveThumbnailImageProvider$load$loadRemoteSource$2(DriveThumbnailImageProvider r100, AtomicBoolean r101, Function1<? super i, Unit> r102) {
        this.this$0 = r100;
        this.$loadDisposed = r101;
        this.$callback = r102;
        super(1, Intrinsics.Kotlin.class, "dispatchSource", "load$dispatchSource(Lcom/bytedance/ee/bear/drive/core/thumbnail/DriveThumbnailImageProvider;Ljava/util/concurrent/atomic/AtomicBoolean;Lkotlin/jvm/functions/Function1;Lcom/bytedance/ee/bear/drive/core/thumbnail/DriveThumbnailImageSource;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(i r100) {
        DriveThumbnailImageProvider.a(this.this$0, this.$loadDisposed, this.$callback, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(i r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
