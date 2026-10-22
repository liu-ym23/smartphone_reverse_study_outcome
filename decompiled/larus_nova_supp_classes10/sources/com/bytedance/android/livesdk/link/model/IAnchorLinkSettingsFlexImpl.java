package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.linkmic.GetSettingsResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\r\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAnchorLinkSettingsFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/o;", "Lcom/bytedance/android/livesdk/link/model/IAnchorLinkmicUserSettingsFlexImpl;", "anchorLinkmicUserSettings$delegate", "Ljava/lang/Object;", "getAnchorLinkmicUserSettings", "()Lcom/bytedance/android/livesdk/link/model/IAnchorLinkmicUserSettingsFlexImpl;", "anchorLinkmicUserSettings", "", "supportAiAssistantCellularEnhancement$delegate", "getSupportAiAssistantCellularEnhancement", "()Ljava/lang/Boolean;", "supportAiAssistantCellularEnhancement", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAnchorLinkSettingsFlexImpl extends FlexModelBase<o> implements o, vh7.h {

    @SerializedName("settings")
    protected IAnchorLinkmicUserSettingsFlexImpl _$$anchorLinkmicUserSettings;

    @SerializedName("support_ai_assistant")
    protected Boolean _$$supportAiAssistantCellularEnhancement;

    public IAnchorLinkSettingsFlexImpl() {
        super(o.class);
    }

    public IAnchorLinkSettingsFlexImpl(am3.g r6) {
        super(o.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$anchorLinkmicUserSettings = new IAnchorLinkmicUserSettingsFlexImpl(r6);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this._$$supportAiAssistantCellularEnhancement = Boolean.valueOf(am3.h.a(r6));
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.link.model.o
    public /* bridge */ /* synthetic */ u getAnchorLinkmicUserSettings() {
        return getAnchorLinkmicUserSettings();
    }

    @Override // com.bytedance.android.livesdk.link.model.o
    public final Boolean getSupportAiAssistantCellularEnhancement() {
        return this._$$supportAiAssistantCellularEnhancement;
    }

    @Override // com.bytedance.android.livesdk.link.model.o
    public final IAnchorLinkmicUserSettingsFlexImpl getAnchorLinkmicUserSettings() {
        return this._$$anchorLinkmicUserSettings;
    }
}
