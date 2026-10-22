package com.bytedance.jedi.ext.adapter.decorator;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.jedi.arch.IReceiver;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\f\u001a\u00020\t\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0002\u0010\u0004*\u00020\u0003\" \b\u0003\u0010\u0006*\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005*\u00028\u00022\u0006\u0010\b\u001a\u00020\u0007H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/jedi/ext/adapter/decorator/JediAdapterDecorator;", "DEC", "Lcom/bytedance/jedi/arch/IReceiver;", "RECEIVER", "Lcom/bytedance/jedi/ext/adapter/decorator/a;", "SELF", "", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/jedi/arch/IReceiver;Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class Decoration$onEmpty$1 extends Lambda implements Function2<IReceiver, Boolean, Unit> {
    public static final Decoration$onEmpty$1 INSTANCE = null;

    static {
        INSTANCE = new Decoration$onEmpty$1();
    }

    public Decoration$onEmpty$1() {
        super(2);
    }

    public final void invoke(IReceiver r100, boolean r101) {
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(IReceiver r100, Boolean r101) {
        invoke(r100, r101.booleanValue());
        return Unit.INSTANCE;
    }
}
