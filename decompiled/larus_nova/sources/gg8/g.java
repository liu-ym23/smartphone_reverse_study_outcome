package gg8;

import com.larus.bmhome.chat.cell.ComponentCellStateType;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g extends com.larus.bmhome.chat.list.cell.text.cells.base.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Message f481220f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.larus.bmhome.chat.list.cell.text.cells.base.c f481221g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f481220f, r101.f481220f) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f481221g, r101.f481221g) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f481220f.hashCode() * 31) + this.f481221g.hashCode();
    }

    public final String toString() {
        return "TopTextCellState(message=" + this.f481220f + ", componentInfo=" + this.f481221g + ')';
    }

    @Override // xc8.b
    public final int d() {
        com.larus.bmhome.chat.bean.d.z0(this.f481220f);
        return 0;
    }

    @Override // xc8.b
    public final ComponentCellStateType f() {
        return ComponentCellStateType.TOP_TEXT_CELL;
    }

    @Override // xc8.b, wq8.a
    public final Message getMessage() {
        return this.f481220f;
    }

    @Override // com.larus.bmhome.chat.list.cell.text.cells.base.a
    public final com.larus.bmhome.chat.list.cell.text.cells.base.c i() {
        return this.f481221g;
    }

    @Override // xc8.b
    public final void h(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f481220f = r100;
    }

    public g(Message r100, com.larus.bmhome.chat.list.cell.text.cells.base.c r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "componentInfo");
        super(r100);
        this.f481220f = r100;
        this.f481221g = r101;
    }
}
