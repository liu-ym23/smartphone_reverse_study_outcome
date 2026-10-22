package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B1\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0014J\b\u0010\u000b\u001a\u00020\nH\u0016R*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/NotificationEvent;", "Lcom/obric/eventkit/eventstaskmanager/AppEvent;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "parcel", "readFromParcel", "", "toString", "", "Lcom/obric/eventkit/eventstaskmanager/AppNotification;", "notifications", "[Lcom/obric/eventkit/eventstaskmanager/AppNotification;", "getNotifications", "()[Lcom/obric/eventkit/eventstaskmanager/AppNotification;", "setNotifications", "([Lcom/obric/eventkit/eventstaskmanager/AppNotification;)V", "id", "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;[Lcom/obric/eventkit/eventstaskmanager/AppNotification;)V", "CREATOR", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class NotificationEvent extends AppEvent {
    public static final a CREATOR = null;
    private static final int VERSION = 0;
    private AppNotification[] notifications;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<NotificationEvent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final NotificationEvent createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            return (NotificationEvent) AppEvent.CREATOR.createAppEventFromParcel$eventstaskkit_release(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final NotificationEvent[] newArray(int r100) {
            return new NotificationEvent[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public NotificationEvent() {
        this(null, null, null, 7, null);
    }

    public NotificationEvent(String r100, String r101, AppNotification[] r102) {
        super(r100, r101, null);
        this.notifications = r102;
    }

    public /* synthetic */ NotificationEvent(String r100, String r101, AppNotification[] r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }

    public final AppNotification[] getNotifications() {
        return this.notifications;
    }

    @Override // com.obric.eventkit.eventstaskmanager.AppEvent
    public void readFromParcel(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        super.readFromParcel(r100);
        int r101 = r100.readInt();
        if (r101 <= 0) goto L10;
        AppNotification[] r102 = new AppNotification[r101];
        int r103 = 0;
    L5:
        if (r103 >= r101) goto L7;
        Parcelable r104 = r100.readParcelable(AppNotification.class.getClassLoader());
        Intrinsics.checkNotNull(r104);
        r102[r103] = (AppNotification) r104;
        r103 = r103 + 1;
        goto L5
    L7:
        this.notifications = r102;
        return;
    }

    public final void setNotifications(AppNotification[] r100) {
        this.notifications = r100;
    }

    @Override // com.obric.eventkit.eventstaskmanager.AppEvent
    public String toString() {
        return "NotificationEvent(id=" + getId() + ", content=" + getContent() + ", extra=" + getExtra() + ", createTime=" + getCreateTime() + ", lastModifiedTime=" + getLastModifiedTime() + ", source='" + getSource() + "', eventType='" + getEventType() + "', notifications='" + this.notifications + "')";
    }

    @Override // com.obric.eventkit.eventstaskmanager.AppEvent, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        super.writeToParcel(r100, r101);
        AppNotification[] r102 = this.notifications;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.length;
    L6:
        r100.writeInt(r104);
        AppNotification[] r105 = this.notifications;
        if (r105 == null) goto L11;
        int r106 = r105.length;
    L9:
        if (r103 >= r106) goto L13;
        r100.writeParcelable(r105[r103], r101);
        r103 = r103 + 1;
        goto L9
    L13:
        return;
    L11:
        return;
    L5:
        r104 = 0;
        goto L6
    }
}
