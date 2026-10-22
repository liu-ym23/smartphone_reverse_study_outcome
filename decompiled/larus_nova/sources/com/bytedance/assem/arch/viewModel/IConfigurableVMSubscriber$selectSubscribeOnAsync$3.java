package com.bytedance.assem.arch.viewModel;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\b\b\u0002\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/bytedance/assem/arch/viewModel/h;", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/bytedance/tiktok/proxy/a;", "RECEIVER", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class IConfigurableVMSubscriber$selectSubscribeOnAsync$3 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ Function2 $subscriber;
    final /* synthetic */ e this$0;

    public IConfigurableVMSubscriber$selectSubscribeOnAsync$3(e r100, Function2 r101) {
        this.this$0 = r100;
        this.$subscriber = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object r100) {
        com.bytedance.tiktok.proxy.a r101 = this.this$0.dh();
        if (r101 != null) goto L6;
        r101 = this.this$0.pF().oq();
    L6:
        if (r101 == null) goto L9;
        Unit r102 = (Unit) this.$subscriber.invoke(r101, r100);
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
