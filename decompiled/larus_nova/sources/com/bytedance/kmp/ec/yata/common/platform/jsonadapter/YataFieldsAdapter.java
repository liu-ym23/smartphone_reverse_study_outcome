package com.bytedance.kmp.ec.yata.common.platform.jsonadapter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import z96.a;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "SDK内部工具类")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/kmp/ec/yata/common/platform/jsonadapter/YataFieldsAdapter;", "Lcom/google/gson/TypeAdapter;", "", "<init>", "()V", "yata-common-kmp_release"}, k = 1, mv = {1, 7, 0})
public final class YataFieldsAdapter extends TypeAdapter<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypeAdapter<Object> f251543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f251544b;

    public YataFieldsAdapter() {
        this.f251543a = new Gson().getAdapter(Object.class);
        this.f251544b = new a();
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "reader");
        this.f251544b.getClass();
        return a.a(r100);
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, Object r101) throws IOException {
        this.f251543a.write(r100, r101);
    }
}
