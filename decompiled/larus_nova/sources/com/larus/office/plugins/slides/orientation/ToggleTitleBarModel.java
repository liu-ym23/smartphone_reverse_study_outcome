package com.larus.office.plugins.slides.orientation;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/larus/office/plugins/slides/orientation/ToggleTitleBarModel;", "", "states", "", "<init>", "(Ljava/lang/Integer;)V", "getStates", "()Ljava/lang/Integer;", "setStates", "Ljava/lang/Integer;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ToggleTitleBarModel {

    @SerializedName("states")
    private Integer states;

    /* JADX WARN: Multi-variable type inference failed */
    public ToggleTitleBarModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final Integer getStates() {
        return this.states;
    }

    public ToggleTitleBarModel(Integer r100) {
        this.states = r100;
    }

    public final void setStates(Integer r100) {
        this.states = r100;
    }

    public /* synthetic */ ToggleTitleBarModel(Integer r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = Integer.valueOf(TitleBarStates.VISIBLE.getStates());
    L5:
        this(r100);
    }
}
