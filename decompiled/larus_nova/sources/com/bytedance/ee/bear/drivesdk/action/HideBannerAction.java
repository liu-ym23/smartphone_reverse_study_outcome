package com.bytedance.ee.bear.drivesdk.action;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.drive.sdk.preview.PreviewAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/drivesdk/action/HideBannerAction;", "Lcom/bytedance/ee/bear/contract/drive/sdk/preview/PreviewAction;", "bannerId", "", "<init>", "(Ljava/lang/String;)V", "getBannerId", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "contentmanager-drive-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HideBannerAction implements PreviewAction {
    public static final Parcelable.Creator<HideBannerAction> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f225985a;

    public static final class a implements Parcelable.Creator<HideBannerAction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final HideBannerAction createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new HideBannerAction(r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final HideBannerAction[] newArray(int r100) {
            return new HideBannerAction[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f225985a);
    }

    public HideBannerAction(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bannerId");
        this.f225985a = r100;
    }
}
