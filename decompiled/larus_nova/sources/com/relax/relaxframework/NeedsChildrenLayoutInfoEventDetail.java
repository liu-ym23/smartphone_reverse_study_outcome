package com.relax.relaxframework;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u0007R*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/relax/relaxframework/NeedsChildrenLayoutInfoEventDetail;", "", "width", "Ljava/util/ArrayList;", "", "Lcom/bytedance/rts/foundation/RTSArray;", "height", "(Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getHeight", "()Ljava/util/ArrayList;", "setHeight", "(Ljava/util/ArrayList;)V", "getWidth", "setWidth", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NeedsChildrenLayoutInfoEventDetail {
    private ArrayList<Double> height;
    private ArrayList<Double> width;

    public final ArrayList<Double> getHeight() {
        return this.height;
    }

    public final ArrayList<Double> getWidth() {
        return this.width;
    }

    public final void setHeight(ArrayList<Double> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.height = r100;
    }

    public final void setWidth(ArrayList<Double> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.width = r100;
    }

    public NeedsChildrenLayoutInfoEventDetail(ArrayList<Double> r100, ArrayList<Double> r101) {
        Intrinsics.checkNotNullParameter(r100, "width");
        Intrinsics.checkNotNullParameter(r101, "height");
        this.width = r100;
        this.height = r101;
    }
}
