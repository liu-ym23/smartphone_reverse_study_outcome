package si0;

import android.view.ViewGroup;
import com.bytedance.android.live.broadcastgame.api.xplay.f;
import hg6.g;

/* JADX INFO: loaded from: classes46.dex */
public interface b {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f542094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ViewGroup f542095b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ViewGroup f542096c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ViewGroup f542097d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final g f542098e;

        public a(boolean r100, ViewGroup r101, ViewGroup r102, ViewGroup r103, g r104) {
            this.f542094a = r100;
            this.f542095b = r101;
            this.f542096c = r102;
            this.f542097d = r103;
            this.f542098e = r104;
        }
    }

    void a(ViewGroup r100);

    void b(boolean r100);

    void c(a r100, f r101);

    void d();

    void onCreate();

    void onDestroy();
}
