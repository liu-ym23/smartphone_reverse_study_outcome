package com.ss.ugc.effectplatform.model;

import com.facebook.keyframes.model.KFFeature;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b \b\u0017\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\u000fR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R0\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\u001a\u0010\t\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001f\"\u0004\b)\u0010!R\u001a\u0010\u0004\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0019\"\u0004\b+\u0010\u001b¨\u0006,"}, d2 = {"Lcom/ss/ugc/effectplatform/model/CategoryEffectModel;", "", "category_key", "", "version", "has_more", "", EffectConfiguration.KEY_CURSOR, "", EffectConfiguration.KEY_SORTING_POSITION, "collection", "", "Lcom/ss/ugc/effectplatform/model/Effect;", KFFeature.EFFECT_JSON_FIELD, "bind_effects", "(Ljava/lang/String;Ljava/lang/String;ZIILjava/util/List;Ljava/util/List;Ljava/util/List;)V", "getBind_effects", "()Ljava/util/List;", "setBind_effects", "(Ljava/util/List;)V", "value", "category_effects", "getCategory_effects", "setCategory_effects", "getCategory_key", "()Ljava/lang/String;", "setCategory_key", "(Ljava/lang/String;)V", "getCollection", "setCollection", "getCursor", "()I", "setCursor", "(I)V", "getHas_more", "()Z", "setHas_more", "(Z)V", "isCache", "setCache", "getSorting_position", "setSorting_position", "getVersion", "setVersion", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class CategoryEffectModel {
    private List<? extends Effect> bind_effects;
    private String category_key;
    private List<? extends Effect> collection;
    private int cursor;
    private List<? extends Effect> effects;
    private boolean has_more;
    private boolean isCache;
    private int sorting_position;
    private String version;

    public CategoryEffectModel() {
        this(null, null, false, 0, 0, null, null, null, 255, null);
    }

    public List<Effect> getBind_effects() {
        return this.bind_effects;
    }

    public final List<Effect> getCategory_effects() {
        return this.effects;
    }

    public String getCategory_key() {
        return this.category_key;
    }

    public List<Effect> getCollection() {
        return this.collection;
    }

    public int getCursor() {
        return this.cursor;
    }

    public boolean getHas_more() {
        return this.has_more;
    }

    public int getSorting_position() {
        return this.sorting_position;
    }

    public String getVersion() {
        return this.version;
    }

    public final boolean isCache() {
        return this.isCache;
    }

    public void setBind_effects(List<? extends Effect> r100) {
        this.bind_effects = r100;
    }

    public final void setCache(boolean r100) {
        this.isCache = r100;
    }

    public final void setCategory_effects(List<? extends Effect> r100) {
        this.effects = r100;
    }

    public void setCategory_key(String r100) {
        this.category_key = r100;
    }

    public void setCollection(List<? extends Effect> r100) {
        this.collection = r100;
    }

    public void setCursor(int r100) {
        this.cursor = r100;
    }

    public void setHas_more(boolean r100) {
        this.has_more = r100;
    }

    public void setSorting_position(int r100) {
        this.sorting_position = r100;
    }

    public void setVersion(String r100) {
        this.version = r100;
    }

    public CategoryEffectModel(String r100, String r101, boolean r102, int r103, int r104, List<? extends Effect> r105, List<? extends Effect> r106, List<? extends Effect> r107) {
        this.category_key = r100;
        this.version = r101;
        this.has_more = r102;
        this.cursor = r103;
        this.sorting_position = r104;
        this.collection = r105;
        this.effects = r106;
        this.bind_effects = r107;
    }

    public /* synthetic */ CategoryEffectModel(String r100, String r110, boolean r111, int r112, int r113, List r114, List r115, List r116, int r117, DefaultConstructorMarker r118) {
        String r101 = "";
        if ((r117 & 1) == 0) goto L5;
        String r102 = "";
    L7:
        if ((r117 & 2) != 0) goto L10;
        r101 = r110;
    L10:
        int r103 = 0;
        if ((r117 & 4) == 0) goto L13;
        boolean r104 = false;
    L15:
        if ((r117 & 8) == 0) goto L17;
        int r105 = 0;
    L19:
        if ((r117 & 16) != 0) goto L23;
        r103 = r113;
    L23:
        if ((r117 & 32) == 0) goto L25;
        List r106 = new ArrayList();
    L27:
        if ((r117 & 64) == 0) goto L29;
        List r107 = new ArrayList();
    L31:
        if ((r117 & 128) == 0) goto L33;
        List r108 = new ArrayList();
    L34:
        this(r102, r101, r104, r105, r103, r106, r107, r108);
        return;
    L33:
        r108 = r116;
        goto L34
    L29:
        r107 = r115;
        goto L31
    L25:
        r106 = r114;
        goto L27
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L5:
        r102 = r100;
        goto L7
    }
}
