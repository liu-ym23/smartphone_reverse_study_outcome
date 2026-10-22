package com.ss.android.ugc.effectmanager.effect.model;

import com.ss.android.ugc.effectmanager.effect.model.template.CustomizedEffectsResponseTemplate;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R4\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR4\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R(\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0006\u001a\u0004\u0018\u00010\u00148V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u001a8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR4\u0010 \u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b!\u0010\u000b\"\u0004\b\"\u0010\rR4\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b$\u0010\u000b\"\u0004\b%\u0010\r¨\u0006&"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/CustomizedEffectsResponse;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/CustomizedEffectsResponseTemplate;", "Ljava/io/Serializable;", "kCustomizedEffectsResponse", "Lcom/ss/ugc/effectplatform/model/net/CustomizedEffectsResponse;", "(Lcom/ss/ugc/effectplatform/model/net/CustomizedEffectsResponse;)V", "value", "", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "customEffects", "getCustomEffects", "()Ljava/util/List;", "setCustomEffects", "(Ljava/util/List;)V", "Lcom/ss/ugc/effectplatform/model/Effect;", "custom_effects", "getCustom_effects", "setCustom_effects", "getKCustomizedEffectsResponse", "()Lcom/ss/ugc/effectplatform/model/net/CustomizedEffectsResponse;", "", "message", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "", "status_code", "getStatus_code", "()I", "setStatus_code", "(I)V", "templateEffects", "getTemplateEffects", "setTemplateEffects", "template_effects", "getTemplate_effects", "setTemplate_effects", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class CustomizedEffectsResponse extends CustomizedEffectsResponseTemplate implements Serializable {
    private final transient com.ss.ugc.effectplatform.model.net.CustomizedEffectsResponse kCustomizedEffectsResponse;

    /* JADX WARN: Multi-variable type inference failed */
    public CustomizedEffectsResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.CustomizedEffectsResponseTemplate
    public List<Effect> getCustomEffects() {
        return super.getCustomEffects();
    }

    @Override // com.ss.ugc.effectplatform.model.net.CustomizedEffectsResponse
    public List<com.ss.ugc.effectplatform.model.Effect> getCustom_effects() {
        com.ss.ugc.effectplatform.model.net.CustomizedEffectsResponse r100 = getKCustomizedEffectsResponse();
        if (r100 == null) goto L8;
        List<com.ss.ugc.effectplatform.model.Effect> r101 = r100.getCustom_effects();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getCustom_effects();
    }

    @Override // com.ss.ugc.effectplatform.model.net.CustomizedEffectsResponse
    public String getMessage() {
        com.ss.ugc.effectplatform.model.net.CustomizedEffectsResponse r100 = getKCustomizedEffectsResponse();
        if (r100 == null) goto L8;
        String r101 = r100.getMessage();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getMessage();
    }

    @Override // com.ss.ugc.effectplatform.model.net.CustomizedEffectsResponse
    public int getStatus_code() {
        com.ss.ugc.effectplatform.model.net.CustomizedEffectsResponse r100 = getKCustomizedEffectsResponse();
        if (r100 == null) goto L6;
        return r100.getStatus_code();
    L6:
        return super.getStatus_code();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.CustomizedEffectsResponseTemplate
    public List<Effect> getTemplateEffects() {
        return super.getTemplateEffects();
    }

    @Override // com.ss.ugc.effectplatform.model.net.CustomizedEffectsResponse
    public List<com.ss.ugc.effectplatform.model.Effect> getTemplate_effects() {
        com.ss.ugc.effectplatform.model.net.CustomizedEffectsResponse r100 = getKCustomizedEffectsResponse();
        if (r100 == null) goto L8;
        List<com.ss.ugc.effectplatform.model.Effect> r101 = r100.getTemplate_effects();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getTemplate_effects();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.CustomizedEffectsResponseTemplate
    public com.ss.ugc.effectplatform.model.net.CustomizedEffectsResponse getKCustomizedEffectsResponse() {
        return this.kCustomizedEffectsResponse;
    }

    public CustomizedEffectsResponse(com.ss.ugc.effectplatform.model.net.CustomizedEffectsResponse r100) {
        super(r100);
        this.kCustomizedEffectsResponse = r100;
        com.ss.ugc.effectplatform.model.net.CustomizedEffectsResponse r101 = getKCustomizedEffectsResponse();
        if (r101 == null) goto L14;
        List<com.ss.ugc.effectplatform.model.Effect> r102 = r101.getCustom_effects();
        if (r102 == null) goto L7;
        super.setCustom_effects(r102);
    L7:
        String r103 = r101.getMessage();
        if (r103 == null) goto L10;
        super.setMessage(r103);
    L10:
        super.setStatus_code(r101.getStatus_code());
        List<com.ss.ugc.effectplatform.model.Effect> r104 = r101.getTemplate_effects();
        if (r104 == null) goto L15;
        super.setTemplate_effects(r104);
        return;
    L15:
        return;
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.CustomizedEffectsResponseTemplate
    public void setCustomEffects(List<? extends Effect> r100) {
        super.setCustomEffects(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.CustomizedEffectsResponse
    public void setCustom_effects(List<? extends com.ss.ugc.effectplatform.model.Effect> r100) {
        com.ss.ugc.effectplatform.model.net.CustomizedEffectsResponse r101 = getKCustomizedEffectsResponse();
        if (r101 == null) goto L5;
        r101.setCustom_effects(r100);
    L5:
        super.setCustom_effects(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.CustomizedEffectsResponse
    public void setMessage(String r100) {
        com.ss.ugc.effectplatform.model.net.CustomizedEffectsResponse r101 = getKCustomizedEffectsResponse();
        if (r101 == null) goto L5;
        r101.setMessage(r100);
    L5:
        super.setMessage(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.CustomizedEffectsResponse
    public void setStatus_code(int r100) {
        com.ss.ugc.effectplatform.model.net.CustomizedEffectsResponse r101 = getKCustomizedEffectsResponse();
        if (r101 == null) goto L5;
        r101.setStatus_code(r100);
    L5:
        super.setStatus_code(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.CustomizedEffectsResponseTemplate
    public void setTemplateEffects(List<? extends Effect> r100) {
        super.setTemplateEffects(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.CustomizedEffectsResponse
    public void setTemplate_effects(List<? extends com.ss.ugc.effectplatform.model.Effect> r100) {
        com.ss.ugc.effectplatform.model.net.CustomizedEffectsResponse r101 = getKCustomizedEffectsResponse();
        if (r101 == null) goto L5;
        r101.setTemplate_effects(r100);
    L5:
        super.setTemplate_effects(r100);
    }

    public /* synthetic */ CustomizedEffectsResponse(com.ss.ugc.effectplatform.model.net.CustomizedEffectsResponse r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
