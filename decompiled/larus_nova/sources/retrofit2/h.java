package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes41.dex */
public final class h extends CallAdapter.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f537486a = null;

    public class a implements CallAdapter<Object, Call<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Type f537487a;

        @Override // retrofit2.CallAdapter
        public final Call<?> adapt(Call<Object> r100) {
            return r100;
        }

        @Override // retrofit2.CallAdapter
        public final Type responseType() {
            return this.f537487a;
        }

        public a(Type r100) {
            this.f537487a = r100;
        }
    }

    static {
        f537486a = new h();
    }

    public h() {
    }

    @Override // retrofit2.CallAdapter.Factory
    @Nullable
    public final CallAdapter<?, ?> get(Type r100, Annotation[] r101, Retrofit r102) {
        if (CallAdapter.Factory.getRawType(r100) == Call.class) goto L7;
        return null;
    L7:
        if ((r100 instanceof ParameterizedType) == false) goto L11;
        return new a(u.e(0, (ParameterizedType) r100));
    L11:
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
