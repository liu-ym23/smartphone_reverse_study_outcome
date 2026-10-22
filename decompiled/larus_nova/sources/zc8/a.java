package zc8;

import com.larus.bmhome.chat.bean.d;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a extends xc8.b {
    @Override // xc8.b
    public final int d() {
        return d.G0(this.f563233a) ? 1 : 0;
    }

    public a(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        super(r100);
    }
}
