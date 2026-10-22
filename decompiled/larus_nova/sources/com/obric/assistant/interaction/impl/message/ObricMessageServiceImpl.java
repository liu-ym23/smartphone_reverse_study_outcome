package com.obric.assistant.interaction.impl.message;

import com.larus.im.bean.message.Message;
import com.obric.assistant.spi.message.IObricMessageService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/assistant/interaction/impl/message/ObricMessageServiceImpl;", "Lcom/obric/assistant/spi/message/IObricMessageService;", "<init>", "()V", "isObricIntentMessage", "", "msg", "Lcom/larus/im/bean/message/Message;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMessageServiceImpl implements IObricMessageService {
    public ObricMessageServiceImpl() {
    }

    @Override // com.obric.assistant.spi.message.IObricMessageService
    public boolean isObricIntentMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Map<String, String> r101 = r100.getExt();
        if (r101 == null) goto L10;
        String r102 = r101.get("flow_app_variant");
        if (r102 != null) goto L7;
        return false;
    L7:
        if (StringsKt.startsWith$default(r102, "obric", false, 2, null) != true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }
}
