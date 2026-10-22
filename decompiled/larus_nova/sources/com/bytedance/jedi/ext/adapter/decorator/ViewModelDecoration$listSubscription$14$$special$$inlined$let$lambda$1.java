package com.bytedance.jedi.ext.adapter.decorator;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.jedi.arch.IReceiver;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\b\b\u0002\u0010\u0005*\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "DEC", "Lcom/bytedance/jedi/ext/adapter/decorator/JediAdapterDecorator;", "RECEIVER", "Lcom/bytedance/jedi/arch/IReceiver;", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/jedi/ext/adapter/decorator/ViewModelDecoration$listSubscription$14$1$1"}, k = 3, mv = {1, 1, 16})
public final class ViewModelDecoration$listSubscription$14$$special$$inlined$let$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1 $it;
    final /* synthetic */ IReceiver $this_selectSubscribe$inlined;

    public ViewModelDecoration$listSubscription$14$$special$$inlined$let$lambda$1(Function1 r100, IReceiver r101) {
        this.$it = r100;
        this.$this_selectSubscribe$inlined = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$it.invoke(this.$this_selectSubscribe$inlined);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
