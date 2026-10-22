package com.ss.android.ugc.aweme.discover.commodity.utils;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", ExifInterface.GPS_DIRECTION_TRUE, "it", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/String;)Ljava/lang/Integer;"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class DataFilter$Companion$IntTransform$1 extends Lambda implements Function1<String, Integer> {
    public static final DataFilter$Companion$IntTransform$1 INSTANCE = null;

    static {
        INSTANCE = new DataFilter$Companion$IntTransform$1();
    }

    public DataFilter$Companion$IntTransform$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Integer invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return CastIntegerProtector.valueOf(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(String r100) {
        return invoke2(r100);
    }
}
