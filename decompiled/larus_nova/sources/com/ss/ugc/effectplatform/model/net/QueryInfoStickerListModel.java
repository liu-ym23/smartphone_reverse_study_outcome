package com.ss.ugc.effectplatform.model.net;

import com.facebook.keyframes.model.KFFeature;
import com.ss.ugc.effectplatform.model.EffectCategoryModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\u0002\u0010\u000fJ\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\u0081\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001b¨\u00065"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/QueryInfoStickerListModel;", "", "version", "", "panel", "Lcom/ss/ugc/effectplatform/model/net/PanelDesc;", KFFeature.EFFECT_JSON_FIELD, "", "Lcom/ss/ugc/effectplatform/model/net/InfoStickerEffect;", "collection", "category", "Lcom/ss/ugc/effectplatform/model/EffectCategoryModel;", "front_effect_id", "rear_effect_id", "url_prefix", "(Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/net/PanelDesc;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCategory", "()Ljava/util/List;", "setCategory", "(Ljava/util/List;)V", "getCollection", "setCollection", "getEffects", "setEffects", "getFront_effect_id", "()Ljava/lang/String;", "setFront_effect_id", "(Ljava/lang/String;)V", "getPanel", "()Lcom/ss/ugc/effectplatform/model/net/PanelDesc;", "setPanel", "(Lcom/ss/ugc/effectplatform/model/net/PanelDesc;)V", "getRear_effect_id", "setRear_effect_id", "getUrl_prefix", "setUrl_prefix", "getVersion", "setVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class QueryInfoStickerListModel {
    private List<? extends EffectCategoryModel> category;
    private List<InfoStickerEffect> collection;
    private List<InfoStickerEffect> effects;
    private String front_effect_id;
    private PanelDesc panel;
    private String rear_effect_id;
    private List<String> url_prefix;
    private String version;

    public QueryInfoStickerListModel() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QueryInfoStickerListModel copy$default(QueryInfoStickerListModel r100, String r110, PanelDesc r111, List r112, List r113, List r114, String r115, String r116, List r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.version;
    L7:
        if ((r118 & 2) == 0) goto L9;
        PanelDesc r102 = r100.panel;
    L11:
        if ((r118 & 4) == 0) goto L13;
        List r103 = r100.effects;
    L15:
        if ((r118 & 8) == 0) goto L17;
        List r104 = r100.collection;
    L19:
        if ((r118 & 16) == 0) goto L21;
        List r105 = r100.category;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.front_effect_id;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.rear_effect_id;
    L31:
        if ((r118 & 128) == 0) goto L33;
        List r108 = r100.url_prefix;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
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

    public final String component1() {
        return this.version;
    }

    public final PanelDesc component2() {
        return this.panel;
    }

    public final List<InfoStickerEffect> component3() {
        return this.effects;
    }

    public final List<InfoStickerEffect> component4() {
        return this.collection;
    }

    public final List<EffectCategoryModel> component5() {
        return this.category;
    }

    public final String component6() {
        return this.front_effect_id;
    }

    public final String component7() {
        return this.rear_effect_id;
    }

    public final List<String> component8() {
        return this.url_prefix;
    }

    public final QueryInfoStickerListModel copy(String r110, PanelDesc r111, List<InfoStickerEffect> r112, List<InfoStickerEffect> r113, List<? extends EffectCategoryModel> r114, String r115, String r116, List<String> r117) {
        return new QueryInfoStickerListModel(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof QueryInfoStickerListModel) == false) goto L22;
        QueryInfoStickerListModel r101 = (QueryInfoStickerListModel) r100;
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.panel, r101.panel) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.effects, r101.effects) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.collection, r101.collection) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.category, r101.category) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.front_effect_id, r101.front_effect_id) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.rear_effect_id, r101.rear_effect_id) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.url_prefix, r101.url_prefix) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        String r100 = this.version;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        PanelDesc r104 = this.panel;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<InfoStickerEffect> r107 = this.effects;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<InfoStickerEffect> r110 = this.collection;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<? extends EffectCategoryModel> r113 = this.category;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.front_effect_id;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.rear_effect_id;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        List<String> r122 = this.url_prefix;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "QueryInfoStickerListModel(version=" + this.version + ", panel=" + this.panel + ", effects=" + this.effects + ", collection=" + this.collection + ", category=" + this.category + ", front_effect_id=" + this.front_effect_id + ", rear_effect_id=" + this.rear_effect_id + ", url_prefix=" + this.url_prefix + ")";
    }

    public final List<EffectCategoryModel> getCategory() {
        return this.category;
    }

    public final List<InfoStickerEffect> getCollection() {
        return this.collection;
    }

    public final List<InfoStickerEffect> getEffects() {
        return this.effects;
    }

    public final String getFront_effect_id() {
        return this.front_effect_id;
    }

    public final PanelDesc getPanel() {
        return this.panel;
    }

    public final String getRear_effect_id() {
        return this.rear_effect_id;
    }

    public final List<String> getUrl_prefix() {
        return this.url_prefix;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setCategory(List<? extends EffectCategoryModel> r100) {
        this.category = r100;
    }

    public final void setCollection(List<InfoStickerEffect> r100) {
        this.collection = r100;
    }

    public final void setEffects(List<InfoStickerEffect> r100) {
        this.effects = r100;
    }

    public final void setFront_effect_id(String r100) {
        this.front_effect_id = r100;
    }

    public final void setPanel(PanelDesc r100) {
        this.panel = r100;
    }

    public final void setRear_effect_id(String r100) {
        this.rear_effect_id = r100;
    }

    public final void setUrl_prefix(List<String> r100) {
        this.url_prefix = r100;
    }

    public final void setVersion(String r100) {
        this.version = r100;
    }

    public QueryInfoStickerListModel(String r100, PanelDesc r101, List<InfoStickerEffect> r102, List<InfoStickerEffect> r103, List<? extends EffectCategoryModel> r104, String r105, String r106, List<String> r107) {
        this.version = r100;
        this.panel = r101;
        this.effects = r102;
        this.collection = r103;
        this.category = r104;
        this.front_effect_id = r105;
        this.rear_effect_id = r106;
        this.url_prefix = r107;
    }

    public /* synthetic */ QueryInfoStickerListModel(String r110, PanelDesc r111, List r112, List r113, List r114, String r115, String r116, List r117, int r118, DefaultConstructorMarker r119) {
        List r100 = null;
        if ((r118 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        PanelDesc r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        List r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        List r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        List r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = null;
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
