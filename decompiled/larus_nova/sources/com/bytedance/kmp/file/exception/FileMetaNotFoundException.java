package com.bytedance.kmp.file.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/kmp/file/exception/FileMetaNotFoundException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "path", "", "(Ljava/lang/String;)V", "kmpfile_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
public final class FileMetaNotFoundException extends Exception {
    public FileMetaNotFoundException(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        super("Kmpfile meta info not found " + r100);
    }
}
