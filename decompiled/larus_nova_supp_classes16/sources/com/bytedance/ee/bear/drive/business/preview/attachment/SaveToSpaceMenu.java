package com.bytedance.ee.bear.drive.business.preview.attachment;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.drive.business.preview.attachment.menuaction.AttachmentBaseMenuAction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SaveToSpaceMenu extends AttachmentBaseMenuAction {
    public static final Parcelable.Creator<SaveToSpaceMenu> CREATOR = null;
    public final boolean d;

    public class a implements Parcelable.Creator<SaveToSpaceMenu> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SaveToSpaceMenu createFromParcel(Parcel r2) {
            return new SaveToSpaceMenu(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final SaveToSpaceMenu[] newArray(int r1) {
            return new SaveToSpaceMenu[r1];
        }
    }

    @Override // com.bytedance.ee.bear.drive.business.preview.attachment.menuaction.AttachmentBaseMenuAction, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public SaveToSpaceMenu() {
        this.d = true;
    }

    public SaveToSpaceMenu(Parcel r2) {
        super(r2);
        boolean r0 = true;
        this.d = true;
        if (r2.readByte() != 0) goto L6;
        r0 = false;
    L6:
        this.d = r0;
    }

    @Override // com.bytedance.ee.bear.drive.business.preview.attachment.menuaction.AttachmentBaseMenuAction, android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        super.writeToParcel(r1, r2);
        r1.writeByte(this.d ? 1 : 0);
    }
}
