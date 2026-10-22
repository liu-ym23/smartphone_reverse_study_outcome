package com.haibin.calendarview;

import java.io.Serializable;

/* JADX INFO: loaded from: classes23.dex */
final class Month implements Serializable {
    private int count;
    private int diff;
    private int month;
    private int year;

    public Month() {
    }

    public int getCount() {
        return this.count;
    }

    public int getDiff() {
        return this.diff;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public void setCount(int r100) {
        this.count = r100;
    }

    public void setDiff(int r100) {
        this.diff = r100;
    }

    public void setMonth(int r100) {
        this.month = r100;
    }

    public void setYear(int r100) {
        this.year = r100;
    }
}
