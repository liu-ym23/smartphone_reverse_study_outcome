package com.bytedance.locallife.live.goodsshelves.bean;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/LiveGoodsShelvesController;", "Ljava/io/Serializable;", "label", "", "(Ljava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class LiveGoodsShelvesController implements Serializable {
    private final String label;

    /* JADX WARN: Multi-variable type inference failed */
    public LiveGoodsShelvesController() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ LiveGoodsShelvesController copy$default(LiveGoodsShelvesController r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.label;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.label;
    }

    public final LiveGoodsShelvesController copy(String r100) {
        Intrinsics.checkNotNullParameter(r100, "label");
        return new LiveGoodsShelvesController(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LiveGoodsShelvesController) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.label, ((LiveGoodsShelvesController) r100).label) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.label.hashCode();
    }

    public String toString() {
        return "LiveGoodsShelvesController(label=" + this.label + ')';
    }

    public final String getLabel() {
        return this.label;
    }

    public LiveGoodsShelvesController(String r100) {
        Intrinsics.checkNotNullParameter(r100, "label");
        this.label = r100;
    }

    public /* synthetic */ LiveGoodsShelvesController(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = "";
    L5:
        this(r100);
    }
}
