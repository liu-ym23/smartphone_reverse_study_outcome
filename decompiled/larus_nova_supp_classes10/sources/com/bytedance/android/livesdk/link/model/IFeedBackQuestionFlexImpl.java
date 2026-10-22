package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.RecordResponse.BattleRecord.FeedbackInfo.Question")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IFeedBackQuestionFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/j4;", "", "questionKey$delegate", "Ljava/lang/Object;", "getQuestionKey", "()Ljava/lang/String;", "questionKey", "questionText$delegate", "getQuestionText", "questionText", "", "type$delegate", "getType", "()J", LocationMonitorConst.TYPE, "", "Lcom/bytedance/android/livesdk/link/model/IFeedBackInfoOptionFlexImpl;", "options$delegate", "getOptions", "()Ljava/util/List;", "options", "questionId$delegate", "getQuestionId", "()Ljava/lang/Long;", "questionId", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IFeedBackQuestionFlexImpl extends FlexModelBase<j4> implements j4, vh7.h {

    @SerializedName("options")
    protected List<IFeedBackInfoOptionFlexImpl> _$$options;

    @SerializedName("question_id")
    protected Long _$$questionId;

    @SerializedName("question_key")
    protected String _$$questionKey;

    @SerializedName("question_text")
    protected String _$$questionText;

    @SerializedName(LocationMonitorConst.TYPE)
    protected long _$$type;

    public IFeedBackQuestionFlexImpl() {
        super(j4.class);
        this._$$options = $defaultValue_options$();
    }

    public final List<IFeedBackInfoOptionFlexImpl> $defaultValue_options$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.link.model.j4
    public final List<IFeedBackInfoOptionFlexImpl> getOptions() {
        return this._$$options;
    }

    @Override // com.bytedance.android.livesdk.link.model.j4
    public final Long getQuestionId() {
        return this._$$questionId;
    }

    @Override // com.bytedance.android.livesdk.link.model.j4
    public final String getQuestionKey() {
        return this._$$questionKey;
    }

    @Override // com.bytedance.android.livesdk.link.model.j4
    public final String getQuestionText() {
        return this._$$questionText;
    }

    @Override // com.bytedance.android.livesdk.link.model.j4
    public final long getType() {
        return this._$$type;
    }

    public IFeedBackQuestionFlexImpl(am3.g r6) {
        super(j4.class);
        this._$$options = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L21;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$questionKey = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$questionText = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$type = r6.j();
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this._$$options.add(new IFeedBackInfoOptionFlexImpl(r6));
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this._$$questionId = Long.valueOf(r6.j());
        goto L3
    L15:
        am3.h.d(r3, r6);
        goto L3
    L21:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$options.isEmpty() == false) goto L43;
        this._$$options = $defaultValue_options$();
        return;
    }
}
