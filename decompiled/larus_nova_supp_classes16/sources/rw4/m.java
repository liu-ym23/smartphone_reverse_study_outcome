package rw4;

import android.net.Uri;
import com.bytedance.ee.bear.document.export.dialog.BaseExportDialogFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m implements a {
    public final a a;

    @Override // rw4.a
    public final void onDismiss() {
        if (this.a == null) goto L6;
        com.bytedance.ee.util.ui.j.c(new i(this));
        return;
    }

    @Override // rw4.a
    public final void onExportStart() {
        if (this.a == null) goto L6;
        com.bytedance.ee.util.ui.j.c(new j(this));
        return;
    }

    @Override // rw4.a
    public final void onStartDownload() {
        if (this.a == null) goto L6;
        com.bytedance.ee.util.ui.j.c(new e(this));
        return;
    }

    @Override // rw4.a
    public final void onStartPolling() {
        if (this.a == null) goto L6;
        com.bytedance.ee.util.ui.j.c(new f(this));
        return;
    }

    public m(BaseExportDialogFragment r1) {
        this.a = r1;
    }

    @Override // rw4.a
    public final void onDownloading(final int r2) {
        if (this.a == null) goto L6;
        com.bytedance.ee.util.ui.j.c(new k(this, r2));
        return;
    }

    @Override // rw4.a
    public final void onPolling(final int r2) {
        if (this.a == null) goto L6;
        com.bytedance.ee.util.ui.j.c(new h(this, r2));
        return;
    }

    @Override // rw4.a
    public final void onSuccess(final Uri r2) {
        if (this.a == null) goto L6;
        com.bytedance.ee.util.ui.j.c(new l(this, r2));
        return;
    }

    @Override // rw4.a
    public final void onFail(final int r2, final Throwable r3) {
        if (this.a == null) goto L6;
        com.bytedance.ee.util.ui.j.c(new g(this, r2, r3));
        return;
    }
}
