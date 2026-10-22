package com.ss.android.ugc.effectmanager.effect.model.template;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.effect.model.ProviderEffect;
import com.ss.ugc.effectplatform.model.ProviderEffectModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0016R&\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR*\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\r8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R2\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/template/ProviderEffectModelTemplate;", "Lcom/ss/ugc/effectplatform/model/ProviderEffectModel;", "kProviderEffect", "(Lcom/ss/ugc/effectplatform/model/ProviderEffectModel;)V", "value", "", "hasMore", "getHasMore", "()Z", "setHasMore", "(Z)V", "getKProviderEffect", "()Lcom/ss/ugc/effectplatform/model/ProviderEffectModel;", "", "searchTips", "getSearchTips", "()Ljava/lang/String;", "setSearchTips", "(Ljava/lang/String;)V", "", "Lcom/ss/android/ugc/effectmanager/effect/model/ProviderEffect;", "stickerList", "getStickerList", "()Ljava/util/List;", "setStickerList", "(Ljava/util/List;)V", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public class ProviderEffectModelTemplate extends ProviderEffectModel {
    private boolean hasMore;
    private final transient ProviderEffectModel kProviderEffect;
    private String searchTips;
    private List<ProviderEffect> stickerList;

    /* JADX WARN: Multi-variable type inference failed */
    public ProviderEffectModelTemplate() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public boolean getHasMore() {
        ProviderEffectModel r100 = getKProviderEffect();
        if (r100 == null) goto L6;
        return r100.getHas_more();
    L6:
        return super.getHas_more();
    }

    public String getSearchTips() {
        ProviderEffectModel r100 = getKProviderEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getSearch_tips();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getSearch_tips();
    }

    public List<ProviderEffect> getStickerList() {
        ProviderEffectModel r100 = getKProviderEffect();
        if (r100 == null) goto L7;
        List r101 = r100.getSticker_list();
        List r102 = r101;
        if (r101 == null) goto L7;
    L9:
        if ((!r102.isEmpty()) == false) goto L24;
        if ((ListProtector.get(r102, 0) instanceof ProviderEffect) == false) goto L16;
        if (r102 == null) goto L15;
        return r102;
    L15:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.ss.android.ugc.effectmanager.effect.model.ProviderEffect>");
    L16:
        List r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L18:
        if (r105.hasNext() == false) goto L20;
        r104.add(new ProviderEffect((com.ss.ugc.effectplatform.model.ProviderEffect) r105.next()));
        goto L18
    L20:
        if (r100 == null) goto L22;
        r100.setSticker_list(r104);
    L22:
        super.setSticker_list(r104);
        return r104;
    L24:
        return new ArrayList();
    L7:
        r102 = super.getSticker_list();
        goto L9
    }

    public boolean hasMore() {
        return getHasMore();
    }

    public ProviderEffectModel getKProviderEffect() {
        return this.kProviderEffect;
    }

    public ProviderEffectModelTemplate(ProviderEffectModel r110) {
        super(null, 0, false, null, null, null, 63, null);
        this.kProviderEffect = r110;
        this.stickerList = new ArrayList();
    }

    public void setHasMore(boolean r100) {
        this.hasMore = r100;
        ProviderEffectModel r101 = getKProviderEffect();
        if (r101 == null) goto L5;
        r101.setHas_more(r100);
    L5:
        super.setHas_more(r100);
    }

    public void setSearchTips(String r100) {
        this.searchTips = r100;
        ProviderEffectModel r101 = getKProviderEffect();
        if (r101 == null) goto L5;
        r101.setSearch_tips(r100);
    L5:
        super.setSearch_tips(r100);
    }

    public void setStickerList(List<ProviderEffect> r100) {
        this.stickerList = r100;
        ProviderEffectModel r101 = getKProviderEffect();
        if (r101 == null) goto L5;
        r101.setSticker_list(r100);
    L5:
        super.setSticker_list(r100);
    }

    public /* synthetic */ ProviderEffectModelTemplate(ProviderEffectModel r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
