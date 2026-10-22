package u77;

import com.bytedance.push.settings.PushOnlineSettings;
import com.ss.android.message.AppProvider;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static volatile g f549044r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f549045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f549046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f549047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f549048d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f549049e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<String> f549050f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f549051g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f549052h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f549053i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f549054j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<List<String>> f549055k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<String> f549056l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<String> f549057m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<n> f549058n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f549059o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List<String> f549060p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public List<String> f549061q;

    public g() {
    }

    public static g a() {
        if (f549044r != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f549044r != null) goto L9;
        f549044r = ((PushOnlineSettings) j77.i.a(AppProvider.getApp(), PushOnlineSettings.class)).p();     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f549044r;
    }
}
