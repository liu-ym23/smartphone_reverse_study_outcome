package yg8;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;
import xc8.l;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements xc8.g {
    @Override // xc8.g
    public final int c() {
        return 13;
    }

    public g() {
    }

    @Override // ei9.g
    public final boolean a(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        if (r101.getContentType() != 1002) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // ei9.g
    public final ei9.f b(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        return new l(r101);
    }
}
