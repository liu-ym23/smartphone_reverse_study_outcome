package com.ss.android.ugc.aweme.shortvideo.mapping;

import com.bytedance.creativex.model.mapping.OnlySerializableModelExtraAdapter;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/mapping/AVChallengeExtrasAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "<init>", "()V", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class AVChallengeExtrasAdapterFactory implements TypeAdapterFactory {
    public AVChallengeExtrasAdapterFactory() {
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final <T> TypeAdapter<T> create(Gson r100, TypeToken<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "gson");
        Intrinsics.checkNotNullParameter(r101, "type");
        if (HashMap.class.isAssignableFrom(r101.getRawType()) == true) goto L7;
        return null;
    L7:
        return new OnlySerializableModelExtraAdapter(r100, AVChallengeMappingKt.f454185a);
    }
}
