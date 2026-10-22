package pfc;

import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f529087a;

    public class a implements b {
        public a() {
        }

        @Override // pfc.n.b
        public final void e() {
            Log.e("EditActionManager", "mOriginBmp is null");
        }

        @Override // pfc.n.b
        public final void i(String r100) {
            Log.i("EditActionManager", r100);
        }
    }

    public interface b {
        void e();

        void i(String r100);
    }

    static {
        f529087a = new a();
    }
}
