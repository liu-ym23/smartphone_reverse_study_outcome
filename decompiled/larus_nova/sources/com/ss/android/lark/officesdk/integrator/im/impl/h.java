package com.ss.android.lark.officesdk.integrator.im.impl;

import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;

/* JADX INFO: loaded from: classes37.dex */
public final /* synthetic */ class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f433299a = null;

    static {
        int[] r100 = new int[FileAuthResultFrom.values().length];
        r100[FileAuthResultFrom.COME_FROM_AUTHZ.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
    L19:
        r100[FileAuthResultFrom.COME_FROM_DLP_CONTENT_DETECTING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
    L27:
        r100[FileAuthResultFrom.COME_FROM_DLP_CONTENT_SENSITIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
    L21:
        r100[FileAuthResultFrom.COME_FROM_FILE_POLICY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
    L23:
        r100[FileAuthResultFrom.COME_FROM_TT_BLOCK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
    L17:
        r100[FileAuthResultFrom.COME_FROM_UNKNOWN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
    L9:
        f433299a = r100;
    }
}
