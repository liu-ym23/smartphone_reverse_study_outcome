package com.larus.extension.chat_extension.impl;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/extension/chat_extension/impl/GetRecommendVideosResponse;", "Ljava/io/Serializable;", "code", "", "msg", "", "data", "Lcom/larus/extension/chat_extension/impl/RecommendVideos;", "<init>", "(ILjava/lang/String;Lcom/larus/extension/chat_extension/impl/RecommendVideos;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getData", "()Lcom/larus/extension/chat_extension/impl/RecommendVideos;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetRecommendVideosResponse implements Serializable {
    private final int code;
    private final RecommendVideos data;
    private final String msg;

    public GetRecommendVideosResponse() {
        this(0, null, null, 7, null);
    }

    public final int getCode() {
        return this.code;
    }

    public final RecommendVideos getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public GetRecommendVideosResponse(int r100, String r101, RecommendVideos r102) {
        this.code = r100;
        this.msg = r101;
        this.data = r102;
    }

    public /* synthetic */ GetRecommendVideosResponse(int r100, String r101, RecommendVideos r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
