package com.obric.sva.sdk.utils;

import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.obric.sva.sdk.session.SessionType;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 52\u00020\u0001:\u00015BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u001b\u001a\u00020\bH\u0016J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u0005J\u0006\u0010\u001f\u001a\u00020\bJ\u0006\u0010 \u001a\u00020\u001dJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\fHÆ\u0003JK\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0006\u0010*\u001a\u00020\u0005J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0005HÖ\u0001J\u0016\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010!\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0019¨\u00066"}, d2 = {"Lcom/obric/sva/sdk/utils/DetectionEventContainer;", "Landroid/os/Parcelable;", InteractConst.WAKEUP_SESSION_TYPE, "Lcom/obric/sva/sdk/session/SessionType;", "eventType", "", "sessionId", "smFullName", "", "audioStream", "Landroid/os/ParcelFileDescriptor;", "trackerData", "Landroid/os/Bundle;", "<init>", "(Lcom/obric/sva/sdk/session/SessionType;IILjava/lang/String;Landroid/os/ParcelFileDescriptor;Landroid/os/Bundle;)V", "getSessionType", "()Lcom/obric/sva/sdk/session/SessionType;", "getEventType", "()I", "getSessionId", "getSmFullName", "()Ljava/lang/String;", "getAudioStream", "()Landroid/os/ParcelFileDescriptor;", "getTrackerData", "()Landroid/os/Bundle;", "TAG", "toString", "getStage2EndTime", "", "getScreenState", "getOneshotKeyword", "getOneshotOffset", "trackerBundle", "getTrackerBundle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DetectionEventContainer implements Parcelable {
    public static final Parcelable.Creator<DetectionEventContainer> CREATOR = null;
    public static final Companion Companion = null;
    private final String TAG;
    private final ParcelFileDescriptor audioStream;
    private final int eventType;
    private final int sessionId;
    private final SessionType sessionType;
    private final String smFullName;
    private final Bundle trackerData;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H\u0007¨\u0006\t"}, d2 = {"Lcom/obric/sva/sdk/utils/DetectionEventContainer$Companion;", "", "<init>", "()V", "mapToBundle", "Landroid/os/Bundle;", "data", "", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final Bundle mapToBundle(Map<String, ? extends Object> r100) {
            Bundle r101 = new Bundle();
            if (r100 == null) goto L25;
            Iterator<Map.Entry<String, ? extends Object>> r102 = r100.entrySet().iterator();
        L6:
            if (r102.hasNext() == false) goto L25;
            Map.Entry<String, ? extends Object> r103 = r102.next();
            String r104 = r103.getKey();
            Object r105 = r103.getValue();
            if ((r105 instanceof Integer) == true) goto L9;
            if ((r105 instanceof Long) == true) goto L12;
            if ((r105 instanceof String) == true) goto L15;
            if ((r105 instanceof Boolean) == true) goto L18;
            if ((r105 instanceof Float) == true) goto L21;
            if ((r105 instanceof Double) == false) goto L6;
            r101.putDouble(r104, ((Number) r105).doubleValue());
            goto L6
        L21:
            r101.putFloat(r104, ((Number) r105).floatValue());
            goto L6
        L18:
            r101.putBoolean(r104, ((Boolean) r105).booleanValue());
            goto L6
        L15:
            r101.putString(r104, (String) r105);
            goto L6
        L12:
            r101.putLong(r104, ((Number) r105).longValue());
            goto L6
        L9:
            r101.putInt(r104, ((Number) r105).intValue());
        L25:
            return r101;
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DetectionEventContainer> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DetectionEventContainer createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new DetectionEventContainer(SessionType.valueOf(r100.readString()), r100.readInt(), r100.readInt(), r100.readString(), (ParcelFileDescriptor) r100.readParcelable(DetectionEventContainer.class.getClassLoader()), r100.readBundle(DetectionEventContainer.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DetectionEventContainer createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DetectionEventContainer[] newArray(int r100) {
            return new DetectionEventContainer[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DetectionEventContainer[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        Companion = new Companion(null);
        CREATOR = new Creator();
    }

    public static /* synthetic */ DetectionEventContainer copy$default(DetectionEventContainer r100, SessionType r101, int r102, int r103, String r104, ParcelFileDescriptor r105, Bundle r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.sessionType;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.eventType;
    L8:
        int r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.sessionId;
    L11:
        int r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.smFullName;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.audioStream;
    L17:
        ParcelFileDescriptor r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.trackerData;
    L20:
        SessionType r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    @JvmStatic
    public static final Bundle mapToBundle(Map<String, ? extends Object> r100) {
        return Companion.mapToBundle(r100);
    }

    public final SessionType component1() {
        return this.sessionType;
    }

    public final int component2() {
        return this.eventType;
    }

    public final int component3() {
        return this.sessionId;
    }

    public final String component4() {
        return this.smFullName;
    }

    public final ParcelFileDescriptor component5() {
        return this.audioStream;
    }

    public final Bundle component6() {
        return this.trackerData;
    }

    public final DetectionEventContainer copy(SessionType r100, int r110, int r111, String r112, ParcelFileDescriptor r113, Bundle r114) {
        Intrinsics.checkNotNullParameter(r100, InteractConst.WAKEUP_SESSION_TYPE);
        return new DetectionEventContainer(r100, r110, r111, r112, r113, r114);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DetectionEventContainer) == true) goto L8;
        return false;
    L8:
        DetectionEventContainer r101 = (DetectionEventContainer) r100;
        if (this.sessionType == r101.sessionType) goto L12;
        return false;
    L12:
        if (this.eventType == r101.eventType) goto L15;
        return false;
    L15:
        if (this.sessionId == r101.sessionId) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.smFullName, r101.smFullName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.audioStream, r101.audioStream) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.trackerData, r101.trackerData) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.sessionType.hashCode() * 31) + this.eventType) * 31) + this.sessionId) * 31;
        String r101 = this.smFullName;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        ParcelFileDescriptor r105 = this.audioStream;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Bundle r108 = this.trackerData;
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

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.sessionType.name());
        r100.writeInt(this.eventType);
        r100.writeInt(this.sessionId);
        r100.writeString(this.smFullName);
        r100.writeParcelable(this.audioStream, r101);
        r100.writeBundle(this.trackerData);
    }

    public final String getOneshotKeyword() {
        Bundle r100 = this.trackerData;
        Object r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getString(TrackerConstant.TRACKER_EVENT_ONESHOT_PARAMS);
    L7:
        if (r102 != null) goto L22;
        return "";
    L22:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        Object r104 = Result.m9449constructorimpl(new JSONObject(r102).optString(TrackerConstant.TRACKER_EVENT_ONESHOT_WAKEUP_WORDS));     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r104) == true) goto L17;
        r101 = r104;
    L17:
        String r105 = (String) r101;
        if (r105 != null) goto L21;
        return "";
    L21:
        return r105;
    L11:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L5:
        r102 = null;
        goto L7
    }

    public final long getOneshotOffset() {
        Bundle r100 = this.trackerData;
        Object r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getString(TrackerConstant.TRACKER_EVENT_ONESHOT_PARAMS);
    L7:
        if (r102 != null) goto L21;
        return 0;
    L21:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        Object r104 = Result.m9449constructorimpl(Long.valueOf(new JSONObject(r102).optLong(TrackerConstant.TRACKER_EVENT_ONESHOT_OFFSET_TIME)));     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r104) == true) goto L17;
        r101 = r104;
    L17:
        Long r105 = (Long) r101;
        if (r105 != null) goto L20;
        return 0;
    L20:
        return r105.longValue();
    L11:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L5:
        r102 = null;
        goto L7
    }

    public final int getScreenState() {
        Bundle r100 = this.trackerData;
        if (r100 == null) goto L5;
        String r101 = r100.getString(TrackerConstant.TRACKER_EVENT_WAKEUP_STAGE2_SCREEN_STATE);
    L7:
        if (Intrinsics.areEqual(r101, "1") == false) goto L10;
        return 1;
    L10:
        if (Intrinsics.areEqual(r101, "2") == false) goto L13;
        return 2;
    L13:
        return 1;
    L5:
        r101 = null;
        goto L7
    }

    public final long getStage2EndTime() {
        Bundle r100 = this.trackerData;
        if (r100 == null) goto L6;
        return r100.getLong(TrackerConstant.TRACKER_INTERNAL_STAGE2_RAW_END_TIME, System.currentTimeMillis());
    L6:
        return System.currentTimeMillis();
    }

    public String toString() {
        return "DetectionEventContainer{TAG='" + this.TAG + "', mEventType=" + this.eventType + ", mSessionId=" + this.sessionId + ", mSmFullName='" + this.smFullName + ", audioStream=" + this.audioStream + ", mTrackerData = " + this.trackerData + '}';
    }

    public final ParcelFileDescriptor getAudioStream() {
        return this.audioStream;
    }

    public final int getEventType() {
        return this.eventType;
    }

    public final int getSessionId() {
        return this.sessionId;
    }

    public final SessionType getSessionType() {
        return this.sessionType;
    }

    public final String getSmFullName() {
        return this.smFullName;
    }

    public final Bundle getTrackerBundle() {
        return this.trackerData;
    }

    public final Bundle getTrackerData() {
        return this.trackerData;
    }

    public DetectionEventContainer(SessionType r100, int r101, int r102, String r103, ParcelFileDescriptor r104, Bundle r105) {
        Intrinsics.checkNotNullParameter(r100, InteractConst.WAKEUP_SESSION_TYPE);
        this.sessionType = r100;
        this.eventType = r101;
        this.sessionId = r102;
        this.smFullName = r103;
        this.audioStream = r104;
        this.trackerData = r105;
        this.TAG = "DetectionEventContainer";
    }

    public /* synthetic */ DetectionEventContainer(SessionType r100, int r101, int r102, String r110, ParcelFileDescriptor r111, Bundle r112, int r113, DefaultConstructorMarker r114) {
        int r103 = 0;
        if ((r113 & 2) == 0) goto L5;
        int r104 = 0;
    L7:
        if ((r113 & 4) != 0) goto L10;
        r103 = r102;
    L10:
        Bundle r105 = null;
        if ((r113 & 8) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r113 & 16) == 0) goto L17;
        ParcelFileDescriptor r107 = null;
    L19:
        if ((r113 & 32) != 0) goto L22;
        r105 = r112;
    L22:
        this(r100, r104, r103, r106, r107, r105);
        return;
    L17:
        r107 = r111;
        goto L19
    L13:
        r106 = r110;
        goto L15
    L5:
        r104 = r101;
        goto L7
    }
}
