package com.bytedance.jedi.arch;

import com.bytedance.jedi.arch.IReceiver;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00018\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/jedi/arch/ReceiverHolder;", "RECEIVER", "Lcom/bytedance/jedi/arch/IReceiver;", "", SocialConstants.PARAM_RECEIVER, "getReceiver", "()Lcom/bytedance/jedi/arch/IReceiver;", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface ReceiverHolder<RECEIVER extends IReceiver> {
    RECEIVER getReceiver();
}
