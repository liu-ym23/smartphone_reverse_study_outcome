package zf1;

import android.util.Pair;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f571624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DownloadTask f571625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Pair<String, String>> f571626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f571627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f571628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final zf1.a f571629f;

    public interface a {
    }

    public final void a() {
        this.f571627d++;
        DownloadTask r100 = Downloader.with(s1.getContext()).url((String) ((Pair) ListProtector.get(this.f571626c, this.f571627d)).first);
        String r101 = (String) ((Pair) ListProtector.get(this.f571626c, this.f571627d)).second;
        int r102 = r101.lastIndexOf(HTTP.URL_DEFAULT);
        String r103 = null;
        if (r102 == (-1)) goto L5;
        String r104 = r101.substring(r102 + 1);
    L6:
        DownloadTask r105 = r100.name(r104).monitorScene("live_anchor_backtrack");
        String r106 = (String) ((Pair) ListProtector.get(this.f571626c, this.f571627d)).second;
        int r107 = r106.lastIndexOf(HTTP.URL_DEFAULT);
        if (r107 == (-1)) goto L9;
        r103 = r106.substring(0, r107);
    L9:
        DownloadTask r108 = r105.savePath(r103);
        this.f571625b = r108;
        r108.mainThreadListener(this.f571629f);
        this.f571625b.download();
        return;
    L5:
        r104 = null;
        goto L6
    }

    public b(List r100, e0 r101) {
        this.f571626c = new ArrayList(r100);
        this.f571628e = r101;
        this.f571627d = -1;
        this.f571624a = false;
        this.f571629f = new zf1.a(this, r101);
    }
}
