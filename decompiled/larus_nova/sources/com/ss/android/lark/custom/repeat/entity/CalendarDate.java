package com.ss.android.lark.custom.repeat.entity;

import com.ss.android.lark.custom.repeat.CustomRepeatParams$DayOfWeek;
import com.ss.ttm.player.MediaPlayer;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes35.dex */
public class CalendarDate implements Serializable {
    private static final long serialVersionUID = 1;
    private GregorianCalendar mGregorianCalendar;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f420299a = null;

        static {
            int[] r100 = new int[CustomRepeatParams$DayOfWeek.values().length];
            f420299a = r100;
            r100[CustomRepeatParams$DayOfWeek.MONDAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f420299a[CustomRepeatParams$DayOfWeek.SATURDAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public Date getDate() {
        return this.mGregorianCalendar.getTime();
    }

    public int getHour() {
        return this.mGregorianCalendar.get(11);
    }

    public int getMinute() {
        return this.mGregorianCalendar.get(12);
    }

    public int getMonth() {
        return this.mGregorianCalendar.get(2) + 1;
    }

    public int getMonthDay() {
        return this.mGregorianCalendar.get(5);
    }

    public int getSecond() {
        return this.mGregorianCalendar.get(13);
    }

    public Date getTime() {
        return this.mGregorianCalendar.getTime();
    }

    public long getTimeInMilliSeconds() {
        return this.mGregorianCalendar.getTimeInMillis();
    }

    public long getTimeInSeconds() {
        return this.mGregorianCalendar.getTimeInMillis() / 1000;
    }

    public TimeZone getTimeZone() {
        GregorianCalendar r100 = this.mGregorianCalendar;
        if (r100 == null) goto L7;
        return r100.getTimeZone();
    L7:
        return TimeZone.getDefault();
    }

    public int getWeekDay() {
        return this.mGregorianCalendar.get(7);
    }

    public int getYear() {
        return this.mGregorianCalendar.get(1);
    }

    public CalendarDate moveToDayStart() {
        CalendarDate r100 = new CalendarDate(this);
        r100.setHour(0);
        r100.setMinute(0);
        r100.setSecond(0);
        return r100;
    }

    public String toString() {
        return "Year：" + getYear() + " Month:" + getMonth() + " Day:" + getMonthDay() + " Hour:" + getHour() + " Minute:" + getMinute() + " Second:" + getSecond() + " JulianDay:" + getJulianDay();
    }

    public CalendarDate() {
        this.mGregorianCalendar = new GregorianCalendar();
    }

    public int getDayMinutes() {
        return (getHour() * 60) + getMinute();
    }

    public int getJulianDay() {
        int r100 = getYear();
        int r101 = getMonth();
        int r102 = (r101 - 14) / 12;
        return (((((((getYear() + 4800) + r102) * 1461) / 4) + ((((r101 - 2) - (r102 * 12)) * MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DECODE_TIME) / 12)) - (((((r100 + 4900) + r102) / 100) * 3) / 4)) + getMonthDay()) - 32075;
    }

    public CalendarDate(CalendarDate r100) {
        if (this == r100) goto L6;
        this.mGregorianCalendar = new GregorianCalendar();
        setYear(r100.getYear());
        setMonth(r100.getMonth());
        setMonthDay(r100.getMonthDay());
        setHour(r100.getHour());
        setMinute(r100.getMinute());
        setSecond(r100.getSecond());
        return;
    }

    public CalendarDate addDay(int r100) {
        CalendarDate r101 = new CalendarDate(this);
        r101.add(5, r100);
        return r101;
    }

    public boolean before(CalendarDate r100) {
        return this.mGregorianCalendar.before(r100.mGregorianCalendar);
    }

    public int dayDiff(CalendarDate r100) {
        return getJulianDay() - r100.getJulianDay();
    }

    public int getWeeklyDayIndex(CustomRepeatParams$DayOfWeek r100) {
        int r101 = a.f420299a[r100.ordinal()];
        if (r101 == 1) goto L11;
        if (r101 == 2) goto L9;
        return getWeekDay() - 1;
    L9:
        return ((getWeekDay() - 1) + 1) % 7;
    L11:
        return ((getWeekDay() - 1) + 6) % 7;
    }

    public boolean sameDay(CalendarDate r100) {
        if (getJulianDay() != r100.getJulianDay()) goto L5;
        return true;
    L5:
        return false;
    }

    public void setDayMinutes(int r100) {
        setHour(r100 / 60);
        setMinute(r100 % 60);
    }

    public void setHour(int r100) {
        this.mGregorianCalendar.set(11, r100);
    }

    public CalendarDate setJulianDay(int r110) {
        long r100 = r110 + 68569;
        long r101 = (r100 * 4) / 146097;
        long r102 = r100 - (((146097 * r101) + 3) / 4);
        long r103 = ((r102 + 1) * 4000) / 1461001;
        long r104 = (r102 - ((1461 * r103) / 4)) + 31;
        long r111 = (r104 * 80) / 2447;
        int r112 = (int) (r104 - ((2447 * r111) / 80));
        long r105 = r111 / 11;
        setYear((int) ((((r101 - 49) * 100) + r103) + r105));
        setMonth(((int) (((r111 + 2) - (12 * r105)) - 1)) + 1);
        setMonthDay(r112);
        setHour(0);
        setMinute(0);
        setSecond(0);
        return this;
    }

    public void setMinute(int r100) {
        this.mGregorianCalendar.set(12, r100);
    }

    public void setMonth(int r100) {
        this.mGregorianCalendar.set(2, r100 - 1);
    }

    public void setMonthDay(int r100) {
        this.mGregorianCalendar.set(5, r100);
    }

    public void setSecond(int r100) {
        this.mGregorianCalendar.set(13, r100);
    }

    public CalendarDate setTimeInMillis(long r100) {
        this.mGregorianCalendar.setTimeInMillis(r100);
        return this;
    }

    public CalendarDate setTimeInSeconds(long r100) {
        this.mGregorianCalendar.setTimeInMillis(r100 * 1000);
        return this;
    }

    public void setTimeZone(TimeZone r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mGregorianCalendar.setTimeZone(r100);
    }

    public void setYear(int r100) {
        this.mGregorianCalendar.set(1, r100);
    }

    public CalendarDate(Date r100) {
        GregorianCalendar r101 = new GregorianCalendar();
        this.mGregorianCalendar = r101;
        r101.setTime(r100);
    }

    public CalendarDate(TimeZone r100) {
        this.mGregorianCalendar = new GregorianCalendar(r100);
    }

    public CalendarDate(CalendarDate r100, TimeZone r101) {
        if (this == r100) goto L6;
        this.mGregorianCalendar = new GregorianCalendar(r101);
        setYear(r100.getYear());
        setMonth(r100.getMonth());
        setMonthDay(r100.getMonthDay());
        setHour(r100.getHour());
        setMinute(r100.getMinute());
        setSecond(r100.getSecond());
        return;
    }

    public void add(int r100, int r101) {
        this.mGregorianCalendar.add(r100, r101);
    }

    public CalendarDate(Date r100, TimeZone r101) {
        GregorianCalendar r102 = new GregorianCalendar(r101);
        this.mGregorianCalendar = r102;
        r102.setTime(r100);
    }

    public CalendarDate(int r100, int r101, int r102, int r103, int r104, int r105) {
        this.mGregorianCalendar = new GregorianCalendar();
        setYear(r100);
        setMonth(r101);
        setMonthDay(r102);
        setHour(r103);
        setMinute(r104);
        setSecond(r105);
    }
}
