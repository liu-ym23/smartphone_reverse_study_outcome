package com.github.alexzhirkevich.customqrgenerator;

import android.graphics.Bitmap;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "xrange", "Lkotlin/ranges/IntRange;", "yrange", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class QrCodeGeneratorImpl$drawCode$2$1$1 extends Lambda implements Function2<IntRange, IntRange, Unit> {
    final /* synthetic */ CoroutineScope $$this$coroutineScope;
    final /* synthetic */ int[] $array;
    final /* synthetic */ int[] $bgBitmapPixels;
    final /* synthetic */ boolean $drawBg;
    final /* synthetic */ int $offsetX;
    final /* synthetic */ int $offsetY;
    final /* synthetic */ e $options;
    final /* synthetic */ Bitmap $this_drawCode;
    final /* synthetic */ com.github.alexzhirkevich.customqrgenerator.encoder.d $this_with;
    final /* synthetic */ b this$0;

    public QrCodeGeneratorImpl$drawCode$2$1$1(boolean r100, e r101, Bitmap r102, int[] r103, int[] r104, CoroutineScope r105, com.github.alexzhirkevich.customqrgenerator.encoder.d r106, int r107, int r108, b r110) {
        this.$drawBg = r100;
        this.$options = r101;
        this.$this_drawCode = r102;
        this.$bgBitmapPixels = r103;
        this.$array = r104;
        this.$$this$coroutineScope = r105;
        this.$this_with = r106;
        this.$offsetX = r107;
        this.$offsetY = r108;
        this.this$0 = r110;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(IntRange r100, IntRange r110) {
        Intrinsics.checkNotNullParameter(r100, "xrange");
        Intrinsics.checkNotNullParameter(r110, "yrange");
        if (this.$drawBg == false) goto L12;
        int r101 = r100.getFirst();
        int r102 = r100.getLast();
        if (r101 > r102) goto L12;
    L7:
        if (r110.getFirst() <= r110.getLast()) goto L10;
        if (r101 == r102) goto L12;
        r101 = r101 + 1;
        goto L7
    L10:
        this.$options.getClass();
        throw null;
    L12:
        int r103 = r100.getFirst();
        int r104 = r100.getLast();
        if (r103 > r104) goto L34;
    L14:
        int r105 = r110.getFirst();
        int r106 = r110.getLast();
        if (r105 > r106) goto L32;
    L16:
        CoroutineScopeKt.ensureActive(this.$$this$coroutineScope);
        this.$this_with.getClass();
        int r107 = this.$this_drawCode.getWidth();
        this.$this_with.getClass();
        boolean r108 = false;
        if (r103 >= ((r107 - 0) - 0)) goto L20;
        if (r103 < 0) goto L20;
        boolean r109 = true;
    L21:
        if (r109 == false) goto L30;
        int r111 = this.$this_drawCode.getHeight();
        this.$this_with.getClass();
        if (r105 >= ((r111 - 0) - 0)) goto L26;
        if (r105 < 0) goto L26;
        r108 = true;
    L26:
        if (r108 == false) goto L30;
        this.$options.getClass();
        throw null;
    L30:
        if (r105 == r106) goto L32;
        r105 = r105 + 1;
    L20:
        r109 = false;
    L32:
        if (r103 == r104) goto L40;
        r103 = r103 + 1;
        goto L14
    L40:
        return;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(IntRange r100, IntRange r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
