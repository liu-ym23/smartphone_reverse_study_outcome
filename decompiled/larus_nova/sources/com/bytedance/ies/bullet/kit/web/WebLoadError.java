package com.bytedance.ies.bullet.kit.web;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/WebLoadError;", "", "errorCode", "", "description", "", "failingUrl", "(ILjava/lang/CharSequence;Ljava/lang/CharSequence;)V", "getDescription", "()Ljava/lang/CharSequence;", "getErrorCode", "()I", "getFailingUrl", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class WebLoadError extends Throwable {
    private final CharSequence description;
    private final int errorCode;
    private final CharSequence failingUrl;

    public final CharSequence getDescription() {
        return this.description;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final CharSequence getFailingUrl() {
        return this.failingUrl;
    }

    public WebLoadError(int r100, CharSequence r101, CharSequence r102) {
        super("WebLoadError, errorCode: " + r100 + ", desc: " + r101 + ", failingUrl: " + r102);
        this.errorCode = r100;
        this.description = r101;
        this.failingUrl = r102;
    }

    public /* synthetic */ WebLoadError(int r100, CharSequence r101, CharSequence r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102);
    }
}
