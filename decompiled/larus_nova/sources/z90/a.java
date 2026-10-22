package z90;

import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.livesdkapi.depend.message.RoomFeatureValue;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public interface a {

    /* JADX INFO: renamed from: z90.a$a, reason: collision with other inner class name */
    public static final class C8431a {
        public static /* synthetic */ boolean a(a r100, String r101, Object r102) {
            return r100.i(r101, r102, FeatureType.DYNAMIC);
        }
    }

    public interface b {
        <T> void a(String r100, T r101);
    }

    public interface c {
        void a(List<String> r100);
    }

    void a(String r100, b r101);

    <T> T b(String r100, String r101, T r102);

    boolean c(String r100, Object r101);

    void d(String r100, Map<String, RoomFeatureValue> r101);

    boolean e(b r100, List<String> r101);

    void f(c r100);

    void g(String r100);

    <T> T getFeature(String r100, T r101);

    void h(b r100);

    boolean i(String r100, Object r101, FeatureType r102);

    void j(b r100);
}
