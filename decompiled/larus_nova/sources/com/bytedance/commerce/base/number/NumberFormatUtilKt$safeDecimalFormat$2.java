package com.bytedance.commerce.base.number;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/text/DecimalFormat;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class NumberFormatUtilKt$safeDecimalFormat$2 extends Lambda implements Function0<DecimalFormat> {
    public static final NumberFormatUtilKt$safeDecimalFormat$2 INSTANCE = null;

    static {
        INSTANCE = new NumberFormatUtilKt$safeDecimalFormat$2();
    }

    public NumberFormatUtilKt$safeDecimalFormat$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ DecimalFormat invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final DecimalFormat invoke2() {
        NumberFormat r100 = NumberFormat.getInstance();
        if (r100 == null) goto L7;
        return (DecimalFormat) r100;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type java.text.DecimalFormat");
    }
}
