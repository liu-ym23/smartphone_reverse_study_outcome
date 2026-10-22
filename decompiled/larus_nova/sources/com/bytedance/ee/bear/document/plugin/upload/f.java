package com.bytedance.ee.bear.document.plugin.upload;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeDownloadPlugin f221029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ tb5.m f221030b;

    public f(OfficeDownloadPlugin r100, tb5.m r101) {
        this.f221029a = r100;
        this.f221030b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        OfficeDownloadPlugin.access$cancelDownload(this.f221029a, this.f221030b);
    }
}
