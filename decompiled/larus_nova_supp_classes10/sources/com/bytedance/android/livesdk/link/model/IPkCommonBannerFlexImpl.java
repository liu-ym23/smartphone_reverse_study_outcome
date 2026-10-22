package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.RivalsRecommendResponse.CommonBanner")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPkCommonBannerFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/v7;", "", "bannerInfo$delegate", "Ljava/lang/Object;", "getBannerInfo", "()Ljava/lang/String;", "bannerInfo", "bannerArea$delegate", "getBannerArea", "bannerArea", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IPkCommonBannerFlexImpl extends FlexModelBase<v7> implements v7, vh7.h {

    @SerializedName("banner_area")
    protected String _$$bannerArea;

    @SerializedName("banner_info")
    protected String _$$bannerInfo;

    public IPkCommonBannerFlexImpl() {
        super(v7.class);
        this._$$bannerInfo = "";
        this._$$bannerArea = "";
    }

    public IPkCommonBannerFlexImpl(am3.g r6) {
        super(v7.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$bannerInfo = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this._$$bannerArea = am3.h.c(r6);
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$bannerInfo != null) goto L16;
        this._$$bannerInfo = "";
    L16:
        if (this._$$bannerArea != null) goto L28;
        this._$$bannerArea = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.v7
    public final String getBannerArea() {
        return this._$$bannerArea;
    }

    @Override // com.bytedance.android.livesdk.link.model.v7
    public final String getBannerInfo() {
        return this._$$bannerInfo;
    }
}
