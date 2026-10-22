package com.ss.android.lark.larkconfig.universal;

import com.bytedance.lark.pb.basic.v1.UniversalUserSetting;
import com.bytedance.lark.pb.settings.v1.UpdateUniversalUserSettingResponse;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class d<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d<T> f431130a = null;

    static {
        f431130a = new d();
    }

    public d() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return (UniversalUserSetting) CollectionsKt.firstOrNull(UpdateUniversalUserSettingResponse.ADAPTER.decode(r100).settings);
    }
}
