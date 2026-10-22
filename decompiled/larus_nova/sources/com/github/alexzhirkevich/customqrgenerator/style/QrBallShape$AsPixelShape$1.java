package com.github.alexzhirkevich.customqrgenerator.style;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "size", "Lcom/github/alexzhirkevich/customqrgenerator/style/c;", "<anonymous parameter 1>", AbsMethodDelegate.TAG_INVOKE, "(ILcom/github/alexzhirkevich/customqrgenerator/style/c;)Ljava/lang/Integer;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class QrBallShape$AsPixelShape$1 extends Lambda implements Function2<Integer, c, Integer> {
    public static final QrBallShape$AsPixelShape$1 INSTANCE = null;

    static {
        INSTANCE = new QrBallShape$AsPixelShape$1();
    }

    public QrBallShape$AsPixelShape$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Integer invoke(Integer r100, c r101) {
        return invoke(r100.intValue(), r101);
    }

    public final Integer invoke(int r100, c r101) {
        Intrinsics.checkNotNullParameter(r101, "<anonymous parameter 1>");
        return Integer.valueOf(r100 / 3);
    }
}
