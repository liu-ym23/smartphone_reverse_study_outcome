package com.bytedance.jedi.ext.adapter.decorator;

import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u000b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0002\u0010\u0004*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LLcom/bytedance/jedi/ext/adapter/decorator/JediAdapterDecorator;;", "DEC", "Lcom/bytedance/jedi/arch/IReceiver;", "RECEIVER", "Landroid/view/ViewGroup;", "it", "Lcom/bytedance/jedi/ext/adapter/decorator/b;", AbsMethodDelegate.TAG_INVOKE, "(Landroid/view/ViewGroup;)Lcom/bytedance/jedi/ext/adapter/decorator/b;", "om/bytedance/jedi/ext/adapter/decorator/MiddlewareDecoration.attachTo.10.", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class MiddlewareDecoration$attachTo$$inlined$apply$lambda$2 extends Lambda implements Function1<ViewGroup, b> {
    final /* synthetic */ d this$0;

    /* JADX INFO: renamed from: com.bytedance.jedi.ext.adapter.decorator.MiddlewareDecoration$attachTo$$inlined$apply$lambda$2$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\b\b\u0002\u0010\u0005*\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "DEC", "Lcom/bytedance/jedi/ext/adapter/decorator/JediAdapterDecorator;", "RECEIVER", "Lcom/bytedance/jedi/arch/IReceiver;", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/jedi/ext/adapter/decorator/MiddlewareDecoration$attachTo$10$3$1"}, k = 3, mv = {1, 1, 16})
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        final /* synthetic */ MiddlewareDecoration$attachTo$$inlined$apply$lambda$2 this$0;

        public AnonymousClass1(MiddlewareDecoration$attachTo$$inlined$apply$lambda$2 r100) {
            this.this$0 = r100;
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.this$0.getClass();
            throw null;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    public MiddlewareDecoration$attachTo$$inlined$apply$lambda$2(d r100) {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ b invoke(ViewGroup r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final b invoke2(ViewGroup r100) {
        throw null;
    }
}
