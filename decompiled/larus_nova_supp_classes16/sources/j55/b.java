package j55;

import android.text.TextUtils;
import com.bytedance.ee.bear.drive.biz.importfile.im.entity.ImportResult;
import com.bytedance.ee.bear.drive.biz.importfile.request.error.ImportFailedType;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        ImportResult.Detail r6 = (ImportResult.Detail) r5;
        tt5.a.h("ImImportFilePresenter", "im file import finish. status=" + r6.getJob_status() + " ,url=" + du5.b.k(r6.getUrl()));
        if (TextUtils.isEmpty(r6.getUrl()) == true) goto L18;
        ((o55.b) this.a.a).Cm(r6.getUrl());
        int r7 = r6.getExtraCode();
        switch(r7) {
            case 2000: goto L7;
            case 2001: goto L7;
            case 2002: goto L7;
            case 2003: goto L7;
            case 2004: goto L7;
            case 2005: goto L7;
            default: goto L26;
        };
    L7:
        o55.b r0 = (o55.b) this.a.a;
        int r1 = d.a;
        switch(r7) {
            case 2000: goto L15;
            case 2001: goto L14;
            case 2002: goto L13;
            case 2003: goto L12;
            case 2004: goto L11;
            case 2005: goto L10;
            default: goto L9;
        };
    L9:
        String r8 = eu5.b.a.getResources().getString(2131887555);
        Intrinsics.checkNotNull(r8);
    L16:
        r0.showToast(r8);
        return;
    L10:
        r8 = eu5.b.a.getResources().getString(2131887334);
        Intrinsics.checkNotNull(r8);
        goto L16
    L11:
        r8 = eu5.b.a.getResources().getString(2131887338);
        Intrinsics.checkNotNull(r8);
        goto L16
    L12:
        r8 = eu5.b.a.getResources().getString(2131887339);
        Intrinsics.checkNotNull(r8);
        goto L16
    L13:
        r8 = xo5.a.c(eu5.b.a, 2131887336, "number", "4000");
        Intrinsics.checkNotNull(r8);
        goto L16
    L14:
        r8 = xo5.a.c(eu5.b.a, 2131887337, "number", "2000000");
        Intrinsics.checkNotNull(r8);
        goto L16
    L15:
        r8 = xo5.a.c(eu5.b.a, 2131887335, "number", "13000");
        Intrinsics.checkNotNull(r8);
        goto L16
    L26:
        return;
    L18:
        if (com.bytedance.ee.bear.middleground.permission.b.c() == true) goto L20;
    L22:
        ((o55.b) this.a.a).Do(m55.a.a(r6.getJob_status()), -1);
        return;
    L20:
        if (m55.a.b(r6.getJob_status()) == false) goto L22;
        ((o55.b) this.a.a).Do(ImportFailedType.FailedImportDriveFileEncrypted, -1);
    }
}
