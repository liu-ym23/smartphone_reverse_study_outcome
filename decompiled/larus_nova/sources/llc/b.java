package llc;

import android.content.Context;
import bytekn.foundation.logger.Logger;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.ugc.effectplatform.bridge.network.EmptyByteReadStream;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import com.ss.ugc.effectplatform.util.i;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Triple;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class b implements com.ss.ugc.effectplatform.bridge.network.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f509808e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static b f509809f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f509810g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f509811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, Triple<String, DownloadTask, NetResponse>> f509812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Object> f509813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f509814d;

    public static final class a {
        public a() {
        }
    }

    static {
        f509810g = new a();
        f509808e = new Object();
    }

    public final Object getContext() {
        return this.f509814d;
    }

    public b(Object r100) {
        this.f509814d = r100;
        if (r100 == null) goto L7;
        this.f509811a = (Context) r100;
        this.f509812b = new ConcurrentHashMap();
        this.f509813c = new ConcurrentHashMap();
        return;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type android.content.Context");
    }

    public static String c(String r100) {
        String r101 = (String) CollectionsKt.last(StringsKt.split$default(r100, new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null));
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return r100;
    L9:
        return r101;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.b
    public final void cancel(String r100) {
        Triple<String, DownloadTask, NetResponse> r101 = this.f509812b.get(c(r100));
        if (r101 == null) goto L5;
        String r102 = r101.getFirst();
        DownloadTask r103 = r101.getSecond();
    L6:
        if (r103 == null) goto L11;
        Logger.e$default(Logger.INSTANCE, "JKL", "[取消][调用SDK][" + r102 + "][剩余任务" + this.f509812b.values().size() + "个][DownLoadID : " + r103.getDownloadId() + ']', null, 4, null);
        Downloader.getInstance(this.f509811a).cancel(r103.getDownloadId());
        if (a0.a.a() == true) goto L12;
        d(r103);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r103 = null;
        r102 = "";
        goto L6
    }

    public final void d(DownloadTask r100) {
        if (this.f509813c.get(Integer.valueOf(r100.getDownloadId())) != null) goto L5;
        this.f509813c.put(Integer.valueOf(r100.getDownloadId()), new Object());
    L5:
        Object r101 = this.f509813c.get(Integer.valueOf(r100.getDownloadId()));
        if (r101 == null) goto L19;
        monitor-enter(r101);
        r101.wait();     // Catch: Throwable -> L10 Exception -> L12
    L14:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r101);
        goto L19
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L19:
        this.f509813c.remove(Integer.valueOf(r100.getDownloadId()));
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.INetworkClient
    public final NetResponse fetchFromNetwork(NetRequest r100) {
        return new NetResponse(601, new EmptyByteReadStream(), -1, null, 8, null);
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.b
    public final void pause(String r100) {
        Triple<String, DownloadTask, NetResponse> r101 = this.f509812b.get(c(r100));
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getFirst();
        DownloadTask r104 = r101.getSecond();
    L6:
        if (r104 == null) goto L14;
        Logger r105 = Logger.INSTANCE;
        StringBuilder r106 = new StringBuilder("[暂停][调用SDK][");
        r106.append(r103);
        r106.append("][剩余任务");
        r106.append(this.f509812b.values().size());
        r106.append("个][暂停链接:");
        DownloadInfo r107 = r104.getDownloadInfo();
        if (r107 == null) goto L10;
        r102 = r107.getUrl();
    L10:
        r106.append(r102);
        r106.append(']');
        r105.w("JKL", r106.toString());
        Downloader.getInstance(this.f509811a).pause(r104.getDownloadId());
        if (a0.a.a() == true) goto L15;
        d(r104);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r103 = "";
        r104 = null;
        goto L6
    }

    public static final void b(b r100, int r101) {
        Object r102 = r100.f509813c.get(Integer.valueOf(r101));
        if (r102 == null) goto L16;
        monitor-enter(r102);
        r102.notifyAll();     // Catch: Throwable -> L7 Exception -> L9
    L11:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r102);
        return;
    L7:
        th = move-exception;
        throw th;
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L7
        goto L11
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.b
    public final NetResponse a(NetRequest r110, String r111, String r112, com.ss.ugc.effectplatform.bridge.network.a r113) {
        Triple<String, DownloadTask, NetResponse> r100 = this.f509812b.get(c(r110.getUrl()));
        Object r101 = null;
        if (r100 == null) goto L5;
        DownloadTask r102 = r100.getSecond();
    L7:
        if (r102 != null) goto L9;
    L12:
        r102 = Downloader.with(this.f509811a);
        r102.url(r110.getUrl());
        List<String> r103 = r110.getBackupUrl();
        if (r103 == null) goto L15;
        r102.backUpUrls(r103);
    L15:
        i r104 = i.f458038a;
        r102.savePath(i.g(r111));
        r102.name(i.e(r111));
        Map<String, Object> r105 = r110.getExtraParms();
        if (r105 == null) goto L19;
        r101 = r105.get("ParamsNetLimit");
    L19:
        if ((r101 instanceof Long) == true) goto L21;
    L23:
        r102.subThreadListener(new c(this, r113));
        r100 = new Triple(r112, r102, new NetResponse(601, new EmptyByteReadStream(), -1, null, 8, null));
        this.f509812b.put(c(r110.getUrl()), r100);
        r102.download();
        Logger.INSTANCE.d("JKL", "[收到下载请求][SDK][" + r112 + ']');
    L24:
        d(r102);
        if (r100 == null) goto L30;
        NetResponse r106 = r100.getThird();
        if (r106 == null) goto L30;
        return r106;
    L30:
        return new NetResponse(601, new EmptyByteReadStream(), -1, null, 8, null);
    L21:
        if ((!Intrinsics.areEqual(r101, 0L)) == false) goto L23;
        r102.throttleNetSpeed(((Number) r101).longValue());
        goto L23
    L9:
        if (r102.getDownloadId() == 0) goto L12;
        Logger.INSTANCE.d("JKL", "[恢复下载请求][SDK][" + r112 + ']');
        Downloader.getInstance(this.f509811a).resume(r102.getDownloadId());
        goto L24
    L5:
        r102 = null;
        goto L7
    }
}
