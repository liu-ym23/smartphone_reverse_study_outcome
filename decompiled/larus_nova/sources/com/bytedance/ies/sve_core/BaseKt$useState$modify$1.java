package com.bytedance.ies.sve_core;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/ies/sve_core/s;", ExifInterface.LATITUDE_SOUTH, "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/ies/sve_core/s;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class BaseKt$useState$modify$1 extends Lambda implements Function1<s, Unit> {
    final /* synthetic */ u $name;
    final /* synthetic */ Store $store;

    public BaseKt$useState$modify$1(Store r100, u r101) {
        this.$store = r100;
        this.$name = r101;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(s r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(s r100) {
        this.$store.dispatch(this.$name, new n(r100));
    }
}
