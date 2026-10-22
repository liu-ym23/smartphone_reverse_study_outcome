package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014JJ\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0005J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006)"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/PicInfo;", "Landroid/os/Parcelable;", "tosKey", "", "width", "", "height", "resId", "time", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;)V", "getTosKey", "()Ljava/lang/String;", "getWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "getResId", "getTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;)Lcom/obric/aiagent/assistant/idl/bean/PicInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PicInfo implements Parcelable {
    public static final Parcelable.Creator<PicInfo> CREATOR = null;
    private final Integer height;
    private final String resId;
    private final Long time;
    private final String tosKey;
    private final Integer width;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<PicInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PicInfo createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            if (r110.readInt() != 0) goto L5;
            Integer r101 = null;
        L7:
            if (r110.readInt() != 0) goto L9;
            Integer r102 = null;
        L10:
            String r103 = r110.readString();
            if (r110.readInt() != 0) goto L13;
            Long r111 = null;
        L15:
            return new PicInfo(r100, r101, r102, r103, r111);
        L13:
            r111 = Long.valueOf(r110.readLong());
            goto L15
        L9:
            r102 = Integer.valueOf(r110.readInt());
            goto L10
        L5:
            r101 = Integer.valueOf(r110.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final PicInfo[] newArray(int r100) {
            return new PicInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public PicInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ PicInfo copy$default(PicInfo r100, String r101, Integer r102, Integer r103, String r104, Long r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.tosKey;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.width;
    L8:
        Integer r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.height;
    L11:
        Integer r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.resId;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.time;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.tosKey;
    }

    public final Integer component2() {
        return this.width;
    }

    public final Integer component3() {
        return this.height;
    }

    public final String component4() {
        return this.resId;
    }

    public final Long component5() {
        return this.time;
    }

    public final PicInfo copy(String r100, Integer r101, Integer r110, String r111, Long r112) {
        return new PicInfo(r100, r101, r110, r111, r112);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PicInfo) == true) goto L8;
        return false;
    L8:
        PicInfo r101 = (PicInfo) r100;
        if (Intrinsics.areEqual(this.tosKey, r101.tosKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.resId, r101.resId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.time, r101.time) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.tosKey;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.width;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.height;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.resId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.time;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PicInfo(tosKey=" + this.tosKey + ", width=" + this.width + ", height=" + this.height + ", resId=" + this.resId + ", time=" + this.time + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.tosKey);
        Integer r102 = this.width;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Integer r103 = this.height;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        r100.writeString(this.resId);
        Long r104 = this.time;
        if (r104 != null) goto L13;
        r100.writeInt(0);
        return;
    L13:
        r100.writeInt(1);
        r100.writeLong(r104.longValue());
        return;
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.intValue());
        goto L6
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getResId() {
        return this.resId;
    }

    public final Long getTime() {
        return this.time;
    }

    public final String getTosKey() {
        return this.tosKey;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public PicInfo(String r100, Integer r101, Integer r102, String r103, Long r104) {
        this.tosKey = r100;
        this.width = r101;
        this.height = r102;
        this.resId = r103;
        this.time = r104;
    }

    public /* synthetic */ PicInfo(String r100, Integer r101, Integer r102, String r103, Long r104, int r105, DefaultConstructorMarker r110) {
        String r106 = "";
        if ((r105 & 1) == 0) goto L5;
        String r111 = "";
    L7:
        if ((r105 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        Integer r107 = r101;
        if ((r105 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        Integer r108 = r102;
        if ((r105 & 8) != 0) goto L17;
        r106 = r103;
    L17:
        if ((r105 & 16) == 0) goto L19;
        r104 = 0L;
    L19:
        Long r109 = r104;
        this(r111, r107, r108, r106, r109);
        return;
    L5:
        r111 = r100;
        goto L7
    }
}
