package com.ss.android.ugc.effectmanager.effect.model.template;

import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import com.ss.ugc.effectplatform.model.EffectCategoryModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R&\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR*\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/template/EffectCategoryModelTemplate;", "Lcom/ss/ugc/effectplatform/model/EffectCategoryModel;", "kCategoryModel", "(Lcom/ss/ugc/effectplatform/model/EffectCategoryModel;)V", "value", "", "isDefault", "()Z", "setDefault", "(Z)V", "getKCategoryModel", "()Lcom/ss/ugc/effectplatform/model/EffectCategoryModel;", "", "tagsUpdateTime", "getTagsUpdateTime", "()Ljava/lang/String;", "setTagsUpdateTime", "(Ljava/lang/String;)V", "setIsDefault", "", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public class EffectCategoryModelTemplate extends EffectCategoryModel {
    private boolean isDefault;
    private final transient EffectCategoryModel kCategoryModel;
    private String tagsUpdateTime;

    /* JADX WARN: Multi-variable type inference failed */
    public EffectCategoryModelTemplate() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public String getTagsUpdateTime() {
        EffectCategoryModel r100 = getKCategoryModel();
        if (r100 == null) goto L8;
        String r101 = r100.getTags_updated_at();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getTags_updated_at();
    }

    public boolean isDefault() {
        EffectCategoryModel r100 = getKCategoryModel();
        if (r100 == null) goto L6;
        return r100.is_default();
    L6:
        return super.is_default();
    }

    public EffectCategoryModel getKCategoryModel() {
        return this.kCategoryModel;
    }

    public EffectCategoryModelTemplate(EffectCategoryModel r110) {
        super(null, null, null, null, null, null, null, null, false, null, 0, null, UnixStat.PERM_MASK, null);
        this.kCategoryModel = r110;
    }

    public void setDefault(boolean r100) {
        this.isDefault = r100;
        EffectCategoryModel r101 = getKCategoryModel();
        if (r101 == null) goto L5;
        r101.set_default(r100);
    L5:
        super.set_default(r100);
    }

    public void setIsDefault(boolean r100) {
        EffectCategoryModel r101 = getKCategoryModel();
        if (r101 == null) goto L5;
        r101.set_default(is_default());
    L5:
        super.set_default(is_default());
    }

    public void setTagsUpdateTime(String r100) {
        this.tagsUpdateTime = r100;
        EffectCategoryModel r101 = getKCategoryModel();
        if (r101 == null) goto L5;
        r101.setTags_updated_at(r100);
    L5:
        super.setTags_updated_at(r100);
    }

    public /* synthetic */ EffectCategoryModelTemplate(EffectCategoryModel r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
