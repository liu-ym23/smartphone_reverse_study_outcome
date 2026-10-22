package sb0;

import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lsb0/b;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f541206a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f541207a = null;

        public a() {
        }

        static {
            f541207a = new a();
        }

        public static Pair a() {
            sb0.a r100 = new sb0.a();
            Object r101 = Proxy.newProxyInstance(b.class.getClassLoader(), new Class[]{b.class}, r100);
            if (r101 == null) goto L7;
            return new Pair((b) r101, r100);
        L7:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.ktv.common.model.entity.IDataEntity");
        }
    }

    static {
        f541206a = a.f541207a;
    }

    boolean a();

    e b();

    c c();

    d d();

    String e();

    String f();

    DataCenter getDataCenter();

    boolean isAnchor();
}
