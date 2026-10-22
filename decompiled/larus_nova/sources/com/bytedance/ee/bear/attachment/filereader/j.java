package com.bytedance.ee.bear.attachment.filereader;

import android.view.View;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.vfs.VFSPath;

/* JADX INFO: loaded from: classes15.dex */
public final class j implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileReaderActivity f206401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VFSPath f206402b;

    public j(FileReaderActivity r100, VFSPath r101) {
        this.f206401a = r100;
        this.f206402b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        FileReaderActivity r101 = this.f206401a;
        FileUtils.I(r101, this.f206402b, r101.f206376o);
        String r102 = x.f206422a;
        x.a.e("click_attachment_open", "2", "0");
    }
}
