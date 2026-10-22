package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001j\u0002`\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001j\u0002`\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<no name provided>", "", "", "Lcom/relax/relaxframework/SwiperCbTuple;", "value", AbsMethodDelegate.TAG_INVOKE, "([Ljava/lang/Object;)[Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class RxSwiperImpl$swipeTo$1 extends Lambda implements Function1<Object[], Object[]> {
    final /* synthetic */ SwiperToOptions $options;

    public RxSwiperImpl$swipeTo$1(SwiperToOptions r100) {
        this.$options = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object[] invoke2(Object[] r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        SwiperToOptions r101 = this.$options;
        if (r101 == null) goto L7;
        Function0<Unit> r102 = r101.getOnFinish();
        if (r102 == null) goto L7;
        r102.invoke();
    L7:
        return r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object[] invoke(Object[] r100) {
        return invoke2(r100);
    }
}
