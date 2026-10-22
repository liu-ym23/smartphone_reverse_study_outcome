package com.obric.memorydata.sdk.awareness;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0001&B.\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000b\u0010\u0004\u001a\u00070\u0005¢\u0006\u0002\b\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000e\u0010\u0016\u001a\u00070\u0005¢\u0006\u0002\b\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J6\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\r\b\u0002\u0010\u0004\u001a\u00070\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\u001f\u001a\u00020\u001bHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00070\u0005¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/AwarenessEventData;", "Landroid/os/Parcelable;", "key", "", "value", "", "Lkotlinx/parcelize/RawValue;", "timestamp", "", "extras", "Landroid/os/Bundle;", "<init>", "(Ljava/lang/String;Ljava/lang/Object;JLandroid/os/Bundle;)V", "getKey", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "getTimestamp", "()J", "getExtras", "()Landroid/os/Bundle;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AwarenessEventData implements Parcelable {
    public static final Parcelable.Creator<AwarenessEventData> CREATOR = null;
    private static final a Companion = null;
    private final Bundle extras;
    private final String key;
    private final long timestamp;
    private final Object value;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Parcelable.Creator<AwarenessEventData> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final AwarenessEventData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new AwarenessEventData(r100.readString(), r100.readValue(AwarenessEventData.class.getClassLoader()), r100.readLong(), r100.readBundle(AwarenessEventData.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final AwarenessEventData[] newArray(int r100) {
            return new AwarenessEventData[r100];
        }
    }

    static {
        Companion = new a();
        CREATOR = new b();
    }

    public static /* synthetic */ AwarenessEventData copy$default(AwarenessEventData r100, String r101, Object r102, long r103, Bundle r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.key;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.value;
    L8:
        Object r111 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.timestamp;
    L11:
        long r106 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.extras;
    L14:
        String r107 = r101;
        return r100.copy(r107, r111, r106, r104);
    }

    public final String component1() {
        return this.key;
    }

    public final Object component2() {
        return this.value;
    }

    public final long component3() {
        return this.timestamp;
    }

    public final Bundle component4() {
        return this.extras;
    }

    public final AwarenessEventData copy(String r100, Object r101, long r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        Intrinsics.checkNotNullParameter(r111, "extras");
        return new AwarenessEventData(r100, r101, r110, r111);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AwarenessEventData) == true) goto L8;
        return false;
    L8:
        AwarenessEventData r101 = (AwarenessEventData) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.value, r101.value) == true) goto L15;
        return false;
    L15:
        if (this.timestamp == r101.timestamp) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extras, r101.extras) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.key.hashCode() * 31) + this.value.hashCode()) * 31;
        long r101 = this.timestamp;
        return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.extras.hashCode();
    }

    public String toString() {
        return "AwarenessEventData(key=" + this.key + ", value=" + this.value + ", timestamp=" + this.timestamp + ", extras=" + this.extras + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.key);
        r100.writeValue(this.value);
        r100.writeLong(this.timestamp);
        r100.writeBundle(this.extras);
    }

    public final Bundle getExtras() {
        return this.extras;
    }

    public final String getKey() {
        return this.key;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final Object getValue() {
        return this.value;
    }

    public AwarenessEventData(String r100, Object r101, long r102, Bundle r103) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        Intrinsics.checkNotNullParameter(r103, "extras");
        this.key = r100;
        this.value = r101;
        this.timestamp = r102;
        this.extras = r103;
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r101, "value");
        if ((r101 instanceof Boolean) == false) goto L5;
    L22:
        boolean r104 = true;
    L23:
        if (r104 == false) goto L26;
        return;
    L26:
        throw new IllegalArgumentException("AwarenessEventData.value 仅支持基础类型和 String".toString());
    L5:
        if ((r101 instanceof Byte) == true) goto L22;
        if ((r101 instanceof Character) == true) goto L22;
        if ((r101 instanceof Short) == true) goto L22;
        if ((r101 instanceof Integer) == true) goto L22;
        if ((r101 instanceof Long) == true) goto L22;
        if ((r101 instanceof Float) == true) goto L22;
        if ((r101 instanceof Double) == true) goto L22;
        if ((r101 instanceof String) == true) goto L22;
        r104 = false;
        goto L23
    }

    public /* synthetic */ AwarenessEventData(String r100, Object r101, long r102, Bundle r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 8) == 0) goto L5;
        r110 = Bundle.EMPTY;
    L5:
        this(r100, r101, r102, r110);
    }
}
