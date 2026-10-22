package com.obric.livecard.api.entity;

import com.bytedance.crash.dumper.Scraps;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019J\u0017\u0010G\u001a\u00020H2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010JR,\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010'\"\u0004\b4\u0010)R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b\u0010\u0010/\"\u0004\b5\u00101R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u00106\"\u0004\b7\u00108R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010'\"\u0004\b>\u0010)R\u001a\u0010\u0011\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006K"}, d2 = {"Lcom/obric/livecard/api/entity/TimerExpandTemplate;", "", "icon", "Lcom/obric/livecard/api/entity/Icon;", "titleIcon", "content", "Lcom/obric/livecard/api/entity/Text;", "buttonList", "", "Lcom/obric/livecard/api/entity/Button;", "timeStyle", "Lcom/obric/livecard/api/entity/TimeStyle;", EventConstants.ExtraJson.EXTRA_CURRENT_TIMESTAMP, "", "duration", "", "is_auto", "type", Scraps.INNER_UNIT, "", "buttonV2List", "Lcom/obric/livecard/api/entity/ButtonV2;", "contentIcon", "is_time_bottom", "", "(Lcom/obric/livecard/api/entity/Icon;Lcom/obric/livecard/api/entity/Icon;Lcom/obric/livecard/api/entity/Text;Ljava/util/List;Lcom/obric/livecard/api/entity/TimeStyle;JLjava/lang/Integer;Ljava/lang/Integer;ILjava/lang/String;Ljava/util/List;Lcom/obric/livecard/api/entity/Icon;Z)V", "getButtonList$annotations", "()V", "getButtonList", "()Ljava/util/List;", "setButtonList", "(Ljava/util/List;)V", "getButtonV2List", "setButtonV2List", "getContent", "()Lcom/obric/livecard/api/entity/Text;", "setContent", "(Lcom/obric/livecard/api/entity/Text;)V", "getContentIcon", "()Lcom/obric/livecard/api/entity/Icon;", "setContentIcon", "(Lcom/obric/livecard/api/entity/Icon;)V", "getCurrent_timestamp", "()J", "setCurrent_timestamp", "(J)V", "getDuration", "()Ljava/lang/Integer;", "setDuration", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getIcon", "setIcon", "set_auto", "()Z", "set_time_bottom", "(Z)V", "getTimeStyle", "()Lcom/obric/livecard/api/entity/TimeStyle;", "setTimeStyle", "(Lcom/obric/livecard/api/entity/TimeStyle;)V", "getTitleIcon", "setTitleIcon", "getType", "()I", "setType", "(I)V", "getUnit", "()Ljava/lang/String;", "setUnit", "(Ljava/lang/String;)V", "create", "Lcom/obric/livecard/api/entity/IslandWidget;", "isDefault", "(Ljava/lang/Boolean;)Lcom/obric/livecard/api/entity/IslandWidget;", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TimerExpandTemplate {
    private List<Button> buttonList;
    private List<ButtonV2> buttonV2List;
    private Text content;
    private Icon contentIcon;
    private long current_timestamp;
    private Integer duration;
    private Icon icon;
    private Integer is_auto;
    private boolean is_time_bottom;
    private TimeStyle timeStyle;
    private Icon titleIcon;
    private int type;
    private String unit;

    @Deprecated(message = "请使用buttonV2List")
    public static /* synthetic */ void getButtonList$annotations() {
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

    public final long getCurrent_timestamp() {
        return this.current_timestamp;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final TimeStyle getTimeStyle() {
        return this.timeStyle;
    }

    public final Icon getTitleIcon() {
        return this.titleIcon;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUnit() {
        return this.unit;
    }

    public final Integer is_auto() {
        return this.is_auto;
    }

    public final boolean is_time_bottom() {
        return this.is_time_bottom;
    }

    public final IslandWidget create(Boolean r110) {
        return new IslandWidget("com.obric.island_applet:common_expand_timer_template", this, r110, null, null, null, null, null, null, 504, null);
    }

    public final void setButtonList(List<Button> r100) {
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

    public final void setCurrent_timestamp(long r100) {
        this.current_timestamp = r100;
    }

    public final void setDuration(Integer r100) {
        this.duration = r100;
    }

    public final void setIcon(Icon r100) {
        this.icon = r100;
    }

    public final void setTimeStyle(TimeStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.timeStyle = r100;
    }

    public final void setTitleIcon(Icon r100) {
        this.titleIcon = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }

    public final void setUnit(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.unit = r100;
    }

    public final void set_auto(Integer r100) {
        this.is_auto = r100;
    }

    public final void set_time_bottom(boolean r100) {
        this.is_time_bottom = r100;
    }

    public static /* synthetic */ IslandWidget create$default(TimerExpandTemplate r100, Boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = Boolean.FALSE;
    L6:
        return r100.create(r101);
    }

    public TimerExpandTemplate(Icon r100, Icon r101, Text r102, List<Button> r103, TimeStyle r104, long r105, Integer r106, Integer r110, int r111, String r112, List<ButtonV2> r113, Icon r114, boolean r115) {
        Intrinsics.checkNotNullParameter(r102, "content");
        Intrinsics.checkNotNullParameter(r104, "timeStyle");
        Intrinsics.checkNotNullParameter(r112, Scraps.INNER_UNIT);
        Intrinsics.checkNotNullParameter(r113, "buttonV2List");
        this.icon = r100;
        this.titleIcon = r101;
        this.content = r102;
        this.buttonList = r103;
        this.timeStyle = r104;
        this.current_timestamp = r105;
        this.duration = r106;
        this.is_auto = r110;
        this.type = r111;
        this.unit = r112;
        this.buttonV2List = r113;
        this.contentIcon = r114;
        this.is_time_bottom = r115;
    }

    public /* synthetic */ TimerExpandTemplate(Icon r110, Icon r210, Text r211, List r212, TimeStyle r213, long r214, Integer r215, Integer r216, int r217, String r218, List r310, Icon r311, boolean r312, int r313, DefaultConstructorMarker r314) {
        if ((r313 & 1) == 0) goto L5;
        Icon r100 = null;
    L7:
        if ((r313 & 2) == 0) goto L9;
        Icon r101 = null;
    L11:
        if ((r313 & 8) == 0) goto L13;
        List r102 = null;
    L15:
        if ((r313 & 64) == 0) goto L17;
        Integer r111 = null;
    L19:
        if ((r313 & 128) == 0) goto L21;
        Integer r112 = null;
    L23:
        if ((r313 & 1024) == 0) goto L25;
        List r113 = CollectionsKt.emptyList();
    L27:
        if ((r313 & 2048) == 0) goto L29;
        Icon r114 = null;
    L31:
        if ((r313 & 4096) == 0) goto L33;
        boolean r115 = false;
    L34:
        this(r100, r101, r211, r102, r213, r214, r111, r112, r217, r218, r113, r114, r115);
        return;
    L33:
        r115 = r312;
        goto L34
    L29:
        r114 = r311;
        goto L31
    L25:
        r113 = r310;
        goto L27
    L21:
        r112 = r216;
        goto L23
    L17:
        r111 = r215;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
