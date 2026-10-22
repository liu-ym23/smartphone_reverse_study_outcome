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
@ProtoMessage("webcast.api.battle.RecommendAreaActionResponse.Data")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R#\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IRecommendAreaActionResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/i8;", "", "action$delegate", "Ljava/lang/Object;", "getAction", "()I", "action", "", "Lcom/bytedance/android/livesdk/link/model/IPanelAreaFlexImpl;", "areas$delegate", "getAreas", "()Ljava/util/List;", "areas", "", "trackingInfo$delegate", "getTrackingInfo", "()Ljava/lang/String;", "trackingInfo", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IRecommendAreaActionResponseFlexImpl extends FlexModelBase<i8> implements i8, vh7.h {

    @SerializedName("client_action")
    protected int _$$action;

    @SerializedName("areas")
    protected List<IPanelAreaFlexImpl> _$$areas;

    @SerializedName("event_tracking_info")
    protected String _$$trackingInfo;

    public IRecommendAreaActionResponseFlexImpl() {
        super(i8.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.i8
    public final int getAction() {
        return this._$$action;
    }

    @Override // com.bytedance.android.livesdk.link.model.i8
    public final List<IPanelAreaFlexImpl> getAreas() {
        return this._$$areas;
    }

    @Override // com.bytedance.android.livesdk.link.model.i8
    public final String getTrackingInfo() {
        return this._$$trackingInfo;
    }

    public IRecommendAreaActionResponseFlexImpl(am3.g r6) {
        super(i8.class);
        this._$$areas = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$action = r6.i();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$areas.add(new IPanelAreaFlexImpl(r6));
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this._$$trackingInfo = am3.h.c(r6);
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
    }
}
