package com.ss.android.lark.widget.timepicker.monthview.data;

import com.larksuite.framework.utils.e;
import com.ss.ttm.player.MediaPlayer;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes38.dex */
public class CalendarDate implements Serializable {
    private static final long serialVersionUID = 1;
    private GregorianCalendar mGregorianCalendar;

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

    public int getWeekDay() {
        return this.mGregorianCalendar.get(7);
    }

    public int getYear() {
        return this.mGregorianCalendar.get(1);
    }

    public int getYearDay() {
        return this.mGregorianCalendar.get(6);
    }

    public int getYearWeek() {
        this.mGregorianCalendar.setFirstDayOfWeek(1);
        return this.mGregorianCalendar.get(3);
    }

    public CalendarDate moveToDayEnd() {
        CalendarDate r100 = new CalendarDate(this);
        r100.setHour(23);
        r100.setMinute(59);
        r100.setSecond(59);
        return r100;
    }

    public CalendarDate moveToDayStart() {
        CalendarDate r100 = new CalendarDate(this);
        r100.setHour(0);
        r100.setMinute(0);
        r100.setSecond(0);
        return r100;
    }

    public void moveToNow() {
        this.mGregorianCalendar.setTimeInMillis(System.currentTimeMillis());
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

    public CalendarDate getFirstDayOfTheWeek() {
        return addDay(-getWeeklyDayIndex());
    }

    public int getJulianDay() {
        int r100 = getYear();
        int r101 = getMonth();
        int r102 = (r101 - 14) / 12;
        return (((((((getYear() + 4800) + r102) * 1461) / 4) + ((((r101 - 2) - (r102 * 12)) * MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DECODE_TIME) / 12)) - (((((r100 + 4900) + r102) / 100) * 3) / 4)) + getMonthDay()) - 32075;
    }

    public int getWeeklyDayIndex() {
        return getWeekDay() - 1;
    }

    public Calendar getCalendar() {
        return this.mGregorianCalendar;
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

    public static CalendarDate getCalendarDate(long r100) {
        return new CalendarDate(new Date(r100));
    }

    public static void roundSecond(CalendarDate r100) {
        if (r100.getSecond() < 30) goto L5;
        r100.setMinute(r100.getMinute() + 1);
    L5:
        r100.setSecond(0);
    }

    public CalendarDate addDay(int r100) {
        CalendarDate r101 = new CalendarDate(this);
        r101.add(5, r100);
        return r101;
    }

    public CalendarDate addMonth(int r100) {
        CalendarDate r101 = new CalendarDate(this);
        r101.add(2, r100);
        return r101;
    }

    public CalendarDate addYear(int r100) {
        CalendarDate r101 = new CalendarDate(this);
        r101.add(1, r100);
        return r101;
    }

    public boolean before(CalendarDate r100) {
        return this.mGregorianCalendar.before(r100.mGregorianCalendar);
    }

    public boolean beforeDay(CalendarDate r100) {
        if (getJulianDay() >= r100.getJulianDay()) goto L5;
        return true;
    L5:
        return false;
    }

    public int dayDiff(CalendarDate r100) {
        return getJulianDay() - r100.getJulianDay();
    }

    public CalendarDate modifyDay(int r110) {
        int r100 = e.d(getYear(), getMonth() - 1);
        if (r110 > e.d(getYear(), getMonth())) goto L12;
        if (r110 <= 0) goto L8;
        return new CalendarDate(getYear(), getMonth(), r110, 0, 0, 0);
    L8:
        if (r110 <= (0 - r100)) goto L11;
        return new CalendarDate(getYear(), getMonth(), r100 + r110, 0, 0, 0);
    L11:
        return new CalendarDate(getYear(), getMonth(), getMonthDay(), 0, 0, 0);
    L12:
        return new CalendarDate(getYear(), getMonth(), getMonthDay(), 0, 0, 0);
    }

    public CalendarDate modifyMonth(int r100) {
        CalendarDate r101 = new CalendarDate();
        int r102 = getMonth() + r100;
        int r103 = 12;
        if (r100 <= 0) goto L11;
        if (r102 <= 12) goto L10;
        r101.setYear(getYear() + ((r102 - 1) / 12));
        int r104 = r102 % 12;
        if (r104 == 0) goto L9;
        r103 = r104;
    L9:
        r101.setMonth(r103);
    L23:
        return r101;
    L10:
        r101.setYear(getYear());
        r101.setMonth(r102);
        goto L23
    L11:
        if (r102 != 0) goto L13;
        r101.setYear(getYear() - 1);
        r101.setMonth(12);
        goto L23
    L13:
        if (r102 >= 0) goto L19;
        r101.setYear((getYear() + (r102 / 12)) - 1);
        int r105 = 12 - (Math.abs(r102) % 12);
        if (r105 == 0) goto L18;
        r103 = r105;
    L18:
        r101.setMonth(r103);
        goto L23
    L19:
        r101.setYear(getYear());
        if (r102 != 0) goto L22;
        r102 = 12;
    L22:
        r101.setMonth(r102);
        goto L23
    }

    public CalendarDate modifyWeek(int r100) {
        return new CalendarDate(this).addDay(r100 * 7);
    }

    public int monthDiff(CalendarDate r100) {
        return ((getYear() * 12) + getMonth()) - ((r100.getYear() * 12) + r100.getMonth());
    }

    public boolean sameDay(CalendarDate r100) {
        if (getJulianDay() != r100.getJulianDay()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean sameDayWithZeroPoint(CalendarDate r100) {
        if (r100.getTimeInSeconds() != r100.moveToDayStart().getTimeInSeconds()) goto L12;
        if (getTimeInSeconds() != r100.getTimeInSeconds()) goto L8;
        return true;
    L8:
        if (getJulianDay() != r100.addDay(-1).getJulianDay()) goto L15;
        return true;
    L15:
        return false;
    L12:
        if (getJulianDay() != r100.getJulianDay()) goto L16;
        return true;
    L16:
        return false;
    }

    public void setDayMinutes(int r100) {
        setHour(r100 / 60);
        setMinute(r100 % 60);
    }

    public final void setHour(int r100) {
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

    public final void setMinute(int r100) {
        this.mGregorianCalendar.set(12, r100);
    }

    public final void setMonth(int r100) {
        this.mGregorianCalendar.set(2, r100 - 1);
    }

    public void setMonthDay(int r100) {
        this.mGregorianCalendar.set(5, r100);
    }

    public final void setSecond(int r100) {
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

    public final void setYear(int r100) {
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

    public CalendarDate(Date r100, TimeZone r101) {
        GregorianCalendar r102 = new GregorianCalendar(r101);
        this.mGregorianCalendar = r102;
        r102.setTime(r100);
    }

    public void add(int r100, int r101) {
        this.mGregorianCalendar.add(r100, r101);
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
