package com.obric.assistant.interaction.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"KeyguardState", "Lcom/obric/assistant/interaction/api/IKeyguardState;", "getKeyguardState", "()Lcom/obric/assistant/interaction/api/IKeyguardState;", "KeyguardState$delegate", "Lkotlin/Lazy;", "api_mainlandRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class IKeyguardStateKt {
    private static final Lazy KeyguardState$delegate = null;

    public static /* synthetic */ IKeyguardState a() {
        return KeyguardState_delegate$lambda$0();
    }

    static {
        KeyguardState$delegate = LazyKt.lazy(new c());
    }

    private static final IKeyguardState KeyguardState_delegate$lambda$0() {
        Object r100 = ServiceManager.get().getService(IKeyguardState.class);
        Intrinsics.checkNotNull(r100);
        return (IKeyguardState) r100;
    }

    public static final IKeyguardState getKeyguardState() {
        return (IKeyguardState) KeyguardState$delegate.getValue();
    }
}
