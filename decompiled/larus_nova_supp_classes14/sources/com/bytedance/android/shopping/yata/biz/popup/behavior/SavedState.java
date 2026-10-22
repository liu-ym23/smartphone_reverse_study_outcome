package com.bytedance.android.shopping.yata.biz.popup.behavior;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
class SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = null;
    public final int a;

    public class a implements Parcelable.ClassLoaderCreator<SavedState> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel r2) {
            return new SavedState(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int r1) {
            return new SavedState[r1];
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public final SavedState createFromParcel(Parcel r1, ClassLoader r2) {
            return new SavedState(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public SavedState(Parcel r1) {
        super(r1);
        this.a = r1.readInt();
    }

    public SavedState(Parcelable r1, int r2) {
        super(r1);
        this.a = r2;
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        super.writeToParcel(r1, r2);
        r1.writeInt(this.a);
    }
}
