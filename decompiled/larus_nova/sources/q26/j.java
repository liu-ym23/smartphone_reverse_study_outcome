package q26;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public interface j {

    public static final class a {
        public static <T> T a(j r100, Class<T> r101) {
            Intrinsics.checkNotNullParameter(r101, "clazz");
            return (T) r100.getServiceContext().a(r101);
        }

        public static <T extends c> T b(j r100, Class<T> r101) {
            Intrinsics.checkNotNullParameter(r101, "clazz");
            s26.d r102 = s26.d.f540305c;
            return (T) s26.d.f540305c.d(r100.getBid(), r101);
        }
    }

    <T> T a(Class<T> r100);

    Map<Class<?>, Object> getAllDependency();

    String getBid();

    <T extends c> T getService(Class<T> r100);

    h getServiceContext();
}
