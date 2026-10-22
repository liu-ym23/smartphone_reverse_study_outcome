package com.bytedance.android.shopping.store.hybrid.download;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends AbsDownloadListener {
    public final /* synthetic */ File a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ Function1 c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Context e;

    public final void a(Integer r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        Downloader.getInstance(this.e).removeSubThreadListener(r2.intValue(), this);
    }

    public final void onCanceled(DownloadInfo r4) {
        super.onCanceled(r4);
        if (r4 == null) goto L5;
        Integer r5 = Integer.valueOf(r4.getId());
    L6:
        a(r5);
        dm.a.a("ISVDownloadManager").b("download canceled, cdnUrl: " + this.d, null);
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void onPause(DownloadInfo r3) {
        super.onPause(r3);
        dm.a.a("ISVDownloadManager").b("download onPause, cdnUrl: " + this.d, null);
    }

    public final void onSuccessed(DownloadInfo r4) {
        super.onSuccessed(r4);
        if (this.a.exists() == false) goto L7;
        Function1 r0 = this.b;
        if (r0 == null) goto L10;
        Unit r1 = (Unit) r0.invoke(r4);
    L10:
        if (r4 == null) goto L12;
        Integer r5 = Integer.valueOf(r4.getId());
    L13:
        a(r5);
        return;
    L12:
        r5 = null;
        goto L13
    L7:
        Function1 r2 = this.c;
        if (r2 == null) goto L10;
        Unit r3 = (Unit) r2.invoke(new Throwable("downloader callback success, but file not exists"));
        goto L10
    }

    public final void onFailed(DownloadInfo r4, BaseException r5) {
        super.onFailed(r4, r5);
        Function1 r0 = this.c;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke(r5);
    L6:
        if (r4 == null) goto L8;
        Integer r6 = Integer.valueOf(r4.getId());
    L9:
        a(r6);
        dm.a.b r7 = dm.a.a("ISVDownloadManager");
        StringBuilder r2 = new StringBuilder("download onFailed,  ");
        if (r5 == null) goto L12;
        String r8 = r5.getMessage();
    L13:
        r2.append(r8);
        r2.append(", cdnUrl: ");
        r2.append(this.d);
        r7.b(r2.toString(), null);
        return;
    L12:
        r8 = null;
        goto L13
    L8:
        r6 = null;
        goto L9
    }

    public a(PolarisFileWrapper r1, Function1 r2, Function1 r3, String r4, Context r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
