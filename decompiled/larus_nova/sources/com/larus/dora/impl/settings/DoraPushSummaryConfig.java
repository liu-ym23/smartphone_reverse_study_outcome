package com.larus.dora.impl.settings;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/dora/impl/settings/DoraPushSummaryConfig;", "", "notificationSummary", "", "proactiveMessage", "<init>", "(ZZ)V", "getNotificationSummary", "()Z", "getProactiveMessage", "toString", "", "component1", "component2", "copy", "equals", "other", "hashCode", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraPushSummaryConfig {

    @SerializedName("notification_summary")
    private final boolean notificationSummary;

    @SerializedName("proactive_message")
    private final boolean proactiveMessage;

    public DoraPushSummaryConfig() {
        boolean r100 = false;
        this(r100, r100, 3, null);
    }

    public static /* synthetic */ DoraPushSummaryConfig copy$default(DoraPushSummaryConfig r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.notificationSummary;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.proactiveMessage;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.notificationSummary;
    }

    public final boolean component2() {
        return this.proactiveMessage;
    }

    public final DoraPushSummaryConfig copy(boolean r100, boolean r101) {
        return new DoraPushSummaryConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DoraPushSummaryConfig) == true) goto L8;
        return false;
    L8:
        DoraPushSummaryConfig r101 = (DoraPushSummaryConfig) r100;
        if (this.notificationSummary == r101.notificationSummary) goto L12;
        return false;
    L12:
        if (this.proactiveMessage == r101.proactiveMessage) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.notificationSummary == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.proactiveMessage == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "DoraPushSummaryConfig(notificationSummary=" + this.notificationSummary + ", proactiveMessage=" + this.proactiveMessage + ')';
    }

    public final boolean getNotificationSummary() {
        return this.notificationSummary;
    }

    public final boolean getProactiveMessage() {
        return this.proactiveMessage;
    }

    public DoraPushSummaryConfig(boolean r100, boolean r101) {
        this.notificationSummary = r100;
        this.proactiveMessage = r101;
    }

    public /* synthetic */ DoraPushSummaryConfig(boolean r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
