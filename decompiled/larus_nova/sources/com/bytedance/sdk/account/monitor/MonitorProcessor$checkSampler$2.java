package com.bytedance.sdk.account.monitor;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "info", "Lorg/json/JSONObject;", "params", "Lcom/bytedance/sdk/account/monitor/MonitorProcessor$a;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/String;Lorg/json/JSONObject;)Lcom/bytedance/sdk/account/monitor/MonitorProcessor$a;", "report"}, k = 3, mv = {1, 4, 0})
final class MonitorProcessor$checkSampler$2 extends Lambda implements Function2<String, JSONObject, MonitorProcessor.a> {
    final /* synthetic */ com.bytedance.sdk.account.monitor.settings.a $config;
    final /* synthetic */ String $configVersion;
    final /* synthetic */ int $sampleRate;

    public MonitorProcessor$checkSampler$2(String r100, int r101, com.bytedance.sdk.account.monitor.settings.a r102) {
        this.$configVersion = r100;
        this.$sampleRate = r101;
        this.$config = r102;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final MonitorProcessor.a invoke2(String r110, JSONObject r111) {
        String r100 = this.$configVersion;
        int r101 = this.$sampleRate;
        Set<String> r102 = this.$config.f269202g;
        if (r102 != null) goto L7;
        r102 = SetsKt.emptySet();
    L7:
        return new MonitorProcessor.a(true, true, r110, r100, r101, r111, r102, this.$config.f269203h);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ MonitorProcessor.a invoke(String r100, JSONObject r101) {
        return invoke2(r100, r101);
    }
}
