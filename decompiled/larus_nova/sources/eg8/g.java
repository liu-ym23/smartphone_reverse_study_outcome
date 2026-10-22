package eg8;

import com.larus.bmhome.chat.cell.ComponentCellStateType;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g extends com.larus.bmhome.chat.list.cell.text.cells.base.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Message f472613f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.larus.bmhome.chat.list.cell.text.cells.base.c f472614g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f472613f, r101.f472613f) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f472614g, r101.f472614g) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f472613f.hashCode() * 31) + this.f472614g.hashCode();
    }

    public final String toString() {
        return "BottomTextCellState(message=" + this.f472613f + ", componentInfo=" + this.f472614g + ')';
    }

    @Override // xc8.b
    public final int d() {
        com.larus.bmhome.chat.bean.d.z0(this.f472613f);
        return 0;
    }

    @Override // xc8.b
    public final ComponentCellStateType f() {
        return ComponentCellStateType.BOTTOM_TEXT_CELL;
    }

    @Override // xc8.b, wq8.a
    public final Message getMessage() {
        return this.f472613f;
    }

    @Override // com.larus.bmhome.chat.list.cell.text.cells.base.a
    public final com.larus.bmhome.chat.list.cell.text.cells.base.c i() {
        return this.f472614g;
    }

    @Override // xc8.b
    public final boolean b(wq8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "newItem");
        if (com.larus.im.bean.message.a.f0(r100.getMessage()) == false) goto L22;
        boolean r101 = false;
        if ((r100 instanceof g) == false) goto L24;
        g r102 = (g) r100;
        if (com.larus.bmhome.chat.bean.d.f0(r102.f472613f) == false) goto L10;
    L19:
        return true;
    L10:
        if (com.larus.bmhome.chat.bean.d.Q0(r102.f472613f) == true) goto L19;
        String r103 = com.larus.im.bean.message.a.K(r102.f472613f);
        if (r103 != null) goto L14;
    L15:
        r101 = true;
    L16:
        if (r101 == true) goto L19;
        return super.b(r100);
    L14:
        if (r103.length() != 0) goto L16;
    L24:
        return false;
    L22:
        return super.b(r100);
    }

    @Override // com.larus.bmhome.chat.list.cell.text.cells.base.a, xc8.b
    public final boolean c(wq8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "newItem");
        return super.c(r100);
    }

    @Override // xc8.b
    public final void h(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f472613f = r100;
    }

    public g(Message r100, com.larus.bmhome.chat.list.cell.text.cells.base.c r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "componentInfo");
        super(r100);
        this.f472613f = r100;
        this.f472614g = r101;
    }
}
