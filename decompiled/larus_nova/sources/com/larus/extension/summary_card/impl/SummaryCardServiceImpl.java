package com.larus.extension.summary_card.impl;

import com.larus.extension.summary_card.api.ISummaryCardService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ.\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J,\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0002¨\u0006\u001b"}, d2 = {"Lcom/larus/extension/summary_card/impl/SummaryCardServiceImpl;", "Lcom/larus/extension/summary_card/api/ISummaryCardService;", "<init>", "()V", "insertSummaryCard", "Lcom/larus/extension/summary_card/api/model/MessageOpResult;", "cvsId", "", "botId", "sectionId", "summaryCardData", "Lcom/larus/extension/summary_card/api/model/SummaryCardData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/extension/summary_card/api/model/SummaryCardData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSummaryCard", "summaryId", "summaryCardUpdateParam", "Lcom/larus/extension/summary_card/api/model/SummaryCardUpdateParam;", "removeCardOnFailure", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/extension/summary_card/api/model/SummaryCardUpdateParam;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildVideoSummaryContent", "buildSummaryCardMessageRequest", "Lcom/larus/im/bean/message/MessageRequest;", "deleteLocalMessageByLocalId", "", "localId", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SummaryCardServiceImpl implements ISummaryCardService {

    public static final class a {
    }

    static {
    }

    public SummaryCardServiceImpl() {
    }
}
