package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.LinkerStats")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0012\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001b\u0010\u0015\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u001b\u0010\u001a\u001a\u00020\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkStatsMetaFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/s5;", "Lcom/bytedance/android/livesdk/link/model/e7;", "multiPKModeInfo", "Lcom/bytedance/android/livesdk/link/model/e7;", "getMultiPKModeInfo", "()Lcom/bytedance/android/livesdk/link/model/e7;", "setMultiPKModeInfo", "(Lcom/bytedance/android/livesdk/link/model/e7;)V", "", "battleDisplayEntrance$delegate", "Ljava/lang/Object;", "getBattleDisplayEntrance", "()Z", "battleDisplayEntrance", "forbidInviteByGeneral$delegate", "getForbidInviteByGeneral", "forbidInviteByGeneral", "forbidApplyFromOther$delegate", "getForbidApplyFromOther", "forbidApplyFromOther", "Lcom/bytedance/android/livesdk/link/model/ILinkmicUIConfigFlexImpl;", "uiConfig$delegate", "getUiConfig", "()Lcom/bytedance/android/livesdk/link/model/ILinkmicUIConfigFlexImpl;", "uiConfig", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkStatsMetaFlexImpl extends FlexModelBase<s5> implements s5, vh7.h {

    @SerializedName("battle_display_entrance")
    protected boolean _$$battleDisplayEntrance;

    @SerializedName("forbid_apply_from_other")
    protected boolean _$$forbidApplyFromOther;

    @SerializedName("forbid_invite_by_general")
    protected boolean _$$forbidInviteByGeneral;

    @SerializedName("ui_config")
    protected ILinkmicUIConfigFlexImpl _$$uiConfig;

    @SerializedName("multi_pk_mode_info")
    protected e7 multiPKModeInfo;

    public ILinkStatsMetaFlexImpl() {
        super(s5.class);
        this._$$battleDisplayEntrance = false;
        this._$$forbidInviteByGeneral = false;
        this._$$forbidApplyFromOther = false;
        this._$$uiConfig = $defaultValue_uiConfig$();
    }

    /* JADX WARN: Type inference failed for: r4v6, types: [com.bytedance.android.livesdk.link.model.e7, java.lang.Object] */
    public ILinkStatsMetaFlexImpl(am3.g r9) {
        super(s5.class);
        setThreadSafe(false);
        long r1 = r9.c();
        int r3 = 0;
    L3:
        int r4 = r9.f();
        if (r4 == (-1)) goto L20;
        am3.g.a r5 = decodeExtensionFields(r4, r9);
        if (r4 != 1) goto L8;
        this.multiPKModeInfo = vh7.f.a(r9, e7.class);
        goto L3
    L8:
        if (r4 != 2) goto L10;
        this._$$battleDisplayEntrance = am3.h.a(r9);
        r3 = r3 | 1;
        goto L3
    L10:
        if (r4 != 3) goto L11;
        this._$$forbidInviteByGeneral = am3.h.a(r9);
        r3 = r3 | 2;
        goto L3
    L11:
        if (r4 != 4) goto L13;
        this._$$forbidApplyFromOther = am3.h.a(r9);
        r3 = r3 | 4;
        goto L3
    L13:
        if (r4 != 6) goto L14;
        this._$$uiConfig = new ILinkmicUIConfigFlexImpl(r9);
        goto L3
    L14:
        am3.h.d(r5, r9);
        goto L3
    L20:
        r9.d(r1);
        setThreadSafe(true);
        if ((r3 & 1) != 0) goto L24;
        this._$$battleDisplayEntrance = false;
    L24:
        if ((r3 & 2) != 0) goto L27;
        this._$$forbidInviteByGeneral = false;
    L27:
        if ((r3 & 4) != 0) goto L30;
        this._$$forbidApplyFromOther = false;
    L30:
        if (this._$$uiConfig != null) goto L51;
        this._$$uiConfig = $defaultValue_uiConfig$();
        return;
    }

    public final ILinkmicUIConfigFlexImpl $defaultValue_uiConfig$() {
        return (ILinkmicUIConfigFlexImpl) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(ILinkmicUIConfigFlexImpl.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.s5
    public /* bridge */ /* synthetic */ t6 getUiConfig() {
        return getUiConfig();
    }

    @Override // com.bytedance.android.livesdk.link.model.s5
    public final boolean getBattleDisplayEntrance() {
        return this._$$battleDisplayEntrance;
    }

    @Override // com.bytedance.android.livesdk.link.model.s5
    public final boolean getForbidApplyFromOther() {
        return this._$$forbidApplyFromOther;
    }

    @Override // com.bytedance.android.livesdk.link.model.s5
    public final boolean getForbidInviteByGeneral() {
        return this._$$forbidInviteByGeneral;
    }

    @Override // com.bytedance.android.livesdk.link.model.s5
    public e7 getMultiPKModeInfo() {
        return this.multiPKModeInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.s5
    public final ILinkmicUIConfigFlexImpl getUiConfig() {
        return this._$$uiConfig;
    }

    public void setMultiPKModeInfo(e7 r1) {
        this.multiPKModeInfo = r1;
    }
}
