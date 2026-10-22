package com.larus.paging;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/larus/paging/d1;", "stash", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/larus/paging/d1;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class SeparatorState$onDrop$1 extends Lambda implements Function1<d1<Object>, Boolean> {
    final /* synthetic */ IntRange $pageOffsetsToDrop;

    public SeparatorState$onDrop$1(IntRange r100) {
        this.$pageOffsetsToDrop = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(d1<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "stash");
        int[] r101 = r100.f363802a;
        IntRange r102 = this.$pageOffsetsToDrop;
        int r103 = r101.length;
        boolean r104 = false;
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L9;
        if (r102.contains(r101[r105]) == true) goto L6;
        r105 = r105 + 1;
        goto L3
    L6:
        r104 = true;
    L9:
        return Boolean.valueOf(r104);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(d1<Object> r100) {
        return invoke2(r100);
    }
}
