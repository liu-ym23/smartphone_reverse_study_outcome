package g43;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends Converter.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f479968a;

    public a(Gson r100) {
        this.f479968a = r100;
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public final Converter<TypedInput, ?> responseBodyConverter(Type r100, Annotation[] r101, Retrofit r102) {
        TypeAdapter r103 = this.f479968a.getAdapter(TypeToken.get(r100));
        return new c(this.f479968a, r103);
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public final Converter<?, TypedOutput> requestBodyConverter(Type r100, Annotation[] r101, Annotation[] r102, Retrofit r103) {
        TypeAdapter r104 = this.f479968a.getAdapter(TypeToken.get(r100));
        return new b(this.f479968a, r104);
    }
}
