package com.bytedance.salamander.anniex;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005j\u0002`\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<no name provided>", "", "eventName", "", "params", "", "Lcom/bytedance/salamander/adapter/JsonObject;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class EventEmitterNative$createEventCallback$1 extends Lambda implements Function2<String, Map<String, ? extends Object>, Object> {
    final /* synthetic */ Function2<String, Map<String, ? extends Object>, Unit> $onRealCallBack;

    /* JADX WARN: Multi-variable type inference failed */
    public EventEmitterNative$createEventCallback$1(Function2<? super String, ? super Map<String, ? extends Object>, Unit> r100) {
        this.$onRealCallBack = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.$onRealCallBack.invoke(r100, r101);
        return 1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(String r100, Map<String, ? extends Object> r101) {
        return invoke2(r100, r101);
    }
}
