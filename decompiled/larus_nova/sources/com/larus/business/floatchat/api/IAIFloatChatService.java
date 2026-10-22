package com.larus.business.floatchat.api;

import android.content.Context;
import android.os.Bundle;
import com.larus.business.floatchat.impl.AIFloatChatFragment;
import com.larus.im.service.a;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0010\u0010\t\u001a\u0004\u0018\u00010\nH¦@¢\u0006\u0002\u0010\u000bJ&\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H¦@¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/business/floatchat/api/IAIFloatChatService;", "", "createAIFloatChatInputFragment", "Landroidx/fragment/app/Fragment;", "arguments", "Landroid/os/Bundle;", "getFloatChatBizCmdProcessors", "", "Lcom/larus/im/service/AbsBizCmdProcessor;", "getMainAIChatConversationInfo", "Lcom/larus/business/floatchat/api/AIChatConversationInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createNewAIChatConversationInfo", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "customSuffix", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAIFloatChatService {
    AIFloatChatFragment a(Bundle r100);

    Object b(Context r100, Continuation r101);

    List<a> c();
}
