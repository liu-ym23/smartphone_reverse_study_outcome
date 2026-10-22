package com.larus.network.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/network/utils/UrlConvertException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "url", "", "<init>", "(Ljava/lang/String;)V", "network_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlConvertException extends RuntimeException {
    public UrlConvertException(String r100) {
        super("convert error, url=" + r100);
    }
}
