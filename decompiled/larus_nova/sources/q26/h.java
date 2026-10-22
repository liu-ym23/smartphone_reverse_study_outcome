package q26;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public interface h {
    <T> T a(Class<T> r100);

    s26.b b();

    Map<Class<?>, Object> getAllDependency();

    Context getContext();

    boolean isDebug();

    <T> void putDependency(Class<T> r100, T r101);
}
