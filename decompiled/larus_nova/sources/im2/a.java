package im2;

import com.ss.android.lark.videosend.tools.VideoTools;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements amc.d, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f490454a;

    @Override // amc.d
    public final Map<String, String> a() {
        return MapsKt.hashMapOf(new Pair[]{TuplesKt.to(VideoTools.ERROR_TYPE_COMPRESS, DownloadHelper.GZIP)});
    }

    @Override // im2.b
    public final List<p> getInfo() {
        return CollectionsKt.listOf(this.f490454a.c());
    }

    public a() {
        this.f490454a = new o(DownloadHelper.GZIP);
    }

    @Override // amc.d
    public final byte[] b(tlc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "payloadItem");
        byte[] r101 = r100.f546764e;
        if (Intrinsics.areEqual(com.ss.ugc.live.sdk.msg.utils.h.a(r100), DownloadHelper.GZIP) == false) goto L6;
        GZIPInputStream r102 = new GZIPInputStream(new ByteArrayInputStream(r100.f546764e));
        return this.f490454a.b(r102, r100.f546764e.length);
    L6:
        return r101;
    }
}
