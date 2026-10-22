package com.ss.ugc.effectplatform.model.net;

import com.facebook.keyframes.model.KFFeature;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ugc.effectplatform.model.Effect;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0017\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\u0010\u000fR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/SearchEffectModel;", "", "has_more", "", EffectConfiguration.KEY_CURSOR, "", "search_id", "", "search_tips", "use_hot", KFFeature.EFFECT_JSON_FIELD, "", "Lcom/ss/ugc/effectplatform/model/Effect;", "collection", "bind_effects", "(ZILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getBind_effects", "()Ljava/util/List;", "setBind_effects", "(Ljava/util/List;)V", "getCollection", "setCollection", "getCursor", "()I", "setCursor", "(I)V", "getEffects", "setEffects", "getHas_more", "()Z", "setHas_more", "(Z)V", "getSearch_id", "()Ljava/lang/String;", "setSearch_id", "(Ljava/lang/String;)V", "getSearch_tips", "setSearch_tips", "getUse_hot", "()Ljava/lang/Boolean;", "setUse_hot", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public class SearchEffectModel {
    private List<? extends Effect> bind_effects;
    private List<? extends Effect> collection;
    private int cursor;
    private List<? extends Effect> effects;
    private boolean has_more;
    private String search_id;
    private String search_tips;
    private Boolean use_hot;

    public SearchEffectModel() {
        this(false, 0, null, null, null, null, null, null, 255, null);
    }

    public List<Effect> getBind_effects() {
        return this.bind_effects;
    }

    public List<Effect> getCollection() {
        return this.collection;
    }

    public int getCursor() {
        return this.cursor;
    }

    public List<Effect> getEffects() {
        return this.effects;
    }

    public boolean getHas_more() {
        return this.has_more;
    }

    public String getSearch_id() {
        return this.search_id;
    }

    public String getSearch_tips() {
        return this.search_tips;
    }

    public Boolean getUse_hot() {
        return this.use_hot;
    }

    public void setBind_effects(List<? extends Effect> r100) {
        this.bind_effects = r100;
    }

    public void setCollection(List<? extends Effect> r100) {
        this.collection = r100;
    }

    public void setCursor(int r100) {
        this.cursor = r100;
    }

    public void setEffects(List<? extends Effect> r100) {
        this.effects = r100;
    }

    public void setHas_more(boolean r100) {
        this.has_more = r100;
    }

    public void setSearch_id(String r100) {
        this.search_id = r100;
    }

    public void setSearch_tips(String r100) {
        this.search_tips = r100;
    }

    public void setUse_hot(Boolean r100) {
        this.use_hot = r100;
    }

    public SearchEffectModel(boolean r100, int r101, String r102, String r103, Boolean r104, List<? extends Effect> r105, List<? extends Effect> r106, List<? extends Effect> r107) {
        this.has_more = r100;
        this.cursor = r101;
        this.search_id = r102;
        this.search_tips = r103;
        this.use_hot = r104;
        this.effects = r105;
        this.collection = r106;
        this.bind_effects = r107;
    }

    public /* synthetic */ SearchEffectModel(boolean r110, int r111, String r112, String r113, Boolean r114, List r115, List r116, List r117, int r118, DefaultConstructorMarker r119) {
        int r100 = 0;
        if ((r118 & 1) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r118 & 2) != 0) goto L10;
        r100 = r111;
    L10:
        List r102 = null;
        if ((r118 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Boolean r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        List r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        List r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r102 = r117;
    L34:
        this(r101, r100, r103, r104, r105, r106, r107, r102);
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
    L5:
        r101 = r110;
        goto L7
    }
}
