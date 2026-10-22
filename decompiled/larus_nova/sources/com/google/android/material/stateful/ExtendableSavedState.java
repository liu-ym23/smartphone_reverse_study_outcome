package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.SimpleArrayMap;
import androidx.customview.view.AbsSavedState;
import com.alipay.sdk.m.u.i;

/* JADX INFO: loaded from: classes23.dex */
public class ExtendableSavedState extends AbsSavedState {
    public static final Parcelable.Creator<ExtendableSavedState> CREATOR = null;
    public final SimpleArrayMap<String, Bundle> extendableStates;

    static {
        CREATOR = new AnonymousClass1();
    }

    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.extendableStates + i.f25855d;
    }

    public ExtendableSavedState(Parcelable r100) {
        super(r100);
        this.extendableStates = new SimpleArrayMap();
    }

    private ExtendableSavedState(Parcel r100, ClassLoader r101) {
        super(r100, r101);
        int r102 = r100.readInt();
        String[] r103 = new String[r102];
        r100.readStringArray(r103);
        Bundle[] r104 = new Bundle[r102];
        r100.readTypedArray(r104, Bundle.CREATOR);
        this.extendableStates = new SimpleArrayMap(r102);
        int r105 = 0;
    L3:
        if (r105 >= r102) goto L5;
        this.extendableStates.put(r103[r105], r104[r105]);
        r105 = r105 + 1;
        goto L3
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        int r102 = this.extendableStates.size();
        r100.writeInt(r102);
        String[] r103 = new String[r102];
        Bundle[] r104 = new Bundle[r102];
        int r105 = 0;
    L3:
        if (r105 >= r102) goto L5;
        r103[r105] = this.extendableStates.keyAt(r105);
        r104[r105] = this.extendableStates.valueAt(r105);
        r105 = r105 + 1;
        goto L3
    L5:
        r100.writeStringArray(r103);
        r100.writeTypedArray(r104, 0);
    }

    public /* synthetic */ ExtendableSavedState(Parcel r100, ClassLoader r101, AnonymousClass1 r102) {
        this(r100, r101);
    }
}
