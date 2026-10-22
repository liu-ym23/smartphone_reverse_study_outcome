package com.ss.android.lark.larkconfig.universal;

import com.bytedance.lark.pb.settings.v1.GetUniversalUserSettingResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes36.dex */
public final class c<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T> f431129a = null;

    static {
        f431129a = new c();
    }

    public c() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return GetUniversalUserSettingResponse.ADAPTER.decode(r100).settings;
    }
}
