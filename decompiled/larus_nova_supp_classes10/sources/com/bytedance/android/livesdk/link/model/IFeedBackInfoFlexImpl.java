package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.RecordResponse.BattleRecord.FeedbackInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IFeedBackInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/h4;", "", "feedbackId$delegate", "Ljava/lang/Object;", "getFeedbackId", "()Ljava/lang/Long;", "feedbackId", "updateTime$delegate", "getUpdateTime", "updateTime", "Lcom/bytedance/android/livesdk/link/model/IFeedBackQuestionFlexImpl;", "question$delegate", "getQuestion", "()Lcom/bytedance/android/livesdk/link/model/IFeedBackQuestionFlexImpl;", "question", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IFeedBackInfoFlexImpl extends FlexModelBase<h4> implements h4, vh7.h {

    @SerializedName("feedback_id")
    protected Long _$$feedbackId;

    @SerializedName("question")
    protected IFeedBackQuestionFlexImpl _$$question;

    @SerializedName("update_time")
    protected Long _$$updateTime;

    public IFeedBackInfoFlexImpl() {
        super(h4.class);
        this._$$question = $defaultValue_question$();
    }

    public final IFeedBackQuestionFlexImpl $defaultValue_question$() {
        return (IFeedBackQuestionFlexImpl) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(IFeedBackQuestionFlexImpl.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.h4
    public /* bridge */ /* synthetic */ j4 getQuestion() {
        return getQuestion();
    }

    @Override // com.bytedance.android.livesdk.link.model.h4
    public final Long getFeedbackId() {
        return this._$$feedbackId;
    }

    @Override // com.bytedance.android.livesdk.link.model.h4
    public final Long getUpdateTime() {
        return this._$$updateTime;
    }

    @Override // com.bytedance.android.livesdk.link.model.h4
    public final IFeedBackQuestionFlexImpl getQuestion() {
        return this._$$question;
    }

    public IFeedBackInfoFlexImpl(am3.g r6) {
        super(h4.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$feedbackId = Long.valueOf(r6.j());
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$question = new IFeedBackQuestionFlexImpl(r6);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this._$$updateTime = Long.valueOf(r6.j());
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$question != null) goto L31;
        this._$$question = $defaultValue_question$();
        return;
    }
}
