package v05;

import android.content.Context;
import android.os.Looper;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.larus.nova.R;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes16.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, a> f552312a = null;

    public f() {
    }

    static {
        f552312a = new ConcurrentHashMap();
    }

    public static void c(String r100, Class<? extends BaseFragment> r101) {
        Map<String, a> r102 = f552312a;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        r103.put(r100, new a(r101, R.layout.document_fragment));
    }

    public static void d(String r100, a r101) {
        ((ConcurrentHashMap) f552312a).put(r100, r101);
    }

    public static View a(Context r100, ViewGroup r101, a r102) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        return b(r100, r101, r102);
    L6:
        monitor-enter(f.class);
        View r103 = b(r100, r101, r102);     // Catch: Throwable -> L10
        monitor-exit(f.class);     // Catch: Throwable -> L10
        return r103;
    L10:
        th = move-exception;
        throw th;
    }

    public static View b(Context r100, ViewGroup r101, a r102) {
        View r103 = LayoutInflater.from(new ContextThemeWrapper(r100, R.style.DocAppTheme_NoActionBar)).inflate(r102.f552305b, r101, false);
        ((BaseTitleBar) r103.findViewById(R.id.doc_main_title)).setCustomTitleView(g.a(r100).getView());
        return r103;
    }
}
