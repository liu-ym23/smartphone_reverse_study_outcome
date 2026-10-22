package j55;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.k0;
import com.bytedance.ee.bear.drive.biz.importfile.im.entity.ImportException;
import com.bytedance.ee.bear.drive.biz.importfile.request.error.ImportFailedType;
import com.bytedance.ee.bear.quoto.t;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        Throwable r7 = (Throwable) r6;
        tt5.a.f("ImImportFilePresenter", r7, false);
        if ((r7 instanceof NetService.ServerErrorException) == false) goto L14;
        NetService.ServerErrorException r3 = (NetService.ServerErrorException) r7;
        if (((t) org.koin.java.a.c(t.class, null, null, 6)).o(r3.getCode()) == false) goto L8;
        ImportFailedType r0 = ImportFailedType.FailedQuotaLimit;
    L23:
        if (TextUtils.isEmpty(((com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.d.class, null, null, 6)).f("", "CCM_EXPORT", k0.a(r7))) == true) goto L25;
        ((o55.b) this.a.a).Do(ImportFailedType.FailedDlpError, k0.a(r7));
        return;
    L25:
        ((o55.b) this.a.a).Do(r0, k0.a(r7));
        return;
    L8:
        if (com.bytedance.ee.bear.middleground.permission.b.c() == true) goto L10;
    L12:
        r0 = m55.a.a(r3.getCode());
        Intrinsics.checkNotNull(r0);
        goto L23
    L10:
        if (m55.a.b(r3.getCode()) == false) goto L12;
        r0 = ImportFailedType.FailedImportDriveFileEncrypted;
        goto L23
    L14:
        if ((r7 instanceof ImportException) == true) goto L16;
        r0 = ImportFailedType.FailedCanRetry;
        goto L23
    L16:
        if (com.bytedance.ee.bear.middleground.permission.b.c() == true) goto L18;
    L20:
        r0 = m55.a.a(((ImportException) r7).getJobStatus());
        Intrinsics.checkNotNull(r0);
        goto L23
    L18:
        if (m55.a.b(((ImportException) r7).getJobStatus()) == false) goto L20;
        r0 = ImportFailedType.FailedImportDriveFileEncrypted;
        goto L23
    }
}
