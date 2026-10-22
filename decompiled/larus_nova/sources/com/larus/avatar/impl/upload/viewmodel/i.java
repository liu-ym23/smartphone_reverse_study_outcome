package com.larus.avatar.impl.upload.viewmodel;

import android.net.Uri;
import com.larus.avatar.impl.upload.adapter.DigitalAvatarUploadItemStatus;
import ey9.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes23.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DigitalAvatarUploadItemStatus f291363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f291364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Deferred<Unit> f291365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Uri f291366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k f291367e;

    public i() {
        throw null;
    }

    public final void a(DigitalAvatarUploadItemStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f291363a = r100;
    }

    public i(DigitalAvatarUploadItemStatus r100, String r101, Uri r102, k r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = DigitalAvatarUploadItemStatus.UPLOADING;
    L6:
        if ((r104 & 16) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 32) == 0) goto L11;
        r103 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, "status");
        Intrinsics.checkNotNullParameter(r101, "pathKey");
        this.f291363a = r100;
        this.f291364b = r101;
        this.f291365c = null;
        this.f291366d = r102;
        this.f291367e = r103;
    }
}
