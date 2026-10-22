package com.ss.android.lark.videosend.compress;

import android.text.TextUtils;
import com.ss.android.lark.videosend.tools.CompressPathManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f444926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f444927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f444928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f444929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f444930e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f444931f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f444932g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f444933h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f444934i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f444935j;

    public final String a() {
        if (TextUtils.isEmpty(this.f444929d) == false) goto L6;
        this.f444929d = CompressPathManager.generateCommonCompressFilePath(this.f444927b);
    L6:
        return this.f444929d;
    }

    public final String toString() {
        return "compressId=" + this.f444926a + ",originPath=" + this.f444927b + ",useCompressUpload=" + this.f444930e + ",cId=" + this.f444932g + ",isPre=" + this.f444933h;
    }

    public a(long r100, String r101, m r102) {
        Intrinsics.checkNotNullParameter(r101, "originPath");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f444926a = r100;
        this.f444927b = r101;
        this.f444928c = r102;
    }
}
