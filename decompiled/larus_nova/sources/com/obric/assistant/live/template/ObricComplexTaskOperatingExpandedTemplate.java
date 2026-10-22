package com.obric.assistant.live.template;

import com.alipay.sdk.m.x.d;
import com.obric.livecard.api.entity.Button;
import com.obric.livecard.api.entity.ButtonV2;
import com.obric.livecard.api.entity.Icon;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.entity.Text;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 42\u00020\u0001:\u00014BS\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0002\u0010%J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003HÆ\u0003JY\u0010,\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003HÆ\u0001J\u0013\u0010-\u001a\u00020$2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u000203HÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012¨\u00065"}, d2 = {"Lcom/obric/assistant/live/template/ObricComplexTaskOperatingExpandedTemplate;", "Lcom/obric/assistant/live/template/IObricTemplate;", "buttonList", "", "Lcom/obric/livecard/api/entity/Button;", "content", "Lcom/obric/livecard/api/entity/Text;", "icon", "Lcom/obric/livecard/api/entity/Icon;", "title", "titleIcon", "buttonV2List", "Lcom/obric/livecard/api/entity/ButtonV2;", "<init>", "(Ljava/util/List;Lcom/obric/livecard/api/entity/Text;Lcom/obric/livecard/api/entity/Icon;Lcom/obric/livecard/api/entity/Text;Lcom/obric/livecard/api/entity/Icon;Ljava/util/List;)V", "getButtonList", "()Ljava/util/List;", "setButtonList", "(Ljava/util/List;)V", "getContent", "()Lcom/obric/livecard/api/entity/Text;", "setContent", "(Lcom/obric/livecard/api/entity/Text;)V", "getIcon", "()Lcom/obric/livecard/api/entity/Icon;", "setIcon", "(Lcom/obric/livecard/api/entity/Icon;)V", "getTitle", d.f25925o, "getTitleIcon", "setTitleIcon", "getButtonV2List", "setButtonV2List", "create", "Lcom/obric/livecard/api/entity/IslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/livecard/api/entity/IslandWidget;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricComplexTaskOperatingExpandedTemplate implements IObricTemplate {
    public static final a Companion = null;
    private static final String TEMPLATE_ID = "com.obric.island_applet:common_expand_template";
    private List<Button> buttonList;
    private List<ButtonV2> buttonV2List;
    private Text content;
    private Icon icon;
    private Text title;
    private Icon titleIcon;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricComplexTaskOperatingExpandedTemplate copy$default(ObricComplexTaskOperatingExpandedTemplate r100, List r101, Text r102, Icon r103, Text r104, Icon r105, List r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.buttonList;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.content;
    L8:
        Text r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.icon;
    L11:
        Icon r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.title;
    L14:
        Text r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.titleIcon;
    L17:
        Icon r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.buttonV2List;
    L20:
        List r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
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

    public final ObricComplexTaskOperatingExpandedTemplate copy(List<Button> r100, Text r110, Icon r111, Text r112, Icon r113, List<ButtonV2> r114) {
        Intrinsics.checkNotNullParameter(r100, "buttonList");
        Intrinsics.checkNotNullParameter(r110, "content");
        return new ObricComplexTaskOperatingExpandedTemplate(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricComplexTaskOperatingExpandedTemplate) == true) goto L8;
        return false;
    L8:
        ObricComplexTaskOperatingExpandedTemplate r101 = (ObricComplexTaskOperatingExpandedTemplate) r100;
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
        if (Intrinsics.areEqual(this.buttonV2List, r101.buttonV2List) == true) goto L26;
        return false;
    L26:
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
        int r110 = (r107 + r109) * 31;
        List<ButtonV2> r111 = this.buttonV2List;
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
        return "ObricComplexTaskOperatingExpandedTemplate(buttonList=" + this.buttonList + ", content=" + this.content + ", icon=" + this.icon + ", title=" + this.title + ", titleIcon=" + this.titleIcon + ", buttonV2List=" + this.buttonV2List + ')';
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

    public final Icon getIcon() {
        return this.icon;
    }

    public final Text getTitle() {
        return this.title;
    }

    public final Icon getTitleIcon() {
        return this.titleIcon;
    }

    @Override // com.obric.assistant.live.template.IObricTemplate
    public IslandWidget create(Boolean r110) {
        return new IslandWidget(TEMPLATE_ID, this, r110, null, null, null, null, null, null, 504, null);
    }

    public final void setButtonList(List<Button> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.buttonList = r100;
    }

    public final void setButtonV2List(List<ButtonV2> r100) {
        this.buttonV2List = r100;
    }

    public final void setContent(Text r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.content = r100;
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

    public ObricComplexTaskOperatingExpandedTemplate(List<Button> r100, Text r101, Icon r102, Text r103, Icon r104, List<ButtonV2> r105) {
        Intrinsics.checkNotNullParameter(r100, "buttonList");
        Intrinsics.checkNotNullParameter(r101, "content");
        this.buttonList = r100;
        this.content = r101;
        this.icon = r102;
        this.title = r103;
        this.titleIcon = r104;
        this.buttonV2List = r105;
    }

    public /* synthetic */ ObricComplexTaskOperatingExpandedTemplate(List r110, Text r111, Icon r112, Text r113, Icon r114, List r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 4) == 0) goto L5;
        Icon r100 = null;
    L7:
        if ((r116 & 8) == 0) goto L9;
        Text r101 = null;
    L11:
        if ((r116 & 16) == 0) goto L13;
        Icon r102 = null;
    L15:
        if ((r116 & 32) == 0) goto L17;
        List r103 = null;
    L18:
        this(r110, r111, r100, r101, r102, r103);
        return;
    L17:
        r103 = r115;
        goto L18
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
