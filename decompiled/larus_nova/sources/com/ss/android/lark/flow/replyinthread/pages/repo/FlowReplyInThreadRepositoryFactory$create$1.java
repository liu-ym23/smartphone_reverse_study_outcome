package com.ss.android.lark.flow.replyinthread.pages.repo;

import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class FlowReplyInThreadRepositoryFactory$create$1 extends FunctionReferenceImpl implements Function0<ThreadTopic> {
    public FlowReplyInThreadRepositoryFactory$create$1(Object r100) {
        super(0, r100, MutableLiveData.class, "getValue", "getValue()Ljava/lang/Object;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    public final ThreadTopic invoke() {
        return (ThreadTopic) ((MutableLiveData) this.receiver).getValue();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ThreadTopic invoke() {
        return invoke();
    }
}
