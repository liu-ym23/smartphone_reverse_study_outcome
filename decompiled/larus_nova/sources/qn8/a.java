package qn8;

import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a extends jc8.a {
    @Override // jc8.a
    public final boolean e(jc8.a r100) {
        return true;
    }

    @Override // jc8.a
    public final String g() {
        return "SpliteLineBlockBizModel";
    }

    @Override // jc8.a
    public final int l() {
        int r100 = j.f302403a;
        return j.f302434p0;
    }

    public a(Message r100, Block r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "block");
        super(r100, r101);
    }
}
