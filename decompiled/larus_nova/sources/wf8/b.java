package wf8;

import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import ei9.f;
import kotlin.jvm.internal.Intrinsics;
import xc8.g;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements g {
    @Override // xc8.g
    public final int c() {
        return 50;
    }

    public b() {
    }

    @Override // ei9.g
    public final boolean a(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        Integer r102 = b0.c(r101);
        if (r102 != null) goto L6;
    L8:
        return false;
    L6:
        if (r102.intValue() != 11) goto L8;
        return true;
    }

    @Override // ei9.g
    public final f b(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        return new a(r101);
    }
}
