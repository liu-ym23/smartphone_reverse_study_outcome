package com.bytedance.pitaya.api;

import com.bytedance.pitaya.api.mutilinstance.DelegateCoreProvider;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/pitaya/api/PitayaCoreFactory;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "()V", ShortVideoSegments.KEY_PROP_PROVIDER, "Lcom/bytedance/pitaya/api/CoreProvider;", "getProvider", "()Lcom/bytedance/pitaya/api/CoreProvider;", "getCore", "Lcom/bytedance/pitaya/api/IPitayaCore;", "aid", "", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PitayaCoreFactory implements ReflectionCall {
    public static final PitayaCoreFactory INSTANCE = null;
    private static final CoreProvider provider = null;

    private PitayaCoreFactory() {
    }

    static {
        INSTANCE = new PitayaCoreFactory();
        provider = DelegateCoreProvider.INSTANCE;
    }

    public final CoreProvider getProvider() {
        return provider;
    }

    @JvmStatic
    public static final IPitayaCore getCore(String r100) {
        Intrinsics.checkNotNullParameter(r100, "aid");
        return provider.getCore(r100);
    }
}
