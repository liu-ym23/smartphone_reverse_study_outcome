package p85;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.contract.drive.DriveCache;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.config.strategy.h;
import com.bytedance.ee.bear.drive.core.model.PreviewMeta;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.UrlSplicer;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.streaming.PDFStreamingDownloader;
import com.bytedance.ee.plugin.common.ttpdfreader.Range;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<T, R> implements Function {
    public final /* synthetic */ w75.a a;
    public final /* synthetic */ PreviewMeta b;
    public final /* synthetic */ a95.a c;

    public c(f85.a r1, PreviewMeta r2, a95.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object apply(Object r13) {
        Intrinsics.checkNotNullParameter((w75.a) r13, "it");
        String r2 = UrlSplicer.spliceV1PreviewUrl((f85.a) this.a);
        Application r14 = eu5.b.a;
        DriveFilePath r16 = t.h();
        r16.cacheName("2_" + ((f85.a.C0229a) ((f85.a) this.a).a).a + '_' + ((f85.a.C0229a) ((f85.a) this.a).a).p + ".pdf");
        MutableLiveData r9 = new MutableLiveData();
        String r1 = ((f85.a.C0229a) ((f85.a) this.a).a).a;
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNull(r16);
        long r4 = this.b.getPreviewFileSize();
        f85.a.C0229a r0 = (f85.a.C0229a) ((f85.a) this.a).a;
        PDFStreamingDownloader r11 = new PDFStreamingDownloader(r1, r2, r16, r4, r0.h, r0.p, r0.n, r9, this.c);
        String r3 = o75.b.a().Ic(h.class).i(this.a);
        t r5 = t.l();
        a95.a r6 = this.c;
        r5.getClass();
        DriveCache r7 = t.i(r3, false, r6);
        if (z75.b.d(r16, this.c.b) == false) goto L5;
        tt5.a.h("DriveStreamingPdfPreloader", "streamingFilePath already exists, ignore preload");
    L9:
        return Boolean.TRUE;
    L5:
        if (r7 == null) goto L7;
        tt5.a.h("DriveStreamingPdfPreloader", "cacheFileModel already exists, ignore preload");
        goto L9
    L7:
        long r8 = Math.min(200000, this.b.getPreviewFileSize() - 1);
        Range r17 = new Range(0, r8);
        Range r10 = new Range(Math.max(this.b.getPreviewFileSize() - r8, 0), this.b.getPreviewFileSize() - 1);
        ArrayList r12 = new ArrayList();
        r12.add(r17);
        r12.add(r10);
        tt5.a.h("DriveStreamingPdfPreloader", "request ranges=" + r12);
        r11.download(new b(r12), r12);
        goto L9
    }
}
