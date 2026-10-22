package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.BattleGetSettingsResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\r\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAnchorBattleSettingsFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/g;", "Lcom/bytedance/android/livesdk/link/model/IAnchorBattleUserSettingsFlexImpl;", "anchorBattleUserSettings$delegate", "Ljava/lang/Object;", "getAnchorBattleUserSettings", "()Lcom/bytedance/android/livesdk/link/model/IAnchorBattleUserSettingsFlexImpl;", "anchorBattleUserSettings", "Lcom/bytedance/android/livesdk/link/model/IAnchorPrecisionMatchSettingsFlexImpl;", "anchorPrecisionMatchSettings$delegate", "getAnchorPrecisionMatchSettings", "()Lcom/bytedance/android/livesdk/link/model/IAnchorPrecisionMatchSettingsFlexImpl;", "anchorPrecisionMatchSettings", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAnchorBattleSettingsFlexImpl extends FlexModelBase<g> implements g, vh7.h {

    @SerializedName("settings")
    protected IAnchorBattleUserSettingsFlexImpl _$$anchorBattleUserSettings;

    @SerializedName("precision_match_settings")
    protected IAnchorPrecisionMatchSettingsFlexImpl _$$anchorPrecisionMatchSettings;

    public IAnchorBattleSettingsFlexImpl() {
        super(g.class);
    }

    public IAnchorBattleSettingsFlexImpl(am3.g r6) {
        super(g.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$anchorBattleUserSettings = new IAnchorBattleUserSettingsFlexImpl(r6);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this._$$anchorPrecisionMatchSettings = new IAnchorPrecisionMatchSettingsFlexImpl(r6);
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.link.model.g
    public /* bridge */ /* synthetic */ h getAnchorBattleUserSettings() {
        return getAnchorBattleUserSettings();
    }

    @Override // com.bytedance.android.livesdk.link.model.g
    public /* bridge */ /* synthetic */ w getAnchorPrecisionMatchSettings() {
        return getAnchorPrecisionMatchSettings();
    }

    @Override // com.bytedance.android.livesdk.link.model.g
    public final IAnchorBattleUserSettingsFlexImpl getAnchorBattleUserSettings() {
        return this._$$anchorBattleUserSettings;
    }

    @Override // com.bytedance.android.livesdk.link.model.g
    public final IAnchorPrecisionMatchSettingsFlexImpl getAnchorPrecisionMatchSettings() {
        return this._$$anchorPrecisionMatchSettings;
    }
}
