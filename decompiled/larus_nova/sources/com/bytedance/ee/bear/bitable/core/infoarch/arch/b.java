package com.bytedance.ee.bear.bitable.core.infoarch.arch;

import android.widget.ImageView;
import java.io.File;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements w85.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f210242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f210243b;

    @Override // w85.a.b
    public final void e(String r100) {
    }

    public b(String r100, ThemeBackgroundView r101) {
        this.f210242a = r100;
        this.f210243b = r101;
    }

    @Override // w85.a.b
    public final void c(String r100, w85.b r101) {
        if (r101 == null) goto L9;
        File r102 = r101.f558653b;
        if (r102 == null) goto L10;
        String r103 = r102.getAbsolutePath();
        if (r103 == null) goto L11;
        String r104 = this.f210242a;
        ImageView r105 = this.f210243b;
        int r106 = d.f210249a;
        com.bytedance.ee.util.ui.j.f(new c(r105, r103, r104));
        return;
    L11:
        return;
    L10:
        return;
    }

    @Override // w85.a.b
    public final void a(String r100, String r101, int r102) {
        tt5.a.d("BitableImageRender", "onDownloadFail, key = " + r101 + ", errorCode = " + r102);
    }
}
