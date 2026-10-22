package com.bytedance.caijing.sdk.infra.base.api.settings;

import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032F\u0010\u0004\u001aB\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H&Jf\u0010\r\u001a\u00020\u00032\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062F\u0010\u0004\u001aB\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/settings/ISLSettings;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "fetchSettings", "", "callback", "Lkotlin/Function2;", "", "", "", "Lkotlin/ParameterName;", "name", "response", "error", "fetchSettingsV2", "params", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ISLSettings extends ICJService {
    void fetchSettings(Function2<? super Map<String, Object>, ? super String, Unit> r100);

    void fetchSettingsV2(Map<String, String> r100, Function2<? super Map<String, Object>, ? super String, Unit> r101);
}
