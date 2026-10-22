package op8;

import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import java.util.Map;

/* JADX INFO: loaded from: classes26.dex */
public interface i {

    public static abstract class a {

        /* JADX INFO: renamed from: op8.i$a$a, reason: collision with other inner class name */
        public static final class C7088a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C7088a f524765a = null;

            static {
                f524765a = new C7088a();
            }

            public C7088a() {
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f524766a = null;

            static {
                f524766a = new b();
            }

            public b() {
            }
        }

        public a() {
        }
    }

    void M2(a r100);

    void a(View r100, MotionEvent r101);

    Fragment b(Boolean r100, String r101, Map<String, String> r102);

    void o8();

    void stopInput();
}
