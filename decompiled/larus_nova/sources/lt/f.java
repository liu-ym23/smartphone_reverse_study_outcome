package lt;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.gamecp.base.gamedetail.l0;
import com.bytedance.android.gamecp.common.utils.y0;

/* JADX INFO: loaded from: classes44.dex */
public interface f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f510641a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f510642a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f510643b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f510644c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f510645d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f510646e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f510647f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ a f510648g = null;

        public a() {
        }

        static {
            f510648g = new a();
            f510642a = y0.b(44.0f);
            f510643b = y0.b(28.0f);
            f510644c = y0.b(8.0f);
            f510645d = y0.b(92.0f);
            f510646e = y0.b(40.0f);
            f510647f = y0.b(88.0f);
        }
    }

    static {
        f510641a = a.f510648g;
    }

    void a(Dialog r100);

    b b(FrameLayout r100);

    l0 c(Context r100, Window r101, boolean r102, boolean r103);

    void d(DialogFragment r100, String r101);

    void e(Dialog r100);

    void onViewCreated(View r100);
}
