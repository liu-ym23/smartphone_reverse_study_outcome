package com.bytedance.android.shopping.widget.ecvideoplayer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECVideoPlayer$dispatchVideoStatus$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ b $ecVideoListener;
    final /* synthetic */ ECVideoPlayer this$0;

    public ECVideoPlayer$dispatchVideoStatus$1(ECVideoPlayer r1, b r2) {
        this.this$0 = r1;
        this.$ecVideoListener = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m491invoke() {
        int r0 = this.this$0.g.d;
        if (r0 == (-1)) goto L22;
        if (r0 != 0) goto L6;
        this.$ecVideoListener.onIdle();
        return;
    L6:
        if (r0 != 3) goto L8;
        this.$ecVideoListener.onPlaying();
        return;
    L8:
        if (r0 != 4) goto L10;
        this.$ecVideoListener.onPaused();
        return;
    L10:
        if (r0 != 6) goto L12;
        this.$ecVideoListener.onRelease();
        return;
    L12:
        if (r0 != 7) goto L14;
        this.$ecVideoListener.E();
        return;
    L14:
        if (r0 != 8) goto L30;
        this.$ecVideoListener.w();
        return;
    L30:
        return;
    L22:
        this.$ecVideoListener.onError(this.this$0.l);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m491invoke();
        return Unit.INSTANCE;
    }
}
