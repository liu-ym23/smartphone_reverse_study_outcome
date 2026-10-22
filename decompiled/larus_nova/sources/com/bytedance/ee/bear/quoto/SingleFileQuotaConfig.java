package com.bytedance.ee.bear.quoto;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0014B\u001b\b\u0002\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/quoto/SingleFileQuotaConfig;", "Landroid/os/Parcelable;", "", "placeHolderId", "", "quotaType", "<init>", "(Ljava/lang/String;III)V", "getPlaceHolderId", "()I", "getQuotaType", "UPLOAD", "DUPLICATE", "SAVE", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "describeContents", "CREATOR", "features-quoto-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SingleFileQuotaConfig extends Enum<SingleFileQuotaConfig> implements Parcelable {
    public static final a CREATOR = null;
    public static final SingleFileQuotaConfig DUPLICATE = null;
    public static final SingleFileQuotaConfig SAVE = null;
    public static final SingleFileQuotaConfig UPLOAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SingleFileQuotaConfig[] f236339a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f236340b = null;
    private final int placeHolderId;
    private final int quotaType;

    public static EnumEntries<SingleFileQuotaConfig> getEntries() {
        return f236340b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.quoto.SingleFileQuotaConfig$a] */
    static {
        SingleFileQuotaConfig r100 = new SingleFileQuotaConfig("UPLOAD", 0, 1);
        UPLOAD = r100;
        SingleFileQuotaConfig r101 = new SingleFileQuotaConfig("DUPLICATE", 1, 2);
        DUPLICATE = r101;
        SingleFileQuotaConfig r102 = new SingleFileQuotaConfig("SAVE", 2, 3);
        SAVE = r102;
        SingleFileQuotaConfig[] r103 = {r100, r101, r102};
        f236339a = r103;
        f236340b = EnumEntriesKt.enumEntries(r103);
        CREATOR = new a();
    }

    public static SingleFileQuotaConfig[] values() {
        return (SingleFileQuotaConfig[]) f236339a.clone();
    }

    public final int getPlaceHolderId() {
        return this.placeHolderId;
    }

    public final int getQuotaType() {
        return this.quotaType;
    }

    public static SingleFileQuotaConfig valueOf(String r100) {
        return (SingleFileQuotaConfig) r27.a.a(SingleFileQuotaConfig.class, r100);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(ordinal());
    }

    public SingleFileQuotaConfig(String r100, int r101, int r102) {
        super(r100, r101);
        this.placeHolderId = R.drawable.ccm_ccm_empty_positive_storage_limit;
        this.quotaType = r102;
    }
}
