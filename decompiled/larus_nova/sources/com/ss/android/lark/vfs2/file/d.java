package com.ss.android.lark.vfs2.file;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d extends com.ss.android.lark.vfs2.a<d, a, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f444838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f444839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f444840c;

    public d() {
        String r100 = "";
        Intrinsics.checkNotNullParameter("", "path");
        Uri r101 = UriProtector.parse("");
        Intrinsics.checkNotNullParameter(r101, "uri");
        super(r101);
        this.f444838a = r101;
        String r102 = r101.getPath();
        if (r102 == null) goto L6;
        r100 = r102;
    L6:
        this.f444839b = r100;
        this.f444840c = LazyKt.lazy(new LocalFilePath$legacyFile$2(this));
    }
}
