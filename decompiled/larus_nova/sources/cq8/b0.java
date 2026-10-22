package cq8;

import com.larus.bmhome.instruction.core.model.widget.PanelState;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b0 f464803d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f464804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<y0> f464805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PanelState f464806c;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r101 = (b0) r100;
        if (Intrinsics.areEqual(this.f464804a, r101.f464804a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464805b, r101.f464805b) == true) goto L15;
        return false;
    L15:
        if (this.f464806c == r101.f464806c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f464804a.hashCode() * 31) + this.f464805b.hashCode()) * 31) + this.f464806c.hashCode();
    }

    public final String toString() {
        return "InstructionWidgetRenderModel(panelId=" + this.f464804a + ", widgetEntries=" + this.f464805b + ", panelState=" + this.f464806c + ')';
    }

    static {
        f464803d = new b0("", CollectionsKt.emptyList(), PanelState.IDLE);
    }

    public b0(String r100, List<y0> r101, PanelState r102) {
        Intrinsics.checkNotNullParameter(r100, "panelId");
        Intrinsics.checkNotNullParameter(r101, "widgetEntries");
        Intrinsics.checkNotNullParameter(r102, "panelState");
        this.f464804a = r100;
        this.f464805b = r101;
        this.f464806c = r102;
    }
}
