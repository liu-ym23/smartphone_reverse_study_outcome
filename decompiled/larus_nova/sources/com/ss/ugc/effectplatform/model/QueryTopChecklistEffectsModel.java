package com.ss.ugc.effectplatform.model;

import com.facebook.keyframes.model.KFFeature;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0013\b\u0017\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bR \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/ss/ugc/effectplatform/model/QueryTopChecklistEffectsModel;", "", EffectConfiguration.KEY_CURSOR, "", "collection", "", "Lcom/ss/ugc/effectplatform/model/Effect;", KFFeature.EFFECT_JSON_FIELD, "bind_effects", "last_updated_at", "", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;)V", "getBind_effects", "()Ljava/util/List;", "setBind_effects", "(Ljava/util/List;)V", "getCollection", "setCollection", "getCursor", "()I", "setCursor", "(I)V", "getEffects", "setEffects", "getLast_updated_at", "()Ljava/lang/Long;", "setLast_updated_at", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class QueryTopChecklistEffectsModel {
    private List<? extends Effect> bind_effects;
    private List<? extends Effect> collection;
    private int cursor;
    private List<? extends Effect> effects;
    private Long last_updated_at;

    public QueryTopChecklistEffectsModel() {
        this(0, null, null, null, null, 31, null);
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

    public Long getLast_updated_at() {
        return this.last_updated_at;
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

    public void setLast_updated_at(Long r100) {
        this.last_updated_at = r100;
    }

    public QueryTopChecklistEffectsModel(int r100, List<? extends Effect> r101, List<? extends Effect> r102, List<? extends Effect> r103, Long r104) {
        this.cursor = r100;
        this.collection = r101;
        this.effects = r102;
        this.bind_effects = r103;
        this.last_updated_at = r104;
    }

    public /* synthetic */ QueryTopChecklistEffectsModel(int r100, List r101, List r102, List r103, Long r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r101 = new ArrayList();
    L8:
        List r111 = r101;
        if ((r105 & 4) == 0) goto L11;
        r102 = new ArrayList();
    L11:
        List r106 = r102;
        if ((r105 & 8) == 0) goto L14;
        r103 = new ArrayList();
    L14:
        List r107 = r103;
        if ((r105 & 16) == 0) goto L17;
        r104 = null;
    L17:
        int r108 = r100;
        this(r108, r111, r106, r107, r104);
    }
}
