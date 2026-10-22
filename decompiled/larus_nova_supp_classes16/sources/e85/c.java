package e85;

import android.text.TextUtils;
import b85.f0;
import com.bytedance.ee.bear.contract.drive.DriveCache;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.document.comment.bean.ShowCardsJsData;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.loader.download.IFileDownloadDependency;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.services.v;
import w75.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<FM extends w75.a> extends a<FM> {
    public final boolean g;

    @Override // e85.d
    public final FM b(DriveCache r5, w75.c<FM> r6) throws DriveException {
        if (this.g == true) goto L12;
        String r0 = r5.g;
        int r1 = v.a;
        if (TextUtils.equals("3", r0) == true) goto L7;
        boolean r7 = false;
    L8:
        if (r7 == true) goto L11;
        return null;
    L11:
        throw new DriveException(ErrCode.DEFAULT, "add preview fg close, local is cleared");
    L7:
        DriveFilePath.Companion.getClass();
        DriveFilePath r2 = DriveFilePath.a.a();
        t r3 = this.c.getCacheManager();
        String r4 = DriveFilePath.a.c(r2);
        a95.a r8 = this.f;
        r3.getClass();
        tt5.a.h("SyncCacheFileHandler", "clearSDKCache result=" + ((com.bytedance.ee.bear.drive.services.c) org.koin.java.a.a(com.bytedance.ee.bear.drive.services.c.class)).M9(r5, r4, r8.b));
        r5.g = ShowCardsJsData.ID_GLOBAL;
        r6.g(r2);
        r7 = true;
        goto L8
    L12:
        return null;
    }

    public c(FM r1, f0 r2, IFileDownloadDependency r3, a95.a r4) {
        super(r1, r2, r3, r4);
        this.g = false;
        this.g = com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.mobile.drive.add_preview_cache_enable");
    }
}
