package id;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes43.dex */
public final class a extends Converter.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f489273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.chunkstreamprediction.network.e f489274b;

    @Override // com.bytedance.retrofit2.Converter.Factory
    public final Converter<?, TypedOutput> requestBodyConverter(Type r100, Annotation[] r101, Annotation[] r102, Retrofit r103) {
        return null;
    }

    public a(Gson r100, com.bytedance.android.chunkstreamprediction.network.e r101) {
        if (r100 == null) goto L7;
        this.f489273a = r100;
        this.f489274b = r101;
        return;
    L7:
        throw new NullPointerException("gson == null");
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public final Converter<TypedInput, ?> responseBodyConverter(Type r100, Annotation[] r101, Retrofit r102) {
        if ((r100 instanceof ParameterizedType) == true) goto L5;
        return null;
    L5:
        ParameterizedType r103 = (ParameterizedType) r100;
        Type r104 = r103.getRawType();
        if ((r104 instanceof Class) == true) goto L9;
        return null;
    L9:
        if (com.bytedance.android.chunkstreamprediction.network.b.class.isAssignableFrom((Class) r104) == true) goto L11;
        return null;
    L11:
        Type[] r105 = r103.getActualTypeArguments();
        if (r105.length != 1) goto L16;
        Type r106 = r105[0];
        TypeAdapter r107 = this.f489273a.getAdapter(TypeToken.get(r106));
        Gson r108 = this.f489273a;
        this.f489274b.getClass();
        return new c(r108, r107, null);
    L16:
        throw new RuntimeException("ChunkBundle should have one generic type.");
    }
}
