package com.larksuite.component.card.component.personlist;

import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001cJ\t\u0010&\u001a\u00020\u000eHÆ\u0003J\\\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\fHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006-"}, d2 = {"Lcom/larksuite/component/card/component/personlist/PersonListProps;", "", "tag", "", "id", "persons", "", "Lcom/larksuite/component/card/component/personlist/PersonInfo;", "showAvatar", "", "showName", GXTemplateKey.STYLE_FONT_LINES, "", "styles", "Lcom/larksuite/component/card/component/personlist/PersonStyle;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZZLjava/lang/Integer;Lcom/larksuite/component/card/component/personlist/PersonStyle;)V", "getTag", "()Ljava/lang/String;", "getId", "getPersons", "()Ljava/util/List;", "setPersons", "(Ljava/util/List;)V", "getShowAvatar", "()Z", "getShowName", "getLines", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStyles", "()Lcom/larksuite/component/card/component/personlist/PersonStyle;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZZLjava/lang/Integer;Lcom/larksuite/component/card/component/personlist/PersonStyle;)Lcom/larksuite/component/card/component/personlist/PersonListProps;", "equals", "other", "hashCode", "toString", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PersonListProps {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f283423id;
    private final Integer lines;
    private List<PersonInfo> persons;
    private final boolean showAvatar;
    private final boolean showName;
    private final PersonStyle styles;
    private final String tag;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PersonListProps copy$default(PersonListProps r100, String r101, String r102, List r103, boolean r104, boolean r110, Integer r111, PersonStyle r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.tag;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.f283423id;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.persons;
    L11:
        List r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.showAvatar;
    L14:
        boolean r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.showName;
    L17:
        boolean r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.lines;
    L20:
        Integer r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.styles;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.tag;
    }

    public final String component2() {
        return this.f283423id;
    }

    public final List<PersonInfo> component3() {
        return this.persons;
    }

    public final boolean component4() {
        return this.showAvatar;
    }

    public final boolean component5() {
        return this.showName;
    }

    public final Integer component6() {
        return this.lines;
    }

    public final PersonStyle component7() {
        return this.styles;
    }

    public final PersonListProps copy(String r110, String r111, List<PersonInfo> r112, boolean r113, boolean r114, Integer r115, PersonStyle r116) {
        Intrinsics.checkNotNullParameter(r110, "tag");
        Intrinsics.checkNotNullParameter(r111, "id");
        Intrinsics.checkNotNullParameter(r112, "persons");
        Intrinsics.checkNotNullParameter(r116, "styles");
        return new PersonListProps(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PersonListProps) == true) goto L8;
        return false;
    L8:
        PersonListProps r101 = (PersonListProps) r100;
        if (Intrinsics.areEqual(this.tag, r101.tag) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f283423id, r101.f283423id) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.persons, r101.persons) == true) goto L18;
        return false;
    L18:
        if (this.showAvatar == r101.showAvatar) goto L21;
        return false;
    L21:
        if (this.showName == r101.showName) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.lines, r101.lines) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.styles, r101.styles) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.tag.hashCode() * 31) + this.f283423id.hashCode()) * 31) + this.persons.hashCode()) * 31;
        int r101 = 1231;
        if (this.showAvatar == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.showName == true) goto L10;
        r101 = 1237;
    L10:
        int r104 = (r103 + r101) * 31;
        Integer r105 = this.lines;
        if (r105 != null) goto L13;
        int r106 = 0;
    L15:
        return ((r104 + r106) * 31) + this.styles.hashCode();
    L13:
        r106 = r105.hashCode();
        goto L15
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "PersonListProps(tag=" + this.tag + ", id=" + this.f283423id + ", persons=" + this.persons + ", showAvatar=" + this.showAvatar + ", showName=" + this.showName + ", lines=" + this.lines + ", styles=" + this.styles + ')';
    }

    public final String getId() {
        return this.f283423id;
    }

    public final Integer getLines() {
        return this.lines;
    }

    public final List<PersonInfo> getPersons() {
        return this.persons;
    }

    public final boolean getShowAvatar() {
        return this.showAvatar;
    }

    public final boolean getShowName() {
        return this.showName;
    }

    public final PersonStyle getStyles() {
        return this.styles;
    }

    public final String getTag() {
        return this.tag;
    }

    public final void setPersons(List<PersonInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.persons = r100;
    }

    public PersonListProps(String r100, String r101, List<PersonInfo> r102, boolean r103, boolean r104, Integer r105, PersonStyle r106) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r102, "persons");
        Intrinsics.checkNotNullParameter(r106, "styles");
        this.tag = r100;
        this.f283423id = r101;
        this.persons = r102;
        this.showAvatar = r103;
        this.showName = r104;
        this.lines = r105;
        this.styles = r106;
    }

    public /* synthetic */ PersonListProps(String r110, String r111, List r112, boolean r113, boolean r114, Integer r115, PersonStyle r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 32) == 0) goto L5;
        Integer r100 = 0;
    L6:
        this(r110, r111, r112, r113, r114, r100, r116);
        return;
    L5:
        r100 = r115;
        goto L6
    }
}
