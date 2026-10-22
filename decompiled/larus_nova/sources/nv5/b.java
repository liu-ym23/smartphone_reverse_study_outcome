package nv5;

import android.webkit.WebView;
import com.bytedance.falconx.statistic.InterceptorModel;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends rv5.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InterceptorModel f520870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WebView f520871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a f520872d;

    @Override // rv5.c, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        super.close();
        this.f520870b.loadFinish(true);
        a r100 = this.f520872d;
        WebView r101 = this.f520871c;
        InterceptorModel r102 = this.f520870b;
        r100.f520867c.post(new c(r101, r102));
    }

    @Override // rv5.c
    public final void a(IOException r100) {
        this.f520870b.setErrorCode("101");
        this.f520870b.setErrorMsg(r100.getMessage());
        this.f520870b.loadFinish(false);
        a r101 = this.f520872d;
        WebView r102 = this.f520871c;
        InterceptorModel r103 = this.f520870b;
        r101.f520867c.post(new c(r102, r103));
    }

    public b(a r100, InputStream r101, InterceptorModel r102, WebView r103) {
        this.f520872d = r100;
        this.f520870b = r102;
        this.f520871c = r103;
        super(r101);
    }
}
