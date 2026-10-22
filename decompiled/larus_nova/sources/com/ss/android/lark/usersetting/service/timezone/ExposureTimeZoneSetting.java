package com.ss.android.lark.usersetting.service.timezone;

import com.bytedance.lark.pb.basic.v1.ExternalDisplayTimezoneSettingType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/usersetting/service/timezone/ExposureTimeZoneSetting;", "Ljava/io/Serializable;", "selectSettingType", "Lcom/bytedance/lark/pb/basic/v1/ExternalDisplayTimezoneSettingType;", "timeZoneId", "", "timeZoneOffset", "", "<init>", "(Lcom/bytedance/lark/pb/basic/v1/ExternalDisplayTimezoneSettingType;Ljava/lang/String;I)V", "getSelectSettingType", "()Lcom/bytedance/lark/pb/basic/v1/ExternalDisplayTimezoneSettingType;", "getTimeZoneId", "()Ljava/lang/String;", "getTimeZoneOffset", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "usersetting_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExposureTimeZoneSetting implements Serializable {
    private final ExternalDisplayTimezoneSettingType selectSettingType;
    private final String timeZoneId;
    private final int timeZoneOffset;

    public ExposureTimeZoneSetting() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ ExposureTimeZoneSetting copy$default(ExposureTimeZoneSetting r100, ExternalDisplayTimezoneSettingType r101, String r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.selectSettingType;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.timeZoneId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.timeZoneOffset;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final ExternalDisplayTimezoneSettingType component1() {
        return this.selectSettingType;
    }

    public final String component2() {
        return this.timeZoneId;
    }

    public final int component3() {
        return this.timeZoneOffset;
    }

    public final ExposureTimeZoneSetting copy(ExternalDisplayTimezoneSettingType r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "selectSettingType");
        Intrinsics.checkNotNullParameter(r101, "timeZoneId");
        return new ExposureTimeZoneSetting(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ExposureTimeZoneSetting) == true) goto L8;
        return false;
    L8:
        ExposureTimeZoneSetting r101 = (ExposureTimeZoneSetting) r100;
        if (this.selectSettingType == r101.selectSettingType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.timeZoneId, r101.timeZoneId) == true) goto L15;
        return false;
    L15:
        if (this.timeZoneOffset == r101.timeZoneOffset) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.selectSettingType.hashCode() * 31) + this.timeZoneId.hashCode()) * 31) + this.timeZoneOffset;
    }

    public String toString() {
        return "ExposureTimeZoneSetting(selectSettingType=" + this.selectSettingType + ", timeZoneId=" + this.timeZoneId + ", timeZoneOffset=" + this.timeZoneOffset + ')';
    }

    public final ExternalDisplayTimezoneSettingType getSelectSettingType() {
        return this.selectSettingType;
    }

    public final String getTimeZoneId() {
        return this.timeZoneId;
    }

    public final int getTimeZoneOffset() {
        return this.timeZoneOffset;
    }

    public ExposureTimeZoneSetting(ExternalDisplayTimezoneSettingType r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "selectSettingType");
        Intrinsics.checkNotNullParameter(r101, "timeZoneId");
        this.selectSettingType = r100;
        this.timeZoneId = r101;
        this.timeZoneOffset = r102;
    }

    public /* synthetic */ ExposureTimeZoneSetting(ExternalDisplayTimezoneSettingType r100, String r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = ExternalDisplayTimezoneSettingType.UNKNOWN;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 8;
    L11:
        this(r100, r101, r102);
    }
}
