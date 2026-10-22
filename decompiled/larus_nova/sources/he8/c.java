package he8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.platform.spi.IAIChatService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c implements je8.a {
    public c() {
    }

    @Override // ei9.g
    public final boolean a(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        if (com.larus.im.bean.message.a.b0(r101) == true) goto L6;
    L13:
        return false;
    L6:
        if (r101.getMessageStatus() == MessageStatus.MessageStatus_INVISIBLE) goto L13;
        if (IAIChatService.f365899a.B7(r101) != null) goto L13;
        if (com.larus.bmhome.chat.bean.d.G0(r101) == true) goto L13;
        return true;
    }

    @Override // ei9.g
    public final ei9.f b(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        return new b(r101);
    }
}
