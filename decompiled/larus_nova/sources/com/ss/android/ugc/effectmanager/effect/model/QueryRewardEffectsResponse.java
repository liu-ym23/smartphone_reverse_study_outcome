package com.ss.android.ugc.effectmanager.effect.model;

import com.ss.android.ugc.effectmanager.effect.model.template.QueryRewardEffectsResponseTemplate;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u000f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00158V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR0\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R0\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u001b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\"0\u001b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R$\u0010&\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00158V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b'\u0010\u0018\"\u0004\b(\u0010\u001aR0\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b*\u0010\u001f\"\u0004\b+\u0010!¨\u0006,"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/QueryRewardEffectsResponse;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/QueryRewardEffectsResponseTemplate;", "Ljava/io/Serializable;", "kQueryRewardEffectsResponse", "Lcom/ss/ugc/effectplatform/model/net/QueryRewardEffectsResponse;", "(Lcom/ss/ugc/effectplatform/model/net/QueryRewardEffectsResponse;)V", "value", "", "has_more", "getHas_more", "()Z", "setHas_more", "(Z)V", "getKQueryRewardEffectsResponse", "()Lcom/ss/ugc/effectplatform/model/net/QueryRewardEffectsResponse;", "", "message", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "", "next_cursor", "getNext_cursor", "()I", "setNext_cursor", "(I)V", "", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "rewardEffects", "getRewardEffects", "()Ljava/util/List;", "setRewardEffects", "(Ljava/util/List;)V", "Lcom/ss/ugc/effectplatform/model/Effect;", "reward_effects", "getReward_effects", "setReward_effects", "status_code", "getStatus_code", "setStatus_code", "url_prefix", "getUrl_prefix", "setUrl_prefix", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class QueryRewardEffectsResponse extends QueryRewardEffectsResponseTemplate implements Serializable {
    private final transient com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse kQueryRewardEffectsResponse;

    /* JADX WARN: Multi-variable type inference failed */
    public QueryRewardEffectsResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse
    public boolean getHas_more() {
        com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse r100 = getKQueryRewardEffectsResponse();
        if (r100 == null) goto L6;
        return r100.getHas_more();
    L6:
        return super.getHas_more();
    }

    @Override // com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse
    public String getMessage() {
        com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse r100 = getKQueryRewardEffectsResponse();
        if (r100 == null) goto L8;
        String r101 = r100.getMessage();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getMessage();
    }

    @Override // com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse
    public int getNext_cursor() {
        com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse r100 = getKQueryRewardEffectsResponse();
        if (r100 == null) goto L6;
        return r100.getNext_cursor();
    L6:
        return super.getNext_cursor();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.QueryRewardEffectsResponseTemplate
    public List<Effect> getRewardEffects() {
        return super.getRewardEffects();
    }

    @Override // com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse
    public List<com.ss.ugc.effectplatform.model.Effect> getReward_effects() {
        com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse r100 = getKQueryRewardEffectsResponse();
        if (r100 == null) goto L8;
        List<com.ss.ugc.effectplatform.model.Effect> r101 = r100.getReward_effects();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getReward_effects();
    }

    @Override // com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse
    public int getStatus_code() {
        com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse r100 = getKQueryRewardEffectsResponse();
        if (r100 == null) goto L6;
        return r100.getStatus_code();
    L6:
        return super.getStatus_code();
    }

    @Override // com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse
    public List<String> getUrl_prefix() {
        com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse r100 = getKQueryRewardEffectsResponse();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getUrl_prefix();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getUrl_prefix();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.QueryRewardEffectsResponseTemplate
    public com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse getKQueryRewardEffectsResponse() {
        return this.kQueryRewardEffectsResponse;
    }

    public QueryRewardEffectsResponse(com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse r100) {
        super(r100);
        this.kQueryRewardEffectsResponse = r100;
        com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse r101 = getKQueryRewardEffectsResponse();
        if (r101 == null) goto L14;
        super.setHas_more(r101.getHas_more());
        String r102 = r101.getMessage();
        if (r102 == null) goto L7;
        super.setMessage(r102);
    L7:
        super.setNext_cursor(r101.getNext_cursor());
        List<com.ss.ugc.effectplatform.model.Effect> r103 = r101.getReward_effects();
        if (r103 == null) goto L10;
        super.setReward_effects(r103);
    L10:
        super.setStatus_code(r101.getStatus_code());
        List<String> r104 = r101.getUrl_prefix();
        if (r104 == null) goto L15;
        super.setUrl_prefix(r104);
        return;
    L15:
        return;
    }

    @Override // com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse
    public void setHas_more(boolean r100) {
        com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse r101 = getKQueryRewardEffectsResponse();
        if (r101 == null) goto L5;
        r101.setHas_more(r100);
    L5:
        super.setHas_more(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse
    public void setMessage(String r100) {
        com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse r101 = getKQueryRewardEffectsResponse();
        if (r101 == null) goto L5;
        r101.setMessage(r100);
    L5:
        super.setMessage(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse
    public void setNext_cursor(int r100) {
        com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse r101 = getKQueryRewardEffectsResponse();
        if (r101 == null) goto L5;
        r101.setNext_cursor(r100);
    L5:
        super.setNext_cursor(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.QueryRewardEffectsResponseTemplate
    public void setRewardEffects(List<? extends Effect> r100) {
        super.setRewardEffects(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse
    public void setReward_effects(List<? extends com.ss.ugc.effectplatform.model.Effect> r100) {
        com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse r101 = getKQueryRewardEffectsResponse();
        if (r101 == null) goto L5;
        r101.setReward_effects(r100);
    L5:
        super.setReward_effects(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse
    public void setStatus_code(int r100) {
        com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse r101 = getKQueryRewardEffectsResponse();
        if (r101 == null) goto L5;
        r101.setStatus_code(r100);
    L5:
        super.setStatus_code(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse
    public void setUrl_prefix(List<String> r100) {
        com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse r101 = getKQueryRewardEffectsResponse();
        if (r101 == null) goto L5;
        r101.setUrl_prefix(r100);
    L5:
        super.setUrl_prefix(r100);
    }

    public /* synthetic */ QueryRewardEffectsResponse(com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
