package com.bytedance.ee.bear.drive.biz.preview.more;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.SpaceFileDownloadManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ b a;
    public final /* synthetic */ a95.a b;

    public d(b r1, a95.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        b r9 = this.a;
        com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d r4 = new com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d(null);
        a95.a r5 = this.b;
        r9.getClass();
        FragmentActivity r1 = r9.a;
        e65.a r10 = r9.b;
        new SpaceFileDownloadManager(r1, r10.a, r10.b.getFileModel(), r4, r5).c();
    }
}
