package i11;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.link.model.p;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public interface c {

    public static class a implements b {
        public a() {
        }

        @Override // i11.c.b
        public void a(int r100, List r101) {
        }

        @Override // i11.c.b
        public void b(int r100, List<? extends p> r101) {
        }

        @Override // i11.c.b
        public void c(int r100, List<? extends IBaseUser> r101) {
        }

        @Override // i11.c.b
        public void d(int r100, List<? extends p> r101) {
            Intrinsics.checkNotNullParameter(r101, "list");
        }

        @Override // i11.c.b
        public void e(String r100) {
        }

        @Override // i11.c.b
        public void f() {
        }

        @Override // i11.c.b
        public final void g() {
        }

        @Override // i11.c.b
        public void h(int r100, List<? extends p> r101) {
        }

        @Override // i11.c.b
        public void i(int r100) {
        }
    }

    public interface b {
        void a(int r100, List r101);

        void b(int r100, List<? extends p> r101);

        void c(int r100, List<? extends IBaseUser> r101);

        void d(int r100, List<? extends p> r101);

        void e(String r100);

        void f();

        void g();

        void h(int r100, List<? extends p> r101);

        void i(int r100);
    }

    List<p> a();

    void b(int r100, String r101);

    Map<String, String> g();

    p getGuestInfo(String r100, String r101);

    List<p> getOnlineUserList();

    void i(b r100);

    void l(b r100);

    Disposable m(Function2<? super List<? extends p>, ? super Integer, Unit> r100);
}
