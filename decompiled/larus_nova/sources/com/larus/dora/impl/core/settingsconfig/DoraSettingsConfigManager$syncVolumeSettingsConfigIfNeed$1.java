package com.larus.dora.impl.core.settingsconfig;

import com.bytedance.map.api.monitor.MapMonitorConst;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.settingsconfig.DoraSettingsConfigManager", f = "DoraSettingsConfigManager.kt", i = {0, 0, 0}, l = {135}, m = "syncVolumeSettingsConfigIfNeed", n = {"retArray", "volumeConfig", MapMonitorConst.ATTEMPT}, s = {"L$0", "L$1", "I$0"})
public final class DoraSettingsConfigManager$syncVolumeSettingsConfigIfNeed$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraSettingsConfigManager this$0;

    public DoraSettingsConfigManager$syncVolumeSettingsConfigIfNeed$1(DoraSettingsConfigManager r100, Continuation<? super DoraSettingsConfigManager$syncVolumeSettingsConfigIfNeed$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, this);
    }
}
