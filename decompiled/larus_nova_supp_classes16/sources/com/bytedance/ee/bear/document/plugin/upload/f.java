package com.bytedance.ee.bear.document.plugin.upload;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements DialogInterface.OnClickListener {
    public final /* synthetic */ OfficeDownloadPlugin a;
    public final /* synthetic */ tb5.m b;

    public f(OfficeDownloadPlugin r1, tb5.m r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        OfficeDownloadPlugin.access$cancelDownload(this.a, this.b);
    }
}
