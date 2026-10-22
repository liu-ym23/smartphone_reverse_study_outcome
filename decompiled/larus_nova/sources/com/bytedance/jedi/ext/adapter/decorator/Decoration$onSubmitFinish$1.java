package com.bytedance.jedi.ext.adapter.decorator;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.jedi.arch.IReceiver;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0002\u0010\u0004*\u00020\u0003\" \b\u0003\u0010\u0006*\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005*\u00028\u0002H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/jedi/ext/adapter/decorator/JediAdapterDecorator;", "DEC", "Lcom/bytedance/jedi/arch/IReceiver;", "RECEIVER", "Lcom/bytedance/jedi/ext/adapter/decorator/a;", "SELF", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/jedi/arch/IReceiver;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class Decoration$onSubmitFinish$1 extends Lambda implements Function1<IReceiver, Unit> {
    public static final Decoration$onSubmitFinish$1 INSTANCE = null;

    static {
        INSTANCE = new Decoration$onSubmitFinish$1();
    }

    public Decoration$onSubmitFinish$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(IReceiver r100) {
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(IReceiver r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
