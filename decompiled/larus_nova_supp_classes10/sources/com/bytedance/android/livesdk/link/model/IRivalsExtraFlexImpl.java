package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.RivalsRecommendResponse.RivalsExtra")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IRivalsExtraFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/u8;", "", "punishTip$delegate", "Ljava/lang/Object;", "getPunishTip", "()Ljava/lang/String;", "punishTip", "", "isHitPunish$delegate", "isHitPunish", "()Z", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IRivalsExtraFlexImpl extends FlexModelBase<u8> implements u8, vh7.h {

    @SerializedName("is_hit_anchor_punish")
    protected boolean _$$isHitPunish;

    @SerializedName("hit_punish_content")
    protected String _$$punishTip;

    public IRivalsExtraFlexImpl() {
        super(u8.class);
        this._$$isHitPunish = false;
    }

    public IRivalsExtraFlexImpl(am3.g r8) {
        super(u8.class);
        setThreadSafe(false);
        long r1 = r8.c();
        boolean r3 = false;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L12;
        am3.g.a r5 = decodeExtensionFields(r4, r8);
        if (r4 != 1) goto L8;
        this._$$isHitPunish = am3.h.a(r8);
        r3 = r3 | true;
        goto L3
    L8:
        if (r4 != 2) goto L9;
        this._$$punishTip = am3.h.c(r8);
        goto L3
    L9:
        am3.h.d(r5, r8);
        goto L3
    L12:
        r8.d(r1);
        setThreadSafe(true);
        if ((r3 & true) == true) goto L25;
        this._$$isHitPunish = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.u8
    public final String getPunishTip() {
        return this._$$punishTip;
    }

    @Override // com.bytedance.android.livesdk.link.model.u8
    public final boolean isHitPunish() {
        return this._$$isHitPunish;
    }
}
