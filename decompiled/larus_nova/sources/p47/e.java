package p47;

import android.webkit.WebView;
import com.bytedance.pia.core.metrics.MetricsType;
import com.bytedance.pia.core.utils.ThreadUtil;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f527692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MetricsType f527693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f527694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Map f527695d;

    public /* synthetic */ e(h r100, MetricsType r101, Map r102) {
        this.f527692a = r100;
        this.f527693b = r101;
        this.f527694c = r102;
        this.f527695d = null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h r100 = this.f527692a;
        final MetricsType r101 = this.f527693b;
        final Map r102 = this.f527694c;
        final Map r103 = this.f527695d;
        Iterator r110 = ((HashSet) r100.f527705c).iterator();
    L4:
        if (r110.hasNext() == false) goto L12;
        final f47.a r104 = (f47.a) r110.next();
        if (r104 == null) goto L4;
        WeakReference<WebView> r105 = r100.f527708f;
        if (r105 != null) goto L10;
        WebView r106 = null;
    L11:
        final WebView r107 = r106;
        ThreadUtil.b(new g(r104, r101, r107, r102, r103));
        goto L4
    L10:
        r106 = r105.get();
        goto L11
    }
}
