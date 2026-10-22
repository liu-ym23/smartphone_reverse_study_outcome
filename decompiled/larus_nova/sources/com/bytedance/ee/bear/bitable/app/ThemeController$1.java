package com.bytedance.ee.bear.bitable.app;

import androidx.core.graphics.ColorKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ThemeController$1 extends FunctionReferenceImpl implements Function1<String, Integer> {
    public static final ThemeController$1 INSTANCE = null;

    static {
        INSTANCE = new ThemeController$1();
    }

    public ThemeController$1() {
        super(1, ColorKt.class, "toColorInt", "toColorInt(Ljava/lang/String;)I", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Integer invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return Integer.valueOf(ColorProtector.parseColor(r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(String r100) {
        return invoke2(r100);
    }
}
