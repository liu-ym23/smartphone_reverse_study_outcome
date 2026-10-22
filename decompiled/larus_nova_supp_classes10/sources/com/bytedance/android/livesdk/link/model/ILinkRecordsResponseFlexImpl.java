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
@ProtoMessage("webcast.api.linkmic.AnchorLinkmicRecordsResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkRecordsResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/p5;", "", "Lcom/bytedance/android/livesdk/link/model/ILinkRecordFlexImpl;", "records$delegate", "Ljava/lang/Object;", "getRecords", "()Ljava/util/List;", "records", "", "nextQueryIndex$delegate", "getNextQueryIndex", "()Ljava/lang/String;", "nextQueryIndex", "", "hasMoreQueryResult$delegate", "getHasMoreQueryResult", "()Ljava/lang/Boolean;", "hasMoreQueryResult", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkRecordsResponseFlexImpl extends FlexModelBase<p5> implements p5, vh7.h {

    @SerializedName("has_more_record")
    protected Boolean _$$hasMoreQueryResult;

    @SerializedName("next_offset")
    protected String _$$nextQueryIndex;

    @SerializedName("records")
    protected List<ILinkRecordFlexImpl> _$$records;

    public ILinkRecordsResponseFlexImpl() {
        super(p5.class);
        this._$$records = $defaultValue_records$();
    }

    public ILinkRecordsResponseFlexImpl(am3.g r6) {
        super(p5.class);
        this._$$records = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$records.add(new ILinkRecordFlexImpl(r6));
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$nextQueryIndex = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this._$$hasMoreQueryResult = Boolean.valueOf(am3.h.a(r6));
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$records.isEmpty() == false) goto L31;
        this._$$records = $defaultValue_records$();
        return;
    }

    public final List<ILinkRecordFlexImpl> $defaultValue_records$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.link.model.p5
    public final Boolean getHasMoreQueryResult() {
        return this._$$hasMoreQueryResult;
    }

    @Override // com.bytedance.android.livesdk.link.model.p5
    public final String getNextQueryIndex() {
        return this._$$nextQueryIndex;
    }

    @Override // com.bytedance.android.livesdk.link.model.p5
    public final List<ILinkRecordFlexImpl> getRecords() {
        return this._$$records;
    }
}
