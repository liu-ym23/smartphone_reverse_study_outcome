package com.ss.ugc.effectplatform.model;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0017\u0018\u00002\u00020\u0001B9\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u001d\u001a\u00020\bH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/ss/ugc/effectplatform/model/RankingEffectInfoModel;", "", "effect", "Lcom/ss/ugc/effectplatform/model/Effect;", "simple_video_info", "", "Lcom/ss/ugc/effectplatform/model/SimpleVideoInfo;", "designer_name", "", "ranking_info", "Lcom/ss/ugc/effectplatform/model/RankingEffectModel;", "(Lcom/ss/ugc/effectplatform/model/Effect;[Lcom/ss/ugc/effectplatform/model/SimpleVideoInfo;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/RankingEffectModel;)V", "getDesigner_name", "()Ljava/lang/String;", "setDesigner_name", "(Ljava/lang/String;)V", "getEffect", "()Lcom/ss/ugc/effectplatform/model/Effect;", "setEffect", "(Lcom/ss/ugc/effectplatform/model/Effect;)V", "getRanking_info", "()Lcom/ss/ugc/effectplatform/model/RankingEffectModel;", "setRanking_info", "(Lcom/ss/ugc/effectplatform/model/RankingEffectModel;)V", "getSimple_video_info", "()[Lcom/ss/ugc/effectplatform/model/SimpleVideoInfo;", "setSimple_video_info", "([Lcom/ss/ugc/effectplatform/model/SimpleVideoInfo;)V", "[Lcom/ss/ugc/effectplatform/model/SimpleVideoInfo;", "toString", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class RankingEffectInfoModel {
    private String designer_name;
    private Effect effect;
    private RankingEffectModel ranking_info;
    private SimpleVideoInfo[] simple_video_info;

    public RankingEffectInfoModel() {
        this(null, null, null, null, 15, null);
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("RankingEffectInfoModel(effect=");
        r100.append(getEffect());
        r100.append(", simple_video_info=");
        SimpleVideoInfo[] r101 = getSimple_video_info();
        if (r101 == null) goto L5;
        String r102 = Arrays.toString(r101);
    L6:
        r100.append(r102);
        r100.append(", designer_name='");
        r100.append(getDesigner_name());
        r100.append("', ranking_info=");
        r100.append(getRanking_info());
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public String getDesigner_name() {
        return this.designer_name;
    }

    public Effect getEffect() {
        return this.effect;
    }

    public RankingEffectModel getRanking_info() {
        return this.ranking_info;
    }

    public SimpleVideoInfo[] getSimple_video_info() {
        return this.simple_video_info;
    }

    public void setDesigner_name(String r100) {
        this.designer_name = r100;
    }

    public void setEffect(Effect r100) {
        this.effect = r100;
    }

    public void setRanking_info(RankingEffectModel r100) {
        this.ranking_info = r100;
    }

    public void setSimple_video_info(SimpleVideoInfo[] r100) {
        this.simple_video_info = r100;
    }

    public RankingEffectInfoModel(Effect r100, SimpleVideoInfo[] r101, String r102, RankingEffectModel r103) {
        this.effect = r100;
        this.simple_video_info = r101;
        this.designer_name = r102;
        this.ranking_info = r103;
    }

    public /* synthetic */ RankingEffectInfoModel(Effect r100, SimpleVideoInfo[] r101, String r102, RankingEffectModel r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = "";
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
