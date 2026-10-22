package com.larus.vesdk.impl.effectplatform;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.ss.android.ugc.effectmanager.common.listener.IJsonConverter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class j implements IJsonConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f375610a;

    public j() {
        this.f375610a = new Gson();
    }

    @Override // com.ss.android.ugc.effectmanager.common.listener.IJsonConverter
    public final <T> String convertObjToJson(T r100) {
        return GsonProtectorUtils.toJson(this.f375610a, r100);
    }

    @Override // com.ss.android.ugc.effectmanager.common.listener.IJsonConverter
    public final <T> T convertJsonToObj(InputStream r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "json");
        InputStreamReader r102 = new InputStreamReader(r100, StandardCharsets.UTF_8);
        return (T) GsonProtectorUtils.fromJson(this.f375610a, r102, r101);
    }
}
