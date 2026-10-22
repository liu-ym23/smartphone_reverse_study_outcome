package com.ss.android.ugc.aweme.search.common.repo.convert;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.MediaType;

/* JADX INFO: loaded from: classes40.dex */
public class StringConverterFactory extends Converter.Factory {
    static {
        MediaType.parse("text/plain");
    }

    public StringConverterFactory() {
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public final Converter<TypedInput, ?> responseBodyConverter(Type r100, Annotation[] r101, Retrofit r102) {
        if (String.class.equals(r100) == true) goto L5;
        return null;
    L5:
        return new AnonymousClass1();
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public final Converter<?, TypedOutput> requestBodyConverter(Type r100, Annotation[] r101, Annotation[] r102, Retrofit r103) {
        if (String.class.equals(r100) == true) goto L5;
        return null;
    L5:
        return new AnonymousClass2();
    }
}
