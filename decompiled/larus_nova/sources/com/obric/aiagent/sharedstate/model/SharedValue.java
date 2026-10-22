package com.obric.aiagent.sharedstate.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0013\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0016\u0010\u0017B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0015\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\tHÖ\u0003R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/obric/aiagent/sharedstate/model/SharedValue;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "", "component1", "value", "copy", "", "toString", "hashCode", "other", "", "equals", "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "<init>", "(Ljava/lang/Object;)V", "(Landroid/os/Parcel;)V", "CREATOR", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "shared-state-sdk_release"}, k = 1, mv = {1, 7, 0})
public final class SharedValue implements Parcelable {
    public static final a CREATOR = null;
    private static final int TYPE_BOOLEAN = 1;
    private static final int TYPE_DOUBLE = 5;
    private static final int TYPE_FLOAT = 4;
    private static final int TYPE_INT = 2;
    private static final int TYPE_LONG = 3;
    private static final int TYPE_NULL = 0;
    private static final int TYPE_SERIALIZABLE = 7;
    private static final int TYPE_STRING = 6;
    private final Object value;

    public static final class a implements Parcelable.Creator<SharedValue> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SharedValue createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new SharedValue(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SharedValue[] newArray(int r100) {
            return new SharedValue[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public SharedValue() {
        DefaultConstructorMarker r100 = null;
        this(r100, 1, r100);
    }

    public static /* synthetic */ SharedValue copy$default(SharedValue r100, Object r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.value;
    L6:
        return r100.copy(r101);
    }

    public final Object component1() {
        return this.value;
    }

    public final SharedValue copy(Object r100) {
        return new SharedValue(r100);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SharedValue) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.value, ((SharedValue) r100).value) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        Object r100 = this.value;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "SharedValue(value=" + this.value + ')';
    }

    public final Object getValue() {
        return this.value;
    }

    public SharedValue(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        CREATOR.getClass();
        switch(r100.readInt()) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L16;
        };
    L5:
        Serializable r101 = r100.readSerializable();
    L17:
        this(r101);
        return;
    L6:
        r101 = r100.readString();
        goto L17
    L7:
        r101 = Double.valueOf(r100.readDouble());
        goto L17
    L8:
        r101 = Float.valueOf(r100.readFloat());
        goto L17
    L9:
        r101 = Long.valueOf(r100.readLong());
        goto L17
    L10:
        r101 = Integer.valueOf(r100.readInt());
        goto L17
    L11:
        boolean r102 = true;
        if (r100.readInt() == 1) goto L15;
        r102 = false;
    L15:
        r101 = Boolean.valueOf(r102);
        goto L17
    L16:
        r101 = null;
        goto L17
    }

    public SharedValue(Object r100) {
        this.value = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        a r102 = CREATOR;
        Object r103 = this.value;
        r102.getClass();
        if (r103 != null) goto L6;
        r100.writeInt(0);
        return;
    L6:
        if ((r103 instanceof Boolean) == false) goto L9;
        r100.writeInt(1);
        r100.writeInt(((Boolean) r103).booleanValue() ? 1 : 0);
        return;
    L9:
        if ((r103 instanceof Integer) == false) goto L12;
        r100.writeInt(2);
        r100.writeInt(((Number) r103).intValue());
        return;
    L12:
        if ((r103 instanceof Long) == false) goto L15;
        r100.writeInt(3);
        r100.writeLong(((Number) r103).longValue());
        return;
    L15:
        if ((r103 instanceof Float) == false) goto L18;
        r100.writeInt(4);
        r100.writeFloat(((Number) r103).floatValue());
        return;
    L18:
        if ((r103 instanceof Double) == false) goto L21;
        r100.writeInt(5);
        r100.writeDouble(((Number) r103).doubleValue());
        return;
    L21:
        if ((r103 instanceof String) == false) goto L24;
        r100.writeInt(6);
        r100.writeString((String) r103);
        return;
    L24:
        if ((r103 instanceof Serializable) == false) goto L28;
        r100.writeInt(7);
        r100.writeSerializable((Serializable) r103);
        return;
    L28:
        throw new IllegalArgumentException("Unsupported type: ".concat(r103.getClass().getName()));
    }

    public /* synthetic */ SharedValue(Object r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
