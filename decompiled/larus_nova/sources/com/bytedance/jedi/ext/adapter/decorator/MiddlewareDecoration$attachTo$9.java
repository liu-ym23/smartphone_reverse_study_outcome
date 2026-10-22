package com.bytedance.jedi.ext.adapter.decorator;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.jedi.arch.IReceiver;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\b\b\u0002\u0010\u0005*\u00020\u0006*\u0002H\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "DEC", "Lcom/bytedance/jedi/ext/adapter/decorator/JediAdapterDecorator;", "RECEIVER", "Lcom/bytedance/jedi/arch/IReceiver;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/jedi/arch/IReceiver;Ljava/util/List;)V"}, k = 3, mv = {1, 1, 16})
final class MiddlewareDecoration$attachTo$9 extends Lambda implements Function2<IReceiver, List<Object>, Unit> {
    final /* synthetic */ d this$0;

    public MiddlewareDecoration$attachTo$9(d r100) {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(IReceiver r100, List<Object> r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(IReceiver r100, List<Object> r101) {
        throw null;
    }
}
