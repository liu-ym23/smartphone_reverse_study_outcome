package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes41.dex */
public interface g<F, T> {

    public static abstract class a {
        public a() {
        }

        @Nullable
        public g<?, RequestBody> requestBodyConverter(Type r100, Annotation[] r101, Annotation[] r102, Retrofit r103) {
            return null;
        }

        @Nullable
        public g<ResponseBody, ?> responseBodyConverter(Type r100, Annotation[] r101, Retrofit r102) {
            return null;
        }

        @Nullable
        public g<?, String> stringConverter(Type r100, Annotation[] r101, Retrofit r102) {
            return null;
        }

        public static Class<?> getRawType(Type r100) {
            return u.f(r100);
        }

        public static Type getParameterUpperBound(int r100, ParameterizedType r101) {
            return u.e(r100, r101);
        }
    }

    @Nullable
    T convert(F r100) throws IOException;
}
