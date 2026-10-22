package com.bytedance.assem.arch.viewModel;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\b\b\u0002\u0010\u0004*\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/bytedance/assem/arch/viewModel/h;", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/tiktok/proxy/a;", "RECEIVER", "Lcom/bytedance/assem/arch/extensions/c;", "async", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/assem/arch/extensions/c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class IConfigurableVMSubscriber$asyncSubscribe$2 extends Lambda implements Function1<com.bytedance.assem.arch.extensions.c<Object>, Unit> {
    final /* synthetic */ Function2 $onError;
    final /* synthetic */ Function1 $onLoading;
    final /* synthetic */ Function2 $onSuccess;
    final /* synthetic */ e this$0;

    public IConfigurableVMSubscriber$asyncSubscribe$2(e r100, Function1 r101, Function2 r102, Function2 r103) {
        this.this$0 = r100;
        this.$onLoading = r101;
        this.$onError = r102;
        this.$onSuccess = r103;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.assem.arch.extensions.c<Object> r100) {
        com.bytedance.tiktok.proxy.a r101 = this.this$0.dh();
        if (r101 != null) goto L6;
        r101 = this.this$0.pF().oq();
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        if ((r100 instanceof com.bytedance.assem.arch.extensions.h) == false) goto L13;
        Function1 r102 = this.$onLoading;
        if (r102 == null) goto L24;
        r102.invoke(r101);
        return;
    L24:
        return;
    L13:
        if ((r100 instanceof com.bytedance.assem.arch.extensions.e) == false) goto L18;
        Function2 r103 = this.$onError;
        if (r103 == null) goto L26;
        r103.invoke(r101, ((com.bytedance.assem.arch.extensions.e) r100).f192925a);
        return;
    L26:
        return;
    L18:
        if ((r100 instanceof com.bytedance.assem.arch.extensions.i) == false) goto L28;
        Function2 r104 = this.$onSuccess;
        if (r104 == null) goto L29;
        r104.invoke(r101, ((com.bytedance.assem.arch.extensions.i) r100).f192929a);
        return;
    L29:
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.assem.arch.extensions.c<Object> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
