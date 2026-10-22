package k9c;

import com.squareup.wire.Message;
import com.ss.android.lark.ug.integrator.UgReachSdkIntegrator;

/* JADX INFO: loaded from: classes38.dex */
public interface e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f502168a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f502169a = null;

        static {
            f502169a = new a();
        }

        public a() {
        }
    }

    static {
        f502168a = a.f502169a;
    }

    <RP extends d<?>> RP b(String r100, Class<RP> r101);

    void c(UgReachSdkIntegrator.a r100);

    void d(String r100, String r101);

    void e(String r100, String r101, byte[] r102);

    <RP extends d<DATA>, DATA extends Message<?, ?>> void f(RP r100);

    void g();
}
