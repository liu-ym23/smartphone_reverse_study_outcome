package com.ss.android.ugc.aweme.filter;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class StrArray implements Parcelable, Serializable {
    public static final Parcelable.Creator<StrArray> CREATOR = null;
    private List<String> mItems;
    private List<Integer> numbers;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public void addIndex() {
        int r100 = this.mItems.size();
        if (r100 <= 0) goto L6;
        this.numbers.add(Integer.valueOf(r100 - 1));
        return;
    }

    public void removeLast() {
        if (this.mItems.isEmpty() == true) goto L6;
        List<String> r100 = this.mItems;
        ListProtector.remove(r100, r100.size() - 1);
        return;
    }

    public void removeLastArray() {
        int r100 = this.mItems.size();
        int r101 = this.numbers.size();
        if (r100 > 0) goto L5;
        return;
    L5:
        if (r101 <= 1) goto L13;
        int r102 = ((Integer) ListProtector.get(this.numbers, r101 - 2)).intValue();
        int r103 = r100 - 1;
    L7:
        if (r103 <= r102) goto L9;
        ListProtector.remove(this.mItems, r103);
        r103 = r103 - 1;
        goto L7
    L9:
        ListProtector.remove(this.numbers, r101 - 1);
        return;
    }

    public void reset() {
        this.mItems.clear();
        this.numbers.clear();
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        int r101 = this.mItems.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        r100.append((String) ListProtector.get(this.mItems, r102));
        if (r102 == (r101 - 1)) goto L7;
        r100.append(",");
    L7:
        r102 = r102 + 1;
        goto L3
    L9:
        return r100.toString();
    }

    public StrArray() {
        this.mItems = new ArrayList();
        ArrayList r100 = new ArrayList();
        this.numbers = r100;
        r100.add(-1);
    }

    public static StrArray from(String r100) {
        StrArray r101 = new StrArray();
        if (TextUtils.isEmpty(r100) == true) goto L7;
        String[] r102 = r100.split(",");
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L7;
        r101.add(r102[r104]);
        r104 = r104 + 1;
    L7:
        return r101;
    }

    public void add(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        this.mItems.add(r100);
        return;
    }

    public StrArray(Parcel r100, AnonymousClass1 r101) {
        this.numbers = new ArrayList();
        this.mItems = r100.createStringArrayList();
        r100.readList(this.numbers, Integer.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeStringList(this.mItems);
        r100.writeList(this.numbers);
    }
}
