package h4a;

import com.bytedance.retrofit2.Retrofit;
import com.ivy.ivykit.api.bridge.inject.IvyIRetrofit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class f implements hx7.d {

    public final class a implements IvyIRetrofit {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Retrofit f483798a;

        public a(Retrofit r100) {
            Intrinsics.checkNotNullParameter(r100, "retrofit");
            this.f483798a = r100;
        }

        @Override // com.ivy.ivykit.api.bridge.inject.IvyIRetrofit
        public final <T> T create(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "service");
            return (T) this.f483798a.create(r100);
        }
    }

    public f() {
    }

    @Override // hx7.d
    public final void getAPIParams() {
    }

    @Override // hx7.d
    public final a createRetrofit(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        return new a(k4a.c.a(r100, r101));
    }
}
