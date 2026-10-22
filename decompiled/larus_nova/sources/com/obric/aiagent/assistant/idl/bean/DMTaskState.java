package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u0017\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tHÆ\u0003JA\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tHÆ\u0001J\u0006\u0010\u0019\u001a\u00020\u0007J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006%"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/DMTaskState;", "Landroid/os/Parcelable;", DBDefinition.TASK_ID, "", "taskInfo", "Lcom/obric/aiagent/assistant/idl/bean/DMTaskInfo;", "state", "", "extra", "", "<init>", "(Ljava/lang/String;Lcom/obric/aiagent/assistant/idl/bean/DMTaskInfo;ILjava/util/Map;)V", "getTaskId", "()Ljava/lang/String;", "getTaskInfo", "()Lcom/obric/aiagent/assistant/idl/bean/DMTaskInfo;", "getState", "()I", "getExtra", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DMTaskState implements Parcelable {
    public static final Parcelable.Creator<DMTaskState> CREATOR = null;
    private final Map<String, String> extra;
    private final int state;
    private final String taskId;
    private final DMTaskInfo taskInfo;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<DMTaskState> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DMTaskState createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            if (r100.readInt() != 0) goto L5;
            DMTaskInfo r102 = null;
        L6:
            DMTaskInfo r103 = r102;
            int r104 = r100.readInt();
            int r105 = r100.readInt();
            LinkedHashMap r106 = new LinkedHashMap(r105);
            int r107 = 0;
        L7:
            if (r107 == r105) goto L10;
            r106.put(r100.readString(), r100.readString());
            r107 = r107 + 1;
            goto L7
        L10:
            return new DMTaskState(r101, r103, r104, r106);
        L5:
            r102 = DMTaskInfo.CREATOR.createFromParcel(r100);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final DMTaskState[] newArray(int r100) {
            return new DMTaskState[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DMTaskState copy$default(DMTaskState r100, String r101, DMTaskInfo r102, int r103, Map r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.taskId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.taskInfo;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.state;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.extra;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.taskId;
    }

    public final DMTaskInfo component2() {
        return this.taskInfo;
    }

    public final int component3() {
        return this.state;
    }

    public final Map<String, String> component4() {
        return this.extra;
    }

    public final DMTaskState copy(String r100, DMTaskInfo r101, int r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r103, "extra");
        return new DMTaskState(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DMTaskState) == true) goto L8;
        return false;
    L8:
        DMTaskState r101 = (DMTaskState) r100;
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.taskInfo, r101.taskInfo) == true) goto L15;
        return false;
    L15:
        if (this.state == r101.state) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = this.taskId.hashCode() * 31;
        DMTaskInfo r101 = this.taskInfo;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((r100 + r102) * 31) + this.state) * 31) + this.extra.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "DMTaskState(taskId=" + this.taskId + ", taskInfo=" + this.taskInfo + ", state=" + this.state + ", extra=" + this.extra + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.taskId);
        DMTaskInfo r102 = this.taskInfo;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeInt(this.state);
        Map<String, String> r103 = this.extra;
        r100.writeInt(r103.size());
        Iterator<Map.Entry<String, String>> r104 = r103.entrySet().iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        Map.Entry<String, String> r105 = r104.next();
        r100.writeString(r105.getKey());
        r100.writeString(r105.getValue());
        goto L8
    L10:
        return;
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
        goto L6
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final int getState() {
        return this.state;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final DMTaskInfo getTaskInfo() {
        return this.taskInfo;
    }

    public DMTaskState(String r100, DMTaskInfo r101, int r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r103, "extra");
        this.taskId = r100;
        this.taskInfo = r101;
        this.state = r102;
        this.extra = r103;
    }

    public /* synthetic */ DMTaskState(String r100, DMTaskInfo r101, int r102, Map r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = MapsKt.emptyMap();
    L8:
        this(r100, r101, r102, r103);
    }
}
