package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006#"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/EventTaskResult;", "Landroid/os/Parcelable;", "code", "", "msg", "", "data", "", "Lcom/obric/eventkit/eventstaskmanager/EventTask;", "detailReason", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getCode", "()I", "getData", "()Ljava/util/List;", "getDetailReason", "()Ljava/lang/String;", "getMsg", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EventTaskResult implements Parcelable {
    public static final Parcelable.Creator<EventTaskResult> CREATOR = null;
    private final int code;
    private final List<EventTask> data;
    private final String detailReason;
    private final String msg;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<EventTaskResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final EventTaskResult createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            int r102 = r100.readInt();
            String r103 = r100.readString();
            if (r100.readInt() != 0) goto L5;
            ArrayList r104 = null;
        L9:
            EventTaskResult r105 = new EventTaskResult(r102, r103, r104, r100.readString());
            int r106 = Math.min(r101, 0);
            ClassLoader r107 = a.class.getClassLoader();
            int r108 = 1;
        L10:
            if (r108 > r106) goto L12;
            r108 = r108 + 1;
        L12:
            if (r108 > r101) goto L14;
            joa.a.d(r100, r107);
            r108 = r108 + 1;
            goto L12
        L14:
            return r105;
        L5:
            int r109 = r100.readInt();
            ArrayList r110 = new ArrayList(r109);
            int r111 = 0;
        L6:
            if (r111 == r109) goto L8;
            r110.add(r100.readParcelable(EventTaskResult.class.getClassLoader()));
            r111 = r111 + 1;
            goto L6
        L8:
            r104 = r110;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final EventTaskResult[] newArray(int r100) {
            return new EventTaskResult[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EventTaskResult(int r100, String r101, List<? extends EventTask> r102, String r103) {
        this.code = r100;
        this.msg = r101;
        this.data = r102;
        this.detailReason = r103;
    }

    public /* synthetic */ EventTaskResult(int r100, String r101, List r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 8) == 0) goto L5;
        r103 = null;
    L5:
        this(r100, r101, r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventTaskResult copy$default(EventTaskResult r100, int r101, String r102, List r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.code;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.msg;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.data;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.detailReason;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final List<EventTask> component3() {
        return this.data;
    }

    public final String component4() {
        return this.detailReason;
    }

    public final EventTaskResult copy(int r100, String r101, List<? extends EventTask> r102, String r103) {
        return new EventTaskResult(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EventTaskResult) == true) goto L8;
        return false;
    L8:
        EventTaskResult r101 = (EventTaskResult) r100;
        if (this.code == r101.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.detailReason, r101.detailReason) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int getCode() {
        return this.code;
    }

    public final List<EventTask> getData() {
        return this.data;
    }

    public final String getDetailReason() {
        return this.detailReason;
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
        List<EventTask> r105 = this.data;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.detailReason;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "EventTaskResult(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ", detailReason=" + this.detailReason + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeInt(this.code);
        r100.writeString(this.msg);
        List<EventTask> r102 = this.data;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L9:
        r100.writeString(this.detailReason);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<EventTask> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        r100.writeParcelable(r103.next(), r101);
        goto L7
    }
}
