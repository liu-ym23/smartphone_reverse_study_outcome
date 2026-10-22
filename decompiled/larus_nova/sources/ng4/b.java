package ng4;

import android.content.Context;
import com.bytedance.component.lyric_v2.core.LyricComponentManager$downloadCallback$1;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f519058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f519059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DownloadTask f519060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference<Context> f519061d;

    @Override // ng4.g
    public final boolean c() {
        return this.f519059b;
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f519061d = new WeakReference(r100);
    }

    @Override // ng4.g
    public final void b(l r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        this.f519059b = false;
        Integer r101 = this.f519058a;
        Context r102 = this.f519061d.get();
        if (r101 == null) goto L6;
        if (r102 == null) goto L6;
        int r103 = r101.intValue();
        ug4.b.a(new Object[]{"取消下载: " + r103});
        Downloader.getInstance(r102).cancel(r103);
    L6:
        this.f519060c = null;
    }

    @Override // ng4.g
    public final void a(l r100, LyricComponentManager$downloadCallback$1 r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "callback");
        b(r100);
        this.f519059b = true;
        Context r102 = this.f519061d.get();
        if (r102 == null) goto L5;
        this.f519060c = Downloader.with(r102).url(r100.f519074f).name(r100.f519076h).savePath(r100.f519075g).monitorScene("musicpack_lyrics").autoRemoveCallback(true).setCacheLifeTimeMax(1209600);
    L5:
        a r103 = new a(this, r100, r101);
        DownloadTask r104 = this.f519060c;
        if (r104 == null) goto L10;
        DownloadTask r105 = r104.subThreadListener(r103);
        if (r105 == null) goto L10;
        Integer r106 = Integer.valueOf(r105.download());
    L11:
        this.f519058a = r106;
        return;
    L10:
        r106 = null;
        goto L11
    }
}
