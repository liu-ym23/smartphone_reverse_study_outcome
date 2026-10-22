package oj5;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b7\b\u0086\b\u0018\u0000 ?2\u00020\u0001:\u0001?B£\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010,\u001a\u00020\tH\u0016J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u00101\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u00106\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u00108\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\tHÆ\u0003Jª\u0001\u0010:\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010;J\u0013\u0010<\u001a\u00020\u00052\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0004\u0010\u0017R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001a\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR \u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001c\"\u0004\b\u001e\u0010\u001fR \u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001fR \u0010\f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001c\"\u0004\b#\u0010\u001fR\"\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010&R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b(\u0010\u0015R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001c\"\u0004\b+\u0010\u001f¨\u0006@"}, d2 = {"Lcom/bytedance/ee/bear/more/export/SpaceListExtra;", "", "bizType", "", "isExternal", "", "notWikiObj", "templateType", "wikiHomepage", "", "wikiSpaceCreateUid", "wikiSpaceId", "wikiSpaceName", "wikiSpaceType", "wikiSubToken", "wikiSubtype", "wikiVersion", WikiFolderPushPlugin.WIKI_TOKEN, "<init>", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getBizType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNotWikiObj", "getTemplateType", "getWikiHomepage", "()Ljava/lang/String;", "getWikiSpaceCreateUid", "setWikiSpaceCreateUid", "(Ljava/lang/String;)V", "getWikiSpaceId", "setWikiSpaceId", "getWikiSpaceName", "setWikiSpaceName", "getWikiSpaceType", "setWikiSpaceType", "(Ljava/lang/Integer;)V", "getWikiSubToken", "getWikiSubtype", "getWikiVersion", "getWikiToken", "setWikiToken", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/ee/bear/more/export/SpaceListExtra;", "equals", "other", "hashCode", "Companion", "features-more-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {
    public static final /* synthetic */ int b = 0;
    public String a;

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
        public static d a(String r3) {
            if (r3 != null) goto L4;
        L7:
            boolean r0 = true;
        L9:
            if (r0 == false) goto L16;
            return null;
        L16:
            return (d) new Gson().fromJson(r3, d.class);
        L13:
            e = move-exception;
            tt5.a.d("WikiExtra", "fromJson fail: " + e);
            return null;
        L4:
            if (r3.length() == 0) goto L7;
            r0 = false;
            goto L9
        }
    }

    static {
    }

    public d() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.bizType, r6.bizType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isExternal, r6.isExternal) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.notWikiObj, r6.notWikiObj) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.templateType, r6.templateType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.wikiHomepage, r6.wikiHomepage) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.wikiSpaceCreateUid, r6.wikiSpaceCreateUid) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.wikiSpaceId, r6.wikiSpaceId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.wikiSpaceName, r6.wikiSpaceName) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.wikiSpaceType, r6.wikiSpaceType) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.wikiSubToken, r6.wikiSubToken) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.wikiSubtype, r6.wikiSubtype) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.wikiVersion, r6.wikiVersion) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.bizType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.isExternal;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.notWikiObj;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.templateType;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.wikiHomepage;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.wikiSpaceCreateUid;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.wikiSpaceId;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.wikiSpaceName;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.wikiSpaceType;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.wikiSubToken;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Integer r31 = this.wikiSubtype;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.wikiVersion;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.a;
        if (r37 == null) goto L55;
        r1 = r37.hashCode();
    L55:
        return r36 + r1;
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
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

    public d(int r1) {
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
        this.a = null;
    }

    public final void g(String r1) {
        this.wikiSpaceCreateUid = r1;
    }

    public final void h(String r1) {
        this.wikiSpaceId = r1;
    }

    public final void i(String r1) {
        this.wikiSpaceName = r1;
    }

    public final void j(Integer r1) {
        this.wikiSpaceType = r1;
    }
}
