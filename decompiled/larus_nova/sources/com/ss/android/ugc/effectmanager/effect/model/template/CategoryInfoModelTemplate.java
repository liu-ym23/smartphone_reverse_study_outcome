package com.ss.android.ugc.effectmanager.effect.model.template;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryModel;
import com.ss.ugc.effectplatform.model.EffectCategoryModelList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003R6\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/template/CategoryInfoModelTemplate;", "Lcom/ss/ugc/effectplatform/model/EffectCategoryModelList;", "kCategoryModel", "(Lcom/ss/ugc/effectplatform/model/EffectCategoryModelList;)V", "value", "", "Lcom/ss/android/ugc/effectmanager/effect/model/EffectCategoryModel;", "categoryList", "getCategoryList", "()Ljava/util/List;", "setCategoryList", "(Ljava/util/List;)V", "getKCategoryModel", "()Lcom/ss/ugc/effectplatform/model/EffectCategoryModelList;", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public class CategoryInfoModelTemplate extends EffectCategoryModelList {
    private List<EffectCategoryModel> categoryList;
    private final transient EffectCategoryModelList kCategoryModel;

    /* JADX WARN: Multi-variable type inference failed */
    public CategoryInfoModelTemplate() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public List<EffectCategoryModel> getCategoryList() {
        EffectCategoryModelList r100 = getKCategoryModel();
        if (r100 == null) goto L7;
        List r101 = r100.getCategory_list();
        List r102 = r101;
        if (r101 == null) goto L7;
    L8:
        if (r102 != null) goto L10;
    L21:
        return null;
    L10:
        if ((!r102.isEmpty()) != true) goto L21;
        if ((ListProtector.get(r102, 0) instanceof EffectCategoryModel) == true) goto L25;
        List r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L16:
        if (r105.hasNext() == false) goto L18;
        r104.add(new EffectCategoryModel((com.ss.ugc.effectplatform.model.EffectCategoryModel) r105.next()));
        goto L16
    L18:
        if (r100 == null) goto L20;
        r100.setCategory_list(r104);
    L20:
        super.setCategory_list(r104);
        return r104;
    L25:
        return r102;
    L7:
        r102 = super.getCategory_list();
        goto L8
    }

    public EffectCategoryModelList getKCategoryModel() {
        return this.kCategoryModel;
    }

    public CategoryInfoModelTemplate(EffectCategoryModelList r100) {
        this.kCategoryModel = r100;
    }

    public void setCategoryList(List<EffectCategoryModel> r100) {
        this.categoryList = r100;
        EffectCategoryModelList r101 = getKCategoryModel();
        if (r101 == null) goto L5;
        r101.setCategory_list(r100);
    L5:
        super.setCategory_list(r100);
    }

    public /* synthetic */ CategoryInfoModelTemplate(EffectCategoryModelList r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
