package com.obric.capabilitykit.common;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0001%B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B3\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0017\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J<\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\bH\u0016J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\bHÖ\u0001J\t\u0010!\u001a\u00020\u000bHÖ\u0001J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\bH\u0016R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006&"}, d2 = {"Lcom/obric/capabilitykit/common/FloatingIntentParams;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "position", "Lcom/obric/capabilitykit/common/Position;", "height", "", "ext", "Ljava/util/concurrent/ConcurrentHashMap;", "", "(Lcom/obric/capabilitykit/common/Position;Ljava/lang/Integer;Ljava/util/concurrent/ConcurrentHashMap;)V", "getExt", "()Ljava/util/concurrent/ConcurrentHashMap;", "setExt", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPosition", "()Lcom/obric/capabilitykit/common/Position;", "component1", "component2", "component3", "copy", "(Lcom/obric/capabilitykit/common/Position;Ljava/lang/Integer;Ljava/util/concurrent/ConcurrentHashMap;)Lcom/obric/capabilitykit/common/FloatingIntentParams;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FloatingIntentParams implements Parcelable {
    public static final a CREATOR = null;
    private ConcurrentHashMap<String, String> ext;
    private final Integer height;
    private final Position position;

    public static final class a implements Parcelable.Creator<FloatingIntentParams> {
        public a() {
        }

        public static FloatingIntentParams a(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            r100.readInt();
            FloatingIntentParams r102 = new FloatingIntentParams(r100);
            int r103 = Math.min(r101, 0);
            ClassLoader r104 = a.class.getClassLoader();
            int r105 = 1;
        L3:
            if (r105 > r103) goto L5;
            r105 = r105 + 1;
        L5:
            if (r105 > r101) goto L7;
            joa.a.d(r100, r104);
            r105 = r105 + 1;
            goto L5
        L7:
            return r102;
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ FloatingIntentParams createFromParcel(Parcel r100) {
            return a(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final FloatingIntentParams[] newArray(int r100) {
            return new FloatingIntentParams[r100];
        }
    }

    public FloatingIntentParams() {
        this(null, null, null, 7, null);
    }

    public FloatingIntentParams(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        Object r101 = r100.readValue(Position.class.getClassLoader());
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.capabilitykit.common.Position");
        Position r102 = (Position) r101;
        Object r103 = r100.readValue(Integer.TYPE.getClassLoader());
        ConcurrentHashMap r104 = null;
        if ((r103 instanceof Integer) == false) goto L5;
        Integer r105 = (Integer) r103;
    L6:
        Serializable r106 = r100.readSerializable();
        if ((r106 instanceof ConcurrentHashMap) == false) goto L9;
        r104 = (ConcurrentHashMap) r106;
    L9:
        this(r102, r105, r104);
        return;
    L5:
        r105 = null;
        goto L6
    }

    public FloatingIntentParams(Position r100, Integer r101, ConcurrentHashMap<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "position");
        this.position = r100;
        this.height = r101;
        this.ext = r102;
    }

    public /* synthetic */ FloatingIntentParams(Position r100, Integer r101, ConcurrentHashMap r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = Position.BOTTOM;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FloatingIntentParams copy$default(FloatingIntentParams r100, Position r101, Integer r102, ConcurrentHashMap r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.position;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.height;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.ext;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Position component1() {
        return this.position;
    }

    public final Integer component2() {
        return this.height;
    }

    public final ConcurrentHashMap<String, String> component3() {
        return this.ext;
    }

    public final FloatingIntentParams copy(Position r100, Integer r101, ConcurrentHashMap<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "position");
        return new FloatingIntentParams(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FloatingIntentParams) == true) goto L8;
        return false;
    L8:
        FloatingIntentParams r101 = (FloatingIntentParams) r100;
        if (this.position == r101.position) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final ConcurrentHashMap<String, String> getExt() {
        return this.ext;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Position getPosition() {
        return this.position;
    }

    public int hashCode() {
        int r100 = this.position.hashCode() * 31;
        Integer r101 = this.height;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        ConcurrentHashMap<String, String> r105 = this.ext;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final void setExt(ConcurrentHashMap<String, String> r100) {
        this.ext = r100;
    }

    public String toString() {
        return "FloatingIntentParams(position=" + this.position + ", height=" + this.height + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(0);
        r100.writeValue(this.position);
        r100.writeValue(this.height);
        r100.writeSerializable(this.ext);
    }

    static {
        CREATOR = new a();
    }
}
