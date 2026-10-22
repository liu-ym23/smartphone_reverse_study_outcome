package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0001#B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J>\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\tHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/larus/platform/model/audio/RealtimeCallSceneConfig;", "Ljava/io/Serializable;", "autoCloseDurationSecond", "", "autoOpenCountTimes", "", "useSpringSceneIcon", "", "springSceneTitle", "", "<init>", "(Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;)V", "getAutoCloseDurationSecond", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getAutoOpenCountTimes", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUseSpringSceneIcon", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSpringSceneTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/larus/platform/model/audio/RealtimeCallSceneConfig;", "equals", "other", "", "hashCode", "", "toString", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallSceneConfig implements Serializable {
    public static final a Companion = null;
    private static final RealtimeCallSceneConfig DEFAULT = null;

    @SerializedName("scene_panel_display_duration")
    private final Double autoCloseDurationSecond;

    @SerializedName("auto_show_scene_panel_count")
    private final Long autoOpenCountTimes;

    @SerializedName("use_spring_scene_title")
    private final String springSceneTitle;

    @SerializedName("use_spring_scene_icon")
    private final Boolean useSpringSceneIcon;

    public static final class a {
        public a() {
        }
    }

    public RealtimeCallSceneConfig() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ RealtimeCallSceneConfig copy$default(RealtimeCallSceneConfig r100, Double r101, Long r102, Boolean r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.autoCloseDurationSecond;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.autoOpenCountTimes;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.useSpringSceneIcon;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.springSceneTitle;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Double component1() {
        return this.autoCloseDurationSecond;
    }

    public final Long component2() {
        return this.autoOpenCountTimes;
    }

    public final Boolean component3() {
        return this.useSpringSceneIcon;
    }

    public final String component4() {
        return this.springSceneTitle;
    }

    public final RealtimeCallSceneConfig copy(Double r100, Long r101, Boolean r102, String r103) {
        return new RealtimeCallSceneConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RealtimeCallSceneConfig) == true) goto L8;
        return false;
    L8:
        RealtimeCallSceneConfig r101 = (RealtimeCallSceneConfig) r100;
        if (Intrinsics.areEqual(this.autoCloseDurationSecond, r101.autoCloseDurationSecond) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.autoOpenCountTimes, r101.autoOpenCountTimes) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.useSpringSceneIcon, r101.useSpringSceneIcon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.springSceneTitle, r101.springSceneTitle) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Double r100 = this.autoCloseDurationSecond;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.autoOpenCountTimes;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.useSpringSceneIcon;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.springSceneTitle;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "RealtimeCallSceneConfig(autoCloseDurationSecond=" + this.autoCloseDurationSecond + ", autoOpenCountTimes=" + this.autoOpenCountTimes + ", useSpringSceneIcon=" + this.useSpringSceneIcon + ", springSceneTitle=" + this.springSceneTitle + ')';
    }

    static {
        Companion = new a();
        DEFAULT = new RealtimeCallSceneConfig(null, null, null, null, 15, null);
    }

    public static final /* synthetic */ RealtimeCallSceneConfig access$getDEFAULT$cp() {
        return DEFAULT;
    }

    public final Double getAutoCloseDurationSecond() {
        return this.autoCloseDurationSecond;
    }

    public final Long getAutoOpenCountTimes() {
        return this.autoOpenCountTimes;
    }

    public final String getSpringSceneTitle() {
        return this.springSceneTitle;
    }

    public final Boolean getUseSpringSceneIcon() {
        return this.useSpringSceneIcon;
    }

    public RealtimeCallSceneConfig(Double r100, Long r101, Boolean r102, String r103) {
        this.autoCloseDurationSecond = r100;
        this.autoOpenCountTimes = r101;
        this.useSpringSceneIcon = r102;
        this.springSceneTitle = r103;
    }

    public /* synthetic */ RealtimeCallSceneConfig(Double r100, Long r101, Boolean r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
