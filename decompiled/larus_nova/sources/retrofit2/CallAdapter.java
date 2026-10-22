package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes41.dex */
public interface CallAdapter<R, T> {

    public static abstract class Factory {
        public Factory() {
        }

        @Nullable
        public abstract CallAdapter<?, ?> get(Type r100, Annotation[] r101, Retrofit r102);

        public static Class<?> getRawType(Type r100) {
            return u.f(r100);
        }

        public static Type getParameterUpperBound(int r100, ParameterizedType r101) {
            return u.e(r100, r101);
        }
    }

    T adapt(Call<R> r100);

    Type responseType();
}
