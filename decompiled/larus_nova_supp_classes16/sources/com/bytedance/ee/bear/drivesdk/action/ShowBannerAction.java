package com.bytedance.ee.bear.drivesdk.action;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.drive.sdk.preview.PreviewAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/drivesdk/action/ShowBannerAction;", "Lcom/bytedance/ee/bear/contract/drive/sdk/preview/PreviewAction;", "bannerId", "", "banner", "Lcom/bytedance/ee/bear/drivesdk/action/ShowBannerAction$BannerProvider;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ee/bear/drivesdk/action/ShowBannerAction$BannerProvider;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getBannerId", "()Ljava/lang/String;", "getBanner", "()Lcom/bytedance/ee/bear/drivesdk/action/ShowBannerAction$BannerProvider;", "writeToParcel", "", "flags", "", "describeContents", "BannerProvider", "CREATOR", "contentmanager-drive-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShowBannerAction implements PreviewAction {
    public static final a CREATOR = null;
    public final String a;

    public static final class a implements Parcelable.Creator<ShowBannerAction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ShowBannerAction createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new ShowBannerAction(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final ShowBannerAction[] newArray(int r1) {
            return new ShowBannerAction[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ShowBannerAction(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        String r3 = r2.readString();
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        Intrinsics.checkNotNullParameter(r3, "bannerId");
        this.a = r3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.a);
    }
}
