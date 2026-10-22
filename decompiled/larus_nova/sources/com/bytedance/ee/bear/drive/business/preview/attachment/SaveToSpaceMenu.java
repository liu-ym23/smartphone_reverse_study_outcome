package com.bytedance.ee.bear.drive.business.preview.attachment;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.drive.business.preview.attachment.menuaction.AttachmentBaseMenuAction;

/* JADX INFO: loaded from: classes16.dex */
public class SaveToSpaceMenu extends AttachmentBaseMenuAction {
    public static final Parcelable.Creator<SaveToSpaceMenu> CREATOR = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f224038d;

    public class a implements Parcelable.Creator<SaveToSpaceMenu> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SaveToSpaceMenu createFromParcel(Parcel r100) {
            return new SaveToSpaceMenu(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SaveToSpaceMenu[] newArray(int r100) {
            return new SaveToSpaceMenu[r100];
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
        this.f224038d = true;
    }

    public SaveToSpaceMenu(Parcel r100) {
        super(r100);
        boolean r101 = true;
        this.f224038d = true;
        if (r100.readByte() != 0) goto L6;
        r101 = false;
    L6:
        this.f224038d = r101;
    }

    @Override // com.bytedance.ee.bear.drive.business.preview.attachment.menuaction.AttachmentBaseMenuAction, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeByte(this.f224038d ? 1 : 0);
    }
}
