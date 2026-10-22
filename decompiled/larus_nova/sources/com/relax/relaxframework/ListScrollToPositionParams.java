package com.relax.relaxframework;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/relax/relaxframework/ListScrollToPositionParams;", "", "smooth", "", "position", "", "alignTo", "", "offset", "", "(ZILjava/lang/String;Ljava/lang/Double;)V", "getAlignTo", "()Ljava/lang/String;", "setAlignTo", "(Ljava/lang/String;)V", "getOffset", "()Ljava/lang/Double;", "setOffset", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getPosition", "()I", "setPosition", "(I)V", "getSmooth", "()Z", "setSmooth", "(Z)V", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ListScrollToPositionParams {
    private String alignTo;
    private Double offset;
    private int position;
    private boolean smooth;

    public final String getAlignTo() {
        return this.alignTo;
    }

    public final Double getOffset() {
        return this.offset;
    }

    public final int getPosition() {
        return this.position;
    }

    public final boolean getSmooth() {
        return this.smooth;
    }

    public final void setAlignTo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.alignTo = r100;
    }

    public final void setOffset(Double r100) {
        this.offset = r100;
    }

    public final void setPosition(int r100) {
        this.position = r100;
    }

    public final void setSmooth(boolean r100) {
        this.smooth = r100;
    }

    public ListScrollToPositionParams(boolean r100, int r101, String r102, Double r103) {
        Intrinsics.checkNotNullParameter(r102, "alignTo");
        this.smooth = r100;
        this.position = r101;
        this.alignTo = r102;
        this.offset = r103;
    }

    public /* synthetic */ ListScrollToPositionParams(boolean r100, int r101, String r102, Double r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 8) == 0) goto L5;
        r103 = null;
    L5:
        this(r100, r101, r102, r103);
    }
}
