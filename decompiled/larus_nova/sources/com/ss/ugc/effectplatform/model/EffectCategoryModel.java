package com.ss.ugc.effectplatform.model;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.facebook.keyframes.model.KFFeature;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b%\b\u0017\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\n¢\u0006\u0002\u0010\u0013J\u0006\u00105\u001a\u00020\u000eR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR\u001a\u0010\r\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0005\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001b\"\u0004\b*\u0010\u001dR\u001a\u0010\u0004\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001dR\u001a\u0010\u0010\u001a\u00020\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001b\"\u0004\b4\u0010\u001d¨\u00066"}, d2 = {"Lcom/ss/ugc/effectplatform/model/EffectCategoryModel;", "", "id", "", "name", "key", "icon", "Lcom/ss/ugc/effectplatform/model/UrlModel;", "icon_selected", KFFeature.EFFECT_JSON_FIELD, "", PromotionProductPrivilegesStruct.TAGS, "tags_updated_at", "is_default", "", "extra", "parent_category", "", "children_categories", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/UrlModel;Lcom/ss/ugc/effectplatform/model/UrlModel;Ljava/util/List;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;ILjava/util/List;)V", "getChildren_categories", "()Ljava/util/List;", "setChildren_categories", "(Ljava/util/List;)V", "getEffects", "setEffects", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "getIcon", "()Lcom/ss/ugc/effectplatform/model/UrlModel;", "setIcon", "(Lcom/ss/ugc/effectplatform/model/UrlModel;)V", "getIcon_selected", "setIcon_selected", "getId", "setId", "()Z", "set_default", "(Z)V", "getKey", "setKey", "getName", "setName", "getParent_category", "()I", "setParent_category", "(I)V", "getTags", "setTags", "getTags_updated_at", "setTags_updated_at", "checkValued", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class EffectCategoryModel {
    private List<Integer> children_categories;
    private List<String> effects;
    private String extra;
    private UrlModel icon;
    private UrlModel icon_selected;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f457405id;
    private boolean is_default;
    private String key;
    private String name;
    private int parent_category;
    private List<String> tags;
    private String tags_updated_at;

    public EffectCategoryModel() {
        this(null, null, null, null, null, null, null, null, false, null, 0, null, UnixStat.PERM_MASK, null);
    }

    public final boolean checkValued() {
        if (getIcon() != null) goto L6;
        setIcon(new UrlModel(null, null, null, null, 15, null));
    L6:
        if (getIcon() != null) goto L8;
    L14:
        return false;
    L8:
        if (getIcon_selected() != null) goto L11;
        setIcon_selected(new UrlModel(null, null, null, null, 15, null));
    L11:
        if (getIcon_selected() == null) goto L14;
        return !Intrinsics.areEqual(getId(), "");
    }

    public List<Integer> getChildren_categories() {
        return this.children_categories;
    }

    public List<String> getEffects() {
        return this.effects;
    }

    public String getExtra() {
        return this.extra;
    }

    public UrlModel getIcon() {
        return this.icon;
    }

    public UrlModel getIcon_selected() {
        return this.icon_selected;
    }

    public String getId() {
        return this.f457405id;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public int getParent_category() {
        return this.parent_category;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public String getTags_updated_at() {
        return this.tags_updated_at;
    }

    public boolean is_default() {
        return this.is_default;
    }

    public void setChildren_categories(List<Integer> r100) {
        this.children_categories = r100;
    }

    public void setEffects(List<String> r100) {
        this.effects = r100;
    }

    public void setExtra(String r100) {
        this.extra = r100;
    }

    public void setIcon(UrlModel r100) {
        this.icon = r100;
    }

    public void setIcon_selected(UrlModel r100) {
        this.icon_selected = r100;
    }

    public void setId(String r100) {
        this.f457405id = r100;
    }

    public void setKey(String r100) {
        this.key = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setParent_category(int r100) {
        this.parent_category = r100;
    }

    public void setTags(List<String> r100) {
        this.tags = r100;
    }

    public void setTags_updated_at(String r100) {
        this.tags_updated_at = r100;
    }

    public void set_default(boolean r100) {
        this.is_default = r100;
    }

    public EffectCategoryModel(String r100, String r101, String r102, UrlModel r103, UrlModel r104, List<String> r105, List<String> r106, String r107, boolean r108, String r110, int r111, List<Integer> r112) {
        this.f457405id = r100;
        this.name = r101;
        this.key = r102;
        this.icon = r103;
        this.icon_selected = r104;
        this.effects = r105;
        this.tags = r106;
        this.tags_updated_at = r107;
        this.is_default = r108;
        this.extra = r110;
        this.parent_category = r111;
        this.children_categories = r112;
    }

    public /* synthetic */ EffectCategoryModel(String r110, String r111, String r112, UrlModel r113, UrlModel r114, List r115, List r210, String r211, boolean r212, String r213, int r214, List r215, int r216, DefaultConstructorMarker r217) {
        String r100 = "";
        if ((r216 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r216 & 4) != 0) goto L14;
        r100 = r112;
    L14:
        String r103 = null;
        if ((r216 & 8) == 0) goto L17;
        UrlModel r104 = null;
    L19:
        if ((r216 & 16) == 0) goto L21;
        UrlModel r105 = null;
    L23:
        if ((r216 & 32) == 0) goto L25;
        List r106 = new ArrayList();
    L27:
        if ((r216 & 64) == 0) goto L29;
        List r107 = new ArrayList();
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r108 = null;
    L34:
        int r116 = 0;
        if ((r216 & 256) == 0) goto L37;
        boolean r117 = false;
    L39:
        if ((r216 & 512) != 0) goto L43;
        r103 = r213;
    L43:
        if ((r216 & 1024) != 0) goto L47;
        r116 = r214;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        List r109 = new ArrayList();
    L50:
        this(r101, r102, r100, r104, r105, r106, r107, r108, r117, r103, r116, r109);
        return;
    L49:
        r109 = r215;
        goto L50
    L37:
        r117 = r212;
        goto L39
    L33:
        r108 = r211;
        goto L34
    L29:
        r107 = r210;
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
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
