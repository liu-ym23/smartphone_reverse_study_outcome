package p47;

import android.webkit.WebView;
import com.bytedance.pia.core.metrics.PvEventType;
import com.bytedance.pia.core.utils.ThreadUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes21.dex */
public final class h implements l47.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f527704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<f47.a> f527705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f527706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f527707e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakReference<WebView> f527708f;

    @Override // l47.c
    public final void release() {
        ThreadUtil.d(new a(this));
    }

    public h(String r100) {
        this.f527705c = new HashSet();
        this.f527706d = false;
        this.f527707e = new HashMap();
        this.f527708f = null;
        this.f527704b = r100;
    }

    public final void a(String r100, int r101) {
        b(r100, r101, "");
    }

    public final void c(final PvEventType r100, final Object r101) {
        ThreadUtil.d(new f(this, r100, r101));
    }

    public final void b(final String r100, final int r101, final String r102) {
        ThreadUtil.d(new b(this, r100, r101, r102));
    }
}
