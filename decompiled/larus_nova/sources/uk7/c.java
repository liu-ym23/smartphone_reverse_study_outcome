package uk7;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends Converter.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f550528a;

    public c(Gson r100) {
        this.f550528a = r100;
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public final Converter<TypedInput, ?> responseBodyConverter(Type r100, Annotation[] r101, Retrofit r102) {
        TypeAdapter r103 = this.f550528a.getAdapter(TypeToken.get(r100));
        return new p(this.f550528a, r103, r100);
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public final Converter<?, TypedOutput> requestBodyConverter(Type r100, Annotation[] r101, Annotation[] r102, Retrofit r103) {
        TypeAdapter r104 = this.f550528a.getAdapter(TypeToken.get(r100));
        return new o(this.f550528a, r104);
    }
}
