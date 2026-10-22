package hg8;

import com.larus.bmhome.chat.cell.ComponentCellStateType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.Reference;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class r extends com.larus.bmhome.chat.list.cell.text.cells.base.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Reference> f485029f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Message f485030g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.larus.bmhome.chat.list.cell.text.cells.base.c f485031h;

    public r() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f485029f, r101.f485029f) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f485030g, r101.f485030g) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f485031h, r101.f485031h) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        List<Reference> r100 = this.f485029f;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.f485030g.hashCode()) * 31) + this.f485031h.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "DeepThinkReferenceCellState(searchReference=" + this.f485029f + ", message=" + this.f485030g + ", componentInfo=" + this.f485031h + ')';
    }

    @Override // xc8.b
    public final int d() {
        com.larus.bmhome.chat.bean.d.z0(this.f485030g);
        return 0;
    }

    @Override // xc8.b
    public final ComponentCellStateType f() {
        return ComponentCellStateType.DEEP_THINK_REFERENCE_CELL;
    }

    @Override // xc8.b, wq8.a
    public final Message getMessage() {
        return this.f485030g;
    }

    @Override // com.larus.bmhome.chat.list.cell.text.cells.base.a
    public final com.larus.bmhome.chat.list.cell.text.cells.base.c i() {
        return this.f485031h;
    }

    @Override // xc8.b
    public final boolean b(wq8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "newItem");
        Integer r101 = null;
        if ((r100 instanceof r) == false) goto L5;
        r r102 = (r) r100;
    L6:
        if (r102 != null) goto L9;
    L20:
        return false;
    L9:
        if (Intrinsics.areEqual(this.f485030g.getMessageId(), r102.f485030g.getMessageId()) == false) goto L20;
        List<Reference> r103 = this.f485029f;
        if (r103 == null) goto L13;
        Integer r104 = Integer.valueOf(r103.size());
    L14:
        List<Reference> r105 = r102.f485029f;
        if (r105 == null) goto L18;
        r101 = Integer.valueOf(r105.size());
    L18:
        if (Intrinsics.areEqual(r104, r101) == false) goto L20;
        return true;
    L13:
        r104 = null;
        goto L14
    L5:
        r102 = null;
        goto L6
    }

    @Override // xc8.b
    public final void h(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f485030g = r100;
    }

    public r(Message r100, com.larus.bmhome.chat.list.cell.text.cells.base.c r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "componentInfo");
        super(r100);
        this.f485029f = null;
        this.f485030g = r100;
        this.f485031h = r101;
    }
}
