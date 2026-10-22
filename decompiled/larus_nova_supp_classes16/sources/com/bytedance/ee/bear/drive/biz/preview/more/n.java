package com.bytedance.ee.bear.drive.biz.preview.more;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.k0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ b a;
    public final /* synthetic */ BaseOpenEntity b;
    public final /* synthetic */ com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d c;

    public n(b r1, BaseOpenEntity r2, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r12) {
        Throwable r13 = (Throwable) r12;
        w75.a r0 = this.a.b.b.getFileModel();
        if (r0 == null) goto L7;
        w75.b r1 = r0.c();
        if (r1 == null) goto L7;
        Long r2 = Long.valueOf(r1.c);
    L8:
        tt5.a.e("DriveComponent", "saveToSpace fileSize = " + r2 + ", error", r13, false);
        if (k0.c(r13) == true) goto L29;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L16;
        s55.a r3 = s55.a.a;
        if (s55.a.f(k0.a(r13), "UPLOAD", this.b.getFileId(), this.a.a) == false) goto L16;
        return;
    L16:
        String r4 = ((com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.d.class, null, null, 6)).f(this.a.b.a.getFileId(), "CCM_CREATE_COPY", k0.a(r13));
        if (TextUtils.isEmpty(r4) == true) goto L19;
        Toast.showFailureText(this.a.a, r4, 0);
        return;
    L19:
        int r5 = com.bytedance.ee.bear.drive.biz.preview.more.save2space.f.a;
        if (com.bytedance.ee.bear.drive.biz.preview.more.save2space.f.a.a(r13, this.a.a, r2, new a95.a()) == true) goto L22;
        FragmentActivity r14 = this.a.a;
        Toast.showFailureText(r14, r14.getResources().getString(2131888446), 0);
    L22:
        com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d r6 = this.c;
        if (r2 == null) goto L25;
        long r7 = r2.longValue();
    L26:
        com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d.a(r6, null, null, r7, 7);
        return;
    L25:
        r7 = 0;
        goto L26
    L29:
        return;
    L7:
        r2 = null;
        goto L8
    }
}
