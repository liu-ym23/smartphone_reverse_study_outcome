package com.obric.aiagent.assistant.idl.bean;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 42\u00020\u0001:\u00014Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010B\u0011\b\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u000f\u0010\u0013J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u0003H\u0017J\b\u0010%\u001a\u00020\u0003H\u0016J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\u0019\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000eHÆ\u0003Jo\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000eHÆ\u0001J\u0013\u0010/\u001a\u00020\u000b2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\u0003HÖ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001cR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR*\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u00065"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/StateInfo;", "Landroid/os/Parcelable;", "requestType", "", "content", "", "refMessageId", "taskType", "timeOut", "", "isInIsland", "", "startWithAsr", "ext", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JZZLjava/util/Map;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getRequestType", "()I", "getContent", "()Ljava/lang/String;", "getRefMessageId", "getTaskType", "getTimeOut", "()J", "()Z", "getStartWithAsr", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "CREATOR", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StateInfo implements Parcelable {
    public static final a CREATOR = null;
    private final String content;
    private Map<String, String> ext;
    private final boolean isInIsland;
    private final String refMessageId;
    private final int requestType;
    private final boolean startWithAsr;
    private final String taskType;
    private final long timeOut;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<StateInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final StateInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new StateInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final StateInfo[] newArray(int r100) {
            return new StateInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StateInfo copy$default(StateInfo r110, int r111, String r112, String r113, String r114, long r115, boolean r116, boolean r117, Map r118, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        int r100 = r110.requestType;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.content;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.refMessageId;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.taskType;
    L19:
        if ((r210 & 16) == 0) goto L21;
        long r104 = r110.timeOut;
    L23:
        if ((r210 & 32) == 0) goto L25;
        boolean r105 = r110.isInIsland;
    L27:
        if ((r210 & 64) == 0) goto L29;
        boolean r106 = r110.startWithAsr;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Map r107 = r110.ext;
    L35:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107);
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final int component1() {
        return this.requestType;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.refMessageId;
    }

    public final String component4() {
        return this.taskType;
    }

    public final long component5() {
        return this.timeOut;
    }

    public final boolean component6() {
        return this.isInIsland;
    }

    public final boolean component7() {
        return this.startWithAsr;
    }

    public final Map<String, String> component8() {
        return this.ext;
    }

    public final StateInfo copy(int r110, String r111, String r112, String r113, long r114, boolean r115, boolean r116, Map<String, String> r210) {
        return new StateInfo(r110, r111, r112, r113, r114, r115, r116, r210);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof StateInfo) == true) goto L8;
        return false;
    L8:
        StateInfo r101 = (StateInfo) r100;
        if (this.requestType == r101.requestType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.refMessageId, r101.refMessageId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.taskType, r101.taskType) == true) goto L21;
        return false;
    L21:
        if (this.timeOut == r101.timeOut) goto L24;
        return false;
    L24:
        if (this.isInIsland == r101.isInIsland) goto L27;
        return false;
    L27:
        if (this.startWithAsr == r101.startWithAsr) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = this.requestType * 31;
        String r101 = this.content;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.refMessageId;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.taskType;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        long r110 = this.timeOut;
        int r111 = (((r107 + r109) * 31) + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        int r112 = 1231;
        if (this.isInIsland == false) goto L17;
        int r113 = 1231;
    L18:
        int r114 = (r111 + r113) * 31;
        if (this.startWithAsr == true) goto L22;
        r112 = 1237;
    L22:
        int r115 = (r114 + r112) * 31;
        Map<String, String> r116 = this.ext;
        if (r116 == null) goto L27;
        r102 = r116.hashCode();
    L27:
        return r115 + r102;
    L17:
        r113 = 1237;
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "StateInfo(requestType=" + this.requestType + ", content=" + this.content + ", refMessageId=" + this.refMessageId + ", taskType=" + this.taskType + ", timeOut=" + this.timeOut + ", isInIsland=" + this.isInIsland + ", startWithAsr=" + this.startWithAsr + ", ext=" + this.ext + ')';
    }

    public final String getContent() {
        return this.content;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final String getRefMessageId() {
        return this.refMessageId;
    }

    public final int getRequestType() {
        return this.requestType;
    }

    public final boolean getStartWithAsr() {
        return this.startWithAsr;
    }

    public final String getTaskType() {
        return this.taskType;
    }

    public final long getTimeOut() {
        return this.timeOut;
    }

    public final boolean isInIsland() {
        return this.isInIsland;
    }

    public StateInfo(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        this(r110.readInt(), r110.readString(), r110.readString(), r110.readString(), r110.readLong(), r110.readBoolean(), r110.readBoolean(), null, 128, null);
        if (Build.VERSION.SDK_INT < 33) goto L7;
        LinkedHashMap r100 = new LinkedHashMap();
        r110.readMap(r100, StateInfo.class.getClassLoader(), String.class, String.class);
        if ((!r100.isEmpty()) == false) goto L21;
        this.ext = r100;
        return;
    L21:
        return;
    L7:
        Bundle r111 = r110.readBundle(StateInfo.class.getClassLoader());
        if (r111 == null) goto L23;
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<T> r102 = r111.keySet().iterator();
    L11:
        if (r102.hasNext() == false) goto L16;
        String r103 = (String) r102.next();
        String r104 = r111.getString(r103);
        if (r104 != null) goto L15;
        r104 = "";
    L15:
        r101.put(r103, r104);
        goto L11
    L16:
        this.ext = r101;
        return;
    }

    public final void setExt(Map<String, String> r100) {
        this.ext = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.requestType);
        r100.writeString(this.content);
        r100.writeString(this.refMessageId);
        r100.writeString(this.taskType);
        r100.writeLong(this.timeOut);
        r100.writeBoolean(this.isInIsland);
        r100.writeBoolean(this.startWithAsr);
        if (Build.VERSION.SDK_INT < 33) goto L5;
        r100.writeMap(this.ext);
        return;
    L5:
        Bundle r102 = new Bundle();
        Map<String, String> r103 = this.ext;
        if (r103 == null) goto L11;
        Iterator<Map.Entry<String, String>> r104 = r103.entrySet().iterator();
    L9:
        if (r104.hasNext() == false) goto L11;
        Map.Entry<String, String> r105 = r104.next();
        r102.putString(r105.getKey(), r105.getValue());
    L11:
        r100.writeBundle(r102);
    }

    public StateInfo(int r100, String r101, String r102, String r103, long r104, boolean r105, boolean r106, Map<String, String> r107) {
        this.requestType = r100;
        this.content = r101;
        this.refMessageId = r102;
        this.taskType = r103;
        this.timeOut = r104;
        this.isInIsland = r105;
        this.startWithAsr = r106;
        this.ext = r107;
    }

    public /* synthetic */ StateInfo(int r110, String r111, String r112, String r113, long r114, boolean r210, boolean r211, Map r212, int r213, DefaultConstructorMarker r214) {
        if ((r213 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r213 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r213 & 16) == 0) goto L13;
        long r102 = 0;
    L15:
        if ((r213 & 32) == 0) goto L17;
        boolean r115 = false;
    L19:
        if ((r213 & 64) == 0) goto L21;
        boolean r116 = false;
    L23:
        if ((r213 & 128) == 0) goto L25;
        Map r117 = null;
    L26:
        this(r110, r100, r112, r101, r102, r115, r116, r117);
        return;
    L25:
        r117 = r212;
        goto L26
    L21:
        r116 = r211;
        goto L23
    L17:
        r115 = r210;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
