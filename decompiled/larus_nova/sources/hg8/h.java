package hg8;

import com.larus.bmhome.chat.list.cell.text.cells.base.CellComponentType;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class h implements xc8.g {
    @Override // xc8.g
    public final int c() {
        return 9;
    }

    public h() {
    }

    @Override // ei9.g
    public final boolean a(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "sourceData");
        return false;
    }

    @Override // ei9.g
    public final ei9.f b(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        return new g(r101, new com.larus.bmhome.chat.list.cell.text.cells.base.c(CellComponentType.BOTTOM_CELL_COMPONENT, 0, 0, 62));
    }
}
