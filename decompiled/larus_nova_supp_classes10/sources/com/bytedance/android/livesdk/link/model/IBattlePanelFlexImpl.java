package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.BattlePanel")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bI\u0010JR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00158VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010#\u001a\u0004\u0018\u00010\u001f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020$8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\f\u001a\u0004\b&\u0010'R\u001d\u0010+\u001a\u0004\u0018\u00010)8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\f\u001a\u0004\b+\u0010,R\u001b\u00101\u001a\u00020-8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\f\u001a\u0004\b/\u00100R\u001b\u00104\u001a\u00020-8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\f\u001a\u0004\b3\u00100R/\u0010<\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u0001058V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b7\u0010\f\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R/\u0010C\u001a\u0004\u0018\u00010=2\b\u00106\u001a\u0004\u0018\u00010=8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b>\u0010\f\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001d\u0010H\u001a\u0004\u0018\u00010D8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\f\u001a\u0004\bF\u0010G¨\u0006K"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattlePanelFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/b2;", "Lpy/k;", "backImg", "Lpy/k;", "getBackImg", "()Lpy/k;", "setBackImg", "(Lpy/k;)V", "Lcom/bytedance/android/livesdk/link/model/IPanelTitleFlexImpl;", "title$delegate", "Ljava/lang/Object;", "getTitle", "()Lcom/bytedance/android/livesdk/link/model/IPanelTitleFlexImpl;", "title", "Lcom/bytedance/android/livesdk/link/model/IPanelBtnFlexImpl;", "button$delegate", "getButton", "()Lcom/bytedance/android/livesdk/link/model/IPanelBtnFlexImpl;", "button", "", "selfDataIndex$delegate", "getSelfDataIndex", "()J", "selfDataIndex", "Lcom/bytedance/android/livesdk/link/model/IBattleSelfDataFlexImpl;", "selfData$delegate", "getSelfData", "()Lcom/bytedance/android/livesdk/link/model/IBattleSelfDataFlexImpl;", "selfData", "Lcom/bytedance/android/livesdk/link/model/IBattleShellConfigExtensionImpl;", "shellConfig$delegate", "getShellConfig", "()Lcom/bytedance/android/livesdk/link/model/IBattleShellConfigExtensionImpl;", "shellConfig", "", "battlePanelType$delegate", "getBattlePanelType", "()I", "battlePanelType", "", "isForbidden$delegate", "isForbidden", "()Ljava/lang/Boolean;", "", "forbiddenText$delegate", "getForbiddenText", "()Ljava/lang/String;", "forbiddenText", "tagText$delegate", "getTagText", "tagText", "Lcom/bytedance/android/livesdk/link/model/h9;", "<set-?>", "specifyGiftConfig$delegate", "getSpecifyGiftConfig", "()Lcom/bytedance/android/livesdk/link/model/h9;", "setSpecifyGiftConfig", "(Lcom/bytedance/android/livesdk/link/model/h9;)V", "specifyGiftConfig", "Lcom/bytedance/android/livesdk/link/model/d4;", "customConfig$delegate", "getCustomConfig", "()Lcom/bytedance/android/livesdk/link/model/d4;", "setCustomConfig", "(Lcom/bytedance/android/livesdk/link/model/d4;)V", "customConfig", "Lcom/bytedance/android/livesdk/link/model/IProfitGameConfigFlexImpl;", "gameConfig$delegate", "getGameConfig", "()Lcom/bytedance/android/livesdk/link/model/IProfitGameConfigFlexImpl;", "gameConfig", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattlePanelFlexImpl extends FlexModelBase<b2> implements b2, vh7.h {

    @SerializedName("battle_panel_type")
    protected int _$$battlePanelType;

    @SerializedName("panel_btn")
    protected IPanelBtnFlexImpl _$$button;

    @SerializedName("custom_config")
    protected d4 _$$customConfig;

    @SerializedName("forbidden_text")
    protected String _$$forbiddenText;

    @SerializedName("game_config")
    protected IProfitGameConfigFlexImpl _$$gameConfig;

    @SerializedName("is_forbidden")
    protected Boolean _$$isForbidden;

    @SerializedName("self_data")
    protected IBattleSelfDataFlexImpl _$$selfData;

    @SerializedName("self_opt_id")
    protected long _$$selfDataIndex;

    @SerializedName("shell_config")
    protected IBattleShellConfigExtensionImpl _$$shellConfig;

    @SerializedName("specify_gift_config")
    protected h9 _$$specifyGiftConfig;

    @SerializedName("tag_text")
    protected String _$$tagText;

    @SerializedName("panel_title")
    protected IPanelTitleFlexImpl _$$title;

    @SerializedName("back_img")
    protected py.k backImg;

    public IBattlePanelFlexImpl() {
        super(b2.class);
        this._$$forbiddenText = "";
        this._$$tagText = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.b2
    public /* bridge */ /* synthetic */ o7 getButton() {
        return getButton();
    }

    @Override // com.bytedance.android.livesdk.link.model.b2
    public /* bridge */ /* synthetic */ z7 getGameConfig() {
        return getGameConfig();
    }

    @Override // com.bytedance.android.livesdk.link.model.b2
    public /* bridge */ /* synthetic */ u2 getSelfData() {
        return getSelfData();
    }

    @Override // com.bytedance.android.livesdk.link.model.b2
    public /* bridge */ /* synthetic */ w2 getShellConfig() {
        return getShellConfig();
    }

    @Override // com.bytedance.android.livesdk.link.model.b2
    public /* bridge */ /* synthetic */ q7 getTitle() {
        return getTitle();
    }

    @Override // com.bytedance.android.livesdk.link.model.b2
    public py.k getBackImg() {
        return this.backImg;
    }

    @Override // com.bytedance.android.livesdk.link.model.b2
    public final int getBattlePanelType() {
        return this._$$battlePanelType;
    }

    @Override // com.bytedance.android.livesdk.link.model.b2
    public final d4 getCustomConfig() {
        return this._$$customConfig;
    }

    @Override // com.bytedance.android.livesdk.link.model.b2
    public final String getForbiddenText() {
        return this._$$forbiddenText;
    }

    @Override // com.bytedance.android.livesdk.link.model.b2
    public final long getSelfDataIndex() {
        return this._$$selfDataIndex;
    }

    @Override // com.bytedance.android.livesdk.link.model.b2
    public final h9 getSpecifyGiftConfig() {
        return this._$$specifyGiftConfig;
    }

    @Override // com.bytedance.android.livesdk.link.model.b2
    public final String getTagText() {
        return this._$$tagText;
    }

    @Override // com.bytedance.android.livesdk.link.model.b2
    public final Boolean isForbidden() {
        return this._$$isForbidden;
    }

    @Override // com.bytedance.android.livesdk.link.model.b2
    public final IPanelBtnFlexImpl getButton() {
        return this._$$button;
    }

    @Override // com.bytedance.android.livesdk.link.model.b2
    public final IProfitGameConfigFlexImpl getGameConfig() {
        return this._$$gameConfig;
    }

    @Override // com.bytedance.android.livesdk.link.model.b2
    public final IBattleSelfDataFlexImpl getSelfData() {
        return this._$$selfData;
    }

    @Override // com.bytedance.android.livesdk.link.model.b2
    public final IBattleShellConfigExtensionImpl getShellConfig() {
        return this._$$shellConfig;
    }

    @Override // com.bytedance.android.livesdk.link.model.b2
    public final IPanelTitleFlexImpl getTitle() {
        return this._$$title;
    }

    /* JADX WARN: Type inference failed for: r2v15, types: [com.bytedance.android.livesdk.link.model.h9, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v17, types: [com.bytedance.android.livesdk.link.model.d4, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v19, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, vh7.c] */
    public IBattlePanelFlexImpl(am3.g r5) {
        super(b2.class);
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L21;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L7;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L12;
            case 11: goto L11;
            case 12: goto L10;
            case 13: goto L9;
            case 14: goto L8;
            default: goto L7;
        };
    L8:
        this._$$gameConfig = new IProfitGameConfigFlexImpl(r5);
        goto L3
    L9:
        this.backImg = vh7.f.a(r5, py.k.class);
        goto L3
    L10:
        this._$$customConfig = vh7.f.a(r5, d4.class);
        goto L3
    L11:
        this._$$specifyGiftConfig = vh7.f.a(r5, h9.class);
        goto L3
    L12:
        this._$$tagText = am3.h.c(r5);
        goto L3
    L13:
        this._$$forbiddenText = am3.h.c(r5);
        goto L3
    L14:
        this._$$isForbidden = Boolean.valueOf(am3.h.a(r5));
        goto L3
    L15:
        this._$$shellConfig = (IBattleShellConfigExtensionImpl) vh7.f.a(r5, com.bytedance.android.livesdk.link.model.bridge.a0.class).castToOrNull(IBattleShellConfigExtensionImpl.class);
        goto L3
    L16:
        this._$$battlePanelType = r5.i();
        goto L3
    L17:
        this._$$selfData = new IBattleSelfDataFlexImpl(r5);
        goto L3
    L18:
        this._$$selfDataIndex = r5.j();
        goto L3
    L19:
        this._$$button = new IPanelBtnFlexImpl(r5);
        goto L3
    L20:
        this._$$title = new IPanelTitleFlexImpl(r5);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L21:
        r5.d(r0);
        setThreadSafe(true);
        if (this._$$forbiddenText != null) goto L25;
        this._$$forbiddenText = "";
    L25:
        if (this._$$tagText != null) goto L58;
        this._$$tagText = "";
        return;
    }

    public void setBackImg(py.k r1) {
        this.backImg = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.b2
    public final void setCustomConfig(d4 r1) {
        this._$$customConfig = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.b2
    public final void setSpecifyGiftConfig(h9 r1) {
        this._$$specifyGiftConfig = r1;
    }
}
