package com.ss.ugc.effectplatform.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0017\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\t\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\u0010\u0010R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\f\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0012\"\u0004\b(\u0010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010 ¨\u0006+"}, d2 = {"Lcom/ss/ugc/effectplatform/model/EffectChannelResponse;", "", "panel", "", "version", "front_effect", "Lcom/ss/ugc/effectplatform/model/Effect;", "rear_effect", "all_category_effects", "", "category_responses", "Lcom/ss/ugc/effectplatform/model/EffectCategoryResponse;", "panel_model", "Lcom/ss/ugc/effectplatform/model/EffectPanelModel;", "collection_list", "url_prefix", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/Effect;Lcom/ss/ugc/effectplatform/model/Effect;Ljava/util/List;Ljava/util/List;Lcom/ss/ugc/effectplatform/model/EffectPanelModel;Ljava/util/List;Ljava/util/List;)V", "getAll_category_effects", "()Ljava/util/List;", "setAll_category_effects", "(Ljava/util/List;)V", "getCategory_responses", "setCategory_responses", "getCollection_list", "setCollection_list", "getFront_effect", "()Lcom/ss/ugc/effectplatform/model/Effect;", "setFront_effect", "(Lcom/ss/ugc/effectplatform/model/Effect;)V", "getPanel", "()Ljava/lang/String;", "setPanel", "(Ljava/lang/String;)V", "getPanel_model", "()Lcom/ss/ugc/effectplatform/model/EffectPanelModel;", "setPanel_model", "(Lcom/ss/ugc/effectplatform/model/EffectPanelModel;)V", "getRear_effect", "setRear_effect", "getUrl_prefix", "setUrl_prefix", "getVersion", "setVersion", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class EffectChannelResponse {
    private List<? extends Effect> all_category_effects;
    private List<? extends EffectCategoryResponse> category_responses;
    private List<? extends Effect> collection_list;
    private Effect front_effect;
    private String panel;
    private EffectPanelModel panel_model;
    private Effect rear_effect;
    private List<String> url_prefix;
    private String version;

    public EffectChannelResponse() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public List<Effect> getAll_category_effects() {
        return this.all_category_effects;
    }

    public List<EffectCategoryResponse> getCategory_responses() {
        return this.category_responses;
    }

    public List<Effect> getCollection_list() {
        return this.collection_list;
    }

    public Effect getFront_effect() {
        return this.front_effect;
    }

    public String getPanel() {
        return this.panel;
    }

    public EffectPanelModel getPanel_model() {
        return this.panel_model;
    }

    public Effect getRear_effect() {
        return this.rear_effect;
    }

    public List<String> getUrl_prefix() {
        return this.url_prefix;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAll_category_effects(List<? extends Effect> r100) {
        this.all_category_effects = r100;
    }

    public void setCategory_responses(List<? extends EffectCategoryResponse> r100) {
        this.category_responses = r100;
    }

    public void setCollection_list(List<? extends Effect> r100) {
        this.collection_list = r100;
    }

    public void setFront_effect(Effect r100) {
        this.front_effect = r100;
    }

    public void setPanel(String r100) {
        this.panel = r100;
    }

    public void setPanel_model(EffectPanelModel r100) {
        this.panel_model = r100;
    }

    public void setRear_effect(Effect r100) {
        this.rear_effect = r100;
    }

    public void setUrl_prefix(List<String> r100) {
        this.url_prefix = r100;
    }

    public void setVersion(String r100) {
        this.version = r100;
    }

    public EffectChannelResponse(String r100, String r101, Effect r102, Effect r103, List<? extends Effect> r104, List<? extends EffectCategoryResponse> r105, EffectPanelModel r106, List<? extends Effect> r107, List<String> r108) {
        this.panel = r100;
        this.version = r101;
        this.front_effect = r102;
        this.rear_effect = r103;
        this.all_category_effects = r104;
        this.category_responses = r105;
        this.panel_model = r106;
        this.collection_list = r107;
        this.url_prefix = r108;
        getPanel_model().setId(getPanel());
    }

    public /* synthetic */ EffectChannelResponse(String r110, String r111, Effect r210, Effect r211, List r212, List r213, EffectPanelModel r214, List r215, List r216, int r217, DefaultConstructorMarker r218) {
        Effect r100 = null;
        if ((r217 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r217 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r217 & 4) == 0) goto L13;
        Effect r103 = null;
    L15:
        if ((r217 & 8) != 0) goto L19;
        r100 = r211;
    L19:
        if ((r217 & 16) == 0) goto L21;
        List r104 = new ArrayList();
    L23:
        if ((r217 & 32) == 0) goto L25;
        List r105 = new ArrayList();
    L27:
        if ((r217 & 64) == 0) goto L29;
        EffectPanelModel r106 = new EffectPanelModel(null, null, null, null, null, null, 63, null);
    L31:
        if ((r217 & 128) == 0) goto L33;
        List r107 = new ArrayList();
    L35:
        if ((r217 & 256) == 0) goto L37;
        List r108 = new ArrayList();
    L38:
        this(r101, r102, r103, r100, r104, r105, r106, r107, r108);
        return;
    L37:
        r108 = r216;
        goto L38
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L13:
        r103 = r210;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
