package com.bytedance.applet.impl;

import com.ss.bduploader.BDImageXE2EEncryptionInfo;
import com.ss.bduploader.BDImageXInfo;
import com.ss.bduploader.BDImageXUploader;
import com.ss.bduploader.BDImageXUploaderListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i2 implements BDImageXUploaderListener {
    public final zd7.b a;
    public final BDImageXUploader b;

    public static final class a {
        public final String a;

        public a(BDImageXInfo r1) {
            if (r1 == null) goto L7;
            BDImageXE2EEncryptionInfo r2 = r1.mEnd2EndEncryption;
            if (r2 == null) goto L7;
            String r3 = r2.mAESKey;
        L8:
            this.a = r3;
            return;
        L7:
            r3 = null;
            goto L8
        }
    }

    public static final class b {
        public final String a;
        public final Integer b;
        public final String c;
        public final a d;

        public b(BDImageXInfo r3, a r4) {
            String r0 = null;
            if (r3 == null) goto L5;
            String r1 = r3.mImageTosKey;
        L6:
            this.a = r1;
            if (r3 == null) goto L9;
            Integer r2 = Integer.valueOf(r3.mFileIndex);
        L10:
            this.b = r2;
            if (r3 == null) goto L13;
            r0 = r3.mMetaInfo;
        L13:
            this.c = r0;
            this.d = r4;
            return;
        L9:
            r2 = null;
            goto L10
        L5:
            r1 = null;
            goto L6
        }
    }

    public final int imageXUploadCheckNetState(int r1, int r2) {
        return 0;
    }

    public final void onLog(int r1, int r2, String r3) {
    }

    public i2(zd7.b r2, BDImageXUploader r3) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        Intrinsics.checkNotNullParameter(r3, "uploader");
        this.a = r2;
        this.b = r3;
    }

    public final void onNotify(int r4, long r5, BDImageXInfo r7) {
        b r1 = new b(r7, new a(r7));
        String r0 = null;
        if (r4 != 0) goto L5;
        this.a.onComplete();     // Catch: Exception -> L39
        this.b.close();     // Catch: Exception -> L39
        return;
    L5:
        if (r4 != 1) goto L7;
        zd7.b r6 = this.a;     // Catch: Exception -> L39
        if (r7 == null) goto L35;
        Integer r2 = Integer.valueOf(r7.mFileIndex);     // Catch: Exception -> L39
    L36:
        r6.c(r2, r5);     // Catch: Exception -> L39
        return;
    L35:
        r2 = null;
        goto L36
    L7:
        if (r4 != 2) goto L9;
    L24:
        zd7.b r8 = this.a;     // Catch: Exception -> L39
        if (r7 == null) goto L27;
        Long r9 = Long.valueOf(r7.mErrorCode);     // Catch: Exception -> L39
    L28:
        if (r7 == null) goto L30;
        String r10 = r7.mMetaInfo;     // Catch: Exception -> L39
    L31:
        r8.e(r9, r10);     // Catch: Exception -> L39
        this.b.close();     // Catch: Exception -> L39
        return;
    L30:
        r10 = null;
        goto L31
    L27:
        r9 = null;
        goto L28
    L9:
        if (r4 != 3) goto L11;
        zd7.b r11 = this.a;     // Catch: Exception -> L39
        if (r7 == null) goto L19;
        Long r12 = Long.valueOf(r7.mErrorCode);     // Catch: Exception -> L39
    L20:
        if (r7 == null) goto L22;
        String r13 = r7.mMetaInfo;     // Catch: Exception -> L39
    L23:
        r11.a(r12, r13);     // Catch: Exception -> L39
        this.b.close();     // Catch: Exception -> L39
        return;
    L22:
        r13 = null;
        goto L23
    L19:
        r12 = null;
        goto L20
    L11:
        if (r4 != 6) goto L13;
        this.a.b(r1);     // Catch: Exception -> L39
        return;
    L13:
        if (r4 == 7) goto L24;
        return;
    L39:
        e = move-exception;
        zd7.b r14 = this.a;
        if (r7 == null) goto L43;
        Long r15 = Long.valueOf(r7.mErrorCode);
    L44:
        if (r7 == null) goto L46;
        r0 = r7.mMetaInfo;
    L46:
        r14.d(e, r15, r0);
        this.b.close();
        return;
    L43:
        r15 = null;
        goto L44
    }
}
