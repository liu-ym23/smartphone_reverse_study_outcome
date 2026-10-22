package com.bytedance.jedi.arch.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004\"\b\b\u0002\u0010\u0005*\u00020\u00042\u000e\u0010\u0006\u001a\n \u0007*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "R", "PROP", "Lcom/bytedance/jedi/arch/State;", ExifInterface.LATITUDE_SOUTH, "it", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 7, 1}, xi = 176)
public final class SubscriptioinExtensionsKt$middlewareSelectSubscribeMapped$2$1<R> extends Lambda implements Function1<R, Unit> {
    final /* synthetic */ Function1<R, Unit> $subscriber;

    /* JADX WARN: Multi-variable type inference failed */
    public SubscriptioinExtensionsKt$middlewareSelectSubscribeMapped$2$1(Function1<? super R, Unit> r100) {
        this.$subscriber = r100;
        super(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(R r100) {
        this.$subscriber.invoke(r100);
    }
}
