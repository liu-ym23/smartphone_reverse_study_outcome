package com.bytedance.dux.api;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/dux/api/DuxComponentServiceDefault;", "Lcom/bytedance/dux/api/IDuxComponentService;", "<init>", "()V", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxComponentServiceDefault implements IDuxComponentService {
    @Override // com.bytedance.dux.api.IDuxComponentService
    public final int getFoldStatus() {
        return 0;
    }

    @Override // com.bytedance.dux.api.IDuxComponentService
    public final String getHostGeckoAccessKey() {
        return "";
    }

    @Override // com.bytedance.dux.api.IDuxComponentService
    public final boolean isCloseDoubleColorBallStartAfterAttachEnableFlag() {
        return true;
    }

    @Override // com.bytedance.dux.api.IDuxComponentService
    public final boolean isCloseNewToastStyle() {
        return false;
    }

    @Override // com.bytedance.dux.api.IDuxComponentService
    public final boolean isDebugMode() {
        return false;
    }

    @Override // com.bytedance.dux.api.IDuxComponentService
    public final boolean isGridChangeRollbackEnable() {
        return true;
    }

    @Override // com.bytedance.dux.api.IDuxComponentService
    public final boolean isOptimized(String r100) {
        Intrinsics.checkNotNullParameter(r100, "componentId");
        return true;
    }

    @Override // com.bytedance.dux.api.IDuxComponentService
    public final boolean isPad() {
        return false;
    }

    @Override // com.bytedance.dux.api.IDuxComponentService
    public final boolean readForceLTRFlag() {
        return false;
    }

    @Override // com.bytedance.dux.api.IDuxComponentService
    public final void registerGridChangeListenerDowngrade(Fragment r100, String r101, boolean r102, Function1<? super Integer, Unit> r103) {
        Intrinsics.checkNotNullParameter(r103, "listener");
    }

    public DuxComponentServiceDefault() {
    }

    @Override // com.bytedance.dux.api.IDuxComponentService
    public final Pair<Boolean, Boolean> verifyLargeFontModeAdapt(String r100) {
        Intrinsics.checkNotNullParameter(r100, "componentId");
        return TuplesKt.to(Boolean.FALSE, Boolean.TRUE);
    }
}
