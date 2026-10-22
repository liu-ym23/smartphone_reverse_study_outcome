package com.bytedance.revenue.platform.api.core.rx;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u0001H\u0001H\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004\"\b\b\u0001\u0010\u0001*\u00020\u00042*\u0010\u0005\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00040\u0004 \u0002*\u0012\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00040\u00040\u00060\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "R", "kotlin.jvm.PlatformType", ExifInterface.GPS_DIRECTION_TRUE, "", "array", "", AbsMethodDelegate.TAG_INVOKE, "([Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 176)
public final class Singles$zip$1 extends Lambda implements Function1<Object[], Object> {
    final /* synthetic */ Function1<List<Object>, Object> $mapper;

    /* JADX WARN: Multi-variable type inference failed */
    public Singles$zip$1(Function1<? super List<Object>, Object> r100) {
        this.$mapper = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Object[] r100) {
        Intrinsics.checkNotNullParameter(r100, "array");
        return this.$mapper.invoke(ArraysKt.toList(r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object[] r100) {
        return invoke2(r100);
    }
}
