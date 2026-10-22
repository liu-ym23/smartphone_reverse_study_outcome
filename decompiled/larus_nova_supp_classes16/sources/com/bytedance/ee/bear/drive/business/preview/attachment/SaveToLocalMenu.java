package com.bytedance.ee.bear.drive.business.preview.attachment;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.drive.business.preview.attachment.menuaction.AttachmentBaseMenuAction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SaveToLocalMenu extends AttachmentBaseMenuAction {
    public static final Parcelable.Creator<SaveToLocalMenu> CREATOR = null;

    public class a implements Parcelable.Creator<SaveToLocalMenu> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SaveToLocalMenu createFromParcel(Parcel r2) {
            return new SaveToLocalMenu(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final SaveToLocalMenu[] newArray(int r1) {
            return new SaveToLocalMenu[r1];
        }
    }

    public interface b {
        void a();
    }

    static {
        CREATOR = new a();
    }

    public SaveToLocalMenu(Parcel r1) {
        super(r1);
    }
}
