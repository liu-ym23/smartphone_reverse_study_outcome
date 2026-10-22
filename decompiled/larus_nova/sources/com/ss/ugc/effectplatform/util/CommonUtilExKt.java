package com.ss.ugc.effectplatform.util;

import bytekn.foundation.io.file.ContentEncoding;

/* JADX INFO: loaded from: classes5.dex */
public final class CommonUtilExKt {
    public static final String a(byte[] r100, final ContentEncoding r101) {
        return new String(r100, new CommonUtilExKt$convertToEncoding$charset$1(r101).invoke());
    }
}
