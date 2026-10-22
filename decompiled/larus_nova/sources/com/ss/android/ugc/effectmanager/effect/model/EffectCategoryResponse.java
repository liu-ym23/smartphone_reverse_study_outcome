package com.ss.android.ugc.effectmanager.effect.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.ss.android.ugc.effectmanager.effect.model.template.EffectCategoryResponseTemplate;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 V2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001VB\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020UH\u0016R0\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR0\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000f0\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR(\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u0019\u001a\u0004\u0018\u00010\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010#\u001a\u0004\u0018\u00010\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0016\"\u0004\b%\u0010\u0018R(\u0010&\u001a\u0004\u0018\u00010\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R$\u0010)\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00138V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b*\u0010\u0016\"\u0004\b+\u0010\u0018R$\u0010-\u001a\u00020,2\u0006\u0010\u0007\u001a\u00020,8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00101\u001a\u00020,2\u0006\u0010\u0007\u001a\u00020,8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b1\u0010.\"\u0004\b2\u00100R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R$\u00105\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00138V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b6\u0010\u0016\"\u0004\b7\u0010\u0018R$\u00108\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00138V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b9\u0010\u0016\"\u0004\b:\u0010\u0018R(\u0010;\u001a\u0004\u0018\u00010\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b<\u0010\u001b\"\u0004\b=\u0010\u001dR(\u0010>\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b?\u0010 \"\u0004\b@\u0010\"R0\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00130\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00130\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bB\u0010\f\"\u0004\bC\u0010\u000eR(\u0010D\u001a\u0004\u0018\u00010\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bE\u0010\u0016\"\u0004\bF\u0010\u0018R(\u0010G\u001a\u0004\u0018\u00010\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bH\u0010\u0016\"\u0004\bI\u0010\u0018R0\u0010J\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bK\u0010\f\"\u0004\bL\u0010\u000eR0\u0010M\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000f0\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bN\u0010\f\"\u0004\bO\u0010\u000e¨\u0006W"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/EffectCategoryResponse;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/EffectCategoryResponseTemplate;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "kCategoryResponse", "Lcom/ss/ugc/effectplatform/model/EffectCategoryResponse;", "(Lcom/ss/ugc/effectplatform/model/EffectCategoryResponse;)V", "value", "", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "collectionEffect", "getCollectionEffect", "()Ljava/util/List;", "setCollectionEffect", "(Ljava/util/List;)V", "Lcom/ss/ugc/effectplatform/model/Effect;", "collection_effect", "getCollection_effect", "setCollection_effect", "", "extra", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "frontEffect", "getFrontEffect", "()Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "setFrontEffect", "(Lcom/ss/android/ugc/effectmanager/effect/model/Effect;)V", "front_effect", "getFront_effect", "()Lcom/ss/ugc/effectplatform/model/Effect;", "setFront_effect", "(Lcom/ss/ugc/effectplatform/model/Effect;)V", "icon_normal_url", "getIcon_normal_url", "setIcon_normal_url", "icon_selected_url", "getIcon_selected_url", "setIcon_selected_url", "id", "getId", "setId", "", "isDefault", "()Z", "setDefault", "(Z)V", "is_default", "set_default", "getKCategoryResponse", "()Lcom/ss/ugc/effectplatform/model/EffectCategoryResponse;", "key", "getKey", "setKey", "name", "getName", "setName", "rearEffect", "getRearEffect", "setRearEffect", "rear_effect", "getRear_effect", "setRear_effect", PromotionProductPrivilegesStruct.TAGS, "getTags", "setTags", "tagsUpdateTime", "getTagsUpdateTime", "setTagsUpdateTime", "tags_update_time", "getTags_update_time", "setTags_update_time", "totalEffects", "getTotalEffects", "setTotalEffects", "total_effects", "getTotal_effects", "setTotal_effects", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "", "Companion", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class EffectCategoryResponse extends EffectCategoryResponseTemplate implements Serializable, Parcelable {
    public static final Parcelable.Creator<EffectCategoryResponse> CREATOR = null;
    public static final Companion Companion = null;
    private final transient com.ss.ugc.effectplatform.model.EffectCategoryResponse kCategoryResponse;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/EffectCategoryResponse$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/ss/android/ugc/effectmanager/effect/model/EffectCategoryResponse;", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EffectCategoryResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    static {
        Companion = new Companion(null);
        CREATOR = new EffectCategoryResponse$Companion$CREATOR$1();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectCategoryResponseTemplate
    public List<Effect> getCollectionEffect() {
        return super.getCollectionEffect();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryResponse
    public List<com.ss.ugc.effectplatform.model.Effect> getCollection_effect() {
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r100 = getKCategoryResponse();
        if (r100 == null) goto L8;
        List<com.ss.ugc.effectplatform.model.Effect> r101 = r100.getCollection_effect();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getCollection_effect();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryResponse
    public String getExtra() {
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r100 = getKCategoryResponse();
        if (r100 == null) goto L8;
        String r101 = r100.getExtra();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getExtra();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectCategoryResponseTemplate
    public Effect getFrontEffect() {
        return super.getFrontEffect();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryResponse
    public com.ss.ugc.effectplatform.model.Effect getFront_effect() {
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r100 = getKCategoryResponse();
        if (r100 == null) goto L8;
        com.ss.ugc.effectplatform.model.Effect r101 = r100.getFront_effect();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getFront_effect();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryResponse
    public String getIcon_normal_url() {
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r100 = getKCategoryResponse();
        if (r100 == null) goto L8;
        String r101 = r100.getIcon_normal_url();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getIcon_normal_url();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryResponse
    public String getIcon_selected_url() {
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r100 = getKCategoryResponse();
        if (r100 == null) goto L8;
        String r101 = r100.getIcon_selected_url();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getIcon_selected_url();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryResponse
    public String getId() {
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r100 = getKCategoryResponse();
        if (r100 == null) goto L8;
        String r101 = r100.getId();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getId();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryResponse
    public String getKey() {
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r100 = getKCategoryResponse();
        if (r100 == null) goto L8;
        String r101 = r100.getKey();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getKey();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryResponse
    public String getName() {
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r100 = getKCategoryResponse();
        if (r100 == null) goto L8;
        String r101 = r100.getName();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getName();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectCategoryResponseTemplate
    public Effect getRearEffect() {
        return super.getRearEffect();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryResponse
    public com.ss.ugc.effectplatform.model.Effect getRear_effect() {
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r100 = getKCategoryResponse();
        if (r100 == null) goto L8;
        com.ss.ugc.effectplatform.model.Effect r101 = r100.getRear_effect();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getRear_effect();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryResponse
    public List<String> getTags() {
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r100 = getKCategoryResponse();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getTags();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getTags();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectCategoryResponseTemplate
    public String getTagsUpdateTime() {
        return super.getTagsUpdateTime();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryResponse
    public String getTags_update_time() {
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r100 = getKCategoryResponse();
        if (r100 == null) goto L8;
        String r101 = r100.getTags_update_time();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getTags_update_time();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectCategoryResponseTemplate
    public List<Effect> getTotalEffects() {
        return super.getTotalEffects();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryResponse
    public List<com.ss.ugc.effectplatform.model.Effect> getTotal_effects() {
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r100 = getKCategoryResponse();
        if (r100 == null) goto L8;
        List<com.ss.ugc.effectplatform.model.Effect> r101 = r100.getTotal_effects();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getTotal_effects();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectCategoryResponseTemplate
    public boolean isDefault() {
        return super.isDefault();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryResponse
    public boolean is_default() {
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r100 = getKCategoryResponse();
        if (r100 == null) goto L6;
        return r100.is_default();
    L6:
        return super.is_default();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectCategoryResponseTemplate
    public com.ss.ugc.effectplatform.model.EffectCategoryResponse getKCategoryResponse() {
        return this.kCategoryResponse;
    }

    public EffectCategoryResponse(com.ss.ugc.effectplatform.model.EffectCategoryResponse r100) {
        super(r100);
        this.kCategoryResponse = r100;
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r101 = getKCategoryResponse();
        if (r101 == null) goto L41;
        List<com.ss.ugc.effectplatform.model.Effect> r102 = r101.getCollection_effect();
        if (r102 == null) goto L7;
        super.setCollection_effect(r102);
    L7:
        String r103 = r101.getExtra();
        if (r103 == null) goto L10;
        super.setExtra(r103);
    L10:
        com.ss.ugc.effectplatform.model.Effect r104 = r101.getFront_effect();
        if (r104 == null) goto L13;
        super.setFront_effect(r104);
    L13:
        String r105 = r101.getIcon_normal_url();
        if (r105 == null) goto L16;
        super.setIcon_normal_url(r105);
    L16:
        String r106 = r101.getIcon_selected_url();
        if (r106 == null) goto L19;
        super.setIcon_selected_url(r106);
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
        com.ss.ugc.effectplatform.model.Effect r110 = r101.getRear_effect();
        if (r110 == null) goto L31;
        super.setRear_effect(r110);
    L31:
        List<String> r111 = r101.getTags();
        if (r111 == null) goto L34;
        super.setTags(r111);
    L34:
        String r112 = r101.getTags_update_time();
        if (r112 == null) goto L37;
        super.setTags_update_time(r112);
    L37:
        List<com.ss.ugc.effectplatform.model.Effect> r113 = r101.getTotal_effects();
        if (r113 == null) goto L42;
        super.setTotal_effects(r113);
        return;
    L42:
        return;
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectCategoryResponseTemplate
    public void setCollectionEffect(List<? extends Effect> r100) {
        super.setCollectionEffect(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryResponse
    public void setCollection_effect(List<? extends com.ss.ugc.effectplatform.model.Effect> r100) {
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r101 = getKCategoryResponse();
        if (r101 == null) goto L5;
        r101.setCollection_effect(r100);
    L5:
        super.setCollection_effect(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectCategoryResponseTemplate
    public void setDefault(boolean r100) {
        super.setDefault(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryResponse
    public void setExtra(String r100) {
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r101 = getKCategoryResponse();
        if (r101 == null) goto L5;
        r101.setExtra(r100);
    L5:
        super.setExtra(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectCategoryResponseTemplate
    public void setFrontEffect(Effect r100) {
        super.setFrontEffect(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryResponse
    public void setFront_effect(com.ss.ugc.effectplatform.model.Effect r100) {
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r101 = getKCategoryResponse();
        if (r101 == null) goto L5;
        r101.setFront_effect(r100);
    L5:
        super.setFront_effect(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryResponse
    public void setIcon_normal_url(String r100) {
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r101 = getKCategoryResponse();
        if (r101 == null) goto L5;
        r101.setIcon_normal_url(r100);
    L5:
        super.setIcon_normal_url(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryResponse
    public void setIcon_selected_url(String r100) {
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r101 = getKCategoryResponse();
        if (r101 == null) goto L5;
        r101.setIcon_selected_url(r100);
    L5:
        super.setIcon_selected_url(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryResponse
    public void setId(String r100) {
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r101 = getKCategoryResponse();
        if (r101 == null) goto L5;
        r101.setId(r100);
    L5:
        super.setId(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryResponse
    public void setKey(String r100) {
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r101 = getKCategoryResponse();
        if (r101 == null) goto L5;
        r101.setKey(r100);
    L5:
        super.setKey(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryResponse
    public void setName(String r100) {
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r101 = getKCategoryResponse();
        if (r101 == null) goto L5;
        r101.setName(r100);
    L5:
        super.setName(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectCategoryResponseTemplate
    public void setRearEffect(Effect r100) {
        super.setRearEffect(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryResponse
    public void setRear_effect(com.ss.ugc.effectplatform.model.Effect r100) {
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r101 = getKCategoryResponse();
        if (r101 == null) goto L5;
        r101.setRear_effect(r100);
    L5:
        super.setRear_effect(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryResponse
    public void setTags(List<String> r100) {
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r101 = getKCategoryResponse();
        if (r101 == null) goto L5;
        r101.setTags(r100);
    L5:
        super.setTags(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectCategoryResponseTemplate
    public void setTagsUpdateTime(String r100) {
        super.setTagsUpdateTime(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryResponse
    public void setTags_update_time(String r100) {
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r101 = getKCategoryResponse();
        if (r101 == null) goto L5;
        r101.setTags_update_time(r100);
    L5:
        super.setTags_update_time(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectCategoryResponseTemplate
    public void setTotalEffects(List<? extends Effect> r100) {
        super.setTotalEffects(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryResponse
    public void setTotal_effects(List<? extends com.ss.ugc.effectplatform.model.Effect> r100) {
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r101 = getKCategoryResponse();
        if (r101 == null) goto L5;
        r101.setTotal_effects(r100);
    L5:
        super.setTotal_effects(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryResponse
    public void set_default(boolean r100) {
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r101 = getKCategoryResponse();
        if (r101 == null) goto L5;
        r101.set_default(r100);
    L5:
        super.set_default(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryResponse, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        if (getKCategoryResponse() == null) goto L7;
        com.ss.ugc.effectplatform.model.EffectCategoryResponse r102 = getKCategoryResponse();
        if (r102 == null) goto L9;
        r102.writeToParcel(r100, r101);
        return;
    L9:
        return;
    L7:
        super.writeToParcel(r100, r101);
    }

    public /* synthetic */ EffectCategoryResponse(com.ss.ugc.effectplatform.model.EffectCategoryResponse r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
