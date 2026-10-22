package hg8;

import com.larus.bmhome.chat.cell.ComponentCellStateType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextTagInfo;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g extends com.larus.bmhome.chat.list.cell.text.cells.base.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Message f485019f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.larus.bmhome.chat.list.cell.text.cells.base.c f485020g;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f485019f, r101.f485019f) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f485020g, r101.f485020g) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f485019f.hashCode() * 31) + this.f485020g.hashCode();
    }

    public final String toString() {
        return "DeepThinkContentCellState(message=" + this.f485019f + ", componentInfo=" + this.f485020g + ')';
    }

    @Override // xc8.b
    public final int d() {
        com.larus.bmhome.chat.bean.d.z0(this.f485019f);
        return 0;
    }

    @Override // xc8.b
    public final ComponentCellStateType f() {
        return ComponentCellStateType.DEEP_THINK_CONTENT_CELL;
    }

    @Override // xc8.b, wq8.a
    public final Message getMessage() {
        return this.f485019f;
    }

    @Override // com.larus.bmhome.chat.list.cell.text.cells.base.a
    public final com.larus.bmhome.chat.list.cell.text.cells.base.c i() {
        return this.f485020g;
    }

    @Override // xc8.b
    public final boolean b(wq8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "newItem");
        if ((r100 instanceof g) == false) goto L56;
        Object r101 = this.f485020g.f306026f.get("pipe_line_node");
        List<TextTagInfo> r102 = null;
        if ((r101 instanceof uvc.b) == false) goto L8;
        uvc.b r103 = (uvc.b) r101;
    L9:
        g r104 = (g) r100;
        Object r105 = r104.f485020g.f306026f.get("pipe_line_node");
        if ((r105 instanceof uvc.b) == false) goto L12;
        uvc.b r106 = (uvc.b) r105;
    L14:
        if (com.larus.bmhome.chat.bean.d.f0(r104.f485019f) == false) goto L28;
        List<com.larus.im.bean.message.c> r107 = com.larus.im.bean.message.a.S(this.f485019f);
        if (r107 == null) goto L20;
        com.larus.im.bean.message.c r108 = (com.larus.im.bean.message.c) CollectionsKt.firstOrNull(r107);
        if (r108 == null) goto L20;
        List<TextTagInfo> r109 = r108.c();
    L21:
        List<com.larus.im.bean.message.c> r110 = com.larus.im.bean.message.a.S(r104.f485019f);
        if (r110 == null) goto L53;
        com.larus.im.bean.message.c r111 = (com.larus.im.bean.message.c) CollectionsKt.firstOrNull(r110);
        if (r111 == null) goto L53;
        r102 = r111.c();
    L53:
        return Intrinsics.areEqual(r109, r102);
    L20:
        r109 = null;
        goto L21
    L28:
        if (com.larus.business.markdown.impl.widget.f.b(r103, r106) == false) goto L54;
        Message r112 = this.f485019f;
        Message r113 = r104.f485019f;
    L45:
        e = move-exception;
        FLogger.f375446a.e("DeepThinkContentCellState", "messageSame e=" + e.getMessage());
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e);
    L47:
        boolean r114 = false;
    L48:
        if (r114 == false) goto L55;
        return true;
    L55:
        return false;
    L31:
        if (r112.getContentType() != r113.getContentType()) goto L47;
        if (r112.getMessageStatus() != r113.getMessageStatus()) goto L47;
        if (r112.getMessageStatusLocal() != r113.getMessageStatusLocal()) goto L47;
        if (r112.getLocalIndex() != r113.getLocalIndex()) goto L47;
        if (r112.getServerIndex() != r113.getServerIndex()) goto L47;
        if (Intrinsics.areEqual(r112.getSectionId(), r113.getSectionId()) == false) goto L47;
        if (Intrinsics.areEqual(r112.getSectionName(), r113.getSectionName()) == false) goto L47;
        r114 = true;
        goto L48
    L54:
        return false;
    L12:
        r106 = null;
        goto L14
    L8:
        r103 = null;
        goto L9
    L56:
        return false;
    }

    @Override // xc8.b
    public final void h(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f485019f = r100;
    }

    public g(Message r100, com.larus.bmhome.chat.list.cell.text.cells.base.c r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "componentInfo");
        super(r100);
        this.f485019f = r100;
        this.f485020g = r101;
    }
}
