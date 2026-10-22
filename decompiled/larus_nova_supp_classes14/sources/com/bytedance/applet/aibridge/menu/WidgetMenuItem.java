package com.bytedance.applet.aibridge.menu;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b&\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B«\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000f\u0012\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00100\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00101\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0011\u00102\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000fHÆ\u0003J\u0019\u00103\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0003J²\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000f2\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u00020\u000b2\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u000209HÖ\u0001J\t\u0010:\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001eR\u001a\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b!\u0010\u001eR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R*\u0010\u0010\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006;"}, d2 = {"Lcom/bytedance/applet/aibridge/menu/WidgetMenuItem;", "", "text", "", "iconLight", "iconDark", "id", "textColorLight", "textColorDark", "itemStyle", "switchStatus", "", "forbiddenDismissAfterClick", "disableClick", "lineItems", "", "onTap", "Lkotlin/Function1;", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getText", "()Ljava/lang/String;", "getIconLight", "getIconDark", "getId", "getTextColorLight", "getTextColorDark", "getItemStyle", "getSwitchStatus", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getForbiddenDismissAfterClick", "getDisableClick", "getLineItems", "()Ljava/util/List;", "getOnTap", "()Lkotlin/jvm/functions/Function1;", "setOnTap", "(Lkotlin/jvm/functions/Function1;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Lkotlin/jvm/functions/Function1;)Lcom/bytedance/applet/aibridge/menu/WidgetMenuItem;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WidgetMenuItem {

    @SerializedName("disableClick")
    private final Boolean disableClick;

    @SerializedName("forbiddenDismissAfterClick")
    private final Boolean forbiddenDismissAfterClick;

    @SerializedName("iconDark")
    private final String iconDark;

    @SerializedName("iconLight")
    private final String iconLight;

    @SerializedName("id")
    private final String id;

    @SerializedName("itemStyle")
    private final String itemStyle;

    @SerializedName("lineItems")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<WidgetMenuItem> lineItems;
    private Function1<? super Boolean, Unit> onTap;

    @SerializedName("switchStatus")
    private final Boolean switchStatus;

    @SerializedName("text")
    private final String text;

    @SerializedName("textColorDark")
    private final String textColorDark;

    @SerializedName("textColorLight")
    private final String textColorLight;

    public WidgetMenuItem() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetMenuItem copy$default(WidgetMenuItem r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, Boolean r21, Boolean r22, Boolean r23, List r24, Function1 r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        String r2 = r13.text;
    L7:
        if ((r26 & 2) == 0) goto L9;
        String r3 = r13.iconLight;
    L11:
        if ((r26 & 4) == 0) goto L13;
        String r4 = r13.iconDark;
    L15:
        if ((r26 & 8) == 0) goto L17;
        String r5 = r13.id;
    L19:
        if ((r26 & 16) == 0) goto L21;
        String r6 = r13.textColorLight;
    L23:
        if ((r26 & 32) == 0) goto L25;
        String r7 = r13.textColorDark;
    L27:
        if ((r26 & 64) == 0) goto L29;
        String r8 = r13.itemStyle;
    L31:
        if ((r26 & 128) == 0) goto L33;
        Boolean r9 = r13.switchStatus;
    L35:
        if ((r26 & 256) == 0) goto L37;
        Boolean r10 = r13.forbiddenDismissAfterClick;
    L39:
        if ((r26 & 512) == 0) goto L41;
        Boolean r11 = r13.disableClick;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        List r12 = r13.lineItems;
    L47:
        if ((r26 & 2048) == 0) goto L49;
        Function1 r1 = r13.onTap;
    L51:
        return r13.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r1);
    L49:
        r1 = r25;
        goto L51
    L45:
        r12 = r24;
        goto L47
    L41:
        r11 = r23;
        goto L43
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final String component1() {
        return this.text;
    }

    public final Boolean component10() {
        return this.disableClick;
    }

    public final List<WidgetMenuItem> component11() {
        return this.lineItems;
    }

    public final Function1<Boolean, Unit> component12() {
        return this.onTap;
    }

    public final String component2() {
        return this.iconLight;
    }

    public final String component3() {
        return this.iconDark;
    }

    public final String component4() {
        return this.id;
    }

    public final String component5() {
        return this.textColorLight;
    }

    public final String component6() {
        return this.textColorDark;
    }

    public final String component7() {
        return this.itemStyle;
    }

    public final Boolean component8() {
        return this.switchStatus;
    }

    public final Boolean component9() {
        return this.forbiddenDismissAfterClick;
    }

    public final WidgetMenuItem copy(String r15, String r16, String r17, String r18, String r19, String r20, String r21, Boolean r22, Boolean r23, Boolean r24, List<WidgetMenuItem> r25, Function1<? super Boolean, Unit> r26) {
        return new WidgetMenuItem(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WidgetMenuItem) == true) goto L8;
        return false;
    L8:
        WidgetMenuItem r6 = (WidgetMenuItem) r5;
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.iconLight, r6.iconLight) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.iconDark, r6.iconDark) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.textColorLight, r6.textColorLight) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.textColorDark, r6.textColorDark) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.itemStyle, r6.itemStyle) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.switchStatus, r6.switchStatus) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.forbiddenDismissAfterClick, r6.forbiddenDismissAfterClick) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.disableClick, r6.disableClick) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.lineItems, r6.lineItems) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.onTap, r6.onTap) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        String r0 = this.text;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.iconLight;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.iconDark;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.id;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.textColorLight;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.textColorDark;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.itemStyle;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Boolean r22 = this.switchStatus;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Boolean r25 = this.forbiddenDismissAfterClick;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Boolean r28 = this.disableClick;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        List<WidgetMenuItem> r31 = this.lineItems;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Function1<? super Boolean, Unit> r34 = this.onTap;
        if (r34 == null) goto L51;
        r1 = r34.hashCode();
    L51:
        return r33 + r1;
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

    public String toString() {
        return "WidgetMenuItem(text=" + this.text + ", iconLight=" + this.iconLight + ", iconDark=" + this.iconDark + ", id=" + this.id + ", textColorLight=" + this.textColorLight + ", textColorDark=" + this.textColorDark + ", itemStyle=" + this.itemStyle + ", switchStatus=" + this.switchStatus + ", forbiddenDismissAfterClick=" + this.forbiddenDismissAfterClick + ", disableClick=" + this.disableClick + ", lineItems=" + this.lineItems + ", onTap=" + this.onTap + ')';
    }

    public final Boolean getDisableClick() {
        return this.disableClick;
    }

    public final Boolean getForbiddenDismissAfterClick() {
        return this.forbiddenDismissAfterClick;
    }

    public final String getIconDark() {
        return this.iconDark;
    }

    public final String getIconLight() {
        return this.iconLight;
    }

    public final String getId() {
        return this.id;
    }

    public final String getItemStyle() {
        return this.itemStyle;
    }

    public final List<WidgetMenuItem> getLineItems() {
        return this.lineItems;
    }

    public final Function1<Boolean, Unit> getOnTap() {
        return this.onTap;
    }

    public final Boolean getSwitchStatus() {
        return this.switchStatus;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextColorDark() {
        return this.textColorDark;
    }

    public final String getTextColorLight() {
        return this.textColorLight;
    }

    public final void setOnTap(Function1<? super Boolean, Unit> r1) {
        this.onTap = r1;
    }

    public WidgetMenuItem(String r1, String r2, String r3, String r4, String r5, String r6, String r7, Boolean r8, Boolean r9, Boolean r10, List<WidgetMenuItem> r11, Function1<? super Boolean, Unit> r12) {
        this.text = r1;
        this.iconLight = r2;
        this.iconDark = r3;
        this.id = r4;
        this.textColorLight = r5;
        this.textColorDark = r6;
        this.itemStyle = r7;
        this.switchStatus = r8;
        this.forbiddenDismissAfterClick = r9;
        this.disableClick = r10;
        this.lineItems = r11;
        this.onTap = r12;
    }

    public /* synthetic */ WidgetMenuItem(String r14, String r15, String r16, String r17, String r18, String r19, String r20, Boolean r21, Boolean r22, Boolean r23, List r24, Function1 r25, int r26, DefaultConstructorMarker r27) {
        Function1 r2 = null;
        if ((r26 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r26 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r26 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r26 & 8) == 0) goto L17;
        String r5 = "";
    L19:
        if ((r26 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r26 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r26 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r26 & 128) == 0) goto L33;
        Boolean r9 = Boolean.FALSE;
    L35:
        if ((r26 & 256) == 0) goto L37;
        Boolean r10 = Boolean.FALSE;
    L39:
        if ((r26 & 512) == 0) goto L41;
        Boolean r11 = Boolean.FALSE;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        List r12 = null;
    L47:
        if ((r26 & 2048) != 0) goto L50;
        r2 = r25;
    L50:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r2);
        return;
    L45:
        r12 = r24;
        goto L47
    L41:
        r11 = r23;
        goto L43
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r1 = r14;
        goto L7
    }
}
