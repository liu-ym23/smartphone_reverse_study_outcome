package com.bytedance.applet.aibridge.calendar;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b+\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015Jx\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u00020\f2\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u000208HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017¨\u0006:"}, d2 = {"Lcom/bytedance/applet/aibridge/calendar/RemindInfo;", "", "id", "", "dtStart", "", "duration", "rRule", "title", "group", "location", "enableRemind", "", "remindDate", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getDtStart", "()Ljava/lang/Long;", "setDtStart", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDuration", "setDuration", "getRRule", "setRRule", "getTitle", "setTitle", "getGroup", "setGroup", "getLocation", "setLocation", "getEnableRemind", "()Ljava/lang/Boolean;", "setEnableRemind", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getRemindDate", "setRemindDate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;)Lcom/bytedance/applet/aibridge/calendar/RemindInfo;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RemindInfo {
    private Long dtStart;
    private Long duration;
    private Boolean enableRemind;
    private String group;
    private String id;
    private String location;
    private String rRule;
    private Long remindDate;
    private String title;

    public RemindInfo() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ RemindInfo copy$default(RemindInfo r10, String r11, Long r12, Long r13, String r14, String r15, String r16, String r17, Boolean r18, Long r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r2 = r10.id;
    L7:
        if ((r20 & 2) == 0) goto L9;
        Long r3 = r10.dtStart;
    L11:
        if ((r20 & 4) == 0) goto L13;
        Long r4 = r10.duration;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = r10.rRule;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r6 = r10.title;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r7 = r10.group;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r8 = r10.location;
    L31:
        if ((r20 & 128) == 0) goto L33;
        Boolean r9 = r10.enableRemind;
    L35:
        if ((r20 & 256) == 0) goto L37;
        Long r1 = r10.remindDate;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final String component1() {
        return this.id;
    }

    public final Long component2() {
        return this.dtStart;
    }

    public final Long component3() {
        return this.duration;
    }

    public final String component4() {
        return this.rRule;
    }

    public final String component5() {
        return this.title;
    }

    public final String component6() {
        return this.group;
    }

    public final String component7() {
        return this.location;
    }

    public final Boolean component8() {
        return this.enableRemind;
    }

    public final Long component9() {
        return this.remindDate;
    }

    public final RemindInfo copy(String r12, Long r13, Long r14, String r15, String r16, String r17, String r18, Boolean r19, Long r20) {
        Intrinsics.checkNotNullParameter(r12, "id");
        return new RemindInfo(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RemindInfo) == true) goto L8;
        return false;
    L8:
        RemindInfo r6 = (RemindInfo) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.dtStart, r6.dtStart) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.duration, r6.duration) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.rRule, r6.rRule) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.group, r6.group) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.location, r6.location) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.enableRemind, r6.enableRemind) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.remindDate, r6.remindDate) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = this.id.hashCode() * 31;
        Long r1 = this.dtStart;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Long r5 = this.duration;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.rRule;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.title;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.group;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.location;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Boolean r20 = this.enableRemind;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        Long r23 = this.remindDate;
        if (r23 == null) goto L35;
        r2 = r23.hashCode();
    L35:
        return r22 + r2;
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "RemindInfo(id=" + this.id + ", dtStart=" + this.dtStart + ", duration=" + this.duration + ", rRule=" + this.rRule + ", title=" + this.title + ", group=" + this.group + ", location=" + this.location + ", enableRemind=" + this.enableRemind + ", remindDate=" + this.remindDate + ')';
    }

    public final Long getDtStart() {
        return this.dtStart;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final Boolean getEnableRemind() {
        return this.enableRemind;
    }

    public final String getGroup() {
        return this.group;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getRRule() {
        return this.rRule;
    }

    public final Long getRemindDate() {
        return this.remindDate;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setDtStart(Long r1) {
        this.dtStart = r1;
    }

    public final void setDuration(Long r1) {
        this.duration = r1;
    }

    public final void setEnableRemind(Boolean r1) {
        this.enableRemind = r1;
    }

    public final void setGroup(String r1) {
        this.group = r1;
    }

    public final void setId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.id = r2;
    }

    public final void setLocation(String r1) {
        this.location = r1;
    }

    public final void setRRule(String r1) {
        this.rRule = r1;
    }

    public final void setRemindDate(Long r1) {
        this.remindDate = r1;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public RemindInfo(String r2, Long r3, Long r4, String r5, String r6, String r7, String r8, Boolean r9, Long r10) {
        Intrinsics.checkNotNullParameter(r2, "id");
        this.id = r2;
        this.dtStart = r3;
        this.duration = r4;
        this.rRule = r5;
        this.title = r6;
        this.group = r7;
        this.location = r8;
        this.enableRemind = r9;
        this.remindDate = r10;
    }

    public /* synthetic */ RemindInfo(String r11, Long r12, Long r13, String r14, String r15, String r16, String r17, Boolean r18, Long r19, int r20, DefaultConstructorMarker r21) {
        if ((r20 & 1) == 0) goto L5;
        String r1 = "";
    L6:
        Long r3 = null;
        if ((r20 & 2) == 0) goto L9;
        Long r2 = null;
    L11:
        if ((r20 & 4) == 0) goto L13;
        Long r4 = null;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r20 & 128) == 0) goto L33;
        Boolean r9 = null;
    L35:
        if ((r20 & 256) != 0) goto L38;
        r3 = r19;
    L38:
        this(r1, r2, r4, r5, r6, r7, r8, r9, r3);
        return;
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r2 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L6
    }
}
