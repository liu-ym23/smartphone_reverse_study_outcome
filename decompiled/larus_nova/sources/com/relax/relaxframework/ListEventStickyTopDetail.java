package com.relax.relaxframework;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/relax/relaxframework/ListEventStickyTopDetail;", "", "top", "", "(Ljava/lang/String;)V", "getTop", "()Ljava/lang/String;", "setTop", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ListEventStickyTopDetail {
    private String top;

    public final String getTop() {
        return this.top;
    }

    public ListEventStickyTopDetail(String r100) {
        Intrinsics.checkNotNullParameter(r100, "top");
        this.top = r100;
    }

    public final void setTop(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.top = r100;
    }
}
