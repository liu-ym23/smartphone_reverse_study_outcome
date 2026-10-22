package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0017\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\\\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010#J\u0006\u0010$\u001a\u00020\u0005J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u0005HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\u0016\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u00060"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/DMTaskInfo;", "Landroid/os/Parcelable;", DBDefinition.TASK_ID, "", "taskType", "", "message", "Lcom/obric/aiagent/assistant/idl/bean/IMMessage;", "createdTime", "", "progress", "ext", "", "<init>", "(Ljava/lang/String;ILcom/obric/aiagent/assistant/idl/bean/IMMessage;JLjava/lang/Integer;Ljava/util/Map;)V", "getTaskId", "()Ljava/lang/String;", "getTaskType", "()I", "getMessage", "()Lcom/obric/aiagent/assistant/idl/bean/IMMessage;", "getCreatedTime", "()J", "getProgress", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExt", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;ILcom/obric/aiagent/assistant/idl/bean/IMMessage;JLjava/lang/Integer;Ljava/util/Map;)Lcom/obric/aiagent/assistant/idl/bean/DMTaskInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DMTaskInfo implements Parcelable {
    public static final Parcelable.Creator<DMTaskInfo> CREATOR = null;
    private final long createdTime;
    private final Map<String, String> ext;
    private final IMMessage message;
    private final Integer progress;
    private final String taskId;
    private final int taskType;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<DMTaskInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DMTaskInfo createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            int r101 = r110.readInt();
            LinkedHashMap r102 = null;
            if (r110.readInt() != 0) goto L5;
            IMMessage r103 = null;
        L6:
            IMMessage r104 = r103;
            long r105 = r110.readLong();
            if (r110.readInt() != 0) goto L9;
            Integer r106 = null;
        L11:
            if (r110.readInt() == 0) goto L17;
            int r107 = r110.readInt();
            r102 = new LinkedHashMap(r107);
            int r108 = 0;
        L14:
            if (r108 == r107) goto L17;
            r102.put(r110.readString(), r110.readString());
            r108 = r108 + 1;
        L17:
            return new DMTaskInfo(r100, r101, r104, r105, r106, r102);
        L9:
            r106 = Integer.valueOf(r110.readInt());
            goto L11
        L5:
            r103 = IMMessage.CREATOR.createFromParcel(r110);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final DMTaskInfo[] newArray(int r100) {
            return new DMTaskInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DMTaskInfo copy$default(DMTaskInfo r100, String r101, int r102, IMMessage r103, long r104, Integer r110, Map r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L6;
        r101 = r100.taskId;
    L6:
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.taskType;
    L8:
        int r114 = r102;
        if ((r112 & 4) == 0) goto L11;
        r103 = r100.message;
    L11:
        IMMessage r105 = r103;
        if ((r112 & 8) == 0) goto L14;
        r104 = r100.createdTime;
    L14:
        long r106 = r104;
        if ((r112 & 16) == 0) goto L17;
        r110 = r100.progress;
    L17:
        Integer r107 = r110;
        if ((r112 & 32) == 0) goto L20;
        r111 = r100.ext;
    L20:
        String r108 = r101;
        return r100.copy(r108, r114, r105, r106, r107, r111);
    }

    public final String component1() {
        return this.taskId;
    }

    public final int component2() {
        return this.taskType;
    }

    public final IMMessage component3() {
        return this.message;
    }

    public final long component4() {
        return this.createdTime;
    }

    public final Integer component5() {
        return this.progress;
    }

    public final Map<String, String> component6() {
        return this.ext;
    }

    public final DMTaskInfo copy(String r110, int r111, IMMessage r112, long r113, Integer r114, Map<String, String> r115) {
        Intrinsics.checkNotNullParameter(r110, DBDefinition.TASK_ID);
        return new DMTaskInfo(r110, r111, r112, r113, r114, r115);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DMTaskInfo) == true) goto L8;
        return false;
    L8:
        DMTaskInfo r101 = (DMTaskInfo) r100;
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L12;
        return false;
    L12:
        if (this.taskType == r101.taskType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L18;
        return false;
    L18:
        if (this.createdTime == r101.createdTime) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.progress, r101.progress) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.taskId.hashCode() * 31) + this.taskType) * 31;
        IMMessage r101 = this.message;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        long r104 = this.createdTime;
        int r105 = (((r100 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        Integer r106 = this.progress;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        Map<String, String> r109 = this.ext;
        if (r109 == null) goto L15;
        r102 = r109.hashCode();
    L15:
        return r108 + r102;
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "DMTaskInfo(taskId=" + this.taskId + ", taskType=" + this.taskType + ", message=" + this.message + ", createdTime=" + this.createdTime + ", progress=" + this.progress + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.taskId);
        r100.writeInt(this.taskType);
        IMMessage r102 = this.message;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeLong(this.createdTime);
        Integer r103 = this.progress;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        Map<String, String> r104 = this.ext;
        if (r104 != null) goto L13;
        r100.writeInt(0);
        return;
    L13:
        r100.writeInt(1);
        r100.writeInt(r104.size());
        Iterator<Map.Entry<String, String>> r105 = r104.entrySet().iterator();
    L15:
        if (r105.hasNext() == false) goto L19;
        Map.Entry<String, String> r106 = r105.next();
        r100.writeString(r106.getKey());
        r100.writeString(r106.getValue());
        goto L15
    L19:
        return;
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        goto L10
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
        goto L6
    }

    public final long getCreatedTime() {
        return this.createdTime;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final IMMessage getMessage() {
        return this.message;
    }

    public final Integer getProgress() {
        return this.progress;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final int getTaskType() {
        return this.taskType;
    }

    public DMTaskInfo(String r100, int r101, IMMessage r102, long r103, Integer r104, Map<String, String> r105) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        this.taskId = r100;
        this.taskType = r101;
        this.message = r102;
        this.createdTime = r103;
        this.progress = r104;
        this.ext = r105;
    }

    public /* synthetic */ DMTaskInfo(String r110, int r111, IMMessage r112, long r113, Integer r114, Map r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 4) == 0) goto L5;
        IMMessage r100 = null;
    L7:
        if ((r116 & 16) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r116 & 32) == 0) goto L13;
        Map r102 = null;
    L14:
        this(r110, r111, r100, r113, r101, r102);
        return;
    L13:
        r102 = r115;
        goto L14
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
