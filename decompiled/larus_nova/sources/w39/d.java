package w39;

import com.google.gson.Gson;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class d implements w39.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<d> f558188b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f558189a;

    public static final class a {
        public static d a() {
            return d.f558188b.getValue();
        }
    }

    static {
        f558188b = LazyKt.lazy(new b());
    }

    public d() {
        this.f558189a = LazyKt.lazy(new c());
    }

    @Override // w39.a
    public final <T> T a(byte[] r100, Type r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "typeOfT");
        return (T) ((Gson) this.f558189a.getValue()).fromJson(new InputStreamReader(new ByteArrayInputStream(r100)), r101);
    L5:
        e = move-exception;
        g49.d.c("DoraRequestGsonConvertor", "Failed to convert data to Type " + r101, e);
        return null;
    }
}
