package com.obric.memorydata.sdk.screencapture.event;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u0012\u0010\u0013\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0082\u0001\u0004 !\"#¨\u0006$"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", "Landroid/os/Parcelable;", "<init>", "()V", "eventTime", "", "getEventTime", "()J", "setEventTime", "(J)V", "packageName", "", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "appName", "getAppName", "setAppName", "eventType", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "getEventType", "()Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "describeContents", "EventType", "CREATOR", "Lcom/obric/memorydata/sdk/screencapture/event/AppAccessibilityEvent;", "Lcom/obric/memorydata/sdk/screencapture/event/AppStateEvent;", "Lcom/obric/memorydata/sdk/screencapture/event/InputMethodEvent;", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ScreenEvent implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f397236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f397237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f397238c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "", "<init>", "(Ljava/lang/String;I)V", "TOUCH", "INPUT_METHOD", "APP_STATE", "ACCESSIBILITY", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum EventType extends Enum<EventType> {
        public static final EventType ACCESSIBILITY = null;
        public static final EventType APP_STATE = null;
        public static final EventType INPUT_METHOD = null;
        public static final EventType TOUCH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EventType[] f397239a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f397240b = null;

        public static EnumEntries<EventType> getEntries() {
            return f397240b;
        }

        static {
            EventType r100 = new EventType("TOUCH", 0);
            TOUCH = r100;
            EventType r101 = new EventType("INPUT_METHOD", 1);
            INPUT_METHOD = r101;
            EventType r102 = new EventType("APP_STATE", 2);
            APP_STATE = r102;
            EventType r103 = new EventType("ACCESSIBILITY", 3);
            ACCESSIBILITY = r103;
            EventType[] r104 = {r100, r101, r102, r103};
            f397239a = r104;
            f397240b = EnumEntriesKt.enumEntries(r104);
        }

        public static EventType[] values() {
            return (EventType[]) f397239a.clone();
        }

        public static EventType valueOf(String r100) {
            return (EventType) r27.a.a(EventType.class, r100);
        }

        public EventType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements Parcelable.Creator<ScreenEvent> {

        /* JADX INFO: renamed from: com.obric.memorydata.sdk.screencapture.event.ScreenEvent$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: classes33.dex */
        public /* synthetic */ class C4655a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f397241a = null;

            static {
                int[] r100 = new int[EventType.values().length];
                r100[EventType.TOUCH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r100[EventType.INPUT_METHOD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r100[EventType.APP_STATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r100[EventType.ACCESSIBILITY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                f397241a = r100;
            }
        }

        public a() {
        }

        public static ScreenEvent a(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            Intrinsics.checkNotNull(r101);
            EventType r102 = EventType.valueOf(r101);
            long r103 = r100.readLong();
            String r104 = r100.readString();
            Intrinsics.checkNotNull(r104);
            String r105 = r100.readString();
            Intrinsics.checkNotNull(r105);
            int r106 = C4655a.f397241a[r102.ordinal()];
            if (r106 != 1) goto L5;
            ScreenEvent r107 = new ScreenTouchEvent(r100);
        L16:
            r107.f397236a = r103;
            Intrinsics.checkNotNullParameter(r104, "<set-?>");
            r107.f397237b = r104;
            Intrinsics.checkNotNullParameter(r105, "<set-?>");
            r107.f397238c = r105;
            return r107;
        L5:
            if (r106 != 2) goto L7;
            r107 = new InputMethodEvent(r100);
            goto L16
        L7:
            if (r106 != 3) goto L9;
            r107 = new AppStateEvent(r100);
            goto L16
        L9:
            if (r106 != 4) goto L12;
            r107 = new AppAccessibilityEvent(r100);
            goto L16
        L12:
            throw new NoWhenBranchMatchedException();
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ScreenEvent createFromParcel(Parcel r100) {
            return a(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ScreenEvent[] newArray(int r100) {
            return new ScreenEvent[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public abstract EventType a();

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ScreenEvent() {
        this.f397236a = System.currentTimeMillis();
        this.f397237b = "";
        this.f397238c = "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(a().name());
        r100.writeLong(this.f397236a);
        r100.writeString(this.f397237b);
        r100.writeString(this.f397238c);
    }
}
