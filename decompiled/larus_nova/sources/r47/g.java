package r47;

import android.util.Log;
import com.bytedance.pia.core.plugins.HtmlPlugin;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes21.dex */
public final class g extends q47.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f536076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HtmlPlugin f536077b;

    @Override // q47.d.a
    public final void a(Throwable r100) {
        this.f536077b.f540648b.f17562k.b("html_stream_exception", 0, Log.getStackTraceString(r100));
    }

    public g(HtmlPlugin r100, AtomicInteger r101) {
        this.f536077b = r100;
        this.f536076a = r101;
    }

    @Override // q47.d.a
    public final void b(int r100, boolean r101) {
        int r102 = this.f536076a.get();
        if (r100 >= r102) goto L6;
        this.f536077b.f540648b.f17562k.b("html_stream_truncate", 0, "from=copy,length=" + r100 + ",origin=" + r102);
        return;
    }
}
