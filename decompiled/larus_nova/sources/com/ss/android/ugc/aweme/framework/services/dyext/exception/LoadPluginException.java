package com.ss.android.ugc.aweme.framework.services.dyext.exception;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/framework/services/dyext/exception/LoadPluginException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorCode", "", "(I)V", "getErrorCode", "()I", "dy-ext-spi_release"}, k = 1, mv = {1, 1, 15})
public final class LoadPluginException extends Exception {
    private final int errorCode;

    public final int getErrorCode() {
        return this.errorCode;
    }

    public LoadPluginException(int r100) {
        this.errorCode = r100;
    }
}
