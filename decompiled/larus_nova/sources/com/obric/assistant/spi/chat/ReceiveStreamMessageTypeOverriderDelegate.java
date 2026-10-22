package com.obric.assistant.spi.chat;

import com.larus.im.bean.message.Message;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0096\u0001¨\u0006\t"}, d2 = {"Lcom/obric/assistant/spi/chat/ReceiveStreamMessageTypeOverriderDelegate;", "Lcom/obric/assistant/spi/chat/IReceiveStreamMessageTypeOverrider;", "<init>", "()V", "overrideMessageType", "", "msg", "Lcom/larus/im/bean/message/Message;", "defaultType", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReceiveStreamMessageTypeOverriderDelegate implements IReceiveStreamMessageTypeOverrider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReceiveStreamMessageTypeOverriderDelegate f392862b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IReceiveStreamMessageTypeOverrider f392863a;

    static {
        f392862b = new ReceiveStreamMessageTypeOverriderDelegate();
    }

    @Override // com.obric.assistant.spi.chat.IReceiveStreamMessageTypeOverrider
    public final String a(Message r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        return this.f392863a.a(r100, r101);
    }

    private ReceiveStreamMessageTypeOverriderDelegate() {
        IReceiveStreamMessageTypeOverrider r100 = (IReceiveStreamMessageTypeOverrider) ServiceManager.get().getService(IReceiveStreamMessageTypeOverrider.class);
        if (r100 != null) goto L5;
        r100 = new DefaultReceiveStreamMessageTypeOverriderImpl();
    L5:
        this.f392863a = r100;
    }
}
