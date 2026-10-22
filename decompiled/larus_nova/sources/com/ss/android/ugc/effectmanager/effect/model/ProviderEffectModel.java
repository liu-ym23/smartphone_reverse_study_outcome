package com.ss.android.ugc.effectmanager.effect.model;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.android.ugc.effectmanager.effect.model.template.ProviderEffectModelTemplate;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0014\u001a\u00020\u0013H\u0016R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR(\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\r8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00138V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00138V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR(\u0010\u001e\u001a\u0004\u0018\u00010\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\r8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R(\u0010!\u001a\u0004\u0018\u00010\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\r8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012R0\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020%0$8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R0\u0010,\u001a\b\u0012\u0004\u0012\u00020+0$2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020+0$8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*R(\u0010/\u001a\u0004\u0018\u00010\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\r8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b0\u0010\u0010\"\u0004\b1\u0010\u0012¨\u00062"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/ProviderEffectModel;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/ProviderEffectModelTemplate;", "Ljava/io/Serializable;", "kProviderEffect", "Lcom/ss/ugc/effectplatform/model/ProviderEffectModel;", "(Lcom/ss/ugc/effectplatform/model/ProviderEffectModel;)V", "value", "", EffectConfiguration.KEY_CURSOR, "getCursor", "()I", "setCursor", "(I)V", "", "extra", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "", "hasMore", "getHasMore", "()Z", "setHasMore", "(Z)V", "has_more", "getHas_more", "setHas_more", "getKProviderEffect", "()Lcom/ss/ugc/effectplatform/model/ProviderEffectModel;", "searchTips", "getSearchTips", "setSearchTips", "search_tips", "getSearch_tips", "setSearch_tips", "", "Lcom/ss/android/ugc/effectmanager/effect/model/ProviderEffect;", "stickerList", "getStickerList", "()Ljava/util/List;", "setStickerList", "(Ljava/util/List;)V", "Lcom/ss/ugc/effectplatform/model/ProviderEffect;", "sticker_list", "getSticker_list", "setSticker_list", "subtitle", "getSubtitle", "setSubtitle", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class ProviderEffectModel extends ProviderEffectModelTemplate implements Serializable {
    private final transient com.ss.ugc.effectplatform.model.ProviderEffectModel kProviderEffect;

    /* JADX WARN: Multi-variable type inference failed */
    public ProviderEffectModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffectModel
    public int getCursor() {
        com.ss.ugc.effectplatform.model.ProviderEffectModel r100 = getKProviderEffect();
        if (r100 == null) goto L6;
        return r100.getCursor();
    L6:
        return super.getCursor();
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffectModel
    public String getExtra() {
        com.ss.ugc.effectplatform.model.ProviderEffectModel r100 = getKProviderEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getExtra();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getExtra();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.ProviderEffectModelTemplate
    public boolean getHasMore() {
        return super.getHasMore();
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffectModel
    public boolean getHas_more() {
        com.ss.ugc.effectplatform.model.ProviderEffectModel r100 = getKProviderEffect();
        if (r100 == null) goto L6;
        return r100.getHas_more();
    L6:
        return super.getHas_more();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.ProviderEffectModelTemplate
    public String getSearchTips() {
        return super.getSearchTips();
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffectModel
    public String getSearch_tips() {
        com.ss.ugc.effectplatform.model.ProviderEffectModel r100 = getKProviderEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getSearch_tips();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getSearch_tips();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.ProviderEffectModelTemplate
    public List<ProviderEffect> getStickerList() {
        return super.getStickerList();
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffectModel
    public List<com.ss.ugc.effectplatform.model.ProviderEffect> getSticker_list() {
        com.ss.ugc.effectplatform.model.ProviderEffectModel r100 = getKProviderEffect();
        if (r100 == null) goto L8;
        List<com.ss.ugc.effectplatform.model.ProviderEffect> r101 = r100.getSticker_list();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getSticker_list();
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffectModel
    public String getSubtitle() {
        com.ss.ugc.effectplatform.model.ProviderEffectModel r100 = getKProviderEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getSubtitle();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getSubtitle();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.ProviderEffectModelTemplate
    public boolean hasMore() {
        return super.hasMore();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.ProviderEffectModelTemplate
    public com.ss.ugc.effectplatform.model.ProviderEffectModel getKProviderEffect() {
        return this.kProviderEffect;
    }

    public ProviderEffectModel(com.ss.ugc.effectplatform.model.ProviderEffectModel r100) {
        super(r100);
        this.kProviderEffect = r100;
        com.ss.ugc.effectplatform.model.ProviderEffectModel r101 = getKProviderEffect();
        if (r101 == null) goto L17;
        super.setCursor(r101.getCursor());
        String r102 = r101.getExtra();
        if (r102 == null) goto L7;
        super.setExtra(r102);
    L7:
        super.setHas_more(r101.getHas_more());
        String r103 = r101.getSearch_tips();
        if (r103 == null) goto L10;
        super.setSearch_tips(r103);
    L10:
        List<com.ss.ugc.effectplatform.model.ProviderEffect> r104 = r101.getSticker_list();
        if (r104 == null) goto L13;
        super.setSticker_list(r104);
    L13:
        String r105 = r101.getSubtitle();
        if (r105 == null) goto L18;
        super.setSubtitle(r105);
        return;
    L18:
        return;
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffectModel
    public void setCursor(int r100) {
        com.ss.ugc.effectplatform.model.ProviderEffectModel r101 = getKProviderEffect();
        if (r101 == null) goto L5;
        r101.setCursor(r100);
    L5:
        super.setCursor(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffectModel
    public void setExtra(String r100) {
        com.ss.ugc.effectplatform.model.ProviderEffectModel r101 = getKProviderEffect();
        if (r101 == null) goto L5;
        r101.setExtra(r100);
    L5:
        super.setExtra(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.ProviderEffectModelTemplate
    public void setHasMore(boolean r100) {
        super.setHasMore(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffectModel
    public void setHas_more(boolean r100) {
        com.ss.ugc.effectplatform.model.ProviderEffectModel r101 = getKProviderEffect();
        if (r101 == null) goto L5;
        r101.setHas_more(r100);
    L5:
        super.setHas_more(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.ProviderEffectModelTemplate
    public void setSearchTips(String r100) {
        super.setSearchTips(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffectModel
    public void setSearch_tips(String r100) {
        com.ss.ugc.effectplatform.model.ProviderEffectModel r101 = getKProviderEffect();
        if (r101 == null) goto L5;
        r101.setSearch_tips(r100);
    L5:
        super.setSearch_tips(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.ProviderEffectModelTemplate
    public void setStickerList(List<ProviderEffect> r100) {
        super.setStickerList(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffectModel
    public void setSticker_list(List<? extends com.ss.ugc.effectplatform.model.ProviderEffect> r100) {
        com.ss.ugc.effectplatform.model.ProviderEffectModel r101 = getKProviderEffect();
        if (r101 == null) goto L5;
        r101.setSticker_list(r100);
    L5:
        super.setSticker_list(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.ProviderEffectModel
    public void setSubtitle(String r100) {
        com.ss.ugc.effectplatform.model.ProviderEffectModel r101 = getKProviderEffect();
        if (r101 == null) goto L5;
        r101.setSubtitle(r100);
    L5:
        super.setSubtitle(r100);
    }

    public /* synthetic */ ProviderEffectModel(com.ss.ugc.effectplatform.model.ProviderEffectModel r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
