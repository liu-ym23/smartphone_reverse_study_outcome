package j55;

import android.text.TextUtils;
import com.bytedance.ee.bear.drive.biz.importfile.im.entity.ImportResult;
import com.bytedance.ee.bear.drive.biz.importfile.request.error.ImportFailedType;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f497462a;

    public b(a r100) {
        this.f497462a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ImportResult.Detail r101 = (ImportResult.Detail) r100;
        tt5.a.h("ImImportFilePresenter", "im file import finish. status=" + r101.getJob_status() + " ,url=" + du5.b.k(r101.getUrl()));
        if (TextUtils.isEmpty(r101.getUrl()) == true) goto L18;
        ((o55.b) this.f497462a.f512352a).Cm(r101.getUrl());
        int r102 = r101.getExtraCode();
        switch(r102) {
            case 2000: goto L7;
            case 2001: goto L7;
            case 2002: goto L7;
            case 2003: goto L7;
            case 2004: goto L7;
            case 2005: goto L7;
            default: goto L26;
        };
    L7:
        o55.b r103 = (o55.b) this.f497462a.f512352a;
        int r104 = d.f497464a;
        switch(r102) {
            case 2000: goto L15;
            case 2001: goto L14;
            case 2002: goto L13;
            case 2003: goto L12;
            case 2004: goto L11;
            case 2005: goto L10;
            default: goto L9;
        };
    L9:
        String r105 = eu5.b.f474075a.getResources().getString(R.string.CreationMobile_import_failed_retry);
        Intrinsics.checkNotNull(r105);
    L16:
        r103.showToast(r105);
        return;
    L10:
        r105 = eu5.b.f474075a.getResources().getString(R.string.CreationMobile_Import_CelTextOverLimit);
        Intrinsics.checkNotNull(r105);
        goto L16
    L11:
        r105 = eu5.b.f474075a.getResources().getString(R.string.CreationMobile_Import_PictureFailed);
        Intrinsics.checkNotNull(r105);
        goto L16
    L12:
        r105 = eu5.b.f474075a.getResources().getString(R.string.CreationMobile_Import_StorageNotEnough);
        Intrinsics.checkNotNull(r105);
        goto L16
    L13:
        r105 = xo5.a.c(eu5.b.f474075a, R.string.CreationMobile_Import_OverLimitOfPicNumber, "number", "4000");
        Intrinsics.checkNotNull(r105);
        goto L16
    L14:
        r105 = xo5.a.c(eu5.b.f474075a, R.string.CreationMobile_Import_OverLimitOfWorkSheet, "number", "2000000");
        Intrinsics.checkNotNull(r105);
        goto L16
    L15:
        r105 = xo5.a.c(eu5.b.f474075a, R.string.CreationMobile_Import_OverLimitOfColumn, "number", "13000");
        Intrinsics.checkNotNull(r105);
        goto L16
    L26:
        return;
    L18:
        if (com.bytedance.ee.bear.middleground.permission.b.c() == true) goto L20;
    L22:
        ((o55.b) this.f497462a.f512352a).Do(m55.a.a(r101.getJob_status()), -1);
        return;
    L20:
        if (m55.a.b(r101.getJob_status()) == false) goto L22;
        ((o55.b) this.f497462a.f512352a).Do(ImportFailedType.FailedImportDriveFileEncrypted, -1);
    }
}
