package com.bytedance.salamander.anniex;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", WsConstants.KEY_PAYLOAD, "", "", "", "Lcom/bytedance/salamander/anniex/CommonJsonObject;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class EventEmitter$createEventCallback$1 extends Lambda implements Function1<Map<String, ? extends Object>, Unit> {
    final /* synthetic */ Function2<String, Map<String, ? extends Object>, Unit> $callback;

    /* JADX WARN: Multi-variable type inference failed */
    public EventEmitter$createEventCallback$1(Function2<? super String, ? super Map<String, ? extends Object>, Unit> r100) {
        this.$callback = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        this.$callback.invoke("", r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends Object> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
