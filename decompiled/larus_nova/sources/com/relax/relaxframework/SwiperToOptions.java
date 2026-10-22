package com.relax.relaxframework;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007¢\u0006\u0002\u0010\bR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/relax/relaxframework/SwiperToOptions;", "", "animate", "", "onFinish", "Lkotlin/Function0;", "", "Lcom/relax/relaxframework/SwiperAnimateFinishCallback;", "(Ljava/lang/Boolean;Lkotlin/jvm/functions/Function0;)V", "getAnimate", "()Ljava/lang/Boolean;", "setAnimate", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getOnFinish", "()Lkotlin/jvm/functions/Function0;", "setOnFinish", "(Lkotlin/jvm/functions/Function0;)V", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SwiperToOptions {
    private Boolean animate;
    private Function0<Unit> onFinish;

    /* JADX WARN: Multi-variable type inference failed */
    public SwiperToOptions() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final Boolean getAnimate() {
        return this.animate;
    }

    public final Function0<Unit> getOnFinish() {
        return this.onFinish;
    }

    public final void setAnimate(Boolean r100) {
        this.animate = r100;
    }

    public final void setOnFinish(Function0<Unit> r100) {
        this.onFinish = r100;
    }

    public SwiperToOptions(Boolean r100, Function0<Unit> r101) {
        this.animate = r100;
        this.onFinish = r101;
    }

    public /* synthetic */ SwiperToOptions(Boolean r100, Function0 r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
