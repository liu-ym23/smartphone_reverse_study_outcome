package com.ss.ugc.effectplatform.model.net;

import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.EffectCategoryModel;
import com.ss.ugc.effectplatform.model.EffectPanelModel;
import com.ss.ugc.effectplatform.model.PanelInfoModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001Bw\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011R\u001a\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/PanelInfoWithOneEffectData;", "", "version", "", "category_list", "", "Lcom/ss/ugc/effectplatform/model/EffectCategoryModel;", "front_effect", "Lcom/ss/ugc/effectplatform/model/Effect;", "rear_effect", "url_prefix", "panel", "Lcom/ss/ugc/effectplatform/model/EffectPanelModel;", "category_effect_list", "Lcom/ss/ugc/effectplatform/model/net/CategoryEffect;", "extra", "Lcom/ss/ugc/effectplatform/model/PanelInfoModel$Extra;", "(Ljava/lang/String;Ljava/util/List;Lcom/ss/ugc/effectplatform/model/Effect;Lcom/ss/ugc/effectplatform/model/Effect;Ljava/util/List;Lcom/ss/ugc/effectplatform/model/EffectPanelModel;Ljava/util/List;Lcom/ss/ugc/effectplatform/model/PanelInfoModel$Extra;)V", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class PanelInfoWithOneEffectData {
    public List<CategoryEffect> category_effect_list;
    public List<? extends EffectCategoryModel> category_list;
    public PanelInfoModel.Extra extra;
    public Effect front_effect;
    public EffectPanelModel panel;
    public Effect rear_effect;
    public List<String> url_prefix;
    public String version;

    public PanelInfoWithOneEffectData() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public PanelInfoWithOneEffectData(String r100, List<? extends EffectCategoryModel> r101, Effect r102, Effect r103, List<String> r104, EffectPanelModel r105, List<CategoryEffect> r106, PanelInfoModel.Extra r107) {
        this.version = r100;
        this.category_list = r101;
        this.front_effect = r102;
        this.rear_effect = r103;
        this.url_prefix = r104;
        this.panel = r105;
        this.category_effect_list = r106;
        this.extra = r107;
    }

    public /* synthetic */ PanelInfoWithOneEffectData(String r110, List r111, Effect r112, Effect r113, List r114, EffectPanelModel r115, List r116, PanelInfoModel.Extra r117, int r118, DefaultConstructorMarker r119) {
        PanelInfoModel.Extra r100 = null;
        if ((r118 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        List r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        Effect r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Effect r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        List r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        EffectPanelModel r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        List r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
