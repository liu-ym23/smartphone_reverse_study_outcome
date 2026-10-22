package com.ss.android.lark.api.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/api/bean/ForsetiChainType;", "Landroid/os/Parcelable;", "", "<init>", "(Ljava/lang/String;I)V", "TYPE_NORMAL", "TYPE_STACK", "TYPE_HALF_STACK", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "describeContents", "CREATOR", "forseti-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ForsetiChainType extends Enum<ForsetiChainType> implements Parcelable {
    public static final a CREATOR = null;
    public static final ForsetiChainType TYPE_HALF_STACK = null;
    public static final ForsetiChainType TYPE_NORMAL = null;
    public static final ForsetiChainType TYPE_STACK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ForsetiChainType[] f408644a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f408645b = null;

    public static EnumEntries<ForsetiChainType> getEntries() {
        return f408645b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.api.bean.ForsetiChainType$a] */
    static {
        ForsetiChainType r100 = new ForsetiChainType("TYPE_NORMAL", 0);
        TYPE_NORMAL = r100;
        ForsetiChainType r101 = new ForsetiChainType("TYPE_STACK", 1);
        TYPE_STACK = r101;
        ForsetiChainType r102 = new ForsetiChainType("TYPE_HALF_STACK", 2);
        TYPE_HALF_STACK = r102;
        ForsetiChainType[] r103 = {r100, r101, r102};
        f408644a = r103;
        f408645b = EnumEntriesKt.enumEntries(r103);
        CREATOR = new a();
    }

    public static ForsetiChainType[] values() {
        return (ForsetiChainType[]) f408644a.clone();
    }

    public static ForsetiChainType valueOf(String r100) {
        return (ForsetiChainType) r27.a.a(ForsetiChainType.class, r100);
    }

    public ForsetiChainType(String r100, int r101) {
        super(r100, r101);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(ordinal());
    }
}
