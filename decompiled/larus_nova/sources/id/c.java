package id;

import com.bytedance.android.chunkstreamprediction.network.h;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.RequestBuilder;
import com.bytedance.retrofit2.mime.MimeUtil;
import com.bytedance.retrofit2.mime.TypedInput;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.io.IOException;

/* JADX INFO: loaded from: classes43.dex */
public final class c<T> implements Converter<TypedInput, com.bytedance.android.chunkstreamprediction.network.b<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f489279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeAdapter<T> f489280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f489281c;

    @Override // com.bytedance.retrofit2.Converter
    public final /* synthetic */ Object convertWithRequestBuilder(TypedInput r100, RequestBuilder r101) {
        return Converter.CC.$default$convertWithRequestBuilder(this, r100, r101);
    }

    @Override // com.bytedance.retrofit2.Converter
    public final /* synthetic */ boolean needRequestBuilder() {
        return Converter.CC.$default$needRequestBuilder(this);
    }

    @Override // com.bytedance.retrofit2.Converter
    public final Object convert(TypedInput r100) throws IOException {
        TypedInput r101 = r100;
        e r102 = new e(r101.in());
        String r103 = "UTF-8";
        if (r101.mimeType() == null) goto L5;
        r103 = MimeUtil.parseCharset(r101.mimeType(), "UTF-8");
    L5:
        com.bytedance.android.chunkstreamprediction.network.b r104 = new com.bytedance.android.chunkstreamprediction.network.b(new b(this, new com.bytedance.android.chunkstreamprediction.network.c(), r102, r103));
        r102.f489287b = r104.f42520a;
        return r104;
    }

    public c(Gson r100, TypeAdapter<T> r101, h r102) {
        this.f489279a = r100;
        this.f489280b = r101;
        this.f489281c = r102;
    }
}
