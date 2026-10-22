package i00;

import com.bytedance.android.live.broadcast.api.scope.service.e;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes45.dex */
public interface b {
    <T extends e> T a(KClass<T> r100);

    void d(Class r100, f00.b r101);

    void f(KClass r100, f00.b r101);

    <T extends e> T getService(Class<T> r100);
}
