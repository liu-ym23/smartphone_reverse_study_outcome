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
@ProtoMessage("webcast.data.InteractConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bB\u0010CR+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR+\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR+\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R/\u0010%\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u001f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\u0006\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R/\u0010,\u001a\u0004\u0018\u00010&2\b\u0010\u0004\u001a\u0004\u0018\u00010&8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0006\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R/\u00103\u001a\u0004\u0018\u00010-2\b\u0010\u0004\u001a\u0004\u0018\u00010-8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010\u0006\u001a\u0004\b/\u00100\"\u0004\b1\u00102R+\u0010:\u001a\u0002042\u0006\u0010\u0004\u001a\u0002048V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b5\u0010\u0006\u001a\u0004\b6\u00107\"\u0004\b8\u00109R7\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00030;2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030;8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b<\u0010\u0006\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/InteractConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/ca;", "", "<set-?>", "id$delegate", "Ljava/lang/Object;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "id", "", "interactType$delegate", "getInteractType", "()I", "setInteractType", "(I)V", "interactType", "name$delegate", "getName", "setName", "name", "desc$delegate", "getDesc", "setDesc", "desc", "evalType$delegate", "getEvalType", "setEvalType", "evalType", "Lcom/bytedance/android/livesdk/link/model/da;", "battleEffectConfig$delegate", "getBattleEffectConfig", "()Lcom/bytedance/android/livesdk/link/model/da;", "setBattleEffectConfig", "(Lcom/bytedance/android/livesdk/link/model/da;)V", "battleEffectConfig", "Lcom/bytedance/android/livesdk/link/model/fa;", "rewardPunishConfig$delegate", "getRewardPunishConfig", "()Lcom/bytedance/android/livesdk/link/model/fa;", "setRewardPunishConfig", "(Lcom/bytedance/android/livesdk/link/model/fa;)V", "rewardPunishConfig", "Lcom/bytedance/android/livesdk/link/model/ba;", "competeEvalConfig$delegate", "getCompeteEvalConfig", "()Lcom/bytedance/android/livesdk/link/model/ba;", "setCompeteEvalConfig", "(Lcom/bytedance/android/livesdk/link/model/ba;)V", "competeEvalConfig", "Lpy/k;", "icon$delegate", "getIcon", "()Lpy/k;", "setIcon", "(Lpy/k;)V", "icon", "", "playRule$delegate", "getPlayRule", "()Ljava/util/List;", "setPlayRule", "(Ljava/util/List;)V", "playRule", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractConfigFlexImpl extends FlexModelBase<ca> implements ca, vh7.h {

    @SerializedName("battle_effect_config")
    protected da _$$battleEffectConfig;

    @SerializedName("compete_eval_config")
    protected ba _$$competeEvalConfig;

    @SerializedName("desc")
    protected String _$$desc;

    @SerializedName("eval_type")
    protected int _$$evalType;

    @SerializedName("Icon")
    protected py.k _$$icon;

    @SerializedName("id")
    protected String _$$id;

    @SerializedName("interact_type")
    protected int _$$interactType;

    @SerializedName("name")
    protected String _$$name;

    @SerializedName("play_rule")
    protected List<String> _$$playRule;

    @SerializedName("reward_punish_config")
    protected fa _$$rewardPunishConfig;

    public InteractConfigFlexImpl() {
        super(ca.class);
        this._$$id = "";
        this._$$name = "";
        this._$$desc = "";
        this._$$icon = $defaultValue_icon$();
        this._$$playRule = $defaultValue_playRule$();
    }

    public final py.k $defaultValue_icon$() {
        return (py.k) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(py.k.class);
    }

    public final List<String> $defaultValue_playRule$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.link.model.ca
    public final da getBattleEffectConfig() {
        return this._$$battleEffectConfig;
    }

    @Override // com.bytedance.android.livesdk.link.model.ca
    public final ba getCompeteEvalConfig() {
        return this._$$competeEvalConfig;
    }

    @Override // com.bytedance.android.livesdk.link.model.ca
    public final String getDesc() {
        return this._$$desc;
    }

    @Override // com.bytedance.android.livesdk.link.model.ca
    public final int getEvalType() {
        return this._$$evalType;
    }

    @Override // com.bytedance.android.livesdk.link.model.ca
    public final py.k getIcon() {
        return this._$$icon;
    }

    @Override // com.bytedance.android.livesdk.link.model.ca
    public final String getId() {
        return this._$$id;
    }

    @Override // com.bytedance.android.livesdk.link.model.ca
    public final int getInteractType() {
        return this._$$interactType;
    }

    @Override // com.bytedance.android.livesdk.link.model.ca
    public final String getName() {
        return this._$$name;
    }

    @Override // com.bytedance.android.livesdk.link.model.ca
    public final List<String> getPlayRule() {
        return this._$$playRule;
    }

    @Override // com.bytedance.android.livesdk.link.model.ca
    public final fa getRewardPunishConfig() {
        return this._$$rewardPunishConfig;
    }

    /* JADX WARN: Type inference failed for: r2v11, types: [com.bytedance.android.livesdk.link.model.ba, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.android.livesdk.link.model.da, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.bytedance.android.livesdk.link.model.fa, java.lang.Object] */
    public InteractConfigFlexImpl(am3.g r5) {
        super(ca.class);
        this._$$playRule = new ArrayList();
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L18;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            default: goto L7;
        };
    L8:
        this._$$playRule.add(am3.h.c(r5));
        goto L3
    L9:
        this._$$icon = vh7.f.a(r5, py.k.class);
        goto L3
    L10:
        this._$$competeEvalConfig = vh7.f.a(r5, ba.class);
        goto L3
    L11:
        this._$$evalType = r5.i();
        goto L3
    L12:
        this._$$rewardPunishConfig = vh7.f.a(r5, fa.class);
        goto L3
    L13:
        this._$$battleEffectConfig = vh7.f.a(r5, da.class);
        goto L3
    L14:
        this._$$desc = am3.h.c(r5);
        goto L3
    L15:
        this._$$name = am3.h.c(r5);
        goto L3
    L16:
        this._$$interactType = r5.i();
        goto L3
    L17:
        this._$$id = am3.h.c(r5);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L18:
        r5.d(r0);
        setThreadSafe(true);
        if (this._$$id != null) goto L22;
        this._$$id = "";
    L22:
        if (this._$$name != null) goto L25;
        this._$$name = "";
    L25:
        if (this._$$desc != null) goto L28;
        this._$$desc = "";
    L28:
        if (this._$$icon != null) goto L31;
        this._$$icon = $defaultValue_icon$();
    L31:
        if (this._$$playRule.isEmpty() == false) goto L58;
        this._$$playRule = $defaultValue_playRule$();
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.ca
    public final void setBattleEffectConfig(da r1) {
        this._$$battleEffectConfig = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.ca
    public final void setCompeteEvalConfig(ba r1) {
        this._$$competeEvalConfig = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.ca
    public final void setDesc(String r1) {
        this._$$desc = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.ca
    public final void setEvalType(int r1) {
        this._$$evalType = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.ca
    public final void setIcon(py.k r1) {
        this._$$icon = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.ca
    public final void setId(String r1) {
        this._$$id = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.ca
    public final void setInteractType(int r1) {
        this._$$interactType = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.ca
    public final void setName(String r1) {
        this._$$name = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.ca
    public final void setPlayRule(List<String> r1) {
        this._$$playRule = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.ca
    public final void setRewardPunishConfig(fa r1) {
        this._$$rewardPunishConfig = r1;
    }
}
