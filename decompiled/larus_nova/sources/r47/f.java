package r47;

import com.bytedance.pia.core.plugins.HtmlPlugin;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes21.dex */
public final class f extends q47.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f536074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HtmlPlugin f536075b;

    public f(HtmlPlugin r100, AtomicInteger r101) {
        this.f536075b = r100;
        this.f536074a = r101;
    }

    @Override // q47.d.a
    public final void b(int r100, boolean r101) {
        this.f536074a.compareAndSet(0, r100);
        if (r101 == true) goto L6;
        this.f536075b.f540648b.f17562k.b("html_stream_truncate", 0, "from=origin,length=" + r100);
        return;
    }
}
