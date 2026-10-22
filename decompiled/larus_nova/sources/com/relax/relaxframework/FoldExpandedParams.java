package com.relax.relaxframework;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/relax/relaxframework/FoldExpandedParams;", "", "offset", "", "smooth", "", "(Ljava/lang/String;Z)V", "getOffset", "()Ljava/lang/String;", "setOffset", "(Ljava/lang/String;)V", "getSmooth", "()Z", "setSmooth", "(Z)V", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FoldExpandedParams {
    private String offset;
    private boolean smooth;

    public final String getOffset() {
        return this.offset;
    }

    public final boolean getSmooth() {
        return this.smooth;
    }

    public final void setOffset(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.offset = r100;
    }

    public final void setSmooth(boolean r100) {
        this.smooth = r100;
    }

    public FoldExpandedParams(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "offset");
        this.offset = r100;
        this.smooth = r101;
    }
}
