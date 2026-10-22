package com.obric.memorydata.sdk.screencapture.event;

import android.os.Parcel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/event/AppStateEvent;", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", "state", "Lcom/obric/memorydata/sdk/screencapture/event/AppStateEvent$AppState;", "<init>", "(Lcom/obric/memorydata/sdk/screencapture/event/AppStateEvent$AppState;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getState", "()Lcom/obric/memorydata/sdk/screencapture/event/AppStateEvent$AppState;", "eventType", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "getEventType", "()Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "writeToParcel", "", "flags", "", "toString", "", "component1", "copy", "equals", "", "other", "", "hashCode", "AppState", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppStateEvent extends ScreenEvent {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppState f397230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ScreenEvent.EventType f397231e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/event/AppStateEvent$AppState;", "", "<init>", "(Ljava/lang/String;I)V", "OPEN", "CLOSE", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum AppState extends Enum<AppState> {
        public static final AppState CLOSE = null;
        public static final AppState OPEN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AppState[] f397232a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f397233b = null;

        public static EnumEntries<AppState> getEntries() {
            return f397233b;
        }

        static {
            AppState r100 = new AppState("OPEN", 0);
            OPEN = r100;
            AppState r101 = new AppState("CLOSE", 1);
            CLOSE = r101;
            AppState[] r102 = {r100, r101};
            f397232a = r102;
            f397233b = EnumEntriesKt.enumEntries(r102);
        }

        public static AppState[] values() {
            return (AppState[]) f397232a.clone();
        }

        public static AppState valueOf(String r100) {
            return (AppState) a.a(AppState.class, r100);
        }

        public AppState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AppStateEvent) == true) goto L9;
        return false;
    L9:
        if (this.f397230d == ((AppStateEvent) r100).f397230d) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f397230d.hashCode();
    }

    public final String toString() {
        return "AppStateEvent(state=" + this.f397230d.name() + ", appName=" + this.f397238c + ", pkgName=" + this.f397237b + ')';
    }

    @Override // com.obric.memorydata.sdk.screencapture.event.ScreenEvent
    public final ScreenEvent.EventType a() {
        return this.f397231e;
    }

    public AppStateEvent(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        AppState r101 = AppState.values()[r100.readInt()];
        Intrinsics.checkNotNullParameter(r101, "state");
        this.f397230d = r101;
        this.f397231e = ScreenEvent.EventType.APP_STATE;
    }

    @Override // com.obric.memorydata.sdk.screencapture.event.ScreenEvent, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        super.writeToParcel(r100, r101);
        r100.writeInt(this.f397230d.ordinal());
    }
}
