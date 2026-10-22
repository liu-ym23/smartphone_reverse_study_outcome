package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.RecordResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R#\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleRecordsResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/g2;", "Lcom/bytedance/android/livesdk/link/model/IBattleConsecutiveRecordInfoFlexImpl;", "battleConsecutiveRecordInfo$delegate", "Ljava/lang/Object;", "getBattleConsecutiveRecordInfo", "()Lcom/bytedance/android/livesdk/link/model/IBattleConsecutiveRecordInfoFlexImpl;", "battleConsecutiveRecordInfo", "", "Lcom/bytedance/android/livesdk/link/model/IBattleRecordFlexImpl;", "battleRecordList$delegate", "getBattleRecordList", "()Ljava/util/List;", "battleRecordList", "", "noRecordTip$delegate", "getNoRecordTip", "()Ljava/lang/String;", "noRecordTip", "", "offset$delegate", "getOffset", "()Ljava/lang/Long;", LayoutSizeLargeModeConfig.TYPE_SIZE_DP, "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleRecordsResponseFlexImpl extends FlexModelBase<g2> implements g2, vh7.h {

    @SerializedName("consecutive_record")
    protected IBattleConsecutiveRecordInfoFlexImpl _$$battleConsecutiveRecordInfo;

    @SerializedName("records")
    protected List<IBattleRecordFlexImpl> _$$battleRecordList;

    @SerializedName("no_record_tip")
    protected String _$$noRecordTip;

    @SerializedName(LayoutSizeLargeModeConfig.TYPE_SIZE_DP)
    protected Long _$$offset;

    public IBattleRecordsResponseFlexImpl() {
        super(g2.class);
        this._$$noRecordTip = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.g2
    public /* bridge */ /* synthetic */ x0 getBattleConsecutiveRecordInfo() {
        return getBattleConsecutiveRecordInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.g2
    public final List<IBattleRecordFlexImpl> getBattleRecordList() {
        return this._$$battleRecordList;
    }

    @Override // com.bytedance.android.livesdk.link.model.g2
    public final String getNoRecordTip() {
        return this._$$noRecordTip;
    }

    @Override // com.bytedance.android.livesdk.link.model.g2
    public final Long getOffset() {
        return this._$$offset;
    }

    @Override // com.bytedance.android.livesdk.link.model.g2
    public final IBattleConsecutiveRecordInfoFlexImpl getBattleConsecutiveRecordInfo() {
        return this._$$battleConsecutiveRecordInfo;
    }

    public IBattleRecordsResponseFlexImpl(am3.g r6) {
        super(g2.class);
        this._$$battleRecordList = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$battleConsecutiveRecordInfo = new IBattleConsecutiveRecordInfoFlexImpl(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$battleRecordList.add(new IBattleRecordFlexImpl(r6));
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$noRecordTip = am3.h.c(r6);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this._$$offset = Long.valueOf(r6.j());
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$noRecordTip != null) goto L37;
        this._$$noRecordTip = "";
        return;
    }
}
