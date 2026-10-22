package com.bytedance.assem.arch.viewModel;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0011\u001a\u00020\u000e\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0004\b\u0003\u0010\u0004\"\u0004\b\u0004\u0010\u0005\"\u0004\b\u0005\u0010\u0006\"\b\b\u0006\u0010\b*\u00020\u00072\u0006\u0010\t\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u00022\u0006\u0010\u000b\u001a\u00028\u00032\u0006\u0010\f\u001a\u00028\u00042\u0006\u0010\r\u001a\u00028\u0005H\n¢\u0006\u0004\b\u000f\u0010\u0010"}, d2 = {"Lcom/bytedance/assem/arch/viewModel/h;", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "Lcom/bytedance/tiktok/proxy/a;", "RECEIVER", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "e", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class IConfigurableVMSubscriber$selectSubscribe$10 extends Lambda implements Function5<Object, Object, Object, Object, Object, Unit> {
    final /* synthetic */ Function6 $subscriber;
    final /* synthetic */ e this$0;

    public IConfigurableVMSubscriber$selectSubscribe$10(e r100, Function6 r101) {
        this.this$0 = r100;
        this.$subscriber = r101;
        super(5);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object r100, Object r110, Object r111, Object r112, Object r113) {
        com.bytedance.tiktok.proxy.a r101 = this.this$0.dh();
        if (r101 != null) goto L6;
        r101 = this.this$0.pF().oq();
    L6:
        com.bytedance.tiktok.proxy.a r102 = r101;
        if (r102 == null) goto L10;
        Unit r103 = (Unit) this.$subscriber.invoke(r102, r100, r110, r111, r112, r113);
        return;
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ Unit invoke(Object r100, Object r101, Object r102, Object r103, Object r104) {
        invoke2(r100, r101, r102, r103, r104);
        return Unit.INSTANCE;
    }
}
