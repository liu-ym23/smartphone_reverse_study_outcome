package com.relax.relaxframework;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/relax/relaxframework/InputSelectionChangeEventDetail;", "", "start", "", "end", "direction", "", "(IILjava/lang/String;)V", "getDirection", "()Ljava/lang/String;", "setDirection", "(Ljava/lang/String;)V", "getEnd", "()I", "setEnd", "(I)V", "getStart", "setStart", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InputSelectionChangeEventDetail {
    private String direction;
    private int end;
    private int start;

    public final String getDirection() {
        return this.direction;
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getStart() {
        return this.start;
    }

    public final void setDirection(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.direction = r100;
    }

    public final void setEnd(int r100) {
        this.end = r100;
    }

    public final void setStart(int r100) {
        this.start = r100;
    }

    public InputSelectionChangeEventDetail(int r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "direction");
        this.start = r100;
        this.end = r101;
        this.direction = r102;
    }
}
