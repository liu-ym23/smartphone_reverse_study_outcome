package he8;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e implements je8.a {
    public e() {
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
        return new d(r101);
    }
}
