package com.obric.memorydata.sdk.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/sdk/realtime/ActionContext;", "Landroid/os/Parcelable;", "<init>", "()V", "type", "", "getType", "()I", "packageName", "", "getPackageName", "()Ljava/lang/String;", "activityName", "getActivityName", "describeContents", "writeToParcelBase", "", "dest", "Landroid/os/Parcel;", "flags", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ActionContext implements Parcelable {
    public static final CREATOR CREATOR = null;

    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/sdk/realtime/ActionContext$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/memorydata/sdk/realtime/ActionContext;", "<init>", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/memorydata/sdk/realtime/ActionContext;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<ActionContext> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActionContext createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            int r101 = r100.readInt();
            if (r101 == 1) goto L18;
            if (r101 == 2) goto L23;
            if (r101 == 3) goto L22;
            if (r101 == 4) goto L21;
            if (r101 == 5) goto L20;
            return null;
        L20:
            return VideoActionContext.CREATOR.createFromParcel(r100);
        L21:
            return IMActionContext.CREATOR.createFromParcel(r100);
        L22:
            return WebsiteActionContext.CREATOR.createFromParcel(r100);
        L23:
            return FileActionContext.CREATOR.createFromParcel(r100);
        L18:
            return PhotoActionContext.CREATOR.createFromParcel(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ActionContext[] newArray(int r100) {
            return newArray(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ActionContext createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActionContext[] newArray(int r100) {
            return new ActionContext[r100];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public ActionContext() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract String getActivityName();

    public abstract String getPackageName();

    public abstract int getType();

    public final void writeToParcelBase(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(getType());
    }
}
