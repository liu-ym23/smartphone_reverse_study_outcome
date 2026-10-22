package hg8;

import com.larus.bmhome.chat.cell.ComponentCellStateType;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class p extends com.larus.bmhome.chat.list.cell.text.cells.base.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f485023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f485024g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f485025h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f485026i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Message f485027j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.larus.bmhome.chat.list.cell.text.cells.base.c f485028k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (this.f485023f == r101.f485023f) goto L12;
        return false;
    L12:
        if (this.f485024g == r101.f485024g) goto L15;
        return false;
    L15:
        if (this.f485025h == r101.f485025h) goto L18;
        return false;
    L18:
        if (this.f485026i == r101.f485026i) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f485027j, r101.f485027j) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f485028k, r101.f485028k) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f485023f == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f485024g) * 31;
        if (this.f485025h == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f485026i == true) goto L15;
        r100 = 1237;
    L15:
        return ((((r104 + r100) * 31) + this.f485027j.hashCode()) * 31) + this.f485028k.hashCode();
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "DeepThinkHeaderTitleCellState(serverLoading=" + this.f485023f + ", referenceSize=" + this.f485024g + ", hideTopSearchReference=" + this.f485025h + ", isDeepThinkingTyping=" + this.f485026i + ", message=" + this.f485027j + ", componentInfo=" + this.f485028k + ')';
    }

    @Override // xc8.b
    public final int d() {
        com.larus.bmhome.chat.bean.d.z0(this.f485027j);
        return 0;
    }

    @Override // xc8.b
    public final ComponentCellStateType f() {
        return ComponentCellStateType.DEEP_THINK_HEADER_TITLE_CELL;
    }

    @Override // xc8.b, wq8.a
    public final Message getMessage() {
        return this.f485027j;
    }

    @Override // com.larus.bmhome.chat.list.cell.text.cells.base.a
    public final com.larus.bmhome.chat.list.cell.text.cells.base.c i() {
        return this.f485028k;
    }

    @Override // xc8.b
    public final boolean b(wq8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "newState");
        if ((r100 instanceof p) == true) goto L5;
        return false;
    L5:
        p r101 = (p) r100;
    L15:
        e = move-exception;
        FLogger.f375446a.e("DeepThinkContentCellState", "messageSame e=" + e.getMessage());
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e);
        return false;
    L7:
        if (this.f485026i == r101.f485026i) goto L9;
        return false;
    L9:
        if (this.f485023f == r101.f485023f) goto L11;
        return false;
    L11:
        if (this.f485025h != r101.f485025h) goto L22;
        if (this.f485024g != r101.f485024g) goto L23;
        return true;
    L23:
        return false;
    L22:
        return false;
    }

    @Override // xc8.b
    public final void h(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f485027j = r100;
    }

    public p(boolean r100, int r101, boolean r102, boolean r103, Message r104, com.larus.bmhome.chat.list.cell.text.cells.base.c r105) {
        Intrinsics.checkNotNullParameter(r104, "message");
        Intrinsics.checkNotNullParameter(r105, "componentInfo");
        super(r104);
        this.f485023f = r100;
        this.f485024g = r101;
        this.f485025h = r102;
        this.f485026i = r103;
        this.f485027j = r104;
        this.f485028k = r105;
    }
}
