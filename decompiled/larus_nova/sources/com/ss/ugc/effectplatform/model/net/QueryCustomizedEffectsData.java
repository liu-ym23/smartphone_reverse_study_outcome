package com.ss.ugc.effectplatform.model.net;

import com.facebook.keyframes.model.KFFeature;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ugc.effectplatform.model.Effect;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001B[\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016¨\u0006\""}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/QueryCustomizedEffectsData;", "", "url_prefix", "", "", "url_prefix2", KFFeature.EFFECT_JSON_FIELD, "Lcom/ss/ugc/effectplatform/model/Effect;", "has_more", "", EffectConfiguration.KEY_CURSOR, "", EffectConfiguration.KEY_SORTING_POSITION, "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Integer;I)V", "getCursor", "()Ljava/lang/Integer;", "setCursor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getEffects", "()Ljava/util/List;", "setEffects", "(Ljava/util/List;)V", "getHas_more", "()Ljava/lang/Boolean;", "setHas_more", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getSorting_position", "()I", "getUrl_prefix", "setUrl_prefix", "getUrl_prefix2", "setUrl_prefix2", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class QueryCustomizedEffectsData {
    private Integer cursor;
    private List<? extends Effect> effects;
    private Boolean has_more;
    private final int sorting_position;
    private List<String> url_prefix;
    private List<String> url_prefix2;

    public final Integer getCursor() {
        return this.cursor;
    }

    public final List<Effect> getEffects() {
        return this.effects;
    }

    public final Boolean getHas_more() {
        return this.has_more;
    }

    public final int getSorting_position() {
        return this.sorting_position;
    }

    public final List<String> getUrl_prefix() {
        return this.url_prefix;
    }

    public final List<String> getUrl_prefix2() {
        return this.url_prefix2;
    }

    public final void setCursor(Integer r100) {
        this.cursor = r100;
    }

    public final void setEffects(List<? extends Effect> r100) {
        this.effects = r100;
    }

    public final void setHas_more(Boolean r100) {
        this.has_more = r100;
    }

    public final void setUrl_prefix(List<String> r100) {
        this.url_prefix = r100;
    }

    public final void setUrl_prefix2(List<String> r100) {
        this.url_prefix2 = r100;
    }

    public QueryCustomizedEffectsData(List<String> r100, List<String> r101, List<? extends Effect> r102, Boolean r103, Integer r104, int r105) {
        this.url_prefix = r100;
        this.url_prefix2 = r101;
        this.effects = r102;
        this.has_more = r103;
        this.cursor = r104;
        this.sorting_position = r105;
    }

    public /* synthetic */ QueryCustomizedEffectsData(List r110, List r111, List r112, Boolean r113, Integer r114, int r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 1) == 0) goto L5;
        List r100 = null;
    L7:
        if ((r116 & 2) == 0) goto L9;
        List r101 = null;
    L11:
        if ((r116 & 4) == 0) goto L13;
        List r102 = null;
    L15:
        if ((r116 & 8) == 0) goto L17;
        Boolean r103 = null;
    L19:
        if ((r116 & 16) == 0) goto L21;
        Integer r104 = null;
    L22:
        this(r100, r101, r102, r103, r104, r115);
        return;
    L21:
        r104 = r114;
        goto L22
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
