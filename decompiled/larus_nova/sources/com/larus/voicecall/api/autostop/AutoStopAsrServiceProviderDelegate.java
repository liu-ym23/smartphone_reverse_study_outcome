package com.larus.voicecall.api.autostop;

import a3a.c;
import com.larus.asr.session.clicktalk.s;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2 \u0010\u000b\u001a\u001c\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\fH\u0096\u0001¨\u0006\u0010"}, d2 = {"Lcom/larus/voicecall/api/autostop/AutoStopAsrServiceProviderDelegate;", "Lcom/larus/voicecall/api/autostop/IAutoStopAsrServiceProvider;", "<init>", "()V", "create", "Lcom/larus/voicecall/api/autostop/AutoStopAsrService;", "eventListener", "Lcom/larus/voicecall/api/autostop/AutoStopAsrEventListener;", "lifecycleScope", "Lkotlin/Function0;", "Lkotlinx/coroutines/CoroutineScope;", "collectBizPlugin", "Lkotlin/Function2;", "Lcom/larus/audio/call/arch/ICommonPluginContext;", "Lcom/larus/audio/call/arch/ILLMPluginRegistry;", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoStopAsrServiceProviderDelegate implements IAutoStopAsrServiceProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AutoStopAsrServiceProviderDelegate f377089b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAutoStopAsrServiceProvider f377090a;

    static {
        f377089b = new AutoStopAsrServiceProviderDelegate();
    }

    @Override // com.larus.voicecall.api.autostop.IAutoStopAsrServiceProvider
    public final c a(s r100, Function0 r101, Function2 r102) {
        Intrinsics.checkNotNullParameter(r100, "eventListener");
        Intrinsics.checkNotNullParameter(r101, "lifecycleScope");
        return this.f377090a.a(r100, r101, r102);
    }

    private AutoStopAsrServiceProviderDelegate() {
        Object r100 = ServiceManager.get().getService(IAutoStopAsrServiceProvider.class);
        Intrinsics.checkNotNull(r100);
        this.f377090a = (IAutoStopAsrServiceProvider) r100;
    }
}
