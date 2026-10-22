package com.bytedance.ee.bear.drive.business.preview.attachment.menuaction;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ForwardMenuAction extends AttachmentBaseMenuAction {
    public static final Parcelable.Creator<ForwardMenuAction> CREATOR = null;

    public class a implements Parcelable.Creator<ForwardMenuAction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardMenuAction createFromParcel(Parcel r2) {
            return new ForwardMenuAction(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardMenuAction[] newArray(int r1) {
            return new ForwardMenuAction[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public ForwardMenuAction() {
    }

    public ForwardMenuAction(Parcel r1) {
        super(r1);
    }
}
