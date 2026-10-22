package com.bytedance.applet.impl;

import com.ss.bduploader.BDVideoInfo;
import com.ss.bduploader.BDVideoUploader;
import com.ss.bduploader.BDVideoUploaderListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j2 implements BDVideoUploaderListener {
    public final zd7.c a;
    public final BDVideoUploader b;

    public static final class a {
        public final String a;
        public final String b;
        public final Long c;
        public final String d;
        public final String e;

        public a(BDVideoInfo r4) {
            String r0 = null;
            if (r4 == null) goto L5;
            String r1 = r4.mVideoId;
        L6:
            this.a = r1;
            if (r4 == null) goto L9;
            String r2 = r4.mCoverUri;
        L10:
            this.b = r2;
            if (r4 == null) goto L13;
            Long r3 = Long.valueOf(r4.mErrorCode);
        L14:
            this.c = r3;
            if (r4 == null) goto L17;
            String r5 = r4.mErrorMsg;
        L18:
            this.d = r5;
            if (r4 == null) goto L21;
            r0 = r4.mVideoMediaInfo;
        L21:
            this.e = r0;
            return;
        L17:
            r5 = null;
            goto L18
        L13:
            r3 = null;
            goto L14
        L9:
            r2 = null;
            goto L10
        L5:
            r1 = null;
            goto L6
        }
    }

    public final String getStringFromExtern(int r1) {
        return "";
    }

    public final void onLog(int r1, int r2, String r3) {
    }

    public final void onUploadVideoStage(int r1, long r2) {
    }

    public final int videoUploadCheckNetState(int r1, int r2) {
        return 0;
    }

    public j2(zd7.c r2, BDVideoUploader r3) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        Intrinsics.checkNotNullParameter(r3, "uploader");
        this.a = r2;
        this.b = r3;
    }

    public final void onNotify(int r2, long r3, BDVideoInfo r5) {
        a r0 = new a(r5);
        if (r2 != 0) goto L5;
        this.a.a(r0);     // Catch: Exception -> L16
        this.b.close();     // Catch: Exception -> L16
    L19:
        return;
    L5:
        if (r2 != 1) goto L7;
        this.a.d(r3);     // Catch: Exception -> L16
        goto L19
    L7:
        if (r2 != 2) goto L9;
        this.a.c(r0);     // Catch: Exception -> L16
        this.b.close();     // Catch: Exception -> L16
        goto L19
    L9:
        if (r2 != 3) goto L23;
        this.a.e(r0);     // Catch: Exception -> L16
        this.b.close();     // Catch: Exception -> L16
        goto L19
    L23:
        return;
    L16:
        e = move-exception;
        this.a.b(e, r0);
        this.b.close();
    }
}
