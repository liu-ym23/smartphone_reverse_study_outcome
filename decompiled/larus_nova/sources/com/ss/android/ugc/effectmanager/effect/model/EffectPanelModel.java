package com.ss.android.ugc.effectmanager.effect.model;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.ss.android.ugc.effectmanager.effect.model.template.EffectPanelModelTemplate;
import com.ss.ugc.effectplatform.model.UrlModel;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\f\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR(\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\r8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\u0013\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R0\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u00182\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00188V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010\u001e\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\n\"\u0004\b \u0010\fR(\u0010!\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\"\u0010\n\"\u0004\b#\u0010\f¨\u0006$"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/EffectPanelModel;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/EffectPanelModelTemplate;", "Ljava/io/Serializable;", "kPanelModel", "Lcom/ss/ugc/effectplatform/model/EffectPanelModel;", "(Lcom/ss/ugc/effectplatform/model/EffectPanelModel;)V", "value", "", "extra", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "Lcom/ss/ugc/effectplatform/model/UrlModel;", "icon", "getIcon", "()Lcom/ss/ugc/effectplatform/model/UrlModel;", "setIcon", "(Lcom/ss/ugc/effectplatform/model/UrlModel;)V", "id", "getId", "setId", "getKPanelModel", "()Lcom/ss/ugc/effectplatform/model/EffectPanelModel;", "", PromotionProductPrivilegesStruct.TAGS, "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "tags_updated_at", "getTags_updated_at", "setTags_updated_at", "text", "getText", "setText", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class EffectPanelModel extends EffectPanelModelTemplate implements Serializable {
    private final transient com.ss.ugc.effectplatform.model.EffectPanelModel kPanelModel;

    /* JADX WARN: Multi-variable type inference failed */
    public EffectPanelModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectPanelModel
    public String getExtra() {
        com.ss.ugc.effectplatform.model.EffectPanelModel r100 = getKPanelModel();
        if (r100 == null) goto L8;
        String r101 = r100.getExtra();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getExtra();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectPanelModel
    public UrlModel getIcon() {
        com.ss.ugc.effectplatform.model.EffectPanelModel r100 = getKPanelModel();
        if (r100 == null) goto L8;
        UrlModel r101 = r100.getIcon();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getIcon();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectPanelModel
    public String getId() {
        com.ss.ugc.effectplatform.model.EffectPanelModel r100 = getKPanelModel();
        if (r100 == null) goto L8;
        String r101 = r100.getId();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getId();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectPanelModel
    public List<String> getTags() {
        com.ss.ugc.effectplatform.model.EffectPanelModel r100 = getKPanelModel();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getTags();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getTags();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectPanelModel
    public String getTags_updated_at() {
        com.ss.ugc.effectplatform.model.EffectPanelModel r100 = getKPanelModel();
        if (r100 == null) goto L8;
        String r101 = r100.getTags_updated_at();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getTags_updated_at();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectPanelModel
    public String getText() {
        com.ss.ugc.effectplatform.model.EffectPanelModel r100 = getKPanelModel();
        if (r100 == null) goto L8;
        String r101 = r100.getText();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getText();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectPanelModelTemplate
    public com.ss.ugc.effectplatform.model.EffectPanelModel getKPanelModel() {
        return this.kPanelModel;
    }

    public EffectPanelModel(com.ss.ugc.effectplatform.model.EffectPanelModel r100) {
        super(r100);
        this.kPanelModel = r100;
        com.ss.ugc.effectplatform.model.EffectPanelModel r101 = getKPanelModel();
        if (r101 == null) goto L23;
        String r102 = r101.getExtra();
        if (r102 == null) goto L7;
        super.setExtra(r102);
    L7:
        UrlModel r103 = r101.getIcon();
        if (r103 == null) goto L10;
        super.setIcon(r103);
    L10:
        String r104 = r101.getId();
        if (r104 == null) goto L13;
        super.setId(r104);
    L13:
        List<String> r105 = r101.getTags();
        if (r105 == null) goto L16;
        super.setTags(r105);
    L16:
        String r106 = r101.getTags_updated_at();
        if (r106 == null) goto L19;
        super.setTags_updated_at(r106);
    L19:
        String r107 = r101.getText();
        if (r107 == null) goto L24;
        super.setText(r107);
        return;
    L24:
        return;
    }

    @Override // com.ss.ugc.effectplatform.model.EffectPanelModel
    public void setExtra(String r100) {
        com.ss.ugc.effectplatform.model.EffectPanelModel r101 = getKPanelModel();
        if (r101 == null) goto L5;
        r101.setExtra(r100);
    L5:
        super.setExtra(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectPanelModel
    public void setIcon(UrlModel r100) {
        com.ss.ugc.effectplatform.model.EffectPanelModel r101 = getKPanelModel();
        if (r101 == null) goto L5;
        r101.setIcon(r100);
    L5:
        super.setIcon(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectPanelModel
    public void setId(String r100) {
        com.ss.ugc.effectplatform.model.EffectPanelModel r101 = getKPanelModel();
        if (r101 == null) goto L5;
        r101.setId(r100);
    L5:
        super.setId(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectPanelModel
    public void setTags(List<String> r100) {
        com.ss.ugc.effectplatform.model.EffectPanelModel r101 = getKPanelModel();
        if (r101 == null) goto L5;
        r101.setTags(r100);
    L5:
        super.setTags(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectPanelModel
    public void setTags_updated_at(String r100) {
        com.ss.ugc.effectplatform.model.EffectPanelModel r101 = getKPanelModel();
        if (r101 == null) goto L5;
        r101.setTags_updated_at(r100);
    L5:
        super.setTags_updated_at(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectPanelModel
    public void setText(String r100) {
        com.ss.ugc.effectplatform.model.EffectPanelModel r101 = getKPanelModel();
        if (r101 == null) goto L5;
        r101.setText(r100);
    L5:
        super.setText(r100);
    }

    public /* synthetic */ EffectPanelModel(com.ss.ugc.effectplatform.model.EffectPanelModel r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
