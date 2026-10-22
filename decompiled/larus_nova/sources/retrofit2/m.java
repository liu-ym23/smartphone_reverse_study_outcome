package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import javax.annotation.Nullable;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes41.dex */
public final class m extends g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f537520a = null;

    public static final class a<T> implements g<ResponseBody, Optional<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g<ResponseBody, T> f537521a;

        public a(g<ResponseBody, T> r100) {
            this.f537521a = r100;
        }

        @Override // retrofit2.g
        public final Object convert(ResponseBody r100) throws IOException {
            g<ResponseBody, T> r101 = this.f537521a;
            return Optional.ofNullable(r101.convert(r100));
        }
    }

    static {
        f537520a = new m();
    }

    public m() {
    }

    @Override // retrofit2.g.a
    @Nullable
    public final g<ResponseBody, ?> responseBodyConverter(Type r100, Annotation[] r101, Retrofit r102) {
        if (g.a.getRawType(r100) == Optional.class) goto L7;
        return null;
    L7:
        return new a(r102.responseBodyConverter(g.a.getParameterUpperBound(0, (ParameterizedType) r100), r101));
    }
}
