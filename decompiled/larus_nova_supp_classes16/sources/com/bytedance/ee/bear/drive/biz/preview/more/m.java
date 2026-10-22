package com.bytedance.ee.bear.drive.biz.preview.more;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.drive.biz.preview.more.save2space.DriveSpaceFileAttachmentExecutor;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ b a;
    public final /* synthetic */ com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d b;

    public m(b r1, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r9) {
        DriveSpaceFileAttachmentExecutor.AttachSaveResponse r10 = (DriveSpaceFileAttachmentExecutor.AttachSaveResponse) r9;
        tt5.a.h("DriveComponent", "saveToSpace success");
        FragmentActivity r11 = this.a.a;
        Toast.showSuccessText(r11, r11.getResources().getString(2131888447), 0);
        com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d r2 = this.b;
        w75.a r12 = this.a.b.b.getFileModel();
        if (r12 == null) goto L7;
        w75.b r13 = r12.c();
        if (r13 == null) goto L7;
        long r0 = r13.c;
    L8:
        com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d.a(r2, null, null, r0, 7);
        return;
    L7:
        r0 = 0;
        goto L8
    }
}
