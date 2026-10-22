package en8;

import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.RichMediaLayoutBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a extends jc8.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f473208i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f473209j;

    @Override // jc8.a
    public final int l() {
        return this.f473208i;
    }

    @Override // jc8.a
    public final boolean e(jc8.a r100) {
        if ((r100 instanceof a) == false) goto L16;
        BlockContent r101 = this.f498145a.getContent();
        RichMediaLayoutBlock r102 = null;
        if (r101 == null) goto L7;
        RichMediaLayoutBlock r103 = r101.getRichMediaLayoutBlock();
    L8:
        a r104 = (a) r100;
        BlockContent r105 = r104.f498145a.getContent();
        if (r105 == null) goto L12;
        r102 = r105.getRichMediaLayoutBlock();
    L12:
        if (Intrinsics.areEqual(r103, r102) == false) goto L16;
        if (this.f473209j != r104.f473209j) goto L16;
        return true;
    L7:
        r103 = null;
    L16:
        return false;
    }

    public a(Message r100, Block r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "block");
        super(r100, r101);
        this.f473208i = j.f302415g;
        this.f473209j = 1;
    }
}
