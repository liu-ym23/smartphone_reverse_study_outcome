package g43;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.RequestBuilder;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes12.dex */
public final class b<T> implements Converter<T, TypedOutput> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f479969c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f479970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeAdapter<T> f479971b;

    /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.retrofit2.mime.TypedOutput, java.lang.Object] */
    @Override // com.bytedance.retrofit2.Converter
    public final /* synthetic */ TypedOutput convertWithRequestBuilder(Object r100, RequestBuilder r101) {
        return Converter.CC.$default$convertWithRequestBuilder(this, r100, r101);
    }

    @Override // com.bytedance.retrofit2.Converter
    public final /* synthetic */ boolean needRequestBuilder() {
        return Converter.CC.$default$needRequestBuilder(this);
    }

    static {
        f479969c = Charset.forName("UTF-8");
    }

    @Override // com.bytedance.retrofit2.Converter
    public final TypedOutput convert(Object r100) throws IOException {
        StringWriter r101 = new StringWriter();
        BufferedWriter r102 = new BufferedWriter(r101);
        JsonWriter r103 = this.f479970a.newJsonWriter(r102);
        this.f479971b.write(r103, r100);
        r102.flush();
        r103.close();
        return new TypedByteArray("application/json; charset=UTF-8", r101.toString().getBytes(f479969c), new String[0]);
    }

    public b(Gson r100, TypeAdapter<T> r101) {
        this.f479970a = r100;
        this.f479971b = r101;
    }
}
