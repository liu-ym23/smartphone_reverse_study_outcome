package com.ss.android.lark.coremd.ext;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "it", "Lcom/ss/android/lark/coremd/ext/Extendable;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/ss/android/lark/coremd/ext/Extendable;)Ljava/lang/Object;"}, k = 3, mv = {2, 1, 0}, xi = 176)
public final class ExtendKt$extend$1 extends Lambda implements Function1<j, Object> {
    final /* synthetic */ Object $constDefault;

    public ExtendKt$extend$1(Object r100) {
        this.$constDefault = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(j r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return this.$constDefault;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(j r100) {
        return invoke2(r100);
    }
}
