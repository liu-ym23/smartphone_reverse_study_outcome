package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\u0017\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rHÆ\u0003Jo\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rHÆ\u0001J\t\u0010$\u001a\u00020\u000bHÖ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u000bHÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000bHÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001f\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u00060"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/EventTaskExecutionDetailRecord;", "Landroid/os/Parcelable;", "id", "", "sessionId", "", "execTime", "packageName", "appName", "detailText", "detailType", "", "ext", "", "(JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;)V", "getAppName", "()Ljava/lang/String;", "getDetailText", "getDetailType", "()I", "getExecTime", "()J", "getExt", "()Ljava/util/Map;", "getId", "getPackageName", "getSessionId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EventTaskExecutionDetailRecord implements Parcelable {
    public static final Parcelable.Creator<EventTaskExecutionDetailRecord> CREATOR = null;
    private final String appName;
    private final String detailText;
    private final int detailType;
    private final long execTime;
    private final Map<String, String> ext;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f396874id;
    private final String packageName;
    private final String sessionId;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<EventTaskExecutionDetailRecord> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final EventTaskExecutionDetailRecord createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            long r101 = r110.readLong();
            String r102 = r110.readString();
            long r103 = r110.readLong();
            String r104 = r110.readString();
            String r111 = r110.readString();
            String r112 = r110.readString();
            int r113 = r110.readInt();
            if (r110.readInt() != 0) goto L5;
            LinkedHashMap r114 = null;
        L9:
            EventTaskExecutionDetailRecord r105 = new EventTaskExecutionDetailRecord(r101, r102, r103, r104, r111, r112, r113, r114);
            int r106 = Math.min(r100, 0);
            ClassLoader r107 = a.class.getClassLoader();
            int r108 = 1;
        L10:
            if (r108 > r106) goto L12;
            r108 = r108 + 1;
        L12:
            if (r108 > r100) goto L14;
            joa.a.d(r110, r107);
            r108 = r108 + 1;
            goto L12
        L14:
            return r105;
        L5:
            int r109 = r110.readInt();
            LinkedHashMap r115 = new LinkedHashMap(r109);
            int r116 = 0;
        L6:
            if (r116 == r109) goto L8;
            r115.put(r110.readString(), r110.readString());
            r116 = r116 + 1;
            goto L6
        L8:
            r114 = r115;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final EventTaskExecutionDetailRecord[] newArray(int r100) {
            return new EventTaskExecutionDetailRecord[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public EventTaskExecutionDetailRecord(long r100, String r101, long r102, String r103, String r104, String r105, int r106, Map<String, String> r110) {
        this.f396874id = r100;
        this.sessionId = r101;
        this.execTime = r102;
        this.packageName = r103;
        this.appName = r104;
        this.detailText = r105;
        this.detailType = r106;
        this.ext = r110;
    }

    public /* synthetic */ EventTaskExecutionDetailRecord(long r110, String r111, long r112, String r113, String r210, String r211, int r212, Map r213, int r214, DefaultConstructorMarker r215) {
        if ((r214 & 1) == 0) goto L5;
        long r100 = 0;
    L6:
        this(r100, r111, r112, r113, r210, r211, r212, r213);
        return;
    L5:
        r100 = r110;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventTaskExecutionDetailRecord copy$default(EventTaskExecutionDetailRecord r110, long r111, String r112, long r113, String r114, String r115, String r116, int r210, Map r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        long r100 = r110.f396874id;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.sessionId;
    L11:
        if ((r212 & 4) == 0) goto L13;
        long r102 = r110.execTime;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.packageName;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.appName;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.detailText;
    L27:
        if ((r212 & 64) == 0) goto L29;
        int r117 = r110.detailType;
    L31:
        if ((r212 & 128) == 0) goto L33;
        Map r106 = r110.ext;
    L35:
        return r110.copy(r100, r101, r102, r103, r104, r105, r117, r106);
    L33:
        r106 = r211;
        goto L35
    L29:
        r117 = r210;
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

    public final long component1() {
        return this.f396874id;
    }

    public final String component2() {
        return this.sessionId;
    }

    public final long component3() {
        return this.execTime;
    }

    public final String component4() {
        return this.packageName;
    }

    public final String component5() {
        return this.appName;
    }

    public final String component6() {
        return this.detailText;
    }

    public final int component7() {
        return this.detailType;
    }

    public final Map<String, String> component8() {
        return this.ext;
    }

    public final EventTaskExecutionDetailRecord copy(long r110, String r111, long r112, String r113, String r114, String r210, int r211, Map<String, String> r212) {
        return new EventTaskExecutionDetailRecord(r110, r111, r112, r113, r114, r210, r211, r212);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EventTaskExecutionDetailRecord) == true) goto L8;
        return false;
    L8:
        EventTaskExecutionDetailRecord r101 = (EventTaskExecutionDetailRecord) r100;
        if (this.f396874id == r101.f396874id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sessionId, r101.sessionId) == true) goto L15;
        return false;
    L15:
        if (this.execTime == r101.execTime) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.packageName, r101.packageName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.appName, r101.appName) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.detailText, r101.detailText) == true) goto L27;
        return false;
    L27:
        if (this.detailType == r101.detailType) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getDetailText() {
        return this.detailText;
    }

    public final int getDetailType() {
        return this.detailType;
    }

    public final long getExecTime() {
        return this.execTime;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final long getId() {
        return this.f396874id;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        long r100 = this.f396874id;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.sessionId;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        long r105 = this.execTime;
        int r106 = (((r101 + r104) * 31) + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        String r107 = this.packageName;
        if (r107 != null) goto L9;
        int r108 = 0;
    L10:
        int r109 = (r106 + r108) * 31;
        String r110 = this.appName;
        if (r110 != null) goto L13;
        int r111 = 0;
    L14:
        int r112 = (r109 + r111) * 31;
        String r113 = this.detailText;
        if (r113 != null) goto L17;
        int r114 = 0;
    L18:
        int r115 = (((r112 + r114) * 31) + this.detailType) * 31;
        Map<String, String> r116 = this.ext;
        if (r116 == null) goto L23;
        r103 = r116.hashCode();
    L23:
        return r115 + r103;
    L17:
        r114 = r113.hashCode();
        goto L18
    L13:
        r111 = r110.hashCode();
        goto L14
    L9:
        r108 = r107.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public String toString() {
        return "EventTaskExecutionDetailRecord(id=" + this.f396874id + ", sessionId=" + this.sessionId + ", execTime=" + this.execTime + ", packageName=" + this.packageName + ", appName=" + this.appName + ", detailText=" + this.detailText + ", detailType=" + this.detailType + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeLong(this.f396874id);
        r100.writeString(this.sessionId);
        r100.writeLong(this.execTime);
        r100.writeString(this.packageName);
        r100.writeString(this.appName);
        r100.writeString(this.detailText);
        r100.writeInt(this.detailType);
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
