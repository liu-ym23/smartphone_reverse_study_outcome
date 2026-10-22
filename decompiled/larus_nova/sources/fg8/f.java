package fg8;

import com.larus.bmhome.chat.cell.ComponentCellStateType;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f extends com.larus.bmhome.chat.list.cell.text.cells.base.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Message f476903f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.larus.bmhome.chat.list.cell.text.cells.base.c f476904g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f476903f, r101.f476903f) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f476904g, r101.f476904g) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f476903f.hashCode() * 31) + this.f476904g.hashCode();
    }

    public final String toString() {
        return "MiddleTextCellState(message=" + this.f476903f + ", componentInfo=" + this.f476904g + ')';
    }

    @Override // xc8.b
    public final int d() {
        com.larus.bmhome.chat.bean.d.z0(this.f476903f);
        return 0;
    }

    @Override // xc8.b
    public final ComponentCellStateType f() {
        return ComponentCellStateType.MIDDLE_TEXT_CELL;
    }

    @Override // xc8.b, wq8.a
    public final Message getMessage() {
        return this.f476903f;
    }

    @Override // com.larus.bmhome.chat.list.cell.text.cells.base.a
    public final com.larus.bmhome.chat.list.cell.text.cells.base.c i() {
        return this.f476904g;
    }

    @Override // xc8.b
    public final boolean b(wq8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "newItem");
        if (com.larus.im.bean.message.a.f0(r100.getMessage()) == false) goto L20;
        boolean r101 = false;
        if ((r100 instanceof f) == false) goto L22;
        f r102 = (f) r100;
        if (com.larus.bmhome.chat.bean.d.f0(r102.f476903f) == true) goto L17;
        String r103 = com.larus.im.bean.message.a.K(r102.f476903f);
        if (r103 != null) goto L12;
    L13:
        r101 = true;
    L14:
        if (r101 == true) goto L17;
        return super.b(r100);
    L12:
        if (r103.length() != 0) goto L14;
    L17:
        return true;
    L22:
        return false;
    L20:
        return super.b(r100);
    }

    @Override // xc8.b
    public final void h(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f476903f = r100;
    }

    public f(Message r100, com.larus.bmhome.chat.list.cell.text.cells.base.c r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "componentInfo");
        super(r100);
        this.f476903f = r100;
        this.f476904g = r101;
    }
}
