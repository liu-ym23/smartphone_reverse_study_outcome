package com.bytedance.ee.bear.drive.core.thumbnail;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DriveThumbnailImageProvider$load$loadRemoteSource$2 extends FunctionReferenceImpl implements Function1<i, Unit> {
    final /* synthetic */ Function1<i, Unit> $callback;
    final /* synthetic */ AtomicBoolean $loadDisposed;
    final /* synthetic */ DriveThumbnailImageProvider this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public DriveThumbnailImageProvider$load$loadRemoteSource$2(DriveThumbnailImageProvider r7, AtomicBoolean r8, Function1<? super i, Unit> r9) {
        this.this$0 = r7;
        this.$loadDisposed = r8;
        this.$callback = r9;
        super(1, Intrinsics.Kotlin.class, "dispatchSource", "load$dispatchSource(Lcom/bytedance/ee/bear/drive/core/thumbnail/DriveThumbnailImageProvider;Ljava/util/concurrent/atomic/AtomicBoolean;Lkotlin/jvm/functions/Function1;Lcom/bytedance/ee/bear/drive/core/thumbnail/DriveThumbnailImageSource;)V", 0);
    }

    public final void invoke(i r4) {
        DriveThumbnailImageProvider.a(this.this$0, this.$loadDisposed, this.$callback, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((i) r1);
        return Unit.INSTANCE;
    }
}
