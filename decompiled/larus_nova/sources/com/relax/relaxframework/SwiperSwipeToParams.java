package com.relax.relaxframework;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/relax/relaxframework/SwiperSwipeToParams;", "", "index", "", "options", "Lcom/relax/relaxframework/SwiperToOptions;", "smooth", "", "(ILcom/relax/relaxframework/SwiperToOptions;Ljava/lang/Boolean;)V", "getIndex", "()I", "setIndex", "(I)V", "getOptions", "()Lcom/relax/relaxframework/SwiperToOptions;", "setOptions", "(Lcom/relax/relaxframework/SwiperToOptions;)V", "getSmooth", "()Ljava/lang/Boolean;", "setSmooth", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SwiperSwipeToParams {
    private int index;
    private SwiperToOptions options;
    private Boolean smooth;

    public final int getIndex() {
        return this.index;
    }

    public final SwiperToOptions getOptions() {
        return this.options;
    }

    public final Boolean getSmooth() {
        return this.smooth;
    }

    public final void setIndex(int r100) {
        this.index = r100;
    }

    public final void setOptions(SwiperToOptions r100) {
        this.options = r100;
    }

    public final void setSmooth(Boolean r100) {
        this.smooth = r100;
    }

    public SwiperSwipeToParams(int r100, SwiperToOptions r101, Boolean r102) {
        this.index = r100;
        this.options = r101;
        this.smooth = r102;
    }

    public /* synthetic */ SwiperSwipeToParams(int r100, SwiperToOptions r101, Boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102);
    }
}
