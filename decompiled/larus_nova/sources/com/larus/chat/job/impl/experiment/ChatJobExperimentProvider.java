package com.larus.chat.job.impl.experiment;

import com.larus.im.depend.IAIJobExperimentProvider;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/larus/chat/job/impl/experiment/ChatJobExperimentProvider;", "Lcom/larus/im/depend/IAIJobExperimentProvider;", "<init>", "()V", "isLarkEventEnabled", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatJobExperimentProvider implements IAIJobExperimentProvider {
    public ChatJobExperimentProvider() {
    }

    @Override // com.larus.im.depend.IAIJobExperimentProvider
    public final boolean a() {
        ChatJobLarkEventSettings.f325056a.getClass();
        return ChatJobLarkEventSettings.a();
    }
}
