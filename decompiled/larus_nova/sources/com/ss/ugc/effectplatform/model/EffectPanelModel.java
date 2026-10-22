package com.ss.ugc.effectplatform.model;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\b\u0017\u0018\u00002\u00020\u0001BQ\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u001e\u001a\u00020\u001fR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000f¨\u0006 "}, d2 = {"Lcom/ss/ugc/effectplatform/model/EffectPanelModel;", "", "text", "", "id", "icon", "Lcom/ss/ugc/effectplatform/model/UrlModel;", PromotionProductPrivilegesStruct.TAGS, "", "tags_updated_at", "extra", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/UrlModel;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "getIcon", "()Lcom/ss/ugc/effectplatform/model/UrlModel;", "setIcon", "(Lcom/ss/ugc/effectplatform/model/UrlModel;)V", "getId", "setId", "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "getTags_updated_at", "setTags_updated_at", "getText", "setText", "checkValued", "", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class EffectPanelModel {
    private String extra;
    private UrlModel icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f457407id;
    private List<String> tags;
    private String tags_updated_at;
    private String text;

    public EffectPanelModel() {
        this(null, null, null, null, null, null, 63, null);
    }

    public final boolean checkValued() {
        if (getIcon() != null) goto L7;
        setIcon(new UrlModel(null, null, null, null, 15, null));
        return true;
    L7:
        return true;
    }

    public String getExtra() {
        return this.extra;
    }

    public UrlModel getIcon() {
        return this.icon;
    }

    public String getId() {
        return this.f457407id;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public String getTags_updated_at() {
        return this.tags_updated_at;
    }

    public String getText() {
        return this.text;
    }

    public void setExtra(String r100) {
        this.extra = r100;
    }

    public void setIcon(UrlModel r100) {
        this.icon = r100;
    }

    public void setId(String r100) {
        this.f457407id = r100;
    }

    public void setTags(List<String> r100) {
        this.tags = r100;
    }

    public void setTags_updated_at(String r100) {
        this.tags_updated_at = r100;
    }

    public void setText(String r100) {
        this.text = r100;
    }

    public EffectPanelModel(String r100, String r101, UrlModel r102, List<String> r103, String r104, String r105) {
        this.text = r100;
        this.f457407id = r101;
        this.icon = r102;
        this.tags = r103;
        this.tags_updated_at = r104;
        this.extra = r105;
    }

    public /* synthetic */ EffectPanelModel(String r110, String r111, UrlModel r112, List r113, String r114, String r115, int r116, DefaultConstructorMarker r117) {
        String r100 = null;
        if ((r116 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r116 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r116 & 4) == 0) goto L13;
        UrlModel r103 = new UrlModel(null, null, null, null, 15, null);
    L15:
        if ((r116 & 8) == 0) goto L17;
        List r104 = new ArrayList();
    L19:
        if ((r116 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r116 & 32) != 0) goto L26;
        r100 = r115;
    L26:
        this(r101, r102, r103, r104, r105, r100);
        return;
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
