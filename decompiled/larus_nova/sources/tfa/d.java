package tfa;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.obric.aiagent.assistant.idl.bean.OAppIntentBizContentType;
import ei9.f;
import kotlin.jvm.internal.Intrinsics;
import xc8.g;

/* JADX INFO: loaded from: classes5.dex */
public final class d implements g {
    @Override // xc8.g
    public final int c() {
        return 101;
    }

    public d() {
    }

    @Override // ei9.g
    public final boolean a(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        if (r101.getMessageStatus() != MessageStatus.MessageStatus_INVISIBLE) goto L6;
    L10:
        return false;
    L6:
        if (r101.getContentType() != 800) goto L10;
        if (Intrinsics.areEqual(r101.getBizContentType(), OAppIntentBizContentType.REMOTE_CARD) == false) goto L10;
        return true;
    }

    @Override // ei9.g
    public final f b(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        return new c(r101);
    }
}
