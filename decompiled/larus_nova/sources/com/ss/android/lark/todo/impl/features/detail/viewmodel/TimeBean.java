package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\bHÖ\u0001J\t\u0010#\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010¨\u0006$"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/TimeBean;", "Lcom/larksuite/framework/section/IActionData;", "Ljava/io/Serializable;", "dueTimeMillis", "", "isAllDay", "", "reminderRelativeTime", "", "rRule", "", "rRuleText", "startTimeMillis", "<init>", "(JZILjava/lang/String;Ljava/lang/String;J)V", "getDueTimeMillis", "()J", "()Z", "getReminderRelativeTime", "()I", "getRRule", "()Ljava/lang/String;", "getRRuleText", "getStartTimeMillis", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toString", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimeBean implements com.larksuite.framework.section.b, Serializable {
    private final long dueTimeMillis;
    private final boolean isAllDay;
    private final String rRule;
    private final String rRuleText;
    private final int reminderRelativeTime;
    private final long startTimeMillis;

    public static /* synthetic */ TimeBean copy$default(TimeBean r100, long r110, boolean r111, int r112, String r113, String r114, long r115, int r116, Object r117) {
        if ((r116 & 1) == 0) goto L5;
        long r101 = r100.dueTimeMillis;
    L7:
        if ((r116 & 2) == 0) goto L9;
        boolean r102 = r100.isAllDay;
    L11:
        if ((r116 & 4) == 0) goto L13;
        int r103 = r100.reminderRelativeTime;
    L15:
        if ((r116 & 8) == 0) goto L17;
        String r104 = r100.rRule;
    L19:
        if ((r116 & 16) == 0) goto L21;
        String r105 = r100.rRuleText;
    L23:
        if ((r116 & 32) == 0) goto L25;
        long r106 = r100.startTimeMillis;
    L27:
        return r100.copy(r101, r102, r103, r104, r105, r106);
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
        return this.dueTimeMillis;
    }

    public final boolean component2() {
        return this.isAllDay;
    }

    public final int component3() {
        return this.reminderRelativeTime;
    }

    public final String component4() {
        return this.rRule;
    }

    public final String component5() {
        return this.rRuleText;
    }

    public final long component6() {
        return this.startTimeMillis;
    }

    public final TimeBean copy(long r110, boolean r111, int r112, String r113, String r114, long r115) {
        Intrinsics.checkNotNullParameter(r113, "rRule");
        Intrinsics.checkNotNullParameter(r114, "rRuleText");
        return new TimeBean(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TimeBean) == true) goto L8;
        return false;
    L8:
        TimeBean r101 = (TimeBean) r100;
        if (this.dueTimeMillis == r101.dueTimeMillis) goto L12;
        return false;
    L12:
        if (this.isAllDay == r101.isAllDay) goto L15;
        return false;
    L15:
        if (this.reminderRelativeTime == r101.reminderRelativeTime) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.rRule, r101.rRule) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.rRuleText, r101.rRuleText) == true) goto L24;
        return false;
    L24:
        if (this.startTimeMillis == r101.startTimeMillis) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        long r100 = this.dueTimeMillis;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        if (this.isAllDay == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((((((r101 + r102) * 31) + this.reminderRelativeTime) * 31) + this.rRule.hashCode()) * 31) + this.rRuleText.hashCode()) * 31;
        long r104 = this.startTimeMillis;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "TimeBean(dueTimeMillis=" + this.dueTimeMillis + ", isAllDay=" + this.isAllDay + ", reminderRelativeTime=" + this.reminderRelativeTime + ", rRule=" + this.rRule + ", rRuleText=" + this.rRuleText + ", startTimeMillis=" + this.startTimeMillis + ')';
    }

    public final long getDueTimeMillis() {
        return this.dueTimeMillis;
    }

    public final String getRRule() {
        return this.rRule;
    }

    public final String getRRuleText() {
        return this.rRuleText;
    }

    public final int getReminderRelativeTime() {
        return this.reminderRelativeTime;
    }

    public final long getStartTimeMillis() {
        return this.startTimeMillis;
    }

    public final boolean isAllDay() {
        return this.isAllDay;
    }

    public TimeBean(long r100, boolean r101, int r102, String r103, String r104, long r105) {
        Intrinsics.checkNotNullParameter(r103, "rRule");
        Intrinsics.checkNotNullParameter(r104, "rRuleText");
        this.dueTimeMillis = r100;
        this.isAllDay = r101;
        this.reminderRelativeTime = r102;
        this.rRule = r103;
        this.rRuleText = r104;
        this.startTimeMillis = r105;
    }
}
