package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.BattleBarConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u000e\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001b\u0010\u0011\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\u001b\u0010\u0016\u001a\u00020\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleBarConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/IBattleBarConfig;", "", "leftColor$delegate", "Ljava/lang/Object;", "getLeftColor", "()Ljava/lang/String;", "leftColor", "rightColor$delegate", "getRightColor", "rightColor", "leftScoreViewColor$delegate", "getLeftScoreViewColor", "leftScoreViewColor", "rightScoreViewColor$delegate", "getRightScoreViewColor", "rightScoreViewColor", "Lcom/bytedance/android/livesdk/link/model/IAnimeInfoFlexImpl;", "animeInfo$delegate", "getAnimeInfo", "()Lcom/bytedance/android/livesdk/link/model/IAnimeInfoFlexImpl;", "animeInfo", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleBarConfigFlexImpl extends FlexModelBase<IBattleBarConfig> implements IBattleBarConfig, vh7.h {

    @SerializedName("anime_info")
    protected IAnimeInfoFlexImpl _$$animeInfo;

    @SerializedName("left_color")
    protected String _$$leftColor;

    @SerializedName("left_score_view_color")
    protected String _$$leftScoreViewColor;

    @SerializedName("right_color")
    protected String _$$rightColor;

    @SerializedName("right_score_view_color")
    protected String _$$rightScoreViewColor;

    public IBattleBarConfigFlexImpl() {
        super(IBattleBarConfig.class);
        this._$$leftColor = "";
        this._$$rightColor = "";
        this._$$leftScoreViewColor = "";
        this._$$rightScoreViewColor = "";
        this._$$animeInfo = $defaultValue_animeInfo$();
    }

    public IBattleBarConfigFlexImpl(am3.g r6) {
        super(IBattleBarConfig.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L21;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$leftColor = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$rightColor = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$leftScoreViewColor = am3.h.c(r6);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this._$$rightScoreViewColor = am3.h.c(r6);
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this._$$animeInfo = new IAnimeInfoFlexImpl(r6);
        goto L3
    L15:
        am3.h.d(r3, r6);
        goto L3
    L21:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$leftColor != null) goto L25;
        this._$$leftColor = "";
    L25:
        if (this._$$rightColor != null) goto L28;
        this._$$rightColor = "";
    L28:
        if (this._$$leftScoreViewColor != null) goto L31;
        this._$$leftScoreViewColor = "";
    L31:
        if (this._$$rightScoreViewColor != null) goto L34;
        this._$$rightScoreViewColor = "";
    L34:
        if (this._$$animeInfo != null) goto L55;
        this._$$animeInfo = $defaultValue_animeInfo$();
        return;
    }

    public final IAnimeInfoFlexImpl $defaultValue_animeInfo$() {
        return (IAnimeInfoFlexImpl) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(IAnimeInfoFlexImpl.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleBarConfig
    public /* bridge */ /* synthetic */ IAnimeInfo getAnimeInfo() {
        return getAnimeInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleBarConfig
    public final String getLeftColor() {
        return this._$$leftColor;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleBarConfig
    public final String getLeftScoreViewColor() {
        return this._$$leftScoreViewColor;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleBarConfig
    public final String getRightColor() {
        return this._$$rightColor;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleBarConfig
    public final String getRightScoreViewColor() {
        return this._$$rightScoreViewColor;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleBarConfig
    public final IAnimeInfoFlexImpl getAnimeInfo() {
        return this._$$animeInfo;
    }
}
