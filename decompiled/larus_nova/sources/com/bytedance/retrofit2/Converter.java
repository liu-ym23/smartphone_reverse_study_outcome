package com.bytedance.retrofit2;

import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface Converter<F, T> {

    /* JADX INFO: renamed from: com.bytedance.retrofit2.Converter$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<F, T> {
        public static Object $default$convertWithRequestBuilder(Converter r100, Object r101, RequestBuilder r102) {
            return null;
        }

        public static boolean $default$needRequestBuilder(Converter r100) {
            return false;
        }
    }

    public static abstract class Factory {
        public Factory() {
        }

        @Nullable
        public Converter<?, Header> headerConverter(Type r100, Annotation[] r101, Retrofit r102) {
            return null;
        }

        @Nullable
        public Converter<?, Object> objectConverter(Type r100, Annotation[] r101, Retrofit r102) {
            return null;
        }

        @Nullable
        public Converter<?, TypedOutput> requestBodyConverter(Type r100, Annotation[] r101, Annotation[] r102, Retrofit r103) {
            return null;
        }

        @Nullable
        public Converter<TypedInput, ?> responseBodyConverter(Type r100, Annotation[] r101, Retrofit r102) {
            return null;
        }

        @Nullable
        public Converter<?, String> stringConverter(Type r100, Annotation[] r101, Retrofit r102) {
            return null;
        }
    }

    @Nullable
    T convert(F r100) throws IOException;

    T convertWithRequestBuilder(F r100, RequestBuilder r101);

    boolean needRequestBuilder();
}
