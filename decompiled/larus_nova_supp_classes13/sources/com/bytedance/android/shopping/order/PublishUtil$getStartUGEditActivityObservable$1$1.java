package com.bytedance.android.shopping.order;

import io.reactivex.ObservableEmitter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "editModel", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class PublishUtil$getStartUGEditActivityObservable$1$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ ObservableEmitter $emitter;

    public PublishUtil$getStartUGEditActivityObservable$1$1(ObservableEmitter r1) {
        this.$emitter = r1;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1841invoke(Object r3) {
        if (this.$emitter.isDisposed() == true) goto L8;
        if (r3 == null) goto L6;
        this.$emitter.onNext(r3);
        this.$emitter.onComplete();
        return;
    L6:
        this.$emitter.onError(new Throwable("UGPublishEditModel为空"));
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        m1841invoke(r1);
        return Unit.INSTANCE;
    }
}
