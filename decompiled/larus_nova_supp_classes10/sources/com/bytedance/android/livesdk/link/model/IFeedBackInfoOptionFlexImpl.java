package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.RecordResponse.BattleRecord.FeedbackInfo.Option")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0013\u001a\u00020\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IFeedBackInfoOptionFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/i4;", "", "key$delegate", "Ljava/lang/Object;", "getKey", "()Ljava/lang/String;", "key", "text$delegate", "getText", "text", "", "tendency$delegate", "getTendency", "()I", "tendency", "", "isSelect$delegate", "isSelect", "()Z", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IFeedBackInfoOptionFlexImpl extends FlexModelBase<i4> implements i4, vh7.h {

    @SerializedName("is_select")
    protected boolean _$$isSelect;

    @SerializedName("key")
    protected String _$$key;

    @SerializedName("tendency")
    protected int _$$tendency;

    @SerializedName("text")
    protected String _$$text;

    public IFeedBackInfoOptionFlexImpl() {
        super(i4.class);
        this._$$isSelect = false;
    }

    @Override // com.bytedance.android.livesdk.link.model.i4
    public final String getKey() {
        return this._$$key;
    }

    @Override // com.bytedance.android.livesdk.link.model.i4
    public final int getTendency() {
        return this._$$tendency;
    }

    @Override // com.bytedance.android.livesdk.link.model.i4
    public final String getText() {
        return this._$$text;
    }

    @Override // com.bytedance.android.livesdk.link.model.i4
    public final boolean isSelect() {
        return this._$$isSelect;
    }

    public IFeedBackInfoOptionFlexImpl(am3.g r9) {
        super(i4.class);
        setThreadSafe(false);
        long r1 = r9.c();
        int r3 = 0;
    L3:
        int r4 = r9.f();
        if (r4 == (-1)) goto L17;
        am3.g.a r5 = decodeExtensionFields(r4, r9);
        if (r4 != 1) goto L7;
        this._$$key = am3.h.c(r9);
        goto L3
    L7:
        if (r4 != 2) goto L9;
        this._$$text = am3.h.c(r9);
        goto L3
    L9:
        if (r4 != 3) goto L11;
        this._$$tendency = r9.i();
        r3 = r3 | 1;
        goto L3
    L11:
        if (r4 != 4) goto L12;
        this._$$isSelect = am3.h.a(r9);
        r3 = r3 | 2;
        goto L3
    L12:
        am3.h.d(r5, r9);
        goto L3
    L17:
        r9.d(r1);
        setThreadSafe(true);
        if ((r3 & 2) != 0) goto L36;
        this._$$isSelect = false;
        return;
    }
}
