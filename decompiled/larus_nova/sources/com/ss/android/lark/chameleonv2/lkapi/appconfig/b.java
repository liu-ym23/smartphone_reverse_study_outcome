package com.ss.android.lark.chameleonv2.lkapi.appconfig;

import com.bytedance.lark.pb.settings.v1.GetSettingsResponse;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes35.dex */
public final class b<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T> f411425a = null;

    static {
        f411425a = new b();
    }

    public b() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        if (r100 != null) goto L9;
    L7:
        return null;
    L9:
        return GetSettingsResponse.ADAPTER.decode(r100);
    L5:
        e = move-exception;
        Log.e("LK_API_TAG_AppConfig", "getSettingFromRust parse onError: " + e);
        goto L7
    }
}
