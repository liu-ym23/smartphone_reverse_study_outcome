package com.bytedance.ee.bear.document.toolbar.file;

import bb5.j;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.fileselector.api.FileType;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SelectFilePlugin.a f222323a;

    public a(SelectFilePlugin.a r100) {
        this.f222323a = r100;
    }

    @Override // bb5.c
    public final void a(FileType r100) {
        Toast.showFailureText(SelectFilePlugin.access$100(this.f222323a.f222322b), R.string.CreationMobile_Upload_Error_File_TooLarge_Tips);
        tt5.a.k("SelectFilePlugin", "File length is over size.");
    }
}
