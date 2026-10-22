package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.BattleReserveRecordResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0011\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IReserveRecordResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/p8;", "", "Lcom/bytedance/android/livesdk/link/model/IReserveRecordFlexImpl;", "recordList$delegate", "Ljava/lang/Object;", "getRecordList", "()Ljava/util/List;", "recordList", "", "nextOffSetId$delegate", "getNextOffSetId", "()Ljava/lang/String;", "nextOffSetId", "", "isEnd$delegate", "isEnd", "()Z", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IReserveRecordResponseFlexImpl extends FlexModelBase<p8> implements p8, vh7.h {

    @SerializedName("is_end")
    protected boolean _$$isEnd;

    @SerializedName("next_offset_id")
    protected String _$$nextOffSetId;

    @SerializedName("record_list")
    protected List<IReserveRecordFlexImpl> _$$recordList;

    public IReserveRecordResponseFlexImpl() {
        super(p8.class);
        this._$$recordList = $defaultValue_recordList$();
        this._$$nextOffSetId = "";
        this._$$isEnd = false;
    }

    public IReserveRecordResponseFlexImpl(am3.g r8) {
        super(p8.class);
        this._$$recordList = new ArrayList();
        setThreadSafe(false);
        long r1 = r8.c();
        boolean r3 = false;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L15;
        am3.g.a r5 = decodeExtensionFields(r4, r8);
        if (r4 != 1) goto L8;
        this._$$recordList.add(new IReserveRecordFlexImpl(r8));
        goto L3
    L8:
        if (r4 != 2) goto L10;
        this._$$nextOffSetId = am3.h.c(r8);
        goto L3
    L10:
        if (r4 != 3) goto L11;
        this._$$isEnd = am3.h.a(r8);
        r3 = r3 | true;
        goto L3
    L11:
        am3.h.d(r5, r8);
        goto L3
    L15:
        r8.d(r1);
        setThreadSafe(true);
        if (this._$$recordList.isEmpty() == false) goto L19;
        this._$$recordList = $defaultValue_recordList$();
    L19:
        if (this._$$nextOffSetId != null) goto L22;
        this._$$nextOffSetId = "";
    L22:
        if ((r3 & true) == true) goto L37;
        this._$$isEnd = false;
        return;
    }

    public final List<IReserveRecordFlexImpl> $defaultValue_recordList$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.link.model.p8
    public final String getNextOffSetId() {
        return this._$$nextOffSetId;
    }

    @Override // com.bytedance.android.livesdk.link.model.p8
    public final List<IReserveRecordFlexImpl> getRecordList() {
        return this._$$recordList;
    }

    @Override // com.bytedance.android.livesdk.link.model.p8
    public final boolean isEnd() {
        return this._$$isEnd;
    }
}
