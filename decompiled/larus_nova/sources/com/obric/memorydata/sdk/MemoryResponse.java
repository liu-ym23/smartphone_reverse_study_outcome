package com.obric.memorydata.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 **\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001*B)\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\t\u0010 \u001a\u00020\u0004HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0016J6\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0004HÖ\u0001J\t\u0010)\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006+"}, d2 = {"Lcom/obric/memorydata/sdk/MemoryResponse;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/Parcelable;", "code", "", "message", "", "data", "<init>", "(ILjava/lang/String;Ljava/lang/Object;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getCode", "()I", "setCode", "(I)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "isSuccess", "", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "component3", "copy", "(ILjava/lang/String;Ljava/lang/Object;)Lcom/obric/memorydata/sdk/MemoryResponse;", "equals", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryResponse<T> implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f397051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f397052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f397053c;

    public static final class a implements Parcelable.Creator<MemoryResponse<?>> {
        public a() {
        }

        public static MemoryResponse a(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new MemoryResponse(r100.readInt(), r100.readString(), r100.readValue(MemoryResponse.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MemoryResponse<?> createFromParcel(Parcel r100) {
            return a(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final MemoryResponse<?>[] newArray(int r100) {
            return new MemoryResponse[r100];
        }
    }

    public MemoryResponse() {
        int r100 = 0;
        this(r100, null, 7);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MemoryResponse) == true) goto L8;
        return false;
    L8:
        MemoryResponse r101 = (MemoryResponse) r100;
        if (this.f397051a == r101.f397051a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397052b, r101.f397052b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f397053c, r101.f397053c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f397051a * 31;
        String r101 = this.f397052b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        T r105 = this.f397053c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MemoryResponse(code=" + this.f397051a + ", message=" + this.f397052b + ", data=" + this.f397053c + ')';
    }

    static {
        CREATOR = new a();
    }

    public final boolean a() {
        if (this.f397051a != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.f397051a);
        r100.writeString(this.f397052b);
        r100.writeValue(this.f397053c);
    }

    public /* synthetic */ MemoryResponse(int r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101, null);
    }

    public MemoryResponse(int r100, String r101, T r102) {
        this.f397051a = r100;
        this.f397052b = r101;
        this.f397053c = r102;
    }
}
