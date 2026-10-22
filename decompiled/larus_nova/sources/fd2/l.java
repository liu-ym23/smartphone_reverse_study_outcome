package fd2;

import android.graphics.RectF;
import com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.KtvScrollLyricViewV2;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes9.dex */
public interface l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f476496a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f476497a = null;

        public a() {
        }

        static {
            f476497a = new a();
        }
    }

    public static final class b {
        public static /* synthetic */ void a(l r100, long r101, boolean r102, int r103) {
            if ((r103 & 2) == 0) goto L5;
            r102 = false;
        L5:
            r100.r(r101, r102, null);
        }
    }

    static {
        f476496a = a.f476497a;
    }

    void a();

    long b(int r100);

    void c(Function2<? super Integer, ? super Integer, Unit> r100);

    void d(Function1<? super g0, Unit> r100);

    void e(int r100, int r101);

    Long f();

    void g(Function2<? super Integer, ? super Integer, Unit> r100);

    KtvScrollLyricViewV2 getRenderView();

    int h();

    int i(long r100);

    com.bytedance.android.livesdk.ktvapi.config.a j();

    void k(a0 r100);

    long l(int r100);

    void m(int r100, int r101);

    void n(boolean r100);

    void o(RectF r100, int r101);

    void p();

    List<Object> q();

    void r(long r100, boolean r101, Boolean r102);

    void reset();

    int s(Integer r100, Long r101);
}
