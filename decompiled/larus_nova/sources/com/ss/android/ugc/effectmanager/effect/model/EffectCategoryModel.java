package com.ss.android.ugc.effectmanager.effect.model;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.facebook.keyframes.model.KFFeature;
import com.ss.android.ugc.effectmanager.effect.model.template.EffectCategoryModelTemplate;
import com.ss.ugc.effectplatform.model.UrlModel;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010@\u001a\u00020A2\u0006\u0010$\u001a\u00020#H\u0016R0\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR0\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR(\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u000e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0006\u001a\u0004\u0018\u00010\u00178V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR(\u0010\u001d\u001a\u0004\u0018\u00010\u00172\b\u0010\u0006\u001a\u0004\u0018\u00010\u00178V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR$\u0010 \u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u000e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R$\u0010$\u001a\u00020#2\u0006\u0010\u0006\u001a\u00020#8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010(\u001a\u00020#2\u0006\u0010\u0006\u001a\u00020#8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R$\u0010,\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u000e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R$\u0010/\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u000e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b0\u0010\u0014\"\u0004\b1\u0010\u0016R$\u00102\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106R0\u00107\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b8\u0010\u000b\"\u0004\b9\u0010\rR(\u0010:\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u000e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b;\u0010\u0014\"\u0004\b<\u0010\u0016R(\u0010=\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u000e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b>\u0010\u0014\"\u0004\b?\u0010\u0016¨\u0006B"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/EffectCategoryModel;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/EffectCategoryModelTemplate;", "Ljava/io/Serializable;", "kCategoryModel", "Lcom/ss/ugc/effectplatform/model/EffectCategoryModel;", "(Lcom/ss/ugc/effectplatform/model/EffectCategoryModel;)V", "value", "", "", "children_categories", "getChildren_categories", "()Ljava/util/List;", "setChildren_categories", "(Ljava/util/List;)V", "", KFFeature.EFFECT_JSON_FIELD, "getEffects", "setEffects", "extra", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "Lcom/ss/ugc/effectplatform/model/UrlModel;", "icon", "getIcon", "()Lcom/ss/ugc/effectplatform/model/UrlModel;", "setIcon", "(Lcom/ss/ugc/effectplatform/model/UrlModel;)V", "icon_selected", "getIcon_selected", "setIcon_selected", "id", "getId", "setId", "", "isDefault", "()Z", "setDefault", "(Z)V", "is_default", "set_default", "getKCategoryModel", "()Lcom/ss/ugc/effectplatform/model/EffectCategoryModel;", "key", "getKey", "setKey", "name", "getName", "setName", "parent_category", "getParent_category", "()I", "setParent_category", "(I)V", PromotionProductPrivilegesStruct.TAGS, "getTags", "setTags", "tagsUpdateTime", "getTagsUpdateTime", "setTagsUpdateTime", "tags_updated_at", "getTags_updated_at", "setTags_updated_at", "setIsDefault", "", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class EffectCategoryModel extends EffectCategoryModelTemplate implements Serializable {
    private final transient com.ss.ugc.effectplatform.model.EffectCategoryModel kCategoryModel;

    /* JADX WARN: Multi-variable type inference failed */
    public EffectCategoryModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryModel
    public List<Integer> getChildren_categories() {
        com.ss.ugc.effectplatform.model.EffectCategoryModel r100 = getKCategoryModel();
        if (r100 == null) goto L8;
        List<Integer> r101 = r100.getChildren_categories();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getChildren_categories();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryModel
    public List<String> getEffects() {
        com.ss.ugc.effectplatform.model.EffectCategoryModel r100 = getKCategoryModel();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getEffects();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getEffects();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryModel
    public String getExtra() {
        com.ss.ugc.effectplatform.model.EffectCategoryModel r100 = getKCategoryModel();
        if (r100 == null) goto L8;
        String r101 = r100.getExtra();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getExtra();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryModel
    public UrlModel getIcon() {
        com.ss.ugc.effectplatform.model.EffectCategoryModel r100 = getKCategoryModel();
        if (r100 == null) goto L8;
        UrlModel r101 = r100.getIcon();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getIcon();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryModel
    public UrlModel getIcon_selected() {
        com.ss.ugc.effectplatform.model.EffectCategoryModel r100 = getKCategoryModel();
        if (r100 == null) goto L8;
        UrlModel r101 = r100.getIcon_selected();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getIcon_selected();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryModel
    public String getId() {
        com.ss.ugc.effectplatform.model.EffectCategoryModel r100 = getKCategoryModel();
        if (r100 == null) goto L8;
        String r101 = r100.getId();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getId();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryModel
    public String getKey() {
        com.ss.ugc.effectplatform.model.EffectCategoryModel r100 = getKCategoryModel();
        if (r100 == null) goto L8;
        String r101 = r100.getKey();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getKey();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryModel
    public String getName() {
        com.ss.ugc.effectplatform.model.EffectCategoryModel r100 = getKCategoryModel();
        if (r100 == null) goto L8;
        String r101 = r100.getName();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getName();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryModel
    public int getParent_category() {
        com.ss.ugc.effectplatform.model.EffectCategoryModel r100 = getKCategoryModel();
        if (r100 == null) goto L6;
        return r100.getParent_category();
    L6:
        return super.getParent_category();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryModel
    public List<String> getTags() {
        com.ss.ugc.effectplatform.model.EffectCategoryModel r100 = getKCategoryModel();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getTags();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getTags();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectCategoryModelTemplate
    public String getTagsUpdateTime() {
        return super.getTagsUpdateTime();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryModel
    public String getTags_updated_at() {
        com.ss.ugc.effectplatform.model.EffectCategoryModel r100 = getKCategoryModel();
        if (r100 == null) goto L8;
        String r101 = r100.getTags_updated_at();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getTags_updated_at();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectCategoryModelTemplate
    public boolean isDefault() {
        return super.isDefault();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryModel
    public boolean is_default() {
        com.ss.ugc.effectplatform.model.EffectCategoryModel r100 = getKCategoryModel();
        if (r100 == null) goto L6;
        return r100.is_default();
    L6:
        return super.is_default();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectCategoryModelTemplate
    public com.ss.ugc.effectplatform.model.EffectCategoryModel getKCategoryModel() {
        return this.kCategoryModel;
    }

    public EffectCategoryModel(com.ss.ugc.effectplatform.model.EffectCategoryModel r100) {
        super(r100);
        this.kCategoryModel = r100;
        com.ss.ugc.effectplatform.model.EffectCategoryModel r101 = getKCategoryModel();
        if (r101 == null) goto L35;
        List<Integer> r102 = r101.getChildren_categories();
        if (r102 == null) goto L7;
        super.setChildren_categories(r102);
    L7:
        List<String> r103 = r101.getEffects();
        if (r103 == null) goto L10;
        super.setEffects(r103);
    L10:
        String r104 = r101.getExtra();
        if (r104 == null) goto L13;
        super.setExtra(r104);
    L13:
        UrlModel r105 = r101.getIcon();
        if (r105 == null) goto L16;
        super.setIcon(r105);
    L16:
        UrlModel r106 = r101.getIcon_selected();
        if (r106 == null) goto L19;
        super.setIcon_selected(r106);
    L19:
        String r107 = r101.getId();
        if (r107 == null) goto L22;
        super.setId(r107);
    L22:
        super.set_default(r101.is_default());
        String r108 = r101.getKey();
        if (r108 == null) goto L25;
        super.setKey(r108);
    L25:
        String r109 = r101.getName();
        if (r109 == null) goto L28;
        super.setName(r109);
    L28:
        super.setParent_category(r101.getParent_category());
        List<String> r110 = r101.getTags();
        if (r110 == null) goto L31;
        super.setTags(r110);
    L31:
        String r111 = r101.getTags_updated_at();
        if (r111 == null) goto L36;
        super.setTags_updated_at(r111);
        return;
    L36:
        return;
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryModel
    public void setChildren_categories(List<Integer> r100) {
        com.ss.ugc.effectplatform.model.EffectCategoryModel r101 = getKCategoryModel();
        if (r101 == null) goto L5;
        r101.setChildren_categories(r100);
    L5:
        super.setChildren_categories(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectCategoryModelTemplate
    public void setDefault(boolean r100) {
        super.setDefault(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryModel
    public void setEffects(List<String> r100) {
        com.ss.ugc.effectplatform.model.EffectCategoryModel r101 = getKCategoryModel();
        if (r101 == null) goto L5;
        r101.setEffects(r100);
    L5:
        super.setEffects(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryModel
    public void setExtra(String r100) {
        com.ss.ugc.effectplatform.model.EffectCategoryModel r101 = getKCategoryModel();
        if (r101 == null) goto L5;
        r101.setExtra(r100);
    L5:
        super.setExtra(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryModel
    public void setIcon(UrlModel r100) {
        com.ss.ugc.effectplatform.model.EffectCategoryModel r101 = getKCategoryModel();
        if (r101 == null) goto L5;
        r101.setIcon(r100);
    L5:
        super.setIcon(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryModel
    public void setIcon_selected(UrlModel r100) {
        com.ss.ugc.effectplatform.model.EffectCategoryModel r101 = getKCategoryModel();
        if (r101 == null) goto L5;
        r101.setIcon_selected(r100);
    L5:
        super.setIcon_selected(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryModel
    public void setId(String r100) {
        com.ss.ugc.effectplatform.model.EffectCategoryModel r101 = getKCategoryModel();
        if (r101 == null) goto L5;
        r101.setId(r100);
    L5:
        super.setId(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectCategoryModelTemplate
    public void setIsDefault(boolean r100) {
        super.setIsDefault(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryModel
    public void setKey(String r100) {
        com.ss.ugc.effectplatform.model.EffectCategoryModel r101 = getKCategoryModel();
        if (r101 == null) goto L5;
        r101.setKey(r100);
    L5:
        super.setKey(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryModel
    public void setName(String r100) {
        com.ss.ugc.effectplatform.model.EffectCategoryModel r101 = getKCategoryModel();
        if (r101 == null) goto L5;
        r101.setName(r100);
    L5:
        super.setName(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryModel
    public void setParent_category(int r100) {
        com.ss.ugc.effectplatform.model.EffectCategoryModel r101 = getKCategoryModel();
        if (r101 == null) goto L5;
        r101.setParent_category(r100);
    L5:
        super.setParent_category(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryModel
    public void setTags(List<String> r100) {
        com.ss.ugc.effectplatform.model.EffectCategoryModel r101 = getKCategoryModel();
        if (r101 == null) goto L5;
        r101.setTags(r100);
    L5:
        super.setTags(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectCategoryModelTemplate
    public void setTagsUpdateTime(String r100) {
        super.setTagsUpdateTime(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryModel
    public void setTags_updated_at(String r100) {
        com.ss.ugc.effectplatform.model.EffectCategoryModel r101 = getKCategoryModel();
        if (r101 == null) goto L5;
        r101.setTags_updated_at(r100);
    L5:
        super.setTags_updated_at(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryModel
    public void set_default(boolean r100) {
        com.ss.ugc.effectplatform.model.EffectCategoryModel r101 = getKCategoryModel();
        if (r101 == null) goto L5;
        r101.set_default(r100);
    L5:
        super.set_default(r100);
    }

    public /* synthetic */ EffectCategoryModel(com.ss.ugc.effectplatform.model.EffectCategoryModel r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
