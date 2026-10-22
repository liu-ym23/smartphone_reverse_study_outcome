package r07;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes21.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n07.e f535497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f535498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, Future<n07.d>> f535499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, Future<o07.d>> f535500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f535501e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<String, c> f535502f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final n07.a.InterfaceC6878a f535503g;

    public final void finalize() throws Throwable {
        this.f535498b.shutdown();     // Catch: Throwable -> L5
    L3:
        super.finalize();
    }

    public f(g17.b r100) {
        this.f535503g = r100;
        this.f535498b = PThreadExecutorsUtils.newScheduledThreadPool(3, new DefaultThreadFactory("SccCloudServiceImpl"));
        this.f535499c = new ConcurrentHashMap();
        this.f535500d = new ConcurrentHashMap();
        this.f535501e = new ArrayList();
        this.f535497a = new n07.e(n07.b.f516587d);
        this.f535502f = new ConcurrentHashMap();
    }

    public final n07.f a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        if (TextUtils.isEmpty(r100) == false) goto L10;
    L12:
        monitor-enter(this);
        n07.f r101 = this.f535497a.b(r100);     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return r101;
    L16:
        th = move-exception;
        throw th;
    L10:
        if (r100.endsWith(HTTP.URL_DEFAULT) == false) goto L12;
        r100 = r100.substring(0, r100.length() - 1);
        goto L12
    }

    public final n07.f b(String r100) {
        String r101 = q07.b.b(r100);
        n07.a.InterfaceC6878a r102 = this.f535503g;
        if (r102 != null) goto L5;
    L8:
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L10:
        if (((ArrayList) this.f535501e).remove(r101) == false) goto L14;
        n07.f r103 = new n07.f(r101);     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        return r103;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L17
        return null;
    L5:
        if (((g17.b) r102).a(r101) == false) goto L8;
        return new n07.f(r101);
    }
}
