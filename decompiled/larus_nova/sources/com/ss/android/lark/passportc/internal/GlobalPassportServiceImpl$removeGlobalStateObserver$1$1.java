package com.ss.android.lark.passportc.internal;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u00070\u0003H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "it", "Ljava/lang/ref/WeakReference;", "Lkotlin/Function1;", "Lcom/ss/android/lark/passportc/entity/GlobalState;", "", "Lcom/ss/android/lark/passportc/api/IGlobalStateObserver;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/ref/WeakReference;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class GlobalPassportServiceImpl$removeGlobalStateObserver$1$1 extends Lambda implements Function1<WeakReference<Function1<? super f0c.b, ? extends Unit>>, Boolean> {
    final /* synthetic */ Function1<f0c.b, Unit> $observer;

    /* JADX WARN: Multi-variable type inference failed */
    public GlobalPassportServiceImpl$removeGlobalStateObserver$1$1(Function1<? super f0c.b, Unit> r100) {
        this.$observer = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(WeakReference<Function1<f0c.b, Unit>> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return Boolean.valueOf(Intrinsics.areEqual(r100.get(), this.$observer));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(WeakReference<Function1<? super f0c.b, ? extends Unit>> r100) {
        return invoke2(r100);
    }
}
