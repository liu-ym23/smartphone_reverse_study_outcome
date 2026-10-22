package rw4;

import android.net.Uri;
import com.bytedance.ee.bear.document.export.dialog.BaseExportDialogFragment;

/* JADX INFO: loaded from: classes16.dex */
public final class m implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f539700a;

    @Override // rw4.a
    public final void onDismiss() {
        if (this.f539700a == null) goto L6;
        com.bytedance.ee.util.ui.j.c(new i(this));
        return;
    }

    @Override // rw4.a
    public final void onExportStart() {
        if (this.f539700a == null) goto L6;
        com.bytedance.ee.util.ui.j.c(new j(this));
        return;
    }

    @Override // rw4.a
    public final void onStartDownload() {
        if (this.f539700a == null) goto L6;
        com.bytedance.ee.util.ui.j.c(new e(this));
        return;
    }

    @Override // rw4.a
    public final void onStartPolling() {
        if (this.f539700a == null) goto L6;
        com.bytedance.ee.util.ui.j.c(new f(this));
        return;
    }

    public m(BaseExportDialogFragment r100) {
        this.f539700a = r100;
    }

    @Override // rw4.a
    public final void onDownloading(final int r100) {
        if (this.f539700a == null) goto L6;
        com.bytedance.ee.util.ui.j.c(new k(this, r100));
        return;
    }

    @Override // rw4.a
    public final void onPolling(final int r100) {
        if (this.f539700a == null) goto L6;
        com.bytedance.ee.util.ui.j.c(new h(this, r100));
        return;
    }

    @Override // rw4.a
    public final void onSuccess(final Uri r100) {
        if (this.f539700a == null) goto L6;
        com.bytedance.ee.util.ui.j.c(new l(this, r100));
        return;
    }

    @Override // rw4.a
    public final void onFail(final int r100, final Throwable r101) {
        if (this.f539700a == null) goto L6;
        com.bytedance.ee.util.ui.j.c(new g(this, r100, r101));
        return;
    }
}
