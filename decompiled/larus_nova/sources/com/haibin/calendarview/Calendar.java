package com.haibin.calendarview;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public final class Calendar implements Serializable, Comparable<Calendar> {
    private static final long serialVersionUID = 141315161718191143L;
    private int day;
    private String gregorianFestival;
    private boolean isCurrentDay;
    private boolean isCurrentMonth;
    private boolean isLeapYear;
    private boolean isWeekend;
    private int leapMonth;
    private String lunar;
    private Calendar lunarCalendar;
    private int month;
    private String scheme;
    private int schemeColor;
    private List<Scheme> schemes;
    private String solarTerm;
    private String traditionFestival;
    private int week;
    private int year;

    public static final class Scheme implements Serializable {
        private Object obj;
        private String other;
        private String scheme;
        private int shcemeColor;
        private int type;

        public Scheme() {
        }

        public Object getObj() {
            return this.obj;
        }

        public String getOther() {
            return this.other;
        }

        public String getScheme() {
            return this.scheme;
        }

        public int getShcemeColor() {
            return this.shcemeColor;
        }

        public int getType() {
            return this.type;
        }

        public void setObj(Object r100) {
            this.obj = r100;
        }

        public void setOther(String r100) {
            this.other = r100;
        }

        public void setScheme(String r100) {
            this.scheme = r100;
        }

        public void setShcemeColor(int r100) {
            this.shcemeColor = r100;
        }

        public void setType(int r100) {
            this.type = r100;
        }

        public Scheme(int r100, String r101) {
            this.shcemeColor = r100;
            this.scheme = r101;
        }

        public Scheme(int r100, int r101, String r102) {
            this.type = r100;
            this.shcemeColor = r101;
            this.scheme = r102;
        }

        public Scheme(int r100, String r101, String r102) {
            this.shcemeColor = r100;
            this.scheme = r101;
            this.other = r102;
        }

        public Scheme(int r100, int r101, String r102, String r103) {
            this.type = r100;
            this.shcemeColor = r101;
            this.scheme = r102;
            this.other = r103;
        }
    }

    public Calendar() {
    }

    public final void clearScheme() {
        setScheme("");
        setSchemeColor(0);
        setSchemes(null);
    }

    public boolean hasScheme() {
        List<Scheme> r100 = this.schemes;
        if (r100 == null) goto L8;
        if (r100.size() == 0) goto L8;
        return true;
    L8:
        if (TextUtils.isEmpty(this.scheme) == true) goto L10;
        return true;
    L10:
        return false;
    }

    public boolean isAvailable() {
        int r100 = this.year;
        boolean r101 = true;
        if (r100 <= 0) goto L5;
        boolean r102 = true;
    L6:
        int r103 = this.month;
        if (r103 <= 0) goto L9;
        boolean r104 = true;
    L10:
        boolean r105 = r102 & r104;
        int r106 = this.day;
        if (r106 <= 0) goto L13;
        boolean r107 = true;
    L14:
        boolean r108 = r105 & r107;
        if (r106 > 31) goto L17;
        boolean r109 = true;
    L18:
        boolean r110 = r108 & r109;
        if (r103 > 12) goto L21;
        boolean r111 = true;
    L22:
        boolean r112 = r110 & r111;
        if (r100 < 1900) goto L25;
        boolean r113 = true;
    L26:
        boolean r114 = r112 & r113;
        if (r100 <= 2099) goto L31;
        r101 = false;
    L31:
        return r114 & r101;
    L25:
        r113 = false;
        goto L26
    L21:
        r111 = false;
        goto L22
    L17:
        r109 = false;
        goto L18
    L13:
        r107 = false;
        goto L14
    L9:
        r104 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.year);
        r100.append("");
        int r101 = this.month;
        if (r101 >= 10) goto L5;
        Object r102 = "0" + this.month;
    L6:
        r100.append(r102);
        r100.append("");
        int r103 = this.day;
        if (r103 >= 10) goto L9;
        Object r104 = "0" + this.day;
    L10:
        r100.append(r104);
        return r100.toString();
    L9:
        r104 = Integer.valueOf(r103);
        goto L10
    L5:
        r102 = Integer.valueOf(r101);
        goto L6
    }

    public long getTimeInMillis() {
        java.util.Calendar r100 = java.util.Calendar.getInstance();
        r100.set(1, this.year);
        r100.set(2, this.month - 1);
        r100.set(5, this.day);
        return r100.getTimeInMillis();
    }

    public int getDay() {
        return this.day;
    }

    public String getGregorianFestival() {
        return this.gregorianFestival;
    }

    public int getLeapMonth() {
        return this.leapMonth;
    }

    public String getLunar() {
        return this.lunar;
    }

    public Calendar getLunarCalendar() {
        return this.lunarCalendar;
    }

    public int getMonth() {
        return this.month;
    }

    public String getScheme() {
        return this.scheme;
    }

    public int getSchemeColor() {
        return this.schemeColor;
    }

    public List<Scheme> getSchemes() {
        return this.schemes;
    }

    public String getSolarTerm() {
        return this.solarTerm;
    }

    public String getTraditionFestival() {
        return this.traditionFestival;
    }

    public int getWeek() {
        return this.week;
    }

    public int getYear() {
        return this.year;
    }

    public boolean isCurrentDay() {
        return this.isCurrentDay;
    }

    public boolean isCurrentMonth() {
        return this.isCurrentMonth;
    }

    public boolean isLeapYear() {
        return this.isLeapYear;
    }

    public boolean isWeekend() {
        return this.isWeekend;
    }

    public void addScheme(Scheme r100) {
        if (this.schemes != null) goto L5;
        this.schemes = new ArrayList();
    L5:
        this.schemes.add(r100);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Calendar r100) {
        if (r100 != null) goto L6;
        return 1;
    L6:
        return toString().compareTo(r100.toString());
    }

    public final int differ(Calendar r100) {
        if (r100 != null) goto L4;
        return Integer.MAX_VALUE;
    L4:
        java.util.Calendar r101 = java.util.Calendar.getInstance();
        r101.set(getYear(), getMonth() - 1, getDay());
        long r102 = r101.getTimeInMillis();
        r101.set(r100.getYear(), r100.getMonth() - 1, r100.getDay());
        return (int) ((r102 - r101.getTimeInMillis()) / 86400000);
    }

    public boolean equals(Object r100) {
        if (r100 == null) goto L14;
        if ((r100 instanceof Calendar) == false) goto L14;
        Calendar r101 = (Calendar) r100;
        if (r101.getYear() != this.year) goto L14;
        if (r101.getMonth() != this.month) goto L14;
        if (r101.getDay() != this.day) goto L14;
        return true;
    L14:
        return super.equals(r100);
    }

    public boolean isSameMonth(Calendar r100) {
        if (this.year == r100.getYear()) goto L5;
    L7:
        return false;
    L5:
        if (this.month != r100.getMonth()) goto L7;
        return true;
    }

    public void setCurrentDay(boolean r100) {
        this.isCurrentDay = r100;
    }

    public void setCurrentMonth(boolean r100) {
        this.isCurrentMonth = r100;
    }

    public void setDay(int r100) {
        this.day = r100;
    }

    public void setGregorianFestival(String r100) {
        this.gregorianFestival = r100;
    }

    public void setLeapMonth(int r100) {
        this.leapMonth = r100;
    }

    public void setLeapYear(boolean r100) {
        this.isLeapYear = r100;
    }

    public void setLunar(String r100) {
        this.lunar = r100;
    }

    public void setLunarCalendar(Calendar r100) {
        this.lunarCalendar = r100;
    }

    public void setMonth(int r100) {
        this.month = r100;
    }

    public void setScheme(String r100) {
        this.scheme = r100;
    }

    public void setSchemeColor(int r100) {
        this.schemeColor = r100;
    }

    public void setSchemes(List<Scheme> r100) {
        this.schemes = r100;
    }

    public void setSolarTerm(String r100) {
        this.solarTerm = r100;
    }

    public void setTraditionFestival(String r100) {
        this.traditionFestival = r100;
    }

    public void setWeek(int r100) {
        this.week = r100;
    }

    public void setWeekend(boolean r100) {
        this.isWeekend = r100;
    }

    public void setYear(int r100) {
        this.year = r100;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Calendar r100) {
        return compareTo2(r100);
    }

    public void addScheme(int r100, String r101) {
        if (this.schemes != null) goto L5;
        this.schemes = new ArrayList();
    L5:
        this.schemes.add(new Scheme(r100, r101));
    }

    public final void mergeScheme(Calendar r100, String r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100.getScheme()) == true) goto L8;
        r101 = r100.getScheme();
    L8:
        setScheme(r101);
        setSchemeColor(r100.getSchemeColor());
        setSchemes(r100.getSchemes());
    }

    public void addScheme(int r100, int r101, String r102) {
        if (this.schemes != null) goto L5;
        this.schemes = new ArrayList();
    L5:
        this.schemes.add(new Scheme(r100, r101, r102));
    }

    public void addScheme(int r100, String r101, String r102) {
        if (this.schemes != null) goto L5;
        this.schemes = new ArrayList();
    L5:
        this.schemes.add(new Scheme(r100, r101, r102));
    }

    public void addScheme(int r100, int r101, String r102, String r103) {
        if (this.schemes != null) goto L5;
        this.schemes = new ArrayList();
    L5:
        this.schemes.add(new Scheme(r100, r101, r102, r103));
    }
}
