package com.bytedance.ee.bear.drive.business.preview.attachment.menuaction;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes16.dex */
public class ForwardMenuAction extends AttachmentBaseMenuAction {
    public static final Parcelable.Creator<ForwardMenuAction> CREATOR = null;

    public class a implements Parcelable.Creator<ForwardMenuAction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardMenuAction createFromParcel(Parcel r100) {
            return new ForwardMenuAction(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardMenuAction[] newArray(int r100) {
            return new ForwardMenuAction[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ForwardMenuAction() {
    }

    public ForwardMenuAction(Parcel r100) {
        super(r100);
    }
}
