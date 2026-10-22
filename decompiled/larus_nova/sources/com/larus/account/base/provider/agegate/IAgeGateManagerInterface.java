package com.larus.account.base.provider.agegate;

import kotlin.Metadata;
import org.json.JSONObject;
import s38.b;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J$\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&¨\u0006\u0011"}, d2 = {"Lcom/larus/account/base/provider/agegate/IAgeGateManagerInterface;", "", "getLoginPlatform", "", "getNeutralAgeGateStyle", "", "()Ljava/lang/Integer;", "onPassAgeGate", "", "pass", "", "verifyAgeGate", "callback", "Lcom/larus/account/base/provider/agegate/IAgeGateResultCallback;", "platform", "trackerJson", "Lorg/json/JSONObject;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAgeGateManagerInterface {
    void a(b r100, String r101, JSONObject r102);

    Integer b();

    void c(boolean r100);

    String getLoginPlatform();
}
