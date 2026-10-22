package com.obric.sva.sdk.network;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/obric/sva/sdk/network/Params;", "", "baseUrl", "", "relativePath", "queryMap", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getBaseUrl", "()Ljava/lang/String;", "getRelativePath", "getQueryMap", "()Ljava/util/Map;", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Params {
    private final String baseUrl;
    private final Map<String, String> queryMap;
    private final String relativePath;

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final Map<String, String> getQueryMap() {
        return this.queryMap;
    }

    public final String getRelativePath() {
        return this.relativePath;
    }

    public Params(String r100, String r101, Map<String, String> r102) {
        this.baseUrl = r100;
        this.relativePath = r101;
        this.queryMap = r102;
    }
}
