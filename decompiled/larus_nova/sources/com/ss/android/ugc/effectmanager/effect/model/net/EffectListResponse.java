package com.ss.android.ugc.effectmanager.effect.model.net;

import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.template.EffectListResponseTemplate;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0016\u0010(\u001a\u00020)2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0016\u0010*\u001a\u00020)2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016R0\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR0\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R(\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0006\u001a\u0004\u0018\u00010\u00148V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u001a8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR0\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00140\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b!\u0010\u000b\"\u0004\b\"\u0010\rR0\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00140\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00140\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b$\u0010\u000b\"\u0004\b%\u0010\r¨\u0006+"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/net/EffectListResponse;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/EffectListResponseTemplate;", "Ljava/io/Serializable;", "kEffectList", "Lcom/ss/ugc/effectplatform/model/net/EffectListResponse;", "(Lcom/ss/ugc/effectplatform/model/net/EffectListResponse;)V", "value", "", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "bindEffects", "getBindEffects", "()Ljava/util/List;", "setBindEffects", "(Ljava/util/List;)V", "Lcom/ss/ugc/effectplatform/model/Effect;", "bind_effects", "getBind_effects", "setBind_effects", "getKEffectList", "()Lcom/ss/ugc/effectplatform/model/net/EffectListResponse;", "", "message", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "", "status_code", "getStatus_code", "()I", "setStatus_code", "(I)V", "urlPrefix", "getUrlPrefix", "setUrlPrefix", "url_prefix", "getUrl_prefix", "setUrl_prefix", "getCollection", "getData", "setCollection", "", "setData", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class EffectListResponse extends EffectListResponseTemplate implements Serializable {
    private final transient com.ss.ugc.effectplatform.model.net.EffectListResponse kEffectList;

    /* JADX WARN: Multi-variable type inference failed */
    public EffectListResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectListResponseTemplate
    public List<Effect> getBindEffects() {
        return super.getBindEffects();
    }

    @Override // com.ss.ugc.effectplatform.model.net.EffectListResponse
    public List<com.ss.ugc.effectplatform.model.Effect> getBind_effects() {
        com.ss.ugc.effectplatform.model.net.EffectListResponse r100 = getKEffectList();
        if (r100 == null) goto L8;
        List<com.ss.ugc.effectplatform.model.Effect> r101 = r100.getBind_effects();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getBind_effects();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectListResponseTemplate
    public List<Effect> getCollection() {
        return super.getCollection();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectListResponseTemplate
    public List<Effect> getData() {
        return super.getData();
    }

    @Override // com.ss.ugc.effectplatform.model.net.EffectListResponse
    public String getMessage() {
        com.ss.ugc.effectplatform.model.net.EffectListResponse r100 = getKEffectList();
        if (r100 == null) goto L8;
        String r101 = r100.getMessage();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getMessage();
    }

    @Override // com.ss.ugc.effectplatform.model.net.EffectListResponse
    public int getStatus_code() {
        com.ss.ugc.effectplatform.model.net.EffectListResponse r100 = getKEffectList();
        if (r100 == null) goto L6;
        return r100.getStatus_code();
    L6:
        return super.getStatus_code();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectListResponseTemplate
    public List<String> getUrlPrefix() {
        return super.getUrlPrefix();
    }

    @Override // com.ss.ugc.effectplatform.model.net.EffectListResponse
    public List<String> getUrl_prefix() {
        com.ss.ugc.effectplatform.model.net.EffectListResponse r100 = getKEffectList();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getUrl_prefix();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getUrl_prefix();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectListResponseTemplate
    public com.ss.ugc.effectplatform.model.net.EffectListResponse getKEffectList() {
        return this.kEffectList;
    }

    public EffectListResponse(com.ss.ugc.effectplatform.model.net.EffectListResponse r100) {
        super(r100);
        this.kEffectList = r100;
        com.ss.ugc.effectplatform.model.net.EffectListResponse r101 = getKEffectList();
        if (r101 == null) goto L20;
        List<com.ss.ugc.effectplatform.model.Effect> r102 = r101.getBind_effects();
        if (r102 == null) goto L7;
        super.setBind_effects(r102);
    L7:
        List<com.ss.ugc.effectplatform.model.Effect> r103 = r101.getCollection_list();
        if (r103 == null) goto L10;
        super.setCollection_list(r103);
    L10:
        List<com.ss.ugc.effectplatform.model.Effect> r104 = r101.getEffect_list();
        if (r104 == null) goto L13;
        super.setEffect_list(r104);
    L13:
        String r105 = r101.getMessage();
        if (r105 == null) goto L16;
        super.setMessage(r105);
    L16:
        super.setStatus_code(r101.getStatus_code());
        List<String> r106 = r101.getUrl_prefix();
        if (r106 == null) goto L21;
        super.setUrl_prefix(r106);
        return;
    L21:
        return;
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectListResponseTemplate
    public void setBindEffects(List<? extends Effect> r100) {
        super.setBindEffects(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.EffectListResponse
    public void setBind_effects(List<? extends com.ss.ugc.effectplatform.model.Effect> r100) {
        com.ss.ugc.effectplatform.model.net.EffectListResponse r101 = getKEffectList();
        if (r101 == null) goto L5;
        r101.setBind_effects(r100);
    L5:
        super.setBind_effects(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectListResponseTemplate
    public void setCollection(List<? extends Effect> r100) {
        super.setCollection(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectListResponseTemplate
    public void setData(List<? extends Effect> r100) {
        super.setData(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.EffectListResponse
    public void setMessage(String r100) {
        com.ss.ugc.effectplatform.model.net.EffectListResponse r101 = getKEffectList();
        if (r101 == null) goto L5;
        r101.setMessage(r100);
    L5:
        super.setMessage(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.EffectListResponse
    public void setStatus_code(int r100) {
        com.ss.ugc.effectplatform.model.net.EffectListResponse r101 = getKEffectList();
        if (r101 == null) goto L5;
        r101.setStatus_code(r100);
    L5:
        super.setStatus_code(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectListResponseTemplate
    public void setUrlPrefix(List<String> r100) {
        super.setUrlPrefix(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.EffectListResponse
    public void setUrl_prefix(List<String> r100) {
        com.ss.ugc.effectplatform.model.net.EffectListResponse r101 = getKEffectList();
        if (r101 == null) goto L5;
        r101.setUrl_prefix(r100);
    L5:
        super.setUrl_prefix(r100);
    }

    public /* synthetic */ EffectListResponse(com.ss.ugc.effectplatform.model.net.EffectListResponse r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
