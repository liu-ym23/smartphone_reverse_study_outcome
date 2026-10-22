package com.bytedance.ee.docsdk.impl.model;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/model/DocContext;", "", "()V", "backPressHandler", "Lkotlin/Function0;", "", "getBackPressHandler", "()Lkotlin/jvm/functions/Function0;", "setBackPressHandler", "(Lkotlin/jvm/functions/Function0;)V", "docInfo", "Lcom/bytedance/ee/docsdk/impl/model/DocInfo;", "getDocInfo", "()Lcom/bytedance/ee/docsdk/impl/model/DocInfo;", "setDocInfo", "(Lcom/bytedance/ee/docsdk/impl/model/DocInfo;)V", "originUrl", "", "getOriginUrl", "()Ljava/lang/String;", "setOriginUrl", "(Ljava/lang/String;)V", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DocContext {
    private Function0<Boolean> backPressHandler;
    private DocInfo docInfo;
    private String originUrl;

    public DocContext() {
        this.docInfo = new DocInfo(null, null, null, null, null, null, null, null, null, 511, null);
        this.originUrl = "";
    }

    public final Function0<Boolean> getBackPressHandler() {
        return this.backPressHandler;
    }

    public final DocInfo getDocInfo() {
        return this.docInfo;
    }

    public final String getOriginUrl() {
        return this.originUrl;
    }

    public final void setBackPressHandler(Function0<Boolean> r1) {
        this.backPressHandler = r1;
    }

    public final void setDocInfo(DocInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.docInfo = r2;
    }

    public final void setOriginUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.originUrl = r2;
    }
}
