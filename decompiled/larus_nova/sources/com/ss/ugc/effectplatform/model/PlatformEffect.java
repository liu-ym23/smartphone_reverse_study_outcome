package com.ss.ugc.effectplatform.model;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J \u0010%\u001a\u00020&2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\u0006\u0010(\u001a\u00020\u0003H\u0002Jc\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\u0016\u0010/\u001a\u0002002\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bJ\t\u00101\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001b¨\u00062"}, d2 = {"Lcom/ss/ugc/effectplatform/model/PlatformEffect;", "", "name", "", "hint", "file_uri", "icon_uri", "types", "", "hint_uri", "requirements", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getFile_uri", "()Ljava/lang/String;", "setFile_uri", "(Ljava/lang/String;)V", "getHint", "setHint", "getHint_uri", "setHint_uri", "getIcon_uri", "setIcon_uri", "getName", "setName", "getRequirements", "()Ljava/util/List;", "setRequirements", "(Ljava/util/List;)V", "getTypes", "setTypes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "concatPrefixWithUri", "Lcom/ss/ugc/effectplatform/model/UrlModel;", "url_prefix", "uri", "copy", "equals", "", "other", "hashCode", "", "toEffect", "Lcom/ss/ugc/effectplatform/model/Effect;", "toString", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public final class PlatformEffect {
    private String file_uri;
    private String hint;
    private String hint_uri;
    private String icon_uri;
    private String name;
    private List<String> requirements;
    private List<String> types;

    public PlatformEffect() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlatformEffect copy$default(PlatformEffect r100, String r101, String r102, String r103, String r104, List r110, String r111, List r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.name;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.hint;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.file_uri;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.icon_uri;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.types;
    L17:
        List r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.hint_uri;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.requirements;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.hint;
    }

    public final String component3() {
        return this.file_uri;
    }

    public final String component4() {
        return this.icon_uri;
    }

    public final List<String> component5() {
        return this.types;
    }

    public final String component6() {
        return this.hint_uri;
    }

    public final List<String> component7() {
        return this.requirements;
    }

    public final PlatformEffect copy(String r110, String r111, String r112, String r113, List<String> r114, String r115, List<String> r116) {
        return new PlatformEffect(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PlatformEffect) == false) goto L20;
        PlatformEffect r101 = (PlatformEffect) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.hint, r101.hint) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.file_uri, r101.file_uri) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.icon_uri, r101.icon_uri) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.types, r101.types) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.hint_uri, r101.hint_uri) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.requirements, r101.requirements) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.hint;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.file_uri;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.icon_uri;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<String> r113 = this.types;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.hint_uri;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        List<String> r119 = this.requirements;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PlatformEffect(name=" + this.name + ", hint=" + this.hint + ", file_uri=" + this.file_uri + ", icon_uri=" + this.icon_uri + ", types=" + this.types + ", hint_uri=" + this.hint_uri + ", requirements=" + this.requirements + ")";
    }

    public final String getFile_uri() {
        return this.file_uri;
    }

    public final String getHint() {
        return this.hint;
    }

    public final String getHint_uri() {
        return this.hint_uri;
    }

    public final String getIcon_uri() {
        return this.icon_uri;
    }

    public final String getName() {
        return this.name;
    }

    public final List<String> getRequirements() {
        return this.requirements;
    }

    public final List<String> getTypes() {
        return this.types;
    }

    public final void setFile_uri(String r100) {
        this.file_uri = r100;
    }

    public final void setHint(String r100) {
        this.hint = r100;
    }

    public final void setHint_uri(String r100) {
        this.hint_uri = r100;
    }

    public final void setIcon_uri(String r100) {
        this.icon_uri = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setRequirements(List<String> r100) {
        this.requirements = r100;
    }

    public final void setTypes(List<String> r100) {
        this.types = r100;
    }

    public final Effect toEffect(List<String> r810) {
        Effect r110 = new Effect(null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, false, null, false, null, null, 0, null, null, 0, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, null, 0, null, null, 0, null, null, 0, 0, 0, -1, -1, 15, null);
        String r100 = this.name;
        String r101 = "";
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        r110.setName(r100);
        String r102 = this.hint;
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        r110.setHint(r102);
        r110.setFile_url(concatPrefixWithUri(r810, this.file_uri));
        List<String> r103 = this.types;
        if (r103 != null) goto L14;
        r103 = new ArrayList();
    L14:
        r110.setTypes(r103);
        r110.setHint_icon(concatPrefixWithUri(r810, this.hint_uri));
        r110.setIcon_url(concatPrefixWithUri(r810, this.icon_uri));
        List<String> r104 = this.requirements;
        if (r104 != null) goto L18;
        r104 = new ArrayList();
    L18:
        r110.setRequirements(r104);
        String r105 = this.file_uri;
        if (r105 == null) goto L21;
        r101 = r105;
    L21:
        r110.setId(r101);
        return r110;
    }

    private final UrlModel concatPrefixWithUri(List<String> r100, String r110) {
        UrlModel r101 = new UrlModel(null, null, null, null, 15, null);
        r101.setUri(r110);
        if (r100 == null) goto L8;
        ArrayList r102 = new ArrayList();
        int r103 = r100.size();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L7;
        r102.add(((String) ListProtector.get(r100, r104)) + r110);
        r104 = r104 + 1;
        goto L5
    L7:
        r101.setUrl_list(r102);
    L8:
        return r101;
    }

    public PlatformEffect(String r100, String r101, String r102, String r103, List<String> r104, String r105, List<String> r106) {
        this.name = r100;
        this.hint = r101;
        this.file_uri = r102;
        this.icon_uri = r103;
        this.types = r104;
        this.hint_uri = r105;
        this.requirements = r106;
    }

    public /* synthetic */ PlatformEffect(String r100, String r101, String r102, String r110, List r111, String r112, List r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r104 = "";
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r105 = "";
    L19:
        if ((r114 & 16) == 0) goto L21;
        List r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        String r107 = "";
    L27:
        if ((r114 & 64) == 0) goto L29;
        List r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
