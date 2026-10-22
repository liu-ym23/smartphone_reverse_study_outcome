package com.ss.android.lark.api.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u001a2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u001aB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0012\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/api/bean/ForsetiWidth;", "Landroid/os/Parcelable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "parcel", "Landroid/os/Parcel;", "(Ljava/lang/String;ILandroid/os/Parcel;)V", "getValue", "()I", "FULL", "FIXED_LEVEL1_IN_NARROW_SCREEN_LEFT_SIDE", "FIXED_LEVEL1_IN_NARROW_SCREEN_RIGHT_SIDE", "FIXED_LEVEL1_IN_WIDE_SCREEN_LEFT_SIDE", "FIXED_LEVEL1_IN_WIDE_SCREEN_RIGHT_SIDE", "AVERAGE_LEVEL", "FIXED_LEVEL2_IN_NARROW_SCREEN_RIGHT_SIDE", "FIXED_LEVEL2_IN_NARROW_SCREEN_LEFT_SIDE", "FIXED_LEVEL2_IN_WIDE_SCREEN_RIGHT_SIDE", "FIXED_LEVEL2_IN_WIDE_SCREEN_LEFT_SIDE", "writeToParcel", "", "flags", "describeContents", "CREATOR", "forseti-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ForsetiWidth extends Enum<ForsetiWidth> implements Parcelable {
    public static final ForsetiWidth AVERAGE_LEVEL = null;
    public static final a CREATOR = null;
    public static final ForsetiWidth FIXED_LEVEL1_IN_NARROW_SCREEN_LEFT_SIDE = null;
    public static final ForsetiWidth FIXED_LEVEL1_IN_NARROW_SCREEN_RIGHT_SIDE = null;
    public static final ForsetiWidth FIXED_LEVEL1_IN_WIDE_SCREEN_LEFT_SIDE = null;
    public static final ForsetiWidth FIXED_LEVEL1_IN_WIDE_SCREEN_RIGHT_SIDE = null;
    public static final ForsetiWidth FIXED_LEVEL2_IN_NARROW_SCREEN_LEFT_SIDE = null;
    public static final ForsetiWidth FIXED_LEVEL2_IN_NARROW_SCREEN_RIGHT_SIDE = null;
    public static final ForsetiWidth FIXED_LEVEL2_IN_WIDE_SCREEN_LEFT_SIDE = null;
    public static final ForsetiWidth FIXED_LEVEL2_IN_WIDE_SCREEN_RIGHT_SIDE = null;
    public static final ForsetiWidth FULL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ForsetiWidth[] f408657a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f408658b = null;
    private final int value;

    public static EnumEntries<ForsetiWidth> getEntries() {
        return f408658b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.ss.android.lark.api.bean.ForsetiWidth$a] */
    static {
        ForsetiWidth r100 = new ForsetiWidth("FULL", 0, 0);
        FULL = r100;
        ForsetiWidth r101 = new ForsetiWidth("FIXED_LEVEL1_IN_NARROW_SCREEN_LEFT_SIDE", 1, 10);
        FIXED_LEVEL1_IN_NARROW_SCREEN_LEFT_SIDE = r101;
        ForsetiWidth r102 = new ForsetiWidth("FIXED_LEVEL1_IN_NARROW_SCREEN_RIGHT_SIDE", 2, 15);
        FIXED_LEVEL1_IN_NARROW_SCREEN_RIGHT_SIDE = r102;
        ForsetiWidth r103 = new ForsetiWidth("FIXED_LEVEL1_IN_WIDE_SCREEN_LEFT_SIDE", 3, 20);
        FIXED_LEVEL1_IN_WIDE_SCREEN_LEFT_SIDE = r103;
        ForsetiWidth r104 = new ForsetiWidth("FIXED_LEVEL1_IN_WIDE_SCREEN_RIGHT_SIDE", 4, 25);
        FIXED_LEVEL1_IN_WIDE_SCREEN_RIGHT_SIDE = r104;
        ForsetiWidth r110 = new ForsetiWidth("AVERAGE_LEVEL", 5, 30);
        AVERAGE_LEVEL = r110;
        ForsetiWidth r111 = new ForsetiWidth("FIXED_LEVEL2_IN_NARROW_SCREEN_RIGHT_SIDE", 6, 40);
        FIXED_LEVEL2_IN_NARROW_SCREEN_RIGHT_SIDE = r111;
        ForsetiWidth r112 = new ForsetiWidth("FIXED_LEVEL2_IN_NARROW_SCREEN_LEFT_SIDE", 7, 45);
        FIXED_LEVEL2_IN_NARROW_SCREEN_LEFT_SIDE = r112;
        ForsetiWidth r113 = new ForsetiWidth("FIXED_LEVEL2_IN_WIDE_SCREEN_RIGHT_SIDE", 8, 50);
        FIXED_LEVEL2_IN_WIDE_SCREEN_RIGHT_SIDE = r113;
        ForsetiWidth r105 = new ForsetiWidth("FIXED_LEVEL2_IN_WIDE_SCREEN_LEFT_SIDE", 9, 55);
        FIXED_LEVEL2_IN_WIDE_SCREEN_LEFT_SIDE = r105;
        ForsetiWidth[] r106 = {r100, r101, r102, r103, r104, r110, r111, r112, r113, r105};
        f408657a = r106;
        f408658b = EnumEntriesKt.enumEntries(r106);
        CREATOR = new a();
    }

    public static ForsetiWidth[] values() {
        return (ForsetiWidth[]) f408657a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ForsetiWidth valueOf(String r100) {
        return (ForsetiWidth) r27.a.a(ForsetiWidth.class, r100);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.value);
    }

    public ForsetiWidth(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
