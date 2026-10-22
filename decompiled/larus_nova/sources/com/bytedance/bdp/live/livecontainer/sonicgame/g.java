package com.bytedance.bdp.live.livecontainer.sonicgame;

import com.bytedance.bdp.bdpbase.core.BdpResultListener;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements BdpResultListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function3 f201521a;

    public g(Function3 r100) {
        this.f201521a = r100;
    }

    @Override // com.bytedance.bdp.bdpbase.core.BdpResultListener
    public final /* synthetic */ void onResult(int r100, String r101, Object r102) {
        this.f201521a.invoke(Integer.valueOf(r100), r101, r102);
    }
}
