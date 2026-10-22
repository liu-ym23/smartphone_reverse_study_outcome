package com.ss.ugc.effectplatform.model.net;

import com.ss.ugc.effectplatform.model.CategoryEffectModel;
import com.ss.ugc.effectplatform.model.CategoryPageModel;
import com.ss.ugc.effectplatform.model.PanelInfoModel;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/PanelInfoPagingModel;", "", "panelInfoResponse", "Lcom/ss/ugc/effectplatform/model/net/PanelInfoResponse;", "categoryEffectsResponse", "Lcom/ss/ugc/effectplatform/model/net/CategoryEffectListResponse;", "(Lcom/ss/ugc/effectplatform/model/net/PanelInfoResponse;Lcom/ss/ugc/effectplatform/model/net/CategoryEffectListResponse;)V", "getCategoryEffectsResponse", "()Lcom/ss/ugc/effectplatform/model/net/CategoryEffectListResponse;", "setCategoryEffectsResponse", "(Lcom/ss/ugc/effectplatform/model/net/CategoryEffectListResponse;)V", "getPanelInfoResponse", "()Lcom/ss/ugc/effectplatform/model/net/PanelInfoResponse;", "setPanelInfoResponse", "(Lcom/ss/ugc/effectplatform/model/net/PanelInfoResponse;)V", "getPanelInfo", "Lcom/ss/ugc/effectplatform/model/PanelInfoModel;", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class PanelInfoPagingModel {
    private CategoryEffectListResponse categoryEffectsResponse;
    private PanelInfoResponse panelInfoResponse;

    public final PanelInfoModel getPanelInfo() {
        PanelInfoResponse r100 = this.panelInfoResponse;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getData();
    }

    public final CategoryEffectListResponse getCategoryEffectsResponse() {
        return this.categoryEffectsResponse;
    }

    public final PanelInfoResponse getPanelInfoResponse() {
        return this.panelInfoResponse;
    }

    public final void setCategoryEffectsResponse(CategoryEffectListResponse r100) {
        this.categoryEffectsResponse = r100;
    }

    public final void setPanelInfoResponse(PanelInfoResponse r100) {
        this.panelInfoResponse = r100;
    }

    public PanelInfoPagingModel(PanelInfoResponse r100, CategoryEffectListResponse r101) {
        this.panelInfoResponse = r100;
        this.categoryEffectsResponse = r101;
        if (r100 == null) goto L13;
        PanelInfoModel r102 = r100.getData();
        if (r102 == null) goto L13;
        CategoryEffectListResponse r103 = this.categoryEffectsResponse;
        if (r103 == null) goto L11;
        CategoryPageModel r104 = r103.getData();
        if (r104 == null) goto L11;
        CategoryEffectModel r105 = r104.getCategory_effects();
    L12:
        r102.setCategory_effects(r105);
    L11:
        r105 = null;
    L13:
        CategoryEffectListResponse r106 = this.categoryEffectsResponse;
        if (r106 == null) goto L24;
        CategoryPageModel r107 = r106.getData();
        if (r107 == null) goto L24;
        List<String> r108 = r107.getUrl_prefix();
        if (r108 == null) goto L24;
        PanelInfoResponse r109 = this.panelInfoResponse;
        if (r109 == null) goto L24;
        PanelInfoModel r110 = r109.getData();
        if (r110 == null) goto L24;
        r110.setUrl_prefix(r108);
    L24:
        CategoryEffectListResponse r111 = this.categoryEffectsResponse;
        if (r111 == null) goto L38;
        CategoryPageModel r112 = r111.getData();
        if (r112 == null) goto L39;
        CategoryPageModel.Extra r113 = r112.getExtra();
        if (r113 == null) goto L40;
        String r114 = r113.getRec_id();
        if (r114 == null) goto L41;
        PanelInfoModel.Extra r115 = new PanelInfoModel.Extra();
        r115.setRec_id(r114);
        PanelInfoResponse r116 = this.panelInfoResponse;
        if (r116 == null) goto L42;
        PanelInfoModel r117 = r116.getData();
        if (r117 == null) goto L43;
        r117.setExtra(r115);
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    }
}
