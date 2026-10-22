package com.ss.android.lark.officesdk.minutes.service.fileupload;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class MmMinutesFileUploadSessionManager$buildUploadCallback$1 implements fub.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<String> f433721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MmMinutesFileUploadSessionManager f433722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f433723c;

    @Override // fub.b
    public final void a(fub.d r100) {
        Intrinsics.checkNotNullParameter(r100, "progress");
        String r101 = this.f433721a.invoke();
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        lvb.a.a(this.f433722b.f433696d, "uploadCallback.onProgress: taskId=" + this.f433723c + ", uploadTaskId=" + r101 + ", uploaded=" + r100.f478923a + ", total=" + r100.f478924b + ", percent=" + r100.f478925c);
        MmMinutesFileUploadSessionManager r103 = this.f433722b;
        r103.r("uploadCallback.onProgress", new MmMinutesFileUploadSessionManager$buildUploadCallback$1$onProgress$1(r103, this.f433723c, r101, r100, null));
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // fub.b
    public final void b(fub.e r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        String r101 = this.f433721a.invoke();
        boolean r102 = false;
        if (r101.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        return;
    L8:
        String r104 = this.f433722b.f433696d;
        StringBuilder r105 = new StringBuilder("uploadCallback.onSuccess: taskId=");
        r105.append(this.f433723c);
        r105.append(", uploadTaskId=");
        r105.append(r101);
        r105.append(", uploadedFileTokenEmpty=");
        if (r100.f478926a.length() != 0) goto L11;
        r102 = true;
    L11:
        r105.append(r102);
        lvb.a.e(r104, r105.toString());
        MmMinutesFileUploadSessionManager r106 = this.f433722b;
        r106.r("uploadCallback.onSuccess", new MmMinutesFileUploadSessionManager$buildUploadCallback$1$onSuccess$1(r106, this.f433723c, r101, r100, null));
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // fub.b
    public final void onError(int r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "message");
        String r100 = this.f433721a.invoke();
        lvb.a.a(this.f433722b.f433696d, "uploadCallback.onError: taskId=" + this.f433723c + ", uploadTaskId=" + r100 + ", code=" + r110 + ", message=" + r111);
        MmMinutesFileUploadSessionManager r101 = this.f433722b;
        r101.r("uploadCallback.onError", new MmMinutesFileUploadSessionManager$buildUploadCallback$1$onError$1(r101, this.f433723c, r100, r110, r111, null));
    }

    public MmMinutesFileUploadSessionManager$buildUploadCallback$1(Function0<String> r100, MmMinutesFileUploadSessionManager r101, String r102) {
        this.f433721a = r100;
        this.f433722b = r101;
        this.f433723c = r102;
    }
}
