package com.ss.android.lark.usersetting.service.timeformat;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public class TimeFormatSetting implements Serializable {
    private TimeFormat mTimeFormat;

    public static final enum TimeFormat extends Enum<TimeFormat> {
        public static final TimeFormat TWELVE_HOUR = null;
        public static final TimeFormat TWENTY_FOUR_HOUR = null;
        public static final TimeFormat UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TimeFormat[] f444647a = null;
        private int value;

        static {
            TimeFormat r100 = new TimeFormat("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            TimeFormat r101 = new TimeFormat("TWELVE_HOUR", 1, 1);
            TWELVE_HOUR = r101;
            TimeFormat r102 = new TimeFormat("TWENTY_FOUR_HOUR", 2, 2);
            TWENTY_FOUR_HOUR = r102;
            f444647a = new TimeFormat[]{r100, r101, r102};
        }

        public static TimeFormat[] values() {
            return (TimeFormat[]) f444647a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static TimeFormat forNumber(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return UNKNOWN;
        L9:
            return TWENTY_FOUR_HOUR;
        L11:
            return TWELVE_HOUR;
        }

        public static TimeFormat valueOf(String r100) {
            return (TimeFormat) r27.a.a(TimeFormat.class, r100);
        }

        public static TimeFormat valueOf(int r100) {
            return forNumber(r100);
        }

        public TimeFormat(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mTimeFormat});
    }

    public TimeFormatSetting() {
        this.mTimeFormat = TimeFormat.UNKNOWN;
    }

    public TimeFormat getTimeFormat() {
        return this.mTimeFormat;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L15:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L15;
        if (this.mTimeFormat == ((TimeFormatSetting) r100).mTimeFormat) goto L16;
        return false;
    L16:
        return true;
    }

    public void setTimeFormat(TimeFormat r100) {
        this.mTimeFormat = r100;
    }
}
