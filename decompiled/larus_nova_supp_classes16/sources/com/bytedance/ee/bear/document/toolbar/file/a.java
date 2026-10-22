package com.bytedance.ee.bear.document.toolbar.file;

import bb5.j;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.fileselector.api.FileType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends j {
    public final /* synthetic */ SelectFilePlugin.a a;

    public a(SelectFilePlugin.a r1) {
        this.a = r1;
    }

    @Override // bb5.c
    public final void a(FileType r2) {
        Toast.showFailureText(SelectFilePlugin.access$100(this.a.b), 2131887456);
        tt5.a.k("SelectFilePlugin", "File length is over size.");
    }
}
