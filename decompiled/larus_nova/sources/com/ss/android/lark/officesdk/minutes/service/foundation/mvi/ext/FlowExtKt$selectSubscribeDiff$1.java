package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class FlowExtKt$selectSubscribeDiff$1 extends Lambda implements Function2 {
    public static final FlowExtKt$selectSubscribeDiff$1 INSTANCE = null;

    static {
        INSTANCE = new FlowExtKt$selectSubscribeDiff$1();
    }

    public FlowExtKt$selectSubscribeDiff$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Boolean invoke(Object r100, Object r101) {
        return Boolean.valueOf(Intrinsics.areEqual(r100, r101));
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101) {
        return invoke(r100, r101);
    }
}
