package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ConditionTaskResult;", "Landroid/os/Parcelable;", "code", "", "msg", "", "data", "", "Lcom/obric/eventkit/eventstaskmanager/ConditionTask;", "(ILjava/lang/String;Ljava/util/List;)V", "getCode", "()I", "getData", "()Ljava/util/List;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ConditionTaskResult implements Parcelable {
    public static final Parcelable.Creator<ConditionTaskResult> CREATOR = null;
    private final int code;
    private final List<ConditionTask> data;
    private final String msg;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<ConditionTaskResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ConditionTaskResult createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            int r101 = r110.readInt();
            String r102 = r110.readString();
            ArrayList r103 = null;
            if (r110.readInt() == 0) goto L13;
            int r104 = r110.readInt();
            ArrayList r105 = new ArrayList(r104);
            int r106 = 0;
        L6:
            if (r106 == r104) goto L12;
            if (r110.readInt() != 0) goto L10;
            ConditionTask r107 = null;
        L11:
            r105.add(r107);
            r106 = r106 + 1;
            goto L6
        L10:
            r107 = ConditionTask.CREATOR.createFromParcel(r110);
            goto L11
        L12:
            r103 = r105;
        L13:
            ConditionTaskResult r108 = new ConditionTaskResult(r101, r102, r103);
            int r109 = Math.min(r100, 0);
            ClassLoader r111 = a.class.getClassLoader();
            int r112 = 1;
        L14:
            if (r112 > r109) goto L16;
            r112 = r112 + 1;
        L16:
            if (r112 > r100) goto L18;
            joa.a.d(r110, r111);
            r112 = r112 + 1;
            goto L16
        L18:
            return r108;
        }

        @Override // android.os.Parcelable.Creator
        public final ConditionTaskResult[] newArray(int r100) {
            return new ConditionTaskResult[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ConditionTaskResult(int r100, String r101, List<ConditionTask> r102) {
        this.code = r100;
        this.msg = r101;
        this.data = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConditionTaskResult copy$default(ConditionTaskResult r100, int r101, String r102, List r103, int r104, Object r105) {
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

    public final List<ConditionTask> component3() {
        return this.data;
    }

    public final ConditionTaskResult copy(int r100, String r101, List<ConditionTask> r102) {
        return new ConditionTaskResult(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ConditionTaskResult) == true) goto L8;
        return false;
    L8:
        ConditionTaskResult r101 = (ConditionTaskResult) r100;
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

    public final List<ConditionTask> getData() {
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
        List<ConditionTask> r105 = this.data;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "ConditionTaskResult(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeInt(this.code);
        r100.writeString(this.msg);
        List<ConditionTask> r102 = this.data;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<ConditionTask> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L19;
        ConditionTask r104 = r103.next();
        if (r104 == null) goto L10;
        r100.writeInt(1);
        r104.writeToParcel(r100, r101);
        goto L7
    L10:
        r100.writeInt(0);
        goto L7
    }
}
