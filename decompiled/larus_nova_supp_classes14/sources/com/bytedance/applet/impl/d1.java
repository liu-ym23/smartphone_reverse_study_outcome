package com.bytedance.applet.impl;

import android.content.Context;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostMediaDependV2;
import com.ss.bduploader.BDImageXUploader;
import com.ss.bduploader.BDVideoUploader;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d1 implements IHostMediaDependV2 {
    public BDImageXUploader a;
    public BDVideoUploader b;

    public d1() {
    }

    public final void closeImageXUpload() {
        BDImageXUploader r0 = this.a;
        if (r0 == null) goto L6;
        r0.close();
        return;
    }

    public final void closeVideoUpload() {
        BDVideoUploader r0 = this.b;
        if (r0 == null) goto L6;
        r0.close();
        return;
    }

    public final void startImageXUpload(Context r9, yd7.j.g r10, zd7.b0 r11, zd7.b r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "extra");
        Intrinsics.checkNotNullParameter(r12, "callback");
        BDImageXUploader r13 = new BDImageXUploader();
        boolean r2 = false;
        r13.setFilePath(r11.b().size(), (String[]) r11.b().toArray(new String[0]));
        r13.setUploadDomain(r10.getAuthConfig().getHostName());
        r13.setTopAccessKey(r10.getAuthConfig().getAccessKeyId());
        r13.setTopSecretKey(r10.getAuthConfig().getSecretAccessKey());
        r13.setTopSessionToken(r10.getAuthConfig().getSessionToken());
        r13.setServiceID(r10.getAuthConfig().getServiceId());
        yd7.j.f r0 = r10.getUploadConfig();
        String r1 = null;
        if (r0 == null) goto L5;
        Number r3 = r0.getSliceSize();
    L6:
        if (r3 == null) goto L12;
        yd7.j.f r4 = r10.getUploadConfig();
        if (r4 == null) goto L10;
        Number r5 = r4.getSliceSize();
    L11:
        Intrinsics.checkNotNull(r5);
        r13.setSliceSize(r5.intValue());
    L13:
        yd7.j.f r6 = r10.getUploadConfig();
        if (r6 == null) goto L16;
        Number r7 = r6.getSocketNum();
    L18:
        if (r7 == null) goto L24;
        yd7.j.f r8 = r10.getUploadConfig();
        if (r8 == null) goto L22;
        Number r14 = r8.getSocketNum();
    L23:
        Intrinsics.checkNotNull(r14);
        r13.setSocketNum(r14.intValue());
    L26:
        if (StringsKt.equals$default(r10.getMainNetworkType(), "ttnet", false, 2, null) == false) goto L29;
        r13.setNetworkType(403, 1);
        r13.setNetworkType(404, 0);
    L31:
        yd7.j.c r15 = r10.getEncryptionConfig();
        if (r15 == null) goto L38;
        Number r16 = r15.getOption();
        if (r16 == null) goto L38;
        if (Intrinsics.compare(r16.intValue(), 0) != 1) goto L38;
        r2 = true;
    L38:
        if (r2 == false) goto L62;
        yd7.j.c r17 = r10.getEncryptionConfig();
        if (r17 == null) goto L42;
        Number r18 = r17.getOption();
    L43:
        Intrinsics.checkNotNull(r18);
        r13.setEnableEnd2EndEncryption(r18.intValue());
        yd7.j.c r19 = r10.getEncryptionConfig();
        if (r19 == null) goto L46;
        String r20 = r19.getPublicKey();
    L47:
        if (r20 == null) goto L53;
        yd7.j.c r21 = r10.getEncryptionConfig();
        if (r21 == null) goto L51;
        String r22 = r21.getPublicKey();
    L52:
        r13.setEnd2EndEncryptionPublicKey(r22);
        goto L53
    L51:
        r22 = null;
    L53:
        yd7.j.c r23 = r10.getEncryptionConfig();
        if (r23 == null) goto L56;
        String r24 = r23.getAesKey();
    L57:
        if (r24 == null) goto L62;
        yd7.j.c r110 = r10.getEncryptionConfig();
        if (r110 == null) goto L61;
        r1 = r110.getAesKey();
    L61:
        r13.setEnd2EndEncryptionAESKey(r1);
        goto L62
    L56:
        r24 = null;
        goto L57
    L46:
        r20 = null;
        goto L47
    L42:
        r18 = null;
    L62:
        r13.setSliceRetryCount(3);
        r13.setFileRetryCount(3);
        r13.setTraceId(r11.a());
        Boolean r111 = r11.isBoeEnable();
        if (r111 == null) goto L65;
        r13.setOpenBoe(r111.booleanValue());
    L65:
        this.a = r13;
        Intrinsics.checkNotNull(r13);
        r13.setListener(new i2(r12, r13));
        BDImageXUploader r25 = this.a;
        if (r25 == null) goto L69;
        r25.start();
        return;
    L69:
        return;
    L29:
        if (StringsKt.equals$default(r10.getMainNetworkType(), "builtIn", false, 2, null) == false) goto L31;
        r13.setNetworkType(403, 0);
        r13.setNetworkType(404, 1);
        goto L31
    L22:
        r14 = null;
        goto L23
    L24:
        r13.setSocketNum(2);
        goto L26
    L16:
        r7 = null;
        goto L18
    L10:
        r5 = null;
        goto L11
    L12:
        r13.setSliceSize(524288);
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    public final void startVideoUpload(Context r3, yd7.k.f r4, zd7.e0 r5, zd7.c r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "extra");
        Intrinsics.checkNotNullParameter(r6, "callback");
        BDVideoUploader r7 = new BDVideoUploader();
        r7.setPathName(r5.b());
        r7.setUploadDomain(r4.getAuthConfig().getHostName());
        r7.setTopAccessKey(r4.getAuthConfig().getAccessKeyId());
        r7.setTopSecretKey(r4.getAuthConfig().getSecretAccessKey());
        r7.setTopSessionToken(r4.getAuthConfig().getSessionToken());
        r7.setSpaceName(r4.getAuthConfig().getSpaceName());
        yd7.k.d r0 = r4.getUploadConfig();
        Number r1 = null;
        if (r0 == null) goto L5;
        Number r2 = r0.getSliceSize();
    L6:
        if (r2 == null) goto L12;
        yd7.k.d r8 = r4.getUploadConfig();
        if (r8 == null) goto L10;
        Number r9 = r8.getSliceSize();
    L11:
        Intrinsics.checkNotNull(r9);
        r7.setSliceSize(r9.intValue());
    L13:
        yd7.k.d r10 = r4.getUploadConfig();
        if (r10 == null) goto L16;
        Number r11 = r10.getSocketNum();
    L17:
        if (r11 == null) goto L22;
        yd7.k.d r12 = r4.getUploadConfig();
        if (r12 == null) goto L21;
        r1 = r12.getSocketNum();
    L21:
        Intrinsics.checkNotNull(r1);
        r7.setSocketNum(r1.intValue());
    L23:
        r7.setSliceReTryCount(3);
        r7.setFileRetryCount(3);
        r7.setTraceId(r5.a());
        Boolean r13 = r5.isBoeEnable();
        if (r13 == null) goto L26;
        r7.setOpenBoe(r13.booleanValue());
    L26:
        this.b = r7;
        Intrinsics.checkNotNull(r7);
        r7.setListener(new j2(r6, r7));
        BDVideoUploader r14 = this.b;
        if (r14 == null) goto L30;
        r14.start();
        return;
    L30:
        return;
    L22:
        r7.setSocketNum(2);
        goto L23
    L16:
        r11 = null;
        goto L17
    L10:
        r9 = null;
        goto L11
    L12:
        r7.setSliceSize(524288);
        goto L13
    L5:
        r2 = null;
        goto L6
    }
}
