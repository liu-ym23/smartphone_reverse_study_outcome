package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u0017\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fHÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0081\u0001\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fHÆ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0005HÖ\u0001J\t\u00100\u001a\u00020\bHÖ\u0001J\u0019\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u00066"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/EventTaskExecutionRecord;", "Landroid/os/Parcelable;", "id", "", "taskType", "", "taskMode", DBDefinition.TASK_ID, "", "query", "triggerTime", "duration", "resultCode", "resultMessage", "ext", "", "(JIILjava/lang/String;Ljava/lang/String;JJILjava/lang/String;Ljava/util/Map;)V", "getDuration", "()J", "getExt", "()Ljava/util/Map;", "getId", "getQuery", "()Ljava/lang/String;", "getResultCode", "()I", "getResultMessage", "getTaskId", "getTaskMode", "getTaskType", "getTriggerTime", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EventTaskExecutionRecord implements Parcelable {
    public static final Parcelable.Creator<EventTaskExecutionRecord> CREATOR = null;
    private final long duration;
    private final Map<String, String> ext;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f396875id;
    private final String query;
    private final int resultCode;
    private final String resultMessage;
    private final String taskId;
    private final int taskMode;
    private final int taskType;
    private final long triggerTime;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<EventTaskExecutionRecord> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final EventTaskExecutionRecord createFromParcel(Parcel r210) {
            int r100 = r210.readInt();
            Intrinsics.checkNotNullParameter(r210, "parcel");
            long r101 = r210.readLong();
            int r102 = r210.readInt();
            int r103 = r210.readInt();
            String r104 = r210.readString();
            String r105 = r210.readString();
            long r110 = r210.readLong();
            long r111 = r210.readLong();
            int r112 = r210.readInt();
            String r113 = r210.readString();
            if (r210.readInt() != 0) goto L5;
            LinkedHashMap r106 = null;
            int r114 = r100;
        L9:
            EventTaskExecutionRecord r107 = new EventTaskExecutionRecord(r101, r102, r103, r104, r105, r110, r111, r112, r113, r106);
            int r108 = r114;
            int r109 = Math.min(r108, 0);
            ClassLoader r115 = a.class.getClassLoader();
            int r116 = 1;
        L10:
            if (r116 > r109) goto L12;
            r116 = r116 + 1;
        L12:
            if (r116 > r108) goto L14;
            joa.a.d(r210, r115);
            r116 = r116 + 1;
            goto L12
        L14:
            return r107;
        L5:
            int r117 = r210.readInt();
            LinkedHashMap r118 = new LinkedHashMap(r117);
            int r119 = 0;
        L6:
            if (r119 == r117) goto L8;
            int r120 = r117;
            int r121 = r100;
            r118.put(r210.readString(), r210.readString());
            r119 = r119 + 1;
            r117 = r120;
            r100 = r121;
            goto L6
        L8:
            r114 = r100;
            r106 = r118;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final EventTaskExecutionRecord[] newArray(int r100) {
            return new EventTaskExecutionRecord[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public EventTaskExecutionRecord(long r100, int r101, int r102, String r103, String r104, long r105, long r106, int r110, String r111, Map<String, String> r112) {
        this.f396875id = r100;
        this.taskType = r101;
        this.taskMode = r102;
        this.taskId = r103;
        this.query = r104;
        this.triggerTime = r105;
        this.duration = r106;
        this.resultCode = r110;
        this.resultMessage = r111;
        this.ext = r112;
    }

    public /* synthetic */ EventTaskExecutionRecord(long r110, int r111, int r210, String r211, String r212, long r213, long r214, int r215, String r216, Map r217, int r310, DefaultConstructorMarker r311) {
        if ((r310 & 1) == 0) goto L5;
        long r100 = 0;
    L6:
        this(r100, r111, r210, r211, r212, r213, r214, r215, r216, r217);
        return;
    L5:
        r100 = r110;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventTaskExecutionRecord copy$default(EventTaskExecutionRecord r110, long r111, int r112, int r113, String r114, String r210, long r211, long r212, int r213, String r214, Map r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        long r100 = r110.f396875id;
    L7:
        if ((r216 & 2) == 0) goto L9;
        int r101 = r110.taskType;
    L11:
        if ((r216 & 4) == 0) goto L13;
        int r102 = r110.taskMode;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r103 = r110.taskId;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r104 = r110.query;
    L23:
        if ((r216 & 32) == 0) goto L25;
        long r105 = r110.triggerTime;
    L27:
        if ((r216 & 64) == 0) goto L29;
        long r115 = r110.duration;
    L31:
        if ((r216 & 128) == 0) goto L33;
        int r116 = r110.resultCode;
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r117 = r110.resultMessage;
    L39:
        if ((r216 & 512) == 0) goto L41;
        Map r106 = r110.ext;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r115, r116, r117, r106);
    L41:
        r106 = r215;
        goto L43
    L37:
        r117 = r214;
        goto L39
    L33:
        r116 = r213;
        goto L35
    L29:
        r115 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
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

    public final long component1() {
        return this.f396875id;
    }

    public final Map<String, String> component10() {
        return this.ext;
    }

    public final int component2() {
        return this.taskType;
    }

    public final int component3() {
        return this.taskMode;
    }

    public final String component4() {
        return this.taskId;
    }

    public final String component5() {
        return this.query;
    }

    public final long component6() {
        return this.triggerTime;
    }

    public final long component7() {
        return this.duration;
    }

    public final int component8() {
        return this.resultCode;
    }

    public final String component9() {
        return this.resultMessage;
    }

    public final EventTaskExecutionRecord copy(long r110, int r111, int r112, String r210, String r211, long r212, long r213, int r214, String r215, Map<String, String> r216) {
        return new EventTaskExecutionRecord(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EventTaskExecutionRecord) == true) goto L8;
        return false;
    L8:
        EventTaskExecutionRecord r101 = (EventTaskExecutionRecord) r100;
        if (this.f396875id == r101.f396875id) goto L12;
        return false;
    L12:
        if (this.taskType == r101.taskType) goto L15;
        return false;
    L15:
        if (this.taskMode == r101.taskMode) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.query, r101.query) == true) goto L24;
        return false;
    L24:
        if (this.triggerTime == r101.triggerTime) goto L27;
        return false;
    L27:
        if (this.duration == r101.duration) goto L30;
        return false;
    L30:
        if (this.resultCode == r101.resultCode) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.resultMessage, r101.resultMessage) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final long getId() {
        return this.f396875id;
    }

    public final String getQuery() {
        return this.query;
    }

    public final int getResultCode() {
        return this.resultCode;
    }

    public final String getResultMessage() {
        return this.resultMessage;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final int getTaskMode() {
        return this.taskMode;
    }

    public final int getTaskType() {
        return this.taskType;
    }

    public final long getTriggerTime() {
        return this.triggerTime;
    }

    public int hashCode() {
        long r100 = this.f396875id;
        int r101 = ((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.taskType) * 31) + this.taskMode) * 31;
        String r102 = this.taskId;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.query;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        long r108 = this.triggerTime;
        int r109 = (((r105 + r107) * 31) + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.duration;
        int r111 = (((r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31) + this.resultCode) * 31;
        String r112 = this.resultMessage;
        if (r112 != null) goto L13;
        int r113 = 0;
    L14:
        int r114 = (r111 + r113) * 31;
        Map<String, String> r115 = this.ext;
        if (r115 == null) goto L19;
        r103 = r115.hashCode();
    L19:
        return r114 + r103;
    L13:
        r113 = r112.hashCode();
        goto L14
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public String toString() {
        return "EventTaskExecutionRecord(id=" + this.f396875id + ", taskType=" + this.taskType + ", taskMode=" + this.taskMode + ", taskId=" + this.taskId + ", query=" + this.query + ", triggerTime=" + this.triggerTime + ", duration=" + this.duration + ", resultCode=" + this.resultCode + ", resultMessage=" + this.resultMessage + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeLong(this.f396875id);
        r100.writeInt(this.taskType);
        r100.writeInt(this.taskMode);
        r100.writeString(this.taskId);
        r100.writeString(this.query);
        r100.writeLong(this.triggerTime);
        r100.writeLong(this.duration);
        r100.writeInt(this.resultCode);
        r100.writeString(this.resultMessage);
        Map<String, String> r102 = this.ext;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        Map.Entry<String, String> r104 = r103.next();
        r100.writeString(r104.getKey());
        r100.writeString(r104.getValue());
        goto L7
    }
}
