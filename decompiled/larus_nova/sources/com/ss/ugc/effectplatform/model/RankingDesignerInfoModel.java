package com.ss.ugc.effectplatform.model;

import com.facebook.keyframes.model.KFFeature;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0017\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010J\b\u0010,\u001a\u00020\u0003H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001e\u0010\f\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001aR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)¨\u0006-"}, d2 = {"Lcom/ss/ugc/effectplatform/model/RankingDesignerInfoModel;", "", "designer_id", "", "designer_encrypted_id", "name", "small_icon_url", "Lcom/ss/ugc/effectplatform/model/UrlModel;", "ranking_url", "follow_status", "", "following_count", "effect_count", KFFeature.EFFECT_JSON_FIELD, "", "Lcom/ss/ugc/effectplatform/model/Effect;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/UrlModel;Lcom/ss/ugc/effectplatform/model/UrlModel;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "getDesigner_encrypted_id", "()Ljava/lang/String;", "setDesigner_encrypted_id", "(Ljava/lang/String;)V", "getDesigner_id", "setDesigner_id", "getEffect_count", "()Ljava/lang/Integer;", "setEffect_count", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getEffects", "()Ljava/util/List;", "setEffects", "(Ljava/util/List;)V", "getFollow_status", "setFollow_status", "getFollowing_count", "setFollowing_count", "getName", "setName", "getRanking_url", "()Lcom/ss/ugc/effectplatform/model/UrlModel;", "setRanking_url", "(Lcom/ss/ugc/effectplatform/model/UrlModel;)V", "getSmall_icon_url", "setSmall_icon_url", "toString", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class RankingDesignerInfoModel {
    private String designer_encrypted_id;
    private String designer_id;
    private Integer effect_count;
    private List<? extends Effect> effects;
    private Integer follow_status;
    private Integer following_count;
    private String name;
    private UrlModel ranking_url;
    private UrlModel small_icon_url;

    public String toString() {
        return "RankingDesignerInfoModel(designer_id=" + getDesigner_id() + ", designer_encrypted_id=" + getDesigner_encrypted_id() + ", name=" + getName() + ", small_icon_url=" + getSmall_icon_url() + ", ranking_url=" + getRanking_url() + ", follow_status=" + getFollow_status() + ", following_count=" + getFollowing_count() + ", effect_count=" + getEffect_count() + ", effects=" + getEffects() + ')';
    }

    public String getDesigner_encrypted_id() {
        return this.designer_encrypted_id;
    }

    public String getDesigner_id() {
        return this.designer_id;
    }

    public Integer getEffect_count() {
        return this.effect_count;
    }

    public List<Effect> getEffects() {
        return this.effects;
    }

    public Integer getFollow_status() {
        return this.follow_status;
    }

    public Integer getFollowing_count() {
        return this.following_count;
    }

    public String getName() {
        return this.name;
    }

    public UrlModel getRanking_url() {
        return this.ranking_url;
    }

    public UrlModel getSmall_icon_url() {
        return this.small_icon_url;
    }

    public void setDesigner_encrypted_id(String r100) {
        this.designer_encrypted_id = r100;
    }

    public void setDesigner_id(String r100) {
        this.designer_id = r100;
    }

    public void setEffect_count(Integer r100) {
        this.effect_count = r100;
    }

    public void setEffects(List<? extends Effect> r100) {
        this.effects = r100;
    }

    public void setFollow_status(Integer r100) {
        this.follow_status = r100;
    }

    public void setFollowing_count(Integer r100) {
        this.following_count = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setRanking_url(UrlModel r100) {
        this.ranking_url = r100;
    }

    public void setSmall_icon_url(UrlModel r100) {
        this.small_icon_url = r100;
    }

    public RankingDesignerInfoModel(String r100, String r101, String r102, UrlModel r103, UrlModel r104, Integer r105, Integer r106, Integer r107, List<? extends Effect> r108) {
        this.designer_id = r100;
        this.designer_encrypted_id = r101;
        this.name = r102;
        this.small_icon_url = r103;
        this.ranking_url = r104;
        this.follow_status = r105;
        this.following_count = r106;
        this.effect_count = r107;
        this.effects = r108;
    }

    public /* synthetic */ RankingDesignerInfoModel(String r110, String r111, String r112, UrlModel r113, UrlModel r210, Integer r211, Integer r212, Integer r213, List r214, int r215, DefaultConstructorMarker r216) {
        if ((r215 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r215 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r215 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r215 & 8) == 0) goto L17;
        UrlModel r103 = new UrlModel(null, null, null, null, 15, null);
    L19:
        if ((r215 & 16) == 0) goto L21;
        UrlModel r104 = new UrlModel(null, null, null, null, 15, null);
    L23:
        if ((r215 & 256) == 0) goto L25;
        List r114 = null;
    L26:
        this(r100, r101, r102, r103, r104, r211, r212, r213, r114);
        return;
    L25:
        r114 = r214;
        goto L26
    L21:
        r104 = r210;
        goto L23
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
