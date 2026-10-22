package ux4;

import android.content.Context;
import com.bytedance.ee.bear.doc.resupdate.f;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.util.ui.j;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSPath;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements f {
    public final /* synthetic */ d a;

    @Override // u45.a
    public final void onStart() {
        tt5.a.b("DownloadScmPresenter", "onStart");
        this.a.a = true;
        d r0 = this.a;
        r0.getClass();
        j.c(new b(r0, "下载中..."));
    }

    public c(d r1) {
        this.a = r1;
    }

    @Override // u45.a
    public final void a(int r5) {
        d r0 = this.a;
        if (r0.d == false) goto L5;
        j.c(new b(r0, "下载完整包..." + r5 + "%"));
        return;
    L5:
        j.c(new b(r0, "下载中..." + r5 + "%"));
    }

    @Override // u45.a
    public final void b(VFSPath r3) {
        tt5.a.b("DownloadScmPresenter", "onDownloadComplete");
        this.a.a = false;
        d r4 = this.a;
        r4.getClass();
        j.c(new a(r4));
        Context r5 = this.a.b;
        Toast.showSuccessText(r5, r5.getString(2131887648), 1);
    }

    @Override // u45.a
    public final void c(Exception r3) {
        Log.d(tt5.a.a("DownloadScmPresenter"), "onDownloadError", r3);
        this.a.a = false;
        d r4 = this.a;
        r4.getClass();
        j.c(new a(r4));
        Context r5 = this.a.b;
        Toast.showFailureText(r5, r5.getString(2131887258), 1);
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.f
    public final void d(String r3) {
        tt5.a.b("DownloadScmPresenter", "onStartDownloadFullRes, version: " + r3);
        d r4 = this.a;
        r4.d = true;
        j.c(new b(r4, "下载完整包..."));
    }
}
