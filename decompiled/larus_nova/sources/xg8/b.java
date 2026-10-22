package xg8;

import com.larus.bmhome.chat.layout.holder.progressloading.LoadingType;
import com.larus.bmhome.chat.layout.holder.progressloading.h;
import com.larus.im.bean.message.Message;
import ei9.f;
import kotlin.jvm.internal.Intrinsics;
import xc8.g;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements g {
    @Override // xc8.g
    public final int c() {
        return 16;
    }

    public b() {
    }

    @Override // ei9.g
    public final boolean a(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        if (h.a(r101) != LoadingType.TEXT_PROGRESS_LOADING) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // ei9.g
    public final f b(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        return new a(r101);
    }
}
