package com.bytedance.component.lyric_v2.painter;

import android.graphics.Paint;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "Landroid/graphics/Paint;", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class CacheManager$clearPaintCaches$1 extends Lambda implements Function1<Pair<? extends Paint, ? extends String>, Boolean> {
    final /* synthetic */ Paint $paint;

    public CacheManager$clearPaintCaches$1(Paint r100) {
        this.$paint = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Pair<? extends Paint, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        if (r100.getFirst() != this.$paint) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Pair<? extends Paint, ? extends String> r100) {
        return Boolean.valueOf(invoke2(r100));
    }
}
