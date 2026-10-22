package e85;

import b85.f0;
import com.bytedance.ee.bear.contract.drive.DriveCache;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.loader.download.IFileDownloadDependency;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.streaming.StreamingCache;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import i75.h;
import w75.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f<FM extends w75.a> extends a<FM> {
    @Override // e85.d
    public final FM b(DriveCache r6, w75.c<FM> r7) throws DriveException {
        String r0 = r7.getDetails().c().k;
        boolean r2 = true;
        if (h.i(r0) == false) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (this.d == true) goto L12;
    L19:
        r2 = false;
    L20:
        if (r2 == false) goto L22;
        return null;
    L22:
        if (((g85.b) this.c.getMimeTypeManager()).m(r7.B()) == true) goto L24;
        return null;
    L24:
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.drive.pdf_linearized_enable", false) == false) goto L44;
        StreamingCache r3 = (StreamingCache) GsonProtectorUtils.fromJson(new Gson(), r7.getExtra(), StreamingCache.class);
        if (r3 != null) goto L28;
    L34:
        DriveFilePath r8 = r6.b;
        if (r8 != null) goto L37;
    L39:
        r7.H();
        r7.k();
        return this.a;
    L37:
        if (z75.b.d(r8, this.f.b) == true) goto L39;
        tt5.a.h("SyncCacheFileHandler", "loadAsyncFileInfo() pdf error path");
        goto L39
    L28:
        if (r3.check(this.f) == false) goto L34;
        if (this.b.b == true) goto L32;
        tt5.a.h("SyncCacheFileHandler", "loadAsyncFileInfo() pdf is streaming cache, data=" + r3);
        r7.c(r3.getStreamingUrl());
        r7.j();
        r7.f(r3.getPreviewFileSize());
        goto L39
    L32:
        tt5.a.k("SyncCacheFileHandler", "loadAsyncFileInfo() pdf is streaming cache but in vc not usable");
        throw new DriveException(ErrCode.DEFAULT, "not support local cache");
    L44:
        return null;
    L12:
        if (r6.r == false) goto L19;
        f0 r4 = this.b;
        if (r4.b == true) goto L19;
        if (r4.c == true) goto L19;
        if (r1 == false) goto L19;
    L5:
        if (q75.b.a(r0) == true) goto L8;
        r1 = false;
        goto L10
    }

    public f(FM r1, f0 r2, IFileDownloadDependency r3, a95.a r4) {
        super(r1, r2, r3, r4);
    }
}
