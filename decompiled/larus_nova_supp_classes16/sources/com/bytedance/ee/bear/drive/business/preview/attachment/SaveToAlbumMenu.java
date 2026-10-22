package com.bytedance.ee.bear.drive.business.preview.attachment;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SaveToAlbumMenu extends SaveToLocalMenu {
    public static final Parcelable.Creator<SaveToAlbumMenu> CREATOR = null;

    public class a implements Parcelable.Creator<SaveToAlbumMenu> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SaveToAlbumMenu createFromParcel(Parcel r2) {
            return new SaveToAlbumMenu(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final SaveToAlbumMenu[] newArray(int r1) {
            return new SaveToAlbumMenu[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public SaveToAlbumMenu(Parcel r1) {
        super(r1);
    }
}
