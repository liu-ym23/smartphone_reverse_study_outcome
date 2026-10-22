package ny0;

import com.bytedance.android.live.revenue.platform.container.api.CenterServiceType;
import com.google.gson.JsonObject;
import i57.g;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes47.dex */
public interface a extends f80.a {

    /* JADX INFO: renamed from: ny0.a$a, reason: collision with other inner class name */
    public static final class C6992a {
        public static /* synthetic */ Object a(a r100, KClass r101) {
            return r100.x(r101, CenterServiceType.BUSINESS_SERVICE);
        }
    }

    Object A(String r100, String r101, JsonObject r102, String r103, g r104);

    void J0(com.bytedance.platform.aio.a r100);

    void a(String r100, com.bytedance.platform.aio.a r101);

    void g(com.bytedance.platform.aio.a r100);

    <T> T x(KClass<T> r100, CenterServiceType r101);
}
