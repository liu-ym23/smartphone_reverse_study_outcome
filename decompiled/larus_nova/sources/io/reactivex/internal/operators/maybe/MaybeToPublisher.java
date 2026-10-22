package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes41.dex */
public final enum MaybeToPublisher extends Enum<MaybeToPublisher> implements Function<MaybeSource<Object>, Publisher<Object>> {
    public static final MaybeToPublisher INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MaybeToPublisher[] f493807a = null;

    static {
        MaybeToPublisher r100 = new MaybeToPublisher();
        INSTANCE = r100;
        f493807a = new MaybeToPublisher[]{r100};
    }

    public MaybeToPublisher() {
        super("INSTANCE", 0);
    }

    public static MaybeToPublisher[] values() {
        return (MaybeToPublisher[]) f493807a.clone();
    }

    public static <T> Function<MaybeSource<T>, Publisher<T>> instance() {
        return INSTANCE;
    }

    public static MaybeToPublisher valueOf(String r100) {
        return (MaybeToPublisher) r27.a.a(MaybeToPublisher.class, r100);
    }

    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ Publisher<Object> apply(MaybeSource<Object> r100) throws Exception {
        return apply2(r100);
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public Publisher<Object> apply2(MaybeSource<Object> r100) throws Exception {
        return new MaybeToFlowable(r100);
    }
}
