package com.bytedance.ies.sve_core;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/bytedance/ies/sve_core/s;", ExifInterface.LATITUDE_SOUTH, "Lcom/bytedance/ies/sve_core/a;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/ies/sve_core/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class BaseKt$bindReducerState$dispatch$2 extends Lambda implements Function1<a, Unit> {
    final /* synthetic */ u $name;
    final /* synthetic */ Store $store;

    public BaseKt$bindReducerState$dispatch$2(Store r100, u r101) {
        this.$store = r100;
        this.$name = r101;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(a r100) {
        this.$store.dispatch(this.$name, r100);
    }
}
