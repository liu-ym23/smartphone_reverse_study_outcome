package com.obric.assistant.live.template;

import com.alipay.sdk.m.x.d;
import com.obric.livecard.api.entity.Button;
import com.obric.livecard.api.entity.ButtonV2;
import com.obric.livecard.api.entity.Icon;
import com.obric.livecard.api.entity.IslandWidget;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u0001:BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0002\u0010+J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u00100\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u0011\u00101\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000bHÆ\u0003J[\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000bHÆ\u0001J\u0013\u00103\u001a\u00020*2\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u000209HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$¨\u0006;"}, d2 = {"Lcom/obric/assistant/live/template/ObricAINotificationTemplate;", "Lcom/obric/assistant/live/template/IObricTemplate;", "leftIcon", "Lcom/obric/livecard/api/entity/Icon;", "rightIcon", "Lcom/obric/assistant/live/template/ObricAINotificationTemplateIcon;", "title", "Lcom/obric/assistant/live/template/ObricAINotificationTemplateText;", "description", "Lcom/obric/assistant/live/template/ObricAINotificationDescription;", "buttonList", "", "Lcom/obric/livecard/api/entity/Button;", "buttonV2List", "Lcom/obric/livecard/api/entity/ButtonV2;", "<init>", "(Lcom/obric/livecard/api/entity/Icon;Lcom/obric/assistant/live/template/ObricAINotificationTemplateIcon;Lcom/obric/assistant/live/template/ObricAINotificationTemplateText;Lcom/obric/assistant/live/template/ObricAINotificationDescription;Ljava/util/List;Ljava/util/List;)V", "getLeftIcon", "()Lcom/obric/livecard/api/entity/Icon;", "setLeftIcon", "(Lcom/obric/livecard/api/entity/Icon;)V", "getRightIcon", "()Lcom/obric/assistant/live/template/ObricAINotificationTemplateIcon;", "setRightIcon", "(Lcom/obric/assistant/live/template/ObricAINotificationTemplateIcon;)V", "getTitle", "()Lcom/obric/assistant/live/template/ObricAINotificationTemplateText;", d.f25925o, "(Lcom/obric/assistant/live/template/ObricAINotificationTemplateText;)V", "getDescription", "()Lcom/obric/assistant/live/template/ObricAINotificationDescription;", "setDescription", "(Lcom/obric/assistant/live/template/ObricAINotificationDescription;)V", "getButtonList", "()Ljava/util/List;", "setButtonList", "(Ljava/util/List;)V", "getButtonV2List", "setButtonV2List", "create", "Lcom/obric/livecard/api/entity/IslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/livecard/api/entity/IslandWidget;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAINotificationTemplate implements IObricTemplate {
    public static final a Companion = null;
    private static final String TEMPLATE_ID = "com.obric.island_assistant:ai_notification_template";
    private List<Button> buttonList;
    private List<ButtonV2> buttonV2List;
    private ObricAINotificationDescription description;
    private Icon leftIcon;
    private ObricAINotificationTemplateIcon rightIcon;
    private ObricAINotificationTemplateText title;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricAINotificationTemplate copy$default(ObricAINotificationTemplate r100, Icon r101, ObricAINotificationTemplateIcon r102, ObricAINotificationTemplateText r103, ObricAINotificationDescription r104, List r105, List r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.leftIcon;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.rightIcon;
    L8:
        ObricAINotificationTemplateIcon r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.title;
    L11:
        ObricAINotificationTemplateText r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.description;
    L14:
        ObricAINotificationDescription r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.buttonList;
    L17:
        List r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.buttonV2List;
    L20:
        Icon r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Icon component1() {
        return this.leftIcon;
    }

    public final ObricAINotificationTemplateIcon component2() {
        return this.rightIcon;
    }

    public final ObricAINotificationTemplateText component3() {
        return this.title;
    }

    public final ObricAINotificationDescription component4() {
        return this.description;
    }

    public final List<Button> component5() {
        return this.buttonList;
    }

    public final List<ButtonV2> component6() {
        return this.buttonV2List;
    }

    public final ObricAINotificationTemplate copy(Icon r100, ObricAINotificationTemplateIcon r110, ObricAINotificationTemplateText r111, ObricAINotificationDescription r112, List<Button> r113, List<ButtonV2> r114) {
        Intrinsics.checkNotNullParameter(r111, "title");
        return new ObricAINotificationTemplate(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricAINotificationTemplate) == true) goto L8;
        return false;
    L8:
        ObricAINotificationTemplate r101 = (ObricAINotificationTemplate) r100;
        if (Intrinsics.areEqual(this.leftIcon, r101.leftIcon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rightIcon, r101.rightIcon) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.buttonList, r101.buttonList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.buttonV2List, r101.buttonV2List) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Icon r100 = this.leftIcon;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ObricAINotificationTemplateIcon r104 = this.rightIcon;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.title.hashCode()) * 31;
        ObricAINotificationDescription r107 = this.description;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<Button> r110 = this.buttonList;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<ButtonV2> r113 = this.buttonV2List;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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

    public String toString() {
        return "ObricAINotificationTemplate(leftIcon=" + this.leftIcon + ", rightIcon=" + this.rightIcon + ", title=" + this.title + ", description=" + this.description + ", buttonList=" + this.buttonList + ", buttonV2List=" + this.buttonV2List + ')';
    }

    public final List<Button> getButtonList() {
        return this.buttonList;
    }

    public final List<ButtonV2> getButtonV2List() {
        return this.buttonV2List;
    }

    public final ObricAINotificationDescription getDescription() {
        return this.description;
    }

    public final Icon getLeftIcon() {
        return this.leftIcon;
    }

    public final ObricAINotificationTemplateIcon getRightIcon() {
        return this.rightIcon;
    }

    public final ObricAINotificationTemplateText getTitle() {
        return this.title;
    }

    @Override // com.obric.assistant.live.template.IObricTemplate
    public IslandWidget create(Boolean r110) {
        return new IslandWidget(TEMPLATE_ID, this, r110, null, null, null, null, null, null, 504, null);
    }

    public final void setButtonList(List<Button> r100) {
        this.buttonList = r100;
    }

    public final void setButtonV2List(List<ButtonV2> r100) {
        this.buttonV2List = r100;
    }

    public final void setDescription(ObricAINotificationDescription r100) {
        this.description = r100;
    }

    public final void setLeftIcon(Icon r100) {
        this.leftIcon = r100;
    }

    public final void setRightIcon(ObricAINotificationTemplateIcon r100) {
        this.rightIcon = r100;
    }

    public final void setTitle(ObricAINotificationTemplateText r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.title = r100;
    }

    public ObricAINotificationTemplate(Icon r100, ObricAINotificationTemplateIcon r101, ObricAINotificationTemplateText r102, ObricAINotificationDescription r103, List<Button> r104, List<ButtonV2> r105) {
        Intrinsics.checkNotNullParameter(r102, "title");
        this.leftIcon = r100;
        this.rightIcon = r101;
        this.title = r102;
        this.description = r103;
        this.buttonList = r104;
        this.buttonV2List = r105;
    }

    public /* synthetic */ ObricAINotificationTemplate(Icon r110, ObricAINotificationTemplateIcon r111, ObricAINotificationTemplateText r112, ObricAINotificationDescription r113, List r114, List r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 1) == 0) goto L5;
        Icon r100 = null;
    L7:
        if ((r116 & 2) == 0) goto L9;
        ObricAINotificationTemplateIcon r101 = null;
    L11:
        if ((r116 & 8) == 0) goto L13;
        ObricAINotificationDescription r102 = null;
    L15:
        if ((r116 & 16) == 0) goto L17;
        List r103 = null;
    L19:
        if ((r116 & 32) == 0) goto L21;
        List r104 = null;
    L22:
        this(r100, r101, r112, r102, r103, r104);
        return;
    L21:
        r104 = r115;
        goto L22
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
