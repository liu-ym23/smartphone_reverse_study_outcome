package com.ss.ugc.effectplatform.model;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0019\b\u0017\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\b\u0010#\u001a\u00020\u0003H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R$\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/ss/ugc/effectplatform/model/RankingCategoryModel;", "", "id", "", "name", "icon", "Lcom/ss/ugc/effectplatform/model/UrlModel;", "key", "type", "", PromotionProductPrivilegesStruct.TAGS, "", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/UrlModel;Ljava/lang/String;Ljava/lang/Integer;[Ljava/lang/String;)V", "getIcon", "()Lcom/ss/ugc/effectplatform/model/UrlModel;", "setIcon", "(Lcom/ss/ugc/effectplatform/model/UrlModel;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getKey", "setKey", "getName", "setName", "getTags", "()[Ljava/lang/String;", "setTags", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "toString", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class RankingCategoryModel {
    private UrlModel icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f457409id;
    private String key;
    private String name;
    private String[] tags;
    private Integer type;

    public String toString() {
        StringBuilder r100 = new StringBuilder("RankingCategoryModel(id='");
        r100.append(getId());
        r100.append("', name='");
        r100.append(getName());
        r100.append("', icon=");
        r100.append(getIcon());
        r100.append(", key='");
        r100.append(getKey());
        r100.append("', type=");
        r100.append(getType());
        r100.append(", tags=");
        String[] r101 = getTags();
        if (r101 == null) goto L5;
        String r102 = Arrays.toString(r101);
    L6:
        r100.append(r102);
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public UrlModel getIcon() {
        return this.icon;
    }

    public String getId() {
        return this.f457409id;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public String[] getTags() {
        return this.tags;
    }

    public Integer getType() {
        return this.type;
    }

    public void setIcon(UrlModel r100) {
        this.icon = r100;
    }

    public void setId(String r100) {
        this.f457409id = r100;
    }

    public void setKey(String r100) {
        this.key = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setTags(String[] r100) {
        this.tags = r100;
    }

    public void setType(Integer r100) {
        this.type = r100;
    }

    public RankingCategoryModel(String r100, String r101, UrlModel r102, String r103, Integer r104, String[] r105) {
        this.f457409id = r100;
        this.name = r101;
        this.icon = r102;
        this.key = r103;
        this.type = r104;
        this.tags = r105;
    }

    public /* synthetic */ RankingCategoryModel(String r110, String r111, UrlModel r112, String r113, Integer r114, String[] r115, int r116, DefaultConstructorMarker r210) {
        if ((r116 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r116 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r116 & 4) == 0) goto L13;
        UrlModel r102 = new UrlModel(null, null, null, null, 15, null);
    L15:
        if ((r116 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r116 & 32) == 0) goto L21;
        String[] r104 = null;
    L22:
        this(r100, r101, r102, r103, r114, r104);
        return;
    L21:
        r104 = r115;
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
