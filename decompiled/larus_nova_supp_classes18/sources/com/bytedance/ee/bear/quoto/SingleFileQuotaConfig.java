package com.bytedance.ee.bear.quoto;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0014B\u001b\b\u0002\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/quoto/SingleFileQuotaConfig;", "Landroid/os/Parcelable;", "", "placeHolderId", "", "quotaType", "<init>", "(Ljava/lang/String;III)V", "getPlaceHolderId", "()I", "getQuotaType", "UPLOAD", "DUPLICATE", "SAVE", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "describeContents", "CREATOR", "features-quoto-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SingleFileQuotaConfig extends Enum<SingleFileQuotaConfig> implements Parcelable {
    public static final a CREATOR = null;
    public static final SingleFileQuotaConfig DUPLICATE = null;
    public static final SingleFileQuotaConfig SAVE = null;
    public static final SingleFileQuotaConfig UPLOAD = null;
    public static final /* synthetic */ SingleFileQuotaConfig[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int placeHolderId;
    private final int quotaType;

    public static EnumEntries<SingleFileQuotaConfig> getEntries() {
        return b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.quoto.SingleFileQuotaConfig$a] */
    static {
        SingleFileQuotaConfig r0 = new SingleFileQuotaConfig("UPLOAD", 0, 1);
        UPLOAD = r0;
        SingleFileQuotaConfig r1 = new SingleFileQuotaConfig("DUPLICATE", 1, 2);
        DUPLICATE = r1;
        SingleFileQuotaConfig r4 = new SingleFileQuotaConfig("SAVE", 2, 3);
        SAVE = r4;
        SingleFileQuotaConfig[] r6 = {r0, r1, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
        CREATOR = new a();
    }

    public static SingleFileQuotaConfig[] values() {
        return (SingleFileQuotaConfig[]) a.clone();
    }

    public final int getPlaceHolderId() {
        return this.placeHolderId;
    }

    public final int getQuotaType() {
        return this.quotaType;
    }

    public static SingleFileQuotaConfig valueOf(String r1) {
        return (SingleFileQuotaConfig) r27.a.a(SingleFileQuotaConfig.class, r1);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeInt(ordinal());
    }

    public SingleFileQuotaConfig(String r1, int r2, int r3) {
        super(r1, r2);
        this.placeHolderId = 2131232538;
        this.quotaType = r3;
    }
}
