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
@ProtoMessage("webcast.data.BattleAnchorContributors")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R#\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleAnchorContributorsFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/o0;", "", "Lcom/bytedance/android/livesdk/link/model/IBattleRankUserFlexImpl;", "battleRankUserList$delegate", "Ljava/lang/Object;", "getBattleRankUserList", "()Ljava/util/List;", "battleRankUserList", "", "totalCount$delegate", "getTotalCount", "()J", "totalCount", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleAnchorContributorsFlexImpl extends FlexModelBase<o0> implements o0, vh7.h {

    @SerializedName("ranks")
    protected List<IBattleRankUserFlexImpl> _$$battleRankUserList;

    @SerializedName("total_count")
    protected long _$$totalCount;

    public IBattleAnchorContributorsFlexImpl() {
        super(o0.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.o0
    public final List<IBattleRankUserFlexImpl> getBattleRankUserList() {
        return this._$$battleRankUserList;
    }

    @Override // com.bytedance.android.livesdk.link.model.o0
    public final long getTotalCount() {
        return this._$$totalCount;
    }

    public IBattleAnchorContributorsFlexImpl(am3.g r6) {
        super(o0.class);
        this._$$battleRankUserList = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$battleRankUserList.add(new IBattleRankUserFlexImpl(r6));
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this._$$totalCount = r6.j();
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
    }
}
