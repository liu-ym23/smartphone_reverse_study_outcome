package com.bytedance.ee.bear.drivesdk.action;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.drive.sdk.preview.PreviewAction;

/* JADX INFO: loaded from: classes16.dex */
public class ClosePreviewAction implements PreviewAction {
    public static final Parcelable.Creator<ClosePreviewAction> CREATOR = null;

    public class a implements Parcelable.Creator<ClosePreviewAction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ClosePreviewAction createFromParcel(Parcel r100) {
            return new ClosePreviewAction(0);
        }

        @Override // android.os.Parcelable.Creator
        public final ClosePreviewAction[] newArray(int r100) {
            return new ClosePreviewAction[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
    }

    static {
        CREATOR = new a();
    }

    public ClosePreviewAction() {
    }

    public ClosePreviewAction(int r100) {
    }
}
