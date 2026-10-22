package rx5;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.RequestBuilder;
import com.bytedance.retrofit2.mime.MimeUtil;
import com.bytedance.retrofit2.mime.TypedInput;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes3.dex */
public final class c<T> implements Converter<TypedInput, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f539821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeAdapter<T> f539822b;

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
        String r102 = "UTF-8";
        if (r101.mimeType() == null) goto L5;
        r102 = MimeUtil.parseCharset(r101.mimeType(), "UTF-8");
    L5:
        InputStreamReader r103 = new InputStreamReader(r101.in(), r102);
        JsonReader r104 = this.f539821a.newJsonReader(r103);
        T r105 = this.f539822b.read(r104);     // Catch: Throwable -> L9
        r103.close();     // Catch: IOException -> L12
    L8:
        return r105;
    L9:
        th = move-exception;
        r103.close();     // Catch: IOException -> L13
    L11:
        throw th;
    }

    public c(Gson r100, TypeAdapter<T> r101) {
        this.f539821a = r100;
        this.f539822b = r101;
    }
}
