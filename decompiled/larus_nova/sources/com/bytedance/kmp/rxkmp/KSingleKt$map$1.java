package com.bytedance.kmp.rxkmp;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u0001H\u0001H\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004\"\b\b\u0001\u0010\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "R", "kotlin.jvm.PlatformType", ExifInterface.GPS_DIRECTION_TRUE, "", "it", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 0}, xi = 176)
public final class KSingleKt$map$1 extends Lambda implements Function1<Object, Object> {
    final /* synthetic */ Function1<Object, Object> $mapper;

    public KSingleKt$map$1(Function1<Object, Object> r100) {
        this.$mapper = r100;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return this.$mapper.invoke(r100);
    }
}
