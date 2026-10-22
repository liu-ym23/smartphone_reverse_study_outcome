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
@ProtoMessage("webcast.api.battle.RivalsSearchResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR#\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IListRivalsSearchDataFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/u6;", "", "Lcom/bytedance/android/livesdk/link/model/IRivalsSearchAnchorInfoFlexImpl;", "anchorInfo$delegate", "Ljava/lang/Object;", "getAnchorInfo", "()Ljava/util/List;", "anchorInfo", "", "hasMore$delegate", "getHasMore", "()Z", "hasMore", "", "searchId$delegate", "getSearchId", "()Ljava/lang/String;", "searchId", "Lcom/bytedance/android/livesdk/link/model/IBattleActivityPKConfigFlexImpl;", "activityPKConfig$delegate", "getActivityPKConfig", "()Lcom/bytedance/android/livesdk/link/model/IBattleActivityPKConfigFlexImpl;", "activityPKConfig", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IListRivalsSearchDataFlexImpl extends FlexModelBase<u6> implements u6, vh7.h {

    @SerializedName("dynamic_conf")
    protected IBattleActivityPKConfigFlexImpl _$$activityPKConfig;

    @SerializedName("anchor_info_list")
    protected List<IRivalsSearchAnchorInfoFlexImpl> _$$anchorInfo;

    @SerializedName("has_more")
    protected boolean _$$hasMore;

    @SerializedName("search_id")
    protected String _$$searchId;

    public IListRivalsSearchDataFlexImpl() {
        super(u6.class);
        this._$$hasMore = false;
        this._$$searchId = "";
    }

    public IListRivalsSearchDataFlexImpl(am3.g r8) {
        super(u6.class);
        this._$$anchorInfo = new ArrayList();
        setThreadSafe(false);
        long r1 = r8.c();
        boolean r3 = false;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L18;
        am3.g.a r5 = decodeExtensionFields(r4, r8);
        if (r4 != 1) goto L8;
        this._$$anchorInfo.add(new IRivalsSearchAnchorInfoFlexImpl(r8));
        goto L3
    L8:
        if (r4 != 2) goto L10;
        this._$$hasMore = am3.h.a(r8);
        r3 = r3 | true;
        goto L3
    L10:
        if (r4 != 3) goto L12;
        this._$$searchId = am3.h.c(r8);
        goto L3
    L12:
        if (r4 != 4) goto L13;
        this._$$activityPKConfig = new IBattleActivityPKConfigFlexImpl(r8);
        goto L3
    L13:
        am3.h.d(r5, r8);
        goto L3
    L18:
        r8.d(r1);
        setThreadSafe(true);
        if ((r3 & true) == true) goto L22;
        this._$$hasMore = false;
    L22:
        if (this._$$searchId != null) goto L40;
        this._$$searchId = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.u6
    public /* bridge */ /* synthetic */ m0 getActivityPKConfig() {
        return getActivityPKConfig();
    }

    @Override // com.bytedance.android.livesdk.link.model.u6
    public final List<IRivalsSearchAnchorInfoFlexImpl> getAnchorInfo() {
        return this._$$anchorInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.u6
    public final boolean getHasMore() {
        return this._$$hasMore;
    }

    @Override // com.bytedance.android.livesdk.link.model.u6
    public final String getSearchId() {
        return this._$$searchId;
    }

    @Override // com.bytedance.android.livesdk.link.model.u6
    public final IBattleActivityPKConfigFlexImpl getActivityPKConfig() {
        return this._$$activityPKConfig;
    }
}
