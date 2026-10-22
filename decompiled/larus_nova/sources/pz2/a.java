package pz2;

import com.bytedance.android.monitorV2.webview.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f531055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f531056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f531057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f531058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f531059e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public oz2.a f531060f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f531061g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f531062h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f531063i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f531064j;

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        this(r100, new com.bytedance.android.monitorV2.webview.a());
    }

    public a(String r100, com.bytedance.android.monitorV2.webview.a r101) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        Intrinsics.checkNotNullParameter(r101, "monitor");
        this.f531055a = r100;
        this.f531056b = true;
        this.f531057c = true;
        this.f531058d = r101;
        this.f531059e = "";
        this.f531061g = "perf_destroy";
        this.f531062h = "";
    }
}
