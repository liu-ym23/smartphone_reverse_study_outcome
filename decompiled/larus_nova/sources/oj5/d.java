package oj5;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b7\b\u0086\b\u0018\u0000 ?2\u00020\u0001:\u0001?B£\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010,\u001a\u00020\tH\u0016J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u00101\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u00106\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u00108\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\tHÆ\u0003Jª\u0001\u0010:\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010;J\u0013\u0010<\u001a\u00020\u00052\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0004\u0010\u0017R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001a\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR \u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001c\"\u0004\b\u001e\u0010\u001fR \u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001fR \u0010\f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001c\"\u0004\b#\u0010\u001fR\"\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010&R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b(\u0010\u0015R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001c\"\u0004\b+\u0010\u001f¨\u0006@"}, d2 = {"Lcom/bytedance/ee/bear/more/export/SpaceListExtra;", "", "bizType", "", "isExternal", "", "notWikiObj", GXTemplateKey.GAIAX_TEMPLATE_TYPE, "wikiHomepage", "", "wikiSpaceCreateUid", "wikiSpaceId", "wikiSpaceName", "wikiSpaceType", "wikiSubToken", "wikiSubtype", "wikiVersion", WikiFolderPushPlugin.WIKI_TOKEN, "<init>", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getBizType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNotWikiObj", "getTemplateType", "getWikiHomepage", "()Ljava/lang/String;", "getWikiSpaceCreateUid", "setWikiSpaceCreateUid", "(Ljava/lang/String;)V", "getWikiSpaceId", "setWikiSpaceId", "getWikiSpaceName", "setWikiSpaceName", "getWikiSpaceType", "setWikiSpaceType", "(Ljava/lang/Integer;)V", "getWikiSubToken", "getWikiSubtype", "getWikiVersion", "getWikiToken", "setWikiToken", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/ee/bear/more/export/SpaceListExtra;", "equals", "other", "hashCode", "Companion", "features-more-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f523579b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f523580a;

    @SerializedName("biz_type")
    private final Integer bizType;

    @SerializedName("is_external")
    private final Boolean isExternal;

    @SerializedName("not_wiki_obj")
    private final Boolean notWikiObj;

    @SerializedName("template_type")
    private final Integer templateType;

    @SerializedName("wiki_homepage")
    private final String wikiHomepage;

    @SerializedName("wiki_space_create_uid")
    private String wikiSpaceCreateUid;

    @SerializedName("wiki_space_id")
    private String wikiSpaceId;

    @SerializedName("wiki_space_name")
    private String wikiSpaceName;

    @SerializedName("wiki_space_type")
    private Integer wikiSpaceType;

    @SerializedName("wiki_sub_token")
    private final String wikiSubToken;

    @SerializedName("wiki_subtype")
    private final Integer wikiSubtype;

    @SerializedName("wiki_version")
    private final String wikiVersion;

    public static final class a {
        @JvmStatic
        public static d a(String r100) {
            if (r100 != null) goto L4;
        L7:
            boolean r101 = true;
        L9:
            if (r101 == false) goto L16;
            return null;
        L16:
            return (d) new Gson().fromJson(r100, d.class);
        L13:
            e = move-exception;
            tt5.a.d("WikiExtra", "fromJson fail: " + e);
            return null;
        L4:
            if (r100.length() == 0) goto L7;
            r101 = false;
            goto L9
        }
    }

    static {
    }

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.bizType, r101.bizType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isExternal, r101.isExternal) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.notWikiObj, r101.notWikiObj) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.templateType, r101.templateType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.wikiHomepage, r101.wikiHomepage) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.wikiSpaceCreateUid, r101.wikiSpaceCreateUid) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.wikiSpaceId, r101.wikiSpaceId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.wikiSpaceName, r101.wikiSpaceName) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.wikiSpaceType, r101.wikiSpaceType) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.wikiSubToken, r101.wikiSubToken) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.wikiSubtype, r101.wikiSubtype) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.wikiVersion, r101.wikiVersion) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f523580a, r101.f523580a) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.bizType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.isExternal;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.notWikiObj;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.templateType;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.wikiHomepage;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.wikiSpaceCreateUid;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.wikiSpaceId;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.wikiSpaceName;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.wikiSpaceType;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.wikiSubToken;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.wikiSubtype;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.wikiVersion;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.f523580a;
        if (r137 == null) goto L55;
        r101 = r137.hashCode();
    L55:
        return r136 + r101;
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return GsonProtectorUtils.toJson(new Gson(), this);
    }

    public final Integer a() {
        return this.bizType;
    }

    public final Boolean b() {
        return this.notWikiObj;
    }

    public final String c() {
        return this.wikiSpaceCreateUid;
    }

    public final String d() {
        return this.wikiSpaceId;
    }

    public final String e() {
        return this.wikiSpaceName;
    }

    public final Integer f() {
        return this.wikiSpaceType;
    }

    public d(int r100) {
        this.bizType = null;
        this.isExternal = null;
        this.notWikiObj = null;
        this.templateType = null;
        this.wikiHomepage = null;
        this.wikiSpaceCreateUid = null;
        this.wikiSpaceId = null;
        this.wikiSpaceName = null;
        this.wikiSpaceType = null;
        this.wikiSubToken = null;
        this.wikiSubtype = null;
        this.wikiVersion = null;
        this.f523580a = null;
    }

    public final void g(String r100) {
        this.wikiSpaceCreateUid = r100;
    }

    public final void h(String r100) {
        this.wikiSpaceId = r100;
    }

    public final void i(String r100) {
        this.wikiSpaceName = r100;
    }

    public final void j(Integer r100) {
        this.wikiSpaceType = r100;
    }
}
