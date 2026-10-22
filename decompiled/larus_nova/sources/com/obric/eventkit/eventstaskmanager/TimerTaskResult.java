package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0001&B+\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f¢\u0006\u0004\b\"\u0010#B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010$J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0012\b\u0002\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0001J\t\u0010\u0013\u001a\u00020\nHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003R\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR!\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010!¨\u0006'"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/TimerTaskResult;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "component1", "", "component2", "", "Lcom/obric/eventkit/eventstaskmanager/TimerTask;", "component3", "code", "msg", "data", "copy", "toString", "hashCode", "", "other", "", "equals", "I", "getCode", "()I", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "Ljava/util/List;", "getData", "()Ljava/util/List;", "<init>", "(ILjava/lang/String;Ljava/util/List;)V", "(Landroid/os/Parcel;)V", "CREATOR", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class TimerTaskResult implements Parcelable {
    public static final a CREATOR = null;
    private final int code;
    private final List<TimerTask> data;
    private final String msg;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<TimerTaskResult> {
        public static TimerTaskResult a(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new TimerTaskResult(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TimerTaskResult createFromParcel(Parcel r100) {
            return a(r100);
        }

        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TimerTaskResult[] newArray(int r100) {
            return new TimerTaskResult[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public TimerTaskResult(int r100, String r101, List<TimerTask> r102) {
        this.code = r100;
        this.msg = r101;
        this.data = r102;
    }

    public TimerTaskResult(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this(r100.readInt(), r100.readString(), r100.createTypedArrayList(TimerTask.CREATOR));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TimerTaskResult copy$default(TimerTaskResult r100, int r101, String r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.code;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.msg;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.data;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final List<TimerTask> component3() {
        return this.data;
    }

    public final TimerTaskResult copy(int r100, String r101, List<TimerTask> r102) {
        return new TimerTaskResult(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TimerTaskResult) == true) goto L8;
        return false;
    L8:
        TimerTaskResult r101 = (TimerTaskResult) r100;
        if (this.code == r101.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int getCode() {
        return this.code;
    }

    public final List<TimerTask> getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        int r100 = this.code * 31;
        String r101 = this.msg;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        List<TimerTask> r105 = this.data;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "TimerTaskResult(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.code);
        r100.writeString(this.msg);
        r100.writeTypedList(this.data);
    }
}
