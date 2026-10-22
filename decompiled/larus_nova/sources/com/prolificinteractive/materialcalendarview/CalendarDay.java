package com.prolificinteractive.materialcalendarview;

import android.os.Parcel;
import android.os.Parcelable;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes34.dex */
public final class CalendarDay implements Parcelable {
    public static final Parcelable.Creator<CalendarDay> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocalDate f404402a;

    public static class a implements Parcelable.Creator<CalendarDay> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CalendarDay createFromParcel(Parcel r100) {
            return new CalendarDay(r100.readInt(), r100.readInt(), r100.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final CalendarDay[] newArray(int r100) {
            return new CalendarDay[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final int b() {
        return this.f404402a.getMonthValue();
    }

    public final int c() {
        return this.f404402a.getYear();
    }

    public final int hashCode() {
        int r100 = this.f404402a.getYear();
        int r101 = this.f404402a.getMonthValue();
        int r102 = (r100 * 10000) + (r101 * 100);
        return r102 + this.f404402a.getDayOfMonth();
    }

    public final String toString() {
        return "CalendarDay{" + this.f404402a.getYear() + "-" + this.f404402a.getMonthValue() + "-" + this.f404402a.getDayOfMonth() + com.alipay.sdk.m.u.i.f25855d;
    }

    public CalendarDay(LocalDate r100) {
        this.f404402a = r100;
    }

    public static CalendarDay a(LocalDate r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new CalendarDay(r100);
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof CalendarDay) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f404402a.equals(((CalendarDay) r100).f404402a) == false) goto L7;
        return true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f404402a.getYear());
        r100.writeInt(this.f404402a.getMonthValue());
        r100.writeInt(this.f404402a.getDayOfMonth());
    }

    public CalendarDay(int r100, int r101, int r102) {
        this.f404402a = LocalDate.of(r100, r101, r102);
    }
}
