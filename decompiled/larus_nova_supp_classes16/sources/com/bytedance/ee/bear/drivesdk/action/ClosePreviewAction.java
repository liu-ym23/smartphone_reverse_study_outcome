package com.bytedance.ee.bear.drivesdk.action;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.drive.sdk.preview.PreviewAction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ClosePreviewAction implements PreviewAction {
    public static final Parcelable.Creator<ClosePreviewAction> CREATOR = null;

    public class a implements Parcelable.Creator<ClosePreviewAction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ClosePreviewAction createFromParcel(Parcel r2) {
            return new ClosePreviewAction(0);
        }

        @Override // android.os.Parcelable.Creator
        public final ClosePreviewAction[] newArray(int r1) {
            return new ClosePreviewAction[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
    }

    static {
        CREATOR = new a();
    }

    public ClosePreviewAction() {
    }

    public ClosePreviewAction(int r1) {
    }
}
