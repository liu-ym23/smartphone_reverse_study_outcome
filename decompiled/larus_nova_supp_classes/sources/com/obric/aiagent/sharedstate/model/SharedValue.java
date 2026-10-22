package com.obric.aiagent.sharedstate.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0013\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0016\u0010\u0017B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0015\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\tHÖ\u0003R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/obric/aiagent/sharedstate/model/SharedValue;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", XmlPullParser.NO_NAMESPACE, "flags", XmlPullParser.NO_NAMESPACE, "writeToParcel", "describeContents", XmlPullParser.NO_NAMESPACE, "component1", "value", "copy", XmlPullParser.NO_NAMESPACE, "toString", "hashCode", "other", XmlPullParser.NO_NAMESPACE, "equals", "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "<init>", "(Ljava/lang/Object;)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "shared-state-sdk_release"}, k = 1, mv = {1, 7, 0})
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
        public final SharedValue createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new SharedValue(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final SharedValue[] newArray(int r1) {
            return new SharedValue[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public SharedValue() {
        DefaultConstructorMarker r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ SharedValue copy$default(SharedValue r0, Object r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.value;
    L6:
        return r0.copy(r1);
    }

    public final Object component1() {
        return this.value;
    }

    public final SharedValue copy(Object r2) {
        return new SharedValue(r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof SharedValue) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.value, ((SharedValue) r4).value) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        Object r0 = this.value;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "SharedValue(value=" + this.value + ')';
    }

    public final Object getValue() {
        return this.value;
    }

    public SharedValue(Parcel r3) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        CREATOR.getClass();
        switch(r3.readInt()) {
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
        Serializable r4 = r3.readSerializable();
    L17:
        this(r4);
        return;
    L6:
        r4 = r3.readString();
        goto L17
    L7:
        r4 = Double.valueOf(r3.readDouble());
        goto L17
    L8:
        r4 = Float.valueOf(r3.readFloat());
        goto L17
    L9:
        r4 = Long.valueOf(r3.readLong());
        goto L17
    L10:
        r4 = Integer.valueOf(r3.readInt());
        goto L17
    L11:
        boolean r0 = true;
        if (r3.readInt() == 1) goto L15;
        r0 = false;
    L15:
        r4 = Boolean.valueOf(r0);
        goto L17
    L16:
        r4 = null;
        goto L17
    }

    public SharedValue(Object r1) {
        this.value = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        a r5 = CREATOR;
        Object r0 = this.value;
        r5.getClass();
        if (r0 != null) goto L6;
        r3.writeInt(0);
        return;
    L6:
        if ((r0 instanceof Boolean) == false) goto L9;
        r3.writeInt(1);
        r3.writeInt(((Boolean) r0).booleanValue() ? 1 : 0);
        return;
    L9:
        if ((r0 instanceof Integer) == false) goto L12;
        r3.writeInt(2);
        r3.writeInt(((Number) r0).intValue());
        return;
    L12:
        if ((r0 instanceof Long) == false) goto L15;
        r3.writeInt(3);
        r3.writeLong(((Number) r0).longValue());
        return;
    L15:
        if ((r0 instanceof Float) == false) goto L18;
        r3.writeInt(4);
        r3.writeFloat(((Number) r0).floatValue());
        return;
    L18:
        if ((r0 instanceof Double) == false) goto L21;
        r3.writeInt(5);
        r3.writeDouble(((Number) r0).doubleValue());
        return;
    L21:
        if ((r0 instanceof String) == false) goto L24;
        r3.writeInt(6);
        r3.writeString((String) r0);
        return;
    L24:
        if ((r0 instanceof Serializable) == false) goto L28;
        r3.writeInt(7);
        r3.writeSerializable((Serializable) r0);
        return;
    L28:
        throw new IllegalArgumentException("Unsupported type: ".concat(r0.getClass().getName()));
    }

    public /* synthetic */ SharedValue(Object r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
