package e72;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f471159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DownloadTask f471160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Pair<String, String>> f471161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f471162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f471163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final InterfaceC5750b f471164f;

    public static final class a extends AbsDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f471165a;

        public a(b r100) {
            this.f471165a = r100;
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onProgress(DownloadInfo r100) {
            super.onProgress(r100);
            if (r100 == null) goto L6;
            int r101 = ((ArrayList) this.f471165a.f471161c).size();
            b r102 = this.f471165a;
            r102.f471164f.onProgress(((r102.f471162d * 100) / r101) + (r100.getDownloadProcess() / r101));
            return;
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onSuccessed(DownloadInfo r100) {
            super.onSuccessed(r100);
            b r101 = this.f471165a;
            boolean r102 = true;
            if (r101.f471162d == (((ArrayList) r101.f471161c).size() - 1)) goto L6;
            r102 = false;
        L6:
            if (r102 == false) goto L8;
            b r103 = this.f471165a;
            r103.f471164f.onSuccess(r103.f471161c);
            return;
        L8:
            this.f471165a.a();
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onFailed(DownloadInfo r100, BaseException r101) {
            super.onFailed(r100, r101);
            b r102 = this.f471165a;
            r102.f471164f.a(r102.f471161c, r101);
        }
    }

    /* JADX INFO: renamed from: e72.b$b, reason: collision with other inner class name */
    public interface InterfaceC5750b {
        void a(List<Pair<String, String>> r100, BaseException r101);

        void onProgress(int r100);

        void onSuccess(List<Pair<String, String>> r100);
    }

    public final void a() {
        this.f471162d++;
        DownloadTask r100 = Downloader.with(s1.getContext()).url((String) ((Pair) ListProtector.get(this.f471161c, this.f471162d)).getFirst());
        String r101 = (String) ((Pair) ListProtector.get(this.f471161c, this.f471162d)).getSecond();
        int r102 = StringsKt.lastIndexOf$default(r101, HTTP.URL_DEFAULT, 0, false, 6, null);
        String r103 = null;
        if (r102 == (-1)) goto L9;
        int r104 = r102 + 1;
        if (r101 == null) goto L8;
        String r105 = r101.substring(r104);
    L10:
        DownloadTask r106 = r100.name(r105).monitorScene("live_highlight_mark");
        String r107 = (String) ((Pair) ListProtector.get(this.f471161c, this.f471162d)).getSecond();
        int r108 = StringsKt.lastIndexOf$default(r107, HTTP.URL_DEFAULT, 0, false, 6, null);
        if (r108 == (-1)) goto L16;
        if (r107 == null) goto L15;
        r103 = r107.substring(0, r108);
        goto L16
    L15:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L16:
        DownloadTask r109 = r106.savePath(r103);
        this.f471160b = r109;
        if (r109 == null) goto L19;
        r109.mainThreadListener(this.f471163e);
    L19:
        DownloadTask r110 = this.f471160b;
        if (r110 == null) goto L23;
        r110.download();
        return;
    L23:
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L9:
        r105 = null;
        goto L10
    }

    public b(List<Pair<String, String>> r100, InterfaceC5750b r101) {
        Intrinsics.checkNotNullParameter(r100, "urlToPathMap");
        Intrinsics.checkNotNullParameter(r101, "mDownloadCallback");
        this.f471164f = r101;
        this.f471161c = new ArrayList(r100);
        this.f471162d = -1;
        this.f471163e = new a(this);
    }
}
