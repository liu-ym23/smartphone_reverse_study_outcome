package ux4;

import android.content.Context;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.doc.resupdate.f;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSPath;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f551975a;

    @Override // u45.a
    public final void onStart() {
        tt5.a.b("DownloadScmPresenter", WidgetCostModule.TYPE_ON_START);
        this.f551975a.f551976a = true;
        d r100 = this.f551975a;
        r100.getClass();
        j.c(new b(r100, "下载中..."));
    }

    public c(d r100) {
        this.f551975a = r100;
    }

    @Override // u45.a
    public final void a(int r100) {
        d r101 = this.f551975a;
        if (r101.f551979d == false) goto L5;
        j.c(new b(r101, "下载完整包..." + r100 + GXTemplateKey.GAIAX_PE));
        return;
    L5:
        j.c(new b(r101, "下载中..." + r100 + GXTemplateKey.GAIAX_PE));
    }

    @Override // u45.a
    public final void b(VFSPath r100) {
        tt5.a.b("DownloadScmPresenter", "onDownloadComplete");
        this.f551975a.f551976a = false;
        d r101 = this.f551975a;
        r101.getClass();
        j.c(new a(r101));
        Context r102 = this.f551975a.f551977b;
        Toast.showSuccessText(r102, r102.getString(R.string.Doc_Debug_RestartApp), 1);
    }

    @Override // u45.a
    public final void c(Exception r100) {
        Log.d(tt5.a.a("DownloadScmPresenter"), "onDownloadError", r100);
        this.f551975a.f551976a = false;
        d r101 = this.f551975a;
        r101.getClass();
        j.c(new a(r101));
        Context r102 = this.f551975a.f551977b;
        Toast.showFailureText(r102, r102.getString(R.string.CreationMobile_ECM_DownloadUnableToast), 1);
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.f
    public final void d(String r100) {
        tt5.a.b("DownloadScmPresenter", "onStartDownloadFullRes, version: " + r100);
        d r101 = this.f551975a;
        r101.f551979d = true;
        j.c(new b(r101, "下载完整包..."));
    }
}
