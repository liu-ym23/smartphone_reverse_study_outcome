package com.larus.settings.protector;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.news.common.settings.SettingsManager;
import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class f implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f368555a;

    public /* synthetic */ f(String r100) {
        this.f368555a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        String r100 = this.f368555a;
        GsonFilterNotNullConfig r101 = ((IProtectorSettings) SettingsManager.obtain(IProtectorSettings.class)).getGsonFilterNotNullConfig();
        xg9.b.a().storeString("nova_gson_filter_not_null", GsonProtectorUtils.toJson((Gson) j.f368556a.getValue(), r101));
        FLogger.f375446a.i("ProtectorSettings", "updateGsonFilterNotNullConfig from " + r100 + ", config: " + r101);
        return Unit.INSTANCE;
    }
}
