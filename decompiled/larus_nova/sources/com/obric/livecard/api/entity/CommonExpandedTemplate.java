package com.obric.livecard.api.entity;

import com.alipay.sdk.m.x.d;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000eJ\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\bHÆ\u0003Jc\u0010,\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0017\u0010-\u001a\u00020.2\n\b\u0002\u0010/\u001a\u0004\u0018\u000100¢\u0006\u0002\u00101J\u0013\u00102\u001a\u0002002\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\t\u00106\u001a\u000207HÖ\u0001R*\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u001c\u0010\n\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001e¨\u00068"}, d2 = {"Lcom/obric/livecard/api/entity/CommonExpandedTemplate;", "", "buttonList", "", "Lcom/obric/livecard/api/entity/Button;", "content", "Lcom/obric/livecard/api/entity/Text;", "icon", "Lcom/obric/livecard/api/entity/Icon;", "title", "titleIcon", "buttonV2List", "Lcom/obric/livecard/api/entity/ButtonV2;", "contentIcon", "(Ljava/util/List;Lcom/obric/livecard/api/entity/Text;Lcom/obric/livecard/api/entity/Icon;Lcom/obric/livecard/api/entity/Text;Lcom/obric/livecard/api/entity/Icon;Ljava/util/List;Lcom/obric/livecard/api/entity/Icon;)V", "getButtonList$annotations", "()V", "getButtonList", "()Ljava/util/List;", "setButtonList", "(Ljava/util/List;)V", "getButtonV2List", "setButtonV2List", "getContent", "()Lcom/obric/livecard/api/entity/Text;", "setContent", "(Lcom/obric/livecard/api/entity/Text;)V", "getContentIcon", "()Lcom/obric/livecard/api/entity/Icon;", "setContentIcon", "(Lcom/obric/livecard/api/entity/Icon;)V", "getIcon", "setIcon", "getTitle", d.f25925o, "getTitleIcon", "setTitleIcon", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "create", "Lcom/obric/livecard/api/entity/IslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/livecard/api/entity/IslandWidget;", "equals", "other", "hashCode", "", "toString", "", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CommonExpandedTemplate {
    private List<Button> buttonList;
    private List<ButtonV2> buttonV2List;
    private Text content;
    private Icon contentIcon;
    private Icon icon;
    private Text title;
    private Icon titleIcon;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommonExpandedTemplate copy$default(CommonExpandedTemplate r100, List r101, Text r102, Icon r103, Text r104, Icon r110, List r111, Icon r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.buttonList;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.content;
    L8:
        Text r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.icon;
    L11:
        Icon r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.title;
    L14:
        Text r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.titleIcon;
    L17:
        Icon r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.buttonV2List;
    L20:
        List r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.contentIcon;
    L23:
        List r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    @Deprecated(message = "请使用buttonV2List")
    public static /* synthetic */ void getButtonList$annotations() {
    }

    public final List<Button> component1() {
        return this.buttonList;
    }

    public final Text component2() {
        return this.content;
    }

    public final Icon component3() {
        return this.icon;
    }

    public final Text component4() {
        return this.title;
    }

    public final Icon component5() {
        return this.titleIcon;
    }

    public final List<ButtonV2> component6() {
        return this.buttonV2List;
    }

    public final Icon component7() {
        return this.contentIcon;
    }

    public final CommonExpandedTemplate copy(List<Button> r110, Text r111, Icon r112, Text r113, Icon r114, List<ButtonV2> r115, Icon r116) {
        Intrinsics.checkNotNullParameter(r110, "buttonList");
        Intrinsics.checkNotNullParameter(r111, "content");
        Intrinsics.checkNotNullParameter(r115, "buttonV2List");
        return new CommonExpandedTemplate(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CommonExpandedTemplate) == true) goto L8;
        return false;
    L8:
        CommonExpandedTemplate r101 = (CommonExpandedTemplate) r100;
        if (Intrinsics.areEqual(this.buttonList, r101.buttonList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.titleIcon, r101.titleIcon) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.buttonV2List, r101.buttonV2List) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.contentIcon, r101.contentIcon) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.buttonList.hashCode() * 31) + this.content.hashCode()) * 31;
        Icon r101 = this.icon;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Text r105 = this.title;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Icon r108 = this.titleIcon;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (((r107 + r109) * 31) + this.buttonV2List.hashCode()) * 31;
        Icon r111 = this.contentIcon;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "CommonExpandedTemplate(buttonList=" + this.buttonList + ", content=" + this.content + ", icon=" + this.icon + ", title=" + this.title + ", titleIcon=" + this.titleIcon + ", buttonV2List=" + this.buttonV2List + ", contentIcon=" + this.contentIcon + ')';
    }

    public final List<Button> getButtonList() {
        return this.buttonList;
    }

    public final List<ButtonV2> getButtonV2List() {
        return this.buttonV2List;
    }

    public final Text getContent() {
        return this.content;
    }

    public final Icon getContentIcon() {
        return this.contentIcon;
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final Text getTitle() {
        return this.title;
    }

    public final Icon getTitleIcon() {
        return this.titleIcon;
    }

    public final IslandWidget create(Boolean r110) {
        return new IslandWidget("com.obric.island_applet:common_expand_template", this, r110, null, null, null, null, null, null, 504, null);
    }

    public final void setButtonList(List<Button> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.buttonList = r100;
    }

    public final void setButtonV2List(List<ButtonV2> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.buttonV2List = r100;
    }

    public final void setContent(Text r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.content = r100;
    }

    public final void setContentIcon(Icon r100) {
        this.contentIcon = r100;
    }

    public final void setIcon(Icon r100) {
        this.icon = r100;
    }

    public final void setTitle(Text r100) {
        this.title = r100;
    }

    public final void setTitleIcon(Icon r100) {
        this.titleIcon = r100;
    }

    public static /* synthetic */ IslandWidget create$default(CommonExpandedTemplate r100, Boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = Boolean.FALSE;
    L6:
        return r100.create(r101);
    }

    public CommonExpandedTemplate(List<Button> r100, Text r101, Icon r102, Text r103, Icon r104, List<ButtonV2> r105, Icon r106) {
        Intrinsics.checkNotNullParameter(r100, "buttonList");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r105, "buttonV2List");
        this.buttonList = r100;
        this.content = r101;
        this.icon = r102;
        this.title = r103;
        this.titleIcon = r104;
        this.buttonV2List = r105;
        this.contentIcon = r106;
    }

    public /* synthetic */ CommonExpandedTemplate(List r110, Text r111, Icon r112, Text r113, Icon r114, List r115, Icon r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 1) == 0) goto L5;
        List r100 = CollectionsKt.emptyList();
    L7:
        if ((r117 & 4) == 0) goto L9;
        Icon r101 = null;
    L11:
        if ((r117 & 8) == 0) goto L13;
        Text r102 = null;
    L15:
        if ((r117 & 16) == 0) goto L17;
        Icon r103 = null;
    L19:
        if ((r117 & 32) == 0) goto L21;
        List r104 = CollectionsKt.emptyList();
    L23:
        if ((r117 & 64) == 0) goto L25;
        Icon r105 = null;
    L26:
        this(r100, r111, r101, r102, r103, r104, r105);
        return;
    L25:
        r105 = r116;
        goto L26
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
