package com.bytedance.assem.arch.viewModel;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0004\b\u0003\u0010\u0004\"\b\b\u0004\u0010\u0006*\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u00012\u0006\u0010\b\u001a\u00028\u00022\u0006\u0010\t\u001a\u00028\u0003H\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/bytedance/assem/arch/viewModel/h;", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "Lcom/bytedance/tiktok/proxy/a;", "RECEIVER", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class IConfigurableVMSubscriber$selectSubscribe$6 extends Lambda implements Function3<Object, Object, Object, Unit> {
    final /* synthetic */ Function4 $subscriber;
    final /* synthetic */ e this$0;

    public IConfigurableVMSubscriber$selectSubscribe$6(e r100, Function4 r101) {
        this.this$0 = r100;
        this.$subscriber = r101;
        super(3);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object r100, Object r101, Object r102) {
        com.bytedance.tiktok.proxy.a r103 = this.this$0.dh();
        if (r103 != null) goto L6;
        r103 = this.this$0.pF().oq();
    L6:
        if (r103 == null) goto L9;
        Unit r104 = (Unit) this.$subscriber.invoke(r103, r100, r101, r102);
        return;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Object r100, Object r101, Object r102) {
        invoke2(r100, r101, r102);
        return Unit.INSTANCE;
    }
}
