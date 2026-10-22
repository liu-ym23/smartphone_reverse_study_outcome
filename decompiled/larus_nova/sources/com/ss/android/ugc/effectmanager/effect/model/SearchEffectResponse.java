package com.ss.android.ugc.effectmanager.effect.model;

import com.facebook.keyframes.model.KFFeature;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.android.ugc.effectmanager.effect.model.template.SearchEffectResponseTemplate;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0016\u0010.\u001a\u00020/2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0016\u00100\u001a\u00020/2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016R0\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR0\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R(\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u0006\u001a\u0004\u0018\u00010#8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017¨\u00062"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/SearchEffectResponse;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/SearchEffectResponseTemplate;", "Ljava/io/Serializable;", "kSearchEffect", "Lcom/ss/ugc/effectplatform/model/net/SearchEffectResponse;", "(Lcom/ss/ugc/effectplatform/model/net/SearchEffectResponse;)V", "value", "", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "bindEffects", "getBindEffects", "()Ljava/util/List;", "setBindEffects", "(Ljava/util/List;)V", "Lcom/ss/ugc/effectplatform/model/Effect;", "bind_effects", "getBind_effects", "setBind_effects", "", EffectConfiguration.KEY_CURSOR, "getCursor", "()I", "setCursor", "(I)V", "", "hasMore", "getHasMore", "()Z", "setHasMore", "(Z)V", "has_more", "getHas_more", "setHas_more", "getKSearchEffect", "()Lcom/ss/ugc/effectplatform/model/net/SearchEffectResponse;", "", "message", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "status_code", "getStatus_code", "setStatus_code", "getCollection", "getEffects", "setCollection", "", "setEffects", KFFeature.EFFECT_JSON_FIELD, "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class SearchEffectResponse extends SearchEffectResponseTemplate implements Serializable {
    private final transient com.ss.ugc.effectplatform.model.net.SearchEffectResponse kSearchEffect;

    /* JADX WARN: Multi-variable type inference failed */
    public SearchEffectResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.SearchEffectResponseTemplate
    public List<Effect> getBindEffects() {
        return super.getBindEffects();
    }

    @Override // com.ss.ugc.effectplatform.model.net.SearchEffectResponse
    public List<com.ss.ugc.effectplatform.model.Effect> getBind_effects() {
        com.ss.ugc.effectplatform.model.net.SearchEffectResponse r100 = getKSearchEffect();
        if (r100 == null) goto L8;
        List<com.ss.ugc.effectplatform.model.Effect> r101 = r100.getBind_effects();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getBind_effects();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.SearchEffectResponseTemplate
    public List<Effect> getCollection() {
        return super.getCollection();
    }

    @Override // com.ss.ugc.effectplatform.model.net.SearchEffectResponse
    public int getCursor() {
        com.ss.ugc.effectplatform.model.net.SearchEffectResponse r100 = getKSearchEffect();
        if (r100 == null) goto L6;
        return r100.getCursor();
    L6:
        return super.getCursor();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.SearchEffectResponseTemplate
    public List<Effect> getEffects() {
        return super.getEffects();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.SearchEffectResponseTemplate
    public boolean getHasMore() {
        return super.getHasMore();
    }

    @Override // com.ss.ugc.effectplatform.model.net.SearchEffectResponse
    public boolean getHas_more() {
        com.ss.ugc.effectplatform.model.net.SearchEffectResponse r100 = getKSearchEffect();
        if (r100 == null) goto L6;
        return r100.getHas_more();
    L6:
        return super.getHas_more();
    }

    @Override // com.ss.ugc.effectplatform.model.net.SearchEffectResponse
    public String getMessage() {
        com.ss.ugc.effectplatform.model.net.SearchEffectResponse r100 = getKSearchEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getMessage();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getMessage();
    }

    @Override // com.ss.ugc.effectplatform.model.net.SearchEffectResponse
    public int getStatus_code() {
        com.ss.ugc.effectplatform.model.net.SearchEffectResponse r100 = getKSearchEffect();
        if (r100 == null) goto L6;
        return r100.getStatus_code();
    L6:
        return super.getStatus_code();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.SearchEffectResponseTemplate
    public com.ss.ugc.effectplatform.model.net.SearchEffectResponse getKSearchEffect() {
        return this.kSearchEffect;
    }

    public SearchEffectResponse(com.ss.ugc.effectplatform.model.net.SearchEffectResponse r100) {
        super(r100);
        this.kSearchEffect = r100;
        com.ss.ugc.effectplatform.model.net.SearchEffectResponse r101 = getKSearchEffect();
        if (r101 == null) goto L18;
        List<com.ss.ugc.effectplatform.model.Effect> r102 = r101.getBind_effects();
        if (r102 == null) goto L7;
        super.setBind_effects(r102);
    L7:
        List<com.ss.ugc.effectplatform.model.Effect> r103 = r101.getCollection_list();
        if (r103 == null) goto L10;
        super.setCollection_list(r103);
    L10:
        super.setCursor(r101.getCursor());
        List<com.ss.ugc.effectplatform.model.Effect> r104 = r101.getEffect_list();
        if (r104 == null) goto L13;
        super.setEffect_list(r104);
    L13:
        super.setHas_more(r101.getHas_more());
        String r105 = r101.getMessage();
        if (r105 == null) goto L16;
        super.setMessage(r105);
    L16:
        super.setStatus_code(r101.getStatus_code());
        return;
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.SearchEffectResponseTemplate
    public void setBindEffects(List<? extends Effect> r100) {
        super.setBindEffects(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.SearchEffectResponse
    public void setBind_effects(List<? extends com.ss.ugc.effectplatform.model.Effect> r100) {
        com.ss.ugc.effectplatform.model.net.SearchEffectResponse r101 = getKSearchEffect();
        if (r101 == null) goto L5;
        r101.setBind_effects(r100);
    L5:
        super.setBind_effects(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.SearchEffectResponseTemplate
    public void setCollection(List<? extends Effect> r100) {
        super.setCollection(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.SearchEffectResponse
    public void setCursor(int r100) {
        com.ss.ugc.effectplatform.model.net.SearchEffectResponse r101 = getKSearchEffect();
        if (r101 == null) goto L5;
        r101.setCursor(r100);
    L5:
        super.setCursor(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.SearchEffectResponseTemplate
    public void setEffects(List<? extends Effect> r100) {
        super.setEffects(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.SearchEffectResponseTemplate
    public void setHasMore(boolean r100) {
        super.setHasMore(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.SearchEffectResponse
    public void setHas_more(boolean r100) {
        com.ss.ugc.effectplatform.model.net.SearchEffectResponse r101 = getKSearchEffect();
        if (r101 == null) goto L5;
        r101.setHas_more(r100);
    L5:
        super.setHas_more(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.SearchEffectResponse
    public void setMessage(String r100) {
        com.ss.ugc.effectplatform.model.net.SearchEffectResponse r101 = getKSearchEffect();
        if (r101 == null) goto L5;
        r101.setMessage(r100);
    L5:
        super.setMessage(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.SearchEffectResponse
    public void setStatus_code(int r100) {
        com.ss.ugc.effectplatform.model.net.SearchEffectResponse r101 = getKSearchEffect();
        if (r101 == null) goto L5;
        r101.setStatus_code(r100);
    L5:
        super.setStatus_code(r100);
    }

    public /* synthetic */ SearchEffectResponse(com.ss.ugc.effectplatform.model.net.SearchEffectResponse r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
