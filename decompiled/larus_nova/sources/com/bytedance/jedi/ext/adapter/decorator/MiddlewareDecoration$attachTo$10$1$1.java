package com.bytedance.jedi.ext.adapter.decorator;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.jedi.arch.ext.list.ListMiddleware;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\b\b\u0002\u0010\u0005*\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "DEC", "Lcom/bytedance/jedi/ext/adapter/decorator/JediAdapterDecorator;", "RECEIVER", "Lcom/bytedance/jedi/arch/IReceiver;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class MiddlewareDecoration$attachTo$10$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ListMiddleware $it;

    public MiddlewareDecoration$attachTo$10$1$1(ListMiddleware r100) {
        this.$it = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$it.loadMore();
    }
}
