package com.ss.android.ugc.aweme.feed.model.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\b\u0087\u0001\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0017B#\b\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016R\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lcom/ss/android/ugc/aweme/feed/model/nearby/NearbyPageType;", "", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "serverCode", "I", "getServerCode", "()I", "", "enterFrom", "Ljava/lang/String;", "getEnterFrom", "()Ljava/lang/String;", "freshType", "getFreshType", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "CREATOR", "TAB_NEARBY", "PAGE_GROUP_BUY", "TAB_GROUP_BUY", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum NearbyPageType extends Enum<NearbyPageType> implements Parcelable {
    private static final /* synthetic */ NearbyPageType[] $VALUES = null;
    public static final CREATOR CREATOR = null;
    public static final NearbyPageType PAGE_GROUP_BUY = null;
    public static final NearbyPageType TAB_GROUP_BUY = null;
    public static final NearbyPageType TAB_NEARBY = null;
    private final String enterFrom;
    private final String freshType;
    private final int serverCode;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/feed/model/nearby/NearbyPageType$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/ss/android/ugc/aweme/feed/model/nearby/NearbyPageType;", "<init>", "()V", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
    public static final class CREATOR implements Parcelable.Creator<NearbyPageType> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(int r100) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public final NearbyPageType createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return NearbyPageType.values()[r100.readInt()];
        }

        @Override // android.os.Parcelable.Creator
        public final NearbyPageType[] newArray(int r100) {
            return new NearbyPageType[r100];
        }
    }

    private static final /* synthetic */ NearbyPageType[] $values() {
        return new NearbyPageType[]{TAB_NEARBY, PAGE_GROUP_BUY, TAB_GROUP_BUY};
    }

    public static NearbyPageType valueOf(String r100) {
        return (NearbyPageType) a.a(NearbyPageType.class, r100);
    }

    public static NearbyPageType[] values() {
        return (NearbyPageType[]) $VALUES.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        TAB_NEARBY = new NearbyPageType("TAB_NEARBY", 0, 0, "homepage_fresh", null);
        PAGE_GROUP_BUY = new NearbyPageType("PAGE_GROUP_BUY", 1, 2, "life_dual_idpt", "dual_idpt");
        TAB_GROUP_BUY = new NearbyPageType("TAB_GROUP_BUY", 2, 1, "homepage_life", "life");
        $VALUES = $values();
        CREATOR = new CREATOR(0);
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getFreshType() {
        return this.freshType;
    }

    public final int getServerCode() {
        return this.serverCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(ordinal());
    }

    private NearbyPageType(String r100, int r101, int r102, String r103, String r104) {
        super(r100, r101);
        this.serverCode = r102;
        this.enterFrom = r103;
        this.freshType = r104;
    }
}
