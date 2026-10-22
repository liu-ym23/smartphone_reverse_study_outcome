package com.obric.eventkit.eventstaskmanager;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zja.a;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 *2\u00020\u0001:\u0001*B\u001f\b\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\b\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0015J\b\u0010&\u001a\u00020\u0003H\u0016J\u0018\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020!H\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0007R(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\u001a\u0010\u001a\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007\u0082\u0001\u0002+,¨\u0006-"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/AppEvent;", "Landroid/os/Parcelable;", "id", "", "content", "(Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "<set-?>", "", "createTime", "getCreateTime", "()J", "eventType", "getEventType", "extra", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getExtra", "()Ljava/util/concurrent/ConcurrentHashMap;", "setExtra", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "getId", "setId", "lastModifiedTime", "getLastModifiedTime", "setLastModifiedTime", "(J)V", "source", "getSource", "describeContents", "", "readFromParcel", "", "parcel", "Landroid/os/Parcel;", "toString", "writeToParcel", "dest", "flags", "CREATOR", "Lcom/obric/eventkit/eventstaskmanager/ActiveAgentEvent;", "Lcom/obric/eventkit/eventstaskmanager/NotificationEvent;", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class AppEvent implements Parcelable {
    public static final CREATOR CREATOR = null;
    private String content;
    private long createTime;
    private final String eventType;
    private ConcurrentHashMap<String, Object> extra;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f396868id;
    private long lastModifiedTime;
    private String source;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J#\u0010\u0004\u001a\u0004\u0018\u0001H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/AppEvent$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/eventkit/eventstaskmanager/AppEvent;", "()V", "createAppEventFromParcel", ExifInterface.GPS_DIRECTION_TRUE, "source", "Landroid/os/Parcel;", "createAppEventFromParcel$eventstaskkit_release", "(Landroid/os/Parcel;)Lcom/obric/eventkit/eventstaskmanager/AppEvent;", "createFromParcel", "newArray", "", "size", "", "(I)[Lcom/obric/eventkit/eventstaskmanager/AppEvent;", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<AppEvent> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        public final <T extends AppEvent> T createAppEventFromParcel$eventstaskkit_release(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            T r101 = (T) EventTypeKt.newInstanceByEventType(r100.readString());
            if (r101 == null) goto L5;
            r101.readFromParcel(r100);
            return r101;
        L5:
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppEvent createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            return createAppEventFromParcel$eventstaskkit_release(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppEvent createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppEvent[] newArray(int r100) {
            return new AppEvent[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppEvent[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public /* synthetic */ AppEvent(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        DefaultConstructorMarker r104 = null;
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101, r104);
    }

    public /* synthetic */ AppEvent(String r100, String r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getEventType() {
        return this.eventType;
    }

    public final ConcurrentHashMap<String, Object> getExtra() {
        return this.extra;
    }

    public final String getId() {
        return this.f396868id;
    }

    public final long getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public final String getSource() {
        return this.source;
    }

    public void readFromParcel(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this.f396868id = r100.readString();
        this.content = r100.readString();
        this.createTime = r100.readLong();
        this.lastModifiedTime = r100.readLong();
        String r101 = r100.readString();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this.source = r101;
        Serializable r102 = r100.readSerializable();
        if ((r102 instanceof ConcurrentHashMap) == false) goto L8;
        ConcurrentHashMap<String, Object> r103 = (ConcurrentHashMap) r102;
    L9:
        this.extra = r103;
        return;
    L8:
        r103 = null;
        goto L9
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setExtra(ConcurrentHashMap<String, Object> r100) {
        this.extra = r100;
    }

    public final void setId(String r100) {
        this.f396868id = r100;
    }

    public final void setLastModifiedTime(long r100) {
        this.lastModifiedTime = r100;
    }

    public String toString() {
        return "AppEvent(id=" + this.f396868id + ", content=" + this.content + ", extra=" + this.extra + ", createTime=" + this.createTime + ", lastModifiedTime=" + this.lastModifiedTime + ", source='" + this.source + "', eventType='" + this.eventType + "')";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.eventType);
        r100.writeString(this.f396868id);
        r100.writeString(this.content);
        r100.writeLong(this.createTime);
        r100.writeLong(this.lastModifiedTime);
        r100.writeString(this.source);
        r100.writeSerializable(this.extra);
    }

    private AppEvent(String r100, String r101) {
        this.f396868id = r100;
        this.content = r101;
        long r102 = System.currentTimeMillis();
        this.createTime = r102;
        this.lastModifiedTime = r102;
        Context r103 = a.f572550a;
        String r104 = a.f572551b;
        if (r104 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("packageName");
        r104 = null;
    L6:
        this.source = r104;
        this.eventType = EventTypeKt.b(this);
    }
}
