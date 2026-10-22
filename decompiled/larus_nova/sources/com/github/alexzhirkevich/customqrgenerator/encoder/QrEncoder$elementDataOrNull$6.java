package com.github.alexzhirkevich.customqrgenerator.encoder;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "it", AbsMethodDelegate.TAG_INVOKE, "(I)Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class QrEncoder$elementDataOrNull$6 extends Lambda implements Function1<Integer, Integer> {
    final /* synthetic */ int $diff;
    final /* synthetic */ int $inputY;
    final /* synthetic */ int $multiple;

    public QrEncoder$elementDataOrNull$6(int r100, int r101, int r102) {
        this.$inputY = r100;
        this.$diff = r101;
        this.$multiple = r102;
        super(1);
    }

    public final Integer invoke(int r100) {
        return Integer.valueOf((((this.$inputY - 2) - this.$diff) * this.$multiple) + r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(Integer r100) {
        return invoke(r100.intValue());
    }
}
