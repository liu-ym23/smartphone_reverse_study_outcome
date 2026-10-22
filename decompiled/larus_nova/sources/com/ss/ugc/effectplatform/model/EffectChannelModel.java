package com.ss.ugc.effectplatform.model;

import com.facebook.keyframes.model.KFFeature;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\b\u0017\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u000fJ\u0006\u0010+\u001a\u00020,R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R0\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010 \u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001d\"\u0004\b&\u0010\u001fR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0013\"\u0004\b(\u0010\u0015R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001d\"\u0004\b*\u0010\u001f¨\u0006-"}, d2 = {"Lcom/ss/ugc/effectplatform/model/EffectChannelModel;", "", "version", "", KFFeature.EFFECT_JSON_FIELD, "", "Lcom/ss/ugc/effectplatform/model/Effect;", "category", "Lcom/ss/ugc/effectplatform/model/EffectCategoryModel;", "panel", "Lcom/ss/ugc/effectplatform/model/EffectPanelModel;", "front_effect_id", "rear_effect_id", "collection", "url_prefix", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/ss/ugc/effectplatform/model/EffectPanelModel;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "value", "category_list", "getCategory_list", "()Ljava/util/List;", "setCategory_list", "(Ljava/util/List;)V", "collection_list", "getCollection_list", "setCollection_list", "effect_list", "getEffect_list", "setEffect_list", "getFront_effect_id", "()Ljava/lang/String;", "setFront_effect_id", "(Ljava/lang/String;)V", "panel_model", "getPanel_model", "()Lcom/ss/ugc/effectplatform/model/EffectPanelModel;", "setPanel_model", "(Lcom/ss/ugc/effectplatform/model/EffectPanelModel;)V", "getRear_effect_id", "setRear_effect_id", "getUrl_prefix", "setUrl_prefix", "getVersion", "setVersion", "checkValued", "", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class EffectChannelModel {
    private List<? extends EffectCategoryModel> category;
    private List<? extends Effect> collection;
    private List<? extends Effect> effects;
    private String front_effect_id;
    private EffectPanelModel panel;
    private String rear_effect_id;
    private List<String> url_prefix;
    private String version;

    public EffectChannelModel() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public final boolean checkValued() {
        return getPanel_model().checkValued();
    }

    public final List<EffectCategoryModel> getCategory_list() {
        return this.category;
    }

    public final List<Effect> getCollection_list() {
        return this.collection;
    }

    public final List<Effect> getEffect_list() {
        return this.effects;
    }

    public String getFront_effect_id() {
        return this.front_effect_id;
    }

    public final EffectPanelModel getPanel_model() {
        return this.panel;
    }

    public String getRear_effect_id() {
        return this.rear_effect_id;
    }

    public List<String> getUrl_prefix() {
        return this.url_prefix;
    }

    public String getVersion() {
        return this.version;
    }

    public final void setCategory_list(List<? extends EffectCategoryModel> r100) {
        this.category = r100;
    }

    public final void setCollection_list(List<? extends Effect> r100) {
        this.collection = r100;
    }

    public final void setEffect_list(List<? extends Effect> r100) {
        this.effects = r100;
    }

    public void setFront_effect_id(String r100) {
        this.front_effect_id = r100;
    }

    public final void setPanel_model(EffectPanelModel r100) {
        this.panel = r100;
    }

    public void setRear_effect_id(String r100) {
        this.rear_effect_id = r100;
    }

    public void setUrl_prefix(List<String> r100) {
        this.url_prefix = r100;
    }

    public void setVersion(String r100) {
        this.version = r100;
    }

    public EffectChannelModel(String r100, List<? extends Effect> r101, List<? extends EffectCategoryModel> r102, EffectPanelModel r103, String r104, String r105, List<? extends Effect> r106, List<String> r107) {
        this.version = r100;
        this.effects = r101;
        this.category = r102;
        this.panel = r103;
        this.front_effect_id = r104;
        this.rear_effect_id = r105;
        this.collection = r106;
        this.url_prefix = r107;
    }

    public /* synthetic */ EffectChannelModel(String r110, List r111, List r112, EffectPanelModel r113, String r210, String r211, List r212, List r213, int r214, DefaultConstructorMarker r215) {
        String r100 = null;
        if ((r214 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r214 & 2) == 0) goto L9;
        List r102 = new ArrayList();
    L11:
        if ((r214 & 4) == 0) goto L13;
        List r103 = new ArrayList();
    L15:
        if ((r214 & 8) == 0) goto L17;
        EffectPanelModel r104 = new EffectPanelModel(null, null, null, null, null, null, 63, null);
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r214 & 32) != 0) goto L27;
        r100 = r211;
    L27:
        if ((r214 & 64) == 0) goto L29;
        List r106 = new ArrayList();
    L31:
        if ((r214 & 128) == 0) goto L33;
        List r107 = new ArrayList();
    L34:
        this(r101, r102, r103, r104, r105, r100, r106, r107);
        return;
    L33:
        r107 = r213;
        goto L34
    L29:
        r106 = r212;
        goto L31
    L21:
        r105 = r210;
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
