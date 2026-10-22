package com.bytedance.locallife.dito.common.request;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.RequestBuilder;
import com.bytedance.retrofit2.mime.TypedInput;

/* JADX INFO: loaded from: classes21.dex */
public final class g implements Converter<TypedInput, k> {
    public g() {
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.locallife.dito.common.request.k, java.lang.Object] */
    @Override // com.bytedance.retrofit2.Converter
    public final /* synthetic */ k convertWithRequestBuilder(TypedInput r100, RequestBuilder r101) {
        return Converter.CC.$default$convertWithRequestBuilder(this, r100, r101);
    }

    @Override // com.bytedance.retrofit2.Converter
    public final /* synthetic */ boolean needRequestBuilder() {
        return Converter.CC.$default$needRequestBuilder(this);
    }

    @Override // com.bytedance.retrofit2.Converter
    public final k convert(TypedInput r100) {
        ChunkHandler.f257654a.getClass();
        ChunkHandler r101 = ChunkHandler.Companion.f257656b.getValue();
        return r101.a(r100);
    }
}
