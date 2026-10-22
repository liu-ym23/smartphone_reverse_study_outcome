package com.bytedance.ee.bear.drivesdk.action;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.drive.sdk.preview.PreviewAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/drivesdk/action/MessageChangeAction;", "Lcom/bytedance/ee/bear/contract/drive/sdk/preview/PreviewAction;", "<init>", "()V", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "contentmanager-drive-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageChangeAction implements PreviewAction {
    public static final Parcelable.Creator<MessageChangeAction> CREATOR = null;

    public static final class a implements Parcelable.Creator<MessageChangeAction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MessageChangeAction createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            r2.readInt();
            return new MessageChangeAction();
        }

        @Override // android.os.Parcelable.Creator
        public final MessageChangeAction[] newArray(int r1) {
            return new MessageChangeAction[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public MessageChangeAction() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeInt(1);
    }
}
