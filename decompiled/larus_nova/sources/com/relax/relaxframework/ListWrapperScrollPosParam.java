package com.relax.relaxframework;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/relax/relaxframework/ListWrapperScrollPosParam;", "", "smooth", "", "position", "", "offset", "", "align", "", "id", "(ZIDLjava/lang/String;Ljava/lang/String;)V", "getAlign", "()Ljava/lang/String;", "setAlign", "(Ljava/lang/String;)V", "getId", "setId", "getOffset", "()D", "setOffset", "(D)V", "getPosition", "()I", "setPosition", "(I)V", "getSmooth", "()Z", "setSmooth", "(Z)V", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ListWrapperScrollPosParam {
    private String align;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f404778id;
    private double offset;
    private int position;
    private boolean smooth;

    public final String getAlign() {
        return this.align;
    }

    public final String getId() {
        return this.f404778id;
    }

    public final double getOffset() {
        return this.offset;
    }

    public final int getPosition() {
        return this.position;
    }

    public final boolean getSmooth() {
        return this.smooth;
    }

    public final void setAlign(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.align = r100;
    }

    public final void setId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f404778id = r100;
    }

    public final void setOffset(double r100) {
        this.offset = r100;
    }

    public final void setPosition(int r100) {
        this.position = r100;
    }

    public final void setSmooth(boolean r100) {
        this.smooth = r100;
    }

    public ListWrapperScrollPosParam(boolean r100, int r101, double r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r103, "align");
        Intrinsics.checkNotNullParameter(r104, "id");
        this.smooth = r100;
        this.position = r101;
        this.offset = r102;
        this.align = r103;
        this.f404778id = r104;
    }
}
