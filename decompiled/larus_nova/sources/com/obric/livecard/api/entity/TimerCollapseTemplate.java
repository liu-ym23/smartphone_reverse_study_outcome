package com.obric.livecard.api.entity;

import com.bytedance.crash.dumper.Scraps;
import com.ss.android.downloadlib.constants.EventConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\tHÆ\u0003J\t\u0010.\u001a\u00020\u000bHÆ\u0003J\t\u0010/\u001a\u00020\rHÆ\u0003JX\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u00101J\u0017\u00102\u001a\u0002032\n\b\u0002\u00104\u001a\u0004\u0018\u000105¢\u0006\u0002\u00106J\u0013\u00107\u001a\u0002052\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\u0005HÖ\u0001J\t\u0010:\u001a\u00020\tHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0006\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006;"}, d2 = {"Lcom/obric/livecard/api/entity/TimerCollapseTemplate;", "", EventConstants.ExtraJson.EXTRA_CURRENT_TIMESTAMP, "", "duration", "", "is_auto", "type", Scraps.INNER_UNIT, "", "startIcon", "Lcom/obric/livecard/api/entity/Icon;", "timeStyle", "Lcom/obric/livecard/api/entity/TimeStyle;", "(JLjava/lang/Integer;Ljava/lang/Integer;ILjava/lang/String;Lcom/obric/livecard/api/entity/Icon;Lcom/obric/livecard/api/entity/TimeStyle;)V", "getCurrent_timestamp", "()J", "setCurrent_timestamp", "(J)V", "getDuration", "()Ljava/lang/Integer;", "setDuration", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "set_auto", "getStartIcon", "()Lcom/obric/livecard/api/entity/Icon;", "setStartIcon", "(Lcom/obric/livecard/api/entity/Icon;)V", "getTimeStyle", "()Lcom/obric/livecard/api/entity/TimeStyle;", "setTimeStyle", "(Lcom/obric/livecard/api/entity/TimeStyle;)V", "getType", "()I", "setType", "(I)V", "getUnit", "()Ljava/lang/String;", "setUnit", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(JLjava/lang/Integer;Ljava/lang/Integer;ILjava/lang/String;Lcom/obric/livecard/api/entity/Icon;Lcom/obric/livecard/api/entity/TimeStyle;)Lcom/obric/livecard/api/entity/TimerCollapseTemplate;", "create", "Lcom/obric/livecard/api/entity/IslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/livecard/api/entity/IslandWidget;", "equals", "other", "hashCode", "toString", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TimerCollapseTemplate {
    private long current_timestamp;
    private Integer duration;
    private Integer is_auto;
    private Icon startIcon;
    private TimeStyle timeStyle;
    private int type;
    private String unit;

    public static /* synthetic */ TimerCollapseTemplate copy$default(TimerCollapseTemplate r100, long r110, Integer r111, Integer r112, int r113, String r114, Icon r115, TimeStyle r116, int r117, Object r118) {
        if ((r117 & 1) == 0) goto L5;
        long r101 = r100.current_timestamp;
    L7:
        if ((r117 & 2) == 0) goto L9;
        Integer r102 = r100.duration;
    L11:
        if ((r117 & 4) == 0) goto L13;
        Integer r103 = r100.is_auto;
    L15:
        if ((r117 & 8) == 0) goto L17;
        int r104 = r100.type;
    L19:
        if ((r117 & 16) == 0) goto L21;
        String r105 = r100.unit;
    L23:
        if ((r117 & 32) == 0) goto L25;
        Icon r106 = r100.startIcon;
    L27:
        if ((r117 & 64) == 0) goto L29;
        TimeStyle r107 = r100.timeStyle;
    L31:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107);
    L29:
        r107 = r116;
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
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final long component1() {
        return this.current_timestamp;
    }

    public final Integer component2() {
        return this.duration;
    }

    public final Integer component3() {
        return this.is_auto;
    }

    public final int component4() {
        return this.type;
    }

    public final String component5() {
        return this.unit;
    }

    public final Icon component6() {
        return this.startIcon;
    }

    public final TimeStyle component7() {
        return this.timeStyle;
    }

    public final TimerCollapseTemplate copy(long r110, Integer r111, Integer r112, int r113, String r114, Icon r115, TimeStyle r116) {
        Intrinsics.checkNotNullParameter(r114, Scraps.INNER_UNIT);
        Intrinsics.checkNotNullParameter(r115, "startIcon");
        Intrinsics.checkNotNullParameter(r116, "timeStyle");
        return new TimerCollapseTemplate(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TimerCollapseTemplate) == true) goto L8;
        return false;
    L8:
        TimerCollapseTemplate r101 = (TimerCollapseTemplate) r100;
        if (this.current_timestamp == r101.current_timestamp) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.is_auto, r101.is_auto) == true) goto L18;
        return false;
    L18:
        if (this.type == r101.type) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.unit, r101.unit) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.startIcon, r101.startIcon) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.timeStyle, r101.timeStyle) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        long r100 = this.current_timestamp;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        Integer r102 = this.duration;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        Integer r106 = this.is_auto;
        if (r106 == null) goto L11;
        r103 = r106.hashCode();
    L11:
        return ((((((((r105 + r103) * 31) + this.type) * 31) + this.unit.hashCode()) * 31) + this.startIcon.hashCode()) * 31) + this.timeStyle.hashCode();
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public String toString() {
        return "TimerCollapseTemplate(current_timestamp=" + this.current_timestamp + ", duration=" + this.duration + ", is_auto=" + this.is_auto + ", type=" + this.type + ", unit=" + this.unit + ", startIcon=" + this.startIcon + ", timeStyle=" + this.timeStyle + ')';
    }

    public final long getCurrent_timestamp() {
        return this.current_timestamp;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final Icon getStartIcon() {
        return this.startIcon;
    }

    public final TimeStyle getTimeStyle() {
        return this.timeStyle;
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

    public final IslandWidget create(Boolean r110) {
        return new IslandWidget("com.obric.island_applet:common_collapse_timer_template", this, r110, null, null, null, null, null, null, 504, null);
    }

    public final void setCurrent_timestamp(long r100) {
        this.current_timestamp = r100;
    }

    public final void setDuration(Integer r100) {
        this.duration = r100;
    }

    public final void setStartIcon(Icon r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.startIcon = r100;
    }

    public final void setTimeStyle(TimeStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.timeStyle = r100;
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

    public static /* synthetic */ IslandWidget create$default(TimerCollapseTemplate r100, Boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = Boolean.FALSE;
    L6:
        return r100.create(r101);
    }

    public TimerCollapseTemplate(long r100, Integer r101, Integer r102, int r103, String r104, Icon r105, TimeStyle r106) {
        Intrinsics.checkNotNullParameter(r104, Scraps.INNER_UNIT);
        Intrinsics.checkNotNullParameter(r105, "startIcon");
        Intrinsics.checkNotNullParameter(r106, "timeStyle");
        this.current_timestamp = r100;
        this.duration = r101;
        this.is_auto = r102;
        this.type = r103;
        this.unit = r104;
        this.startIcon = r105;
        this.timeStyle = r106;
    }

    public /* synthetic */ TimerCollapseTemplate(long r110, Integer r111, Integer r112, int r113, String r114, Icon r115, TimeStyle r116, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 2) == 0) goto L5;
        Integer r100 = null;
    L7:
        if ((r210 & 4) == 0) goto L9;
        Integer r101 = null;
    L10:
        this(r110, r100, r101, r113, r114, r115, r116);
        return;
    L9:
        r101 = r112;
        goto L10
    L5:
        r100 = r111;
        goto L7
    }
}
